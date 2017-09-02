package database.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * A utility class for reading the values of the various literals and data structures
 * used by this database from a wrapped InputStream.
 */
public class DatabaseInputStream implements AutoCloseable{

	private final InputStream in;
	private int index = 0;
	private int length = 0;
	private final byte[] buffer = new byte[8192];
	
	/**
	 * Constructs a DatabaseInputStream by wrapping the specified InputStream. 
	 * A DatabaseInputStream is used as a utility class for reading the various
	 * literals and data structures associated with this database. A
	 * DatabaseInputStream will buffer its reading so there's no need to wrap
	 * the InputStream in a BufferedInputStream prior to construction.
	 * @param in The InputStream to be wrapped.
	 */
	public DatabaseInputStream(InputStream in){
		this.in = in;
	}
	
	/**
	 * Reads a batch of data from the InputStream. The size of the batch to be read
	 * is the size of this object's buffer, 8192 by default.
	 * @throws IOException If there's an error reading the next batch, or the
	 * end of the stream has been reached.
	 */
	private void readBatch() throws IOException{
		
		length = 0;
		while(length == 0)
			length = in.read(buffer, 0, buffer.length);
		
		index = 0;
	}
	
	/**
	 * Reads a byte of data from the InputStream without consuming it, useful
	 * for testing if the end of an input pattern has been reached. This method
	 * first attempts to read from the buffer, however if the end of the buffer
	 * has been reached, a single byte will be read from the underlying InputStream
	 * then the stream will be rewound by 1 byte.	
	 * @return The next byte in the stream.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream or the end of the stream has been reached
	 */
	private byte peekByte() throws IOException{
		
		if(index < length){
			
			return buffer[index];
		}
		else{
			
			readBatch();
			return buffer[0];
		}
	}
	
	/**
	 * Convenience method for casting output from the {@link #peekByte()} method
	 * into a character.
	 * @return The next byte in this stream, as a character.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream or the end of the stream has been reached
	 */
	public char peekChar() throws IOException{
		
		return (char) (peekByte()&255);
	}
	
	/**
	 * Checks if the end of this stream has been reached.
	 * @return True if no more bytes can be read from this stream.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream
	 */
	public boolean eof() throws IOException{
		
		if(index >= length)
			readBatch();
		
		return length == -1;
	}
	
	/**
	 * Consumes a single byte from the underlying InputStream and returns its
	 * value.
	 * @return The next byte in the stream.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream or the end of the stream has been reached
	 */
	public byte readByte() throws IOException{
		
		if(eof())
			throw new IOException("EOF");
		
		return buffer[index++];
	}
	
	/**
	 * Convenience method for casting the output of {@link #readByte()} method
	 * to a character.
	 * @return The next byte in the stream, as a character.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream or the end of the stream has been reached
	 */
	public char readChar() throws IOException{
		
		return (char)(readByte()&255);
	}
	
	/**
	 * Reads an identifier from the underlying InputStream. An identifier is assumed
	 * to be composed of the pattern [a-zA-Z_][a-zA-Z0-9_]+
	 * @return An identifier read from the stream.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream, the end of the stream has been reached, or the data in the
	 * stream does not match the expected pattern of an identifier.
	 */
	public String readIdentifier() throws IOException{
		
		char c = readChar();
		if(!isAlpha(c))
			throw new IOException("Input mismatch while attempting to read identifier");
		
		StringBuffer identifier = new StringBuffer();
		identifier.append(c);
		while(isValid(c = peekChar())){
			
			identifier.append(c);
			readChar();
		}
		
		return identifier.toString();
	}
	
	/**
	 * Convenience method for checking if a character is in [a-zA-Z_].
	 * @param c The character to check.
	 * @return True is the character matches the pattern.
	 */
	private boolean isAlpha(char c){
		
		if(c >= 65 && c <= 90)
			return true;
		if(c >= 97 && c <= 122)
			return true;
		if(c == 95)
			return true;
		
		return false;
	}
	
