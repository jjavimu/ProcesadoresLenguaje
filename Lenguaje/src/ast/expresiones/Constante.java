package ast.expresiones;

import ast.tipos.*;
import ast.Programa;

public class Constante extends Expresion {
    private String valor;
    //private TipoBasicoClass tipo;

    public Constante(String cte, TipoClass tipo){
        this.valor = cte;
        this.tipo = tipo;
    }
    
    public void chequea(){
        tipo.chequea(); //Aunque en realidad solo se crean constantes con tipo basico
    }

    public void vincular(){}

    public void generaCodigo(){
        Programa.escribir.println("i32.const " + valor);
    }

    

    public String getValor(){
        return valor;
    }

    public String toString(){
        return "Expresion(" + valor+ ")";
    }
}
