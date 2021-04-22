package ast.funciones;

import ast.tipos.*;
import java.util.*;
import ast.instrucciones.*;

public class Funcion {

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
        return tipo + " " + nombre + "(" + lista_args + "){\n" + " " + lista_ins + "}\n";
    }

    
}
