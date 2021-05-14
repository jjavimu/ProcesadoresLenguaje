package ast.instrucciones;

import ast.tipos.*;
import ast.accesos.Acceso;
import ast.expresiones.*;

public class DecClass extends Ins {

    protected TipoClass tipo;
    protected String nombre;
    protected Expresion exp;

    public DecClass(TipoClass tipo, String nombre, Expresion exp){ // No inicializado
        this.tipo = tipo;
        this.nombre = nombre; 
        this.exp = exp;
    }

    public void vincular() {
        ASTNodo nodo = Programa.pila.buscaId(nombre);
        if (nodo != null) {
            Programa.pila.insertaId(nombre, this);
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado");
            Programa.okVinculacion = false;
        }
    }
       

    public String toString(){
        return "Declaracion(Tipo: " + tipo + ", nombre:" + nombre + ", exp: " + exp + ")"; 
    }
    
}
