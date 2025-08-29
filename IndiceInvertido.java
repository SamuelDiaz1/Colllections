import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class IndiceInvertido {
    private Map<String, TreeSet<Integer>> indice;

    public IndiceInvertido() {
        indice = new HashMap<>();
    }

    // Agregar ocurrencia de palabra en una página
    public void agregar(String palabra, int pagina) {
        indice.computeIfAbsent(palabra, k -> new TreeSet<>()).add(pagina);
    }

    // Consultar páginas de una palabra
    public TreeSet<Integer> consultar(String palabra) {
        return indice.getOrDefault(palabra, new TreeSet<>());
    }

    // Mostrar todo el índice
    @Override
    public String toString() {
        return indice.toString();
    }

}
