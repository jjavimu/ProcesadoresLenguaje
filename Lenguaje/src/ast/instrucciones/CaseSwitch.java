package ast.instrucciones;

import java.util.*;

import ast.expresiones.*;
import ast.Programa;
import ast.ASTnodo;
import ast.tipos.*;


public class CaseSwitch{

    protected Expresion caso;
    protected List<Ins> instrucciones;

    public CaseSwitch(Expresion condicion, List<Ins> instrucciones){
        this.caso = condicion;
        this.instrucciones = instrucciones;
    }
    
    public CaseSwitch(List<Ins> instrucciones){
        this.caso = null;
        this.instrucciones = instrucciones;
    }

    public void calculos(){
        int cima = Programa.etiquetas.peek();
        Programa.etiquetas.push(cima);
        for(Ins instruccion : instrucciones){
            instruccion.calculos();
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

    public TipoClass getTipo(){
        return caso == null ? null : caso.tipo;
    }

    public void chequea(){
        if (caso!=null) caso.chequea();
        for(Ins instruccion : instrucciones){
            instruccion.chequea();
        }
    }

    public void vincular() {
        if (caso!=null) caso.vincular();

        Programa.pila.abreBloque();
        for (Ins instruccion : instrucciones) {
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
    

    public String toString(){
        if(caso == null)
            return "default: " + instrucciones.toString();
        else return "case " + caso.toString() + ": " + instrucciones.toString();
    }
}