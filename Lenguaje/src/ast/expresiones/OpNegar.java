package ast.expresiones;

import ast.Programa;
import ast.tipos.*;
import ast.accesos.*;

public class OpNegar extends ExpresionUnaria {

    public OpNegar(Expresion exp){
        super(exp);
    }

    public void generaCodigo(){
        exp.generaCodigo();
        if(exp instanceof Acceso)
            Programa.escribir.println("i32.load"); // devuelve direccion
        
        Programa.escribir.println("i32.eqz");
    }

    public void chequea(){
        exp.chequea();

        //if(opizq.tipo 'es igual a' opdcha.tipo && opizq.tipo 'es booleano')
        if(exp.tipo.comparar(new TipoBasicoClass("bool"))){
            this.tipo = new TipoBasicoClass("bool");
        }
        else{
            Programa.okTipos = false;
            System.out.println("Error tipo: negar no comparables");
        }
    }

    public String toString(){
        return "ExpUn(!"+ exp + ")";
      }
    
}
