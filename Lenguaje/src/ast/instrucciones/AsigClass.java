package ast.instrucciones;

import ast.accesos.Acceso;
import ast.expresiones.*;


public class AsigClass extends Ins {

    protected Acceso nombre;
    protected Expresion exp;

    public AsigClass(Acceso nombre, Expresion exp){
        this.exp=exp;
        this.nombre=nombre;
    }

    public void vincular(){
        ASTNodo nodo = Programa.pila.buscaId(nombre);
        if(nodo == null){
            System.out.println("Error vinculacion: Intento asignar sin declaracion");
            Programa.okVinculacion = false;
        }
        exp.vincular();
        this.nodoVinculo = nodo;
    }
    
    public String toString(){
        return "Asignacion( Nombre:" + nombre + ", exp:  " + exp + ")";
    } 
}
