package ast.instrucciones;
import ast.ASTnodo;


public abstract class Ins extends ASTnodo {

    public Ins() {}

    public abstract void vincular();
    public abstract void chequea();
    public abstract void setReturn(ASTnodo nodoFuncion); // vincular los return
    public abstract void calculos();
    public abstract void generaCodigo();
    public int maxMemoria(){return 0;} // Esta funcion es para calcular el maximo de memoria de la funcion

}
