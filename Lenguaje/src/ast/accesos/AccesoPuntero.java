package ast.accesos;

public class AccesoPuntero extends Acceso{
    protected Acceso direccion;

    public AccesoPuntero(Acceso direccion) {
        this.direccion = direccion;
    }

    public void vincular(){
        direccion.vincular();
    }
    
    public String toString(){
        return "ExpAccPtr(*" + direccion +")";
    }
}
