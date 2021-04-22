package ast.instrucciones;

import java.util.*;

import ast.expresiones.Expresion;

public class IfClass extends Ins {

    protected Expresion condicion;
    protected List<Ins> instrucciones_then;
    protected List<Ins> instrucciones_else;

    public IfClass(Expresion exp, List<Ins> instrucciones_then){
        this.condicion = exp;
        this.instrucciones_then = instrucciones_then;
    }
    public IfClass(Expresion exp, List<Ins> instrucciones_then,List<Ins> instrucciones_else){
        this.condicion = exp;
        this.instrucciones_then = instrucciones_then;
        this.instrucciones_else = instrucciones_else;
    }

    public String toString(){
        String els = " ";
        if (instrucciones_else != null){
            els = "else {\n" + instrucciones_else + "}\n";
        }
        return "if (" + condicion.toString() + ") {\n " + instrucciones_then.toString() + "}\n" + els;
    }
    
}
