package database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import database.io.DatabaseInputStream;
import database.io.DatabaseOutputStream;
import database.io.Writable;

/**
 * A single named entry in a {@link Database}. Contains information
 * about each column and the data for each row in the Relation.
 */
public class Relation implements Writable, DatabaseIterable<Tuple>{
	
	private final ArrayList<Attribute> columns;
	protected final ArrayList<Tuple> data;
	private int readIndex = 0;
	
	/**
	 * Constructs a new empty Relation with the specified column information.
	 * @param columns The attribute list for this Relation.
	 */
	public Relation(ArrayList<Attribute> columns){
		
		this.columns = columns;
		data = new ArrayList<>();
	}
	
	/**
	 * Reads a Relation from the specified InputStream.
	 * @param in The {@link DatabaseInputStream} to be read from.
	 * @throws IOException If there is an error reading from the specified
	 * stream.
	 */
	protected Relation(DatabaseInputStream in) throws IOException{

		if(!in.readIdentifier().equals("CREATE"))
			throw new IOException("Input mismatch while reading relation");
		if(in.readChar() != ' ')
			throw new IOException("Input mismatch while reading relation");
		
		if(!in.readIdentifier().equals("TABLE"))
			throw new IOException("Input mismatch while reading relation");
		if(in.readChar() != ' ')
			throw new IOException("Input mismatch while reading relation");
		
		in.readIdentifier();
		if(in.readChar() != ' ')
			throw new IOException("Input mismatch while reading relation");
		
		ArrayList<Attribute> attributes = in.readList(s -> new Attribute(s));
		if(in.readChar() != ' ')
			throw new IOException("Input mismatch while reading relation");
		
		if(!in.readIdentifier().equals("PRIMARY"))
			throw new IOException("Input mismatch while reading relation");
		if(in.readChar() != ' ')
			throw new IOException("Input mismatch while reading relation");
		
		if(!in.readIdentifier().equals("KEY"))
			throw new IOException("Input mismatch while reading relation");
		if(in.readChar() != ' ')
			throw new IOException("Input mismatch while reading relation");
		
		ArrayList<String> primaryKeys = in.readList(s -> s.readIdentifier());
		if(in.readChar() != '\n')
			throw new IOException("Input mismatch while reading relation");
		
		columns = new ArrayList<>(attributes.size());
		for(Attribute a: attributes){
			if(primaryKeys.contains(a.name))
				columns.add(new Attribute(a.name, a.type, a.size, true));
			else
				columns.add(a);
		}
		
		data = new ArrayList<Tuple>();
		while(!in.eof()){
			
			readIndex = 0;
			if(!in.readIdentifier().equals("INSERT"))
				throw new IOException("Input mismatch while reading relation");
			if(in.readChar() != ' ')
				throw new IOException("Input mismatch while reading relation");
			
			if(!in.readIdentifier().equals("INTO"))
				throw new IOException("Input mismatch while reading relation");
			if(in.readChar() != ' ')
				throw new IOException("Input mismatch while reading relation");
			
			in.readIdentifier();
			in.readChar();
			
			if(!in.readIdentifier().equals("VALUES"))
				throw new IOException("Input mismatch while reading relation");
			if(in.readChar() != ' ')
				throw new IOException("Input mismatch while reading relation");
			
			if(!in.readIdentifier().equals("FROM"))
				throw new IOException("Input mismatch while reading relation");
			if(in.readChar() != ' ')
				throw new IOException("Input mismatch while reading relation");
			
			try{
				addTuple(in.readList(this::readLiteral));
			}catch(DatabaseException e){
				throw new IOException("Error loading relation", e);
			}
			
			if(in.readChar() != '\n')
				throw new IOException("Input mismatch while reading relation");
		}
	}
	
	private Literal readLiteral(DatabaseInputStream in) throws IOException{
		
		return new Literal(in, columns.get(readIndex++).type);
	}
	
	/**
	 * Adds a new row of data with the specified values to this Relation.
	 * @param values The values of the row to be added.
	 * @throws DatabaseException If the values do not match the format in
	 * this Relation's attribute list.
	 */
	public void addTuple(ArrayList<Literal> values) throws DatabaseException{
		
		data.add(new Tuple(columns, values));
		
		for(int i = 0; i < columns.size(); ++i)
			columns.get(i).indexLast(i, data);
	}
	
