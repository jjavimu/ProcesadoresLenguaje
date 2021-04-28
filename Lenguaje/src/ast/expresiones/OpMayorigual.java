package ast.expresiones;

public class OpMayorigual extends ExpresionBinaria {

    public OpMayorigual(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return "ExpBin(" + opizq + ">=" + opdcha + ")";
    }
    
}
