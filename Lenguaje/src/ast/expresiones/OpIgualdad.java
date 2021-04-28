package ast.expresiones;

public class OpIgualdad extends ExpresionBinaria {

    public OpIgualdad(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return "ExpBin(" + opizq + "==" + opdcha + ")";
    }
    
}
