import java.util.LinkedList;

public class LaboratorioSistemas {
    private LinkedList<String> Fila;

    public LaboratorioSistemas() {
        Fila = new LinkedList<>();
    }

    // Un solo método para ingresar
    public void ingresar(String estudiante, boolean preferencial) {
        if (preferencial) {
            Fila.addFirst(estudiante); // turno preferencial
            System.out.println(estudiante + " entró con turno preferencial.");
        } else {
            Fila.addLast(estudiante); // turno normal
            System.out.println(estudiante + " entró a la Fila normal.");
        }
    }

    // Atender al siguiente estudiante
    public void atender() {
        if (!Fila.isEmpty()) {
            String atendido = Fila.removeFirst();
            System.out.println("Atendiendo a: " + atendido);
        } else {
            System.out.println("No hay estudiantes en la Fila.");
        }
    }

    // Mostrar Fila
    public void mostrarFila() {
        System.out.println("Fila actual: " + Fila);
    }


}
