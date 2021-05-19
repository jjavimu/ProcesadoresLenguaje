package ast.accesos;

import ast.tipos.*;
import ast.Programa;
import ast.instrucciones.*;
import java.util.*;

public class AccesoStruct extends Acceso {
    protected Acceso acceso;
    protected String campo; //aceso.campo

    public AccesoStruct(Acceso acceso, String campo) {
        this.campo = campo;
        this.acceso = acceso;
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
            System.out.println("Error tipos: Struct ");
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
