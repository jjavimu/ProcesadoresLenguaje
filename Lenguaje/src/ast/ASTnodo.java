package ast;

import ast.tipos.*;

public abstract class ASTnodo {
    public ASTnodo nodoVinculo;
    
    public TipoClass tipo;
    // Todos los nodos tienen un tipo
    // Los if, while y demas tienen tipo null
    
    public ASTnodo(){}

    public abstract void vincular();
    public abstract void chequea();

}
