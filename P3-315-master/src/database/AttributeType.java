package database;

import java.io.IOException;

import database.io.DatabaseInputStream;
import database.io.DatabaseOutputStream;
import database.io.LiteralReader;
import database.io.LiteralWriter;

/**
 * Enumerated type used for designating the different types of literals in this database.
 * Each type has functional interfaces for reading, writing, parsing and comparing their designated
 * literals.
 */
public enum AttributeType {
	
	VARCHAR(v -> v, in -> in.readString(), (out, val) -> out.writeString((String) val), (val1, val2) -> ((String)val1).compareTo((String)val2)),
	INTEGER(v -> Integer.parseInt(v), in -> in.readInt(), (out, val) -> out.writeInt((Integer) val), (val1, val2) -> ((Integer)val1).compareTo((Integer)val2));

	private final LiteralParser parser;
	private final LiteralReader reader;
	private final LiteralWriter writer;
	private final LiteralComparator comparator;
	
	
	private AttributeType(LiteralParser parser, LiteralReader reader, LiteralWriter writer, LiteralComparator comparator){
		
		this.parser = parser;
		this.reader = reader;
		this.writer = writer;
		this.comparator = comparator;
	}
	
	/**
	 * Parses a literal's raw value from the specified String
	 * using this AttributeType's {@link LiteralParser}.
	 * @param in The String to be parsed.
	 * @return The raw value of the literal parsed from the specified String.
	 * @throws DatabaseException If there is an error parsing the specified String.
	 */
	public Object parseLiteral(String toParse) throws DatabaseException{
		
		try{
			return parser.parse(toParse);
		}catch(Throwable t){
			throw new DatabaseException("Failed to parse literal '" + toParse + "' as type " + name(), t);
		}
	}
	
	/**
	 * Reads a literal's raw value from the specified InputStream
	 * using this AttributeType's {@link LiteralReader}.
	 * @param in The {@link DatabaseInputStream} to be read.
	 * @return The raw value of the literal read from the specified stream.
	 * @throws IOException If there is an error reading from the specified stream.
	 */
	public Object readLiteral(DatabaseInputStream in) throws IOException{
		
		return reader.read(in);
	}
	
	/**
	 * Writes the specified raw value of a literal to the specified OutputStream
	 * using this AttributeType's {@link LiteralWriter}.
	 * @param out The {@link DatabaseOutputStream} to be written to.
	 * @param literal The raw value to be written to the stream.
	 * @throws IOException If there is an error writing to the specified stream.
	 */
	public void writeLiteral(DatabaseOutputStream out, Object literal) throws IOException{
		
		writer.write(out, literal);
	}
	
	/**
	 * Compares the raw values of the two specified literal values using this
	 *  AttributeType's {@link LiteralComparator}.
	 * @param literal1 The first literal to be compared.
	 * @param literal The second literal to be compared.
	 * @return -1 if literal1 < literal2, 0 if literal1 = literal2, 1 if literal1 > litearl2.
	 */
	public int compareLiterals(Object literal1, Object literal2){
		
		return comparator.compare(literal1, literal2);
	}
	
	/**
	 * Parses the AttributeType from a Type name as specified in the DBMS grammar.
	 * If the name contains a parenthesis, everything before the parenthesis is used.
	 * If the name does not contain a parenthesis, the entire length of the string is used.
	 * @param name The string to parse.
	 * @return The AttributeType represented by the specified String.
	 */
	public static AttributeType fromName(String name){

		int index = name.indexOf('(');
		if(index == -1)
			return valueOf(name);
		
		return valueOf(name.substring(0, index));
	}
}
