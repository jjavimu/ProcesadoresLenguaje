package ast.tipos;


public class TipoPunteroClass extends TipoClass{
    protected TipoClass tipo;

    public TipoEstructuraClass(TipoClass tipo) {
        this.tipo = tipo;
    }

    public String toString(){
        return tipo;
    }
    
    
}


