package ast.instrucciones;

public class ReturnClass extends Ins {
    protected Expresion valorRetorno;

    public ReturnClass(Expresion exp){
        this.valorRetorno = exp;
    }

    public ReturnClass(){
        this.valorRetorno = NULL;
    }
}
