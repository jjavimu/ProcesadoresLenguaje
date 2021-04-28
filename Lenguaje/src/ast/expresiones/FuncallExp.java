package ast.expresiones;

import java.util.List;

public class FuncallExp extends Expresion {
    protected String nombre;
    protected List<Expresion> parametros;

    public FuncallExp(String nombre, List<Expresion> parametros) {
        this.nombre = nombre;
        this.parametros = parametros;
    }

   
    public String toString(){
        return "Llamada" + nombre + "(" + parametros.toString() + ")";
    }
   
    
}
