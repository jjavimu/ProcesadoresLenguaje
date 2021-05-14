package ast.estructuras;

import java.util.*;

import ast.ASTnodo;

public class EnumClass extends ASTnodo {
    private String nombre;
    private List<String> valores;
    
    public EnumClass(String nombre, List<String> valores){
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
        return "\nNombreEnum: " + nombre  + valores + "\n";
    }
}
