package alex;
import errors.GestionErroresTiny;


public class AnalizadorLexicoTiny implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

  private ALexOperations ops;
  private int charline = 0;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public int columna() {return yychar +1 - charline;}
  private void refrescaColumna() {
    charline = yychar + yytext().length();
  }
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public AnalizadorLexicoTiny (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public AnalizadorLexicoTiny (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private AnalizadorLexicoTiny () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;

  ops = new ALexOperations(this);
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NOT_ACCEPT,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NOT_ACCEPT,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"4:8,1:2,2,4:2,5,4:18,1,19,49,4:2,15,20,48,25,26,11,9,22,10,8,3,7,6:9,24,23," +
"17,18,16,4:2,52:26,27,4,28,4,54,4,39,45,37,36,12,43,42,38,31,53,51,44,47,32" +
",35,14,53,40,41,33,46,34,50,13,53:2,29,21,30,4:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,137,
"0,1:3,2,1,3,1:4,4,1,5,6,7,8,9,1:9,10,11,1:6,12,13,12:4,1,12:19,14,15,1,16,1" +
"3,17,18,13,19,20,12,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,3" +
"9,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,12,62,6" +
"3,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84")[0];

	private int yy_nxt[][] = unpackFromString(85,55,
"1,2,3,4,5,3,6,63,7,8,9,10,11,113,122,12,13,14,15,16,17,62,18,19,20,21,22,23" +
",24,25,26,64,124,126,128,113,129,130,113:2,131,132,113,133,113,134,113,135," +
"66,68,136,113:3,5,-1:58,27,-1:57,6:2,28,-1:52,113:2,-1:4,113,67,113,-1:16,1" +
"13,69,113:11,70,113:3,-1:2,113:2,71,113,71,-1:18,29,-1:54,30,-1:54,31,-1:54" +
",32,-1:56,33,-1:35,27,-1,27:52,-1:6,28:2,-1:53,113:2,-1:4,113:3,-1:16,113:1" +
"7,-1:2,113:2,71,113,71,-1,65,-1,65:2,-1,65:43,36,65:5,-1:48,41,-1:27,34,-1:" +
"39,113:2,-1:4,113:3,-1:16,113,73,113:10,35,113:4,-1:2,113:2,71,113,71,-1,61" +
",-1,61:2,-1,61:49,-1:6,113:2,-1:4,113:2,37,-1:16,113:17,-1:2,113:2,71,113,7" +
"1,-1:6,113:2,-1:4,113:3,-1:16,113:15,83,113,-1:2,113:2,71,113,71,-1:6,113:2" +
",-1:4,113:3,-1:16,113:10,84,113:6,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:" +
"3,-1:16,85,113:16,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:2,38" +
",113:14,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:17,-1:2,39,113" +
",71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:12,117,113:4,-1:2,113:2,71,113,7" +
"1,-1:6,113:2,-1:4,113:3,-1:16,113:8,88,113:8,-1:2,113:2,71,113,71,-1:6,113:" +
"2,-1:4,113:3,-1:16,113:2,90,113:14,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113" +
":3,-1:16,113:9,91,113:7,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,11" +
"3:9,40,113:7,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:13,93,113" +
":3,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:4,94,113:12,-1:2,11" +
"3:2,71,113,71,-1:6,113:2,-1:4,120,113:2,-1:16,113:17,-1:2,113:2,71,113,71,-" +
"1:6,113:2,-1:4,113:3,-1:16,113:16,42,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,4" +
"3,113:2,-1:16,98,113:16,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,11" +
"3,99,113:15,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,44,113:2,-1:16,113:17,-1:2" +
",113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:5,45,113:11,-1:2,113:2,71," +
"113,71,-1:6,113:2,-1:4,113:3,-1:16,113:9,46,113:7,-1:2,113:2,71,113,71,-1:6" +
",113:2,-1:4,47,113:2,-1:16,113:17,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:" +
"3,-1:16,113:15,100,113,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,101" +
",113:14,102,113,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:2,121," +
"113:14,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:10,103,113:6,-1" +
":2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:8,104,113:8,-1:2,113:2,7" +
"1,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:13,48,113:3,-1:2,113:2,71,113,71,-" +
"1:6,113:2,-1:4,113:3,-1:16,113,49,113:15,-1:2,113:2,71,113,71,-1:6,113:2,-1" +
":4,113:3,-1:16,113:13,106,113:3,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3," +
"-1:16,113:12,50,113:4,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:" +
"2,51,113:14,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:9,108,113:" +
"7,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113,109,113:15,-1:2,113:" +
"2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:6,110,113:10,-1:2,113:2,71,113," +
"71,-1:6,113:2,-1:4,52,113:2,-1:16,113:17,-1:2,113:2,71,113,71,-1:6,113:2,-1" +
":4,113:3,-1:16,113:2,53,113:14,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-" +
"1:16,113:17,-1:2,113,54,71,113,71,-1:6,113:2,-1:4,55,113:2,-1:16,113:17,-1:" +
"2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:13,112,113:3,-1:2,113:2,7" +
"1,113,71,-1:6,113:2,-1:4,113:3,-1:16,113,56,113:15,-1:2,113:2,71,113,71,-1:" +
"6,113:2,-1:4,113:3,-1:16,113:11,57,113:5,-1:2,113:2,71,113,71,-1:6,113:2,-1" +
":4,113:3,-1:16,113:2,58,113:14,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-" +
"1:16,113:7,59,113:9,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:2," +
"60,113:14,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:15,86,113,-1" +
":2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:10,89,113:6,-1:2,113:2,7" +
"1,113,71,-1:6,113:2,-1:4,113:3,-1:16,87,113:16,-1:2,113:2,71,113,71,-1:6,11" +
"3:2,-1:4,113:3,-1:16,113:8,119,113:8,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,1" +
"13:3,-1:16,113:4,95,113:12,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16" +
",113:15,107,113,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:8,105," +
"113:8,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:6,111,113:10,-1:" +
"2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:9,72,113:7,-1:2,113:2,71," +
"113,71,-1:6,113:2,-1:4,113:3,-1:16,92,113:16,-1:2,113:2,71,113,71,-1:6,113:" +
"2,-1:4,74,113:2,-1:16,113:17,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:" +
"16,96,113:16,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:9,114,113" +
":7,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,97,113:16,-1:2,113:2,71" +
",113,71,-1:6,113:2,-1:4,113:3,-1:16,113:4,116,113:12,-1:2,113:2,71,113,71,-" +
"1:6,113:2,-1:4,75,113:2,-1:16,113:17,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,1" +
"13:3,-1:16,113:7,76,115,113:8,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,77,113:2" +
",-1:16,113:17,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:2,78,113" +
":14,-1:2,123,113,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:4,79,113:3,80,11" +
"3:4,81,113:3,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:4,118,113" +
":4,82,113:7,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:8,125,113:" +
"8,-1:2,113:2,71,113,71,-1:6,113:2,-1:4,113:3,-1:16,113:7,127,113:9,-1:2,113" +
":2,71,113,71");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {

  return ops.unidadEof();
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{}
					case -3:
						break;
					case 3:
						{refrescaColumna();}
					case -4:
						break;
					case 4:
						{return ops.unidadDiv();}
					case -5:
						break;
					case 5:
						{errores.errorLexico(fila(),columna(),lexema());}
					case -6:
						break;
					case 6:
						{return ops.unidadEnt();}
					case -7:
						break;
					case 7:
						{return ops.unidadPunto();}
					case -8:
						break;
					case 8:
						{return ops.unidadSuma();}
					case -9:
						break;
					case 9:
						{return ops.unidadResta();}
					case -10:
						break;
					case 10:
						{return ops.unidadMul();}
					case -11:
						break;
					case 11:
						{return ops.unidadId();}
					case -12:
						break;
					case 12:
						{return ops.unidadMod();}
					case -13:
						break;
					case 13:
						{return ops.unidadMayor();}
					case -14:
						break;
					case 14:
						{return ops.unidadMenor();}
					case -15:
						break;
					case 15:
						{return ops.unidadIgual();}
					case -16:
						break;
					case 16:
						{return ops.unidadNegacion();}
					case -17:
						break;
					case 17:
						{return ops.unidadReferencia();}
					case -18:
						break;
					case 18:
						{return ops.unidadComa();}
					case -19:
						break;
					case 19:
						{return ops.unidadPuntoyComa();}
					case -20:
						break;
					case 20:
						{return ops.unidadDospuntos();}
					case -21:
						break;
					case 21:
						{return ops.unidadPAp();}
					case -22:
						break;
					case 22:
						{return ops.unidadPCierre();}
					case -23:
						break;
					case 23:
						{return ops.unidadCAp();}
					case -24:
						break;
					case 24:
						{return ops.unidadCCierre();}
					case -25:
						break;
					case 25:
						{return ops.unidadLlaveApertura();}
					case -26:
						break;
					case 26:
						{return ops.unidadLlaveCierre();}
					case -27:
						break;
					case 27:
						{refrescaColumna();}
					case -28:
						break;
					case 28:
						{return ops.unidadReal();}
					case -29:
						break;
					case 29:
						{return ops.unidadMayorIgual();}
					case -30:
						break;
					case 30:
						{return ops.unidadMenorIgual();}
					case -31:
						break;
					case 31:
						{return ops.unidadIgualdad();}
					case -32:
						break;
					case 32:
						{return ops.unidadDistinto();}
					case -33:
						break;
					case 33:
						{return ops.unidadAnd();}
					case -34:
						break;
					case 34:
						{return ops.unidadOr();}
					case -35:
						break;
					case 35:
						{return ops.unidadIf();}
					case -36:
						break;
					case 36:
						{return ops.unidadCadenaCaracteres();}
					case -37:
						break;
					case 37:
						{return ops.unidadPot();}
					case -38:
						break;
					case 38:
						{return ops.unidadInt();}
					case -39:
						break;
					case 39:
						{return ops.unidadNew();}
					case -40:
						break;
					case 40:
						{return ops.unidadFor();}
					case -41:
						break;
					case 41:
						{return ops.unidadCaracter();}
					case -42:
						break;
					case 42:
						{return ops.unidadEnum();}
					case -43:
						break;
					case 43:
						{return ops.unidadElse();}
					case -44:
						break;
					case 44:
						{return ops.unidadTrue();}
					case -45:
						break;
					case 45:
						{return ops.unidadVoid();}
					case -46:
						break;
					case 46:
						{return ops.unidadChar();}
					case -47:
						break;
					case 47:
						{return ops.unidadCase();}
					case -48:
						break;
					case 48:
						{return ops.unidadBool();}
					case -49:
						break;
					case 49:
						{return ops.unidadMain();}
					case -50:
						break;
					case 50:
						{return ops.unidadElsif();}
					case -51:
						break;
					case 51:
						{return ops.unidadPrint();}
					case -52:
						break;
					case 52:
						{return ops.unidadFalse();}
					case -53:
						break;
					case 53:
						{return ops.unidadFloat();}
					case -54:
						break;
					case 54:
						{return ops.unidadBreak();}
					case -55:
						break;
					case 55:
						{return ops.unidadWhile();}
					case -56:
						break;
					case 56:
						{return ops.unidadReturn();}
					case -57:
						break;
					case 57:
						{return ops.unidadString();}
					case -58:
						break;
					case 58:
						{return ops.unidadStruct();}
					case -59:
						break;
					case 59:
						{return ops.unidadSwitch();}
					case -60:
						break;
					case 60:
						{return ops.unidadDefault();}
					case -61:
						break;
					case 62:
						{errores.errorLexico(fila(),columna(),lexema());}
					case -62:
						break;
					case 63:
						{return ops.unidadEnt();}
					case -63:
						break;
					case 64:
						{return ops.unidadId();}
					case -64:
						break;
					case 66:
						{errores.errorLexico(fila(),columna(),lexema());}
					case -65:
						break;
					case 67:
						{return ops.unidadId();}
					case -66:
						break;
					case 68:
						{errores.errorLexico(fila(),columna(),lexema());}
					case -67:
						break;
					case 69:
						{return ops.unidadId();}
					case -68:
						break;
					case 70:
						{return ops.unidadId();}
					case -69:
						break;
					case 71:
						{return ops.unidadId();}
					case -70:
						break;
					case 72:
						{return ops.unidadId();}
					case -71:
						break;
					case 73:
						{return ops.unidadId();}
					case -72:
						break;
					case 74:
						{return ops.unidadId();}
					case -73:
						break;
					case 75:
						{return ops.unidadId();}
					case -74:
						break;
					case 76:
						{return ops.unidadId();}
					case -75:
						break;
					case 77:
						{return ops.unidadId();}
					case -76:
						break;
					case 78:
						{return ops.unidadId();}
					case -77:
						break;
					case 79:
						{return ops.unidadId();}
					case -78:
						break;
					case 80:
						{return ops.unidadId();}
					case -79:
						break;
					case 81:
						{return ops.unidadId();}
					case -80:
						break;
					case 82:
						{return ops.unidadId();}
					case -81:
						break;
					case 83:
						{return ops.unidadId();}
					case -82:
						break;
					case 84:
						{return ops.unidadId();}
					case -83:
						break;
					case 85:
						{return ops.unidadId();}
					case -84:
						break;
					case 86:
						{return ops.unidadId();}
					case -85:
						break;
					case 87:
						{return ops.unidadId();}
					case -86:
						break;
					case 88:
						{return ops.unidadId();}
					case -87:
						break;
					case 89:
						{return ops.unidadId();}
					case -88:
						break;
					case 90:
						{return ops.unidadId();}
					case -89:
						break;
					case 91:
						{return ops.unidadId();}
					case -90:
						break;
					case 92:
						{return ops.unidadId();}
					case -91:
						break;
					case 93:
						{return ops.unidadId();}
					case -92:
						break;
					case 94:
						{return ops.unidadId();}
					case -93:
						break;
					case 95:
						{return ops.unidadId();}
					case -94:
						break;
					case 96:
						{return ops.unidadId();}
					case -95:
						break;
					case 97:
						{return ops.unidadId();}
					case -96:
						break;
					case 98:
						{return ops.unidadId();}
					case -97:
						break;
					case 99:
						{return ops.unidadId();}
					case -98:
						break;
					case 100:
						{return ops.unidadId();}
					case -99:
						break;
					case 101:
						{return ops.unidadId();}
					case -100:
						break;
					case 102:
						{return ops.unidadId();}
					case -101:
						break;
					case 103:
						{return ops.unidadId();}
					case -102:
						break;
					case 104:
						{return ops.unidadId();}
					case -103:
						break;
					case 105:
						{return ops.unidadId();}
					case -104:
						break;
					case 106:
						{return ops.unidadId();}
					case -105:
						break;
					case 107:
						{return ops.unidadId();}
					case -106:
						break;
					case 108:
						{return ops.unidadId();}
					case -107:
						break;
					case 109:
						{return ops.unidadId();}
					case -108:
						break;
					case 110:
						{return ops.unidadId();}
					case -109:
						break;
					case 111:
						{return ops.unidadId();}
					case -110:
						break;
					case 112:
						{return ops.unidadId();}
					case -111:
						break;
					case 113:
						{return ops.unidadId();}
					case -112:
						break;
					case 114:
						{return ops.unidadId();}
					case -113:
						break;
					case 115:
						{return ops.unidadId();}
					case -114:
						break;
					case 116:
						{return ops.unidadId();}
					case -115:
						break;
					case 117:
						{return ops.unidadId();}
					case -116:
						break;
					case 118:
						{return ops.unidadId();}
					case -117:
						break;
					case 119:
						{return ops.unidadId();}
					case -118:
						break;
					case 120:
						{return ops.unidadId();}
					case -119:
						break;
					case 121:
						{return ops.unidadId();}
					case -120:
						break;
					case 122:
						{return ops.unidadId();}
					case -121:
						break;
					case 123:
						{return ops.unidadId();}
					case -122:
						break;
					case 124:
						{return ops.unidadId();}
					case -123:
						break;
					case 125:
						{return ops.unidadId();}
					case -124:
						break;
					case 126:
						{return ops.unidadId();}
					case -125:
						break;
					case 127:
						{return ops.unidadId();}
					case -126:
						break;
					case 128:
						{return ops.unidadId();}
					case -127:
						break;
					case 129:
						{return ops.unidadId();}
					case -128:
						break;
					case 130:
						{return ops.unidadId();}
					case -129:
						break;
					case 131:
						{return ops.unidadId();}
					case -130:
						break;
					case 132:
						{return ops.unidadId();}
					case -131:
						break;
					case 133:
						{return ops.unidadId();}
					case -132:
						break;
					case 134:
						{return ops.unidadId();}
					case -133:
						break;
					case 135:
						{return ops.unidadId();}
					case -134:
						break;
					case 136:
						{return ops.unidadId();}
					case -135:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
