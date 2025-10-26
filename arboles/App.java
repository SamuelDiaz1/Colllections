package arboles;

public class App {
public static void main(String[] args) {

        // Crear un nuevo árbol binario de búsqueda
        ArbolBinario abb = new ArbolBinario();

        System.out.println("=== Inserción de datos ===");
        abb.insertar(8);
        abb.insertar(3);
        abb.insertar(10);
        abb.insertar(1);
        abb.insertar(6);
        abb.insertar(14);
        abb.insertar(4);
        abb.insertar(7);
        abb.insertar(13);

        // -------------------------------------------------------------------
        System.out.println("\n=== Recorridos del árbol ===");
        abb.recorrerInOrden();     // Muestra los datos ordenados: 1 3 4 6 7 8 10 13 14
        abb.recorrerPreOrden();    // Muestra el orden de inserción jerárquico
        abb.recorrerPostOrden();   // Muestra el recorrido postorden

        // -------------------------------------------------------------------
        System.out.println("\n=== Búsqueda de datos ===");
        int buscarDato = 6;
        System.out.println("¿Existe el dato " + buscarDato + "? " + abb.existeDato(buscarDato));

        buscarDato = 11;
        System.out.println("¿Existe el dato " + buscarDato + "? " + abb.existeDato(buscarDato));

        // -------------------------------------------------------------------
        System.out.println("\n=== Propiedades del árbol ===");
        System.out.println("Altura del árbol: " + abb.obtenerAltura());
        System.out.println("Nodo menor: " + abb.obtenerMenor());
        System.out.println("Nodo mayor: " + abb.obtenerMayor());
        System.out.println("Cantidad de hojas: " + abb.contarHojas());

        // -------------------------------------------------------------------
        System.out.println("\n=== Eliminación de nodos ===");
        System.out.println("Eliminando nodo con valor 3...");
        abb.eliminar(3);
        abb.recorrerInOrden();

        System.out.println("Eliminando nodo con valor 8 (raíz)...");
        abb.eliminar(8);
        abb.recorrerInOrden();

        // -------------------------------------------------------------------
        System.out.println("\n=== Borrando el árbol completo ===");
        abb.borrarArbol();
        System.out.println("¿El árbol está vacío? " + abb.estaVacio());
    }
}
