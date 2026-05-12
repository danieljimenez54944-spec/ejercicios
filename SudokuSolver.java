import java.util.Random;

public class SudokuSolver {

    public static boolean esValido(int[][] tablero, int fila, int col, int num) {
        for (int x = 0; x < 9; x++) if (tablero[fila][x] == num || tablero[x][col] == num) return false;
        int inicioFila = fila - fila % 3, inicioCol = col - col % 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i + inicioFila][j + inicioCol] == num) return false;
        return true;
    }

    public static boolean resolverSudoku(int[][] tablero) {
        for (int fila = 0; fila < 9; fila++) {
            for (int col = 0; col < 9; col++) {
                if (tablero[fila][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (esValido(tablero, fila, col, num)) {
                            tablero[fila][col] = num;
                            if (resolverSudoku(tablero)) return true;
                            tablero[fila][col] = 0; // Backtracking
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] generarSudokuAleatorio() {
        int[][] tablero = new int[9][9];
        Random rand = new Random();
        for (int i = 0; i < 5; i++) { // Colocar algunos números iniciales aleatorios válidos
            int f = rand.nextInt(9), c = rand.nextInt(9), num = rand.nextInt(9) + 1;
            if (esValido(tablero, f, c, num)) tablero[f][c] = num;
        }
        resolverSudoku(tablero); // Rellenar tablero completo
        // Remover celdas para crear el juego
        for (int i = 0; i < 40; i++) { tablero[rand.nextInt(9)][rand.nextInt(9)] = 0; }
        return tablero;
    }
}
