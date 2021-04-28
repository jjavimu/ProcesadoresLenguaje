package ast.expresiones;

public class OpModulo extends ExpresionBinaria {

    public OpModulo(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public String toString(){
        return "ExpBin(" + opizq + "%" + opdcha + ")";
    }
    
}
