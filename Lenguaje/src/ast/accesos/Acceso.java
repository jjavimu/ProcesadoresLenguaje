package ast.accesos;

import ast.expresiones.*;

public abstract class Acceso extends Expresion {
    
    public Acceso(){}

    public abstract void vincular();
    public abstract void chequea();
    public void calculos(){}
    public abstract void generaCodigo();
}
