package ast.expresiones;

public abstract class ExpresionUnaria extends Expresion{
    protected Expresion exp;

    public ExpresionUnaria(Expresion exp) {
      this.exp = exp;
    }

    // CHEQUEAR TIPOS -----------------------------------------------------------------
    public abstract void chequea();

    // VINCULAR -----------------------------------------------------------------
    public void vincular(){
      exp.vincular();
    }
}
