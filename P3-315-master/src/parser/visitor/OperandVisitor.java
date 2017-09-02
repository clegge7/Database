package parser.visitor;

import database.Literal;
import parser.ProgramBaseVisitor;
import parser.ProgramParser.AttributenameContext;
import parser.ProgramParser.LiteralContext;
import parser.ProgramParser.OperandContext;

/**
 * Visitor used to parse the 'operand' part of the 'comparison' token.
 * Returns an Operand that can be used in the resulting Comparisons.
 */
public class OperandVisitor extends ProgramBaseVisitor<Operand>{

	public static final OperandVisitor instance = new OperandVisitor();
	
	
	private OperandVisitor(){}
	
	@Override
	public Operand visitOperand(OperandContext ctx){
		
		if(ctx.getChildCount() != 1)
			return null;
		
		return visit(ctx.getChild(0));
	}
	
	@Override
	public Operand visitLiteral(LiteralContext ctx){
		
		final Literal literal = ctx.accept(LiteralVisitor.instance);
		
		if(literal == null)
			return null;
		
		//Operand is the same for each tuple
		return (t -> literal);
	}
	
	@Override
	public Operand visitAttributename(AttributenameContext ctx){
		
		final String attributeName = ctx.getText();
		
		if(attributeName == null || attributeName.isEmpty() || attributeName.equals("<missing Identifier>"))
			return null;
		
		//Operand is the attributeName field of each tuple
		return (t -> t.get(attributeName));
	}
}
