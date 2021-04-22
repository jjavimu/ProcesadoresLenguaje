package ast.expresiones;

public class OpCambioSigno extends ExpresionUnaria {

    public OpCambioSigno(Expresion exp){
        super(exp);
    }

    public String toString(){
        return "-"+exp.toString();
    }
    
}
