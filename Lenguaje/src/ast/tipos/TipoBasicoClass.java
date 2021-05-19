package ast.tipos;

public class TipoBasicoClass extends TipoClass {
    //Identificadores: int, void, float, bool, char, string
    String tipo;

    public TipoBasicoClass(String tipo){
        this.tipo = tipo;
    }

    public boolean comparar(TipoClass otro){
        return (this.tipo.compareTo(otro.toString())==0);
    }

    public void chequea(){}
    
    public String toString(){
        return tipo;
    }
}
