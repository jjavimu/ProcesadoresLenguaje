package ast;

import ast.tipos.*;

public abstract class ASTnodo {
    public ASTnodo nodoVinculo; // nodo con el que se vinculan
    public TipoClass tipo;  // tipo de su nodo
    public int etiqueta; // etiqueta
    
    public ASTnodo(){}

    public abstract void vincular();
    public abstract void chequea();
    public abstract void calculos(); 
    public abstract void generaCodigo(); 
}
