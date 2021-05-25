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
        // Nuestras constantes solo pueden ser int
        // Podemos tratar true y false como 1 y 0 respectivamente
        if (valor.compareTo("true") == 0){ 
            Programa.escribir.println("i32.const " + 1);
        }
        else if (valor.compareTo("false") == 0){
            Programa.escribir.println("i32.const " + 0);
        }
        else{ // solo puede ser int desde aqui
            Programa.escribir.println("i32.const " + valor);
        }
    }

    

    public String getValor(){
        return valor;
    }

    public String toString(){
        return "Expresion(" + valor+ ")";
    }
}
