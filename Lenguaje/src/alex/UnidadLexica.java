package alex;

import java_cup.runtime.Symbol;

public class UnidadLexica extends Symbol {
   private int fila;
   private String lexema;
   public UnidadLexica(int fila, int clase, String lexema) {
     super(clase,lexema);
	 this.fila = fila;
    this.lexema = lexema;
   }
   public int clase () {return sym;}
   public String lexema() {return (String)value;}
   public int fila() {return fila;}
}
