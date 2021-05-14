package ast.accesos;

import ast.expresiones.Expresion;

public class AccesoArray extends Acceso{
    protected Acceso acceso;
    protected Expresion exp;

    public AccesoArray(Acceso acceso, Expresion exp) {
        this.exp = exp;
        this.acceso = acceso;
    }

    public void vincular(){
        acceso.vincular();
        exp.vincular();
    }

    public String toString(){
        return "ExpAccArr(" + acceso + "[" + exp + "])";
    }
    
}
