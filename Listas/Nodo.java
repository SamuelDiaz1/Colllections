package Listas;


/**
 * Nodo de una lista enlazada simple genérica.
 * - campo 'dato' guarda la información.
 * - campo 'siguiente' apunta al siguiente nodo (o null si es el último).
 */
class Nodo<T> {
    T dato;                 // El valor que contiene el nodo
    Nodo<T> siguiente;      // Referencia al siguiente nodo en la lista

    public Nodo(T dato) {
        this.dato = dato;
        this.siguiente = null; // al crear el nodo no hay siguiente aún
    }
}


