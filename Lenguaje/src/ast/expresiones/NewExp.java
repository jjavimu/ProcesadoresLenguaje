package ast.expresiones;

import ast.tipos.TipoClass;

public class NewExp extends Expresion {
    private TipoClass tipo;

    public NewExp(TipoClass tipo){
        this.tipo = tipo; 
    }

    public void vincular(){
        
    }

    public String toString(){
        return "ExpNew(" + tipo.toString()+")";
    }
}
