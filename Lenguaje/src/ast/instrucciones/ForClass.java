package ast.instrucciones;

import ast.expresiones.*;
import java.util.*;

public class ForClass extends Ins {
    private DecClass dec;
    private Expresion expCond;
    private AsigClass asig;
    private List<Ins> instrucciones;
    
    public ForClass(DecClass dec, Expresion expCond, AsigClass asig, List<Ins>ins){
        this.dec = dec;
        this.expCond = expCond;
        this.asig = asig;
        this.instrucciones = ins;
    }


    public String toString(){
        String inst = "";
        for(Ins i : instrucciones){
            inst = inst + i + "\n";
        }

        return "for (" + dec + ";" + expCond + ";" + asig + "Instrucciones:\n" + inst + ")";
    }
    
}
