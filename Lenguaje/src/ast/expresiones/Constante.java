package ast.expresiones;

public class Constante extends Expresion {
    private String valor;

    public Constante(String cte){
        this.valor  =cte;
    }

    public String toString(){
        return valor;
    }
}
