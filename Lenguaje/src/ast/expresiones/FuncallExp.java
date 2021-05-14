package ast.expresiones;

import java.util.List;
import ast.Programa;
import ast.ASTnodo;

public class FuncallExp extends Expresion {
    protected String nombre;
    protected List<Expresion> parametros;

    public FuncallExp(String nombre, List<Expresion> parametros) {
        this.nombre = nombre;
        this.parametros = parametros;
    }

    public void vincular(){
        ASTnodo nodo = Programa.pila.buscaId(nombre);
        if(nodo == null){
            System.out.println("Error vinculacion: Intento hacer llamada sin declarar");
            Programa.okVinculacion = false;
        }
        for(Expresion param: parametros){
            param.vincular();
        }
        this.nodoVinculo = nodo;
    }

   
    public String toString(){
        return "Llamada" + nombre + "(" + parametros.toString() + ")";
    }
   
    
}
