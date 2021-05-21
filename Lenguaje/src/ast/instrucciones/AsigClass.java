package ast.instrucciones;

import ast.accesos.Acceso;
import ast.expresiones.*;
import ast.Programa;
import ast.ASTnodo;


public class AsigClass extends Ins {

    protected Acceso nombre;
    protected Expresion exp;

    public AsigClass(Acceso nombre, Expresion exp){
        this.exp=exp;
        this.nombre=nombre;
    }

    public void calculos(){}

    public void generaCodigo(){
        nombre.generaCodigo(); //devuelve una direccion
        exp.generaCodigo();
        if(exp instanceof Acceso){
            Programa.escribir.println("i32.load"); 
        }
        Programa.escribir.println("i32.store");
    }

    public void chequea(){
        nombre.chequea();
        exp.chequea();

        if(!nombre.tipo.comparar(exp.tipo)){
            System.out.println("Error tipo: Asignacion " + nombre + "=" + exp + "(" + nombre.tipo + "," + exp.tipo + ")");
            Programa.okTipos = false;
        }
    }

    public void vincular(){
        nombre.vincular();
        exp.vincular();
    }


    public void setReturn(ASTnodo nodo) {
    }
    
    public String toString(){
        return "Asignacion( Nombre:" + nombre + ", exp:  " + exp + ")";
    } 
}
