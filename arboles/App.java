package arboles;

import javax.swing.JOptionPane;

public class App {
public static void main(String[] args) {

        
        ArbolBinario arbol = new ArbolBinario();
        int opcion = 0;

        do {
            String menu = """
            🌳 MENÚ ÁRBOL BINARIO 🌳

            1. Insertar nodo
            2. Buscar nodo
            3. Mostrar recorrido Inorden
            4. Mostrar recorrido Preorden
            5. Mostrar recorrido Postorden
            6. Salir

            Seleccione una opción:
            """;

            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del nodo:"));
                    arbol.insertar(valor);
                    JOptionPane.showMessageDialog(null, "Nodo insertado correctamente.");
                }
                case 2 -> {
                    int valor = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor a buscar:"));
                    boolean encontrado = arbol.buscar(valor);
                    JOptionPane.showMessageDialog(null, encontrado ? 
                        "El valor " + valor + " SÍ está en el árbol." : 
                        "El valor " + valor + " NO está en el árbol.");
                }
                case 3 -> {
                    JOptionPane.showMessageDialog(null, "Recorrido Inorden:\n" + arbol.inorden());
                }
                case 4 -> {
                    JOptionPane.showMessageDialog(null, "Recorrido Preorden:\n" + arbol.preorden());
                }
                case 5 -> {
                    JOptionPane.showMessageDialog(null, "Recorrido Postorden:\n" + arbol.postorden());
                }
                case 6 -> {
                    JOptionPane.showMessageDialog(null, "¡Programa finalizado!");
                }
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }

        } while (opcion != 6);
    
    }
}
