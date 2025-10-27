package arboles;
public class ArbolBinario {
    private Nodo raiz;

    // Insertar un valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private Nodo insertarRec(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.dato) {
            actual.izquierdo = insertarRec(actual.izquierdo, valor);
        } else if (valor > actual.dato) {
            actual.derecho = insertarRec(actual.derecho, valor);
        }
        return actual;
    }

    // Buscar un valor en el árbol
    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo actual, int valor) {
        if (actual == null) {
            return false;
        }
        if (actual.dato == valor) {
            return true;
        }
        return valor < actual.dato
            ? buscarRec(actual.izquierdo, valor)
            : buscarRec(actual.derecho, valor);
    }

    // Recorrido Inorden
    public String inorden() {
        StringBuilder sb = new StringBuilder();
        inordenRec(raiz, sb);
        return sb.toString();
    }

    private void inordenRec(Nodo actual, StringBuilder sb) {
        if (actual != null) {
            inordenRec(actual.izquierdo, sb);
            sb.append(actual.dato).append(" ");
            inordenRec(actual.derecho, sb);
        }
    }

    // Recorrido Preorden
    public String preorden() {
        StringBuilder sb = new StringBuilder();
        preordenRec(raiz, sb);
        return sb.toString();
    }

    private void preordenRec(Nodo actual, StringBuilder sb) {
        if (actual != null) {
            sb.append(actual.dato).append(" ");
            preordenRec(actual.izquierdo, sb);
            preordenRec(actual.derecho, sb);
        }
    }

    // Recorrido Postorden
    public String postorden() {
        StringBuilder sb = new StringBuilder();
        postordenRec(raiz, sb);
        return sb.toString();
    }

    private void postordenRec(Nodo actual, StringBuilder sb) {
        if (actual != null) {
            postordenRec(actual.izquierdo, sb);
            postordenRec(actual.derecho, sb);
            sb.append(actual.dato).append(" ");
        }
    }
}
