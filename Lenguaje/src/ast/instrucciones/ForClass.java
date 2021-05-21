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

    public void calculos(){
        int cima = Programa.etiquetas.peek();
        Programa.etiquetas.push(cima);
        dec.calculos();
        for (Ins ins : instrucciones){
            ins.calculos();
        }
        Programa.etiquetas.pop();
    }

    public int maxMemoria(){
        int tam_max = 4; //su declaracion

        for (Ins ins : instrucciones){
            if(ins instanceof DecClass){
                tam_max += ins.maxMemoria(); //tamaño de la declaracion
            }
        }

        int c = tam_max;
        for (Ins ins : this.instrucciones){
            if(ins instanceof ForClass || ins instanceof WhileClass
            || ins instanceof IfClass || ins instanceof SwitchClass){
                int tam_bloque = ins.maxMemoria(); //tamaño_max del bloque
                if(c+tam_bloque > tam_max){
                    tam_max = c+tam_bloque;
                }
            }
        }
        return tam_max;
    }

    public void generaCodigo(){
        dec.generaCodigo();

        Programa.escribir.println("block");
        Programa.escribir.println("loop");

        expCond.generaCodigo();
        
        Programa.escribir.println("i32.eqz");
        Programa.escribir.println("br_if 1");
        
        for (Ins ins : instrucciones){
            ins.generaCodigo();
        }

        asig.generaCodigo();

        Programa.escribir.println("br 0");
        Programa.escribir.println("end");
        Programa.escribir.println("end");
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
