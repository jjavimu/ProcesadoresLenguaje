package ast.expresiones;

public class OpMayor extends ExpresionBinaria {

    public OpMayor(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return "ExpBin(" + opizq + ">" + opdcha + ")";
    }
    
}
