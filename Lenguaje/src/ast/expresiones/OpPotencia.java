package ast.expresiones;

public class OpPotencia extends ExpresionBinaria {

    public OpPotencia(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return opizq.toString() + "^" + opdcha.toString();
    }
    
}
