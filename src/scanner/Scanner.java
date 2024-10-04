// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: scanner.flex

package scanner;

import parser.sym;
import java.io.Reader;
import java.io.IOException;
import java_cup.runtime.Symbol;


@SuppressWarnings("fallthrough")
public class Scanner {

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
    "\11\0\1\1\1\2\2\3\1\2\22\0\1\1\1\4"+
    "\4\0\1\5\1\0\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\12\16\1\0\1\17\1\20\1\21"+
    "\1\22\2\0\17\23\1\24\12\23\6\0\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\36\1\45"+
    "\1\46\1\47\1\50\1\51\1\52\3\36\1\53\1\54"+
    "\1\55\7\0\1\3\u01a2\0\2\3\326\0\u0100\3";

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
    "\1\0\1\1\1\2\1\3\1\1\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\2\20\15\21\1\22\1\1\1\23\1\24\1\25"+
    "\1\0\1\26\1\0\1\27\1\30\1\31\1\32\1\20"+
    "\11\21\1\33\13\21\1\34\1\0\1\35\1\20\10\21"+
    "\1\36\1\37\1\40\11\21\1\41\1\20\5\21\1\42"+
    "\2\21\1\43\4\21\1\44\1\45\1\46\1\21\1\20"+
    "\1\21\1\47\1\21\1\50\1\21\1\51\1\52\4\21"+
    "\1\53\1\20\4\21\1\54\1\55\1\56\1\21\1\57"+
    "\1\60\1\21\1\61\1\62";

