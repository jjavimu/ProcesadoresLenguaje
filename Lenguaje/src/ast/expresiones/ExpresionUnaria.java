package ast.expresiones;

public abstract class ExpresionUnaria extends Expresion{
    protected Expresion exp;

    public ExpresionUnaria(Expresion exp) {
      this.exp = exp;
    }

    public abstract void chequea();
    
    public void vincular(){
      exp.vincular();
    }
}
