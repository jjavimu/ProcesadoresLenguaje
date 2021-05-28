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

    // GENERAR CODIGO -----------------------------------------------------------------
    public void calculos(){}

    public void generaCodigo(){
        exp.generaCodigo();
        if(exp instanceof Acceso){
            Programa.escribir.println("i32.load");  // devuelve direccion
        }
        Programa.escribir.println("call $print");
    }

    // CHEQUEAR TIPOS -----------------------------------------------------------------
    public void chequea(){
        exp.chequea();
    }

    // VINCULACION -----------------------------------------------------------------
    public void vincular(){
        exp.vincular();
    }


    public void setReturn(ASTnodo nodo) {
    }

    // AST TOSTRING -----------------------------------------------------------------
    public String toString(){
        return "Print (" + exp.toString() + ")";
    }
}
