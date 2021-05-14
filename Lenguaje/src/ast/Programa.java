package ast;

import ast.funciones.Fmain;

public class Programa extends ASTnodo {
    
    private ListaDefiniciones definiciones; // Structs, enums y funciones
    private Fmain fmain; //Funcion main del programa

    // Pila de tabla se simbolos
    public static PilaTablaSimbolos pila;
    public static Boolean okVinculacion; 
    
    public Programa(ListaDefiniciones l, Fmain fmain){
        this.definiciones = l;
        this.fmain = fmain;
        this.okVinculacion = true;
    }
    
    public void chequea(){
        definiciones.chequea();
        fmain.chequea();
    }

    public void vincular(){
        pila = new PilaTablaSimbolos();
        pila.abreBloque();
        definiciones.vincular();
        fmain.vincular();
        pila.cierraBloque();
    }
    
    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }

}
