package ast.estructuras;

import java.util.*;
import ast.instrucciones.DecClass;

public class StructClass extends ASTnodo {

    private String nombre;
    private List<DecClass> valores;
    
    public StructClass(String nombre, List<DecClass> valores){
        this.nombre = nombre;
        this.valores = valores;
    }
    
    @Override
    public String toString() {
        return nombre + "->" + valores + "\n";
    }
}
