package ast.instrucciones;

import ast.expresiones.Expresion;
import ast.ASTnodo;

public class PrintClass extends Ins {
    protected Expresion exp;
    
    public PrintClass(Expresion exp){
        this.exp = exp;
    }

    public void chequea(){
        exp.chequea();
    }

    public void vincular(){
        exp.vincular();
    }


    public void setReturn(ASTnodo nodo) {
    }


    public String toString(){
        return "Print (" + exp.toString() + ")";
    }
}
