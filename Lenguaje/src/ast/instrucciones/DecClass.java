package ast.instrucciones;

import ast.tipos.*;
import ast.accesos.Acceso;
import ast.expresiones.*;
import ast.ASTnodo;
import ast.Programa;

public class DecClass extends Ins {

    // protected TipoClass tipo;
    protected String nombre;
    protected Expresion exp;

    public DecClass(TipoClass tipo, String nombre, Expresion exp) { // No inicializado
        this.tipo = tipo;
        this.nombre = nombre;
        this.exp = exp;
    }

    // GENERACION CODIGO -----------------------------------------------------------------
    public void calculos() {
        this.etiqueta = Programa.etiquetas.peek();
        int e = Programa.etiquetas.pop();
        int tam_tipo = tipo.getTam();
        e = e + tam_tipo;
        Programa.etiquetas.push(e);
        System.out.println("Etiqueta: " + etiqueta);
    }

    public int maxMemoria() {
        return tipo.getTam()*4; // (sizeof int = 4) arrays de enteros y enteros
    }

    public void generaCodigo() {
        if (exp != null) {
            Programa.escribir.println("i32.const " + etiqueta);
            Programa.escribir.println("i32.const 4");
            Programa.escribir.println("i32.mul");
            Programa.escribir.println("get_local $localsStart");
            Programa.escribir.println("i32.add");

            exp.generaCodigo();
            if (exp instanceof Acceso) {
                Programa.escribir.println("i32.load"); // devuelve direccion
            }

            Programa.escribir.println("i32.store"); // 1º arg, 2º arg, store
        }
    }

    // CHEQUEAR TIPO -----------------------------------------------------------------
    public void chequea() {
        // El tipo de la parte izquierda es this.tipo
        tipo.chequea();
        if (exp != null) {
            exp.chequea();

            if (!this.tipo.comparar(exp.tipo)) {
                System.out.println("Error tipo: Declaracion " + tipo + " " + nombre + "=" + exp + "(" + nombre + ","
                        + exp.tipo + ")");
                Programa.okTipos = false;
            }
        }
    }

    // VINCULACION -----------------------------------------------------------------
    public void vincular() {
        // Tenemos un buscaId particular para este caso
        // Va a permitir de declarar con un mismo identificador siempre y cuado no se
        // haya declarado uno con el
        // mismo nombre en ese bloque
        ASTnodo nodo = Programa.pila.buscaIdCima(nombre);
        if (nodo == null) { // devuelve null cuando no esta
            Programa.pila.insertaId(nombre, this);
            if (exp != null)
                exp.vincular();
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }
    }

    public void setReturn(ASTnodo nodo) {
    }

    // AST TOSTRING -----------------------------------------------------------------
    public String toString() {
        return "Declaracion(Tipo: " + tipo + ", nombre:" + nombre + ", exp: " + exp + ")";
    }

    // AUXILIARES -----------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }


}
