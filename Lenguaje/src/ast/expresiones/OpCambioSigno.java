package ast.expresiones;

import ast.Programa;
import ast.tipos.*;
import ast.accesos.*;

public class OpCambioSigno extends ExpresionUnaria {

    public OpCambioSigno(Expresion exp){
        super(exp);
    }

    public void generaCodigo(){
        Programa.escribir.println("i32.const 0");
        exp.generaCodigo();
        if(exp instanceof Acceso)
            Programa.escribir.println("i32.load"); // devuelve direccion
        
        Programa.escribir.println("i32.sub");
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
