package ast.expresiones;

public class OpResta extends ExpresionBinaria {

    public OpResta(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }
    
    public String toString(){
        return "ExpBin(" + opizq + "-" + opdcha + ")";
    }
}
