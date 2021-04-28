package ast;

import ast.funciones.Fmain;

public class Programa extends ASTnodo {
    
    private ListaDefiniciones definiciones; // Structs, enums y funciones
    private Fmain fmain;
    
    public Programa(ListaDefiniciones l, Fmain fmain){
        this.definiciones = l;
        this.fmain = fmain;
    }
    
    
    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }
    
}
