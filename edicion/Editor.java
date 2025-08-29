package edicion;
import java.util.Stack;

public class Editor {
    private Stack<Operacion> historial;

    public Editor() {
        historial = new Stack<>();
    }

    // Aplica una nueva operación (push)
    public void aplicarOperacion(Operacion op) {
        historial.push(op);
        System.out.println("Aplicada: " + op);
    }

    // Deshace la última operación (pop)
    public void deshacer() {
        if (!historial.isEmpty()) {
            Operacion ultima = historial.pop();
            System.out.println("Deshecha: " + ultima);
        } else {
            System.out.println("No hay operaciones para deshacer.");
        }
    }

    // Muestra el estado actual del historial
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("Historial vacío.");
        } else {
            System.out.println("Historial actual: " + historial);
        }
    }
}

