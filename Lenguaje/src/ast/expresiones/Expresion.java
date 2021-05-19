package ast.expresiones;

import ast.ASTnodo;

public abstract class Expresion extends ASTnodo {
    
    public Expresion(){}

    public abstract void vincular();
    public abstract void chequea();

}
