package ast.tipos;

public class TipoBasicoClass extends TipoClass {
    //Identificadores: int, void, float, bool, char, string
    String tipo;

    public TipoBasicoClass(String tipo){
        this.tipo = tipo;

    }

    // CHEQUEAR TIPO -----------------------------------------------------------------
    public void chequea(){}

    // AST TOSTRING -----------------------------------------------------------------
    public String toString(){
        return tipo;
    }

    // AUXILIARES -----------------------------------------------------------------
    public int getTam(){
        return 1; //habria que multiplicar por 4. Solo hay int
    }
    public int getTamElem(){
        return 1;
    }

    public boolean comparar(TipoClass otro){
        return (this.tipo.compareTo(otro.toString())==0);
    }
}
