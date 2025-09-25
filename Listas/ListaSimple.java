package Listas;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * ListaSimple<T>
 * Implementación de una lista enlazada simple genérica.
 * - T extiende Comparable<T> porque algunos métodos (ordenar) necesitan comparar elementos.
 * - Implementa Iterable<T> para poder usar foreach.
 *
 * NOTAS:
 * - Muchas operaciones (agregarFinal, eliminarUltimo, tamaño) son O(n) porque no guardamos
 *   una referencia a la cola ni un contador de tamaño. Se podría optimizar guardando `cola` y `size`.
 * - El comportamiento en algunos métodos cuando el índice es inválido es "silencioso" (no lanza excepción),
 *   tal y como solicitaste anteriormente (no lanzar excepciones).
 */
class ListaSimple<T extends Comparable<T>> implements Iterable<T> {
    private Nodo<T> cabeza; // referencia al primer nodo (head). null => lista vacía


    /**
     * Indica si la lista está vacía.
     * Complejidad: O(1)
     */
    public boolean estaVacia() {
        return cabeza == null;
    }

    /**
     * Devuelve el tamaño (número de nodos) de la lista.
     * Complejidad: O(n) — recorre todos los nodos.
     * Nota: Si necesitas tamaño frecuente, guarda un campo `size` y actualízalo en modificaciones.
     */
    public int tamaño() {
        int count = 0;
        Nodo<T> aux = cabeza;
        while (aux != null) {
            count++;
            aux = aux.siguiente;
        }
        return count;
    }

    /**
     * Comprueba si un índice es válido (0 .. tamaño-1).
     * COMPLEJIDAD: O(n) porque llama a tamaño().
     * Nota: método utilizado por algunas operaciones para validación.
     */
    public boolean indiceValido(int indice) {
        return indice >= 0 && indice < tamaño();
    }


    /**
     * Agrega un nuevo nodo con 'dato' al inicio de la lista.
     * - Nuevo nodo apunta a la antigua cabeza.
     * - La cabeza pasa a ser el nuevo nodo.
     * Complejidad: O(1)
     */
    public void agregarInicio(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = cabeza; // enlazamos el nuevo al antiguo primer nodo (puede ser null)
        cabeza = nuevo;           // actualizamos la cabeza
    }

