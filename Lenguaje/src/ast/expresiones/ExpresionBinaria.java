package ast.expresiones;

public class ExpresionBinaria extends Expresion {
    private Expresion opizq;
    private Expresion opdcha;

    public ExpresionBinaria(Expresion opizq, Expresion opdcha){
        this.opizq = opizq;
        this.opdcha = opdcha;
    }
}
