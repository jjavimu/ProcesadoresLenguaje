package ast;

import ast.funciones.Fmain;

public class Programa extends ASTnodo {
    
    private ListaDefiniciones definiciones; // Structs, enums y funciones
    private Fmain fmain; //Funcion main del programa

    // Pila de tabla se simbolos
    protected static PilaTablaSimbolos pila;
    
    public Programa(ListaDefiniciones l, Fmain fmain){
        this.definiciones = l;
        this.fmain = fmain;
    }
    
    
    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }

    public void vincular(){
        pila = new PilaTablaSimbolos();
        pila.abreBloque();

        for(ListaDefiniciones def: definiciones){
            def.vincular();
        }
        fmain.vincular();
    }
}
