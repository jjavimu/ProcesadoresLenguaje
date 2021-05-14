package ast.tipos;

public class TipoBasicoClass extends TipoClass {
    //Identificadores: int, void, float, bool, char, string, cte_enum
    String tipo;

    public TipoBasicoClass(String tipo){
        this.tipo = tipo;
    }
    
    public String toString(){
        return tipo;
    }
}
