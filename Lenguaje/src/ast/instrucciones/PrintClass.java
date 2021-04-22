package ast.instrucciones;

public class PrintClass extends Ins {
    protected Expresion exp;
    
    public PrintClass(Expresion exp){
        this.exp = exp;
    }
}
