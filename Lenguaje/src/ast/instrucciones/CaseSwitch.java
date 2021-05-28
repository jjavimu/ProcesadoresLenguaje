package ast.instrucciones;

import java.util.*;

import ast.expresiones.*;
import ast.Programa;
import ast.ASTnodo;
import ast.tipos.*;
import ast.accesos.*;

public class CaseSwitch {

    protected Expresion caso;
    protected List<Ins> instrucciones;

    public CaseSwitch(Expresion condicion, List<Ins> instrucciones) {
        this.caso = condicion;
        this.instrucciones = instrucciones;
    }

    public CaseSwitch(List<Ins> instrucciones) {
        this.caso = null;
        this.instrucciones = instrucciones;
    }

    // GENERACION CODIGO -----------------------------------------------------------------
    public void generaCodigo() {
        Programa.escribir.println("end"); // comienzo del caso
        Programa.escribir.println("get_local $temp"); // dejo en la cima de la pila la condicion pa no perderla
        if (caso != null) {
            caso.generaCodigo();
            if (caso instanceof Acceso) {
                Programa.escribir.println("i32.load"); // si es acceso, obtengo su valor
            }
            Programa.escribir.println("get_local $temp"); // temp tiene el valor de la exp del switch
            Programa.escribir.println("i32.eq"); // si es es caso adecuado
            Programa.escribir.println("i32.eqz"); // cambio el valor
            Programa.escribir.println("br_if 0"); // si no es el valor entonces salto al siguiente caso
        } 
        // si es el caso, tengo que hacer sus instrucciones
        for (Ins instruccion : instrucciones) {
            instruccion.generaCodigo();
        }
        Programa.escribir.println("br $break"); // ;; salto al end del switch bc of break
    }

    public void calculos() {
        int cima = Programa.etiquetas.peek();
        Programa.etiquetas.push(cima);
        for (Ins instruccion : instrucciones) {
            instruccion.calculos();
        }
        Programa.etiquetas.pop();
    }

    public int maxMemoria() {
        int tam_max = 0;

        for (Ins ins : instrucciones) {
            if (ins instanceof DecClass) {
                tam_max += ins.maxMemoria(); // tamaño de la declaracion
            }
        }

        int c = tam_max;
        for (Ins ins : this.instrucciones) {
            if (ins instanceof ForClass || ins instanceof WhileClass || ins instanceof IfClass
                    || ins instanceof SwitchClass) {
                int tam_bloque = ins.maxMemoria(); // tamaño_max del bloque
                if (c + tam_bloque > tam_max) {
                    tam_max = c + tam_bloque;
                }
            }
        }
        return tam_max;
    }

    // CHEQUEAR TIPOS -----------------------------------------------------------------
    public void chequea() {
        if (caso != null)
            caso.chequea();
        for (Ins instruccion : instrucciones) {
            instruccion.chequea();
        }
    }

    // VINCULACION -----------------------------------------------------------------
    public void vincular() {
        if (caso != null)
            caso.vincular();

        Programa.pila.abreBloque();
        for (Ins instruccion : instrucciones) {
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
    }

    // AST TOSTRING -----------------------------------------------------------------
    public String toString() {
        if (caso == null)
            return "default: " + instrucciones.toString();
        else
            return "case " + caso.toString() + ": " + instrucciones.toString();
    }

    // AUXILIARES -----------------------------------------------------------------
    public void setReturn(ASTnodo nodoFuncion) {
        for (Ins instruccion : instrucciones) {
            // Vincular el return
            if (!(instruccion instanceof AsigClass || instruccion instanceof DecClass
                    || instruccion instanceof FuncallClass)) {
                instruccion.setReturn(nodoFuncion);
            }
        }
    }

    public TipoClass getTipo() {
        return caso == null ? null : caso.tipo;
    }
}