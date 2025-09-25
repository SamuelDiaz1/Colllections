package Listas;

class NodoCircular<T> {
    T dato;
    NodoCircular<T> siguiente;

    public NodoCircular(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
