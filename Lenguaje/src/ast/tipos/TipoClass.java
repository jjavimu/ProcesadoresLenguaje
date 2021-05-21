package ast.tipos;

public abstract class TipoClass{

    public TipoClass(){}

    public abstract boolean comparar(TipoClass otro);

    public abstract void chequea();
    public abstract int getTam(); // Para las etiquetas del codigo
    public int getTamElem(int i){return 0;}
}
