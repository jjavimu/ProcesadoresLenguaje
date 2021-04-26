package ast.accesos;
import java.util.*;

public class AccesoVar extends Acceso {
    private String direccionInicial;
    private List<Acceso> accesos;
    
    public AccesoVar(String nombreVar, List<Acceso> accesos){
        this.direccionIncial = nombreVar;
        this.accesos = accesos;
    }

    public String toString(){
        return direccionInicial + accesos.toString();
    }
    
}
