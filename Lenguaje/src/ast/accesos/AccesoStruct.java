package ast.accesos;

import ast.tipos.*;
import ast.Programa;
import ast.instrucciones.*;
import java.util.*;
import ast.estructuras.*;

public class AccesoStruct extends Acceso {
    protected Acceso acceso;
    protected String campo; // aceso.campo

    public AccesoStruct(Acceso acceso, String campo) {
        this.campo = campo;
        this.acceso = acceso;
    }

    public void generaCodigo(){
        acceso.generaCodigo(); 
        //i32.const etiqueta del campo
        int etiqueta_campo = 0;
        for(DecClass dec : ((TipoEstructuraClass) nodoVinculo.tipo).getSusCampos()){
            if(dec.getNombre().compareTo(campo) == 0){
                etiqueta_campo = dec.etiqueta*4; // *4 solo int 
                break;
            }
        }
        Programa.escribir.println("i32.const " + etiqueta_campo);
        Programa.escribir.println("i32.add");
        // i32.add
    }

    public void chequea(){
        acceso.chequea();
        if(acceso.tipo != null){
            if(acceso.tipo instanceof TipoEstructuraClass && (((TipoEstructuraClass)acceso.tipo).getEnumStruct())){
                List<DecClass> declaraciones = ((TipoEstructuraClass)acceso.tipo).getSusCampos();
                DecClass m = null;
                for (DecClass d : declaraciones) {
                    if (d.getNombre().compareTo(campo) == 0){
                        m = d;
                        break;
                    } 
                }
                if (m == null) {
                    System.out.println("Error tipos: miembro inexistente");
                    Programa.okTipos = false;
                 }
                else {
                    this.tipo = m.tipo;
                } 
            }
        }
        else{
            System.out.println("Error tipos: Acceso Struct ");
            Programa.okTipos = false;
        }
    }

    public void vincular(){
        acceso.vincular();
        this.nodoVinculo = acceso.nodoVinculo;
    }

    public String toString(){
        return "ExpAccStr(" + acceso+ "." + this.campo + ")";
    }

}
