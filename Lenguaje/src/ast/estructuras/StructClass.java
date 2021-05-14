package ast.estructuras;

import java.util.*;
import ast.instrucciones.DecClass;
import ast.ASTnodo;

public class StructClass extends ASTnodo {

    private String nombre;
    private List<DecClass> valores;

    public StructClass(String nombre, List<DecClass> valores) {
        this.nombre = nombre;
        this.valores = valores;
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

    public String toString() {
        return "\nNombreStruct: " + nombre + valores + "\n";
    }
}
