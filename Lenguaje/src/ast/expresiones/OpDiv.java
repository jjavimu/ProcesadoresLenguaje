package ast.expresiones;

import ast.Programa;
import ast.tipos.*;
import ast.accesos.*;

public class OpDiv extends ExpresionBinaria {

    public OpDiv(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public void generaCodigo() {
        opizq.generaCodigo();
        if(opizq instanceof Acceso)
            Programa.escribir.println("i32.load");  // devuelve direccion
        
        opdcha.generaCodigo();
        if(opdcha instanceof Acceso)
            Programa.escribir.println("i32.load"); // devuelve direccion

        Programa.escribir.println("i32.div_s");
    }

    public void chequea(){
        opizq.chequea();
        opdcha.chequea();

        if(opizq.tipo == null || opdcha.tipo == null){
            System.out.println("Error tipo: div alguno null");
            Programa.okTipos = false;
        }
        //operacion solo para enteros
        else if(opizq.tipo.comparar(new TipoBasicoClass("int")) && opdcha.tipo.comparar(new TipoBasicoClass("int"))){
            this.tipo = new TipoBasicoClass("int");
        }
        else{
            Programa.okTipos = false;
            System.out.println("Error tipo: div no comparables");
        }

    }

    public String toString(){
        return "ExpBin(" + opizq + "/" + opdcha + ")";
    }
    
}
