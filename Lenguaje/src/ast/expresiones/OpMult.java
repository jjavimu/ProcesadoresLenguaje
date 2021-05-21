package ast.expresiones;

import ast.Programa;
import ast.tipos.*;
import ast.accesos.*;

public class OpMult extends ExpresionBinaria {

    public OpMult(Expresion opizq, Expresion opdcha) {
        super(opizq, opdcha);
    }

    public void generaCodigo() {
        opizq.generaCodigo();
        if (opizq instanceof Acceso)
            Programa.escribir.println("i32.load"); // devuelve direccion

        opdcha.generaCodigo();
        if (opdcha instanceof Acceso)
            Programa.escribir.println("i32.load"); // devuelve direccion

        Programa.escribir.println("i32.mul");
    }

    public void chequea() {
        opizq.chequea();
        opdcha.chequea();

        if (opizq.tipo == null || opdcha.tipo == null) {
            System.out.println("Error tipo: mult alguno null");
            Programa.okTipos = false;
        }

        else if (opizq.tipo.comparar(new TipoBasicoClass("int")) && opdcha.tipo.comparar(new TipoBasicoClass("int"))) {
            this.tipo = new TipoBasicoClass("int");
        } else if (opizq.tipo.comparar(new TipoBasicoClass("float"))
                && opdcha.tipo.comparar(new TipoBasicoClass("float"))) {
            this.tipo = new TipoBasicoClass("float");
        } else {
            Programa.okTipos = false;
            System.out.println("Error tipo: mult no comparables");
        }

    }

    public String toString() {
        return "ExpBin(" + opizq + "*" + opdcha + ")";
    }

}
