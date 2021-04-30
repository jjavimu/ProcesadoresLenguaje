package ast.instrucciones;

import ast.accesos.Acceso;
import ast.expresiones.*;


public class AsigClass extends Ins {

    protected Acceso nombre;
    protected Expresion exp;

    public AsigClass(Acceso nombre, Expresion exp){
        this.exp=exp;
        this.nombre=nombre;
    }
    
    public String toString(){
        return "Asignacion( Nombre:" + nombre + ", exp:  " + exp + ")";
    } 
}
