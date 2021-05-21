package ast.instrucciones;

import ast.expresiones.Expresion;
import ast.ASTnodo;
import ast.Programa;
import ast.tipos.*;
import ast.accesos.*;

public class ReturnClass extends Ins {
    protected Expresion valorRetorno;

    public ReturnClass(Expresion exp) {
        this.valorRetorno = exp;
    }

    public ReturnClass() {
        this.valorRetorno = null;
    }

    public void calculos() {
    }

    public void generaCodigo() {
        if (valorRetorno != null) {
            valorRetorno.generaCodigo();
            if (valorRetorno instanceof Acceso) {
                Programa.escribir.println("i32.load");
            }
        }
    }

    public void chequea() {
        if (valorRetorno != null) {
            valorRetorno.chequea();
            if (!this.nodoVinculo.tipo.comparar(valorRetorno.tipo)) {
                System.out.println("Error tipo: return no es el de la funcion");
                Programa.okTipos = false;
            }
        } else {
            if (!this.nodoVinculo.tipo.comparar(new TipoBasicoClass("void"))) {
                System.out.println("Error tipo: return no es el de la funcion");
                Programa.okTipos = false;
            }
        }

    }

    public void vincular() {
        if (valorRetorno != null) {
            valorRetorno.vincular();
        }
    }

    public void setReturn(ASTnodo funcion) {
        this.nodoVinculo = funcion;
    }

    public String toString() {
        return "return(" + valorRetorno + ")";
    }
}
