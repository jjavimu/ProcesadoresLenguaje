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

    public void vincular(){
        condicion.vincular();
        Programa.pila.abreBloque();
        
        for(CaseSwitch caso : casos){
            caso.vincular();
        }
        Programa.pila.cierraBloque();
    }

    public String toString(){
        return "Switch (Condición: " + condicion.toString() + ", Casos:" +casos.toString()+ ")";
    }

}
