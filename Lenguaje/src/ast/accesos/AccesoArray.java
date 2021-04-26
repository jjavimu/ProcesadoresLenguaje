package ast.accesos;

import ast.expresiones.Expresion;

public class AccesoArray extends Acceso{
    protected Expresion indice;

    public AccesoArray(Expresion exp) {
        this.indice = exp;
    }

    public String toString(){
        return "[" + indice.toString() + "]";
    }
    
}
