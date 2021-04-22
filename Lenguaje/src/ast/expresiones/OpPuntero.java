package ast.expresiones;

import ast.instrucciones.Ins;

public class OpPuntero extends Ins{
    private String id;
    public OpPuntero(String id){
        this.id = id;
    }
}
