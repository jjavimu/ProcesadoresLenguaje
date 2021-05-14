package ast.instrucciones;

import java.util.*;

import ast.expresiones.Expresion;

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
