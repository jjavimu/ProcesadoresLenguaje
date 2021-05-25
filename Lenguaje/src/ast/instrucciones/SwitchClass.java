package ast.instrucciones;

import java.util.List;
import ast.Programa;
import ast.expresiones.*;
import ast.tipos.*;
import ast.ASTnodo;
import ast.accesos.*;

public class SwitchClass extends Ins {

    protected Expresion condicion;
    protected List<CaseSwitch> casos;
    
    public SwitchClass(Expresion condicion, List<CaseSwitch> casos) {
        this.condicion = condicion;
        this.casos = casos;
    }

    public void calculos(){
        for(CaseSwitch caso:casos){
            caso.calculos();
        }
    }

    public int maxMemoria(){
        int max = 0;
        for(CaseSwitch caso: casos){
            int tam_caso =caso.maxMemoria();
            if (tam_caso > max){
                max = tam_caso;
            }
        }
        return max;
    }

    public void generaCodigo(){
        Programa.escribir.println("block"); // block etiqueta en end para saltar cuando entre en un caso
        condicion.generaCodigo(); // evaluo la condicion 
        if(condicion instanceof Acceso){
            Programa.escribir.println("i32.load"); // si es acceso, obtengo su valor
        }
        Programa.escribir.println("tee_local $temp"); // guardo la condicion en temp y la dejo en la cima de la pila
        for (CaseSwitch caso : casos){
            caso.generaCodigo();
            // ahora tengo que volver a darle a temp la expresion evaludada que estará en la cima de la pila
            Programa.escribir.println("tee_local $temp");
        }

        Programa.escribir.println("drop"); // para quitar de la cima el valor
        Programa.escribir.println("end ;; para salir del switch con break");
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
