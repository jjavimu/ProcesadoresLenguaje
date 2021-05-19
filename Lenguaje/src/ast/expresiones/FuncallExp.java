package ast.expresiones;

import java.util.List;
import ast.Programa;
import ast.ASTnodo;
import ast.instrucciones.*;
import ast.funciones.*;

public class FuncallExp extends Expresion {
    protected String nombre;
    protected List<Expresion> parametros;

    public FuncallExp(String nombre, List<Expresion> parametros) {
        this.nombre = nombre;
        this.parametros = parametros;
    }

    public void chequea(){
        this.tipo = nodoVinculo.tipo;

        // Chequeamos que hay el mismo nº parametros
        Funcion f = (Funcion) this.nodoVinculo;
        if (f.getListaArgs().size() != this.parametros.size()){ // Error, != nº parametros
            System.out.println("Error vinculación: Distinto nº de parametros");
            Programa.okTipos = false;
        }
        for (int i = 0; i < parametros.size(); ++i){ // el nº parametros esta ok por vinculacion
            parametros.get(i).chequea();

            if(!parametros.get(i).tipo.comparar(f.getListaArgs().get(i).tipo)){
                System.out.println("Error Tipos: Funcion " + f.getNombre() + " espera otros parametros");
                Programa.okTipos = false;
            }
        }   
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
