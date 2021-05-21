package ast;

import ast.tipos.*;

public abstract class ASTnodo {
    public ASTnodo nodoVinculo;
    public TipoClass tipo;
    // Todos los nodos tienen un tipo
    // Los if, while y demas tienen tipo null

    public int etiqueta;
    
    public ASTnodo(){}

    public abstract void vincular();
    public abstract void chequea();
    public abstract void calculos(); // Esta es calcular el delta de la etiqueta
    public abstract void generaCodigo(); // Esta es la que genera el codigo wat
}
