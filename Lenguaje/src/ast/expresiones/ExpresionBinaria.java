package ast.expresiones;

public abstract class ExpresionBinaria extends Expresion {
    protected Expresion opizq;
    protected Expresion opdcha;

    public ExpresionBinaria(Expresion opizq, Expresion opdcha){
        this.opizq = opizq;
        this.opdcha = opdcha;
    }

    // CHEQUEAR TIPOS -----------------------------------------------------------------
    public abstract void chequea();

    // VINCULAR -----------------------------------------------------------------
    public void vincular(){
        opizq.vincular();
        opdcha.vincular();
    }
}
