package ast.expresiones;

import ast.tipos.TipoClass;

public class NewExp extends Expresion {

    public NewExp(TipoClass tipo){
        this.tipo = tipo; 
    }

    public void chequea(){
        tipo.chequea();
    }

    public void vincular(){}

    public String toString(){
        return "ExpNew(" + tipo.toString()+")";
    }
}
