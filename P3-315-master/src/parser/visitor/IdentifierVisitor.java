package parser.visitor;

import parser.ProgramBaseVisitor;
import parser.ProgramParser.AttributenameContext;
import parser.ProgramParser.RelationnameContext;

/**
 * Visits the two tokens that use Identifier lexer tokens, and
 * returns their values as a plain String, the two nodes parsed
 * by this visitor are 'attributename' and 'relationname'.
 */
public class IdentifierVisitor extends ProgramBaseVisitor<String>{

	public static final IdentifierVisitor instance = new IdentifierVisitor();
	
	
	private IdentifierVisitor(){}
	
	@Override
	public String visitAttributename(AttributenameContext ctx){

		if(ctx.getText() == null || ctx.getText().isEmpty() || ctx.getText().equals("<missing Identifier>"))
			return null;
		
		return ctx.getText();
	}
	
	@Override
	public String visitRelationname(RelationnameContext ctx){
		
		if(ctx.getText() == null || ctx.getText().isEmpty() || ctx.getText().equals("<missing Identifier>"))
			return null;
		
		return ctx.getText();
	}
}
