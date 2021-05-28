package ast.expresiones;

import ast.tipos.TipoClass;

public class NewExp extends Expresion {

    public NewExp(TipoClass tipo){
        this.tipo = tipo; 
    }

    // CHEQUEAR TIPOS -----------------------------------------------------------------
    public void chequea(){
        tipo.chequea();
    }

    // VINCULAR -----------------------------------------------------------------
    public void vincular(){}

    // AST TOSTRING -----------------------------------------------------------------
    public String toString(){
        return "ExpNew(" + tipo.toString()+")";
    }
}
