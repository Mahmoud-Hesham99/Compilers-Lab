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
		E_MAIL=1, ID=2, WS=3;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"E_MAIL", "ID", "WS", "USERNAME", "SUBDOMAIN", "STUDENT", "BERLIN", "DOMAIN", 
			"BATCH", "APPNUMBER", "NONZERO", "DIGIT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "E_MAIL", "ID", "WS"
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
		"\u0004\u0000\u0003g\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000\u001f\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0004\u0002(\b\u0002\u000b\u0002"+
		"\f\u0002)\u0001\u0002\u0001\u0002\u0001\u0003\u0004\u0003/\b\u0003\u000b"+
		"\u0003\f\u00030\u0001\u0003\u0001\u0003\u0004\u00035\b\u0003\u000b\u0003"+
		"\f\u00036\u0001\u0004\u0001\u0004\u0003\u0004;\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0003\bX\b\b\u0001\b\u0001\b\u0001\t\u0003\t]\b\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0000\u0000\f\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0000\t\u0000"+
		"\u000b\u0000\r\u0000\u000f\u0000\u0011\u0000\u0013\u0000\u0015\u0000\u0017"+
		"\u0000\u0001\u0000\u0010\u0003\u0000\t\n\r\r  \u0003\u0000--AZaz\u0002"+
		"\u0000SSss\u0002\u0000TTtt\u0002\u0000UUuu\u0002\u0000DDdd\u0002\u0000"+
		"EEee\u0002\u0000NNnn\u0002\u0000BBbb\u0002\u0000RRrr\u0002\u0000LLll\u0002"+
		"\u0000IIii\u0002\u0000GGgg\u0002\u0000CCcc\u0001\u000019\u0001\u00000"+
		"9d\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0001\u0019\u0001\u0000\u0000\u0000"+
		"\u0003\"\u0001\u0000\u0000\u0000\u0005\'\u0001\u0000\u0000\u0000\u0007"+
		".\u0001\u0000\u0000\u0000\t:\u0001\u0000\u0000\u0000\u000b<\u0001\u0000"+
		"\u0000\u0000\rD\u0001\u0000\u0000\u0000\u000fK\u0001\u0000\u0000\u0000"+
		"\u0011W\u0001\u0000\u0000\u0000\u0013\\\u0001\u0000\u0000\u0000\u0015"+
		"c\u0001\u0000\u0000\u0000\u0017e\u0001\u0000\u0000\u0000\u0019\u001a\u0003"+
		"\u0007\u0003\u0000\u001a\u001e\u0005@\u0000\u0000\u001b\u001c\u0003\t"+
		"\u0004\u0000\u001c\u001d\u0005.\u0000\u0000\u001d\u001f\u0001\u0000\u0000"+
		"\u0000\u001e\u001b\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000"+
		"\u0000\u001f \u0001\u0000\u0000\u0000 !\u0003\u000f\u0007\u0000!\u0002"+
		"\u0001\u0000\u0000\u0000\"#\u0003\u0011\b\u0000#$\u0005-\u0000\u0000$"+
		"%\u0003\u0013\t\u0000%\u0004\u0001\u0000\u0000\u0000&(\u0007\u0000\u0000"+
		"\u0000\'&\u0001\u0000\u0000\u0000()\u0001\u0000\u0000\u0000)\'\u0001\u0000"+
		"\u0000\u0000)*\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000+,\u0006"+
		"\u0002\u0000\u0000,\u0006\u0001\u0000\u0000\u0000-/\u0007\u0001\u0000"+
		"\u0000.-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000.\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0005"+
		".\u0000\u000035\u0007\u0001\u0000\u000043\u0001\u0000\u0000\u000056\u0001"+
		"\u0000\u0000\u000064\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"7\b\u0001\u0000\u0000\u00008;\u0003\u000b\u0005\u00009;\u0003\r\u0006"+
		"\u0000:8\u0001\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000;\n\u0001\u0000"+
		"\u0000\u0000<=\u0007\u0002\u0000\u0000=>\u0007\u0003\u0000\u0000>?\u0007"+
		"\u0004\u0000\u0000?@\u0007\u0005\u0000\u0000@A\u0007\u0006\u0000\u0000"+
		"AB\u0007\u0007\u0000\u0000BC\u0007\u0003\u0000\u0000C\f\u0001\u0000\u0000"+
		"\u0000DE\u0007\b\u0000\u0000EF\u0007\u0006\u0000\u0000FG\u0007\t\u0000"+
		"\u0000GH\u0007\n\u0000\u0000HI\u0007\u000b\u0000\u0000IJ\u0007\u0007\u0000"+
		"\u0000J\u000e\u0001\u0000\u0000\u0000KL\u0007\f\u0000\u0000LM\u0007\u0004"+
		"\u0000\u0000MN\u0007\r\u0000\u0000NO\u0005.\u0000\u0000OP\u0007\u0006"+
		"\u0000\u0000PQ\u0007\u0005\u0000\u0000QR\u0007\u0004\u0000\u0000RS\u0005"+
		".\u0000\u0000ST\u0007\u0006\u0000\u0000TU\u0007\f\u0000\u0000U\u0010\u0001"+
		"\u0000\u0000\u0000VX\u0003\u0015\n\u0000WV\u0001\u0000\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YZ\u0003\u0017\u000b\u0000"+
		"Z\u0012\u0001\u0000\u0000\u0000[]\u0003\u0015\n\u0000\\[\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^_\u0003\u0017"+
		"\u000b\u0000_`\u0003\u0017\u000b\u0000`a\u0003\u0017\u000b\u0000ab\u0003"+
		"\u0017\u000b\u0000b\u0014\u0001\u0000\u0000\u0000cd\u0007\u000e\u0000"+
		"\u0000d\u0016\u0001\u0000\u0000\u0000ef\u0007\u000f\u0000\u0000f\u0018"+
		"\u0001\u0000\u0000\u0000\b\u0000\u001e)06:W\\\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}