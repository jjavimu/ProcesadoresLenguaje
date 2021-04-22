package alex;

import asint.ClaseLexica;

public class ALexOperations {
   private AnalizadorLexicoTiny alex;

   public ALexOperations(AnalizadorLexicoTiny alex) {
      this.alex = alex;
   }

   public UnidadLexica unidadId() {
      return new UnidadLexica(alex.fila(), ClaseLexica.IDEN, alex.lexema());
   }

   public UnidadLexica unidadEnt() {
      return new UnidadLexica(alex.fila(), ClaseLexica.ENT, alex.lexema());
   }

   public UnidadLexica unidadReal() {
      return new UnidadLexica(alex.fila(), ClaseLexica.REAL, alex.lexema());
   }

   public UnidadLexica unidadSuma() {
      return new UnidadLexica(alex.fila(), ClaseLexica.MAS, "+");
   }

   public UnidadLexica unidadResta() {
      return new UnidadLexica(alex.fila(), ClaseLexica.MENOS, "-");
   }

   public UnidadLexica unidadMul() {
      return new UnidadLexica(alex.fila(), ClaseLexica.POR, "*");
   }

   public UnidadLexica unidadDiv() {
      return new UnidadLexica(alex.fila(), ClaseLexica.DIV, "/");
   }

   public UnidadLexica unidadPot() {
      return new UnidadLexica(alex.fila(), ClaseLexica.POTENCIA, alex.lexema());
   }

   public UnidadLexica unidadMod() {
      return new UnidadLexica(alex.fila(), ClaseLexica.MOD, alex.lexema());
   }

   public UnidadLexica unidadPAp() {
      return new UnidadLexica(alex.fila(), ClaseLexica.PAP, "(");
   }

   public UnidadLexica unidadPCierre() {
      return new UnidadLexica(alex.fila(), ClaseLexica.PCIERRE, ")");
   }

   public UnidadLexica unidadIgual() {
      return new UnidadLexica(alex.fila(), ClaseLexica.IGUAL, "=");
   }

   public UnidadLexica unidadComa() {
      return new UnidadLexica(alex.fila(), ClaseLexica.COMA, ",");
   }

   public UnidadLexica unidadPunto() {
      return new UnidadLexica(alex.fila(), ClaseLexica.PUNTO, ".");
   }

   public UnidadLexica unidadPuntoyComa() {
      return new UnidadLexica(alex.fila(), ClaseLexica.PUNTOYCOMA, ";");
   }

   public UnidadLexica unidadDospuntos() {
      return new UnidadLexica(alex.fila(), ClaseLexica.DOSPUNTOS, alex.lexema());
   }

   public UnidadLexica unidadEof() {
      return new UnidadLexica(alex.fila(), ClaseLexica.EOF, "<EOF>");
   }

   public UnidadLexica unidadMayor() {
      return new UnidadLexica(alex.fila(), ClaseLexica.MAYOR, alex.lexema());
   }

   public UnidadLexica unidadMenor() {
      return new UnidadLexica(alex.fila(), ClaseLexica.MENOR, alex.lexema());
   }

   public UnidadLexica unidadMayorIgual() {
      return new UnidadLexica(alex.fila(), ClaseLexica.MAYORIGUAL, alex.lexema());
   }

   public UnidadLexica unidadMenorIgual() {
      return new UnidadLexica(alex.fila(), ClaseLexica.MENORIGUAL, alex.lexema());
   }

   public UnidadLexica unidadDistinto() {
      return new UnidadLexica(alex.fila(), ClaseLexica.DISTINTO, alex.lexema());
   }

   public UnidadLexica unidadIgualdad() {
      return new UnidadLexica(alex.fila(), ClaseLexica.IGUALDAD, alex.lexema());
   }

   public UnidadLexica unidadAnd() {
      return new UnidadLexica(alex.fila(), ClaseLexica.AND, alex.lexema());
   }

   public UnidadLexica unidadOr() {
      return new UnidadLexica(alex.fila(), ClaseLexica.OR, alex.lexema());
   }

   public UnidadLexica unidadNegacion() {
      return new UnidadLexica(alex.fila(), ClaseLexica.NEG, alex.lexema());
   }

   public UnidadLexica unidadCAp() {
      return new UnidadLexica(alex.fila(), ClaseLexica.CAP, "[");
   }

