package Listas;

class NodoCircularDoble<T> {
    T dato;
    NodoCircularDoble<T> siguiente;
    NodoCircularDoble<T> anterior;

    public NodoCircularDoble(T dato) {
        this.dato = dato;
        this.siguiente = this.anterior = null;
    }
}
