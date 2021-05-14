package ast.instrucciones;

import java.util.*;
import ast.Programa;
import ast.expresiones.Expresion;

public class WhileClass extends Ins {   
    protected Expresion condicion;
    protected List<Ins> instrucciones;
    
    public WhileClass(Expresion exp, List<Ins> instrucciones){
        this.condicion = exp;
        this.instrucciones = instrucciones;
    }

    public void chequea(){
        condicion.chequea();
        if(!condicion.tipo.comparar(new TipoBasicoClass("bool"))){ // La condicion tiene que ser bool
            System.out.println("Error tipo: condicion while " + condicion + "("+ condicion.tipo +")"); 
        } 
        for(Ins instruccion : instrucciones){
            instruccion.chequea();
        }
    }

    public void vincular(){
        Programa.pila.abreBloque();
        condicion.vincular();
        for(Ins instruccion : instrucciones){
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
    }

    public String toString(){
        String inst = "";
        for(Ins i : instrucciones){
            inst = inst + i + "\n";
        }

        return "while (Condición: " + condicion.toString() + ", Instrucciones:\n" + inst + ")";
    }
    
}