    /**
     * Agrega un nuevo nodo con 'dato' al final de la lista.
     * - Si la lista está vacía, la cabeza será el nuevo.
     * - Si no, recorre hasta el último y enlaza.
     * Complejidad: O(n) (recorrer lista).
     */
    public void agregarFinal(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            cabeza = nuevo;
        } else {
            Nodo<T> aux = cabeza;
            // avanzamos hasta el último nodo (aux.siguiente == null)
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo; // enlazamos el nuevo al final
        }
    }

    /**
     * Agrega en una posición específica (índice).
     * - Si indice == 0 -> agrega al inicio.
     * - Si indice > 0: recorre hasta index-1 y enlaza el nuevo.
     * - Si indice está fuera (mayor que longitud), la implementación hace NOTHING (no inserta).
     *   Esto evita lanzar excepciones y respeta la política "sin excepciones".
     * Complejidad: O(n) (recorrer hasta index).
     */
    public void agregar(int indice, T dato) {
        if (indice == 0) {
            agregarInicio(dato);
            return;
        }
        Nodo<T> nuevo = new Nodo<>(dato);
        Nodo<T> aux = cabeza;

        // avanzamos index-1 veces o hasta que aux sea null
        for (int i = 0; i < indice - 1 && aux != null; i++) {
            aux = aux.siguiente;
        }

        // si aux != null => posición válida para insertar después de aux
        if (aux != null) {
            nuevo.siguiente = aux.siguiente; // nuevo apunta al que antes seguía a aux
            aux.siguiente = nuevo;           // aux ahora apunta al nuevo
        }
        // si aux == null => índice mayor que longitud -> no se inserta
    }


    /**
     * Devuelve el valor (dato) del nodo en la posición indicada.
     * - Si el índice no existe devuelve null.
     * Complejidad: O(n) (recorre hasta la posición).
     */
    public T obtenerValorNodo(int indice) {
        Nodo<T> aux = cabeza;
        for (int i = 0; i < indice && aux != null; i++) {
            aux = aux.siguiente;
        }
        return (aux != null) ? aux.dato : null;
    }

    /**
     * Devuelve la referencia al nodo en la posición indicada.
     * - Si el índice no existe devuelve null.
     * Complejidad: O(n)
     */
    public Nodo<T> obtenerNodo(int indice) {
        Nodo<T> aux = cabeza;
        for (int i = 0; i < indice && aux != null; i++) {
            aux = aux.siguiente;
        }
        return aux;
    }

    /**
     * Busca la posición (índice) del primer nodo cuyo dato .equals(valor).
     * - Devuelve el índice o -1 si no se encuentra.
     * Complejidad: O(n)
     */
    public int obtenerPosicionNodo(T valor) {
        Nodo<T> aux = cabeza;
        int indice = 0;
        while (aux != null) {
            if (aux.dato.equals(valor)) {
                return indice;
            }
            aux = aux.siguiente;
            indice++;
        }
        return -1;
    }

    // ---------------------- ELIMINACIONES ----------------------

    /**
     * Elimina el primer nodo (head).
     * - Si la lista está vacía no hace nada.
     * Complejidad: O(1)
     */
    public void eliminarPrimero() {
        if (!estaVacia()) {
            cabeza = cabeza.siguiente; // el GC liberará el antiguo head si no hay referencias externas
        }
    }

    /**
     * Elimina el último nodo.
     * - Si la lista está vacía no hace nada.
     * - Si sólo hay un nodo, deja la lista vacía.
     * Complejidad: O(n) (necesita recorrer hasta el penúltimo).
     */
    public void eliminarUltimo() {
        if (estaVacia()) return;

        // Si sólo hay un nodo, la cabeza se vuelve null
        if (cabeza.siguiente == null) {
            cabeza = null;
            return;
        }

        // Recorremos hasta el penúltimo (aux.siguiente.siguiente == null)
        Nodo<T> aux = cabeza;
        while (aux.siguiente.siguiente != null) {
            aux = aux.siguiente;
        }
        aux.siguiente = null; // eliminar referencia al último nodo
    }

    /**
     * Elimina la primera ocurrencia del valor dado.
     * - Si la lista está vacía no hace nada.
     * - Si la cabeza guarda el valor, elimina la cabeza.
     * - Si no lo encuentra, no hace nada.
     * Complejidad: O(n)
     */
    public void eliminar(T valor) {
        if (estaVacia()) return;

        // Caso cabeza
        if (cabeza.dato.equals(valor)) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo<T> aux = cabeza;
        // buscamos el nodo cuya siguiente contiene el valor
        while (aux.siguiente != null && !aux.siguiente.dato.equals(valor)) {
            aux = aux.siguiente;
        }

        // si aux.siguiente != null => encontramos y saltamos ese nodo
        if (aux.siguiente != null) {
            aux.siguiente = aux.siguiente.siguiente;
        }
        // si aux.siguiente == null => no encontrado -> no se hace nada
    }

    // ---------------------- MODIFICACIÓN ----------------------

    /**
     * Modifica el dato del nodo en la posición indicada.
     * - Si el índice no existe, no hace nada.
     * Complejidad: O(n)
     */
    public void modificarNodo(int indice, T nuevoValor) {
        Nodo<T> nodo = obtenerNodo(indice);
        if (nodo != null) {
            nodo.dato = nuevoValor;
        }
    }

    // ---------------------- ORDENAMIENTO ----------------------

    /**
     * Ordena la lista usando bubble sort (intercambiando datos).
     * - El algoritmo intercambia contenidos (dato) de los nodos en vez de manipular punteros.
     * - Complejidad: O(n^2) en tiempo, O(1) en espacio auxiliar.
     * - Estable (no cambia orden relativo de elementos iguales).
     *
     * Nota: Para listas grandes sería mejor convertir a array, ordenar y reconstruir,
     * o implementar un merge sort para listas enlazadas.
     */
    public void ordenarLista() {
        if (estaVacia() || cabeza.siguiente == null) return;

        boolean cambiado;
        do {
            cambiado = false;
            Nodo<T> actual = cabeza;
            while (actual.siguiente != null) {
                // compareTo > 0 => actual > actual.siguiente => hay que intercambiar
                if (actual.dato.compareTo(actual.siguiente.dato) > 0) {
                    T temp = actual.dato;
                    actual.dato = actual.siguiente.dato;
                    actual.siguiente.dato = temp;
                    cambiado = true;
                }
                actual = actual.siguiente;
            }
        } while (cambiado);
    }


    /**
     * Imprime la lista en formato: dato1 -> dato2 -> ... -> null
     * Complejidad: O(n)
     */
    public void imprimirLista() {
        Nodo<T> aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " -> ");
            aux = aux.siguiente;
        }
        System.out.println("null");
    }

    /**
     * Borra toda la lista (libera la referencia a la cabeza).
     * - El recolector de Java liberará los nodos si no hay otras referencias.
     * Complejidad: O(1)
     */
    public void borrarLista() {
        cabeza = null;
    }


    /**
     * Invierte el contenido de la lista (los enlaces) in-place.
     * - Iterativo: conserva O(1) espacio adicional.
     * - Tras la ejecución, la antigua cabeza pasa a ser el último (siguiente = null).
     * - Complejidad: O(n)
     *
     * Algoritmo:
     * anterior = null
     * actual = cabeza
     * while (actual != null) {
     *   siguiente = actual.siguiente
     *   actual.siguiente = anterior
     *   anterior = actual
     *   actual = siguiente
     * }
     * cabeza = anterior
     */
    public void invertir() {
        Nodo<T> anterior = null;
        Nodo<T> actual = cabeza;
        Nodo<T> siguiente;
        while (actual != null) {
            siguiente = actual.siguiente; // guardar referencia al siguiente antes de romper el enlace
            actual.siguiente = anterior;  // invertir enlace
            anterior = actual;            // mover 'anterior' hacia adelante
            actual = siguiente;           // continuar con el siguiente nodo original
        }
        cabeza = anterior; // 'anterior' ahora apunta al nuevo head (antiguo último)
    }


    /**
     * Iterador para permitir foreach y recorrido externo.
     * - No implementa remove() (podrías añadirlo si quieres eliminar durante la iteración).
     * - next() lanza NoSuchElementException si ya no hay elementos (comportamiento estándar).
     * - Complejidad de hasNext/next: O(1) amortizado.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Nodo<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                if (actual == null) {
                    // Comportamiento esperado por la interfaz Iterator cuando no quedan elementos
                    throw new NoSuchElementException();
                }
                T dato = actual.dato;
                actual = actual.siguiente; // avanzamos el iterador
                return dato;
            }

            // NOTA: no implementamos remove() — si se necesita, podría delegar la eliminación
            // sobre la ListaSimple, pero habría que gestionar referencias previas.
        };
    }
}


