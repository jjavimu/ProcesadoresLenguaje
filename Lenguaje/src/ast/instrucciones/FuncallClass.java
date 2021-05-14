package ast.instrucciones;

import ast.expresiones.FuncallExp;

public class FuncallClass extends Ins {
    private FuncallExp funcion;

    public FuncallClass(FuncallExp funcion){
        this.funcion = funcion;
    }

    public void vincular(){
        funcion.vincular();
    }
    
    public String toString(){
        return "Call(" + funcion.toString() + ")";
    }
}
