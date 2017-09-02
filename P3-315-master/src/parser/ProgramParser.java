// Generated from src/parser/Program.g4 by ANTLR 4.7
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ProgramParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, Type=36, Null=37, Integer=38, 
		Identifier=39, Alpha=40, Digit=41, Varchar=42, WS=43;
	public static final int
		RULE_program = 0, RULE_query = 1, RULE_relationname = 2, RULE_expr = 3, 
		RULE_atomicexpr = 4, RULE_selection = 5, RULE_condition = 6, RULE_conjunction = 7, 
		RULE_comparison = 8, RULE_op = 9, RULE_operand = 10, RULE_attributename = 11, 
		RULE_literal = 12, RULE_projection = 13, RULE_attributelist = 14, RULE_renaming = 15, 
		RULE_union = 16, RULE_difference = 17, RULE_product = 18, RULE_naturaljoin = 19, 
		RULE_command = 20, RULE_opencmd = 21, RULE_closecmd = 22, RULE_writecmd = 23, 
		RULE_exitcmd = 24, RULE_showcmd = 25, RULE_createcmd = 26, RULE_updatecmd = 27, 
		RULE_insertcmd = 28, RULE_deletecmd = 29, RULE_typedatrlist = 30;
	public static final String[] ruleNames = {
		"program", "query", "relationname", "expr", "atomicexpr", "selection", 
		"condition", "conjunction", "comparison", "op", "operand", "attributename", 
		"literal", "projection", "attributelist", "renaming", "union", "difference", 
		"product", "naturaljoin", "command", "opencmd", "closecmd", "writecmd", 
		"exitcmd", "showcmd", "createcmd", "updatecmd", "insertcmd", "deletecmd", 
		"typedatrlist"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'<-'", "'('", "')'", "'select'", "'||'", "'&&'", "'=='", 
		"'!='", "'<'", "'>'", "'<='", "'>='", "'project'", "','", "'rename'", 
		"'+'", "'-'", "'*'", "'&'", "'OPEN'", "'CLOSE'", "'WRITE'", "'EXIT'", 
		"'SHOW'", "'CREATE TABLE'", "'PRIMARY KEY'", "'UPDATE'", "'SET'", "'='", 
		"'WHERE'", "'INSERT INTO'", "'VALUES FROM'", "'VALUES FROM RELATION'", 
		"'DELETE FROM'", null, "'NULL'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"Type", "Null", "Integer", "Identifier", "Alpha", "Digit", "Varchar", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Program.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProgramParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<QueryContext> query() {
			return getRuleContexts(QueryContext.class);
		}
		public QueryContext query(int i) {
			return getRuleContext(QueryContext.class,i);
		}
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public TerminalNode EOF() { return getToken(ProgramParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			int _alt;
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__27:
			case T__31:
			case T__34:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(64);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Identifier:
					{
					setState(62);
					query();
					}
					break;
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case T__27:
				case T__31:
				case T__34:
					{
					setState(63);
					command();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(73);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(66);
						match(T__0);
						setState(69);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case Identifier:
							{
							setState(67);
							query();
							}
							break;
						case T__20:
						case T__21:
						case T__22:
						case T__23:
						case T__24:
						case T__25:
						case T__27:
						case T__31:
						case T__34:
							{
							setState(68);
							command();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(75);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__0) {
					{
					setState(76);
					match(T__0);
					}
				}

				}
				}
				break;
			case EOF:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitQuery(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			relationname();
			setState(83);
			match(T__1);
			setState(84);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationnameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ProgramParser.Identifier, 0); }
		public RelationnameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationname; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitRelationname(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationnameContext relationname() throws RecognitionException {
		RelationnameContext _localctx = new RelationnameContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_relationname);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public SelectionContext selection() {
			return getRuleContext(SelectionContext.class,0);
		}
		public ProjectionContext projection() {
			return getRuleContext(ProjectionContext.class,0);
		}
		public RenamingContext renaming() {
			return getRuleContext(RenamingContext.class,0);
		}
		public UnionContext union() {
			return getRuleContext(UnionContext.class,0);
		}
		public DifferenceContext difference() {
			return getRuleContext(DifferenceContext.class,0);
		}
		public ProductContext product() {
			return getRuleContext(ProductContext.class,0);
		}
		public NaturaljoinContext naturaljoin() {
			return getRuleContext(NaturaljoinContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr);
		try {
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				atomicexpr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				selection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				projection();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				renaming();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(92);
				union();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				difference();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(94);
				product();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(95);
				naturaljoin();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomicexprContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtomicexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicexpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitAtomicexpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicexprContext atomicexpr() throws RecognitionException {
		AtomicexprContext _localctx = new AtomicexprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_atomicexpr);
		try {
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				relationname();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				match(T__2);
				setState(100);
				expr();
				setState(101);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectionContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public SelectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitSelection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelectionContext selection() throws RecognitionException {
		SelectionContext _localctx = new SelectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_selection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__4);
			setState(106);
			match(T__2);
			setState(107);
			condition();
			setState(108);
			match(T__3);
			setState(109);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			conjunction();
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(112);
				match(T__5);
				setState(113);
				conjunction();
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConjunctionContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			comparison();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(120);
				match(T__6);
				setState(121);
				comparison();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparisonContext extends ParserRuleContext {
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_comparison);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Null:
			case Integer:
			case Identifier:
			case Varchar:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				operand();
				setState(128);
				op();
				setState(129);
				operand();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(T__2);
				setState(132);
				condition();
				setState(133);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public AttributenameContext attributename() {
			return getRuleContext(AttributenameContext.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitOperand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operand);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				attributename();
				}
				break;
			case Null:
			case Integer:
			case Varchar:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributenameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ProgramParser.Identifier, 0); }
		public AttributenameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributename; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitAttributename(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributenameContext attributename() throws RecognitionException {
		AttributenameContext _localctx = new AttributenameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attributename);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode Varchar() { return getToken(ProgramParser.Varchar, 0); }
		public TerminalNode Integer() { return getToken(ProgramParser.Integer, 0); }
		public TerminalNode Null() { return getToken(ProgramParser.Null, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Null) | (1L << Integer) | (1L << Varchar))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProjectionContext extends ParserRuleContext {
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public ProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_projection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProjectionContext projection() throws RecognitionException {
		ProjectionContext _localctx = new ProjectionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_projection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__13);
			setState(148);
			match(T__2);
			setState(149);
			attributelist();
			setState(150);
			match(T__3);
			setState(151);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributelistContext extends ParserRuleContext {
		public List<AttributenameContext> attributename() {
			return getRuleContexts(AttributenameContext.class);
		}
		public AttributenameContext attributename(int i) {
			return getRuleContext(AttributenameContext.class,i);
		}
		public AttributelistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributelist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitAttributelist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributelistContext attributelist() throws RecognitionException {
		AttributelistContext _localctx = new AttributelistContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attributelist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			attributename();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(154);
				match(T__14);
				setState(155);
				attributename();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RenamingContext extends ParserRuleContext {
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public RenamingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_renaming; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitRenaming(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RenamingContext renaming() throws RecognitionException {
		RenamingContext _localctx = new RenamingContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_renaming);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__15);
			setState(162);
			match(T__2);
			setState(163);
			attributelist();
			setState(164);
			match(T__3);
			setState(165);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionContext extends ParserRuleContext {
		public List<AtomicexprContext> atomicexpr() {
			return getRuleContexts(AtomicexprContext.class);
		}
		public AtomicexprContext atomicexpr(int i) {
			return getRuleContext(AtomicexprContext.class,i);
		}
		public UnionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitUnion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionContext union() throws RecognitionException {
		UnionContext _localctx = new UnionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			atomicexpr();
			setState(168);
			match(T__16);
			setState(169);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DifferenceContext extends ParserRuleContext {
		public List<AtomicexprContext> atomicexpr() {
			return getRuleContexts(AtomicexprContext.class);
		}
		public AtomicexprContext atomicexpr(int i) {
			return getRuleContext(AtomicexprContext.class,i);
		}
		public DifferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_difference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitDifference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DifferenceContext difference() throws RecognitionException {
		DifferenceContext _localctx = new DifferenceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_difference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			atomicexpr();
			setState(172);
			match(T__17);
			setState(173);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProductContext extends ParserRuleContext {
		public List<AtomicexprContext> atomicexpr() {
			return getRuleContexts(AtomicexprContext.class);
		}
		public AtomicexprContext atomicexpr(int i) {
			return getRuleContext(AtomicexprContext.class,i);
		}
		public ProductContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_product; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitProduct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProductContext product() throws RecognitionException {
		ProductContext _localctx = new ProductContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_product);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			atomicexpr();
			setState(176);
			match(T__18);
			setState(177);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NaturaljoinContext extends ParserRuleContext {
		public List<AtomicexprContext> atomicexpr() {
			return getRuleContexts(AtomicexprContext.class);
		}
		public AtomicexprContext atomicexpr(int i) {
			return getRuleContext(AtomicexprContext.class,i);
		}
		public NaturaljoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_naturaljoin; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitNaturaljoin(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NaturaljoinContext naturaljoin() throws RecognitionException {
		NaturaljoinContext _localctx = new NaturaljoinContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_naturaljoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			atomicexpr();
			setState(180);
			match(T__19);
			setState(181);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public OpencmdContext opencmd() {
			return getRuleContext(OpencmdContext.class,0);
		}
		public ClosecmdContext closecmd() {
			return getRuleContext(ClosecmdContext.class,0);
		}
		public WritecmdContext writecmd() {
			return getRuleContext(WritecmdContext.class,0);
		}
		public ExitcmdContext exitcmd() {
			return getRuleContext(ExitcmdContext.class,0);
		}
		public ShowcmdContext showcmd() {
			return getRuleContext(ShowcmdContext.class,0);
		}
		public CreatecmdContext createcmd() {
			return getRuleContext(CreatecmdContext.class,0);
		}
		public UpdatecmdContext updatecmd() {
			return getRuleContext(UpdatecmdContext.class,0);
		}
		public InsertcmdContext insertcmd() {
			return getRuleContext(InsertcmdContext.class,0);
		}
		public DeletecmdContext deletecmd() {
			return getRuleContext(DeletecmdContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_command);
		try {
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				opencmd();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				closecmd();
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				writecmd();
				}
				break;
			case T__23:
				enterOuterAlt(_localctx, 4);
				{
				setState(186);
				exitcmd();
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				showcmd();
				}
				break;
			case T__25:
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				createcmd();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 7);
				{
				setState(189);
				updatecmd();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 8);
				{
				setState(190);
				insertcmd();
				}
				break;
			case T__34:
				enterOuterAlt(_localctx, 9);
				{
				setState(191);
				deletecmd();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpencmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public OpencmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opencmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitOpencmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpencmdContext opencmd() throws RecognitionException {
		OpencmdContext _localctx = new OpencmdContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_opencmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__20);
			setState(195);
			relationname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClosecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public ClosecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closecmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitClosecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClosecmdContext closecmd() throws RecognitionException {
		ClosecmdContext _localctx = new ClosecmdContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_closecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__21);
			setState(198);
			relationname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WritecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public WritecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_writecmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitWritecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WritecmdContext writecmd() throws RecognitionException {
		WritecmdContext _localctx = new WritecmdContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_writecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(T__22);
			setState(201);
			relationname();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExitcmdContext extends ParserRuleContext {
		public ExitcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exitcmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitExitcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExitcmdContext exitcmd() throws RecognitionException {
		ExitcmdContext _localctx = new ExitcmdContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_exitcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowcmdContext extends ParserRuleContext {
		public AtomicexprContext atomicexpr() {
			return getRuleContext(AtomicexprContext.class,0);
		}
		public ShowcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showcmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitShowcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShowcmdContext showcmd() throws RecognitionException {
		ShowcmdContext _localctx = new ShowcmdContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_showcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__24);
			setState(206);
			atomicexpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public TypedatrlistContext typedatrlist() {
			return getRuleContext(TypedatrlistContext.class,0);
		}
		public AttributelistContext attributelist() {
			return getRuleContext(AttributelistContext.class,0);
		}
		public CreatecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createcmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitCreatecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatecmdContext createcmd() throws RecognitionException {
		CreatecmdContext _localctx = new CreatecmdContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_createcmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__25);
			setState(209);
			relationname();
			setState(210);
			match(T__2);
			setState(211);
			typedatrlist();
			setState(212);
			match(T__3);
			setState(213);
			match(T__26);
			setState(214);
			match(T__2);
			setState(215);
			attributelist();
			setState(216);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdatecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public List<AttributenameContext> attributename() {
			return getRuleContexts(AttributenameContext.class);
		}
		public AttributenameContext attributename(int i) {
			return getRuleContext(AttributenameContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public UpdatecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updatecmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitUpdatecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UpdatecmdContext updatecmd() throws RecognitionException {
		UpdatecmdContext _localctx = new UpdatecmdContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_updatecmd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(T__27);
			setState(219);
			relationname();
			setState(220);
			match(T__28);
			setState(221);
			attributename();
			setState(222);
			match(T__29);
			setState(223);
			literal();
			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(224);
				match(T__14);
				setState(225);
				attributename();
				setState(226);
				match(T__29);
				setState(227);
				literal();
				}
				}
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(234);
			match(T__30);
			setState(235);
			condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertcmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InsertcmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertcmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitInsertcmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InsertcmdContext insertcmd() throws RecognitionException {
		InsertcmdContext _localctx = new InsertcmdContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_insertcmd);
		int _la;
		try {
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(T__31);
				setState(238);
				relationname();
				setState(239);
				match(T__32);
				setState(240);
				match(T__2);
				setState(241);
				literal();
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__14) {
					{
					{
					setState(242);
					match(T__14);
					setState(243);
					literal();
					}
					}
					setState(248);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(249);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(T__31);
				setState(252);
				relationname();
				setState(253);
				match(T__33);
				setState(254);
				expr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeletecmdContext extends ParserRuleContext {
		public RelationnameContext relationname() {
			return getRuleContext(RelationnameContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public DeletecmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deletecmd; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitDeletecmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeletecmdContext deletecmd() throws RecognitionException {
		DeletecmdContext _localctx = new DeletecmdContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_deletecmd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__34);
			setState(259);
			relationname();
			setState(260);
			match(T__30);
			setState(261);
			condition();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypedatrlistContext extends ParserRuleContext {
		public List<AttributenameContext> attributename() {
			return getRuleContexts(AttributenameContext.class);
		}
		public AttributenameContext attributename(int i) {
			return getRuleContext(AttributenameContext.class,i);
		}
		public List<TerminalNode> Type() { return getTokens(ProgramParser.Type); }
		public TerminalNode Type(int i) {
			return getToken(ProgramParser.Type, i);
		}
		public TypedatrlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typedatrlist; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ProgramVisitor ) return ((ProgramVisitor<? extends T>)visitor).visitTypedatrlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypedatrlistContext typedatrlist() throws RecognitionException {
		TypedatrlistContext _localctx = new TypedatrlistContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_typedatrlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			attributename();
			setState(264);
			match(Type);
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14) {
				{
				{
				setState(265);
				match(T__14);
				setState(266);
				attributename();
				setState(267);
				match(Type);
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0115\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\5\2C\n\2\3\2\3\2\3\2\5\2H\n\2\7\2J\n\2\f\2\16\2M\13\2\3\2\5\2P\n"+
		"\2\3\2\5\2S\n\2\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5c\n\5\3\6\3\6\3\6\3\6\3\6\5\6j\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\7\bu\n\b\f\b\16\bx\13\b\3\t\3\t\3\t\7\t}\n\t\f\t\16\t\u0080\13"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u008a\n\n\3\13\3\13\3\f\3\f\5\f"+
		"\u0090\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\7\20\u009f\n\20\f\20\16\20\u00a2\13\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00c3"+
		"\n\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u00e8\n\35\f\35\16\35\u00eb"+
		"\13\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36\u00f7\n"+
		"\36\f\36\16\36\u00fa\13\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0103"+
		"\n\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \7 \u0110\n \f \16 \u0113"+
		"\13 \3 \2\2!\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>\2\4\3\2\n\17\4\2\'(,,\2\u0113\2R\3\2\2\2\4T\3\2\2\2\6X\3\2\2\2"+
		"\bb\3\2\2\2\ni\3\2\2\2\fk\3\2\2\2\16q\3\2\2\2\20y\3\2\2\2\22\u0089\3\2"+
		"\2\2\24\u008b\3\2\2\2\26\u008f\3\2\2\2\30\u0091\3\2\2\2\32\u0093\3\2\2"+
		"\2\34\u0095\3\2\2\2\36\u009b\3\2\2\2 \u00a3\3\2\2\2\"\u00a9\3\2\2\2$\u00ad"+
		"\3\2\2\2&\u00b1\3\2\2\2(\u00b5\3\2\2\2*\u00c2\3\2\2\2,\u00c4\3\2\2\2."+
		"\u00c7\3\2\2\2\60\u00ca\3\2\2\2\62\u00cd\3\2\2\2\64\u00cf\3\2\2\2\66\u00d2"+
		"\3\2\2\28\u00dc\3\2\2\2:\u0102\3\2\2\2<\u0104\3\2\2\2>\u0109\3\2\2\2@"+
		"C\5\4\3\2AC\5*\26\2B@\3\2\2\2BA\3\2\2\2CK\3\2\2\2DG\7\3\2\2EH\5\4\3\2"+
		"FH\5*\26\2GE\3\2\2\2GF\3\2\2\2HJ\3\2\2\2ID\3\2\2\2JM\3\2\2\2KI\3\2\2\2"+
		"KL\3\2\2\2LO\3\2\2\2MK\3\2\2\2NP\7\3\2\2ON\3\2\2\2OP\3\2\2\2PS\3\2\2\2"+
		"QS\7\2\2\3RB\3\2\2\2RQ\3\2\2\2S\3\3\2\2\2TU\5\6\4\2UV\7\4\2\2VW\5\b\5"+
		"\2W\5\3\2\2\2XY\7)\2\2Y\7\3\2\2\2Zc\5\n\6\2[c\5\f\7\2\\c\5\34\17\2]c\5"+
		" \21\2^c\5\"\22\2_c\5$\23\2`c\5&\24\2ac\5(\25\2bZ\3\2\2\2b[\3\2\2\2b\\"+
		"\3\2\2\2b]\3\2\2\2b^\3\2\2\2b_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\t\3\2\2\2"+
		"dj\5\6\4\2ef\7\5\2\2fg\5\b\5\2gh\7\6\2\2hj\3\2\2\2id\3\2\2\2ie\3\2\2\2"+
		"j\13\3\2\2\2kl\7\7\2\2lm\7\5\2\2mn\5\16\b\2no\7\6\2\2op\5\n\6\2p\r\3\2"+
		"\2\2qv\5\20\t\2rs\7\b\2\2su\5\20\t\2tr\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3"+
		"\2\2\2w\17\3\2\2\2xv\3\2\2\2y~\5\22\n\2z{\7\t\2\2{}\5\22\n\2|z\3\2\2\2"+
		"}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\21\3\2\2\2\u0080~\3\2\2\2\u0081"+
		"\u0082\5\26\f\2\u0082\u0083\5\24\13\2\u0083\u0084\5\26\f\2\u0084\u008a"+
		"\3\2\2\2\u0085\u0086\7\5\2\2\u0086\u0087\5\16\b\2\u0087\u0088\7\6\2\2"+
		"\u0088\u008a\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0085\3\2\2\2\u008a\23"+
		"\3\2\2\2\u008b\u008c\t\2\2\2\u008c\25\3\2\2\2\u008d\u0090\5\30\r\2\u008e"+
		"\u0090\5\32\16\2\u008f\u008d\3\2\2\2\u008f\u008e\3\2\2\2\u0090\27\3\2"+
		"\2\2\u0091\u0092\7)\2\2\u0092\31\3\2\2\2\u0093\u0094\t\3\2\2\u0094\33"+
		"\3\2\2\2\u0095\u0096\7\20\2\2\u0096\u0097\7\5\2\2\u0097\u0098\5\36\20"+
		"\2\u0098\u0099\7\6\2\2\u0099\u009a\5\n\6\2\u009a\35\3\2\2\2\u009b\u00a0"+
		"\5\30\r\2\u009c\u009d\7\21\2\2\u009d\u009f\5\30\r\2\u009e\u009c\3\2\2"+
		"\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\37"+
		"\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7\22\2\2\u00a4\u00a5\7\5\2\2"+
		"\u00a5\u00a6\5\36\20\2\u00a6\u00a7\7\6\2\2\u00a7\u00a8\5\n\6\2\u00a8!"+
		"\3\2\2\2\u00a9\u00aa\5\n\6\2\u00aa\u00ab\7\23\2\2\u00ab\u00ac\5\n\6\2"+
		"\u00ac#\3\2\2\2\u00ad\u00ae\5\n\6\2\u00ae\u00af\7\24\2\2\u00af\u00b0\5"+
		"\n\6\2\u00b0%\3\2\2\2\u00b1\u00b2\5\n\6\2\u00b2\u00b3\7\25\2\2\u00b3\u00b4"+
		"\5\n\6\2\u00b4\'\3\2\2\2\u00b5\u00b6\5\n\6\2\u00b6\u00b7\7\26\2\2\u00b7"+
		"\u00b8\5\n\6\2\u00b8)\3\2\2\2\u00b9\u00c3\5,\27\2\u00ba\u00c3\5.\30\2"+
		"\u00bb\u00c3\5\60\31\2\u00bc\u00c3\5\62\32\2\u00bd\u00c3\5\64\33\2\u00be"+
		"\u00c3\5\66\34\2\u00bf\u00c3\58\35\2\u00c0\u00c3\5:\36\2\u00c1\u00c3\5"+
		"<\37\2\u00c2\u00b9\3\2\2\2\u00c2\u00ba\3\2\2\2\u00c2\u00bb\3\2\2\2\u00c2"+
		"\u00bc\3\2\2\2\u00c2\u00bd\3\2\2\2\u00c2\u00be\3\2\2\2\u00c2\u00bf\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c1\3\2\2\2\u00c3+\3\2\2\2\u00c4\u00c5"+
		"\7\27\2\2\u00c5\u00c6\5\6\4\2\u00c6-\3\2\2\2\u00c7\u00c8\7\30\2\2\u00c8"+
		"\u00c9\5\6\4\2\u00c9/\3\2\2\2\u00ca\u00cb\7\31\2\2\u00cb\u00cc\5\6\4\2"+
		"\u00cc\61\3\2\2\2\u00cd\u00ce\7\32\2\2\u00ce\63\3\2\2\2\u00cf\u00d0\7"+
		"\33\2\2\u00d0\u00d1\5\n\6\2\u00d1\65\3\2\2\2\u00d2\u00d3\7\34\2\2\u00d3"+
		"\u00d4\5\6\4\2\u00d4\u00d5\7\5\2\2\u00d5\u00d6\5> \2\u00d6\u00d7\7\6\2"+
		"\2\u00d7\u00d8\7\35\2\2\u00d8\u00d9\7\5\2\2\u00d9\u00da\5\36\20\2\u00da"+
		"\u00db\7\6\2\2\u00db\67\3\2\2\2\u00dc\u00dd\7\36\2\2\u00dd\u00de\5\6\4"+
		"\2\u00de\u00df\7\37\2\2\u00df\u00e0\5\30\r\2\u00e0\u00e1\7 \2\2\u00e1"+
		"\u00e9\5\32\16\2\u00e2\u00e3\7\21\2\2\u00e3\u00e4\5\30\r\2\u00e4\u00e5"+
		"\7 \2\2\u00e5\u00e6\5\32\16\2\u00e6\u00e8\3\2\2\2\u00e7\u00e2\3\2\2\2"+
		"\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec"+
		"\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\7!\2\2\u00ed\u00ee\5\16\b\2\u00ee"+
		"9\3\2\2\2\u00ef\u00f0\7\"\2\2\u00f0\u00f1\5\6\4\2\u00f1\u00f2\7#\2\2\u00f2"+
		"\u00f3\7\5\2\2\u00f3\u00f8\5\32\16\2\u00f4\u00f5\7\21\2\2\u00f5\u00f7"+
		"\5\32\16\2\u00f6\u00f4\3\2\2\2\u00f7\u00fa\3\2\2\2\u00f8\u00f6\3\2\2\2"+
		"\u00f8\u00f9\3\2\2\2\u00f9\u00fb\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb\u00fc"+
		"\7\6\2\2\u00fc\u0103\3\2\2\2\u00fd\u00fe\7\"\2\2\u00fe\u00ff\5\6\4\2\u00ff"+
		"\u0100\7$\2\2\u0100\u0101\5\b\5\2\u0101\u0103\3\2\2\2\u0102\u00ef\3\2"+
		"\2\2\u0102\u00fd\3\2\2\2\u0103;\3\2\2\2\u0104\u0105\7%\2\2\u0105\u0106"+
		"\5\6\4\2\u0106\u0107\7!\2\2\u0107\u0108\5\16\b\2\u0108=\3\2\2\2\u0109"+
		"\u010a\5\30\r\2\u010a\u0111\7&\2\2\u010b\u010c\7\21\2\2\u010c\u010d\5"+
		"\30\r\2\u010d\u010e\7&\2\2\u010e\u0110\3\2\2\2\u010f\u010b\3\2\2\2\u0110"+
		"\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112?\3\2\2\2"+
		"\u0113\u0111\3\2\2\2\23BGKORbiv~\u0089\u008f\u00a0\u00c2\u00e9\u00f8\u0102"+
		"\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}