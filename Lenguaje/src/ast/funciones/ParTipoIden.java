package ast.funciones;

import ast.tipos.TipoBasicoClass;
import ast.tipos.TipoClass;
import ast.instrucciones.*;

public class ParTipoIden extends DecClass{

    public ParTipoIden(TipoClass tipo, String iden) {
        super(tipo,iden,null);
    }

    public TipoClass getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoClass tipo) {
        this.tipo = tipo;
    }

    public String getIden() {
        return this.iden;
    }

    public void setIden(String iden) {
        this.iden = iden;
    }

    public String toString(){
        return tipo.toString() + iden;
    }
    
}
