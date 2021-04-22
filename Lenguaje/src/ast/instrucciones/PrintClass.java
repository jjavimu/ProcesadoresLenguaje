package ast.instrucciones;

import ast.expresiones.Expresion;

public class PrintClass extends Ins {
    protected Expresion exp;
    
    public PrintClass(Expresion exp){
        this.exp = exp;
    }
}
