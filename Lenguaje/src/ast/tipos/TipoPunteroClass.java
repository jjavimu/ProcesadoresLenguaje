package ast.tipos;


public class TipoPunteroClass extends TipoClass{
    protected TipoClass tipo;

    public TipoPunteroClass(TipoClass tipo) {
        this.tipo = tipo;
    }

    public String toString(){
        return tipo.toString();
    }
    
    
}


