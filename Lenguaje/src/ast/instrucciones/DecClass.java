package ast.instrucciones;

import ast.tipos.*;
import ast.accesos.Acceso;
import ast.expresiones.*;
import ast.ASTnodo;
import ast.Programa;

public class DecClass extends Ins {

    // protected TipoClass tipo;
    protected String nombre;
    protected Expresion exp;

    public DecClass(TipoClass tipo, String nombre, Expresion exp){ // No inicializado
        this.tipo = tipo;
        this.nombre = nombre; 
        this.exp = exp;
    }

    public void chequea(){
        // El tipo de la parte izquierda es this.tipo
        exp.chequea();

        if(!this.tipo.comparar(exp.tipo)){
            System.out.println("Error tipo: Declaracion " + tipo + " " + nombre + "=" + exp + "(" + nombre.tipo + "," + exp.tipo + ")");
        }
    }

    public void vincular() {
        ASTnodo nodo = Programa.pila.buscaId(nombre);
        if (nodo == null) { //devuelve null cuando no esta
            Programa.pila.insertaId(nombre, this);
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }
    }
       

    public String toString(){
        return "Declaracion(Tipo: " + tipo + ", nombre:" + nombre + ", exp: " + exp + ")"; 
    }
    
}
