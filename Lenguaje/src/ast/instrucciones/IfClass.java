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

    // GENERAR CODIGO -----------------------------------------------------------------
    public void calculos() {
        int cima = Programa.etiquetas.peek();
        Programa.etiquetas.push(cima);
        for (Ins ins : instrucciones_then) {
            ins.calculos();
        }
        Programa.etiquetas.pop();
            if (instrucciones_else != null){
            Programa.etiquetas.push(cima);
            for (Ins ins : instrucciones_else) {
                ins.calculos();
            }
            Programa.etiquetas.pop();
        }
    }

    public int maxMemoria() {
        int tam_max_if = 0;
        int tam_max_else = 0;

        for (Ins ins : instrucciones_then) {
            if (ins instanceof DecClass) {
                tam_max_if += ins.maxMemoria(); // tamaño de la declaracion
            }
        }

        int c_if = tam_max_if;
        for (Ins ins : instrucciones_then) {
            if (ins instanceof ForClass || ins instanceof WhileClass || ins instanceof IfClass
                    || ins instanceof SwitchClass) {
                int tam_bloque = ins.maxMemoria(); // tamaño_max del bloque
                if (c_if + tam_bloque > tam_max_if) {
                    tam_max_if = c_if + tam_bloque;
                }
            }
        }

        if (instrucciones_else != null) {
            for (Ins ins : instrucciones_else) {
                if (ins instanceof DecClass) {
                    tam_max_else += ins.maxMemoria(); // tamaño de la declaracion
                }
            }

            int c_else = tam_max_else;
            for (Ins ins : instrucciones_else) {
                if (ins instanceof ForClass || ins instanceof WhileClass || ins instanceof IfClass
                        || ins instanceof SwitchClass) {
                    int tam_bloque = ins.maxMemoria(); // tamaño_max del bloque
                    if (c_else + tam_bloque > tam_max_else) {
                        tam_max_else = c_else + tam_bloque;
                    }
                }
            }
        }

        int max = tam_max_if;
        if (tam_max_else > max)
            max = tam_max_else;
        return max;
    }

    public void generaCodigo(){
        condicion.generaCodigo(); // es booleana

        Programa.escribir.println("if");

        for (Ins ins : instrucciones_then) {
            ins.generaCodigo();
        }
        
        Programa.escribir.println("else");

        if (instrucciones_else != null) {
            for (Ins ins : instrucciones_else) {
                ins.generaCodigo();
            }
        }

        Programa.escribir.println("end");
    }

    // CHEQUEAR TIPOS -----------------------------------------------------------------
    public void chequea() {
        condicion.chequea();
        if (!condicion.tipo.comparar(new TipoBasicoClass("bool"))) { // La condicion tiene que ser bool
            System.out.println("Error tipo: condicion if " + condicion + "(" + condicion.tipo + ")");
            Programa.okTipos = false;
        }
        for (Ins instruccion : instrucciones_then) {
            instruccion.chequea();
        }
        if (instrucciones_else != null) {
            for (Ins instruccion : instrucciones_else) {
                instruccion.chequea();
            }
        }
    }

    // VINCULACION -----------------------------------------------------------------
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

        if (instrucciones_else != null) {
            for (Ins instruccion : instrucciones_else) {
                // Vincular el return
                if (!(instruccion instanceof AsigClass || instruccion instanceof DecClass
                        || instruccion instanceof FuncallClass)) {
                    instruccion.setReturn(nodoFuncion);
                }
            }
        }
    }

    // AST TOSTRING -----------------------------------------------------------------
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
