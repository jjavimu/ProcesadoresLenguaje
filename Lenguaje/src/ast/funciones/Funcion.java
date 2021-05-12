package ast.funciones;

import ast.tipos.*;
import java.util.*;
import ast.instrucciones.*;
import ast.ASTnodo;

public class Funcion extends ASTnodo {

    protected TipoClass tipo;
    protected String nombre;
    protected List<ParTipoIden> lista_args;
    protected List<Ins> lista_ins;
    
    public Funcion(TipoClass tipo, String nombre, List<ParTipoIden> lista_args, List<Ins> lista_ins) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.lista_args = lista_args;
        this.lista_ins = lista_ins;
    }

    public String toString(){
        String listains = "\n    ";
        for(Ins i : lista_ins){
            if (i != null)
                listains = listains + i.toString() + "\n    ";
        }
        return "\n  " + tipo + " " + nombre + "(" + lista_args + ") "+ listains;
    }

    public void vincular(){
        Programa.pila.abreBloque();
    }

    
}
