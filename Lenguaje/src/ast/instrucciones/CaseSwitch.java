package ast.instrucciones;

import java.util.*;

import ast.expresiones.*;
import ast.Programa;

public class CaseSwitch{

    protected Expresion caso;
    protected List<Ins> instrucciones;

    public CaseSwitch(Expresion condicion, List<Ins> instrucciones){
        this.caso = condicion;
        this.instrucciones = instrucciones;
    }
    
    public CaseSwitch(List<Ins> instrucciones){
        this.caso = null;
        this.instrucciones = instrucciones;
    }

    public TipoClass getTipo(){
        return caso.tipo;
    }

    public void chequea(){
        for(Ins instruccion : instrucciones){
            instruccion.chequea();
        }
    }

    public void vincular() {
        if (caso!=null) caso.vincular();

        Programa.pila.abreBloque();
        for (Ins instruccion : instrucciones) {
            instruccion.vincular();
        }
        Programa.pila.cierraBloque();
    }
    

    public String toString(){
        if(caso == null)
            return "default: " + instrucciones.toString();
        else return "case " + caso.toString() + ": " + instrucciones.toString();
    }
}