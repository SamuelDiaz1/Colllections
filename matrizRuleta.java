/**
 * Clase matrizRuleta
 * 
 * Esta clase implementa un algoritmo que simula la rotación de los elementos 
 * de una matriz cuadrada en forma de "ruleta", desplazando los bordes de la matriz 
 * hacia la derecha en cada giro.
 * 
 * Métodos principales:
 * - girarRuleta: permite girar la matriz un número dado de veces.
 * - girarDerecha: realiza un giro hacia la derecha en el borde de la matriz.
 * - imprimirMatriz: imprime la matriz en consola de forma tabular.
 */
public class matrizRuleta {

    /**
     * Método recursivo que gira la matriz una cantidad de veces indicada.
     *
     * @param matriz Matriz bidimensional a girar.
     * @param pasos  Número de giros a realizar.
     */
    public static void girarRuleta(int[][] matriz, int pasos) {
        if (pasos == 0) return; // Caso base: sin pasos, no hay más giros.
        
        girarDerecha(matriz);   // Realiza un giro a la derecha.
        girarRuleta(matriz, pasos - 1); // Llamada recursiva para los giros restantes.
    }

    /**
     * Método que realiza un único giro a la derecha sobre el borde de la matriz.
     *
     * @param matriz Matriz bidimensional a modificar.
     */
    private static void girarDerecha(int[][] matriz) {
        int x = matriz.length;        // Número de filas.
        int y = matriz[0].length;     // Número de columnas.
        
        // Guardamos el último elemento de la primera fila (esquina superior derecha).
        int temp = matriz[0][y - 1];

        // Mover la primera fila hacia la derecha.
        for (int j = y - 1; j > 0; j--) {
            matriz[0][j] = matriz[0][j - 1];
        }

        // Mover la primera columna hacia arriba.
        for (int i = 0; i < x - 1; i++) {
            matriz[i][0] = matriz[i + 1][0];
        }

        // Mover la última fila hacia la izquierda.
        for (int j = 0; j < y - 1; j++) {
            matriz[x - 1][j] = matriz[x - 1][j + 1];
        }

        // Mover la última columna hacia abajo.
        for (int i = x - 1; i > 1; i--) {
            matriz[i][y - 1] = matriz[i - 1][y - 1];
        }

        // Colocamos el valor temporal en su nueva posición.
        matriz[1][y - 1] = temp;
    }

    /**
     * Método que imprime la matriz en consola en forma tabular.
     *
     * @param matriz Matriz bidimensional a imprimir.
     */
    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int val : fila) {
                System.out.print(val + "\t"); // Tabulación para alineación.
            }
            System.out.println();
        }
    }

    /**
     * Método principal.
     * Crea una matriz de ejemplo, la imprime, realiza un giro y la imprime de nuevo.
     */
    public static void main(String[] args) {
        // Matriz inicial organizada en espiral.
        int[][] matriz = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 9, 15, 16}
        };

        System.out.println("Matriz original:");
        imprimirMatriz(matriz);

        // Girar una vez a la derecha.
        girarRuleta(matriz, 1);
        System.out.println("Giro a la derecha:");
        imprimirMatriz(matriz);
    }
}
