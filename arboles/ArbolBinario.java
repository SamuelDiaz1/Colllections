package arboles;

// Clase Nodo: representa un nodo del árbol binario
class Nodo {
    int dato;           // Valor almacenado en el nodo
    Nodo izquierdo;     // Referencia al hijo izquierdo
    Nodo derecho;       // Referencia al hijo derecho

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

// Clase principal del Árbol Binario de Búsqueda (ABB)
public class ArbolBinario {
    private Nodo raiz;  // Nodo raíz del árbol

    public ArbolBinario() {
        raiz = null;
    }

    // -------------------------------------------------------------------
    // Verificar si el árbol está vacío
    public boolean estaVacio() {
        return raiz == null;
    }

    // -------------------------------------------------------------------
    // Insertar un nuevo dato en el árbol
    public void insertar(int dato) {
        raiz = insertarNodo(raiz, dato);
    }

    private Nodo insertarNodo(Nodo actual, int dato) {
        if (actual == null) {
            return new Nodo(dato);
        }

        if (dato < actual.dato) {
            actual.izquierdo = insertarNodo(actual.izquierdo, dato);
        } else if (dato > actual.dato) {
            actual.derecho = insertarNodo(actual.derecho, dato);
        }
        // Si el dato ya existe, no se inserta (opcional)
        return actual;
    }

    // -------------------------------------------------------------------
    //Buscar si existe un dato en el árbol
    public boolean existeDato(int dato) {
        return buscar(raiz, dato);
    }

    private boolean buscar(Nodo actual, int dato) {
        if (actual == null) return false;
        if (actual.dato == dato) return true;
        return dato < actual.dato
                ? buscar(actual.izquierdo, dato)
                : buscar(actual.derecho, dato);
    }

    // -------------------------------------------------------------------
    // Recorridos del árbol
    // Imprime el recorrido inorden
    public void recorrerInOrden() {
        System.out.print("InOrden: ");
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(Nodo actual) {
        if (actual != null) {
            inOrden(actual.izquierdo);
            System.out.print(actual.dato + " ");
            inOrden(actual.derecho);
        }
    }
    // Imprime el recorrido preorden
    public void recorrerPreOrden() {
        System.out.print("PreOrden: ");
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(Nodo actual) {
        if (actual != null) {
            System.out.print(actual.dato + " ");
            preOrden(actual.izquierdo);
            preOrden(actual.derecho);
        }
    }
    // Imprime el recorrido postorden
    public void recorrerPostOrden() {
        System.out.print("PostOrden: ");
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(Nodo actual) {
        if (actual != null) {
            postOrden(actual.izquierdo);
            postOrden(actual.derecho);
            System.out.print(actual.dato + " ");
        }
    }

    // -------------------------------------------------------------------
    // Eliminar un nodo del árbol
    public void eliminar(int dato) {
        raiz = eliminarNodo(raiz, dato);
    }

    private Nodo eliminarNodo(Nodo actual, int dato) {
        if (actual == null) return null;

        if (dato < actual.dato) {
            actual.izquierdo = eliminarNodo(actual.izquierdo, dato);
        } else if (dato > actual.dato) {
            actual.derecho = eliminarNodo(actual.derecho, dato);
        } else {
            // Caso 1: nodo sin hijos
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            // Caso 2: un solo hijo
            else if (actual.izquierdo == null) {
                return actual.derecho;
            } else if (actual.derecho == null) {
                return actual.izquierdo;
            }
            // Caso 3: dos hijos
            else {
                int sucesor = obtenerMinimo(actual.derecho);
                actual.dato = sucesor;
                actual.derecho = eliminarNodo(actual.derecho, sucesor);
            }
        }
        return actual;
    }

    // -------------------------------------------------------------------
    //Obtener el valor mínimo del árbol
    public int obtenerMenor() {
        if (estaVacio()) throw new RuntimeException("Árbol vacío");
        return obtenerMinimo(raiz);
    }

    private int obtenerMinimo(Nodo actual) {
        return actual.izquierdo == null ? actual.dato : obtenerMinimo(actual.izquierdo);
    }

    // -------------------------------------------------------------------
    // Obtener el valor máximo del árbol
    public int obtenerMayor() {
        if (estaVacio()) throw new RuntimeException("Árbol vacío");
        return obtenerMaximo(raiz);
    }

    private int obtenerMaximo(Nodo actual) {
        return actual.derecho == null ? actual.dato : obtenerMaximo(actual.derecho);
    }

    // -------------------------------------------------------------------
    // Obtener altura del árbol
    public int obtenerAltura() {
        return altura(raiz);
    }

    private int altura(Nodo actual) {
        if (actual == null) return 0;
        return 1 + Math.max(altura(actual.izquierdo), altura(actual.derecho));
    }

    // -------------------------------------------------------------------
    // Contar hojas del árbol
    public int contarHojas() {
        return contarHojasRec(raiz);
    }

    private int contarHojasRec(Nodo actual) {
        if (actual == null) return 0;
        if (actual.izquierdo == null && actual.derecho == null) return 1;
        return contarHojasRec(actual.izquierdo) + contarHojasRec(actual.derecho);
    }

    // -------------------------------------------------------------------
    // Borrar todo el árbol
    public void borrarArbol() {
        raiz = null;
        System.out.println("El árbol ha sido borrado.");
    }
}
