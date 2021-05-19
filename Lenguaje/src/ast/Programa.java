package ast;

import ast.funciones.Fmain;
import java.util.*;
import ast.estructuras.*;

public class Programa extends ASTnodo {
    
    private ListaDefiniciones definiciones; // Structs, enums y funciones
    private Fmain fmain; //Funcion main del programa

    // Pila de tabla se simbolos
    public static PilaTablaSimbolos pila;
    public static Boolean okVinculacion; 

    // Tipos 
    public static List<String> tipos_basicos = new ArrayList<String>();
    public static List<EnumClass> tipos_enum = new ArrayList<EnumClass>();
    public static List<StructClass> tipos_struct = new ArrayList<StructClass>();
    public static Boolean okTipos;
    
    public Programa(ListaDefiniciones l, Fmain fmain){
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
    
    public void chequea(){
        definiciones.chequea();
        fmain.chequea();
    }

    public void vincular(){
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