	/**
	 * Convenience method for checking if a character is in [a-zA-Z0-9_].
	 * @param c The character to check.
	 * @return True is the character matches the pattern.
	 */
	private boolean isValid(char c){
		
		return isAlpha(c) || c >= 48 && c <= 57;
	}
	
	/**
	 * Reads a string from the underlying InputStream. A string is assumed to be
	 * surrounded by quotation marks. A backslash is assumed to be an escape
	 * character, removing any special meaning from the subsequent character.
	 * For example "\\" is to be interpreted as a single backslash, and "\"" is
	 * to be interpreted as an embedded quotation mark, ie a quotation mark that
	 * does not represent the end of the string. A value of null is returned if
	 * the string NULL is read.
	 * @return A string read from the stream, or null.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream, the end of the stream has been reached, or the data in the
	 * stream does not match the expected pattern of a string.
	 */
	public String readString() throws IOException{
		
		char c = readChar();
		if(c == 'N'){
			
			if(readChar() == 'U' && readChar() == 'L' && readChar() == 'L')
				return null;
			else
				throw new IOException("Input mismatch while attempting to read string");
		}
		else if(c != '"'){
			
			throw new IOException("Input mismatch while attempting to read string");
		}
		
		StringBuffer temp = new StringBuffer();
		while(true){
			
			c = readChar();
			if(c == '\\')
				temp.append(readChar());
			else if(c == '"')
				break;
			else
				temp.append(c);
		}
		
		return temp.toString();
	}
	
	/**
	 * Reads an integer from the underlying InputStream. An integer is assumed to
	 * be a string representation of the value of the integer in base ten. For
	 * example, the number twenty-four should be represented as the string "24".
	 * If no digits can be read from the InputStream an IOException is thrown.
	 * If the string NULL is read, the value null is returned.
	 * @return The next integer read from this stream, or null.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream, the end of the stream has been reached, or the data in the
	 * stream does not match the expected pattern of an integer.
	 */
	public Integer readInt() throws IOException{
		
		int i = 0;
		boolean negative = false;
		char c = peekChar();
		
		if(c == 'N'){
			readChar();
			if(readChar() == 'U' && readChar() == 'L' && readChar() == 'L')
				return null;
			else
				throw new IOException("Input mismatch while attempting to read integer");
		}
		
		if(c == '-'){
			negative = true;
			readChar();
			c = peekChar();
		}
		
		if(!Character.isDigit(c)){
			throw new IOException("Input mismatch while attempting to read integer");
		}
		
		while(true){
			
			c = readChar();
			i *= 10;
			i += c-48;
			c = peekChar();
			if(!Character.isDigit(c))
				break;
		}
		
		if(i < 0) //Value overflowed int type
			throw new IOException("Input mismatch while attempting to read integer");
		
		if(negative)
			i = -i;
		
		return i;
	}
	
	/**
	 * Reads a list of Objects from the underlying InputStream. A list is assumed
	 * to be surrounded by braces, '(', ')', and each element is assumed to be
	 * separated by a single comma ','.
	 * @param reader The object used to parse the individual elements of the list.
	 * @return An ArrayList of objects returned by the specified reader.
	 * @throws IOException If there is an error reading from the underlying
	 * InputStream, the end of the stream has been reached, the data in the
	 * stream does not match the expected pattern of a list, or the specified
	 * reader fails to parse any particular element.
	 */
	public <T> ArrayList<T> readList(Reader<T> reader) throws IOException{
		
		if(readChar() != '(')
			throw new IOException("Input mismatch while attempting to read list");
		
		ArrayList<T> list = new ArrayList<>();
		char c = peekChar();
		if(c != ')'){
			
			do{
				
				list.add(reader.read(this));
				c = readChar();
				
				if(c == ')')
					break;
				else if(c != ',')
					throw new IOException("Input mismatch while attempting to read list");
			}while(true);
		}
		else{
			readChar();
		}
		
		return list;
	}

	@Override
	public void close() throws Exception{
		
		in.close();
	}
}
