package ast.funciones;

import ast.tipos.*;
import java.util.*;
import ast.instrucciones.*;

public class Fmain extends Funcion {

    public Fmain(String nombre, List<Ins> ins){
        // El nombre sobra
        super(new TipoBasicoClass("void"), nombre, new ArrayList<ParTipoIden>(), ins);
    }
    
}