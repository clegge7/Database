package parser.visitor;

import java.util.ArrayList;

import parser.ProgramBaseVisitor;
import parser.ProgramParser.AttributelistContext;

/**
 * Visits a list of Identifier nodes separated by commas and returns their
 * String values in an ArrayList.
 */
public class IdentifierListVisitor extends ProgramBaseVisitor<ArrayList<String>>{

	public static final IdentifierListVisitor instance = new IdentifierListVisitor();
	
	
	private IdentifierListVisitor(){}
	
	@Override
	public ArrayList<String> visitAttributelist(AttributelistContext ctx){
		
		if(ctx.getChildCount() < 1 || (ctx.getChildCount()-1)%2 != 0)
			return null;
		
		ArrayList<String> list = new ArrayList<>();
		for(int i = 0; i < ctx.getChildCount(); i+=2)
			list.add(ctx.getChild(i).accept(IdentifierVisitor.instance));
		
		return list;
	}
}
