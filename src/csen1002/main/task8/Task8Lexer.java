// Generated from F:/Gam3a/Sem 10/Compilers/lab/labCode/src/csen1002/main/task8\Task8.g4 by ANTLR 4.12.0
package csen1002.main.task8;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Task8Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, IF=2, ELSE=3, LP=4, RP=5, COMP=6, ID=7, NUM=8, LIT=9, BLANK=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "IF", "ELSE", "LP", "RP", "COMP", "ID", "NUM", "LIT", "BLANK", 
			"LETTER", "DIGIT", "ELSEE", "LITT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'it is an empty rule'", null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "IF", "ELSE", "LP", "RP", "COMP", "ID", "NUM", "LIT", "BLANK"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public Task8Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Task8.g4"; }

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
		"\u0004\u0000\n\u008d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001:\b\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005K\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006O\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006T\b\u0006\n\u0006\f\u0006"+
		"W\t\u0006\u0001\u0007\u0004\u0007Z\b\u0007\u000b\u0007\f\u0007[\u0001"+
		"\u0007\u0001\u0007\u0004\u0007`\b\u0007\u000b\u0007\f\u0007a\u0003\u0007"+
		"d\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007h\b\u0007\u0001\u0007\u0004"+
		"\u0007k\b\u0007\u000b\u0007\f\u0007l\u0003\u0007o\b\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0005\bt\b\b\n\b\f\bw\t\b\u0001\b\u0001\b\u0001\t\u0004\t|"+
		"\b\t\u000b\t\f\t}\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0000"+
		"\u0000\u000e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b"+
		"\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u0000\u0017\u0000\u0019\u0000"+
		"\u001b\u0000\u0001\u0000\t\u0002\u0000<<>>\u0002\u0000EEee\u0002\u0000"+
		"++--\u0002\u0000\"\"\\\\\u0003\u0000\t\n\r\r  \u0002\u0000AZaz\u0001\u0000"+
		"09\u0002\u0000LLll\u0002\u0000SSss\u009c\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0001\u001d\u0001\u0000\u0000\u0000\u0003"+
		"9\u0001\u0000\u0000\u0000\u0005;\u0001\u0000\u0000\u0000\u0007=\u0001"+
		"\u0000\u0000\u0000\t?\u0001\u0000\u0000\u0000\u000bJ\u0001\u0000\u0000"+
		"\u0000\rN\u0001\u0000\u0000\u0000\u000fY\u0001\u0000\u0000\u0000\u0011"+
		"p\u0001\u0000\u0000\u0000\u0013{\u0001\u0000\u0000\u0000\u0015\u0081\u0001"+
		"\u0000\u0000\u0000\u0017\u0083\u0001\u0000\u0000\u0000\u0019\u0085\u0001"+
		"\u0000\u0000\u0000\u001b\u008a\u0001\u0000\u0000\u0000\u001d\u001e\u0005"+
		"i\u0000\u0000\u001e\u001f\u0005t\u0000\u0000\u001f \u0005 \u0000\u0000"+
		" !\u0005i\u0000\u0000!\"\u0005s\u0000\u0000\"#\u0005 \u0000\u0000#$\u0005"+
		"a\u0000\u0000$%\u0005n\u0000\u0000%&\u0005 \u0000\u0000&\'\u0005e\u0000"+
		"\u0000\'(\u0005m\u0000\u0000()\u0005p\u0000\u0000)*\u0005t\u0000\u0000"+
		"*+\u0005y\u0000\u0000+,\u0005 \u0000\u0000,-\u0005r\u0000\u0000-.\u0005"+
		"u\u0000\u0000./\u0005l\u0000\u0000/0\u0005e\u0000\u00000\u0002\u0001\u0000"+
		"\u0000\u000012\u0005i\u0000\u00002:\u0005f\u0000\u000034\u0005I\u0000"+
		"\u00004:\u0005f\u0000\u000056\u0005i\u0000\u00006:\u0005F\u0000\u0000"+
		"78\u0005I\u0000\u00008:\u0005F\u0000\u000091\u0001\u0000\u0000\u00009"+
		"3\u0001\u0000\u0000\u000095\u0001\u0000\u0000\u000097\u0001\u0000\u0000"+
		"\u0000:\u0004\u0001\u0000\u0000\u0000;<\u0003\u0019\f\u0000<\u0006\u0001"+
		"\u0000\u0000\u0000=>\u0005(\u0000\u0000>\b\u0001\u0000\u0000\u0000?@\u0005"+
		")\u0000\u0000@\n\u0001\u0000\u0000\u0000AK\u0007\u0000\u0000\u0000BC\u0005"+
		">\u0000\u0000CK\u0005=\u0000\u0000DE\u0005<\u0000\u0000EK\u0005=\u0000"+
		"\u0000FG\u0005=\u0000\u0000GK\u0005=\u0000\u0000HI\u0005!\u0000\u0000"+
		"IK\u0005=\u0000\u0000JA\u0001\u0000\u0000\u0000JB\u0001\u0000\u0000\u0000"+
		"JD\u0001\u0000\u0000\u0000JF\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000"+
		"\u0000K\f\u0001\u0000\u0000\u0000LO\u0003\u0015\n\u0000MO\u0005_\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000NM\u0001\u0000\u0000\u0000OU\u0001\u0000"+
		"\u0000\u0000PT\u0003\u0015\n\u0000QT\u0003\u0017\u000b\u0000RT\u0005_"+
		"\u0000\u0000SP\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000SR\u0001"+
		"\u0000\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000"+
		"UV\u0001\u0000\u0000\u0000V\u000e\u0001\u0000\u0000\u0000WU\u0001\u0000"+
		"\u0000\u0000XZ\u0003\u0017\u000b\u0000YX\u0001\u0000\u0000\u0000Z[\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\c\u0001\u0000\u0000\u0000]_\u0005.\u0000\u0000^`\u0003\u0017\u000b\u0000"+
		"_^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000"+
		"\u0000ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000c]\u0001\u0000"+
		"\u0000\u0000cd\u0001\u0000\u0000\u0000dn\u0001\u0000\u0000\u0000eg\u0007"+
		"\u0001\u0000\u0000fh\u0007\u0002\u0000\u0000gf\u0001\u0000\u0000\u0000"+
		"gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000ik\u0003\u0017\u000b"+
		"\u0000ji\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lj\u0001\u0000"+
		"\u0000\u0000lm\u0001\u0000\u0000\u0000mo\u0001\u0000\u0000\u0000ne\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u0010\u0001\u0000\u0000"+
		"\u0000pu\u0005\"\u0000\u0000qt\u0003\u001b\r\u0000rt\b\u0003\u0000\u0000"+
		"sq\u0001\u0000\u0000\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000\u0000"+
		"\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001\u0000"+
		"\u0000\u0000wu\u0001\u0000\u0000\u0000xy\u0005\"\u0000\u0000y\u0012\u0001"+
		"\u0000\u0000\u0000z|\u0007\u0004\u0000\u0000{z\u0001\u0000\u0000\u0000"+
		"|}\u0001\u0000\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000"+
		"\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0080\u0006\t\u0000\u0000"+
		"\u0080\u0014\u0001\u0000\u0000\u0000\u0081\u0082\u0007\u0005\u0000\u0000"+
		"\u0082\u0016\u0001\u0000\u0000\u0000\u0083\u0084\u0007\u0006\u0000\u0000"+
		"\u0084\u0018\u0001\u0000\u0000\u0000\u0085\u0086\u0007\u0001\u0000\u0000"+
		"\u0086\u0087\u0007\u0007\u0000\u0000\u0087\u0088\u0007\b\u0000\u0000\u0088"+
		"\u0089\u0007\u0001\u0000\u0000\u0089\u001a\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0005\\\u0000\u0000\u008b\u008c\u0007\u0003\u0000\u0000\u008c\u001c"+
		"\u0001\u0000\u0000\u0000\u000f\u00009JNSU[acglnsu}\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}