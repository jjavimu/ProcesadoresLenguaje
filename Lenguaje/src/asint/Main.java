package asint;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import alex.AnalizadorLexicoTiny;
import alex.UnidadLexica;
import ast.*;

public class Main {
   public static void main(String[] args) throws Exception {
     Reader input = new InputStreamReader(new FileInputStream(args[0]));
	 AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
	 // sacaLexemas(alex);
	 AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);

	 Programa p = (Programa) asint.parse().value;
	 
	 System.out.println(p); // mostramos el AST
	 p.vincular(); // vinculamos
	 if (Programa.okVinculacion){
	 	System.out.println("SE HA VINCULADO BIEN :)");
		p.chequea(); // chequeamos tipos
		if(Programa.okTipos){
			System.out.println("TIPOS BIEN :)");
			p.calculos(); // colocamos etiquetas
			p.maxMemoria(); // calculamos maxMem de la funcion
	 		p.generaCodigo(); // generamos el codigo
		}
		else System.out.println("TIPOS MAL :(");
	 }
	 else{
		System.out.println("NO SE HA VINCULADO BIEN :/");
	 }
 }
 	// Funcion para sacar los lexemas de la parte lexica
 	public static void sacaLexemas(AnalizadorLexicoTiny alex) throws IOException{
		UnidadLexica unidad;
		do {
		   unidad = (UnidadLexica) alex.next_token();
		   System.out.println(unidad + " " + unidad.lexema());
		 }
		 while (unidad.clase() != ClaseLexica.EOF);
	 }
}   
   
