package ast.accesos;

import ast.expresiones.Expresion;
import ast.tipos.*;
import ast.Programa;

public class AccesoArray extends Acceso {
    protected Acceso acceso;
    protected Expresion exp;
    protected TipoClass tipo_acceso;

    public AccesoArray(Acceso acceso, Expresion exp) {
        this.exp = exp;
        this.acceso = acceso;
    }

    public void generaCodigo() {
        int tam_elem = (((TipoArrayClass) this.nodoVinculo.tipo).getTamElem(1)) * 4;
        Programa.escribir.println("i32.const " + tam_elem); // tam un elemento
        exp.generaCodigo(); // indice
        if (exp instanceof Acceso) {
            Programa.escribir.println("i32.load");
        }
        Programa.escribir.println("i32.mul");
        if (acceso instanceof AccesoArray) {
            acceso.generaCodigo_aux(2); // direccion inicio vector
        } else
            acceso.generaCodigo();
        Programa.escribir.println("i32.add");
    }

    public void generaCodigo_aux(int i) {
        int tam_elem = (((TipoArrayClass) this.nodoVinculo.tipo).getTamElem(i)) * 4;
        Programa.escribir.println("i32.const " + tam_elem); // tam un elemento
        exp.generaCodigo(); // indice
        if (exp instanceof Acceso) {
            Programa.escribir.println("i32.load");
        }
        Programa.escribir.println("i32.mul");
        if (acceso instanceof AccesoArray) {
            acceso.generaCodigo_aux(i+1); // direccion inicio vector
        } else
            acceso.generaCodigo();
        Programa.escribir.println("i32.add");
    }

    public void chequea() {
        acceso.chequea();
        exp.chequea();

        if (acceso.tipo == null || exp.tipo == null) {
            this.tipo = null;
        } else if (acceso.tipo instanceof TipoArrayClass
                && acceso.tipo.comparar(new TipoArrayClass(((TipoArrayClass) acceso.tipo).getTipoDelArray(), null))) {
            if (exp.tipo.comparar(new TipoBasicoClass("int"))) {
                this.tipo = ((TipoArrayClass) acceso.tipo).getTipoDelArray();
            } else {
                System.out.println("Error tipos: Array ");
                Programa.okTipos = false;
            }
        } else {
            System.out.println("Error tipos: Array ");
            Programa.okTipos = false;
        }
    }

    public void vincular() {
        acceso.vincular();
        this.nodoVinculo = acceso.nodoVinculo;
        exp.vincular();
    }

    public String toString() {
        return "ExpAccArr(" + acceso + "[" + exp + "])";
    }

}
