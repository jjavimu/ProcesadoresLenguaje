package ast.expresiones;

import ast.tipos.*;

public class Constante extends Expresion {
    private String valor;
    private TipoBasicoClass tipo;

    public Constante(String cte, TipoBasicoClass tipo){
        this.valor = cte;
        this.tipo = tipo;
    }

    public void vincular(){}

    public String getValor(){
        return valor;
    }

    public String toString(){
        return "Expresion(" + valor+ ")";
    }
}
