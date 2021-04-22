package ast.expresiones;

public class OpDiv extends ExpresionBinaria {

    public OpDiv(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return opizq.toString() + " / " + opdcha.toString();
    }
    
}
