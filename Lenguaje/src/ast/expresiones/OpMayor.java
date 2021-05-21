package ast.expresiones;

import ast.Programa;
import ast.tipos.*;
import ast.accesos.*;

public class OpMayor extends ExpresionBinaria {

    public OpMayor(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public void generaCodigo(){
        opizq.generaCodigo();
        if(opizq instanceof Acceso)
            Programa.escribir.println("i32.load");  // devuelve direccion
        
        opdcha.generaCodigo();
        if(opdcha instanceof Acceso)
            Programa.escribir.println("i32.load"); // devuelve direccion
        
        Programa.escribir.println("i32.gt_s");
    }

    public void chequea(){
        opizq.chequea();
        opdcha.chequea();

        if(opizq.tipo == null || opdcha.tipo == null){
            System.out.println("Error tipo: mayor alguno null");
            Programa.okTipos = false;
        }
        else if(opizq.tipo.comparar(opdcha.tipo)){
            this.tipo = new TipoBasicoClass("bool");
        }
        else{
            Programa.okTipos = false;
            System.out.println("Error tipo: mayor no comparables");
        }

    }

    public String toString(){
        return "ExpBin(" + opizq + ">" + opdcha + ")";
    }
    
}
