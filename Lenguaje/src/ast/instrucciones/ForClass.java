package ast.instrucciones;

import ast.expresiones.*;
import java.util.*;
import ast.Programa;
import ast.ASTnodo;
import ast.tipos.*;

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
        if(dec.tipo == null)
            return;
        if(!dec.tipo.comparar(new TipoBasicoClass("int"))){ // La declaracion tiene que ser int
            System.out.println("Error tipo: declaracion for " + dec + "("+ dec.tipo +")");    
            Programa.okTipos = false;        
        }
        expCond.chequea();
        if(expCond.tipo == null)
            return;
        if(!expCond.tipo.comparar(new TipoBasicoClass("bool"))){ // La condicion tiene que ser bool
            System.out.println("Error tipo: condicion for " + expCond + "("+ expCond.tipo +")"); 
            Programa.okTipos = false;
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


    public void setReturn(ASTnodo nodoFuncion) {
        for (Ins instruccion : instrucciones) {
            // Vincular el return
            if (!(instruccion instanceof AsigClass || instruccion instanceof DecClass
                    || instruccion instanceof FuncallClass)) {
                instruccion.setReturn(nodoFuncion);
            }
        }
    }

    public String toString(){
        String inst = "";
        for(Ins i : instrucciones){
            inst = inst + i + "\n";
        }

        return "for (" + dec + ";" + expCond + ";" + asig + "Instrucciones:\n" + inst + ")";
    }
    
}
