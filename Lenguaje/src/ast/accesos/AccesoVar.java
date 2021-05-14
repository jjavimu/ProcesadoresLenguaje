package ast.accesos;
import java.util.*;

public class AccesoVar extends Acceso {
    private String direccionInicial;
    
    public AccesoVar(String nombreVar){
        this.direccionInicial = nombreVar;
    }


    public void vincular(){
        ASTNodo nodo = Programa.pila.buscaId(direccionInicial);
        if(nodo==null){
            System.out.println("Error vinculacion: Intento de acceso sin declaracion");
            Programa.okVinculacion = false;
        }
        this.nodoVinculo = nodo;
    }

    public String toString(){
        return direccionInicial;
    }
    
}
