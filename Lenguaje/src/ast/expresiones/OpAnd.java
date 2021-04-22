package ast.expresiones;

public class OpAnd extends ExpresionBinaria {

    public OpAnd(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return opizq.toString() + " and " + opdcha.toString();
    }
    
}
