package ast.expresiones;

import ast.Programa;
import ast.tipos.*;

public class OpModulo extends ExpresionBinaria {

    public OpModulo(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public void chequea(){
        opizq.chequea();
        opdcha.chequea();

        if(opizq.tipo == null || opdcha.tipo == null){
            System.out.println("Error tipo: mod alguno null");
            Programa.okTipos = false;
        }
        //operacion solo para enteros
        else if(opizq.tipo.comparar(new TipoBasicoClass("int")) && opdcha.tipo.comparar(new TipoBasicoClass("int"))){
            this.tipo = new TipoBasicoClass("int");
        }
        else{
            Programa.okTipos = false;
            System.out.println("Error tipo: mod no comparables");
        }

    }

    public String toString(){
        return "ExpBin(" + opizq + "%" + opdcha + ")";
    }
    
}
