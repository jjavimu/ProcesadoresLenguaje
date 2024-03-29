package errors;

import alex.UnidadLexica;
import alex.TokenValue;
public class GestionErroresTiny {
   public void errorLexico(int fila, int col, String lexema) {
     System.out.println("LEXICO ERROR fila "+fila+", columna "+col+": Caracter inexperado: "+lexema); 
     //System.exit(1);
   }  
   public void errorSintactico(UnidadLexica unidadLexica) {
     System.out.println("SINTACTICO ERROR fila "+unidadLexica.fila()+ ", columna "+unidadLexica.columna()+": Elemento inesperado "+ ((TokenValue)unidadLexica.value).lexema+"\n");
     //System.exit(1);
   }
}
