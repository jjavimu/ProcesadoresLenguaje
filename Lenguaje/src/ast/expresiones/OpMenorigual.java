package ast.expresiones;

public class OpMenorigual extends ExpresionBinaria {

    public OpMenorigual(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }
    
    public String toString(){
        return opizq.toString() + " <=" + opdcha.toString();
    }

}
