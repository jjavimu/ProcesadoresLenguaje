package ast.accesos;

import java.util.*;
import ast.Programa;
import ast.ASTnodo;
import ast.instrucciones.*;
import ast.expresiones.*;

public class AccesoVar extends Acceso {
    private String direccionInicial;
    
    
    public AccesoVar(String nombreVar){
        this.direccionInicial = nombreVar;
    }

    public void chequea(){
        // Constante para los enumerados o una declaracion
        // para que no permita hacer int a = main; (encontraria a main en la tabla)
        if((this.nodoVinculo instanceof Constante)||(this.nodoVinculo instanceof DecClass)){
            this.tipo = nodoVinculo.tipo;
        }
        else{
            System.out.println("Error tipos: acceso a variable  " + direccionInicial);
            Programa.okTipos = false;
        } 
    }
    
    public void vincular(){
        ASTnodo nodo = Programa.pila.buscaId(direccionInicial);
        if(nodo == null){
            System.out.println("Error vinculacion: Intento de acceso sin declaracion: " + direccionInicial);
            Programa.okVinculacion = false;
        }
        else
            this.nodoVinculo = nodo;
    }

    public String toString(){
        return direccionInicial;
    }
    
}
