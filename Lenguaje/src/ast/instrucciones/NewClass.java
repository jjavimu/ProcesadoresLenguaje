package ast.instrucciones;

import ast.accesos.Acceso;
import ast.tipos.TipoClass;

public class NewClass {
    private TipoClass tipo;
    private Acceso acceso;

    public NewClass(Acceso nombre, TipoClass tipo){
        this.acceso = nombre;
        this.tipo = tipo; 
    }

    public String toString(){
        return acceso.toString() + "= new" +tipo.toString()+ ";\n";
    }
}
