package ast.accesos;

import ast.expresiones.Expresion;

public class AccesoArray extends Acceso{
    protected Acceso acceso;
    protected Expresion exp;

    public AccesoArray(Acceso acceso, Expresion exp) {
        this.exp = exp;
        this.acceso = acceso;
    }

    public String toString(){
        return "ExpAccArr(" + acceso + "[" + exp + "])";
    }
    
}
