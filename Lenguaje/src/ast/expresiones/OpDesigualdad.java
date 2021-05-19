package ast.expresiones;


import ast.Programa;
import ast.tipos.*;

public class OpDesigualdad extends ExpresionBinaria {

    public OpDesigualdad(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public void chequea(){
        opizq.chequea();
        opdcha.chequea();

        if(opizq.tipo == null || opdcha.tipo == null){
            System.out.println("Error tipo: desigualdad alguno null");
            Programa.okTipos = false;
        }
        else if(opizq.tipo.comparar(opdcha.tipo)){
            this.tipo = new TipoBasicoClass("bool");
        }
        else{
            Programa.okTipos = false;
            System.out.println("Error tipo: desigualdad no comparables");
        }

    }
    
    public String toString(){
        return "ExpBin(" + opizq + "!=" + opdcha + ")";
    }

}
