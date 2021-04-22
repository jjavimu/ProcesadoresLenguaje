package ast;

import java.util.*;

import ast.estructuras.*;
import ast.funciones.*;

public class ListaDefiniciones {

    private List<StructClass> lista_struct;
    private List<EnumClass> lista_enum;
    private List<Funcion> lista_funcion;
    
    public ListaDefiniciones(){
        lista_struct = new ArrayList<StructClass>();
        lista_enum = new ArrayList<EnumClass>();
        lista_funcion = new ArrayList<Funcion>();
    }
    
    public void addStruct(StructClass s){
        lista_struct.add(s);
    }
    
    public void addEnum(EnumClass e){
        lista_enum.add(e);
    }
    

    public void addFuncion(Funcion f){
        lista_funcion.add(f);
    }
    
    public String toString() {
        return "Enumerados: " + lista_enum.toString() + "\nStruct: " + lista_struct.toString() +"\nFunciones: "  + lista_funcion.toString();
    }
}
