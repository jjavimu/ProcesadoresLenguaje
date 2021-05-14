package ast.instrucciones;

import ast.expresiones.*;
import java.util.*;
import ast.Programa;

public class ForClass extends Ins {
    private DecClass dec;
    private Expresion expCond;
    private AsigClass asig;
    private List<Ins> instrucciones;
    
    public ForClass(DecClass dec, Expresion expCond, AsigClass asig, List<Ins>ins){
        this.dec = dec;
        this.expCond = expCond;
        this.asig = asig;
        this.instrucciones = ins;
    }

    public void chequea(){
        dec.chequea();
        if(!dec.tipo.comparar(new TipoBasicoClass("int"))){ // La declaracion tiene que ser int
            System.out.println("Error tipo: declaracion for " + dec + "("+ dec.tipo +")");            
        }
        expCond.chequea();
        if(!expCond.tipo.comparar(new TipoBasicoClass("bool"))){ // La condicion tiene que ser bool
            System.out.println("Error tipo: condicion for " + expCond + "("+ expCond.tipo +")"); 
        }
        asig.chequea();

        for(Ins instruccion : instrucciones){
            instruccion.chequea();
        }
    }

    public void vincular(){
        Programa.pila.abreBloque();
        dec.vincular();
        expCond.vincular();
        
        for(Ins instruccion : instrucciones){
            instruccion.vincular();
        }
        
        asig.vincular();
        Programa.pila.cierraBloque();
    }


    public String toString(){
        String inst = "";
        for(Ins i : instrucciones){
            inst = inst + i + "\n";
        }

        return "for (" + dec + ";" + expCond + ";" + asig + "Instrucciones:\n" + inst + ")";
    }
    
}
