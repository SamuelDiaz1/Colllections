package Listas;

import java.util.Iterator;
import java.util.NoSuchElementException;

class ListaDoblementeEnlazada<T extends Comparable<T>> implements Iterable<T> {
    private NodoDoble<T> cabeza;  // primer nodo
    private NodoDoble<T> cola;    // último nodo
    private int size;             // cantidad de elementos (optimización)

    public ListaDoblementeEnlazada() {
        cabeza = null;
        cola = null;
        size = 0;
    }


    public boolean estaVacia() {
        return size == 0;
    }

    public int tamaño() {
        return size;
    }


    /**
     * Agrega un nodo al inicio.
     * O(1)
     */
    public void agregarInicio(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            cabeza = cola = nuevo;
        } else {
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
            cabeza = nuevo;
        }
        size++;
    }

    /**
     * Agrega un nodo al final.
     * O(1) gracias a referencia a cola.
     */
    public void agregarFinal(T dato) {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);
        if (estaVacia()) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
        size++;
    }

    /**
     * Agrega en una posición específica (0..size).
     * O(n) en el peor caso (recorrer hasta la posición).
     */
    public void agregar(int indice, T dato) {
        if (indice < 0 || indice > size) return;

        if (indice == 0) {
            agregarInicio(dato);
        } else if (indice == size) {
            agregarFinal(dato);
        } else {
            NodoDoble<T> nuevo = new NodoDoble<>(dato);
            NodoDoble<T> aux = obtenerNodo(indice);
            NodoDoble<T> anterior = aux.anterior;

            // enlazar nuevo entre "anterior" y "aux"
            nuevo.anterior = anterior;
            nuevo.siguiente = aux;
            anterior.siguiente = nuevo;
            aux.anterior = nuevo;

            size++;
        }
    }


    /**
     * Devuelve el nodo en un índice (o null si fuera de rango).
     * O(n) — pero se puede optimizar recorriendo desde cola si indice > size/2.
     */
    private NodoDoble<T> obtenerNodo(int indice) {
        if (indice < 0 || indice >= size) return null;

        NodoDoble<T> aux;
        if (indice < size / 2) { // recorrer desde cabeza
            aux = cabeza;
            for (int i = 0; i < indice; i++) aux = aux.siguiente;
        } else { // recorrer desde cola
            aux = cola;
            for (int i = size - 1; i > indice; i--) aux = aux.anterior;
        }
        return aux;
    }

    public T obtenerValorNodo(int indice) {
        NodoDoble<T> nodo = obtenerNodo(indice);
        return nodo != null ? nodo.dato : null;
    }


    /**
     * Elimina el primer nodo.
     * O(1)
     */
    public void eliminarPrimero() {
        if (estaVacia()) return;

        if (cabeza == cola) { // solo un nodo
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = null;
        }
        size--;
    }

    /**
     * Elimina el último nodo.
     * O(1)
     */
    public void eliminarUltimo() {
        if (estaVacia()) return;

        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = null;
        }
        size--;
    }

    /**
     * Elimina un nodo con valor dado (primera coincidencia).
     * O(n) — busca hasta encontrarlo.
     */
    public void eliminar(T valor) {
        if (estaVacia()) return;

        NodoDoble<T> aux = cabeza;
        while (aux != null && !aux.dato.equals(valor)) {
            aux = aux.siguiente;
        }

        if (aux == null) return; // no encontrado

        if (aux == cabeza) {
            eliminarPrimero();
        } else if (aux == cola) {
            eliminarUltimo();
        } else {
            aux.anterior.siguiente = aux.siguiente;
            aux.siguiente.anterior = aux.anterior;
            size--;
        }
    }


    /**
     * Imprime la lista hacia adelante.
     */
    public void imprimirAdelante() {
        NodoDoble<T> aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " <-> ");
            aux = aux.siguiente;
        }
        System.out.println("null");
    }

    /**
     * Imprime la lista hacia atrás (usando cola).
     */
    public void imprimirAtras() {
        NodoDoble<T> aux = cola;
        while (aux != null) {
            System.out.print(aux.dato + " <-> ");
            aux = aux.anterior;
        }
        System.out.println("null");
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            NodoDoble<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (actual == null) throw new NoSuchElementException();
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }
}
