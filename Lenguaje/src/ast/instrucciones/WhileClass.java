package ast.instrucciones;

public class WhileClass extends Ins {   
    protected Expresion condicion;
    protected List<Ins> instrucciones;
    
    public WhileClass(Expresion exp, List<Ins> instrucciones){
        this.condicion = exp;
        this.instrucciones = instrucciones;
    }
    
}
