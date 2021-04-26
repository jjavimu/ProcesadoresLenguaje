package ast.accesos;

public class AccesoVar {
    private String direccion;

    public AccesoVar(String nombreVar){
        this.direccion = nombreVar;
    }

    public String toString(){
        return direccion;
    }
    
}
