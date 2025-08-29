package AppMusica;
import java.util.LinkedList;

public class ListaReproduccion {
    private LinkedList<Cancion> canciones;
    private int cursor; // índice de la canción actual

    public ListaReproduccion() {
        canciones = new LinkedList<>();
        cursor = -1; // no hay canción seleccionada al inicio
    }

    public void agregarCancion(Cancion c) {
        canciones.add(c);
        if (cursor == -1) cursor = 0; // primera canción
    }

    public Cancion actual() {
        if (cursor >= 0 && cursor < canciones.size()) {
            return canciones.get(cursor);
        }
        return null;
    }

    public Cancion siguiente() {
        if (cursor < canciones.size() - 1) {
            cursor++;
            return canciones.get(cursor);
        }
        System.out.println("Ya estás en la última canción.");
        return null;
    }

    public Cancion anterior() {
        if (cursor > 0) {
            cursor--;
            return canciones.get(cursor);
        }
        System.out.println("Ya estás en la primera canción.");
        return null;
    }

    public void moverCancion(int origen, int destino) {
        if (origen < 0 || origen >= canciones.size() || destino < 0 || destino >= canciones.size()) {
            System.out.println("Posiciones inválidas.");
            return;
        }
        Cancion c = canciones.remove(origen);
        canciones.add(destino, c);

        // Ajustar cursor si es necesario
        if (cursor == origen) {
            cursor = destino;
        } else if (origen < cursor && destino >= cursor) {
            cursor--; 
        } else if (origen > cursor && destino <= cursor) {
            cursor++;
        }
    }

    @Override
    public String toString() {
        return canciones.toString() + " (actual: " + actual() + ")";
    }
}
