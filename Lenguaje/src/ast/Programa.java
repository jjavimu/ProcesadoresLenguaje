package ast;

import ast.funciones.Fmain;
import java.util.*;
import ast.estructuras.*;
import java.io.*;

public class Programa extends ASTnodo {

    private ListaDefiniciones definiciones; // Structs, enums y funciones
    private Fmain fmain; // Funcion main del programa

    // Pila de tabla se simbolos
    public static PilaTablaSimbolos pila;
    public static Boolean okVinculacion;

    // Tipos
    public static List<String> tipos_basicos = new ArrayList<String>();
    public static List<EnumClass> tipos_enum = new ArrayList<EnumClass>();
    public static List<StructClass> tipos_struct = new ArrayList<StructClass>();
    public static Stack<Integer> etiquetas = new Stack<Integer>();
    public static Boolean okTipos;
    public static PrintWriter escribir;

    public Programa(ListaDefiniciones l, Fmain fmain) {
        this.definiciones = l;
        this.fmain = fmain;
        this.okVinculacion = true;
        this.okTipos = true;

        tipos_basicos.add("int");
        tipos_basicos.add("float");
        tipos_basicos.add("bool");
        tipos_basicos.add("void");
        tipos_basicos.add("char");
        tipos_basicos.add("string");
    }

    public void calculos() {
        fmain.calculos();
    }

    public int maxMemoria() {
        fmain.maxMemoria();
        return 0;
    }

    public void generaCodigo() {
        try {
            escribir = new PrintWriter(new FileWriter("../codigo/codigoPrueba.wat"));

            escribir.println("(module");

            escribir.println(" (type $_sig_i32ri32 (func (param i32) (result i32)))");
            escribir.println("(type $_sig_i32 (func (param i32)))");
            escribir.println("(type $_sig_ri32 (func (result i32)))");
            escribir.println("(type $_sig_void (func ))");
            escribir.println("(import \"runtime\" \"exceptionHandler\" (func $exception (type $_sig_i32)))");
            escribir.println("(import \"runtime\" \"print\" (func $print (type $_sig_i32)))");
            escribir.println("(import \"runtime\" \"read\" (func $read (type $_sig_ri32)))");

            escribir.println("(memory 2000)");

            escribir.println("(global $SP (mut i32) (i32.const 0)) ;; start of stack");
            escribir.println("(global $MP (mut i32) (i32.const 0)) ;; mark pointer");
            escribir.println("(global $NP (mut i32) (i32.const 131071996)) ;; heap 2000*64*1024-4");

            escribir.println("(start $main)");

            fmain.generaCodigo(); // genera codigo del main

            escribir.println("(func $reserveStack (param $size i32)");
            escribir.println("  (result i32)");
            escribir.println("  get_global $MP");
            escribir.println("  get_global $SP");
            escribir.println("  set_global $MP");
            escribir.println("  get_global $SP");
            escribir.println("  get_local $size");
            escribir.println("  i32.add");
            escribir.println("  set_global $SP");
           /*escribir.println("  get_global $SP"); // ;; aqui esto nada porque es para controlar q no se cruce heap
            escribir.println("  get_global $NP");
            escribir.println("  i32.gt_u");
            escribir.println("  if");
            escribir.println("  i32.const 3");
            escribir.println("  call $exception");
            escribir.println("  end");*/
            escribir.println(")");
            escribir.println("(func $freeStack (type $_sig_void)");
            escribir.println("  get_global $MP");
            escribir.println("  i32.load");
            escribir.println("  i32.load offset=4");
            escribir.println("  set_global $SP");
            escribir.println("  get_global $MP");
            escribir.println("  i32.load");
            escribir.println("  set_global $MP");
            escribir.println(")");

            escribir.println(")");
            escribir.close();
        } catch (Exception e) {
            System.out.println("CODIGO MAL");
        }
    }

    public void chequea() {
        definiciones.chequea();
        fmain.chequea();
    }

    public void vincular() {
        pila = new PilaTablaSimbolos();
        pila.abreBloque();
        definiciones.vincular();
        fmain.vincular();
        pila.cierraBloque();
    }

    public String toString() {
        return definiciones.toString() + "\nFuncion Main: " + fmain.toString();
    }

}
