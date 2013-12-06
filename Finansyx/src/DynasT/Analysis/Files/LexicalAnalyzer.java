/* The following code was generated by JFlex 1.4.3 on 5/12/13 22:43 */

package DynasT.Analysis.Classes;

import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 5/12/13 22:43 from the specification file
 * <tt>C:/Users/t4r0/Documents/GitHub/Finansyx/Finansyx/src/DynasT/Analysis/Files/DynasT-lex.flex</tt>
 */
public class LexicalAnalyzer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
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
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\7\1\3\1\1\1\0\1\3\1\2\16\7\4\0\1\3\3\0"+
    "\1\6\1\10\1\0\1\10\1\35\1\36\1\40\1\37\1\45\1\33"+
    "\1\5\1\41\12\4\1\42\1\50\1\0\1\51\1\52\2\0\1\11"+
    "\1\25\1\12\1\27\1\21\1\30\1\32\1\6\1\14\1\31\1\6"+
    "\1\23\1\24\1\20\1\16\1\34\1\6\1\22\1\17\1\13\1\26"+
    "\1\15\4\6\1\46\1\0\1\47\1\0\1\6\1\0\1\11\1\25"+
    "\1\12\1\27\1\21\1\30\1\32\1\6\1\14\1\31\1\6\1\23"+
    "\1\24\1\20\1\16\1\34\1\6\1\22\1\17\1\13\1\26\1\15"+
    "\4\6\1\43\1\0\1\44\1\0\41\7\2\0\4\6\4\0\1\6"+
    "\2\0\1\7\7\0\1\6\4\0\1\6\5\0\27\6\1\0\37\6"+
    "\1\0\u01ca\6\4\0\14\6\16\0\5\6\7\0\1\6\1\0\1\6"+
    "\21\0\160\7\5\6\1\0\2\6\2\0\4\6\10\0\1\6\1\0"+
    "\3\6\1\0\1\6\1\0\24\6\1\0\123\6\1\0\213\6\1\0"+
    "\5\7\2\0\236\6\11\0\46\6\2\0\1\6\7\0\47\6\11\0"+
    "\55\7\1\0\1\7\1\0\2\7\1\0\2\7\1\0\1\7\10\0"+
    "\33\6\5\0\3\6\15\0\4\7\7\0\1\6\4\0\13\7\5\0"+
    "\53\6\37\7\4\0\2\6\1\7\143\6\1\0\1\6\10\7\1\0"+
    "\6\7\2\6\2\7\1\0\4\7\2\6\12\7\3\6\2\0\1\6"+
    "\17\0\1\7\1\6\1\7\36\6\33\7\2\0\131\6\13\7\1\6"+
    "\16\0\12\7\41\6\11\7\2\6\4\0\1\6\5\0\26\6\4\7"+
    "\1\6\11\7\1\6\3\7\1\6\5\7\22\0\31\6\3\7\244\0"+
    "\4\7\66\6\3\7\1\6\22\7\1\6\7\7\12\6\2\7\2\0"+
    "\12\7\1\0\7\6\1\0\7\6\1\0\3\7\1\0\10\6\2\0"+
    "\2\6\2\0\26\6\1\0\7\6\1\0\1\6\3\0\4\6\2\0"+
    "\1\7\1\6\7\7\2\0\2\7\2\0\3\7\1\6\10\0\1\7"+
    "\4\0\2\6\1\0\3\6\2\7\2\0\12\7\4\6\7\0\1\6"+
    "\5\0\3\7\1\0\6\6\4\0\2\6\2\0\26\6\1\0\7\6"+
    "\1\0\2\6\1\0\2\6\1\0\2\6\2\0\1\7\1\0\5\7"+
    "\4\0\2\7\2\0\3\7\3\0\1\7\7\0\4\6\1\0\1\6"+
    "\7\0\14\7\3\6\1\7\13\0\3\7\1\0\11\6\1\0\3\6"+
    "\1\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6\2\0\1\7"+
    "\1\6\10\7\1\0\3\7\1\0\3\7\2\0\1\6\17\0\2\6"+
    "\2\7\2\0\12\7\1\0\1\6\17\0\3\7\1\0\10\6\2\0"+
    "\2\6\2\0\26\6\1\0\7\6\1\0\2\6\1\0\5\6\2\0"+
    "\1\7\1\6\7\7\2\0\2\7\2\0\3\7\10\0\2\7\4\0"+
    "\2\6\1\0\3\6\2\7\2\0\12\7\1\0\1\6\20\0\1\7"+
    "\1\6\1\0\6\6\3\0\3\6\1\0\4\6\3\0\2\6\1\0"+
    "\1\6\1\0\2\6\3\0\2\6\3\0\3\6\3\0\14\6\4\0"+
    "\5\7\3\0\3\7\1\0\4\7\2\0\1\6\6\0\1\7\16\0"+
    "\12\7\11\0\1\6\7\0\3\7\1\0\10\6\1\0\3\6\1\0"+
    "\27\6\1\0\12\6\1\0\5\6\3\0\1\6\7\7\1\0\3\7"+
    "\1\0\4\7\7\0\2\7\1\0\2\6\6\0\2\6\2\7\2\0"+
    "\12\7\22\0\2\7\1\0\10\6\1\0\3\6\1\0\27\6\1\0"+
    "\12\6\1\0\5\6\2\0\1\7\1\6\7\7\1\0\3\7\1\0"+
    "\4\7\7\0\2\7\7\0\1\6\1\0\2\6\2\7\2\0\12\7"+
    "\1\0\2\6\17\0\2\7\1\0\10\6\1\0\3\6\1\0\51\6"+
    "\2\0\1\6\7\7\1\0\3\7\1\0\4\7\1\6\10\0\1\7"+
    "\10\0\2\6\2\7\2\0\12\7\12\0\6\6\2\0\2\7\1\0"+
    "\22\6\3\0\30\6\1\0\11\6\1\0\1\6\2\0\7\6\3\0"+
    "\1\7\4\0\6\7\1\0\1\7\1\0\10\7\22\0\2\7\15\0"+
    "\60\6\1\7\2\6\7\7\4\0\10\6\10\7\1\0\12\7\47\0"+
    "\2\6\1\0\1\6\2\0\2\6\1\0\1\6\2\0\1\6\6\0"+
    "\4\6\1\0\7\6\1\0\3\6\1\0\1\6\1\0\1\6\2\0"+
    "\2\6\1\0\4\6\1\7\2\6\6\7\1\0\2\7\1\6\2\0"+
    "\5\6\1\0\1\6\1\0\6\7\2\0\12\7\2\0\2\6\42\0"+
    "\1\6\27\0\2\7\6\0\12\7\13\0\1\7\1\0\1\7\1\0"+
    "\1\7\4\0\2\7\10\6\1\0\44\6\4\0\24\7\1\0\2\7"+
    "\5\6\13\7\1\0\44\7\11\0\1\7\71\0\53\6\24\7\1\6"+
    "\12\7\6\0\6\6\4\7\4\6\3\7\1\6\3\7\2\6\7\7"+
    "\3\6\4\7\15\6\14\7\1\6\17\7\2\0\46\6\12\0\53\6"+
    "\1\0\1\6\3\0\u0149\6\1\0\4\6\2\0\7\6\1\0\1\6"+
    "\1\0\4\6\2\0\51\6\1\0\4\6\2\0\41\6\1\0\4\6"+
    "\2\0\7\6\1\0\1\6\1\0\4\6\2\0\17\6\1\0\71\6"+
    "\1\0\4\6\2\0\103\6\2\0\3\7\40\0\20\6\20\0\125\6"+
    "\14\0\u026c\6\2\0\21\6\1\0\32\6\5\0\113\6\3\0\3\6"+
    "\17\0\15\6\1\0\4\6\3\7\13\0\22\6\3\7\13\0\22\6"+
    "\2\7\14\0\15\6\1\0\3\6\1\0\2\7\14\0\64\6\40\7"+
    "\3\0\1\6\3\0\2\6\1\7\2\0\12\7\41\0\3\7\2\0"+
    "\12\7\6\0\130\6\10\0\51\6\1\7\1\6\5\0\106\6\12\0"+
    "\35\6\3\0\14\7\4\0\14\7\12\0\12\7\36\6\2\0\5\6"+
    "\13\0\54\6\4\0\21\7\7\6\2\7\6\0\12\7\46\0\27\6"+
    "\5\7\4\0\65\6\12\7\1\0\35\7\2\0\13\7\6\0\12\7"+
    "\15\0\1\6\130\0\5\7\57\6\21\7\7\6\4\0\12\7\21\0"+
    "\11\7\14\0\3\7\36\6\12\7\3\0\2\6\12\7\6\0\46\6"+
    "\16\7\14\0\44\6\24\7\10\0\12\7\3\0\3\6\12\7\44\6"+
    "\122\0\3\7\1\0\25\7\4\6\1\7\4\6\1\7\15\0\300\6"+
    "\47\7\25\0\4\7\u0116\6\2\0\6\6\2\0\46\6\2\0\6\6"+
    "\2\0\10\6\1\0\1\6\1\0\1\6\1\0\1\6\1\0\37\6"+
    "\2\0\65\6\1\0\7\6\1\0\1\6\3\0\3\6\1\0\7\6"+
    "\3\0\4\6\2\0\6\6\4\0\15\6\5\0\3\6\1\0\7\6"+
    "\16\0\5\7\32\0\5\7\20\0\2\6\23\0\1\6\13\0\5\7"+
    "\5\0\6\7\1\0\1\6\15\0\1\6\20\0\15\6\3\0\32\6"+
    "\26\0\15\7\4\0\1\7\3\0\14\7\21\0\1\6\4\0\1\6"+
    "\2\0\12\6\1\0\1\6\3\0\5\6\6\0\1\6\1\0\1\6"+
    "\1\0\1\6\1\0\4\6\1\0\13\6\2\0\4\6\5\0\5\6"+
    "\4\0\1\6\21\0\51\6\u0a77\0\57\6\1\0\57\6\1\0\205\6"+
    "\6\0\4\6\3\7\16\0\46\6\12\0\66\6\11\0\1\6\17\0"+
    "\1\7\27\6\11\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6"+
    "\1\0\7\6\1\0\7\6\1\0\7\6\1\0\7\6\1\0\40\7"+
    "\57\0\1\6\u01d5\0\3\6\31\0\11\6\6\7\1\0\5\6\2\0"+
    "\5\6\4\0\126\6\2\0\2\7\2\0\3\6\1\0\132\6\1\0"+
    "\4\6\5\0\51\6\3\0\136\6\21\0\33\6\65\0\20\6\u0200\0"+
    "\u19b6\6\112\0\u51cc\6\64\0\u048d\6\103\0\56\6\2\0\u010d\6\3\0"+
    "\20\6\12\7\2\6\24\0\57\6\1\7\14\0\2\7\1\0\31\6"+
    "\10\0\120\6\2\7\45\0\11\6\2\0\147\6\2\0\4\6\1\0"+
    "\2\6\16\0\12\6\120\0\10\6\1\7\3\6\1\7\4\6\1\7"+
    "\27\6\5\7\20\0\1\6\7\0\64\6\14\0\2\7\62\6\21\7"+
    "\13\0\12\7\6\0\22\7\6\6\3\0\1\6\4\0\12\7\34\6"+
    "\10\7\2\0\27\6\15\7\14\0\35\6\3\0\4\7\57\6\16\7"+
    "\16\0\1\6\12\7\46\0\51\6\16\7\11\0\3\6\1\7\10\6"+
    "\2\7\2\0\12\7\6\0\27\6\3\0\1\6\1\7\4\0\60\6"+
    "\1\7\1\6\3\7\2\6\2\7\5\6\2\7\1\6\1\7\1\6"+
    "\30\0\3\6\43\0\6\6\2\0\6\6\2\0\6\6\11\0\7\6"+
    "\1\0\7\6\221\0\43\6\10\7\1\0\2\7\2\0\12\7\6\0"+
    "\u2ba4\6\14\0\27\6\4\0\61\6\u2104\0\u012e\6\2\0\76\6\2\0"+
    "\152\6\46\0\7\6\14\0\5\6\5\0\1\6\1\7\12\6\1\0"+
    "\15\6\1\0\5\6\1\0\1\6\1\0\2\6\1\0\2\6\1\0"+
    "\154\6\41\0\u016b\6\22\0\100\6\2\0\66\6\50\0\15\6\3\0"+
    "\20\7\20\0\7\7\14\0\2\6\30\0\3\6\31\0\1\6\6\0"+
    "\5\6\1\0\207\6\2\0\1\7\4\0\1\6\13\0\12\7\7\0"+
    "\32\6\4\0\1\6\1\0\32\6\13\0\131\6\3\0\6\6\2\0"+
    "\6\6\2\0\6\6\2\0\3\6\3\0\2\6\3\0\2\6\22\0"+
    "\3\7\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\14\4\1\5\1\4\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\0\1\23\10\4\1\24"+
    "\1\4\1\25\7\4\1\26\2\4\1\27\17\4\1\30"+
    "\12\4\1\31\2\4\1\32\4\4\1\33\12\4\1\34"+
    "\7\4\1\35\2\4\1\36\1\4\1\37\5\4\1\40"+
    "\1\41\3\4\1\0\1\4\1\42\1\0\3\4\1\43"+
    "\2\4\1\44\2\4\1\45\1\4\1\0\1\4\1\0"+
    "\2\4\1\46\1\47\1\4\1\50\1\4\1\51\1\0"+
    "\1\52\1\0\3\4\1\53\1\54\1\55\1\4\1\56"+
    "\3\4\1\57\1\60";

  private static int [] zzUnpackAction() {
    int [] result = new int[167];
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
    "\0\0\0\53\0\126\0\53\0\201\0\254\0\327\0\u0102"+
    "\0\u012d\0\u0158\0\u0183\0\u01ae\0\u01d9\0\u0204\0\u022f\0\u025a"+
    "\0\u0285\0\u02b0\0\u02db\0\53\0\53\0\53\0\53\0\53"+
    "\0\53\0\53\0\53\0\53\0\53\0\53\0\53\0\53"+
    "\0\u0306\0\53\0\u0331\0\u035c\0\u0387\0\u03b2\0\u03dd\0\u0408"+
    "\0\u0433\0\u045e\0\254\0\u0489\0\254\0\u04b4\0\u04df\0\u050a"+
    "\0\u0535\0\u0560\0\u058b\0\u05b6\0\53\0\u05e1\0\u060c\0\u0306"+
    "\0\u0637\0\u0662\0\u068d\0\u06b8\0\u06e3\0\u070e\0\u0739\0\u0764"+
    "\0\u078f\0\u07ba\0\u07e5\0\u0810\0\u083b\0\u0866\0\u0891\0\254"+
    "\0\u08bc\0\u08e7\0\u0912\0\u093d\0\u0968\0\u0993\0\u09be\0\u09e9"+
    "\0\u0a14\0\u0a3f\0\254\0\u0a6a\0\u0a95\0\254\0\u0ac0\0\u0aeb"+
    "\0\u0b16\0\u0b41\0\254\0\u0b6c\0\u0b97\0\u0bc2\0\u0bed\0\u0c18"+
    "\0\u0c43\0\u0c6e\0\u0c99\0\u0cc4\0\u0cef\0\254\0\u0d1a\0\u0d45"+
    "\0\u0d70\0\u0d9b\0\u0dc6\0\u0df1\0\u0e1c\0\u0e47\0\u0e72\0\u0e9d"+
    "\0\254\0\u0ec8\0\254\0\u0ef3\0\u0f1e\0\u0f49\0\u0f74\0\u0f9f"+
    "\0\254\0\254\0\u0fca\0\u0ff5\0\u1020\0\u104b\0\u1076\0\254"+
    "\0\u10a1\0\u10cc\0\u10f7\0\u1122\0\254\0\u114d\0\u1178\0\254"+
    "\0\u11a3\0\u11ce\0\254\0\u11f9\0\u1224\0\u124f\0\u127a\0\u12a5"+
    "\0\u12d0\0\254\0\254\0\u12fb\0\254\0\u1326\0\254\0\u1351"+
    "\0\254\0\u137c\0\u13a7\0\u13d2\0\u13fd\0\254\0\53\0\53"+
    "\0\u1428\0\254\0\u1453\0\u147e\0\u14a9\0\254\0\254";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[167];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\2\1\6\2\2\1\7"+
    "\1\10\1\11\1\12\1\6\1\13\1\14\1\15\1\16"+
    "\3\6\1\17\2\6\1\20\1\6\1\21\1\22\1\23"+
    "\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\2\55\0\1\4"+
    "\54\0\1\5\1\41\2\0\1\42\46\0\1\6\1\0"+
    "\2\6\1\0\22\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\1\6\1\43\5\6\1\44\1\6\1\45"+
    "\1\46\7\6\1\0\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\5\6\1\47\14\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\13\6\1\50\6\6\1\0\1\6"+
    "\22\0\1\6\1\0\2\6\1\0\7\6\1\51\12\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\22\6"+
    "\1\0\1\52\22\0\1\6\1\0\2\6\1\0\3\6"+
    "\1\53\11\6\1\54\4\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\5\6\1\55\2\6\1\56\11\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\6\6"+
    "\1\57\13\6\1\0\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\11\6\1\60\10\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\3\6\1\61\5\6\1\62\1\63"+
    "\7\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\1\64\21\6\1\0\1\6\70\0\1\65\4\0\1\6"+
    "\1\0\2\6\1\0\1\66\10\6\1\67\10\6\1\0"+
    "\1\6\22\0\1\70\52\0\1\6\1\0\2\6\1\0"+
    "\2\6\1\71\17\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\2\6\1\72\17\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\14\6\1\73\5\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\10\6\1\74"+
    "\11\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\6\6\1\75\13\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\1\76\21\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\2\6\1\77\1\100\13\6\1\101"+
    "\1\6\1\102\1\0\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\2\6\1\103\17\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\22\6\1\0\1\104\22\0\1\6"+
    "\1\0\2\6\1\0\2\6\1\105\17\6\1\0\1\6"+
    "\22\0\1\6\1\0\2\6\1\0\1\6\1\106\20\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\15\6"+
    "\1\107\4\6\1\0\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\7\6\1\110\12\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\1\111\21\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\15\6\1\112\4\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\6\6\1\113"+
    "\13\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\2\6\1\114\17\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\5\6\1\115\14\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\3\6\1\116\16\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\10\6\1\117"+
    "\11\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\5\6\1\120\14\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\13\6\1\121\6\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\2\6\1\122\17\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\11\6\1\123"+
    "\10\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\10\6\1\124\11\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\1\6\1\125\20\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\5\6\1\126\2\6\1\127"+
    "\11\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\11\6\1\130\10\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\3\6\1\131\16\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\10\6\1\132\11\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\5\6\1\133"+
    "\14\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\1\134\7\6\1\135\11\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\2\6\1\136\17\6\1\0\1\6"+
    "\22\0\1\6\1\0\2\6\1\0\7\6\1\137\12\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\20\6"+
    "\1\140\1\6\1\0\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\2\6\1\141\17\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\10\6\1\142\11\6\1\0\1\6"+
    "\22\0\1\6\1\0\2\6\1\0\7\6\1\143\12\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\4\6"+
    "\1\144\15\6\1\0\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\11\6\1\145\10\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\12\6\1\146\7\6\1\0\1\6"+
    "\22\0\1\6\1\0\2\6\1\0\1\147\21\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\5\6\1\150"+
    "\14\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\11\6\1\151\10\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\3\6\1\152\16\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\11\6\1\153\10\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\10\6\1\154"+
    "\11\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\13\6\1\155\6\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\11\6\1\156\10\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\12\6\1\157\7\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\7\6\1\160"+
    "\12\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\5\6\1\161\14\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\1\6\1\162\20\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\5\6\1\163\14\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\5\6\1\164"+
    "\14\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\7\6\1\165\12\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\5\6\1\166\14\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\5\6\1\167\14\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\3\6\1\170"+
    "\16\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\7\6\1\171\12\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\6\6\1\172\13\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\10\6\1\173\11\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\1\174\21\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\3\6"+
    "\1\175\16\6\1\176\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\6\6\1\177\13\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\5\6\1\200\14\6\1\0\1\6"+
    "\22\0\1\6\1\0\2\6\1\0\22\6\1\201\1\6"+
    "\22\0\1\6\1\0\2\6\1\0\5\6\1\202\14\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\1\203"+
    "\21\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\10\6\1\204\11\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\6\6\1\205\13\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\2\6\1\206\17\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\6\6\1\207"+
    "\13\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\6\6\1\210\13\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\5\6\1\211\14\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\6\6\1\212\13\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\12\6\1\213"+
    "\7\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\5\6\1\214\14\6\1\0\1\6\42\0\1\215\32\0"+
    "\1\6\1\0\2\6\1\0\5\6\1\216\14\6\1\0"+
    "\1\6\42\0\1\217\32\0\1\6\1\0\2\6\1\0"+
    "\7\6\1\220\12\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\11\6\1\221\10\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\6\6\1\222\13\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\10\6\1\223"+
    "\11\6\1\0\1\6\22\0\1\6\1\0\2\6\1\0"+
    "\2\6\1\224\17\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\11\6\1\225\10\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\10\6\1\226\11\6\1\0"+
    "\1\6\22\0\1\6\1\0\2\6\1\0\11\6\1\227"+
    "\10\6\1\0\1\6\32\0\1\230\42\0\1\6\1\0"+
    "\2\6\1\0\6\6\1\231\13\6\1\0\1\6\32\0"+
    "\1\232\42\0\1\6\1\0\2\6\1\0\1\233\21\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\3\6"+
    "\1\234\16\6\1\0\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\3\6\1\235\16\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\6\6\1\236\13\6\1\0\1\6"+
    "\36\0\1\237\52\0\1\240\36\0\1\6\1\0\2\6"+
    "\1\0\16\6\1\241\3\6\1\0\1\6\22\0\1\6"+
    "\1\0\2\6\1\0\5\6\1\242\14\6\1\0\1\6"+
    "\22\0\1\6\1\0\2\6\1\0\1\6\1\243\20\6"+
    "\1\0\1\6\22\0\1\6\1\0\2\6\1\0\5\6"+
    "\1\244\14\6\1\0\1\6\22\0\1\6\1\0\2\6"+
    "\1\0\1\245\21\6\1\0\1\6\22\0\1\6\1\0"+
    "\2\6\1\0\6\6\1\246\13\6\1\0\1\6\22\0"+
    "\1\6\1\0\2\6\1\0\11\6\1\247\10\6\1\0"+
    "\1\6\16\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5332];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
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


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\17\1\15\11\1\0\1\11"+
    "\22\1\1\11\110\1\1\0\2\1\1\0\13\1\1\0"+
    "\1\1\1\0\10\1\1\0\1\1\1\0\4\1\2\11"+
    "\7\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[167];
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

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public LexicalAnalyzer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public LexicalAnalyzer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2244) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
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
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
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
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
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


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
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
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 16: 
          { return Symbol(sym.CLSQBRAC);
          }
        case 49: break;
        case 33: 
          { return Symbol(sym.COSTS);
          }
        case 50: break;
        case 31: 
          { return Symbol(sym.FLOW);
          }
        case 51: break;
        case 20: 
          { return Symbol(sym.YES, true);
          }
        case 52: break;
        case 41: 
          { return Symbol(sym.INF);
          }
        case 53: break;
        case 19: 
          { return Symbol(sym.PERCENTAGE,yytext());
          }
        case 54: break;
        case 8: 
          { return Symbol(sym.PLUS);
          }
        case 55: break;
        case 40: 
          { return Symbol(sym.LAST);
          }
        case 56: break;
        case 15: 
          { return Symbol(sym.OPSQBRAC);
          }
        case 57: break;
        case 4: 
          { return Symbol(sym.IDENTIFIER, yytext());
          }
        case 58: break;
        case 32: 
          { return Symbol(sym.GERMAN);
          }
        case 59: break;
        case 43: 
          { return Symbol(sym.INTERESTS);
          }
        case 60: break;
        case 1: 
          { System.err.println("caracter invalido" + yytext() + "["+ yyline + ":"+ yycolumn + "]");
          }
        case 61: break;
        case 26: 
          { return Symbol(sym.INFO);
          }
        case 62: break;
        case 30: 
          { return Symbol(sym.GROSS);
          }
        case 63: break;
        case 13: 
          { return Symbol(sym.CLCURLYBRAC);
          }
        case 64: break;
        case 29: 
          { return Symbol(sym.UPPER);
          }
        case 65: break;
        case 10: 
          { return Symbol(sym.DIVIDE);
          }
        case 66: break;
        case 27: 
          { return Symbol(sym.NET);
          }
        case 67: break;
        case 24: 
          { return Symbol(sym.END);
          }
        case 68: break;
        case 22: 
          { return Symbol(sym.POINTER);
          }
        case 69: break;
        case 44: 
          { return Symbol(sym.INFMIN);
          }
        case 70: break;
        case 9: 
          { return Symbol(sym.TIMES);
          }
        case 71: break;
        case 45: 
          { return Symbol(sym.UPPER-MIN);
          }
        case 72: break;
        case 3: 
          { return Symbol(sym.INTEGER, new Integer(yytext()));
          }
        case 73: break;
        case 2: 
          { /* ignoring */
          }
        case 74: break;
        case 25: 
          { return Symbol(sym.MARR);
          }
        case 75: break;
        case 6: 
          { return Symbol(sym.OPBRAC);
          }
        case 76: break;
        case 11: 
          { return Symbol(sym.POLKADOT);
          }
        case 77: break;
        case 7: 
          { return Symbol(sym.CLBRAC);
          }
        case 78: break;
        case 42: 
          { return Symbol(sym.REVENUE);
          }
        case 79: break;
        case 17: 
          { return Symbol(sym.SEMICOLON);
          }
        case 80: break;
        case 28: 
          { return Symbol(sym.TREE);
          }
        case 81: break;
        case 34: 
          { return Symbol(sym.OPTIMIZER);
          }
        case 82: break;
        case 38: 
          { return Symbol(sym.FRENCH);
          }
        case 83: break;
        case 37: 
          { return Symbol(sym.FIRST);
          }
        case 84: break;
        case 36: 
          { return Symbol(sym.ASSETS);
          }
        case 85: break;
        case 5: 
          { return Symbol(sym.MINUS);
          }
        case 86: break;
        case 46: 
          { return Symbol(sym.SCENARIO);
          }
        case 87: break;
        case 39: 
          { return Symbol(sym.PATENT);
          }
        case 88: break;
        case 23: 
          { return Symbol(sym.FLOAT, new Double(yytext()));
          }
        case 89: break;
        case 18: 
          { return Symbol(sym.EQUALS);
          }
        case 90: break;
        case 48: 
          { return Symbol(sym.PROGNOSTIC);
          }
        case 91: break;
        case 12: 
          { return Symbol(sym.OPCURLYBRAC);
          }
        case 92: break;
        case 14: 
          { return Symbol(sym.COMMA);
          }
        case 93: break;
        case 35: 
          { return Symbol(sym.OUTLAY);
          }
        case 94: break;
        case 47: 
          { return Symbol(sym.TIERED);
          }
        case 95: break;
        case 21: 
          { return Symbol(sym.NO, false);
          }
        case 96: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {   return new Symbol(sym.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
