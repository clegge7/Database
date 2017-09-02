// Generated from src/parser/Program.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ProgramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ProgramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ProgramParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(ProgramParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(ProgramParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#relationname}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationname(ProgramParser.RelationnameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(ProgramParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#atomicexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicexpr(ProgramParser.AtomicexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#selection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection(ProgramParser.SelectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(ProgramParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(ProgramParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(ProgramParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOp(ProgramParser.OpContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#operand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperand(ProgramParser.OperandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#attributename}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributename(ProgramParser.AttributenameContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(ProgramParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#projection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProjection(ProgramParser.ProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#attributelist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributelist(ProgramParser.AttributelistContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#renaming}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRenaming(ProgramParser.RenamingContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#union}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnion(ProgramParser.UnionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#difference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDifference(ProgramParser.DifferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#product}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProduct(ProgramParser.ProductContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#naturaljoin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNaturaljoin(ProgramParser.NaturaljoinContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(ProgramParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#opencmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpencmd(ProgramParser.OpencmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#closecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosecmd(ProgramParser.ClosecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#writecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWritecmd(ProgramParser.WritecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#exitcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExitcmd(ProgramParser.ExitcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#showcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShowcmd(ProgramParser.ShowcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#createcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatecmd(ProgramParser.CreatecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#updatecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdatecmd(ProgramParser.UpdatecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#insertcmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertcmd(ProgramParser.InsertcmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#deletecmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeletecmd(ProgramParser.DeletecmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ProgramParser#typedatrlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedatrlist(ProgramParser.TypedatrlistContext ctx);
}