  private static int [] zzUnpackAction() {
    int [] result = new int[136];
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
    "\0\0\0\56\0\134\0\212\0\270\0\56\0\56\0\56"+
    "\0\56\0\56\0\56\0\346\0\u0114\0\56\0\u0142\0\u0170"+
    "\0\u019e\0\u01cc\0\u01fa\0\u0228\0\u0256\0\u0284\0\u02b2\0\u02e0"+
    "\0\u030e\0\u033c\0\u036a\0\u0398\0\u03c6\0\u03f4\0\u0422\0\u0450"+
    "\0\56\0\u047e\0\56\0\56\0\56\0\u04ac\0\u04da\0\u0508"+
    "\0\u0536\0\56\0\56\0\56\0\u0564\0\u0592\0\u05c0\0\u05ee"+
    "\0\u061c\0\u064a\0\u0678\0\u06a6\0\u06d4\0\u0702\0\u0228\0\u0730"+
    "\0\u075e\0\u078c\0\u07ba\0\u07e8\0\u0816\0\u0844\0\u0872\0\u08a0"+
    "\0\u08ce\0\u08fc\0\56\0\u092a\0\u0508\0\u0958\0\u0986\0\u09b4"+
    "\0\u09e2\0\u0a10\0\u0a3e\0\u0a6c\0\u0a9a\0\u0ac8\0\u0228\0\u0228"+
    "\0\u0228\0\u0af6\0\u0b24\0\u0b52\0\u0b80\0\u0bae\0\u0bdc\0\u0c0a"+
    "\0\u0c38\0\u0c66\0\56\0\u0c94\0\u0cc2\0\u0cf0\0\u0d1e\0\u0d4c"+
    "\0\u0d7a\0\u0228\0\u0da8\0\u0dd6\0\u0228\0\u0e04\0\u0e32\0\u0e60"+
    "\0\u0e8e\0\u0228\0\u0228\0\u0228\0\u0ebc\0\u0eea\0\u0f18\0\u0228"+
    "\0\u0f46\0\u0228\0\u0f74\0\u0228\0\u0228\0\u0fa2\0\u0fd0\0\u0ffe"+
    "\0\u102c\0\u0228\0\u105a\0\u1088\0\u10b6\0\u10e4\0\u1112\0\u0228"+
    "\0\u0228\0\u0228\0\u01cc\0\u0228\0\u0228\0\u1140\0\u0228\0\u0228";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[136];
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
    "\1\2\2\3\1\0\1\4\1\5\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\2\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\24"+
    "\1\27\1\30\2\24\1\31\4\24\1\32\1\24\1\33"+
    "\1\34\1\35\1\36\1\24\1\37\1\40\1\41\1\42"+
    "\1\43\57\0\2\3\74\0\1\44\41\0\1\45\60\0"+
    "\1\46\4\0\1\47\54\0\1\50\1\0\1\15\4\0"+
    "\30\51\24\0\1\52\55\0\1\53\55\0\1\54\52\0"+
    "\1\22\4\0\30\22\21\0\1\22\4\0\22\22\1\55"+
    "\5\22\21\0\1\24\4\0\30\24\21\0\1\24\4\0"+
    "\20\24\1\56\1\24\1\57\5\24\21\0\1\24\4\0"+
    "\2\24\1\60\12\24\1\61\2\24\1\62\7\24\21\0"+
    "\1\24\4\0\15\24\1\63\12\24\21\0\1\24\4\0"+
    "\2\24\1\64\12\24\1\65\2\24\1\66\7\24\21\0"+
    "\1\24\4\0\7\24\1\67\7\24\1\70\10\24\21\0"+
    "\1\24\4\0\6\24\1\71\16\24\1\72\2\24\21\0"+
    "\1\24\4\0\22\24\1\73\2\24\1\74\2\24\21\0"+
    "\1\24\4\0\6\24\1\75\21\24\21\0\1\24\4\0"+
    "\24\24\1\76\3\24\21\0\1\24\4\0\11\24\1\77"+
    "\10\24\1\100\5\24\21\0\1\24\4\0\20\24\1\101"+
    "\7\24\21\0\1\24\4\0\11\24\1\102\16\24\57\0"+
    "\1\103\1\0\10\46\1\104\45\46\2\47\1\0\3\47"+
    "\2\0\44\47\1\0\1\47\16\0\1\105\55\0\1\51"+
    "\4\0\30\51\21\0\1\22\4\0\20\22\1\106\7\22"+
    "\21\0\1\24\4\0\20\24\1\107\7\24\21\0\1\24"+
    "\4\0\6\24\1\110\21\24\21\0\1\24\4\0\15\24"+
    "\1\111\12\24\21\0\1\24\4\0\2\24\1\112\25\24"+
    "\21\0\1\24\4\0\17\24\1\113\10\24\21\0\1\24"+
    "\4\0\23\24\1\114\4\24\21\0\1\24\4\0\15\24"+
    "\1\115\12\24\21\0\1\24\4\0\20\24\1\116\7\24"+
    "\21\0\1\24\4\0\22\24\1\117\5\24\21\0\1\24"+
    "\4\0\24\24\1\120\3\24\21\0\1\24\4\0\27\24"+
    "\1\121\21\0\1\24\4\0\15\24\1\122\12\24\21\0"+
    "\1\24\4\0\12\24\1\123\15\24\21\0\1\24\4\0"+
    "\3\24\1\124\24\24\21\0\1\24\4\0\24\24\1\125"+
    "\3\24\21\0\1\24\4\0\2\24\1\126\25\24\21\0"+
    "\1\24\4\0\12\24\1\127\15\24\21\0\1\24\4\0"+
    "\25\24\1\130\2\24\21\0\1\24\4\0\12\24\1\131"+
    "\15\24\21\0\1\24\4\0\12\24\1\132\15\24\3\0"+
    "\10\46\1\104\4\46\1\133\40\46\16\0\1\22\4\0"+
    "\10\22\1\134\17\22\21\0\1\24\4\0\15\24\1\135"+
    "\12\24\21\0\1\24\4\0\2\24\1\136\25\24\21\0"+
    "\1\24\4\0\15\24\1\137\12\24\21\0\1\24\4\0"+
    "\23\24\1\140\4\24\21\0\1\24\4\0\24\24\1\141"+
    "\3\24\21\0\1\24\4\0\6\24\1\142\21\24\21\0"+
    "\1\24\4\0\23\24\1\143\4\24\21\0\1\24\4\0"+
    "\2\24\1\144\25\24\21\0\1\24\4\0\15\24\1\145"+
    "\12\24\21\0\1\24\4\0\26\24\1\146\1\24\21\0"+
    "\1\24\4\0\15\24\1\147\12\24\21\0\1\24\4\0"+
    "\25\24\1\150\2\24\21\0\1\24\4\0\24\24\1\151"+
    "\3\24\21\0\1\24\4\0\23\24\1\152\4\24\21\0"+
    "\1\24\4\0\6\24\1\153\21\24\21\0\1\24\4\0"+
    "\5\24\1\154\22\24\21\0\1\24\4\0\15\24\1\155"+
    "\12\24\21\0\1\22\4\0\22\22\1\156\5\22\21\0"+
    "\1\24\4\0\6\24\1\157\21\24\21\0\1\24\4\0"+
    "\14\24\1\160\13\24\21\0\1\24\4\0\20\24\1\161"+
    "\7\24\21\0\1\24\4\0\23\24\1\162\4\24\21\0"+
    "\1\24\4\0\12\24\1\163\15\24\21\0\1\24\4\0"+
    "\6\24\1\164\21\24\21\0\1\24\4\0\24\24\1\165"+
    "\3\24\21\0\1\24\4\0\2\24\1\166\25\24\21\0"+
    "\1\24\4\0\12\24\1\167\15\24\21\0\1\24\4\0"+
    "\22\24\1\170\5\24\21\0\1\24\4\0\12\24\1\171"+
    "\15\24\21\0\1\24\4\0\6\24\1\172\21\24\21\0"+
    "\1\22\4\0\2\22\1\173\25\22\21\0\1\24\4\0"+
    "\2\24\1\174\25\24\21\0\1\24\4\0\25\24\1\175"+
    "\2\24\21\0\1\24\4\0\17\24\1\176\10\24\21\0"+
    "\1\24\4\0\24\24\1\177\3\24\21\0\1\24\4\0"+
    "\4\24\1\200\23\24\21\0\1\24\4\0\17\24\1\201"+
    "\10\24\21\0\1\24\4\0\4\24\1\202\23\24\21\0"+
    "\1\22\4\0\16\22\1\203\11\22\21\0\1\24\4\0"+
    "\17\24\1\204\10\24\21\0\1\24\4\0\24\24\1\205"+
    "\3\24\21\0\1\24\4\0\25\24\1\206\2\24\21\0"+
    "\1\24\4\0\6\24\1\207\21\24\21\0\1\24\4\0"+
    "\6\24\1\210\21\24\3\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[4462];
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
    "\1\0\1\11\3\1\6\11\2\1\1\11\22\1\1\11"+
    "\1\1\3\11\1\0\1\1\1\0\1\1\3\11\26\1"+
    "\1\11\1\0\26\1\1\11\55\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[136];
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
  @SuppressWarnings("unused")
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
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Symbol yylex() throws java.io.IOException
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
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { return new Symbol(sym.error, "Carácter desconocido " + yytext() + " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 51: break;
          case 2:
            { /* ignorar */
            }
          // fall through
          case 52: break;
          case 3:
            { return new Symbol(sym.NOT, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 53: break;
          case 4:
            { return new Symbol(sym.PAREN_A, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 54: break;
          case 5:
            { return new Symbol(sym.PAREN_B, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 55: break;
          case 6:
            { return new Symbol(sym.MULTIPLY, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 56: break;
          case 7:
            { return new Symbol(sym.PLUS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 57: break;
          case 8:
            { return new Symbol(sym.COMMA, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 58: break;
          case 9:
            { return new Symbol(sym.MINUS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 59: break;
          case 10:
            { return new Symbol(sym.DIVIDE, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 60: break;
          case 11:
            { return new Symbol(sym.INTLIT, Integer.parseInt(yytext()) + " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 61: break;
          case 12:
            { return new Symbol(sym.SEMICOLON, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 62: break;
          case 13:
            { return new Symbol(sym.LESS_THAN, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 63: break;
          case 14:
            { return new Symbol(sym.EQUALS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 64: break;
          case 15:
            { return new Symbol(sym.GREATER_THAN, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 65: break;
          case 16:
            { return new Symbol(sym.error, "Error: id no puede iniciar con mayuscula: " + yytext() + " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 66: break;
          case 17:
            { return new Symbol(sym.ID, yytext() + " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 67: break;
          case 18:
            { return new Symbol(sym.BRACE_A, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 68: break;
          case 19:
            { return new Symbol(sym.BRACE_B, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 69: break;
          case 20:
            { return new Symbol(sym.NOT_EQUALS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 70: break;
          case 21:
            { return new Symbol(sym.AND, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 71: break;
          case 22:
            { /* ignorar comentarios de línea */
            }
          // fall through
          case 72: break;
          case 23:
            { return new Symbol(sym.error, "Error: id no puede iniciar con numero: " + yytext() + " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 73: break;
          case 24:
            { return new Symbol(sym.LESS_THAN_EQUALS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 74: break;
          case 25:
            { return new Symbol(sym.EQUALS_EQUALS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 75: break;
          case 26:
            { return new Symbol(sym.GREATER_THAN_EQUALS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 76: break;
          case 27:
            { return new Symbol(sym.IF, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 77: break;
          case 28:
            { return new Symbol(sym.OR, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 78: break;
          case 29:
            { return new Symbol(sym.FLOATLIT, Float.parseFloat(yytext()) + " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 79: break;
          case 30:
            { return new Symbol(sym.FOR, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 80: break;
          case 31:
            { return new Symbol(sym.INT, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 81: break;
          case 32:
            { return new Symbol(sym.NEW, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 82: break;
          case 33:
            { /* ignorar comentarios de bloque */
            }
          // fall through
          case 83: break;
          case 34:
            { return new Symbol(sym.ELSE, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 84: break;
          case 35:
            { return new Symbol(sym.NULL, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 85: break;
          case 36:
            { return new Symbol(sym.THIS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 86: break;
          case 37:
            { return new Symbol(sym.TRUE, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 87: break;
          case 38:
            { return new Symbol(sym.VOID, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 88: break;
          case 39:
            { return new Symbol(sym.BREAK, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 89: break;
          case 40:
            { return new Symbol(sym.CLASS, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 90: break;
          case 41:
            { return new Symbol(sym.FALSE, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 91: break;
          case 42:
            { return new Symbol(sym.FLOAT, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 92: break;
          case 43:
            { return new Symbol(sym.WHILE, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 93: break;
          case 44:
            { return new Symbol(sym.PUBLIC, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 94: break;
          case 45:
            { return new Symbol(sym.RETURN, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 95: break;
          case 46:
            { return new Symbol(sym.STATIC, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 96: break;
          case 47:
            { return new Symbol(sym.BOOLEAN, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 97: break;
          case 48:
            { return new Symbol(sym.CALLOUT, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 98: break;
          case 49:
            { return new Symbol(sym.PRIVATE, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 99: break;
          case 50:
            { return new Symbol(sym.CONTINUE, " linea " + yyline + " columna " + yycolumn);
            }
          // fall through
          case 100: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
