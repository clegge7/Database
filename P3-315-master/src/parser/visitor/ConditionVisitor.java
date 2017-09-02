package parser.visitor;

import java.util.ArrayList;
import java.util.HashMap;

import database.DatabasePredicate;
import database.FuzzyBoolean;
import parser.ProgramBaseVisitor;
import parser.ProgramParser.ComparisonContext;
import parser.ProgramParser.ConditionContext;
import parser.ProgramParser.ConjunctionContext;

public class ConditionVisitor extends ProgramBaseVisitor<DatabasePredicate>{

	public static final ConditionVisitor instance = new ConditionVisitor();
	private static final HashMap<String, Operator> ops = new HashMap<>();
	
	static{
		ops.put("==", (lhs, rhs) -> (t -> FuzzyBoolean.equalTo(lhs.eval(t), rhs.eval(t))));
		ops.put("!=", (lhs, rhs) -> (t -> FuzzyBoolean.notEqualTo(lhs.eval(t), rhs.eval(t))));
		ops.put(">", (lhs, rhs) -> (t -> FuzzyBoolean.greaterThan(lhs.eval(t), rhs.eval(t))));
		ops.put("<", (lhs, rhs) -> (t -> FuzzyBoolean.lessThan(lhs.eval(t), rhs.eval(t))));
		ops.put(">=", (lhs, rhs) -> (t -> FuzzyBoolean.greaterThanOrEqualTo(lhs.eval(t), rhs.eval(t))));
		ops.put("<=", (lhs, rhs) -> (t -> FuzzyBoolean.lessThanOrEqualTo(lhs.eval(t), rhs.eval(t))));
	}
	
	
	private ConditionVisitor(){}
	
	@Override
	public DatabasePredicate visitCondition(ConditionContext ctx){
		
		if(ctx.getChildCount() < 1 || (ctx.getChildCount()-1)%2 != 0)
			return null;
		
		final ArrayList<DatabasePredicate> conjunctions = new ArrayList<>();
		for(int i = 0; i < ctx.getChildCount(); i+=2){
			DatabasePredicate predicate = visit(ctx.getChild(i));
			if(predicate == null)
				return null;
			conjunctions.add(predicate);
		}
		
		return (t -> {
			FuzzyBoolean result = conjunctions.get(0).test(t);
			for(int i = 1 ; i < conjunctions.size(); ++i)
				result = result.or(conjunctions.get(i).test(t));
			return result;
		});
	}
	
	@Override
	public DatabasePredicate visitConjunction(ConjunctionContext ctx){
		
		if(ctx.getChildCount() < 1 || (ctx.getChildCount()-1)%2 != 0)
			return null;
		
		final ArrayList<DatabasePredicate> comparisons = new ArrayList<>();
		for(int i = 0; i < ctx.getChildCount(); i+=2){
			DatabasePredicate predicate = visit(ctx.getChild(i));
			if(predicate == null)
				return null;
			comparisons.add(predicate);
		}
		
		return (t -> {
			FuzzyBoolean result = comparisons.get(0).test(t);
			for(int i = 1 ; i < comparisons.size(); ++i)
				result = result.and(comparisons.get(i).test(t));
			return result;
		});
	}
	
	@Override
	public DatabasePredicate visitComparison(ComparisonContext ctx){
		
		if(ctx.getChildCount() != 3)
			return null;
		
		if(ctx.condition() != null)
			return visit(ctx.getChild(1));
		
		String op = ctx.getChild(1).getText();
		Operand lhs = ctx.getChild(0).accept(OperandVisitor.instance);
		Operand rhs = ctx.getChild(2).accept(OperandVisitor.instance);
		
		if(op == null || lhs == null || rhs == null)
			return null;
		
		return ops.get(op).perform(lhs, rhs);
	}
}
