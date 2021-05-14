package ast.instrucciones;

import ast.expresiones.Expresion;

public class ReturnClass extends Ins {
    protected Expresion valorRetorno;

    public ReturnClass(Expresion exp) {
        this.valorRetorno = exp;
    }

    public ReturnClass() {
        this.valorRetorno = null;
    }

    public void chequea(){
        if (valorRetorno != null) {
            valorRetorno.chequea();
            //if(!this.tipo.comparar(valorRetorno))
            // vinculo entre Return y valor de la funcion
        }
    }

    public void vincular() {
        if (valorRetorno != null) {
            valorRetorno.vincular();
        }
    }

    public String toString() {
        return "return(" + valorRetorno + ")";
    }
}
