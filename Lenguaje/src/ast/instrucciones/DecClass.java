package ast.instrucciones;

import ast.tipos.*;
import ast.expresiones.*;

public class DecClass extends Ins {

    protected TipoClass tipo;
    protected String nombre;
    protected Expresion exp;

    public DecClass(TipoClass tipo, String nombre, Expresion exp){
        this.tipo = tipo;
        this.nombre = nombre;
        this.exp = exp;    
    }
    
    public DecClass(TipoClass tipo, String nombre){
        this.tipo = tipo;
        this.nombre = nombre;
        this.exp = null;
    }

    public String toString(){
        if(exp != null)
            return tipo.toString() + nombre + exp.toString() + ";\n";
        else
            return tipo.toString() + nombre + ";\n";

    }
    
}
