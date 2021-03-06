// Generated from gram.g4 by ANTLR 4.7.1
package database;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class gramLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, ALPHA=29, DIGIT=30, INTEGER=31, 
		OP=32, WS=33, POINTER=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "ALPHA", "DIGIT", "INTEGER", "OP", "WS", "POINTER"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'SELECT'", "'PROJECT'", "'RENAME'", "'+'", "'-'", "'*'", "'&'", 
		"'OPEN'", "'CLOSE'", "'WRITE'", "'EXIT'", "'SHOW'", "'CREATE TABLE'", 
		"'PRIMARY KEY'", "'UPDATE'", "'SET'", "'='", "','", "'WHERE'", "'INSERT INTO'", 
		"'VALUES FROM'", "'VALUES FROM RELATION'", "'DELETE FROM'", "'_'", "'||'", 
		"'&&'", "'VARCHAR '", "'INTEGER'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, "ALPHA", "DIGIT", "INTEGER", "OP", "WS", 
		"POINTER"
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


	public gramLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "gram.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u012e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3 \6 \u0106\n \r \16 \u0107\3!\7!\u010b\n!\f!\16!\u010e\13!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\5!\u0119\n!\3!\7!\u011c\n!\f!\16!\u011f\13!\3\""+
		"\6\"\u0122\n\"\r\"\16\"\u0123\3#\7#\u0127\n#\f#\16#\u012a\13#\3#\3#\3"+
		"#\2\2$\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37= ?!A\"C#E$\3\2\5\4\2C\\c|\4\2>>@@\5\2\13\f\17\17\"\"\2\u0136"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2"+
		"\2\5N\3\2\2\2\7V\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17c\3\2\2\2"+
		"\21e\3\2\2\2\23j\3\2\2\2\25p\3\2\2\2\27v\3\2\2\2\31{\3\2\2\2\33\u0080"+
		"\3\2\2\2\35\u008d\3\2\2\2\37\u0099\3\2\2\2!\u00a0\3\2\2\2#\u00a4\3\2\2"+
		"\2%\u00a6\3\2\2\2\'\u00a8\3\2\2\2)\u00ae\3\2\2\2+\u00ba\3\2\2\2-\u00c6"+
		"\3\2\2\2/\u00db\3\2\2\2\61\u00e7\3\2\2\2\63\u00e9\3\2\2\2\65\u00ec\3\2"+
		"\2\2\67\u00ef\3\2\2\29\u00f8\3\2\2\2;\u0100\3\2\2\2=\u0102\3\2\2\2?\u0105"+
		"\3\2\2\2A\u010c\3\2\2\2C\u0121\3\2\2\2E\u0128\3\2\2\2GH\7U\2\2HI\7G\2"+
		"\2IJ\7N\2\2JK\7G\2\2KL\7E\2\2LM\7V\2\2M\4\3\2\2\2NO\7R\2\2OP\7T\2\2PQ"+
		"\7Q\2\2QR\7L\2\2RS\7G\2\2ST\7E\2\2TU\7V\2\2U\6\3\2\2\2VW\7T\2\2WX\7G\2"+
		"\2XY\7P\2\2YZ\7C\2\2Z[\7O\2\2[\\\7G\2\2\\\b\3\2\2\2]^\7-\2\2^\n\3\2\2"+
		"\2_`\7/\2\2`\f\3\2\2\2ab\7,\2\2b\16\3\2\2\2cd\7(\2\2d\20\3\2\2\2ef\7Q"+
		"\2\2fg\7R\2\2gh\7G\2\2hi\7P\2\2i\22\3\2\2\2jk\7E\2\2kl\7N\2\2lm\7Q\2\2"+
		"mn\7U\2\2no\7G\2\2o\24\3\2\2\2pq\7Y\2\2qr\7T\2\2rs\7K\2\2st\7V\2\2tu\7"+
		"G\2\2u\26\3\2\2\2vw\7G\2\2wx\7Z\2\2xy\7K\2\2yz\7V\2\2z\30\3\2\2\2{|\7"+
		"U\2\2|}\7J\2\2}~\7Q\2\2~\177\7Y\2\2\177\32\3\2\2\2\u0080\u0081\7E\2\2"+
		"\u0081\u0082\7T\2\2\u0082\u0083\7G\2\2\u0083\u0084\7C\2\2\u0084\u0085"+
		"\7V\2\2\u0085\u0086\7G\2\2\u0086\u0087\7\"\2\2\u0087\u0088\7V\2\2\u0088"+
		"\u0089\7C\2\2\u0089\u008a\7D\2\2\u008a\u008b\7N\2\2\u008b\u008c\7G\2\2"+
		"\u008c\34\3\2\2\2\u008d\u008e\7R\2\2\u008e\u008f\7T\2\2\u008f\u0090\7"+
		"K\2\2\u0090\u0091\7O\2\2\u0091\u0092\7C\2\2\u0092\u0093\7T\2\2\u0093\u0094"+
		"\7[\2\2\u0094\u0095\7\"\2\2\u0095\u0096\7M\2\2\u0096\u0097\7G\2\2\u0097"+
		"\u0098\7[\2\2\u0098\36\3\2\2\2\u0099\u009a\7W\2\2\u009a\u009b\7R\2\2\u009b"+
		"\u009c\7F\2\2\u009c\u009d\7C\2\2\u009d\u009e\7V\2\2\u009e\u009f\7G\2\2"+
		"\u009f \3\2\2\2\u00a0\u00a1\7U\2\2\u00a1\u00a2\7G\2\2\u00a2\u00a3\7V\2"+
		"\2\u00a3\"\3\2\2\2\u00a4\u00a5\7?\2\2\u00a5$\3\2\2\2\u00a6\u00a7\7.\2"+
		"\2\u00a7&\3\2\2\2\u00a8\u00a9\7Y\2\2\u00a9\u00aa\7J\2\2\u00aa\u00ab\7"+
		"G\2\2\u00ab\u00ac\7T\2\2\u00ac\u00ad\7G\2\2\u00ad(\3\2\2\2\u00ae\u00af"+
		"\7K\2\2\u00af\u00b0\7P\2\2\u00b0\u00b1\7U\2\2\u00b1\u00b2\7G\2\2\u00b2"+
		"\u00b3\7T\2\2\u00b3\u00b4\7V\2\2\u00b4\u00b5\7\"\2\2\u00b5\u00b6\7K\2"+
		"\2\u00b6\u00b7\7P\2\2\u00b7\u00b8\7V\2\2\u00b8\u00b9\7Q\2\2\u00b9*\3\2"+
		"\2\2\u00ba\u00bb\7X\2\2\u00bb\u00bc\7C\2\2\u00bc\u00bd\7N\2\2\u00bd\u00be"+
		"\7W\2\2\u00be\u00bf\7G\2\2\u00bf\u00c0\7U\2\2\u00c0\u00c1\7\"\2\2\u00c1"+
		"\u00c2\7H\2\2\u00c2\u00c3\7T\2\2\u00c3\u00c4\7Q\2\2\u00c4\u00c5\7O\2\2"+
		"\u00c5,\3\2\2\2\u00c6\u00c7\7X\2\2\u00c7\u00c8\7C\2\2\u00c8\u00c9\7N\2"+
		"\2\u00c9\u00ca\7W\2\2\u00ca\u00cb\7G\2\2\u00cb\u00cc\7U\2\2\u00cc\u00cd"+
		"\7\"\2\2\u00cd\u00ce\7H\2\2\u00ce\u00cf\7T\2\2\u00cf\u00d0\7Q\2\2\u00d0"+
		"\u00d1\7O\2\2\u00d1\u00d2\7\"\2\2\u00d2\u00d3\7T\2\2\u00d3\u00d4\7G\2"+
		"\2\u00d4\u00d5\7N\2\2\u00d5\u00d6\7C\2\2\u00d6\u00d7\7V\2\2\u00d7\u00d8"+
		"\7K\2\2\u00d8\u00d9\7Q\2\2\u00d9\u00da\7P\2\2\u00da.\3\2\2\2\u00db\u00dc"+
		"\7F\2\2\u00dc\u00dd\7G\2\2\u00dd\u00de\7N\2\2\u00de\u00df\7G\2\2\u00df"+
		"\u00e0\7V\2\2\u00e0\u00e1\7G\2\2\u00e1\u00e2\7\"\2\2\u00e2\u00e3\7H\2"+
		"\2\u00e3\u00e4\7T\2\2\u00e4\u00e5\7Q\2\2\u00e5\u00e6\7O\2\2\u00e6\60\3"+
		"\2\2\2\u00e7\u00e8\7a\2\2\u00e8\62\3\2\2\2\u00e9\u00ea\7~\2\2\u00ea\u00eb"+
		"\7~\2\2\u00eb\64\3\2\2\2\u00ec\u00ed\7(\2\2\u00ed\u00ee\7(\2\2\u00ee\66"+
		"\3\2\2\2\u00ef\u00f0\7X\2\2\u00f0\u00f1\7C\2\2\u00f1\u00f2\7T\2\2\u00f2"+
		"\u00f3\7E\2\2\u00f3\u00f4\7J\2\2\u00f4\u00f5\7C\2\2\u00f5\u00f6\7T\2\2"+
		"\u00f6\u00f7\7\"\2\2\u00f78\3\2\2\2\u00f8\u00f9\7K\2\2\u00f9\u00fa\7P"+
		"\2\2\u00fa\u00fb\7V\2\2\u00fb\u00fc\7G\2\2\u00fc\u00fd\7I\2\2\u00fd\u00fe"+
		"\7G\2\2\u00fe\u00ff\7T\2\2\u00ff:\3\2\2\2\u0100\u0101\t\2\2\2\u0101<\3"+
		"\2\2\2\u0102\u0103\4\62;\2\u0103>\3\2\2\2\u0104\u0106\5=\37\2\u0105\u0104"+
		"\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108"+
		"@\3\2\2\2\u0109\u010b\5C\"\2\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c"+
		"\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0118\3\2\2\2\u010e\u010c\3\2"+
		"\2\2\u010f\u0110\7?\2\2\u0110\u0119\7?\2\2\u0111\u0112\7#\2\2\u0112\u0119"+
		"\7?\2\2\u0113\u0119\t\3\2\2\u0114\u0115\7>\2\2\u0115\u0119\7?\2\2\u0116"+
		"\u0117\7@\2\2\u0117\u0119\7?\2\2\u0118\u010f\3\2\2\2\u0118\u0111\3\2\2"+
		"\2\u0118\u0113\3\2\2\2\u0118\u0114\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011d"+
		"\3\2\2\2\u011a\u011c\5C\"\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011eB\3\2\2\2\u011f\u011d\3\2\2\2"+
		"\u0120\u0122\t\4\2\2\u0121\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0123\u0124\3\2\2\2\u0124D\3\2\2\2\u0125\u0127\5C\"\2\u0126\u0125"+
		"\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c\7>\2\2\u012c\u012d\7/\2"+
		"\2\u012dF\3\2\2\2\t\2\u0107\u010c\u0118\u011d\u0123\u0128\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}