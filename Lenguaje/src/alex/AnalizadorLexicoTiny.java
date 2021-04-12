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
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
   this.errores = errores;
  }
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
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
		/* 58 */ YY_NOT_ACCEPT,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NOT_ACCEPT,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NOT_ACCEPT,
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
		/* 130 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"3:8,47:2,1,3:2,4,3:18,47,18,48,3:2,14,19,46,24,25,10,8,21,9,7,2,6,5:9,23,22" +
",16,17,15,3:2,51:26,26,3,27,3:3,38,42,36,35,11,40,52,37,30,52,50,41,44,31,3" +
"4,13,52,39,45,32,43,33,49,12,52:2,28,20,29,3:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,131,
"0,1:2,2,3,1:4,4,1,5,6,7,8,9,1:9,10,11,1:6,12,13,12:4,1,12:18,14,1,15,16,17," +
"13,18,19,20,12,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40," +
"41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,12,59,60,61,62,63,64," +
"65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82")[0];

	private int yy_nxt[][] = unpackFromString(83,53,
"1,2,3,-1,2,4,59,5,6,7,8,9,106,115,10,11,12,13,14,15,58,16,17,18,19,20,21,22" +
",23,24,60,118,120,122,106,123,124,106:2,125,126,106,127,106,128,129,61,2,63" +
",130,106:3,-1:55,25,-1:55,4:2,26,-1:50,106:2,-1:4,106,62,106,-1:16,106,64,1" +
"06:9,66,106:4,-1:3,106:2,67,106,-1:17,27,-1:52,28,-1:52,29,-1:52,30,-1:54,3" +
"1,-1:35,25:51,-1:5,26:2,-1:51,106:2,-1:4,106:3,-1:16,106:16,-1:3,106:2,67,1" +
"06,-1:2,63:2,-1,63:43,34,63:4,-1:20,32,-1:37,106:2,-1:4,106:3,-1:16,106,69," +
"106:8,33,106:5,-1:3,106:2,67,106,-1:2,65:2,-1,65:48,-1:5,106:2,-1:4,106:2,3" +
"5,-1:16,106:16,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:13,79,106:" +
"2,-1:3,106:2,67,106,-1:46,39,-1:11,106:2,-1:4,106:3,-1:16,106:15,80,-1:3,10" +
"6:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,81,106:15,-1:3,106:2,67,106,-1:5,106" +
":2,-1:4,106:3,-1:16,106:2,36,106:13,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3" +
",-1:16,106:16,-1:3,37,106,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:10,110,106" +
":5,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:8,84,106:7,-1:3,106:2," +
"67,106,-1:5,106:2,-1:4,106:3,-1:16,106:2,86,106:13,-1:3,106:2,67,106,-1:5,1" +
"06:2,-1:4,106:3,-1:16,106:9,38,106:6,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:" +
"3,-1:16,106:11,87,106:4,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:4" +
",88,106:11,-1:3,106:2,67,106,-1:5,106:2,-1:4,113,106:2,-1:16,106:16,-1:3,10" +
"6:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:9,112,106:6,-1:3,106:2,67,106,-1" +
":5,106:2,-1:4,106:3,-1:16,106:14,40,106,-1:3,106:2,67,106,-1:5,106:2,-1:4,4" +
"1,106:2,-1:16,93,106:15,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106,9" +
"4,106:14,-1:3,106:2,67,106,-1:5,106:2,-1:4,42,106:2,-1:16,106:16,-1:3,106:2" +
",67,106,-1:5,106:2,-1:4,106:3,-1:16,106:5,43,106:10,-1:3,106:2,67,106,-1:5," +
"106:2,-1:4,106:3,-1:16,106:9,44,106:6,-1:3,106:2,67,106,-1:5,106:2,-1:4,45," +
"106:2,-1:16,106:16,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:13,95," +
"106:2,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:15,96,-1:3,106:2,67" +
",106,-1:5,106:2,-1:4,106:3,-1:16,106:8,97,106:7,-1:3,106:2,67,106,-1:5,106:" +
"2,-1:4,106:3,-1:16,106:11,46,106:4,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3," +
"-1:16,106,47,106:14,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:2,114" +
",106:13,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:11,100,106:4,-1:3" +
",106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:10,48,106:5,-1:3,106:2,67,106" +
",-1:5,106:2,-1:4,106:3,-1:16,106:2,49,106:13,-1:3,106:2,67,106,-1:5,106:2,-" +
"1:4,106:3,-1:16,106:9,102,106:6,-1:3,106:2,67,106,-1:5,106:2,-1:4,50,106:2," +
"-1:16,106:16,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:2,51,106:13," +
"-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:16,-1:3,106,52,67,106,-1:" +
"5,106:2,-1:4,106:3,-1:16,106:6,103,106:9,-1:3,106:2,67,106,-1:5,106:2,-1:4," +
"53,106:2,-1:16,106:16,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:11," +
"105,106:4,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106,54,106:14,-1:3," +
"106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:2,55,106:13,-1:3,106:2,67,106," +
"-1:5,106:2,-1:4,106:3,-1:16,106:7,56,106:8,-1:3,106:2,67,106,-1:5,106:2,-1:" +
"4,106:3,-1:16,106:2,57,106:13,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16" +
",106:13,82,106:2,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:15,85,-1" +
":3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,83,106:15,-1:3,106:2,67,106,-1:" +
"5,106:2,-1:4,106:3,-1:16,106:8,117,106:7,-1:3,106:2,67,106,-1:5,106:2,-1:4," +
"106:3,-1:16,106:4,89,106:11,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,1" +
"06:13,99,106:2,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:8,98,106:7" +
",-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:6,104,106:9,-1:3,106:2,6" +
"7,106,-1:5,106:2,-1:4,106:3,-1:16,106:9,68,106:6,-1:3,106:2,67,106,-1:5,106" +
":2,-1:4,106:3,-1:16,90,106:15,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16" +
",106:13,101,106:2,-1:3,106:2,67,106,-1:5,106:2,-1:4,70,106:2,-1:16,106:16,-" +
"1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,91,106:15,-1:3,106:2,67,106,-1" +
":5,106:2,-1:4,106:3,-1:16,106:9,107,106:6,-1:3,106:2,67,106,-1:5,106:2,-1:4" +
",106:3,-1:16,92,106:15,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:4," +
"109,106:11,-1:3,106:2,67,106,-1:5,106:2,-1:4,71,106:2,-1:16,106:16,-1:3,106" +
":2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:7,72,108,106:7,-1:3,106:2,67,106," +
"-1:5,106:2,-1:4,73,106:2,-1:16,106:16,-1:3,106:2,67,106,-1:5,106:2,-1:4,106" +
":3,-1:16,106:4,74,106:3,75,106:2,76,106:4,-1:3,106:2,67,106,-1:5,106:2,-1:4" +
",106:3,-1:16,106:4,111,106:4,77,106:6,-1:3,106:2,67,106,-1:5,106:2,-1:4,106" +
":3,-1:16,106:8,116,106:7,-1:3,106:2,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:" +
"2,78,106:13,-1:3,119,106,67,106,-1:5,106:2,-1:4,106:3,-1:16,106:7,121,106:8" +
",-1:3,106:2,67,106");

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
						{return ops.unidadDiv();}
					case -4:
						break;
					case 4:
						{return ops.unidadEnt();}
					case -5:
						break;
					case 5:
						{return ops.unidadPunto();}
					case -6:
						break;
					case 6:
						{return ops.unidadSuma();}
					case -7:
						break;
					case 7:
						{return ops.unidadResta();}
					case -8:
						break;
					case 8:
						{return ops.unidadMul();}
					case -9:
						break;
					case 9:
						{return ops.unidadId();}
					case -10:
						break;
					case 10:
						{return ops.unidadMod();}
					case -11:
						break;
					case 11:
						{return ops.unidadMayor();}
					case -12:
						break;
					case 12:
						{return ops.unidadMenor();}
					case -13:
						break;
					case 13:
						{return ops.unidadIgual();}
					case -14:
						break;
					case 14:
						{return ops.unidadNegacion();}
					case -15:
						break;
					case 15:
						{return ops.unidadReferencia();}
					case -16:
						break;
					case 16:
						{return ops.unidadComa();}
					case -17:
						break;
					case 17:
						{return ops.unidadPuntoyComa();}
					case -18:
						break;
					case 18:
						{return ops.unidadDospuntos();}
					case -19:
						break;
					case 19:
						{return ops.unidadPAp();}
					case -20:
						break;
					case 20:
						{return ops.unidadPCierre();}
					case -21:
						break;
					case 21:
						{return ops.unidadCAp();}
					case -22:
						break;
					case 22:
						{return ops.unidadCCierre();}
					case -23:
						break;
					case 23:
						{return ops.unidadLlaveApertura();}
					case -24:
						break;
					case 24:
						{return ops.unidadLlaveCierre();}
					case -25:
						break;
					case 25:
						{}
					case -26:
						break;
					case 26:
						{return ops.unidadReal();}
					case -27:
						break;
					case 27:
						{return ops.unidadMayorIgual();}
					case -28:
						break;
					case 28:
						{return ops.unidadMenorIgual();}
					case -29:
						break;
					case 29:
						{return ops.unidadIgualdad();}
					case -30:
						break;
					case 30:
						{return ops.unidadDistinto();}
					case -31:
						break;
					case 31:
						{return ops.unidadAnd();}
					case -32:
						break;
					case 32:
						{return ops.unidadOr();}
					case -33:
						break;
					case 33:
						{return ops.unidadIf();}
					case -34:
						break;
					case 34:
						{return ops.unidadCadenaCaracteres();}
					case -35:
						break;
					case 35:
						{return ops.unidadPot();}
					case -36:
						break;
					case 36:
						{return ops.unidadInt();}
					case -37:
						break;
					case 37:
						{return ops.unidadNew();}
					case -38:
						break;
					case 38:
						{return ops.unidadFor();}
					case -39:
						break;
					case 39:
						{return ops.unidadCaracter();}
					case -40:
						break;
					case 40:
						{return ops.unidadEnum();}
					case -41:
						break;
					case 41:
						{return ops.unidadElse();}
					case -42:
						break;
					case 42:
						{return ops.unidadTrue();}
					case -43:
						break;
					case 43:
						{return ops.unidadVoid();}
					case -44:
						break;
					case 44:
						{return ops.unidadChar();}
					case -45:
						break;
					case 45:
						{return ops.unidadCase();}
					case -46:
						break;
					case 46:
						{return ops.unidadBool();}
					case -47:
						break;
					case 47:
						{return ops.unidadMain();}
					case -48:
						break;
					case 48:
						{return ops.unidadElsif();}
					case -49:
						break;
					case 49:
						{return ops.unidadPrint();}
					case -50:
						break;
					case 50:
						{return ops.unidadFalse();}
					case -51:
						break;
					case 51:
						{return ops.unidadFloat();}
					case -52:
						break;
					case 52:
						{return ops.unidadBreak();}
					case -53:
						break;
					case 53:
						{return ops.unidadWhile();}
					case -54:
						break;
					case 54:
						{return ops.unidadReturn();}
					case -55:
						break;
					case 55:
						{return ops.unidadStruct();}
					case -56:
						break;
					case 56:
						{return ops.unidadSwitch();}
					case -57:
						break;
					case 57:
						{return ops.unidadDefault();}
					case -58:
						break;
					case 59:
						{return ops.unidadEnt();}
					case -59:
						break;
					case 60:
						{return ops.unidadId();}
					case -60:
						break;
					case 62:
						{return ops.unidadId();}
					case -61:
						break;
					case 64:
						{return ops.unidadId();}
					case -62:
						break;
					case 66:
						{return ops.unidadId();}
					case -63:
						break;
					case 67:
						{return ops.unidadId();}
					case -64:
						break;
					case 68:
						{return ops.unidadId();}
					case -65:
						break;
					case 69:
						{return ops.unidadId();}
					case -66:
						break;
					case 70:
						{return ops.unidadId();}
					case -67:
						break;
					case 71:
						{return ops.unidadId();}
					case -68:
						break;
					case 72:
						{return ops.unidadId();}
					case -69:
						break;
					case 73:
						{return ops.unidadId();}
					case -70:
						break;
					case 74:
						{return ops.unidadId();}
					case -71:
						break;
					case 75:
						{return ops.unidadId();}
					case -72:
						break;
					case 76:
						{return ops.unidadId();}
					case -73:
						break;
					case 77:
						{return ops.unidadId();}
					case -74:
						break;
					case 78:
						{return ops.unidadId();}
					case -75:
						break;
					case 79:
						{return ops.unidadId();}
					case -76:
						break;
					case 80:
						{return ops.unidadId();}
					case -77:
						break;
					case 81:
						{return ops.unidadId();}
					case -78:
						break;
					case 82:
						{return ops.unidadId();}
					case -79:
						break;
					case 83:
						{return ops.unidadId();}
					case -80:
						break;
					case 84:
						{return ops.unidadId();}
					case -81:
						break;
					case 85:
						{return ops.unidadId();}
					case -82:
						break;
					case 86:
						{return ops.unidadId();}
					case -83:
						break;
					case 87:
						{return ops.unidadId();}
					case -84:
						break;
					case 88:
						{return ops.unidadId();}
					case -85:
						break;
					case 89:
						{return ops.unidadId();}
					case -86:
						break;
					case 90:
						{return ops.unidadId();}
					case -87:
						break;
					case 91:
						{return ops.unidadId();}
					case -88:
						break;
					case 92:
						{return ops.unidadId();}
					case -89:
						break;
					case 93:
						{return ops.unidadId();}
					case -90:
						break;
					case 94:
						{return ops.unidadId();}
					case -91:
						break;
					case 95:
						{return ops.unidadId();}
					case -92:
						break;
					case 96:
						{return ops.unidadId();}
					case -93:
						break;
					case 97:
						{return ops.unidadId();}
					case -94:
						break;
					case 98:
						{return ops.unidadId();}
					case -95:
						break;
					case 99:
						{return ops.unidadId();}
					case -96:
						break;
					case 100:
						{return ops.unidadId();}
					case -97:
						break;
					case 101:
						{return ops.unidadId();}
					case -98:
						break;
					case 102:
						{return ops.unidadId();}
					case -99:
						break;
					case 103:
						{return ops.unidadId();}
					case -100:
						break;
					case 104:
						{return ops.unidadId();}
					case -101:
						break;
					case 105:
						{return ops.unidadId();}
					case -102:
						break;
					case 106:
						{return ops.unidadId();}
					case -103:
						break;
					case 107:
						{return ops.unidadId();}
					case -104:
						break;
					case 108:
						{return ops.unidadId();}
					case -105:
						break;
					case 109:
						{return ops.unidadId();}
					case -106:
						break;
					case 110:
						{return ops.unidadId();}
					case -107:
						break;
					case 111:
						{return ops.unidadId();}
					case -108:
						break;
					case 112:
						{return ops.unidadId();}
					case -109:
						break;
					case 113:
						{return ops.unidadId();}
					case -110:
						break;
					case 114:
						{return ops.unidadId();}
					case -111:
						break;
					case 115:
						{return ops.unidadId();}
					case -112:
						break;
					case 116:
						{return ops.unidadId();}
					case -113:
						break;
					case 117:
						{return ops.unidadId();}
					case -114:
						break;
					case 118:
						{return ops.unidadId();}
					case -115:
						break;
					case 119:
						{return ops.unidadId();}
					case -116:
						break;
					case 120:
						{return ops.unidadId();}
					case -117:
						break;
					case 121:
						{return ops.unidadId();}
					case -118:
						break;
					case 122:
						{return ops.unidadId();}
					case -119:
						break;
					case 123:
						{return ops.unidadId();}
					case -120:
						break;
					case 124:
						{return ops.unidadId();}
					case -121:
						break;
					case 125:
						{return ops.unidadId();}
					case -122:
						break;
					case 126:
						{return ops.unidadId();}
					case -123:
						break;
					case 127:
						{return ops.unidadId();}
					case -124:
						break;
					case 128:
						{return ops.unidadId();}
					case -125:
						break;
					case 129:
						{return ops.unidadId();}
					case -126:
						break;
					case 130:
						{return ops.unidadId();}
					case -127:
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
