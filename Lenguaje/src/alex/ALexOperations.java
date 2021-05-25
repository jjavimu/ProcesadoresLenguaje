package alex;

import asint.ClaseLexica;

public class ALexOperations {
   private AnalizadorLexicoTiny alex;

   public ALexOperations(AnalizadorLexicoTiny alex) {
      this.alex = alex;
   }

   public UnidadLexica unidadId() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IDEN, alex.lexema());
   }

   public UnidadLexica unidadEnt() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ENT, alex.lexema());
   }

   public UnidadLexica unidadReal() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.REAL, alex.lexema());
   }

   public UnidadLexica unidadSuma() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAS, "+");
   }

   public UnidadLexica unidadResta() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MENOS, "-");
   }

   public UnidadLexica unidadMul() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.POR, "*");
   }

   public UnidadLexica unidadDiv() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DIV, "/");
   }

   public UnidadLexica unidadPot() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.POTENCIA, alex.lexema());
   }

   public UnidadLexica unidadMod() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MOD, alex.lexema());
   }

   public UnidadLexica unidadPAp() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PAP, "(");
   }

   public UnidadLexica unidadPCierre() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PCIERRE, ")");
   }

   public UnidadLexica unidadIgual() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IGUAL, "=");
   }

   public UnidadLexica unidadComa() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.COMA, ",");
   }

   public UnidadLexica unidadPunto() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PUNTO, ".");
   }

   public UnidadLexica unidadPuntoyComa() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PUNTOYCOMA, ";");
   }

   public UnidadLexica unidadDospuntos() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DOSPUNTOS, alex.lexema());
   }

   public UnidadLexica unidadEof() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.EOF, "<EOF>");
   }

   public UnidadLexica unidadMayor() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAYOR, alex.lexema());
   }

   public UnidadLexica unidadMenor() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MENOR, alex.lexema());
   }

   public UnidadLexica unidadMayorIgual() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAYORIGUAL, alex.lexema());
   }

   public UnidadLexica unidadMenorIgual() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MENORIGUAL, alex.lexema());
   }

   public UnidadLexica unidadDistinto() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DISTINTO, alex.lexema());
   }

   public UnidadLexica unidadIgualdad() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IGUALDAD, alex.lexema());
   }

   public UnidadLexica unidadAnd() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.AND, alex.lexema());
   }

   public UnidadLexica unidadOr() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.OR, alex.lexema());
   }

   public UnidadLexica unidadNegacion() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NEG, alex.lexema());
   }

   public UnidadLexica unidadCAp() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CAP, "[");
   }

   public UnidadLexica unidadCCierre() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CCIERRE, "]");
   }

   public UnidadLexica unidadLlaveApertura() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LAP, alex.lexema());
   }

   public UnidadLexica unidadLlaveCierre() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.LCIERRE, alex.lexema());
   }

   public UnidadLexica unidadInt() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.INT, alex.lexema());
   }

   public UnidadLexica unidadVoid() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.VOID, alex.lexema());
   }

   public UnidadLexica unidadChar() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CHAR, alex.lexema());
   }

   public UnidadLexica unidadFloat() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.FLOAT, alex.lexema());
   }

   public UnidadLexica unidadBool() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.BOOL, alex.lexema());
   }

   public UnidadLexica unidadEnum() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ENUM, alex.lexema());
   }

   public UnidadLexica unidadTrue() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.TRUE, alex.lexema());
   }

   public UnidadLexica unidadFalse() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.FALSE, alex.lexema());
   }

   public UnidadLexica unidadCaracter() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CARACTER, alex.lexema());
   }

   public UnidadLexica unidadCadenaCaracteres() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CADENA, alex.lexema());
   }

   public UnidadLexica unidadString() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.STRING, alex.lexema());
   }

   public UnidadLexica unidadNew() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.NEW, alex.lexema());
   }

   public UnidadLexica unidadWhile() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.WHILE, alex.lexema());
   }

   public UnidadLexica unidadFor() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.FOR, alex.lexema());
   }

   public UnidadLexica unidadIf() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.IF, alex.lexema());
   }

   public UnidadLexica unidadElse() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.ELSE, alex.lexema());
   }

   public UnidadLexica unidadStruct() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.STRUCT, alex.lexema());
   }

   public UnidadLexica unidadSwitch() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.SWITCH, alex.lexema());
   }

   public UnidadLexica unidadCase() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.CASE, alex.lexema());
   }

   public UnidadLexica unidadBreak() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.BREAK, alex.lexema());
   }

   public UnidadLexica unidadDefault() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.DEFAULT, alex.lexema());
   }

   public UnidadLexica unidadReturn() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.RETURN, alex.lexema());
   }

   public UnidadLexica unidadPrint() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.PRINT, alex.lexema());
   }

   public UnidadLexica unidadMain() {
      return new UnidadLexica(alex.fila(), alex.columna(), ClaseLexica.MAIN, alex.lexema());
   }

}
