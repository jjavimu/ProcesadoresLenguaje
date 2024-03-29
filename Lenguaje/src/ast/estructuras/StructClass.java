package ast.estructuras;

import java.util.*;
import ast.instrucciones.DecClass;
import ast.tipos.*;
import ast.ASTnodo;
import ast.Programa;

public class StructClass extends ASTnodo {

    private String nombre;
    private List<DecClass> valores;


    public StructClass(String nombre, List<DecClass> valores) {
        this.nombre = nombre;
        this.valores = valores;
        Programa.tipos_struct.add(this);
    }

    // GENERAR CODIGO -----------------------------------------------------------------
    public void generaCodigo(){}
    public void calculos(){
        Programa.etiquetas.push(0);
        for(DecClass dec:valores){
            dec.calculos();
        }
        Programa.etiquetas.pop();
    }

    // CHEQUEAR TIPOS  -----------------------------------------------------------------
    public void chequea(){
        for(DecClass dec:valores){
            dec.chequea();
        }
    }

    // VINCULAR -----------------------------------------------------------------
    public void vincular() {
        ASTnodo nodo = Programa.pila.buscaId(nombre);
        if (nodo == null) { //devuelve null cuando no esta
            Programa.pila.insertaId(nombre, this);
        } else {
            System.out.println("Error vinculacion: Este identificador ya esta usado: " + nombre );
            Programa.okVinculacion = false;
        }
    }

    // TOSTRING -----------------------------------------------------------------
    public String toString() {
        return "\nNombreStruct: " + nombre + valores + "\n";
    }

    // AUXILIARES -----------------------------------------------------------------
    public List<DecClass> getDeclaraciones(){
        return this.valores;
    }

    public String getNombre(){
        return nombre;
    }
}
