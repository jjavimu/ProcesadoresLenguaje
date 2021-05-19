package ast.instrucciones;

import java.util.*;

import ast.expresiones.Expresion;
import ast.Programa;
import ast.ASTnodo;
import ast.tipos.*;

public class IfClass extends Ins {

    protected Expresion condicion;
    protected List<Ins> instrucciones_then;
    protected List<Ins> instrucciones_else;

    public IfClass(Expresion exp, List<Ins> instrucciones_then) {
        this.condicion = exp;
        this.instrucciones_then = instrucciones_then;
    }

    public IfClass(Expresion exp, List<Ins> instrucciones_then, List<Ins> instrucciones_else) {
        this.condicion = exp;
        this.instrucciones_then = instrucciones_then;
        this.instrucciones_else = instrucciones_else;
    }

    public void chequea(){
        condicion.chequea();
        if(!condicion.tipo.comparar(new TipoBasicoClass("bool"))){ // La condicion tiene que ser bool
            System.out.println("Error tipo: condicion if " + condicion + "("+ condicion.tipo +")"); 
            Programa.okTipos = false;
        }        
        for (Ins instruccion : instrucciones_then) {
            instruccion.chequea();
        }
        if (instrucciones_else != null){
            for (Ins instruccion : instrucciones_else) {
                instruccion.chequea();
            }
        }
    }

    public void vincular() {
        condicion.vincular();
        Programa.pila.abreBloque();
        for (Ins instruccion : instrucciones_then) {
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
        if (instrucciones_else != null) {
            Programa.pila.abreBloque();
            for (Ins instruccion : instrucciones_else) {
                instruccion.vincular();
            }
            Programa.pila.cierraBloque();
        }
    }

    public void setReturn(ASTnodo nodoFuncion) {
        for (Ins instruccion : instrucciones_then) {
            // Vincular el return
            if (!(instruccion instanceof AsigClass || instruccion instanceof DecClass
                    || instruccion instanceof FuncallClass)) {
                instruccion.setReturn(nodoFuncion);
            }
        }
        for (Ins instruccion : instrucciones_else) {
            // Vincular el return
            if (!(instruccion instanceof AsigClass || instruccion instanceof DecClass
                    || instruccion instanceof FuncallClass)) {
                instruccion.setReturn(nodoFuncion);
            }
        }
    }

    public String toString() {
        String inst = "";
        for (Ins i : instrucciones_then) {
            inst = inst + i + "\n";
        }
        String el = "";
        if (instrucciones_else != null) {
            for (Ins i : instrucciones_else) {
                el = el + i + "\n";
            }
        }

        return "If (Condición:" + condicion.toString() + ", Instrucciones:\n" + inst + "Else:\n" + el + ")";
    }

}
