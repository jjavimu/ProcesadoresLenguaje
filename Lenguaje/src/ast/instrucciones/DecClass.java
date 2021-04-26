package ast.instrucciones;

import ast.tipos.*;
import ast.expresiones.*;

public class DecClass extends Ins {

    protected TipoClass tipo;
    protected Acceso nombre;
    protected Asignacion asig;
    protected NewClass asigDinamica;

    public DecClass(TipoClass tipo, Acceso nombre){ // No inicializado
        this.tipo = tipo;
        this.nombre = nombre; 
    }
    
    public DecClass(TipoClass tipo, Asignacion asig){ // Inicializado
        this.tipo = tipo;
        this.asig = asig;
    }
    public DecClass(TipoClass tipo, NewClass asigNew){ // Inicializado dinamico
        this.tipo = tipo;
        this.asigDinamica = asigNew;
    }

    public String toString(){
        if (asignacion == null && asigDinamica == null) // no se ha init
            return tipo.toString() + " " + nombre.toString() + ";\n";
        else {// se ha inicializado
            if(asignacion != null) // no new
                return tipo.toString() + " " + asig.toString() + ";\n";
            else  // new
                return tipo.toString() + " " + asigDinamica.toString() + ";\n";
        }

    }
    
}