   public UnidadLexica unidadCCierre() {
      return new UnidadLexica(alex.fila(), ClaseLexica.CCIERRE, "]");
   }

   public UnidadLexica unidadLlaveApertura() {
      return new UnidadLexica(alex.fila(), ClaseLexica.LAP, alex.lexema());
   }

   public UnidadLexica unidadLlaveCierre() {
      return new UnidadLexica(alex.fila(), ClaseLexica.LCIERRE, alex.lexema());
   }

   public UnidadLexica unidadInt() {
      return new UnidadLexica(alex.fila(), ClaseLexica.INT, alex.lexema());
   }

   public UnidadLexica unidadVoid() {
      return new UnidadLexica(alex.fila(), ClaseLexica.VOID, alex.lexema());
   }

   public UnidadLexica unidadChar() {
      return new UnidadLexica(alex.fila(), ClaseLexica.CHAR, alex.lexema());
   }

   public UnidadLexica unidadFloat() {
      return new UnidadLexica(alex.fila(), ClaseLexica.FLOAT, alex.lexema());
   }

   public UnidadLexica unidadBool() {
      return new UnidadLexica(alex.fila(), ClaseLexica.BOOL, alex.lexema());
   }

   public UnidadLexica unidadEnum() {
      return new UnidadLexica(alex.fila(), ClaseLexica.ENUM, alex.lexema());
   }

   public UnidadLexica unidadTrue() {
      return new UnidadLexica(alex.fila(), ClaseLexica.TRUE, alex.lexema());
   }

   public UnidadLexica unidadFalse() {
      return new UnidadLexica(alex.fila(), ClaseLexica.FALSE, alex.lexema());
   }

   public UnidadLexica unidadCaracter() {
      return new UnidadLexica(alex.fila(), ClaseLexica.CARACTER, alex.lexema());
   }

   public UnidadLexica unidadCadenaCaracteres() {
      return new UnidadLexica(alex.fila(), ClaseLexica.CADENA, alex.lexema());
   }

   public UnidadLexica unidadString() {
      return new UnidadLexica(alex.fila(), ClaseLexica.STRING, alex.lexema());
   }

   public UnidadLexica unidadNew() {
      return new UnidadLexica(alex.fila(), ClaseLexica.NEW, alex.lexema());
   }

   public UnidadLexica unidadReferencia() {
      return new UnidadLexica(alex.fila(), ClaseLexica.REF, alex.lexema());
   }

   public UnidadLexica unidadWhile() {
      return new UnidadLexica(alex.fila(), ClaseLexica.WHILE, alex.lexema());
   }

   public UnidadLexica unidadFor() {
      return new UnidadLexica(alex.fila(), ClaseLexica.FOR, alex.lexema());
   }

   public UnidadLexica unidadIf() {
      return new UnidadLexica(alex.fila(), ClaseLexica.IF, alex.lexema());
   }

   public UnidadLexica unidadElsif() {
      return new UnidadLexica(alex.fila(), ClaseLexica.ELSIF, alex.lexema());
   }

   public UnidadLexica unidadElse() {
      return new UnidadLexica(alex.fila(), ClaseLexica.ELSE, alex.lexema());
   }

   public UnidadLexica unidadStruct() {
      return new UnidadLexica(alex.fila(), ClaseLexica.STRUCT, alex.lexema());
   }

   public UnidadLexica unidadSwitch() {
      return new UnidadLexica(alex.fila(), ClaseLexica.SWITCH, alex.lexema());
   }

   public UnidadLexica unidadCase() {
      return new UnidadLexica(alex.fila(), ClaseLexica.CASE, alex.lexema());
   }

   public UnidadLexica unidadBreak() {
      return new UnidadLexica(alex.fila(), ClaseLexica.BREAK, alex.lexema());
   }

   public UnidadLexica unidadDefault() {
      return new UnidadLexica(alex.fila(), ClaseLexica.DEFAULT, alex.lexema());
   }

   public UnidadLexica unidadReturn() {
      return new UnidadLexica(alex.fila(), ClaseLexica.RETURN, alex.lexema());
   }

   public UnidadLexica unidadPrint() {
      return new UnidadLexica(alex.fila(), ClaseLexica.PRINT, alex.lexema());
   }

   public UnidadLexica unidadMain() {
      return new UnidadLexica(alex.fila(), ClaseLexica.MAIN, alex.lexema());
   }

}
