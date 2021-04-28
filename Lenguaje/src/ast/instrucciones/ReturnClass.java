package ast.instrucciones;

import ast.expresiones.Expresion;

public class ReturnClass extends Ins {
    protected Expresion valorRetorno;

    public ReturnClass(Expresion exp){
        this.valorRetorno = exp;
    }

    public ReturnClass(){
        this.valorRetorno = null;
    }

    public String toString(){
        return "return(" + valorRetorno + ")";
    }
}
