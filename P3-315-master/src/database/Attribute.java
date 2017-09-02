package database;

import java.io.IOException;
import java.util.ArrayList;

import database.io.DatabaseInputStream;
import database.io.DatabaseOutputStream;
import database.io.Writable;

/**
 * Contains the name, type, size, and, if this attribute is a primary key, the indices
 * of a given column in a {@link Relation}.
 */
public class Attribute implements Writable{

	public final String name;
	public final AttributeType type;
	public final int size;
	public final boolean isPrimary;
	public final ArrayList<Integer> indices;
	
	/**
	 * Create sized attribute with specified max size.
	 * @param name The name of the attribute.
	 * @param size the max size of the VARCHAR.
	 * @param isPrimary whether or not this attribute is a primary key.
	 */
	public Attribute(String name, AttributeType type, int size, boolean isPrimary){
		
		this.name = name;
		this.type = type;
		this.size = size;
		this.isPrimary = isPrimary;
		
		if(isPrimary)
			indices = new ArrayList<>();
		else
			indices = null;
	}
	
	/**
	 * Create non-sized attribute.
	 * @param name The name of the attribute.
	 * @param isPrimary whether or not this attribute is a primary key.
	 */
	public Attribute(String name, AttributeType type, boolean isPrimary){
		
		this.name = name;
		this.type = type;
		this.size = -1;
		this.isPrimary = isPrimary;

		if(isPrimary)
			indices = new ArrayList<>();
		else
			indices = null;
	}
	
	/**
	 * Load an attribute from a file.
	 * @param in The DatabaseInputStream object used to read from a file.
	 * @throws IOException If there is an error reading from the file, or the data does not match an Attribute.
	 */
	protected Attribute(DatabaseInputStream in) throws IOException{
		
		this.name = in.readIdentifier();
		
		if(in.readChar() != ' ')
			throw new IOException("Input mismatch while trying to read attribute");
		
		this.type = AttributeType.valueOf(in.readIdentifier());
		if(in.peekChar() == '('){
			
			in.readChar();
			
			this.size = in.readInt();
			
			if(in.readChar() != ')')
				throw new IOException("Input mismatch while trying to read attribute");
		}
		else{
			size = -1;
		}
		
		isPrimary = false;
		indices = null;
	}
	
	/**
	 * Indexes the last element in the Relation's data by this column.
	 * This is used whenever a new element is inserted into a relation
	 * and it needs to be indexed in all of its primary attributes.
	 * @param columnIndex The index of this column in the Relation
	 * @param data The data in the Relation, the last element of which
	 * has yet to be indexed.
	 */
	protected void indexLast(int columnIndex, ArrayList<Tuple> data){
		
		if(!isPrimary)
			return;
		
		Literal val = data.get(indices.size()).values.get(columnIndex);
		int min = 0;
		int max = indices.size();
		int test = (max+min)/2;
		
		while(max != min){
			
			if(test == 0){
				if(val.compareTo(data.get(indices.get(0)).values.get(columnIndex)) > 0)
					test = 1;
				break;
			}
			
			if(val.compareTo(data.get(indices.get(test)).values.get(columnIndex)) > 0){
				min = test+1;
				test = (min+max)/2;
				continue;
			}
			
			if(val.compareTo(data.get(indices.get(test-1)).values.get(columnIndex)) < 0){
				max = test-1;
				test = (min+max)/2;
				continue;
			}
			
			break;
		}
		
		indices.add(test, indices.size());
	}
	
	/**
	 * Removes an index from the list of indices and adjusts.
	 * @param index The index that should be removed.
	 */
	protected void removeIndex(int index){
		
		if(!isPrimary)
			return;
		
		indices.remove((Object)index);
		for(int i = 0; i < indices.size(); ++i){
			
			int current = indices.get(i);
			if(current > index)
				indices.set(i, current-1);
		}
	}
	
	/**
	 * Private helper method for binary searching the data by this attribute's indices.
	 * @param value The value to search for.
	 * @param columnIndex The index of this attribute.
	 * @param data The data to search.
	 * @return The index of an occurrence of value in data.
	 */
	private int search(Literal value, int columnIndex, ArrayList<Tuple> data){
		
		int min = 0;
		int max = data.size()-1;
		int test = (max+min)/2;
		
		if(max == -1)
			return -1;
		
		while(max > min){
			
			int compare = value.compareTo(data.get(indices.get(test)).values.get(columnIndex));
			if(compare > 0){
				
				min = test+1;
				test = (min+max)/2;
				continue;
			}
			
			if(compare < 0){
				
				max = test-1;
				test = (min+max)/2;
				continue;
			}
			
			break;
		}
		
		if(value.equals(data.get(indices.get(test)).values.get(columnIndex)))
			return test;
		
		return -1;
	}
	
