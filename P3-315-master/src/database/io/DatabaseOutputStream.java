package database.io;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * A utility class for writing the values of the various literals and data structures
 * used by this database to a wrapped OutputStream.
 */
public class DatabaseOutputStream implements AutoCloseable{
	
	private final OutputStream out;
	private int index = 0;
	private final byte[] buffer = new byte[8192];
	
	/**
	 * Constructs a DatabaseOutputStream by wrapping the specified OutputStream. 
	 * A DatabaseOutputStream is used as a utility class for writing the various
	 * literals and data structures associated with this database. A
	 * DatabaseOutputStream will buffer its writing so there's no need to wrap
	 * the OutputStream in a BufferedOutputStream prior to construction.
	 * @param in The OutputStream to be wrapped.
	 */
	public DatabaseOutputStream(OutputStream out){
		this.out = out;
	}
	
	/**
	 * Flushes the buffer to the underlying OutputStream, then flushes
	 * that stream.
	 * @throws IOException If there is an error writing to, or flushing
	 * the underlying OutputStream.
	 */
	public void flush() throws IOException{
		
		out.write(buffer, 0, index);
		out.flush();
		index = 0;
	}
	
	/**
	 * Writes a single byte to this stream.
	 * @param b The byte to be written.
	 * @throws IOException If there is an error writing to, or flushing
	 * the underlying OutputStream.
	 */
	public void writeByte(byte b) throws IOException{
		
		if(index >= buffer.length)
			flush();
		
		buffer[index++] = b;
	}
	
	/**
	 * Convenience method for writing a single character to this stream.
	 * The character is simply casted to a byte then written using the {@link #writeByte()}
	 * method
	 * @param c The character to be written.
	 * @throws IOException If there is an error writing to, or flushing
	 * the underlying OutputStream.
	 */
	public void writeChar(char c) throws IOException{
		
		writeByte((byte)c);
	}
	
	/**
	 * Writes the specified string to the stream. The string will be surrounded
	 * by quotation marks and any special characters within the string will be
	 * escaped prior to writing. Any backslashes within the string will be replaced
	 * by "\\", then any quotation marks in the string will be replaced by "\"".
	 * If null, NULL is written.
	 * @param s The string to be written, or null.
	 * @throws IOException If there is an error writing to, or flushing
	 * the underlying OutputStream.
	 */
	public void writeString(String s) throws IOException{

		if(s == null){
			
			writeChar('N');
			writeChar('U');
			writeChar('L');
			writeChar('L');
		}
		else{
			
			writeChar('"');
			s.replace("\\", "\\\\");
			s.replace("\"", "\\\"");
			
			for(int i = 0; i < s.length(); ++i)
				writeChar(s.charAt(i));
			
			writeChar('"');
		}
	}
	
	/**
	 * Writes the specified string to the stream as a literal. The string will be
	 * written as it appears, and is assumed to only contain valid characters,
	 * [a-zA-z0-9_]<br>
	 * The string should be terminated by a call to {@link #writeChar(char)}
	 * with some invalid character after this method returns.
	 * @param s The string to be written.
	 * @throws IOException If there is an error writing to, or flushing
	 * the underlying OutputStream.
	 */
	public void writeIdentifier(String s) throws IOException{

		if(s == null)
			throw new NullPointerException();
			
		for(int i = 0; i < s.length(); ++i)
			writeChar(s.charAt(i));
	}
	
	/**
	 * Writes the specified integer to the stream. The integer will be
	 * written as a string using its base 10 value. For example, the
	 * value forty-two will be written as "42". If null, NULL is written.
	 * @param i The integer to be written, or null.
	 * @throws IOException If there is an error writing to, or flushing
	 * the underlying OutputStream
	 */
	public void writeInt(Integer i) throws IOException{
		
		if(i == null){
			
			writeChar('N');
			writeChar('U');
			writeChar('L');
			writeChar('L');
		}
		else{
			
			String s = i+"";
			for(int j = 0; j < s.length(); ++j)
				writeChar(s.charAt(j));
		}
	}
	
	/**
	 * Writes a list of {@link #Writable} objects to the stream. The list
	 * will be written surround by parenthesis, '(', ')', and each element will
	 * be separated by a single comma ','. Each element will be written by
	 * calling their {@link #Writable.write(DatabaseOutputStream)} method.
	 * @param list The list of {@link #Writable} objects to be written.
	 * @throws IOException If there is an error writing to, or flushing
	 * the underlying OutputStream, or if there is an error writing any
	 * of the {@link #Writable} objects.
	 */
	public void writeList(ArrayList<? extends Writable> list) throws IOException{
		
		writeChar('(');
		for(int i = 0; i < list.size(); ++i){
			
			list.get(i).write(this);
			if(i+1 != list.size())
				writeChar(',');
		}
		writeChar(')');
	}

	@Override
	public void close() throws Exception{
		
		if(index > 0)
			flush();
		
		out.close();
	}
}
