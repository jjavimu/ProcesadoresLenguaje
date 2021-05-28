package ast.tipos;


public class TipoArrayClass extends TipoClass{
    protected TipoClass tipo;
    protected String tam;

    public  TipoArrayClass(TipoClass tipo, String tamanio ) {
        this.tipo = tipo;
        this.tam = tamanio;
    }

    // CHEQUEAR TIPOS ----------------------------------------------------------------- 
    public void chequea(){
        tipo.chequea();
    }

    // AST TOSTRING -----------------------------------------------------------------
    public String toString(){
        if(tam != null)
            return tipo.toString() + "<" + tam + ">";
        else 
            return tipo.toString() + "<>";
    }

    // AUXILIARES -----------------------------------------------------------------
    public int getTam(){
        int tam_tipo =  Integer.parseInt(tam)* tipo.getTam();
        return tam_tipo;
    }

    public int getTamElem(){
        return tipo.getTam();
    }

    public TipoClass getTipoDelArray(){
        return tipo;
    }

    public boolean comparar(TipoClass otro){
        if(!(otro instanceof TipoArrayClass)){
            return false;
        }
        else return tipo.comparar(((TipoArrayClass) otro).getTipoDelArray());

    }  
    
}
