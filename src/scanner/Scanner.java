// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: scanner.flex

package scanner;

import java.io.Reader;
import java.io.IOException;
import parser.sym;      // Importa la clase sym
import java_cup.runtime.Symbol; //usado por cup
import ast.*;



@SuppressWarnings("fallthrough")
public class Scanner implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\37\u0100\1\u0200\267\u0100\10\u0300\u1020\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\2\3\1\4\22\0\1\1\1\5"+
    "\1\6\2\0\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\0\1\20\1\21\11\22\1\0"+
    "\1\23\1\24\1\25\1\26\2\0\6\27\21\30\1\31"+
    "\2\30\1\32\1\33\1\34\3\0\1\35\1\36\1\37"+
    "\1\40\1\41\1\42\1\30\1\43\1\44\1\30\1\45"+
    "\1\46\1\30\1\47\1\50\2\30\1\51\1\52\1\53"+
    "\1\54\1\55\1\56\1\31\2\30\1\57\1\60\1\61"+
    "\7\0\1\3\u01a2\0\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1024];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\1\1\4\2\1\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\2\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\12\21\1\24"+
    "\1\1\1\25\1\26\1\0\1\27\1\0\1\30\2\0"+
    "\1\31\1\32\1\0\1\33\2\34\1\35\1\36\1\37"+
    "\11\21\1\40\6\21\1\41\1\42\1\0\1\43\10\21"+
    "\1\44\1\45\1\46\4\21\1\47\3\21\1\50\2\21"+
    "\1\51\2\21\1\52\1\53\2\21\1\54\1\21\1\55"+
    "\1\21\1\56\1\21\1\57\3\21\1\60\1\61\1\62"+
    "\1\21\1\63";

  private static int [] zzUnpackAction() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\62\0\372\0\u012c"+
    "\0\62\0\62\0\62\0\u015e\0\62\0\u0190\0\u01c2\0\u01f4"+
    "\0\u0226\0\62\0\u0258\0\u028a\0\u02bc\0\u02ee\0\62\0\62"+
    "\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c\0\u047e"+
    "\0\u04b0\0\u04e2\0\62\0\u0514\0\62\0\62\0\310\0\62"+
    "\0\u0546\0\62\0\u0578\0\u05aa\0\62\0\62\0\u05dc\0\u060e"+
    "\0\u0640\0\u0672\0\62\0\62\0\62\0\u06a4\0\u06d6\0\u0708"+
    "\0\u073a\0\u076c\0\u079e\0\u07d0\0\u0802\0\u0834\0\u02ee\0\u0866"+
    "\0\u0898\0\u08ca\0\u08fc\0\u092e\0\u0960\0\62\0\62\0\u0992"+
    "\0\u0672\0\u09c4\0\u09f6\0\u0a28\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0"+
    "\0\u0b22\0\u02ee\0\u02ee\0\u02ee\0\u0b54\0\u0b86\0\u0bb8\0\u0bea"+
    "\0\62\0\u0c1c\0\u0c4e\0\u0c80\0\u02ee\0\u0cb2\0\u0ce4\0\u02ee"+
    "\0\u0d16\0\u0d48\0\u02ee\0\u02ee\0\u0d7a\0\u0dac\0\u02ee\0\u0dde"+
    "\0\u02ee\0\u0e10\0\u02ee\0\u0e42\0\u02ee\0\u0e74\0\u0ea6\0\u0ed8"+
    "\0\u02ee\0\u02ee\0\u02ee\0\u0f0a\0\u02ee";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\2\3\1\0\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\3\26\1\27"+
    "\1\2\1\30\1\26\1\31\1\32\1\26\1\33\1\34"+
    "\1\26\1\35\2\26\1\36\1\26\1\37\1\26\1\40"+
    "\1\26\1\41\1\42\1\43\1\44\1\45\63\0\2\3"+
    "\1\0\1\3\102\0\1\46\34\0\2\47\1\0\3\47"+
    "\1\50\24\47\1\51\26\47\10\0\1\52\51\0\2\53"+
    "\1\0\6\53\1\0\21\53\1\54\26\53\25\0\1\55"+
    "\61\0\1\56\50\0\1\57\3\0\1\60\62\0\2\21"+
    "\4\0\2\61\1\62\3\0\22\61\24\0\2\21\4\0"+
    "\3\61\3\0\22\61\30\0\1\63\61\0\1\64\61\0"+
    "\1\65\55\0\2\26\4\0\3\26\3\0\22\26\24\0"+
    "\2\26\4\0\3\26\3\0\13\26\1\66\1\67\5\26"+
    "\24\0\2\26\4\0\3\26\3\0\1\70\5\26\1\71"+
    "\2\26\1\72\1\26\1\73\6\26\24\0\2\26\4\0"+
    "\3\26\3\0\11\26\1\74\10\26\24\0\2\26\4\0"+
    "\3\26\3\0\1\75\12\26\1\76\6\26\24\0\2\26"+
    "\4\0\3\26\3\0\5\26\1\77\4\26\1\100\7\26"+
    "\24\0\2\26\4\0\3\26\3\0\4\26\1\101\15\26"+
    "\24\0\2\26\4\0\3\26\3\0\4\26\1\102\15\26"+
    "\24\0\2\26\4\0\3\26\3\0\14\26\1\103\5\26"+
    "\24\0\2\26\4\0\3\26\3\0\13\26\1\104\6\26"+
    "\24\0\2\26\4\0\3\26\3\0\6\26\1\105\13\26"+
    "\63\0\1\106\7\0\1\47\2\0\1\47\7\0\1\47"+
    "\11\0\1\47\2\0\1\47\3\0\1\47\4\0\1\47"+
    "\1\0\1\47\1\0\1\47\17\0\1\107\56\0\1\53"+
    "\2\0\1\53\7\0\1\53\11\0\1\53\2\0\1\53"+
    "\3\0\1\53\4\0\1\53\1\0\1\53\1\0\1\53"+
    "\6\0\14\57\1\110\45\57\2\60\3\0\55\60\21\0"+
    "\2\61\4\0\3\61\3\0\22\61\24\0\2\111\4\0"+
    "\1\111\2\61\3\0\6\111\14\61\24\0\2\26\4\0"+
    "\3\26\3\0\13\26\1\112\6\26\24\0\2\26\4\0"+
    "\3\26\3\0\4\26\1\113\15\26\24\0\2\26\4\0"+
    "\3\26\3\0\11\26\1\114\10\26\24\0\2\26\4\0"+
    "\3\26\3\0\1\115\21\26\24\0\2\26\4\0\3\26"+
    "\3\0\1\116\21\26\24\0\2\26\4\0\3\26\3\0"+
    "\12\26\1\117\7\26\24\0\2\26\4\0\3\26\3\0"+
    "\15\26\1\120\4\26\24\0\2\26\4\0\3\26\3\0"+
    "\11\26\1\121\10\26\24\0\2\26\4\0\3\26\3\0"+
    "\14\26\1\122\5\26\24\0\2\26\4\0\3\26\3\0"+
    "\16\26\1\123\3\26\24\0\2\26\4\0\3\26\3\0"+
    "\21\26\1\124\24\0\2\26\4\0\3\26\3\0\16\26"+
    "\1\125\3\26\24\0\2\26\4\0\3\26\3\0\17\26"+
    "\1\126\2\26\24\0\2\26\4\0\3\26\3\0\7\26"+
    "\1\127\12\26\24\0\2\26\4\0\3\26\3\0\7\26"+
    "\1\130\12\26\3\0\20\57\1\131\41\57\21\0\2\26"+
    "\4\0\3\26\3\0\11\26\1\132\10\26\24\0\2\26"+
    "\4\0\3\26\3\0\1\133\21\26\24\0\2\26\4\0"+
    "\3\26\3\0\11\26\1\134\10\26\24\0\2\26\4\0"+
    "\3\26\3\0\14\26\1\135\5\26\24\0\2\26\4\0"+
    "\3\26\3\0\15\26\1\136\4\26\24\0\2\26\4\0"+
    "\3\26\3\0\16\26\1\137\3\26\24\0\2\26\4\0"+
    "\3\26\3\0\4\26\1\140\15\26\24\0\2\26\4\0"+
    "\3\26\3\0\15\26\1\141\4\26\24\0\2\26\4\0"+
    "\3\26\3\0\17\26\1\142\2\26\24\0\2\26\4\0"+
    "\3\26\3\0\4\26\1\143\15\26\24\0\2\26\4\0"+
    "\3\26\3\0\3\26\1\144\16\26\24\0\2\26\4\0"+
    "\3\26\3\0\11\26\1\145\10\26\24\0\2\26\4\0"+
    "\3\26\3\0\4\26\1\146\15\26\24\0\2\26\4\0"+
    "\3\26\3\0\10\26\1\147\11\26\24\0\2\26\4\0"+
    "\3\26\3\0\13\26\1\150\6\26\24\0\2\26\4\0"+
    "\3\26\3\0\15\26\1\151\4\26\24\0\2\26\4\0"+
    "\3\26\3\0\7\26\1\152\12\26\24\0\2\26\4\0"+
    "\3\26\3\0\4\26\1\153\15\26\24\0\2\26\4\0"+
    "\3\26\3\0\14\26\1\154\5\26\24\0\2\26\4\0"+
    "\3\26\3\0\4\26\1\155\15\26\24\0\2\26\4\0"+
    "\3\26\3\0\1\156\21\26\24\0\2\26\4\0\3\26"+
    "\3\0\17\26\1\157\2\26\24\0\2\26\4\0\3\26"+
    "\3\0\12\26\1\160\7\26\24\0\2\26\4\0\3\26"+
    "\3\0\12\26\1\161\7\26\24\0\2\26\4\0\3\26"+
    "\3\0\12\26\1\162\7\26\24\0\2\26\4\0\3\26"+
    "\3\0\16\26\1\163\3\26\24\0\2\26\4\0\3\26"+
    "\3\0\17\26\1\164\2\26\24\0\2\26\4\0\3\26"+
    "\3\0\4\26\1\165\15\26\3\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[3900];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\3\1\1\11\2\1\3\11\1\1\1\11"+
    "\4\1\1\11\4\1\2\11\12\1\1\11\1\1\2\11"+
    "\1\0\1\11\1\0\1\11\2\0\2\11\1\0\3\1"+
    "\3\11\20\1\2\11\1\0\20\1\1\11\34\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[117];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Scanner(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return null;
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return new Symbol(sym.ERROR, yyline+1, yycolumn+1, "Carácter desconocido: " + yytext());
            }
          // fall through
          case 52: break;
          case 2:
            { /* ignorar */
            }
          // fall through
          case 53: break;
          case 3:
            { return new Symbol(sym.NOT, yyline+1, yycolumn+1, "!");
            }
          // fall through
          case 54: break;
          case 4:
            { return new Symbol(sym.MOD, yyline+1, yycolumn+1, "%");
            }
          // fall through
          case 55: break;
          case 5:
            { return new Symbol(sym.LPAREN, yyline+1, yycolumn+1, "(");
            }
          // fall through
          case 56: break;
          case 6:
            { return new Symbol(sym.RPAREN, yyline+1, yycolumn+1, ")");
            }
          // fall through
          case 57: break;
          case 7:
            { return new Symbol(sym.TIMES, yyline+1, yycolumn+1, "*");
            }
          // fall through
          case 58: break;
          case 8:
            { return new Symbol(sym.PLUS, yyline+1, yycolumn+1, "+");
            }
          // fall through
          case 59: break;
          case 9:
            { return new Symbol(sym.COMMA, yyline+1, yycolumn+1, ",");
            }
          // fall through
          case 60: break;
          case 10:
            { return new Symbol(sym.MINUS, yyline+1, yycolumn+1, "-");
            }
          // fall through
          case 61: break;
          case 11:
            { return new Symbol(sym.DIVIDE, yyline+1, yycolumn+1, "/");
            }
          // fall through
          case 62: break;
          case 12:
            { return new Symbol(sym.INT_LITERAL, yyline+1, yycolumn+1, Integer.parseInt(yytext()));
            }
          // fall through
          case 63: break;
          case 13:
            { return new Symbol(sym.SEMI, yyline+1, yycolumn+1, ";");
            }
          // fall through
          case 64: break;
          case 14:
            { return new Symbol(sym.LT, yyline+1, yycolumn+1, "<");
            }
          // fall through
          case 65: break;
          case 15:
            { return new Symbol(sym.ASSIGN, yyline+1, yycolumn+1, "=");
            }
          // fall through
          case 66: break;
          case 16:
            { return new Symbol(sym.GT, yyline+1, yycolumn+1, ">");
            }
          // fall through
          case 67: break;
          case 17:
            { return new Symbol(sym.ID, yyline+1, yycolumn+1, yytext());
            }
          // fall through
          case 68: break;
          case 18:
            { return new Symbol(sym.LBRACKET, yyline+1, yycolumn+1, "[");
            }
          // fall through
          case 69: break;
          case 19:
            { return new Symbol(sym.RBRACKET, yyline+1, yycolumn+1, "]");
            }
          // fall through
          case 70: break;
          case 20:
            { return new Symbol(sym.LBRACE, yyline+1, yycolumn+1, "{");
            }
          // fall through
          case 71: break;
          case 21:
            { return new Symbol(sym.RBRACE, yyline+1, yycolumn+1, "}");
            }
          // fall through
          case 72: break;
          case 22:
            { return new Symbol(sym.NEQ, yyline+1, yycolumn+1, "!=");
            }
          // fall through
          case 73: break;
          case 23:
            { return new Symbol(sym.STRING_LITERAL, yyline+1, yycolumn+1, yytext());
            }
          // fall through
          case 74: break;
          case 24:
            { return new Symbol(sym.AND, yyline+1, yycolumn+1, "&&");
            }
          // fall through
          case 75: break;
          case 25:
            { return new Symbol(sym.PLUS_ASSIGN, yyline+1, yycolumn+1, "+=");
            }
          // fall through
          case 76: break;
          case 26:
            { return new Symbol(sym.MINUS_ASSIGN, yyline+1, yycolumn+1, "-=");
            }
          // fall through
          case 77: break;
          case 27:
            { /* ignorar comentarios de una línea */
            }
          // fall through
          case 78: break;
          case 28:
            { return new Symbol(sym.ERROR, yyline+1, yycolumn+1, "Error: id no puede iniciar con número: " + yytext());
            }
          // fall through
          case 79: break;
          case 29:
            { return new Symbol(sym.LE, yyline+1, yycolumn+1, "<=");
            }
          // fall through
          case 80: break;
          case 30:
            { return new Symbol(sym.EQ, yyline+1, yycolumn+1, "==");
            }
          // fall through
          case 81: break;
          case 31:
            { return new Symbol(sym.GE, yyline+1, yycolumn+1, ">=");
            }
          // fall through
          case 82: break;
          case 32:
            { return new Symbol(sym.IF, yyline+1, yycolumn+1, "if");
            }
          // fall through
          case 83: break;
          case 33:
            { return new Symbol(sym.OR, yyline+1, yycolumn+1, "||");
            }
          // fall through
          case 84: break;
          case 34:
            { return new Symbol(sym.CHAR_LITERAL, yyline+1, yycolumn+1, yytext());
            }
          // fall through
          case 85: break;
          case 35:
            { return new Symbol(sym.INT_LITERAL, yyline+1, yycolumn+1, yytext());
            }
          // fall through
          case 86: break;
          case 36:
            { return new Symbol(sym.FOR, yyline+1, yycolumn+1, "for");
            }
          // fall through
          case 87: break;
          case 37:
            { return new Symbol(sym.INT, yyline+1, yycolumn+1, "int");
            }
          // fall through
          case 88: break;
          case 38:
            { return new Symbol(sym.NEW, yyline+1, yycolumn+1, "new");
            }
          // fall through
          case 89: break;
          case 39:
            { /* ignorar comentarios de bloque */
            }
          // fall through
          case 90: break;
          case 40:
            { return new Symbol(sym.CHAR, yyline+1, yycolumn+1, "char");
            }
          // fall through
          case 91: break;
          case 41:
            { return new Symbol(sym.ELSE, yyline+1, yycolumn+1, "else");
            }
          // fall through
          case 92: break;
          case 42:
            { return new Symbol(sym.TRUE, yyline+1, yycolumn+1, "true");
            }
          // fall through
          case 93: break;
          case 43:
            { return new Symbol(sym.VOID, yyline+1, yycolumn+1, "void");
            }
          // fall through
          case 94: break;
          case 44:
            { return new Symbol(sym.BREAK, yyline+1, yycolumn+1, "break");
            }
          // fall through
          case 95: break;
          case 45:
            { return new Symbol(sym.CLASS, yyline+1, yycolumn+1, "class");
            }
          // fall through
          case 96: break;
          case 46:
            { return new Symbol(sym.FALSE, yyline+1, yycolumn+1, "false");
            }
          // fall through
          case 97: break;
          case 47:
            { return new Symbol(sym.WHILE, yyline+1, yycolumn+1, "while");
            }
          // fall through
          case 98: break;
          case 48:
            { return new Symbol(sym.RETURN, yyline+1, yycolumn+1, "return");
            }
          // fall through
          case 99: break;
          case 49:
            { return new Symbol(sym.BOOLEAN, yyline+1, yycolumn+1, "boolean");
            }
          // fall through
          case 100: break;
          case 50:
            { return new Symbol(sym.CALLOUT, yyline+1, yycolumn+1, "callout");
            }
          // fall through
          case 101: break;
          case 51:
            { return new Symbol(sym.CONTINUE, yyline+1, yycolumn+1, "continue");
            }
          // fall through
          case 102: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
