package ast.estructuras;

import java.util.*;

public class EnumClass {
    private String nombre;
    private List<String> valores;
    
    public EnumClass(String nombre, List<String> valores){
        this.nombre = nombre;
        this.valores = valores;  
    }
    
    
    public String toString() {
        return nombre + "->" + valores.toString() + "\n";
    }
}
