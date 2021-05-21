package ast.funciones;

import ast.tipos.*;
import java.util.*;
import ast.instrucciones.*;
import ast.ASTnodo;
import ast.Programa;

public class Funcion extends ASTnodo {
    protected String nombre;
    protected List<ParTipoIden> lista_args;
    protected List<Ins> lista_ins;

    public Funcion(TipoClass tipo, String nombre, List<ParTipoIden> lista_args, List<Ins> lista_ins) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.lista_args = lista_args;
        this.lista_ins = lista_ins;
    }

    public void generaCodigo(){}
    public void calculos(){}

    public String getNombre(){
        return nombre;
    }
    
    public List<ParTipoIden> getListaArgs(){
        return lista_args;
    }

    public void chequea() {
        this.tipo.chequea();

        for (ParTipoIden arg : lista_args) {
            arg.chequea();
        }

        for (Ins instruccion : lista_ins) {
            instruccion.chequea();
        }
    }

    public void vincular() {
        ASTnodo nodo = Programa.pila.buscaId(nombre);
        if (nodo == null) {
            Programa.pila.insertaId(nombre, this);
            Programa.pila.abreBloque();

            for (ParTipoIden arg : lista_args) {
                arg.vincular();
            }

            // si es void no hace falta
            for (Ins instruccion : lista_ins) {
                instruccion.vincular();
                // Vincular el return
                if (! (instruccion instanceof AsigClass || instruccion instanceof DecClass || 
                    instruccion instanceof FuncallClass)){
                        instruccion.setReturn(this);
                    }
            }

            Programa.pila.cierraBloque();
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }

    }

    public String toString() {
        String listains = "\n    ";
        for (Ins i : lista_ins) {
            if (i != null)
                listains = listains + i.toString() + "\n    ";
        }
        return "\n  " + tipo + " " + nombre + "(" + lista_args + ") " + listains;
    }

}
