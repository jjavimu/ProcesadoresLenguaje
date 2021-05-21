package ast.accesos;

import ast.tipos.*;
import ast.Programa;

public class AccesoPuntero extends Acceso{
    protected Acceso direccion;

    public AccesoPuntero(Acceso direccion) {
        this.direccion = direccion;
    }

    public void generaCodigo(){
        direccion.generaCodigo();
        Programa.escribir.println("i32.load");           
    }

    public void chequea(){
        direccion.chequea();
        //direccion.tipo; algo * ese algo es getTipoDelPuntero
        if(direccion.tipo instanceof TipoPunteroClass  && direccion.tipo.comparar(new TipoPunteroClass(((TipoPunteroClass)direccion.tipo).getTipoDelPuntero()))){
            this.tipo = ((TipoPunteroClass)direccion.tipo).getTipoDelPuntero();
        } 
        else{
            System.out.println("Error tipos: Acceso Puntero ");
            Programa.okTipos = false;
        }
    }

    public void vincular(){
        direccion.vincular();
        this.nodoVinculo = direccion.nodoVinculo;
    }
    
    public String toString(){
        return "ExpAccPtr(*" + direccion +")";
    }
}
