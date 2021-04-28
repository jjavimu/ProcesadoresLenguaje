package ast.tipos;


public class TipoArrayClass extends TipoClass{
    protected TipoClass tipo;
    protected String tam;

    public  TipoArrayClass(TipoClass tipo, String tamanio ) {
        this.tipo = tipo;
        this.tam = tamanio;
    }

    public String toString(){
        if(tam != null)
            return tipo.toString() + "<" + tam + ">";
        else 
            return tipo.toString() + "<>";
    }
    
}
