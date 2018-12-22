// Generated from C:/Users/mocli/Code/psython2/src/parser\psython.g4 by ANTLR 4.7
package parser;

import helper.*;
import ast.expression.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class psythonLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, BOOL=15, NEXT_RAND=16, 
		SEED_RAND=17, IF=18, ELIF=19, ELSE=20, RETURN=21, DEF=22, WHILE=23, PRINT=24, 
		TRUE=25, FALSE=26, AND=27, OR=28, NOT=29, ID=30, NL=31, INT=32, STRING=33, 
		CHAR=34, WS=35, COMMENT=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "BOOL", "NEXT_RAND", "SEED_RAND", 
		"IF", "ELIF", "ELSE", "RETURN", "DEF", "WHILE", "PRINT", "TRUE", "FALSE", 
		"AND", "OR", "NOT", "ID", "NL", "INT", "STRING", "CHAR", "WS", "COMMENT", 
		"HEX_DIGIT", "ESC_SEQ", "OCTAL_ESC", "UNICODE_ESC"
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
		"ID", "NL", "INT", "STRING", "CHAR", "WS", "COMMENT"
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


	  private final DenterHelper denter = DenterHelper.builder()
	    .nl(NL)
	    .indent(psythonParser.INDENT)
	    .dedent(psythonParser.DEDENT)
	    .pullToken(psythonLexer.super::nextToken);

	  @Override
	  public Token nextToken() {
	    return denter.nextToken();
	  }


	public psythonLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "psython.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u011b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3\20\5\20u\n\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\7\37\u00bf\n\37\f\37\16\37\u00c2\13\37\3 \5 \u00c5\n \3 \6"+
		" \u00c8\n \r \16 \u00c9\3 \7 \u00cd\n \f \16 \u00d0\13 \3!\6!\u00d3\n"+
		"!\r!\16!\u00d4\3\"\3\"\3\"\7\"\u00da\n\"\f\"\16\"\u00dd\13\"\3\"\3\"\3"+
		"#\3#\3#\5#\u00e4\n#\3#\3#\3$\6$\u00e9\n$\r$\16$\u00ea\3$\3$\3%\3%\7%\u00f1"+
		"\n%\f%\16%\u00f4\13%\3%\5%\u00f7\n%\3%\3%\3%\3%\3&\3&\3\'\3\'\3\'\3\'"+
		"\3\'\5\'\u0104\n\'\3\'\3\'\5\'\u0108\n\'\3(\3(\3(\3(\3(\3(\3(\3(\3(\5"+
		"(\u0113\n(\3)\3)\3)\3)\3)\3)\3)\2\2*\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\2M\2O\2Q\2\3\2\n"+
		"\5\2C\\aac|\6\2\62;C\\aac|\4\2$$^^\4\2))^^\4\2\13\13\"\"\4\2\f\f\17\17"+
		"\5\2\62;CHch\7\2ddhhppttvv\2\u0128\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3S\3\2\2\2\5U\3\2\2\2\7"+
		"W\3\2\2\2\tY\3\2\2\2\13[\3\2\2\2\r]\3\2\2\2\17_\3\2\2\2\21a\3\2\2\2\23"+
		"c\3\2\2\2\25e\3\2\2\2\27h\3\2\2\2\31k\3\2\2\2\33m\3\2\2\2\35p\3\2\2\2"+
		"\37t\3\2\2\2!v\3\2\2\2#|\3\2\2\2%\u0082\3\2\2\2\'\u0085\3\2\2\2)\u008a"+
		"\3\2\2\2+\u008f\3\2\2\2-\u0096\3\2\2\2/\u009a\3\2\2\2\61\u00a0\3\2\2\2"+
		"\63\u00a6\3\2\2\2\65\u00ab\3\2\2\2\67\u00b1\3\2\2\29\u00b5\3\2\2\2;\u00b8"+
		"\3\2\2\2=\u00bc\3\2\2\2?\u00c4\3\2\2\2A\u00d2\3\2\2\2C\u00d6\3\2\2\2E"+
		"\u00e0\3\2\2\2G\u00e8\3\2\2\2I\u00ee\3\2\2\2K\u00fc\3\2\2\2M\u0107\3\2"+
		"\2\2O\u0112\3\2\2\2Q\u0114\3\2\2\2ST\7*\2\2T\4\3\2\2\2UV\7+\2\2V\6\3\2"+
		"\2\2WX\7<\2\2X\b\3\2\2\2YZ\7?\2\2Z\n\3\2\2\2[\\\7-\2\2\\\f\3\2\2\2]^\7"+
		"/\2\2^\16\3\2\2\2_`\7,\2\2`\20\3\2\2\2ab\7\61\2\2b\22\3\2\2\2cd\7@\2\2"+
		"d\24\3\2\2\2ef\7@\2\2fg\7?\2\2g\26\3\2\2\2hi\7?\2\2ij\7?\2\2j\30\3\2\2"+
		"\2kl\7>\2\2l\32\3\2\2\2mn\7>\2\2no\7?\2\2o\34\3\2\2\2pq\7.\2\2q\36\3\2"+
		"\2\2ru\5\63\32\2su\5\65\33\2tr\3\2\2\2ts\3\2\2\2u \3\2\2\2vw\7p\2\2wx"+
		"\7g\2\2xy\7z\2\2yz\7v\2\2z{\7t\2\2{\"\3\2\2\2|}\7u\2\2}~\7g\2\2~\177\7"+
		"g\2\2\177\u0080\7f\2\2\u0080\u0081\7t\2\2\u0081$\3\2\2\2\u0082\u0083\7"+
		"k\2\2\u0083\u0084\7h\2\2\u0084&\3\2\2\2\u0085\u0086\7g\2\2\u0086\u0087"+
		"\7n\2\2\u0087\u0088\7k\2\2\u0088\u0089\7h\2\2\u0089(\3\2\2\2\u008a\u008b"+
		"\7g\2\2\u008b\u008c\7n\2\2\u008c\u008d\7u\2\2\u008d\u008e\7g\2\2\u008e"+
		"*\3\2\2\2\u008f\u0090\7t\2\2\u0090\u0091\7g\2\2\u0091\u0092\7v\2\2\u0092"+
		"\u0093\7w\2\2\u0093\u0094\7t\2\2\u0094\u0095\7p\2\2\u0095,\3\2\2\2\u0096"+
		"\u0097\7f\2\2\u0097\u0098\7g\2\2\u0098\u0099\7h\2\2\u0099.\3\2\2\2\u009a"+
		"\u009b\7y\2\2\u009b\u009c\7j\2\2\u009c\u009d\7k\2\2\u009d\u009e\7n\2\2"+
		"\u009e\u009f\7g\2\2\u009f\60\3\2\2\2\u00a0\u00a1\7r\2\2\u00a1\u00a2\7"+
		"t\2\2\u00a2\u00a3\7k\2\2\u00a3\u00a4\7p\2\2\u00a4\u00a5\7v\2\2\u00a5\62"+
		"\3\2\2\2\u00a6\u00a7\7V\2\2\u00a7\u00a8\7t\2\2\u00a8\u00a9\7w\2\2\u00a9"+
		"\u00aa\7g\2\2\u00aa\64\3\2\2\2\u00ab\u00ac\7H\2\2\u00ac\u00ad\7c\2\2\u00ad"+
		"\u00ae\7n\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0\66\3\2\2\2\u00b1"+
		"\u00b2\7c\2\2\u00b2\u00b3\7p\2\2\u00b3\u00b4\7f\2\2\u00b48\3\2\2\2\u00b5"+
		"\u00b6\7q\2\2\u00b6\u00b7\7t\2\2\u00b7:\3\2\2\2\u00b8\u00b9\7p\2\2\u00b9"+
		"\u00ba\7q\2\2\u00ba\u00bb\7v\2\2\u00bb<\3\2\2\2\u00bc\u00c0\t\2\2\2\u00bd"+
		"\u00bf\t\3\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2\3\2\2\2\u00c0\u00be\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1>\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c5"+
		"\7\17\2\2\u00c4\u00c3\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c7\3\2\2\2"+
		"\u00c6\u00c8\7\f\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00c7"+
		"\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00cd\7\"\2\2\u00cc"+
		"\u00cb\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2"+
		"\2\2\u00cf@\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d3\4\62;\2\u00d2\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5"+
		"B\3\2\2\2\u00d6\u00db\7$\2\2\u00d7\u00da\5M\'\2\u00d8\u00da\n\4\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2"+
		"\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de"+
		"\u00df\7$\2\2\u00dfD\3\2\2\2\u00e0\u00e3\7)\2\2\u00e1\u00e4\5M\'\2\u00e2"+
		"\u00e4\n\5\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e6\7)\2\2\u00e6F\3\2\2\2\u00e7\u00e9\t\6\2\2\u00e8\u00e7"+
		"\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00ed\b$\2\2\u00edH\3\2\2\2\u00ee\u00f2\7%\2\2\u00ef"+
		"\u00f1\n\7\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2"+
		"\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\u00f7\7\17\2\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f8\3"+
		"\2\2\2\u00f8\u00f9\7\f\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fb\b%\2\2\u00fb"+
		"J\3\2\2\2\u00fc\u00fd\t\b\2\2\u00fdL\3\2\2\2\u00fe\u0103\7^\2\2\u00ff"+
		"\u0104\t\t\2\2\u0100\u0101\7^\2\2\u0101\u0104\7$\2\2\u0102\u0104\t\5\2"+
		"\2\u0103\u00ff\3\2\2\2\u0103\u0100\3\2\2\2\u0103\u0102\3\2\2\2\u0104\u0108"+
		"\3\2\2\2\u0105\u0108\5Q)\2\u0106\u0108\5O(\2\u0107\u00fe\3\2\2\2\u0107"+
		"\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108N\3\2\2\2\u0109\u010a\7^\2\2\u010a"+
		"\u010b\4\62\65\2\u010b\u010c\4\629\2\u010c\u0113\4\629\2\u010d\u010e\7"+
		"^\2\2\u010e\u010f\4\629\2\u010f\u0113\4\629\2\u0110\u0111\7^\2\2\u0111"+
		"\u0113\4\629\2\u0112\u0109\3\2\2\2\u0112\u010d\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0113P\3\2\2\2\u0114\u0115\7^\2\2\u0115\u0116\7w\2\2\u0116\u0117"+
		"\5K&\2\u0117\u0118\5K&\2\u0118\u0119\5K&\2\u0119\u011a\5K&\2\u011aR\3"+
		"\2\2\2\22\2t\u00c0\u00c4\u00c9\u00ce\u00d4\u00d9\u00db\u00e3\u00ea\u00f2"+
		"\u00f6\u0103\u0107\u0112\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}