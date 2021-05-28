package ast.instrucciones;

import java.util.*;
import ast.Programa;
import ast.expresiones.Expresion;
import ast.ASTnodo;
import ast.tipos.*;

public class WhileClass extends Ins {   
    protected Expresion condicion;
    protected List<Ins> instrucciones;
    
    public WhileClass(Expresion exp, List<Ins> instrucciones){
        this.condicion = exp;
        this.instrucciones = instrucciones;
    }

    // GENERACION CODIGO -----------------------------------------------------------------
    public void calculos(){
        int cima = Programa.etiquetas.peek();
        Programa.etiquetas.push(cima);
        for (Ins ins : instrucciones) {
            ins.calculos();
        }
        Programa.etiquetas.pop();
    }

    public int maxMemoria(){
        int tam_max = 0; 

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
       
        Programa.escribir.println("block");
        Programa.escribir.println("loop");

        condicion.generaCodigo();
        
        Programa.escribir.println("i32.eqz");
        Programa.escribir.println("br_if 1");
        
        for (Ins ins : instrucciones){
            ins.generaCodigo();
        }

        Programa.escribir.println("br 0");
        Programa.escribir.println("end");
        Programa.escribir.println("end");
    }

    // CHEQUEAR TIPOS -----------------------------------------------------------------
    public void chequea(){
        condicion.chequea();
        if(!condicion.tipo.comparar(new TipoBasicoClass("bool"))){ // La condicion tiene que ser bool
            System.out.println("Error tipo: condicion while " + condicion + "("+ condicion.tipo +")"); 
            Programa.okTipos = false;
        } 
        for(Ins instruccion : instrucciones){
            instruccion.chequea();
        }
    }

    // VINCULACION -----------------------------------------------------------------
    public void vincular(){
        Programa.pila.abreBloque();
        condicion.vincular();
        for(Ins instruccion : instrucciones){
            instruccion.vincular();
        }
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

    // AST TOSTRING -----------------------------------------------------------------
    public String toString(){
        String inst = "";
        for(Ins i : instrucciones){
            inst = inst + i + "\n";
        }

        return "while (Condición: " + condicion.toString() + ", Instrucciones:\n" + inst + ")";
    }
    
}
