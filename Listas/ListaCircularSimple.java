package Listas;

class ListaCircularSimple<T extends Comparable<T>> {
    private NodoCircular<T> cabeza;  // primer nodo
    private NodoCircular<T> cola;    // último nodo (para facilitar inserciones al final)
    private int size;

    public ListaCircularSimple() {
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
     * Agregar al inicio.
     * El nuevo nodo apunta a la cabeza actual.
     * La cola siempre apunta a la nueva cabeza (cierre circular).
     */
    public void agregarInicio(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (estaVacia()) {
            cabeza = cola = nuevo;
            cola.siguiente = cabeza; // circularidad
        } else {
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            cola.siguiente = cabeza; // mantener circularidad
        }
        size++;
    }

    /**
     * Agregar al final.
     * La cola apunta al nuevo nodo y el nuevo apunta a cabeza.
     */
    public void agregarFinal(T dato) {
        NodoCircular<T> nuevo = new NodoCircular<>(dato);
        if (estaVacia()) {
            cabeza = cola = nuevo;
            cola.siguiente = cabeza;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
            cola.siguiente = cabeza; // mantener circularidad
        }
        size++;
    }



    /**
     * Eliminar primero.
     * La cabeza se mueve al siguiente nodo.
     * La cola debe volver a apuntar a la nueva cabeza.
     */
    public void eliminarPrimero() {
        if (estaVacia()) return;
        if (cabeza == cola) { // un solo nodo
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cola.siguiente = cabeza;
        }
        size--;
    }

    /**
     * Eliminar último.
     * Recorremos hasta el penúltimo y lo enlazamos con cabeza.
     */
    public void eliminarUltimo() {
        if (estaVacia()) return;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            NodoCircular<T> aux = cabeza;
            while (aux.siguiente != cola) { // llegar al penúltimo
                aux = aux.siguiente;
            }
            aux.siguiente = cabeza;
            cola = aux;
        }
        size--;
    }


    /**
     * Imprimir la lista una vuelta (size elementos).
     */
    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircular<T> aux = cabeza;
        for (int i = 0; i < size; i++) {
            System.out.print(aux.dato + " -> ");
            aux = aux.siguiente;
        }
        System.out.println("(circular a cabeza)");
    }

    /**
     * Buscar un valor en la lista.
     * Se recorre máximo "size" veces para evitar ciclo infinito.
     */
    public boolean contiene(T valor) {
        if (estaVacia()) return false;
        NodoCircular<T> aux = cabeza;
        for (int i = 0; i < size; i++) {
            if (aux.dato.equals(valor)) return true;
            aux = aux.siguiente;
        }
        return false;
    }
}

