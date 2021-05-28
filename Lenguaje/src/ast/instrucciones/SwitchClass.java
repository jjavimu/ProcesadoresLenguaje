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

    // GENERAR CODIGO -----------------------------------------------------------------
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
        condicion.generaCodigo(); // evaluo la condicion 
        if(condicion instanceof Acceso){
            Programa.escribir.println("i32.load"); // si es acceso, obtengo su valor
        }
        Programa.escribir.println("set_local $temp"); // guardo la condicion en temp

        Programa.escribir.println("block $break"); // block etiqueta en end para saltar cuando entre en un caso con break
        for (CaseSwitch caso : casos){
            Programa.escribir.println("block ;; un caso");
        }
        for (CaseSwitch caso : casos){
            caso.generaCodigo(); // lo primero que haré despues de end es dejar en la cima de la pila el valor de la exp
            Programa.escribir.println("set_local $temp"); // guardo la condicion en temp que dejé en la cima para recuperar
        }

        Programa.escribir.println("end ;; para salir del switch con break");
        //Programa.escribir.println("drop"); // para quitar de la cima el valor
    }

    // CHEQUEAR TIPOS -----------------------------------------------------------------
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

    // VINCULACION -----------------------------------------------------------------
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

    // AST TOSTRING -----------------------------------------------------------------
    public String toString(){
        return "Switch (Condición: " + condicion.toString() + ", Casos:" +casos.toString()+ ")";
    }

}
