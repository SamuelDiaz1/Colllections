package Listas;

/**
 * Nodo de una lista doblemente enlazada genérica.
 * - Guarda referencias tanto al siguiente como al anterior nodo.
 */
class NodoDoble<T> {
    T dato;
    NodoDoble<T> siguiente;
    NodoDoble<T> anterior;

    public NodoDoble(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }
}
