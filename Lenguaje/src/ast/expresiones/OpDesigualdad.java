package ast.expresiones;

public class OpDesigualdad extends ExpresionBinaria {

    public OpDesigualdad(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }
    
    public String toString(){
        return "ExpBin(" + opizq + "!=" + opdcha + ")";
    }

}
