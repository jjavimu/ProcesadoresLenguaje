package ast.accesos;

public class AccesoPuntero {
    protected Acceso accesoAnterior;

    public AccesoPuntero(Acceso accesoAnterior) {
        this.accesoAnterior = accesoAnterior;
    }
    
    public String toString(){
        return "*" + accesoAnterior.toString();
    }
}
