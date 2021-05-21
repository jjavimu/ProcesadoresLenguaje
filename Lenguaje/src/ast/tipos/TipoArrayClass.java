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

    public int getTam(){
        int tam_tipo =  Integer.parseInt(tam)* tipo.getTam();
        return tam_tipo;
    }

    public int getTamElem(int i){
        int tamanio;
        if(i==1){
            tamanio = tipo.getTam();
        }
        else {
            tamanio = tipo.getTamElem(i-1);
        }
        return tamanio;
    }

    public TipoClass getTipoDelArray(){
        return tipo;
    }

    public String toString(){
        if(tam != null)
            return tipo.toString() + "<" + tam + ">";
        else 
            return tipo.toString() + "<>";
    }

    
    
}
