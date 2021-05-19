package ast.instrucciones;

import java.util.List;
import ast.Programa;
import ast.expresiones.*;
import ast.tipos.*;
import ast.ASTnodo;

public class SwitchClass extends Ins {

    protected Expresion condicion;
    protected List<CaseSwitch> casos;
    
    public SwitchClass(Expresion condicion, List<CaseSwitch> casos) {
        this.condicion = condicion;
        this.casos = casos;
    }

    public void chequea(){
        condicion.chequea();
        // los casos tienen que ser del mismo tipo que la condicion

        for(CaseSwitch caso:casos){
            caso.chequea();  
            if(caso.getTipo()!=null && !caso.getTipo().comparar(condicion.tipo)){
                System.out.println("Error tipo: caso switch " + condicion + "(condicion: "+ condicion.tipo + ", caso: " + caso.getTipo()+")"); 
                Programa.okTipos = false;
            }         
        }
    }

    public void vincular(){
        condicion.vincular();
        Programa.pila.abreBloque();
        
        for(CaseSwitch caso : casos){
            caso.vincular();
        }
        Programa.pila.cierraBloque();
    }

    public void setReturn(ASTnodo nodoFuncion) {
        for (CaseSwitch caso : casos) {
            // Vincular el return
            caso.setReturn(nodoFuncion);
         }
    }

    public String toString(){
        return "Switch (Condición: " + condicion.toString() + ", Casos:" +casos.toString()+ ")";
    }

}
