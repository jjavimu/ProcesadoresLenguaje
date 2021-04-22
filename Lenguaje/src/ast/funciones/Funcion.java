package ast.funciones;

import ast.tipos.*;
import java.util.*;
import ast.instrucciones.*;

public class Funcion {

    private TipoBasicoClass tipo;
    private String nombre;
    private List<ParTipoIden> lista_args;
    private List<Ins> lista_ins;
    
    public Funcion(TipoBasicoClass tipo, String nombre, List<ParTipoIden> lista_args, List<Ins> lista_ins) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.lista_args = lista_args;
        this.lista_ins = lista_ins;
    }


    
}
