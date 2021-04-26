package ast.accesos;

public class AccesoStruct {
    protected Acceso accesoAnterior;
    protected String campo;

    public AccesoStruct(Acceso accesoAnterior, String campo) {
        this.accesoAnterior = accesoAnterior;
        this.campo = campo;
    }

    public String toString(){
        return accesoAnterior.toString() + "." + this.campo;
    }

}
