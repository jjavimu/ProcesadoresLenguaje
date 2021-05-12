package asint;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import alex.UnidadLexica;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
	 AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	 // sacaLexemas(alex);
	 AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
	 // asint.setScanner(alex);
	 // asint.parse();
	 Programa p = asint.parse().value;
	 System.out.println(p);
	 p.vinculacion();
 }
 	public static void sacaLexemas(AnalizadorLexicoTiny alex) throws IOException{
		UnidadLexica unidad;
		do {
		   unidad = (UnidadLexica) alex.next_token();
		   System.out.println(unidad + " " + unidad.lexema());
		 }
		 while (unidad.clase() != ClaseLexica.EOF);
	 }
}   
   
