package ast;

public abstract class ASTnodo {
    public ASTnodo nodoVinculo;
    public TipoClass tipo;
    
    public ASTnodo(){}

    public abstract void vincular();
}
