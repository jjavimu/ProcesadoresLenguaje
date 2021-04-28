package ast.accesos;

import ast.expresiones.Expresion;

public class AccesoArray extends Acceso{
    protected Acceso acceso;
    protected Expresion indice;

    public AccesoArray(Acceso acceso, Expresion exp) {
        this.indice = exp;
        this.acceso = acceso;
    }

    public String toString(){
        return acceso.toString() + "[" + exp.toString + "]";
    }
    
}
