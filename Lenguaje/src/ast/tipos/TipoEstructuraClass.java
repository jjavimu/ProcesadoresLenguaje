package ast.tipos;

import ast.ASTnodo;
import java.util.*;
import ast.instrucciones.*;
import ast.Programa;
import ast.estructuras.*;

public class TipoEstructuraClass extends TipoClass {

    private String nombre_tipo; // nombre struct/enumerado
    private ASTnodo susCampos; // Campos del struct/enumerado
    private boolean se; // 1 si es struct y 0 si es enum

    public TipoEstructuraClass(String tipo) {
        this.nombre_tipo = tipo;
    }

    public void chequea() {
        boolean ok = false;
        for (EnumClass nodo : Programa.tipos_enum) {
            if (nombre_tipo.compareTo(nodo.getNombre()) == 0) {
                susCampos = nodo;
                ok = true;
                se = false;
            }
        }

        for (StructClass nodo : Programa.tipos_struct) {
            if (nombre_tipo.compareTo(nodo.getNombre()) == 0) { // ==0 es true
                susCampos = nodo;
                ok = true;
                se = true;
            }
        }
        if (!ok) {
            System.out.println("Error tipos: el tipo " + nombre_tipo + " definido por usuario no existe");
            Programa.okTipos = false;

        }
    }

    public boolean comparar(TipoClass otro) {
        if (!(otro instanceof TipoEstructuraClass)) {
            if (!((otro instanceof TipoBasicoClass) && otro.toString().compareTo(nombre_tipo) == 0)) {
                return false;
            } else if (!(otro instanceof TipoBasicoClass)) {
                return false;
            } else {
                return true;
            }
        }

        // ya es estructura
        else if (this.se != ((TipoEstructuraClass) otro).getEnumStruct()) {
            return false; // uno enum y otro struct
        } else if (this.nombre_tipo.compareTo(((TipoEstructuraClass) otro).getNombre()) == 1) {
            if (this.se) { // si es struct
                List<DecClass> dec_otro = ((TipoEstructuraClass) otro).getSusCampos();
                List<DecClass> dec_yo = ((StructClass) susCampos).getDeclaraciones();
                if (dec_otro.size() != dec_yo.size())
                    return false;
                else {
                    for (int i = 0; i < dec_otro.size(); ++i) {
                        if (!dec_otro.get(i).tipo.comparar(dec_yo.get(i).tipo)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            else
                return false;
        } else
            return true; // si tienen igual nombre son iguales
    }

    // FUNCIONES GET/SET

    public List<DecClass> getSusCampos() {
        return ((StructClass) susCampos).getDeclaraciones();
    }

    public boolean getEnumStruct() {
        return se;
    }
    
    public int getTam(){
        // no nos da tiempo :(
        return 0;
    }

    public String getNombre() {
        return nombre_tipo;
    }

    public String toString() {
        return nombre_tipo;
    }

}
