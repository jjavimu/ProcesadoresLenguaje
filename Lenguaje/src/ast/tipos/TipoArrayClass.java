package ast.tipos;


public class TipoArrayClass extends TipoClass{
    protected TipoClass tipo;
    protected String tam;

    public  TipoArrayClass(TipoClass tipo, String tamanio ) {
        this.tipo = tipo;
        this.tam = tamanio;
    }

    public boolean comparar(TipoClass otro){
        if(!(otro instanceof TipoArrayClass)){
            return false;
        }
        else return tipo.comparar(((TipoArrayClass) otro).getTipoDelArray());

    }

    public void chequea(){
        tipo.chequea();
    }

    public String toString(){
        if(tam != null)
            return tipo.toString() + "<" + tam + ">";
        else 
            return tipo.toString() + "<>";
    }

     public TipoClass getTipoDelArray(){
        return tipo;
    }
    
}