	/**
	 * Adds new rows of data with the specified values to this Relation.
	 * @param values The values of the rows to be added.
	 * @throws DatabaseException If the values do not match the format in
	 * this Relation's attribute list.
	 */
	public void addTuples(ArrayList<Literal> values) throws DatabaseException{
		
		if(values.size()%columns.size() != 0)
			throw new DatabaseException("Invalid size of literal list.");
		
		ArrayList<Literal> row = new ArrayList<Literal>(columns.size());
		for(int i = 0; i < values.size(); ++i){
			row.add(values.get(i));
			if(row.size() == columns.size()){
				addTuple(row);
				row = new ArrayList<>(columns.size());
			}
		}
	}
	
	/**
	 * Adds new rows of data from the specified relation.
	 * @param relation The Relation whose values should be added.
	 * @throws DatabaseException If the values do not match the format in
	 * this Relation's attribute list.
	 */
	public void addTuples(Relation relation) throws DatabaseException{
		
		if(relation.columns.size() != columns.size())
			throw new DatabaseException("Relations have different number of attributes.");
		
		for(int i = 0; i < columns.size(); ++i)
			if(!columns.get(i).isCompatibleWith(relation.columns.get(i)))
				throw new DatabaseException("Attribute '" + relation.columns.get(i).name + "' in specifed relation is incompatible with attribute '" + columns.get(i).name + "'");
	
		for(Tuple tuple: relation)
			addTuple(tuple.values);
	}
	
	/**
	 * Parses an array of Strings into literals then adds the literals as a Tuple to this Relation.
	 * @param values The strings to be parsed.
	 * @throws DatabaseException If there is an error parsing the Strings, the String array's length
	 * does not match the number of columns, or the String array does not match the expected format
	 * as specified by this Relation's Attribute List.
	 */
	public void addTuple(String... values) throws DatabaseException{
		
		if(values.length != columns.size())
			throw new DatabaseException("Tried to add tuple of invalid length");
		
		ArrayList<Literal> literals = new ArrayList<Literal>(values.length);
		for(int i = 0; i < values.length; ++i)
			literals.add(new Literal(values[i], columns.get(i).type));
		
		addTuple(literals);
	}
	
	
	/**
	 * Deletes a specified Tuple from this Relation.
	 * @param tuple The tuple to delete.
	 * @throws DatabaseException If the Tuple cannot be found in this Relaiton.
	 */
	public void deleteTuple(Tuple tuple) throws DatabaseException{
		
		for(int i = 0; i < data.size(); ++i){
			
			if(data.get(i).equals(tuple)){

				data.remove(i);
				for(Attribute a: columns)
					a.removeIndex(i);
				return;
			}			
		}
		
		throw new DatabaseException("Tuple could not be found");
	}
	

	@Override
	public int size(){
		
		return data.size();
	}

	@Override
	public Tuple get(int i) {

		return data.get(i);
	}

	@Override
	public void delete(int i) {
		
		data.remove(i);
		for(Attribute a: columns)
			a.removeIndex(i);
	}
	
	@Override
	public void forAll(DatabaseConsumer<Tuple> consumer) throws DatabaseException{
		
		for(Tuple tuple: data)
			consumer.accept(tuple);
	}
	
	
	public void forEach(DatabasePredicate predicate, DatabaseConsumer<Tuple> consumer) throws DatabaseException{
		
		for(Tuple t: data)
			if(predicate.test(t).getValue())
				consumer.accept(t);
	}
	
	/**
	 * Finds a Tuple in this Relation by searching the specified column for
	 * the specified value. If multiple tuples with this value exist, the
	 * first appearance is returned.
	 * @param by The name of the column to search.
	 * @param value The value to search for.
	 * @return The first tuple with the specified value in the specified column.
	 * @throws DatabaseException If the column with the specified name does not
	 * exist or no values with the specified value exist in that column.
	 */
	public Tuple lookup(String by, Literal value) throws DatabaseException{
		
		return getAttributeByName(by).find(value, data);
	}
	
	/**
	 * Finds a Tuple in this Relation by parsing toParse into a Literal and
	 * then searching the specified Attribute for the first instance of that
	 * Literal.
	 * @param by The name of the Attribute to search.
	 * @param toParse The Literal value to be parsed then searched for.
	 * @return The first tuple with the specified value in the specified column.
	 * @throws DatabaseException If the column with the specified name does not
	 * exist or no values with the specified value exist in that column, or
	 * parsing of the Literal value fails.
	 */
	public Tuple lookup(String by, String toParse) throws DatabaseException{
		
		Attribute attribute = getAttributeByName(by);
		Literal value = new Literal(toParse, attribute.type);
		return attribute.find(value, data);
	}
	
