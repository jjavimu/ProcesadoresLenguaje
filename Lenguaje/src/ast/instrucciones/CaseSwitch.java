package ast.instrucciones;

import ast.expresiones.*;

public class CaseSwitch{

    protected Expresion caso;
    protected List<Ins> instrucciones;

    public CaseSwitch(Expresion condicion, List<Ins> instrucciones){
        this.caso = condicion;
        this.instrucciones = instrucciones;
    }
    
    public CaseSwitch(List<Ins> instrucciones){
        this.caso = NULL;
        this.instrucciones = instrucciones;
    }
}