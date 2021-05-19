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

    public String getNombre(){
        return nombre;
    }

    public void chequea(){
        // El tipo de la parte izquierda es this.tipo
        tipo.chequea();
        if(exp!=null) {
            exp.chequea();

            if(!this.tipo.comparar(exp.tipo)){
                System.out.println("Error tipo: Declaracion " + tipo + " " + nombre + "=" + exp + "(" + nombre + "," + exp.tipo + ")");
                Programa.okTipos = false;
            }
    }
    }

    public void vincular() {
        // Tenemos un buscaId particular para este caso
        // Va a permitir de declarar con un mismo identificador siempre y cuado no se haya declarado uno con el 
        // mismo nombre en ese bloque
        ASTnodo nodo = Programa.pila.buscaIdCima(nombre);
        if (nodo == null) { //devuelve null cuando no esta
            Programa.pila.insertaId(nombre, this);
             if (exp != null)
                exp.vincular();
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }
    }


    public void setReturn(ASTnodo nodo) {
    }
       

    public String toString(){
        return "Declaracion(Tipo: " + tipo + ", nombre:" + nombre + ", exp: " + exp + ")"; 
    }
    
}
