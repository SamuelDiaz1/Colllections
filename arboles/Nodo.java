package arboles;

public class Nodo {
    int dato;            // Valor almacenado en el nodo
    Nodo izquierdo;      // Hijo izquierdo
    Nodo derecho;        // Hijo derecho

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