	/**
	 * Finds the first Tuple in this Attribute's indexed list with the specified value.
	 * @param value The value to find.
	 * @param columnIndex The index of this column.
	 * @param data The data to search.
	 * @return The first occurrence of value in data, indexed by this attribute.
	 * @throws DatabaseException If the value does not exist in data.
	 */
	protected Tuple find(Literal value, ArrayList<Tuple> data) throws DatabaseException{
		
		if(data.isEmpty())
			throw new DatabaseException("Tried to find nonexistant value '" + value + "'");
		
		int columnIndex;
		try{
			columnIndex = Relation.getAttributeIndex(name, data.get(0).columns);
		} catch (DatabaseException e){
			//Theoretically should never happen.
			throw new DatabaseException("Tried to find nonexistant value '" + value + "'");
		}
		
		if(!isPrimary){
			
			for(Tuple tuple: data){				
				if(tuple.values.get(columnIndex).equals(value))
					return tuple;
			}
			
			throw new DatabaseException("Tried to find nonexistant value '" + value + "'");
		}
		
		int index = search(value, columnIndex, data);
		if(index == -1)
			throw new DatabaseException("Tried to find nonexistant value '" + value + "'");
		
		while(index > 0 && value.equals(data.get(indices.get(index-1)).values.get(columnIndex)))
			--index;

		return data.get(indices.get(index));
	}
	
	/**
	 * Finds all of the occurrences of value in data and stores them in a Relation.
	 * @param value The value to search for.
	 * @param data The data to be searched.
	 * @param relation The Relation to store the results in.
	 * @throws DatabaseException If the specified relation is incompatible with Tuples
	 * from the specified data.
	 */
	protected void findAll(Literal value, ArrayList<Tuple> data, Relation relation) throws DatabaseException{
		
		if(data.isEmpty())
			return;
		
		int columnIndex;
		try{
			columnIndex = Relation.getAttributeIndex(name, data.get(0).columns);
		} catch (DatabaseException e){
			//Theoretically should never happen.
			return;
		}
		
		if(!isPrimary){
			
			for(Tuple tuple: data){				
				if(tuple.values.get(columnIndex).equals(value))
					relation.addTuple(tuple.getValues());
			}
			
			return;
		}
		
		int index = search(value, columnIndex, data);
		if(index == -1)
			return;
		
		int length = 1;
		while(index > 0 && value.equals(data.get(indices.get(index-1)).values.get(columnIndex))){
			--index;
			++length;
		}
		
		while(index+length < indices.size() && value.equals(data.get(indices.get(index+length)).values.get(columnIndex)))
			++length;
		
		for(int i = index; i < index+length; ++i)
			relation.addTuple(data.get(indices.get(i)).getValues());
		
		return;
	}
	
	/**
	 * Creates a copy of this attribute, ignoring the indices.
	 * @return A new attribute that has the same name, size, type, and primary values
	 * as this object.
	 */
	protected Attribute copy(){
		
		return new Attribute(name, type, size, isPrimary);
	}

	@Override
	public void write(DatabaseOutputStream out) throws IOException {
		
		out.writeIdentifier(name);
		out.writeChar(' ');
		out.writeIdentifier(type.name());
		
		if(size != -1){
			out.writeChar('(');
			out.writeInt(size);
			out.writeChar(')');
		}
	}
	
	/**
	 * Checks if this Attribute is compatible with Literals of the specified Attribute. Used for
	 * combining relations like in the {@link Relation#union(Relation)} method.
	 * @param a The Attribute to test.
	 * @return True if this Attribute is compatible with Literals of the specified Attribute.
	 */
	public boolean isCompatibleWith(Attribute a){
		
		return type == a.type && size >= a.size;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(obj instanceof Attribute){
			Attribute a = (Attribute) obj;
			return name.equals(a.name) && type == a.type && size == a.size && isPrimary == a.isPrimary && indices.equals(a.indices);
		}
		
		return false;
	}
}
