package parser.visitor;

import java.util.ArrayList;

import database.DatabaseException;
import database.DatabasePredicate;
import database.Relation;
import database.Session;
import parser.ProgramBaseVisitor;
import parser.ProgramParser.AtomicexprContext;
import parser.ProgramParser.DifferenceContext;
import parser.ProgramParser.ExprContext;
import parser.ProgramParser.NaturaljoinContext;
import parser.ProgramParser.ProductContext;
import parser.ProgramParser.ProjectionContext;
import parser.ProgramParser.RelationnameContext;
import parser.ProgramParser.RenamingContext;
import parser.ProgramParser.SelectionContext;
import parser.ProgramParser.UnionContext;

/**
 * Visitor used to parse Exprs, AtomicExprs, and the Expr operations such as: selection
 * renaming, 
 */
public class ExpressionVisitor extends ProgramBaseVisitor<Relation>{

	public final static ExpressionVisitor instance = new ExpressionVisitor(Parser.getSession());
	private final Session session;
	
	
	private ExpressionVisitor(Session session){
		this.session = session;
	}
	
	@Override
	public Relation visitAtomicexpr(AtomicexprContext ctx){
		
		if(ctx.getChildCount() != 1 && ctx.getChildCount() != 3)
			return null;
		
		if(ctx.getChildCount() == 1)
			return visit(ctx.getChild(0));
		else if(ctx.getChild(0).getText().equals("(") && ctx.getChild(2).getText().equals(")"))
			return visit(ctx.getChild(1));
		
		return null;
	}
	
	@Override
	public Relation visitExpr(ExprContext ctx){

		if(ctx.getChildCount() != 1)
			return null;
		
		return visit(ctx.getChild(0));
	}

	@Override
	public Relation visitSelection(SelectionContext ctx){
		
		if(ctx.getChildCount() != 5)
			return null;
		
		DatabasePredicate predicate = ctx.getChild(2).accept(ConditionVisitor.instance);
		Relation relation = visit(ctx.getChild(4));
		
		if(relation == null)
			return null;
		
		try {
			
			return relation.lookupAll(predicate);
		} catch (DatabaseException e) {
			
			System.out.println("Error performing selection: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Relation visitProjection(ProjectionContext ctx){

		if(ctx.getChildCount() != 5)
			return null;
		
		ArrayList<String> attributes = ctx.getChild(2).accept(IdentifierListVisitor.instance);
		Relation relation = visit(ctx.getChild(4));

		if(attributes == null || relation == null)
			return null;
		
		try {

			return relation.project(attributes);
		}catch(DatabaseException e){
			
			System.out.println("Error performing projection: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Relation visitRenaming(RenamingContext ctx){

		if(ctx.getChildCount() != 5)
			return null;
		
		ArrayList<String> attributes = ctx.getChild(2).accept(IdentifierListVisitor.instance);
		Relation relation = visit(ctx.getChild(4));
		
		if(attributes == null || relation == null)
			return null;
		
		try {
			
			return relation.rename(attributes);
		}catch(DatabaseException e){
			
			System.out.println("Error performing renaming: " + e.getMessage());
			return null;
		}
	}

	@Override
	public Relation visitRelationname(RelationnameContext ctx){

		if(ctx.getText() == null || ctx.getText().isEmpty() || ctx.getText().equals("<missing Identifier>"))
			return null;
		
		try {
			
			Relation relation = session.getRelation(ctx.getText());
			
			if(relation == null){
				System.out.println("Error parsing relation name: Relation '" + ctx.getText() + "' does not be exist or has not been opened.");
				return null;
			}
			
			return relation;
		} catch (DatabaseException e) {

			System.out.println("Error parsing relation name: " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public Relation visitUnion(UnionContext ctx){
		
		if(ctx.getChildCount() != 3)
			return null;
		
		Relation lhs = visit(ctx.getChild(0));
		Relation rhs = visit(ctx.getChild(2));
		
		if(lhs == null || rhs == null)
			return null;
		
		try{

			return lhs.union(rhs);
		}catch(DatabaseException e){
			
			System.out.println("Error performing union operation: " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public Relation visitDifference(DifferenceContext ctx){
		
		if(ctx.getChildCount() != 3)
			return null;
		
		Relation lhs = visit(ctx.getChild(0));
		Relation rhs = visit(ctx.getChild(2));
		
		if(lhs == null || rhs == null)
			return null;
		
		try{
			
			return lhs.difference(rhs);
		}catch(DatabaseException e){
			
			System.out.println("Error performing difference operation: " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public Relation visitProduct(ProductContext ctx){

		if(ctx.getChildCount() != 3)
			return null;
		
		Relation lhs = visit(ctx.getChild(0));
		Relation rhs = visit(ctx.getChild(2));
		
		if(lhs == null || rhs == null)
			return null;
		
		try{
			
			return lhs.product(rhs);
		}catch(DatabaseException e){
			
			System.out.println("Error performing product operation: " + e.getMessage());
			return null;
		}
	}
	
	@Override
	public Relation visitNaturaljoin(NaturaljoinContext ctx){

		if(ctx.getChildCount() != 3)
			return null;
		
		Relation lhs = visit(ctx.getChild(0));
		Relation rhs = visit(ctx.getChild(2));
		
		if(lhs == null || rhs == null)
			return null;
		
		try{
			
			return lhs.naturalJoin(rhs);
		}catch(DatabaseException e){
			
			System.out.println("Error performing natural join operation: " + e.getMessage());
			return null;
		}
	}
}
