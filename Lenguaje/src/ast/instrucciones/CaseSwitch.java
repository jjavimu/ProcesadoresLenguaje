package ast.instrucciones;

import java.util.*;

import ast.expresiones.*;

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

    public String toString(){
        if(caso == null)
            return "default: " + instrucciones.toString();
        else return "case " + caso.toString() + ": " + instrucciones.toString();
    }
}