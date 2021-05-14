package ast.expresiones;

public class OpAnd extends ExpresionBinaria {

    public OpAnd(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public void chequea(){
        opizq.chequea();
        opdcha.chequea();

        //if(opizq.tipo 'es igual a' opdcha.tipo && opizq.tipo 'es booleano')
    }

    public String toString(){
        return "ExpBin(" + opizq + "and" + opdcha + ")";
    }
    
}
