// Generated from Program.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ProgramParser}.
 */
public interface ProgramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ProgramParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ProgramParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(ProgramParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(ProgramParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#relationname}.
	 * @param ctx the parse tree
	 */
	void enterRelationname(ProgramParser.RelationnameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#relationname}.
	 * @param ctx the parse tree
	 */
	void exitRelationname(ProgramParser.RelationnameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(ProgramParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(ProgramParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#alpha}.
	 * @param ctx the parse tree
	 */
	void enterAlpha(ProgramParser.AlphaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#alpha}.
	 * @param ctx the parse tree
	 */
	void exitAlpha(ProgramParser.AlphaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#digit}.
	 * @param ctx the parse tree
	 */
	void enterDigit(ProgramParser.DigitContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#digit}.
	 * @param ctx the parse tree
	 */
	void exitDigit(ProgramParser.DigitContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(ProgramParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(ProgramParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#atomicexpr}.
	 * @param ctx the parse tree
	 */
	void enterAtomicexpr(ProgramParser.AtomicexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#atomicexpr}.
	 * @param ctx the parse tree
	 */
	void exitAtomicexpr(ProgramParser.AtomicexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#selection}.
	 * @param ctx the parse tree
	 */
	void enterSelection(ProgramParser.SelectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#selection}.
	 * @param ctx the parse tree
	 */
	void exitSelection(ProgramParser.SelectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(ProgramParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(ProgramParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void enterConjunction(ProgramParser.ConjunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#conjunction}.
	 * @param ctx the parse tree
	 */
	void exitConjunction(ProgramParser.ConjunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(ProgramParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(ProgramParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOp(ProgramParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOp(ProgramParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#operand}.
	 * @param ctx the parse tree
	 */
	void enterOperand(ProgramParser.OperandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#operand}.
	 * @param ctx the parse tree
	 */
	void exitOperand(ProgramParser.OperandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#attributename}.
	 * @param ctx the parse tree
	 */
	void enterAttributename(ProgramParser.AttributenameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#attributename}.
	 * @param ctx the parse tree
	 */
	void exitAttributename(ProgramParser.AttributenameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(ProgramParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(ProgramParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#projection}.
	 * @param ctx the parse tree
	 */
	void enterProjection(ProgramParser.ProjectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#projection}.
	 * @param ctx the parse tree
	 */
	void exitProjection(ProgramParser.ProjectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#attributelist}.
	 * @param ctx the parse tree
	 */
	void enterAttributelist(ProgramParser.AttributelistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#attributelist}.
	 * @param ctx the parse tree
	 */
	void exitAttributelist(ProgramParser.AttributelistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#renaming}.
	 * @param ctx the parse tree
	 */
	void enterRenaming(ProgramParser.RenamingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#renaming}.
	 * @param ctx the parse tree
	 */
	void exitRenaming(ProgramParser.RenamingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#union}.
	 * @param ctx the parse tree
	 */
	void enterUnion(ProgramParser.UnionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#union}.
	 * @param ctx the parse tree
	 */
	void exitUnion(ProgramParser.UnionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#difference}.
	 * @param ctx the parse tree
	 */
	void enterDifference(ProgramParser.DifferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#difference}.
	 * @param ctx the parse tree
	 */
	void exitDifference(ProgramParser.DifferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#product}.
	 * @param ctx the parse tree
	 */
	void enterProduct(ProgramParser.ProductContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#product}.
	 * @param ctx the parse tree
	 */
	void exitProduct(ProgramParser.ProductContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#naturaljoin}.
	 * @param ctx the parse tree
	 */
	void enterNaturaljoin(ProgramParser.NaturaljoinContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#naturaljoin}.
	 * @param ctx the parse tree
	 */
	void exitNaturaljoin(ProgramParser.NaturaljoinContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(ProgramParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(ProgramParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#opencmd}.
	 * @param ctx the parse tree
	 */
	void enterOpencmd(ProgramParser.OpencmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#opencmd}.
	 * @param ctx the parse tree
	 */
	void exitOpencmd(ProgramParser.OpencmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#closecmd}.
	 * @param ctx the parse tree
	 */
	void enterClosecmd(ProgramParser.ClosecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#closecmd}.
	 * @param ctx the parse tree
	 */
	void exitClosecmd(ProgramParser.ClosecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#writecmd}.
	 * @param ctx the parse tree
	 */
	void enterWritecmd(ProgramParser.WritecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#writecmd}.
	 * @param ctx the parse tree
	 */
	void exitWritecmd(ProgramParser.WritecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#exitcmd}.
	 * @param ctx the parse tree
	 */
	void enterExitcmd(ProgramParser.ExitcmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#exitcmd}.
	 * @param ctx the parse tree
	 */
	void exitExitcmd(ProgramParser.ExitcmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#showcmd}.
	 * @param ctx the parse tree
	 */
	void enterShowcmd(ProgramParser.ShowcmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#showcmd}.
	 * @param ctx the parse tree
	 */
	void exitShowcmd(ProgramParser.ShowcmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#createcmd}.
	 * @param ctx the parse tree
	 */
	void enterCreatecmd(ProgramParser.CreatecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#createcmd}.
	 * @param ctx the parse tree
	 */
	void exitCreatecmd(ProgramParser.CreatecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#updatecmd}.
	 * @param ctx the parse tree
	 */
	void enterUpdatecmd(ProgramParser.UpdatecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#updatecmd}.
	 * @param ctx the parse tree
	 */
	void exitUpdatecmd(ProgramParser.UpdatecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#insertcmd}.
	 * @param ctx the parse tree
	 */
	void enterInsertcmd(ProgramParser.InsertcmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#insertcmd}.
	 * @param ctx the parse tree
	 */
	void exitInsertcmd(ProgramParser.InsertcmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#deletecmd}.
	 * @param ctx the parse tree
	 */
	void enterDeletecmd(ProgramParser.DeletecmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#deletecmd}.
	 * @param ctx the parse tree
	 */
	void exitDeletecmd(ProgramParser.DeletecmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#typedatrlist}.
	 * @param ctx the parse tree
	 */
	void enterTypedatrlist(ProgramParser.TypedatrlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#typedatrlist}.
	 * @param ctx the parse tree
	 */
	void exitTypedatrlist(ProgramParser.TypedatrlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(ProgramParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(ProgramParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ProgramParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(ProgramParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ProgramParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(ProgramParser.IntegerContext ctx);
}