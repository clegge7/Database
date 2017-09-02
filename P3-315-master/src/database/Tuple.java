package database;

import java.io.IOException;
import java.util.ArrayList;

import database.io.DatabaseOutputStream;
import database.io.Writable;

/**
 * A single row of a {@link Relation} represented by an
 * ArrayList of {@link Literal} values.
 */
public class Tuple implements Writable, DatabaseIterable<Literal>{

	protected final ArrayList<Literal> values;
	protected final ArrayList<Attribute> columns;
	
	/**
	 * Construct an empty tuple using the type data stored in the column data.
	 * @param columns The information about each column in the {@link Relation}.
	 */
	protected Tuple(ArrayList<Attribute> columns){
		
		values = new ArrayList<>();
		this.columns = columns;
		
		for(int i = 0; i < columns.size(); ++i)
			values.add(new Literal(columns.get(i).type));
	}
	
	/**
	 * Construct a tuple of the specified values, checking that they match the format
	 * specified by the data in columns.
	 * @param columns The attribute list of the {@link Relation}
	 * @param values The literal values of this tuple.
	 * @throws DatabaseException If the data in values is not in the same format as
	 * specified by the attribute list.
	 */
	protected Tuple(ArrayList<Attribute> columns, ArrayList<Literal> values) throws DatabaseException{
		
		this.values = values;
		this.columns = columns;
		
		if(columns.size() != values.size())
			throw new DatabaseException("Error creating new tuple, values do not match types in attribute list");
		
		for(int i = 0; i < columns.size(); ++i){
			
			if(values.get(i).isNull()){
				
				values.set(i, new Literal(columns.get(i).type));
				continue;
			}
			
			if(values.get(i).type != columns.get(i).type)
				throw new DatabaseException("Error creating new tuple, values do not match types in attribute list");
			
			if(values.get(i).type == AttributeType.VARCHAR){
				if(values.get(i).getValue() != null && values.get(i).asVarChar().length() > columns.get(i).size)
					throw new DatabaseException("Error creating new tuple, VARCHAR overflow");
			}
		}
	}

	@Override
	public int size(){

		return values.size();
	}

	@Override
	public Literal get(int i){
		
		return values.get(i).copy();
	}

	@Override
	public void delete(int i){
		
		values.get(i).setNull();
	}
	
	/**
	 * Gets all values in this Tuple. The list is a copy and is safe to be modified.
	 * @return A list of all the values in this Tuple.
	 */
	public ArrayList<Literal> getValues(){
		
		ArrayList<Literal> toReturn = new ArrayList<>(values.size());
		for(Literal literal: values)
			toReturn.add(literal);
		
		return toReturn;
	}
	
	/**
	 * Gets the values in this Tuple of the specified. The list is a copy and is safe to be modified.
	 * @return A list of the specified values in this Tuple.
	 */
	public ArrayList<Literal> getValues(ArrayList<String> attributes) throws DatabaseException{
		
		ArrayList<Literal> toReturn = new ArrayList<>(attributes.size());
		for(String name: attributes)
			toReturn.add(get(name));
		
		return toReturn;
	}
	
	/**
	 * Returns an ArrayList formed by combining the values in this Tuple with the values
	 * in the specified Tuple. Used as part of computing the Cartesian product.
	 * @param t The tuple to combine with.
	 * @return The list of Literals in both this Tuple and the specified Tuple.
	 */
	public ArrayList<Literal> cross(Tuple t){
		
		ArrayList<Literal> toReturn = new ArrayList<>();
		toReturn.addAll(getValues());
		toReturn.addAll(t.getValues());
		
		return toReturn;
	}
	
	/**
	 * Gets a literal in this tuple by attribute name.
	 * @param name The name of the attribute.
	 * @return The literal for the specified attribute.
	 * @throws DatabaseException If the specified attribute does not exist.
	 */
	public Literal get(String name) throws DatabaseException{
		
		return values.get(Relation.getAttributeIndex(name, columns)).copy();
	}
	
	/**
	 * Sets a Literal in this Tuple by attribute name.
	 * @param name The name of the attribute.
	 * @param value The new literal.
	 * @throws DatabaseException If the specified attribute does not exist, or if the new literal
	 * does not match the type specified in the attribute list.
	 */	
	public void set(String name, Literal value) throws DatabaseException{
		
		int index = Relation.getAttributeIndex(name, columns);
		
		if(columns.get(index).type != value.type)
			throw new DatabaseException("Error setting value of literal, new value does not match types in attribute list");
		
		if(value.type == AttributeType.VARCHAR && value.asVarChar() != null && value.asVarChar().length() > columns.get(index).size)
			throw new DatabaseException("Error setting value of literal, VARCHAR overflow");
		
		values.set(index, value);
	}
	

	/**
	 * Sets the Literal in this Tuple specified by attribute name to the parsed Literal value of
	 * the specified string.
	 * @param name The name of the Attribute to set.
	 * @param toParse The Literal value to be parsed.
	 * @throws DatabaseException If there is an error parsing the specified string, the specified column
	 * does not exist, or the specified string does not match the type specified in the attribute list.
	 */
	public void set(String name, String toParse) throws DatabaseException {
		
		int index = Relation.getAttributeIndex(name, columns);
		Literal value = new Literal(toParse, columns.get(index).type);
		
		if(value.type == AttributeType.VARCHAR && value.asVarChar() != null && value.asVarChar().length() > columns.get(index).size)
			throw new DatabaseException("Error setting value of literal, VARCHAR overflow");
		
		values.set(index, value);
	}
	
	@Override
	public void forAll(DatabaseConsumer<Literal> consumer) throws DatabaseException{
		
		for(Literal literal: values)
			consumer.accept(literal);
	}

	@Override
	public void write(DatabaseOutputStream out) throws IOException{
		
		out.writeList(values);
	}
	
	@Override
	public String toString(){
		
		String toReturn = "";
		for(Literal l: values)
			toReturn += l.toString() + '\t';
		
		return toReturn;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(obj instanceof Tuple){
			
			Tuple t = (Tuple) obj;
			return this == t || values.equals(t.values);
		}
		
		return false;
	}

	@Override
	public DatabaseIterator<Literal> iterator(){
		
		return new DatabaseIterator<Literal>(this);
	}
}
