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
    

    public String toString(){
        return  "tipo: " + tipo.toString() + ", nombre: " + this.nombre + ", expresion: " + exp;

    }
    
}
