package ast.estructuras;

import java.util.*;
import ast.instrucciones.DecClass;
import ast.ASTnodo;
import ast.Programa;

public class StructClass extends ASTnodo {

    private String nombre;
    private List<DecClass> valores;

    public StructClass(String nombre, List<DecClass> valores) {
        this.nombre = nombre;
        this.valores = valores;
    }

    public void vincular() {
        ASTnodo nodo = Programa.pila.buscaId(nombre);
        if (nodo == null) { //devuelve null cuando no esta
            Programa.pila.insertaId(nombre, this);
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre );
            Programa.okVinculacion = false;
        }
    }

    public String toString() {
        return "\nNombreStruct: " + nombre + valores + "\n";
    }
}