	/**
	 * Finds all Tuples in this Relation with the specified value in the specified
	 * column.
	 * @param by The name of the column to search.
	 * @param value The value to search for.
	 * @return A Relation containing all Tuples with the value 'value' in the column
	 * 'by'.
	 * @throws DatabaseException If the column with the specified name does not
	 * exist.
	 */
	public Relation lookupAll(String by, Literal value) throws DatabaseException{
		
		Relation relation = new Relation(copyColumns(columns));
		getAttributeByName(by).findAll(value, data, relation);
		return relation;
	}
	
	/**
	 * Finds all Tuples in this Relation by parsing toParse into a Literal and
	 * then searching the specified Attribute for the first instance of that
	 * Literal.
	 * @param by The name of the column to search.
	 * @param toParse The Literal value to be parsed then searched for.
	 * @return A Relation containing all Tuples with the value 'value' in the column
	 * 'by'.
	 * @throws DatabaseException If the column with the specified name does not
	 * exist, or there is an error parsing the Literal.
	 */
	public Relation lookupAll(String by, String toParse) throws DatabaseException{
		
		Attribute attribute = getAttributeByName(by);
		Literal value = new Literal(toParse, attribute.type);
		Relation relation = new Relation(copyColumns(columns));
		attribute.findAll(value, data, relation);
		return relation;
	}
	
	/**
	 * Finds all Tuples in this Relation matching the specified predicate.
	 * @param predicate The predicate to test each tuple against.
	 * @return A Relation containing all Tuples passing the test of the
	 * specified predicate.
	 * @throws DatabaseException If an error is encountered while testing a tuple.
	 */
	public Relation lookupAll(DatabasePredicate predicate) throws DatabaseException{
		
		Relation relation = new Relation(copyColumns(columns));
		for(Tuple tuple: data)
			if(predicate.test(tuple).getValue())
				relation.addTuple(tuple.getValues());
		
		return relation;
	}
	
	/**
	 * Determines whether or not this Relation contains the specified Tuple.
	 * @param tuple The Tuple to check for.
	 * @return True if this Relation contains the specified Tuple.
	 * @throws DatabaseException If the Tuple does not match the format
	 * of this Relation.
	 */
	public boolean contains(Tuple tuple) throws DatabaseException{
		
		if(tuple.size() != columns.size())
			return false;
		
		for(int i = 0; i < tuple.size(); ++i)
			if(tuple.get(i).type != columns.get(i).type)
				return false;
		
		String searchColumn = columns.get(0).name;
		Literal searchValue = tuple.get(0);
		for(int i = 0; i < columns.size(); ++i){
			if(columns.get(i).isPrimary){
				
				searchColumn = columns.get(i).name;
				searchValue = tuple.get(i);
				break;
			}
		}
		
		Relation subset = lookupAll(searchColumn, searchValue);
		for(Tuple t: subset)
			if(t.equals(tuple))
				return true;
		
		return false;
	}
	
	/**
	 * Projects this Relation onto the specified names.
	 * @param names The attribute names to project onto.
	 * @return A new Relation formed by projecting this relation onto the
	 * specified names. The new Relation is completely independent of this
	 * Relation.
	 * @throws DatabaseException If one of the specified names doesn't exist.
	 */
	public Relation project(ArrayList<String> names) throws DatabaseException{
		
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		for(Attribute a: columns)
			if(names.contains(a.name))
				attributes.add(a.copy());
		
		Relation rel = new Relation(attributes);
		forAll(t -> rel.addTuple(t.getValues(names)));
		return rel;
	}
	
	/**
	 * Unions this Relation with the specified Relation.
	 * @param relation The relation to union with.
	 * @return A new Relation formed by performing the union. The new Relation will be
	 * completely independent of this Relation. Non distinct elements will be purged.
	 * @throws DatabaseException If the Relations are not of compatible types.
	 */
	public Relation union(Relation relation) throws DatabaseException{
		
		if(columns.size() != relation.columns.size())
			throw new DatabaseException("Relations are of incompatible size");
		
		final Relation toReturn;
		if(isCompatibleWith(relation))
			toReturn = new Relation(copyColumns(columns));
		else if(relation.isCompatibleWith(this))
			toReturn = new Relation(copyColumns(relation.columns));
		else
			throw new DatabaseException("Relations are of incompatible types");

		forAll(t -> {if(!toReturn.contains(t)) toReturn.addTuple(t.getValues());});
		relation.forAll(t -> {if(!toReturn.contains(t)) toReturn.addTuple(t.getValues());});
		
		return toReturn;
	}
	
