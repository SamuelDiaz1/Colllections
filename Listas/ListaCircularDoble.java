package Listas;

class ListaCircularDoble<T extends Comparable<T>> {
    private NodoCircularDoble<T> cabeza; // primer nodo
    private NodoCircularDoble<T> cola;   // último nodo
    private int size;

    public ListaCircularDoble() {
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
     * Se ajustan punteros de cabeza, cola y circularidad.
     */
    public void agregarInicio(T dato) {
        NodoCircularDoble<T> nuevo = new NodoCircularDoble<>(dato);
        if (estaVacia()) {
            cabeza = cola = nuevo;
            cabeza.siguiente = cabeza.anterior = cabeza; // circularidad
        } else {
            nuevo.siguiente = cabeza;
            nuevo.anterior = cola;
            cabeza.anterior = nuevo;
            cola.siguiente = nuevo;
            cabeza = nuevo;
        }
        size++;
    }

    /**
     * Agregar al final.
     * Similar a agregar al inicio pero se actualiza cola.
     */
    public void agregarFinal(T dato) {
        NodoCircularDoble<T> nuevo = new NodoCircularDoble<>(dato);
        if (estaVacia()) {
            cabeza = cola = nuevo;
            cabeza.siguiente = cabeza.anterior = cabeza;
        } else {
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cola.siguiente = nuevo;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }
        size++;
    }



    /**
     * Eliminar primero.
     * La cabeza se mueve al siguiente y se ajusta circularidad.
     */
    public void eliminarPrimero() {
        if (estaVacia()) return;
        if (cabeza == cola) { // un solo nodo
            cabeza = cola = null;
        } else {
            cabeza = cabeza.siguiente;
            cabeza.anterior = cola;
            cola.siguiente = cabeza;
        }
        size--;
    }

    /**
     * Eliminar último.
     * La cola se mueve al anterior y se ajusta circularidad.
     */
    public void eliminarUltimo() {
        if (estaVacia()) return;
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.anterior;
            cola.siguiente = cabeza;
            cabeza.anterior = cola;
        }
        size--;
    }



    /**
     * Imprimir lista hacia adelante (size pasos).
     */
    public void imprimirAdelante() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircularDoble<T> aux = cabeza;
        for (int i = 0; i < size; i++) {
            System.out.print(aux.dato + " -> ");
            aux = aux.siguiente;
        }
        System.out.println("(circular a cabeza)");
    }

    /**
     * Imprimir lista hacia atrás (size pasos).
     */
    public void imprimirAtras() {
        if (estaVacia()) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircularDoble<T> aux = cola;
        for (int i = 0; i < size; i++) {
            System.out.print(aux.dato + " -> ");
            aux = aux.anterior;
        }
        System.out.println("(circular a cola)");
    }

    /**
     * Buscar un valor en la lista.
     */
    public boolean contiene(T valor) {
        if (estaVacia()) return false;
        NodoCircularDoble<T> aux = cabeza;
        for (int i = 0; i < size; i++) {
            if (aux.dato.equals(valor)) return true;
            aux = aux.siguiente;
        }
        return false;
    }
}
