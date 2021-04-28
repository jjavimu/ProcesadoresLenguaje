package ast.expresiones;


public class NewExp extends Expresion {
    private TipoClass tipo;

    public NewExp(TipoClass tipo){
        this.tipo = tipo; 
    }

    public String toString(){
        return "new" + tipo.toString();
    }
}