	/**
	 * Performs a difference on this Relation with the specified Relation.
	 * @param relation The Relation to perform the difference with.
	 * @return A new Relation formed by performing the difference between this
	 * Relation and the specified Relation. The new Relation will be
	 * completely independent of this Relation.
	 * @throws DatabaseException If the Relations are of incompatible types.
	 */
	public Relation difference(Relation relation) throws DatabaseException{
		
		if(columns.size() != relation.columns.size())
			throw new DatabaseException("Relations are of incompatible size");
		
		final Relation toReturn;
		if(isCompatibleWith(relation))
			toReturn = new Relation(copyColumns(columns));
		else if(relation.isCompatibleWith(this))
			toReturn = new Relation(copyColumns(relation.columns));
		else
			throw new DatabaseException("Relations are of incompatible types");
		
		forAll(t -> {if(!relation.contains(t) && !toReturn.contains(t)) toReturn.addTuple(t.getValues());});
		
		return toReturn;
	}
	
	/**
	 * Performs a Cartesian product on this Relation and the specified Relation.
	 * @param relation The relation to perform the product with.
	 * @return A new Relation representing the Cartesian product of this Relation
	 * and the specified Relation. The new Relation will be
	 * completely independent of this Relation.
	 * @throws DatabaseException If there is an error performing the product.
	 */
	public Relation product(Relation relation) throws DatabaseException{
		
		ArrayList<Attribute> attributes = copyColumns(columns);
		attributes.addAll(copyColumns(relation.columns));
		
		final Relation toReturn = new Relation(attributes);
		
		forAll(t1 -> relation.forAll(t2 -> toReturn.addTuple(t1.cross(t2))));
		
		return toReturn;
	}
	
	/**
	 * Joins this Relation with the specified Relation about the common attributes.
	 * @param relation The Relation to join with.
	 * @return A new Relation that is the result of performing a natural join on
	 * this Relation with the specified Relation. The new Relation will be
	 * completely independent of this Relation.
	 * @throws DatabaseException If there is an error performing the natural
	 * join.
	 */
	public Relation naturalJoin(Relation relation) throws DatabaseException{
		
		HashMap<Integer, Integer> joins = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < columns.size(); ++i){
			for(int j = 0; j < relation.columns.size(); ++j){
				
				Attribute a1 = columns.get(i);
				Attribute a2 = relation.columns.get(j);
				
				if(a1.name.equals(a2.name) && a1.type == a2.type && a1.size == a2.size)
					joins.put(i, j);
			}
		}

		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
		attributes.addAll(copyColumns(columns));
		for(int i = 0; i < relation.columns.size(); ++i){
			if(joins.values().contains(i))
				continue;
			attributes.add(relation.columns.get(i).copy());
		}
		
		Relation toReturn = new Relation(attributes);
		
		forAll(t -> {
			
			Relation temp = relation;
			Relation next = new Relation(copyColumns(temp.columns));
			
			for(int i: joins.keySet()){
				
				int j = joins.get(i);
				temp.columns.get(j).findAll(t.get(i), temp.data, next);
				temp = next;
				next = new Relation(copyColumns(temp.columns));
			}
			
			temp.forAll(t2 -> {
				ArrayList<Literal> values = new ArrayList<Literal>();
				values.addAll(t.getValues());
				for(int i = 0; i < relation.columns.size(); ++i){
					if(joins.values().contains(i))
						continue;
					values.add(t2.get(i));
				}
				toReturn.addTuple(values);
			});
		});
		
