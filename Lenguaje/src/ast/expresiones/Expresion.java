package ast.expresiones;

import ast.ASTnodo;

public abstract class Expresion extends ASTnodo {
    
    public Expresion(){}

    public abstract void vincular();
    public abstract void chequea();
    public void calculos(){} // no necesitan etiqueta delta
    public void generaCodigo(){} // Esta es calcular el delta de la etiqueta
}
