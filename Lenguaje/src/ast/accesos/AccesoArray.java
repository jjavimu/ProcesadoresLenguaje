package ast.accesos;

public class AccesoArray {
    protected Acceso accesoAnterior;
    protected Expresion exp;

    public AccesoArray(Acceso accesoAnterior, Expresion exp) {
        this.accesoAnterior = accesoAnterior;
        this.exp = exp;
    }

    public String toString(){
        return accesoAnterior.toString() + "[" + exp.toString() + "]";
    }
    
}
