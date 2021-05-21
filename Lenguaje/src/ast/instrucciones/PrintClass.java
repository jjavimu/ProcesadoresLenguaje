package ast.instrucciones;

import ast.expresiones.Expresion;
import ast.ASTnodo;
import ast.Programa;
import ast.accesos.*;


public class PrintClass extends Ins {
    protected Expresion exp;
    
    public PrintClass(Expresion exp){
        this.exp = exp;
    }

    public void calculos(){}

    public void generaCodigo(){
        exp.generaCodigo();
        if(exp instanceof Acceso){
            Programa.escribir.println("i32.load");  // devuelve direccion
        }
        Programa.escribir.println("call $print");
    }

    public void chequea(){
        exp.chequea();
    }

    public void vincular(){
        exp.vincular();
    }


    public void setReturn(ASTnodo nodo) {
    }


    public String toString(){
        return "Print (" + exp.toString() + ")";
    }
}
