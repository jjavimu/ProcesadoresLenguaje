package ast.accesos;

public class AccesoStruct extends Acceso {
    protected String campo;

    public AccesoStruct(String campo) {
        this.campo = campo;
    }

    public String toString(){
        return  "." + this.campo;
    }

}
