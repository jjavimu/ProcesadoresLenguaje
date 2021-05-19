package ast.expresiones;

import ast.Programa;
import ast.tipos.*;

public class OpDiv extends ExpresionBinaria {

    public OpDiv(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
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
