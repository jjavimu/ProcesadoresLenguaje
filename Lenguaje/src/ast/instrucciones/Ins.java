package ast.instrucciones;
import ast.ASTnodo;


public abstract class Ins extends ASTnodo {

    public Ins() {}

    public abstract void vincular();
    public abstract void chequea();
    public abstract void setReturn(ASTnodo nodoFuncion);
}
