package ast.expresiones;

public class OpOr extends ExpresionBinaria {

    public OpOr(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return "ExpBin(" + opizq + "or" + opdcha + ")";
    }
    
}
