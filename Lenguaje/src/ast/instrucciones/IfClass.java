package ast.instrucciones;

public class IfClass extends Ins {

    protected Expresion condicion;
    protected List<Ins> instrucciones_then;
    protected List<Ins> instrucciones_else;

    public IfClass(Expresion exp, List<Ins> instrucciones_then){
        this.condicion = exp;
        this.instrucciones_then = instrucciones_then;
    }
    public IfClass(Expresion exp, List<Ins> instrucciones_then,List<Ins> instrucciones_else){
        this.condicion = exp;
        this.instrucciones_then = instrucciones_then;
        this.instrucciones_else = instrucciones_else;
    }
    
}
