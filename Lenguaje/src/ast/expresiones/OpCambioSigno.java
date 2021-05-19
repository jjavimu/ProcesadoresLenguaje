package ast.expresiones;

import ast.Programa;
import ast.tipos.*;

public class OpCambioSigno extends ExpresionUnaria {

    public OpCambioSigno(Expresion exp){
        super(exp);
    }

    public void chequea(){
        exp.chequea();

        //if(opizq.tipo 'es igual a' opdcha.tipo && opizq.tipo 'es booleano')
        if(exp.tipo.comparar(new TipoBasicoClass("int")) || exp.tipo.comparar(new TipoBasicoClass("float")) ){
            this.tipo = exp.tipo;
        }
        else{
            Programa.okTipos = false;
            System.out.println("Error tipo: cambio signo no comparables");
        }
    }

    public String toString(){
        return "ExpUn(-" + exp + ")";
      }
    
}
