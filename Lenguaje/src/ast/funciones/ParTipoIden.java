package ast.funciones;

import ast.tipos.TipoBasicoClass;
import ast.tipos.TipoClass;

public class ParTipoIden {
    private TipoClass tipo;
    private String iden;

    public ParTipoIden(TipoClass tipo, String iden) {
        this.tipo = tipo;
        this.iden = iden;
    }

    public String toString(){
        return tipo.toString() + iden;
    }
    
}
