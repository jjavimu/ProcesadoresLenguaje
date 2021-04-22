package ast.expresiones;

public class ExpresionBinaria extends Expresion {
    protected Expresion opizq;
    protected Expresion opdcha;

    public ExpresionBinaria(Expresion opizq, Expresion opdcha){
        this.opizq = opizq;
        this.opdcha = opdcha;
    }
}
