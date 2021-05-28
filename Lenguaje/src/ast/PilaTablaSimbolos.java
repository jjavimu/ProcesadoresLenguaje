package ast;

import java.util.Stack;
import java.util.HashMap;

public class PilaTablaSimbolos {

    // Pila con tabla de simbolos (nombreIden, ASTNodo)
    private Stack<HashMap<String, ASTnodo>> pila_tablas;

    public PilaTablaSimbolos(){
        inicializa();
    }
    
    // Comprueba si vacia
    public boolean empty(){
        return pila_tablas.empty() || pila_tablas.peek().isEmpty();
    }

    // Inicializa la pila
    public void inicializa(){
        //crea una pila de tablas vacía.
        pila_tablas = new Stack<HashMap<String, ASTnodo>>();

    }

    // Cada vez que entro en un nuevo ambito 
    public void abreBloque(){
        // que empieza un nuevo bloque apilando una nueva tabla vacía
        pila_tablas.push(new HashMap<String,ASTnodo>());
    }

    // Cada vez que salgo de un ambito 
    public void cierraBloque(){
        // que desapila la tabla de la cima.
        if (!pila_tablas.empty()){ 
            pila_tablas.pop(); 
        }
    }

    // Insertamos en la tabla de la cima de la pila un nuevo identificador
    public void insertaId (String id, ASTnodo puntero){
        // que inserta id con su referencia al AST en la tabla de la cima.
        if(!pila_tablas.empty()){
            HashMap<String,ASTnodo> cima = pila_tablas.peek();
            cima.put(id, puntero);
        }
    }

    // Buscamos el identificador en la pila
    public ASTnodo buscaId (String id){
        // busca la primera aparición de id en la pila de tablas empezando por la cima y devuelve su referencia.
        Stack<HashMap<String, ASTnodo>> pila_tablas_aux = new Stack<HashMap<String, ASTnodo>>();
        ASTnodo puntero = null;
        if(!pila_tablas.empty()){
            HashMap<String,ASTnodo> cima = pila_tablas.pop();
            puntero = cima.get(id);
            pila_tablas_aux.push(cima);
            while (puntero == null && !pila_tablas.empty()){
                cima = pila_tablas.pop();
                puntero = cima.get(id);
                pila_tablas_aux.push(cima);
            }

            //volver a guardar todo en la pila
            while(!pila_tablas_aux.empty()){
                pila_tablas.push(pila_tablas_aux.pop());
            }
        }
        return puntero;
    }

    // Buscamos el identificador solo en la tabla de la cima
    public ASTnodo buscaIdCima (String id){
        ASTnodo puntero = null;
        if(!pila_tablas.empty()){
            HashMap<String,ASTnodo> cima = pila_tablas.pop();
            puntero = cima.get(id);
            pila_tablas.push(cima);
        }
        return puntero;
    }
}

