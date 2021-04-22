package ast.instrucciones;

import ast.expresiones.*;


public class AsigClass extends Ins {

    protected String nombre;
    protected Expresion exp;

    public AsigClass(String nombre, Expresion exp){
        this.exp=exp;
        this.nombre=nombre;
    }
    
}
