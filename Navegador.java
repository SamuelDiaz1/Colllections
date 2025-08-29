import java.util.ArrayDeque;

public class Navegador {
    private ArrayDeque<String> atras;
    private ArrayDeque<String> adelante;
    private String actual;

    public Navegador() {
        atras = new ArrayDeque<>();
        adelante = new ArrayDeque<>();
        actual = null;
    }

    // Visitar una nueva página
    public void visitar(String pagina) {
        if (actual != null) {
            atras.push(actual); // guardar la actual en "atrás"
        }
        actual = pagina;
        adelante.clear(); // se pierde lo que estaba en adelante
        System.out.println("Visitando: " + actual);
    }

    // Retroceder
    public void atras() {
        if (atras.isEmpty()) {
            System.out.println("No hay páginas anteriores");
            return;
        }
        adelante.push(actual); // guardar la actual en "adelante"
        actual = atras.pop();
        System.out.println("Retrocediendo a: " + actual);
    }

    // Adelante
    public void adelante() {
        if (adelante.isEmpty()) {
            System.out.println("No hay páginas siguientes");
            return;
        }
        atras.push(actual); // guardar la actual en "atrás"
        actual = adelante.pop();
        System.out.println("Avanzando a: " + actual);
    }

    // Página actual
    public String getActual() {
        return actual;
    }
}
