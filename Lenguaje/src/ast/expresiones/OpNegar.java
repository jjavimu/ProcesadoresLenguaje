package ast.expresiones;

public class OpNegar extends ExpresionUnaria {

    public OpNegar(Expresion exp){
        super(exp);
    }

    public String toString(){
        return "!"  + exp.toString();
    }
    
}
