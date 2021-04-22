package ast;

import ast.funciones.Fmain;

public class Programa {

    private ListaDefiniciones definiciones;
    private Fmain fmain;

    public Programa(ListaDefiniciones l, Fmain fmain){
        this.definiciones = l;
        this.fmain = fmain;
    }
    
}
