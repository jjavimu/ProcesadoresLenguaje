package ast.expresiones;

public class OpMenor extends ExpresionBinaria {

    public OpMenor(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return opizq.toString() + " < " + opdcha.toString();
    }
    
}