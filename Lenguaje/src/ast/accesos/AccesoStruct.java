package ast.accesos;

public class AccesoStruct extends Acceso {
    protected Acceso acceso;
    protected String campo;

    public AccesoStruct(Acceso acceso, String campo) {
        this.campo = campo;
        this.acceso = acceso;
    }

    public String toString(){
        return acceso.toString() + "." + this.campo;
    }

}