		return toReturn;
	}
	
	/**
	 * Creates a new Relation by renaming this Relations attribute names to the
	 * specified names.
	 * @param newNames The new names of the attributes.
	 * @return A new Relation formed by renaming the attributes of this Relation.
	 * @throws DatabaseException If the list of names is incompatible with this
	 * Relation's attribute list.
	 */
	public Relation rename(ArrayList<String> newNames) throws DatabaseException{
		
		if(newNames.size() != columns.size())
			throw new DatabaseException("Error renaming attributes, names list did not match length of columns");
		
		ArrayList<Attribute> attributes = new ArrayList<>();
		for(int i = 0; i < columns.size(); ++i){
			
			Attribute a = columns.get(i);
			attributes.add(new Attribute(newNames.get(i), a.type, a.size, a.isPrimary));
		}
		
		Relation relation = new Relation(attributes);
		forAll(t -> relation.addTuple(t.getValues()));
		
		return relation;
	}
	
	/**
	 * Gets an Attribute by searching the attribute list for the specified name.
	 * @param name The name of the column to retrieve.
	 * @return The Attribute with the specified name.
	 * @throws DatabaseException If the column does not exist.
	 */
	public Attribute getAttributeByName(String name) throws DatabaseException{
		
		for(Attribute a: columns)
			if(a.name.equals(name))
				return a;
		
		throw new DatabaseException("Tried to lookup non-existant column");
	}
	
	/**
	 * Helper function for getting the index of an attribute from an attribute list by name.
	 * @param name The name of the attribute to find.
	 * @param columns The attribute list.
	 * @return The index of the attribute with the specified name in columns.
	 * @throws DatabaseException If the attribute can not be found.
	 */
	protected static int getAttributeIndex(String name, ArrayList<Attribute> columns) throws DatabaseException{
		
		for(int i = 0; i < columns.size(); ++i)
			if(columns.get(i).name.equals(name))
				return i;
		
		throw new DatabaseException("Tried to lookup non-existant column");
	}
	
	/**
	 * Returns true if this relation's Attributes are compatible with the
	 * specified relation's Tuples. This relationship may be one-way if
	 * a Relation has a VARCHAR or other variable length field. For example,
	 * a Relation with a VARCHAR(10) is not compatible with the Tuples in a
	 * Relation with a VARCHAR(20), however the VARCHAR(20) Relation is compatible
	 * with Tuples from a VARCHAR(10) Relation.
	 * @param relation The relation to test.
	 * @return True if this Relation is compatible with Tuples in the specified
	 * Relation.
	 */
	private boolean isCompatibleWith(Relation relation){
		
		for(int i = 0; i < columns.size(); ++i)
			if(!columns.get(i).isCompatibleWith(relation.columns.get(i)))
				return false;
		
		return true;
	}
	
	/**
	 * Creates a deep copy of this relation, used for creating temporary
	 * views from existing relations.
	 * @return A deep copy of this relation.
	 */
	public Relation copy(){
		
		Relation relation = new Relation(copyColumns(columns));
		for(Tuple t: data){
			try {
				relation.addTuple(t.getValues());
			} catch (DatabaseException e){
				e.printStackTrace();	//Should never happen
			}
		}
		
		return relation;
	}
	
	/**
	 * Performs a deep copy on an attribute list, used for producing new
	 * Relations from existing Attribute lists.
	 * @param columns The Attribute list to copy.
	 * @return A deep copy of the specified Attribute list.
	 */
	private static ArrayList<Attribute> copyColumns(ArrayList<Attribute> columns){
		
		ArrayList<Attribute> copy = new ArrayList<>();
		for(Attribute a: columns)
			copy.add(a.copy());
		
		return copy;
	}
	
	@Override
	public void write(DatabaseOutputStream out) throws IOException{
		
		out.writeIdentifier("CREATE TABLE relation ");
		out.writeList(columns);
		out.writeIdentifier(" PRIMARY KEY ");
		
		ArrayList<Writable> primary = new ArrayList<Writable>();
		for(Attribute a: columns)
			if(a.isPrimary)
				primary.add(s -> s.writeIdentifier(a.name));
		
		out.writeList(primary);
		out.writeChar('\n');
		
		for(Tuple t: data){
			out.writeIdentifier("INSERT INTO relation VALUES FROM ");
			out.writeList(t.values);
			out.writeChar('\n');
		}
	}
	
	@Override
	public String toString(){
		
		String toReturn = "";
		for(Attribute a: columns)
			toReturn += a.name + '\t';
		toReturn += '\n';
		
		for(Tuple t: data)
			toReturn += t.toString() + '\n';
		
		return toReturn;
	}
	
	@Override
	public boolean equals(Object obj){
		
		if(obj instanceof Relation){
			Relation r = (Relation) obj;
			return columns.equals(r.columns) && data.equals(r.data);
		}
		
		return false;
	}

	@Override
	public DatabaseIterator<Tuple> iterator() {
		
		return new DatabaseIterator<Tuple>(this);
	}
}
