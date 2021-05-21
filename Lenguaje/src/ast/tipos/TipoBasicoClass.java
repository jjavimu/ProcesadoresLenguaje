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

    public int getTam(){
        return 1; //habria que multiplicar por 4. Solo hay int
    }
    public int getTamElem(int i){return 1;}
    
    public String toString(){
        return tipo;
    }
}
