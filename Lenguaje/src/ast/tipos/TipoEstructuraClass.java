package ast.tipos;


public class TipoEstructuraClass extends TipoClass {
    // nombre struct/enumerado
    String tipo;

    public TipoEstructuraClass(String tipo) {
        this.tipo = tipo;
    }

    public String toString(){
        return tipo;
    }
    
}
