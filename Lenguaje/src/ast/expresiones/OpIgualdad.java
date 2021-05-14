package ast.expresiones;

public class OpIgualdad extends ExpresionBinaria {

    public OpIgualdad(Expresion opizq, Expresion opdcha){
        super(opizq, opdcha);
    }

    public void chequea(){
        opizq.chequea();
        opdcha.chequea();

        if(!opizq.tipo.comparar(opdcha.tipo)){ // Los dos lados de la expresion tiene que ser la misma
            System.out.println("Error tipo: Op " + opizq  "=="+ opdcha + "(" + opizq.tipo + "," + opdcha.tipo + ")"); 
        }    
    }

    public String toString(){
        return "ExpBin(" + opizq + "==" + opdcha + ")";
    }
    
}
