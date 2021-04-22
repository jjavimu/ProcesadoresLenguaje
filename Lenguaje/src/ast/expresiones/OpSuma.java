package ast.expresiones;

public class OpSuma extends ExpresionBinaria {

    public OpSuma(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return opizq.toString() + " + " + opdcha.toString();
    }
    
}
