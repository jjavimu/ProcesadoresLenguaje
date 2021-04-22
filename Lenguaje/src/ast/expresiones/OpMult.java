package ast.expresiones;

public class OpMult extends ExpresionBinaria {

    public OpMult(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return opizq.toString() + " * " + opdcha.toString();
    }
    
}
