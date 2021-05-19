package ast.tipos;

import ast.ASTnodo;
import java.util.*;
import ast.instrucciones.*;
import ast.Programa;
import ast.estructuras.*;

public class TipoEstructuraClass extends TipoClass {
    // nombre struct/enumerado
    private String nombre_tipo;
    private ASTnodo susCampos;
    private boolean se; // 1 si es struct y 0 si es enum

    public TipoEstructuraClass(String tipo) {
        this.nombre_tipo = tipo;
    }

    public boolean comparar(TipoClass otro){        
        if(!(otro instanceof TipoEstructuraClass)){
            if(!((otro instanceof TipoBasicoClass) && otro.toString().compareTo(nombre_tipo)==0)){
               return false;
            }
            else if (!(otro instanceof TipoBasicoClass)) {
                return false;
            }
            else{
                return true;
            }
        }
        //ya es estructura
        else if(this.se != ((TipoEstructuraClass) otro).getEnumStruct()){
            return false;
        }
        else if(this.nombre_tipo.compareTo(((TipoEstructuraClass)otro).getNombre())==1){
            return false;
        }
        else return true;
    }

    public List<DecClass> getSusCampos() {
        return ((StructClass) susCampos).getDeclaraciones();
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

    public boolean getEnumStruct() {
        return se;
    }

    public String getNombre() {
        return nombre_tipo;
    }

    public String toString() {
        return nombre_tipo;
    }

}
