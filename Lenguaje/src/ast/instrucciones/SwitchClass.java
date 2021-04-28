package ast.instrucciones;

import java.util.List;

import ast.expresiones.*;

public class SwitchClass extends Ins {

    protected Expresion condicion;
    protected List<CaseSwitch> casos;
    
    public SwitchClass(Expresion condicion, List<CaseSwitch> casos) {
        this.condicion = condicion;
        this.casos = casos;
    }

    public String toString(){
        return "Switch (Condición: " + condicion.toString() + ", Casos:" +casos.toString()+ ")";
    }

}
