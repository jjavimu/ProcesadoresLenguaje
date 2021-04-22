package ast.instrucciones;

import ast.expresiones.FuncallExp;

public class FuncallClass extends Ins {
    private FuncallExp funcion;

    public FuncallClass(FuncallExp funcion){
        this.funcion = funcion;
    }
    
}
