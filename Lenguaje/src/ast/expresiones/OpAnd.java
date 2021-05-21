package ast.expresiones;

import ast.Programa;
import ast.tipos.*;
import ast.accesos.*;

public class OpAnd extends ExpresionBinaria {

    public OpAnd(Expresion opizq, Expresion opdcha) {
        super(opizq, opdcha);
    }

    public void generaCodigo() {
        opizq.generaCodigo();
        if (opizq instanceof Acceso)
            Programa.escribir.println("i32.load"); // devuelve direccion

        opdcha.generaCodigo();
        if (opdcha instanceof Acceso)
            Programa.escribir.println("i32.load"); // devuelve direccion

        Programa.escribir.println("i32.and");
    }

    public void chequea() {
        opizq.chequea();
        opdcha.chequea();

        // if(opizq.tipo 'es igual a' opdcha.tipo && opizq.tipo 'es booleano')
        if (opizq.tipo == null || opdcha.tipo == null) {
            System.out.println("Error tipo: and alguno null");
            Programa.okTipos = false;
        } else if (opizq.tipo.comparar(new TipoBasicoClass("bool"))
                && opdcha.tipo.comparar(new TipoBasicoClass("bool"))) {
            this.tipo = new TipoBasicoClass("bool");
        } else {
            Programa.okTipos = false;
            System.out.println("Error tipo: and no comparables");
        }

    }

    public String toString() {
        return "ExpBin(" + opizq + "and" + opdcha + ")";
    }

}
