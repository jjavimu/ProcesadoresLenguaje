package ast.instrucciones;

import ast.expresiones.Expresion;

public class PrintClass extends Ins {
    protected Expresion exp;
    
    public PrintClass(Expresion exp){
        this.exp = exp;
    }

    public void vincular(){
        exp.vincular();
    }


    public String toString(){
        return "Print (" + exp.toString() + ")";
    }
}
