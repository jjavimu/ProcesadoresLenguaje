package ast.tipos;


public class TipoPunteroClass extends TipoClass{
    protected TipoClass tipo;

    public TipoPunteroClass(TipoClass tipo) {
        this.tipo = tipo;
    }

    public boolean comparar(TipoClass otro){
        if(!(otro instanceof TipoPunteroClass)){
            return false;
        }
        else return tipo.comparar(((TipoPunteroClass) otro).getTipoDelPuntero());
    }

    public void chequea(){
        tipo.chequea();
    }
    
    public String toString(){
        return tipo.toString() + "*";
    }
    
    public TipoClass getTipoDelPuntero(){
        return tipo;
    }
    
}


