package ast.expresiones;
import ast.Programa;
import ast.tipos.*;

public class OpPotencia extends ExpresionBinaria {

    public OpPotencia(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public void chequea(){
        opizq.chequea();
        opdcha.chequea();

        if(opizq.tipo == null || opdcha.tipo == null){
            System.out.println("Error tipo: pot alguno null");
            Programa.okTipos = false;
        }
        
        else if(opizq.tipo.comparar(new TipoBasicoClass("int")) && opdcha.tipo.comparar(new TipoBasicoClass("int"))){
            this.tipo = new TipoBasicoClass("int");
        }
        else{
            Programa.okTipos = false;
            System.out.println("Error tipo: pot no comparables");
        }

    }

    public String toString(){
        return "ExpBin(" + opizq + "^" + opdcha + ")";
    }
}
