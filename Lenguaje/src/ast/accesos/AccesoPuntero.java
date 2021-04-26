package ast.accesos;

public class AccesoPuntero extends Acceso{
    protected Acceso direccion;

    public AccesoStruct(Acceso direccion) {
        this.direccion = direccion;
    }
    
    public String toString(){
        return "*" + direccion.toString();
    }
}
