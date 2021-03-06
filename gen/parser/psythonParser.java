// Generated from C:/Users/mocli/Code/psython2/src/parser\psython.g4 by ANTLR 4.7
package parser;

import ast.expression.*;
import ast.component.*;
import ast.leaf.*;
import ast.visitor.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class psythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, BOOL=15, NEXT_RAND=16, 
		SEED_RAND=17, IF=18, ELIF=19, ELSE=20, RETURN=21, DEF=22, WHILE=23, PRINT=24, 
		TRUE=25, FALSE=26, AND=27, OR=28, NOT=29, ID=30, NL=31, INT=32, STRING=33, 
		CHAR=34, WS=35, COMMENT=36, INDENT=37, DEDENT=38;
	public static final int
		RULE_program = 0, RULE_explist = 1, RULE_expression = 2, RULE_return_cmp = 3, 
		RULE_function = 4, RULE_function_call = 5, RULE_assignment = 6, RULE_arithmetic = 7, 
		RULE_relational = 8, RULE_logical = 9, RULE_print = 10, RULE_next_rand = 11, 
		RULE_seed_rand = 12, RULE_if_then_else = 13, RULE_while_exp = 14, RULE_argument = 15, 
		RULE_idlist = 16, RULE_arglist = 17, RULE_truth_val = 18, RULE_literal = 19;
	public static final String[] ruleNames = {
		"program", "explist", "expression", "return_cmp", "function", "function_call", 
		"assignment", "arithmetic", "relational", "logical", "print", "next_rand", 
		"seed_rand", "if_then_else", "while_exp", "argument", "idlist", "arglist", 
		"truth_val", "literal"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "'='", "'+'", "'-'", "'*'", "'/'", "'>'", "'>='", 
		"'=='", "'<'", "'<='", "','", null, "'nextr'", "'seedr'", "'if'", "'elif'", 
		"'else'", "'return'", "'def'", "'while'", "'print'", "'True'", "'False'", 
		"'and'", "'or'", "'not'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, "BOOL", "NEXT_RAND", "SEED_RAND", "IF", "ELIF", "ELSE", 
		"RETURN", "DEF", "WHILE", "PRINT", "TRUE", "FALSE", "AND", "OR", "NOT", 
		"ID", "NL", "INT", "STRING", "CHAR", "WS", "COMMENT", "INDENT", "DEDENT"
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
	public String getGrammarFileName() { return "psython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public psythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TerminalNode EOF() { return getToken(psythonParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			explist();
			setState(41);
			match(EOF);
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

	public static class ExplistContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TerminalNode NL() { return getToken(psythonParser.NL, 0); }
		public ExplistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterExplist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitExplist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitExplist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplistContext explist() throws RecognitionException {
		ExplistContext _localctx = new ExplistContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_explist);
		try {
			setState(49);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				expression();
				setState(44);
				explist();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(46);
				match(NL);
				setState(47);
				explist();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class ExpressionContext extends ParserRuleContext {
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ArithmeticContext arithmetic() {
			return getRuleContext(ArithmeticContext.class,0);
		}
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public If_then_elseContext if_then_else() {
			return getRuleContext(If_then_elseContext.class,0);
		}
		public While_expContext while_exp() {
			return getRuleContext(While_expContext.class,0);
		}
		public Next_randContext next_rand() {
			return getRuleContext(Next_randContext.class,0);
		}
		public Seed_randContext seed_rand() {
			return getRuleContext(Seed_randContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		try {
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51);
				function_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				assignment();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(53);
				function();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(54);
				arithmetic();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(55);
				relational();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				logical();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(57);
				print();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(58);
				if_then_else();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(59);
				while_exp();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(60);
				next_rand();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(61);
				seed_rand();
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

	public static class Return_cmpContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(psythonParser.RETURN, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public Return_cmpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_cmp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterReturn_cmp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitReturn_cmp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitReturn_cmp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_cmpContext return_cmp() throws RecognitionException {
		Return_cmpContext _localctx = new Return_cmpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_return_cmp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(RETURN);
			setState(65);
			arglist();
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

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(psythonParser.DEF, 0); }
		public TerminalNode ID() { return getToken(psythonParser.ID, 0); }
		public IdlistContext idlist() {
			return getRuleContext(IdlistContext.class,0);
		}
		public TerminalNode INDENT() { return getToken(psythonParser.INDENT, 0); }
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public Return_cmpContext return_cmp() {
			return getRuleContext(Return_cmpContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(psythonParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(psythonParser.NL, i);
		}
		public TerminalNode DEDENT() { return getToken(psythonParser.DEDENT, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(DEF);
			setState(68);
			match(ID);
			setState(69);
			match(T__0);
			setState(70);
			idlist();
			setState(71);
			match(T__1);
			setState(72);
			match(T__2);
			setState(73);
			match(INDENT);
			setState(74);
			explist();
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NL:
				{
				setState(75);
				match(NL);
				}
				break;
			case RETURN:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(79);
			return_cmp();
			setState(80);
			match(NL);
			setState(81);
			match(DEDENT);
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

	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(psythonParser.ID, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(ID);
			setState(84);
			match(T__0);
			setState(85);
			arglist();
			setState(86);
			match(T__1);
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

	public static class AssignmentContext extends ParserRuleContext {
		public IdlistContext idlist() {
			return getRuleContext(IdlistContext.class,0);
		}
		public TerminalNode ID() { return getToken(psythonParser.ID, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ArithmeticContext arithmetic() {
			return getRuleContext(ArithmeticContext.class,0);
		}
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			idlist();
			setState(89);
			match(T__3);
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(90);
				match(ID);
				}
				break;
			case 2:
				{
				setState(91);
				literal();
				}
				break;
			case 3:
				{
				setState(92);
				arithmetic();
				}
				break;
			case 4:
				{
				setState(93);
				relational();
				}
				break;
			case 5:
				{
				setState(94);
				logical();
				}
				break;
			case 6:
				{
				setState(95);
				function_call();
				}
				break;
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

	public static class ArithmeticContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(psythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(psythonParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(psythonParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(psythonParser.INT, i);
		}
		public ArithmeticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmetic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterArithmetic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitArithmetic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitArithmetic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticContext arithmetic() throws RecognitionException {
		ArithmeticContext _localctx = new ArithmeticContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arithmetic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(99);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(100);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==INT) ) {
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

	public static class RelationalContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(psythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(psythonParser.ID, i);
		}
		public List<TerminalNode> INT() { return getTokens(psythonParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(psythonParser.INT, i);
		}
		public RelationalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterRelational(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitRelational(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitRelational(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RelationalContext relational() throws RecognitionException {
		RelationalContext _localctx = new RelationalContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_relational);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(103);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(104);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==INT) ) {
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

	public static class LogicalContext extends ParserRuleContext {
		public TerminalNode AND() { return getToken(psythonParser.AND, 0); }
		public TerminalNode OR() { return getToken(psythonParser.OR, 0); }
		public List<TerminalNode> ID() { return getTokens(psythonParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(psythonParser.ID, i);
		}
		public List<TerminalNode> BOOL() { return getTokens(psythonParser.BOOL); }
		public TerminalNode BOOL(int i) {
			return getToken(psythonParser.BOOL, i);
		}
		public List<RelationalContext> relational() {
			return getRuleContexts(RelationalContext.class);
		}
		public RelationalContext relational(int i) {
			return getRuleContext(RelationalContext.class,i);
		}
		public TerminalNode NOT() { return getToken(psythonParser.NOT, 0); }
		public LogicalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterLogical(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitLogical(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitLogical(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalContext logical() throws RecognitionException {
		LogicalContext _localctx = new LogicalContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_logical);
		int _la;
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case ID:
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(106);
					match(ID);
					}
					break;
				case 2:
					{
					setState(107);
					match(BOOL);
					}
					break;
				case 3:
					{
					setState(108);
					relational();
					}
					break;
				}
				setState(111);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(115);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(112);
					match(ID);
					}
					break;
				case 2:
					{
					setState(113);
					match(BOOL);
					}
					break;
				case 3:
					{
					setState(114);
					relational();
					}
					break;
				}
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(NOT);
				setState(121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(118);
					match(ID);
					}
					break;
				case 2:
					{
					setState(119);
					match(BOOL);
					}
					break;
				case 3:
					{
					setState(120);
					relational();
					}
					break;
				}
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

	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(psythonParser.PRINT, 0); }
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(PRINT);
			setState(126);
			arglist();
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

	public static class Next_randContext extends ParserRuleContext {
		public TerminalNode NEXT_RAND() { return getToken(psythonParser.NEXT_RAND, 0); }
		public Next_randContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_next_rand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterNext_rand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitNext_rand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitNext_rand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Next_randContext next_rand() throws RecognitionException {
		Next_randContext _localctx = new Next_randContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_next_rand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(NEXT_RAND);
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

	public static class Seed_randContext extends ParserRuleContext {
		public TerminalNode SEED_RAND() { return getToken(psythonParser.SEED_RAND, 0); }
		public Seed_randContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seed_rand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterSeed_rand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitSeed_rand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitSeed_rand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Seed_randContext seed_rand() throws RecognitionException {
		Seed_randContext _localctx = new Seed_randContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_seed_rand);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(SEED_RAND);
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

	public static class If_then_elseContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(psythonParser.IF, 0); }
		public List<Truth_valContext> truth_val() {
			return getRuleContexts(Truth_valContext.class);
		}
		public Truth_valContext truth_val(int i) {
			return getRuleContext(Truth_valContext.class,i);
		}
		public List<TerminalNode> INDENT() { return getTokens(psythonParser.INDENT); }
		public TerminalNode INDENT(int i) {
			return getToken(psythonParser.INDENT, i);
		}
		public List<ExplistContext> explist() {
			return getRuleContexts(ExplistContext.class);
		}
		public ExplistContext explist(int i) {
			return getRuleContext(ExplistContext.class,i);
		}
		public List<TerminalNode> DEDENT() { return getTokens(psythonParser.DEDENT); }
		public TerminalNode DEDENT(int i) {
			return getToken(psythonParser.DEDENT, i);
		}
		public List<TerminalNode> ELIF() { return getTokens(psythonParser.ELIF); }
		public TerminalNode ELIF(int i) {
			return getToken(psythonParser.ELIF, i);
		}
		public TerminalNode ELSE() { return getToken(psythonParser.ELSE, 0); }
		public If_then_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_then_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterIf_then_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitIf_then_else(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitIf_then_else(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_then_elseContext if_then_else() throws RecognitionException {
		If_then_elseContext _localctx = new If_then_elseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_if_then_else);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(IF);
			setState(133);
			truth_val();
			setState(134);
			match(T__2);
			setState(135);
			match(INDENT);
			setState(136);
			explist();
			setState(137);
			match(DEDENT);
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ELIF) {
				{
				{
				setState(138);
				match(ELIF);
				setState(139);
				truth_val();
				setState(140);
				match(T__2);
				setState(141);
				match(INDENT);
				setState(142);
				explist();
				setState(143);
				match(DEDENT);
				}
				}
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(150);
				match(ELSE);
				setState(151);
				match(T__2);
				setState(152);
				match(INDENT);
				setState(153);
				explist();
				setState(154);
				match(DEDENT);
				}
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

	public static class While_expContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(psythonParser.WHILE, 0); }
		public Truth_valContext truth_val() {
			return getRuleContext(Truth_valContext.class,0);
		}
		public TerminalNode INDENT() { return getToken(psythonParser.INDENT, 0); }
		public ExplistContext explist() {
			return getRuleContext(ExplistContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(psythonParser.DEDENT, 0); }
		public While_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterWhile_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitWhile_exp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitWhile_exp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_expContext while_exp() throws RecognitionException {
		While_expContext _localctx = new While_expContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_while_exp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(WHILE);
			setState(159);
			truth_val();
			setState(160);
			match(T__2);
			setState(161);
			match(INDENT);
			setState(162);
			explist();
			setState(163);
			match(DEDENT);
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

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(psythonParser.ID, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_argument);
		try {
			setState(167);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				match(ID);
				}
				break;
			case BOOL:
			case INT:
			case STRING:
			case CHAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
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

	public static class IdlistContext extends ParserRuleContext {
		public IdlistContext idlist() {
			return getRuleContext(IdlistContext.class,0);
		}
		public TerminalNode ID() { return getToken(psythonParser.ID, 0); }
		public IdlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_idlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterIdlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitIdlist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitIdlist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdlistContext idlist() throws RecognitionException {
		IdlistContext _localctx = new IdlistContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_idlist);
		try {
			setState(174);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(T__13);
				setState(170);
				idlist();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				match(ID);
				setState(172);
				idlist();
				}
				break;
			case T__1:
			case T__3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class ArglistContext extends ParserRuleContext {
		public ArglistContext arglist() {
			return getRuleContext(ArglistContext.class,0);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public ArglistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arglist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterArglist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitArglist(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitArglist(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArglistContext arglist() throws RecognitionException {
		ArglistContext _localctx = new ArglistContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_arglist);
		try {
			setState(182);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(T__13);
				setState(177);
				arglist();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				argument();
				setState(179);
				arglist();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
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

	public static class Truth_valContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(psythonParser.ID, 0); }
		public TerminalNode BOOL() { return getToken(psythonParser.BOOL, 0); }
		public RelationalContext relational() {
			return getRuleContext(RelationalContext.class,0);
		}
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public Truth_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_truth_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterTruth_val(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitTruth_val(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitTruth_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Truth_valContext truth_val() throws RecognitionException {
		Truth_valContext _localctx = new Truth_valContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_truth_val);
		try {
			setState(188);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				match(BOOL);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				relational();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				logical();
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

	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(psythonParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(psythonParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(psythonParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(psythonParser.BOOL, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof psythonListener ) ((psythonListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof psythonVisitor ) return ((psythonVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << CHAR))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u00c3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"\64\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4A\n\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6P\n\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bc\n\b\3\t\3\t\3"+
		"\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\5\13p\n\13\3\13\3\13\3\13\3\13\5"+
		"\13v\n\13\3\13\3\13\3\13\3\13\5\13|\n\13\5\13~\n\13\3\f\3\f\3\f\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\7\17\u0094\n\17\f\17\16\17\u0097\13\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u009f\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\5\21\u00aa\n\21\3\22\3\22\3\22\3\22\3\22\5\22\u00b1\n\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u00b9\n\23\3\24\3\24\3\24\3\24\5\24\u00bf\n\24"+
		"\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(\2"+
		"\7\4\2  \"\"\3\2\7\n\3\2\13\17\3\2\35\36\4\2\21\21\"$\2\u00d1\2*\3\2\2"+
		"\2\4\63\3\2\2\2\6@\3\2\2\2\bB\3\2\2\2\nE\3\2\2\2\fU\3\2\2\2\16Z\3\2\2"+
		"\2\20d\3\2\2\2\22h\3\2\2\2\24}\3\2\2\2\26\177\3\2\2\2\30\u0082\3\2\2\2"+
		"\32\u0084\3\2\2\2\34\u0086\3\2\2\2\36\u00a0\3\2\2\2 \u00a9\3\2\2\2\"\u00b0"+
		"\3\2\2\2$\u00b8\3\2\2\2&\u00be\3\2\2\2(\u00c0\3\2\2\2*+\5\4\3\2+,\7\2"+
		"\2\3,\3\3\2\2\2-.\5\6\4\2./\5\4\3\2/\64\3\2\2\2\60\61\7!\2\2\61\64\5\4"+
		"\3\2\62\64\3\2\2\2\63-\3\2\2\2\63\60\3\2\2\2\63\62\3\2\2\2\64\5\3\2\2"+
		"\2\65A\5\f\7\2\66A\5\16\b\2\67A\5\n\6\28A\5\20\t\29A\5\22\n\2:A\5\24\13"+
		"\2;A\5\26\f\2<A\5\34\17\2=A\5\36\20\2>A\5\30\r\2?A\5\32\16\2@\65\3\2\2"+
		"\2@\66\3\2\2\2@\67\3\2\2\2@8\3\2\2\2@9\3\2\2\2@:\3\2\2\2@;\3\2\2\2@<\3"+
		"\2\2\2@=\3\2\2\2@>\3\2\2\2@?\3\2\2\2A\7\3\2\2\2BC\7\27\2\2CD\5$\23\2D"+
		"\t\3\2\2\2EF\7\30\2\2FG\7 \2\2GH\7\3\2\2HI\5\"\22\2IJ\7\4\2\2JK\7\5\2"+
		"\2KL\7\'\2\2LO\5\4\3\2MP\7!\2\2NP\3\2\2\2OM\3\2\2\2ON\3\2\2\2PQ\3\2\2"+
		"\2QR\5\b\5\2RS\7!\2\2ST\7(\2\2T\13\3\2\2\2UV\7 \2\2VW\7\3\2\2WX\5$\23"+
		"\2XY\7\4\2\2Y\r\3\2\2\2Z[\5\"\22\2[b\7\6\2\2\\c\7 \2\2]c\5(\25\2^c\5\20"+
		"\t\2_c\5\22\n\2`c\5\24\13\2ac\5\f\7\2b\\\3\2\2\2b]\3\2\2\2b^\3\2\2\2b"+
		"_\3\2\2\2b`\3\2\2\2ba\3\2\2\2c\17\3\2\2\2de\t\2\2\2ef\t\3\2\2fg\t\2\2"+
		"\2g\21\3\2\2\2hi\t\2\2\2ij\t\4\2\2jk\t\2\2\2k\23\3\2\2\2lp\7 \2\2mp\7"+
		"\21\2\2np\5\22\n\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2pq\3\2\2\2qu\t\5\2\2r"+
		"v\7 \2\2sv\7\21\2\2tv\5\22\n\2ur\3\2\2\2us\3\2\2\2ut\3\2\2\2v~\3\2\2\2"+
		"w{\7\37\2\2x|\7 \2\2y|\7\21\2\2z|\5\22\n\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2"+
		"\2|~\3\2\2\2}o\3\2\2\2}w\3\2\2\2~\25\3\2\2\2\177\u0080\7\32\2\2\u0080"+
		"\u0081\5$\23\2\u0081\27\3\2\2\2\u0082\u0083\7\22\2\2\u0083\31\3\2\2\2"+
		"\u0084\u0085\7\23\2\2\u0085\33\3\2\2\2\u0086\u0087\7\24\2\2\u0087\u0088"+
		"\5&\24\2\u0088\u0089\7\5\2\2\u0089\u008a\7\'\2\2\u008a\u008b\5\4\3\2\u008b"+
		"\u0095\7(\2\2\u008c\u008d\7\25\2\2\u008d\u008e\5&\24\2\u008e\u008f\7\5"+
		"\2\2\u008f\u0090\7\'\2\2\u0090\u0091\5\4\3\2\u0091\u0092\7(\2\2\u0092"+
		"\u0094\3\2\2\2\u0093\u008c\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096\u009e\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
		"\u0099\7\26\2\2\u0099\u009a\7\5\2\2\u009a\u009b\7\'\2\2\u009b\u009c\5"+
		"\4\3\2\u009c\u009d\7(\2\2\u009d\u009f\3\2\2\2\u009e\u0098\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\35\3\2\2\2\u00a0\u00a1\7\31\2\2\u00a1\u00a2\5&\24"+
		"\2\u00a2\u00a3\7\5\2\2\u00a3\u00a4\7\'\2\2\u00a4\u00a5\5\4\3\2\u00a5\u00a6"+
		"\7(\2\2\u00a6\37\3\2\2\2\u00a7\u00aa\7 \2\2\u00a8\u00aa\5(\25\2\u00a9"+
		"\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa!\3\2\2\2\u00ab\u00ac\7\20\2\2"+
		"\u00ac\u00b1\5\"\22\2\u00ad\u00ae\7 \2\2\u00ae\u00b1\5\"\22\2\u00af\u00b1"+
		"\3\2\2\2\u00b0\u00ab\3\2\2\2\u00b0\u00ad\3\2\2\2\u00b0\u00af\3\2\2\2\u00b1"+
		"#\3\2\2\2\u00b2\u00b3\7\20\2\2\u00b3\u00b9\5$\23\2\u00b4\u00b5\5 \21\2"+
		"\u00b5\u00b6\5$\23\2\u00b6\u00b9\3\2\2\2\u00b7\u00b9\3\2\2\2\u00b8\u00b2"+
		"\3\2\2\2\u00b8\u00b4\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9%\3\2\2\2\u00ba"+
		"\u00bf\7 \2\2\u00bb\u00bf\7\21\2\2\u00bc\u00bf\5\22\n\2\u00bd\u00bf\5"+
		"\24\13\2\u00be\u00ba\3\2\2\2\u00be\u00bb\3\2\2\2\u00be\u00bc\3\2\2\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\'\3\2\2\2\u00c0\u00c1\t\6\2\2\u00c1)\3\2\2\2\20\63"+
		"@Obou{}\u0095\u009e\u00a9\u00b0\u00b8\u00be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}