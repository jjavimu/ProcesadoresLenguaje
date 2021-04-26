package ast.accesos;

public class AccesoArray extends Acceso{
    protected Expresion indice;

    public AccesoArray(Expresion exp) {
        this.indice = exp;
    }

    public String toString(){
        return accesoAnterior.toString() + "[" + exp.toString() + "]";
    }
    
}
