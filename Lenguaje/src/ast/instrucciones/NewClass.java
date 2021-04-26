package ast.instrucciones;

public class NewClass {
    private TipoClass tipo;
    private Acceso acceso;

    public NewClass(Acceso nombre, TipoClass tipo){
        this.acceso = nombre;
        this.tipo = tipo; 
    }

    public String toString(){
        return acceso.toString() + "= new" +tipo.toString()+ ";\n";
    }
}
