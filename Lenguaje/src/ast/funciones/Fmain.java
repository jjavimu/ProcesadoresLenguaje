package ast.funciones;

import ast.tipos.*;
import java.util.*;
import ast.instrucciones.*;
import ast.Programa;

public class Fmain extends Funcion {

    private int tam_memoria;

    public Fmain(String nombre, List<Ins> ins) {
        // El nombre sobra
        super(new TipoBasicoClass("void"), nombre, new ArrayList<ParTipoIden>(), ins);
    }

    public void calculos() {
        Programa.etiquetas.push(0);
        for (Ins ins : this.lista_ins) { //si hubiese parametros se recorrerian
            ins.calculos();
        }
        Programa.etiquetas.pop();
    }

    public int maxMemoria() {
        tam_memoria = 0;

        for (ParTipoIden param : lista_args) {
            int tam_param = param.maxMemoria(); // tamaño de la declaracion
            tam_memoria += tam_param;
        }

        for (Ins ins : this.lista_ins) {
            if (ins instanceof DecClass) {
                int tam_dec = ins.maxMemoria(); // tamaño de la declaracion
                tam_memoria += tam_dec;
            }
        }

        int c = tam_memoria;
        for (Ins ins : this.lista_ins) {
            if (ins instanceof ForClass || ins instanceof WhileClass || ins instanceof IfClass
                    || ins instanceof SwitchClass) {
                int tam_bloque = ins.maxMemoria(); // tamaño_max del bloque
                if (c + tam_bloque > tam_memoria) {
                    tam_memoria = c + tam_bloque;
                }
            }
        }
        System.out.println(tam_memoria);
        return tam_memoria;
    }

    public void generaCodigo() {
        int tam = tam_memoria + 8;

        Programa.escribir.println("(func $main  (type $_sig_void)");
        Programa.escribir.println(" (local $localsStart i32)");
        Programa.escribir.println(" (local $temp i32)");
        Programa.escribir.println(" i32.const " + tam); //  ;; let this be the stack size needed (params+locals+2)*4");
        Programa.escribir.println(" call $reserveStack"); // ;; returns old MP (dynamic link)");
        Programa.escribir.println(" set_local $temp");
        Programa.escribir.println(" get_global $MP");
        Programa.escribir.println(" get_local $temp");
        Programa.escribir.println(" i32.store"); // vuelvo al antiguo marco
        Programa.escribir.println(" get_global $MP");
        Programa.escribir.println(" get_global $SP");
        Programa.escribir.println(" i32.store offset=4"); //dir mp + 4 guardo sp
        Programa.escribir.println(" get_global $MP");
        Programa.escribir.println(" i32.const 8"); //salto el dl y el 2p que ocupan 8 primeras 
        Programa.escribir.println(" i32.add");
        Programa.escribir.println(" set_local $localsStart"); //localstart es donde empieza funcion
        
        for (Ins ins : this.lista_ins) {
            ins.generaCodigo();
        }

        Programa.escribir.println(" call $freeStack");
        Programa.escribir.println(")");
    }
}