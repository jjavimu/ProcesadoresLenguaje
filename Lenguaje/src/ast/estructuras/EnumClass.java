package ast.estructuras;

import java.util.*;

import ast.ASTnodo;
import ast.Programa;
import ast.expresiones.*;
import ast.tipos.TipoBasicoClass;

public class EnumClass extends ASTnodo {
    private String nombre;
    private List<Constante> valores;

    public EnumClass(String nombre, List<String> valores) {
        this.nombre = nombre;
        this.valores = new ArrayList<Constante>();
        for (String s : valores) {
            this.valores.add(new Constante(s, new TipoBasicoClass(nombre)));
        }
        Programa.tipos_enum.add(this);
    }

    // GENERAR CODIGO -----------------------------------------------------------------
    public void generaCodigo(){}
    public void calculos(){}

    // CHEQUEAR TIPOS -----------------------------------------------------------------
    public void chequea(){
        // No hay que chequear nada porque es un tipo en si mismo
    }

    // VINCULAR -----------------------------------------------------------------
    public void vincular() {
        ASTnodo nodo = Programa.pila.buscaId(nombre);
        if (nodo == null) { // devuelve null cuando no esta
            Programa.pila.insertaId(nombre, this);
            for (Constante c : valores) {
                Programa.pila.insertaId(c.getValor(), c);
            }
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre);
            Programa.okVinculacion = false;
        }
    }

    // AST TOSTRING -----------------------------------------------------------------
    public String toString() {
        return "\nNombreEnum: " + nombre + valores + "\n";
    }

    // AUXILIARES -----------------------------------------------------------------
    public String getNombre(){
        return nombre;
    }
}
