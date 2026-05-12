import java.util.*;

public class BusquedaListas {

    // Búsqueda Binaria (Requiere arreglo ordenado)
    public static int busquedaBinaria(int[] arr, int destino) {
        int inicio = 0, fin = arr.length - 1;
        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arr[medio] == destino) return medio;
            if (arr[medio] < destino) inicio = medio + 1;
            else fin = medio - 1;
        }
        return -1;
    }

    // Búsqueda Lineal con Centinela
    public static int busquedaCentinela(int[] arr, int destino) {
        int n = arr.length;
        if (n == 0) return -1;
        if (arr[n - 1] == destino) return n - 1;
        
        int temp = arr[n - 1];
        arr[n - 1] = destino; // Colocar centinela
        int i = 0;
        while (arr[i] != destino) { i++; }
        arr[n - 1] = temp; // Restaurar el último elemento
        
        if (i < n - 1) return i;
        return -1;
    }

    // Buscar elemento más cercano a un valor objetivo (Arreglo debe estar ordenado)
    public static int elementoMasCercano(int[] arr, int objetivo) {
        int n = arr.length;
        if (n == 0) return -1;
        if (objetivo <= arr[0]) return arr[0];
        if (objetivo >= arr[n - 1]) return arr[n - 1];

        int i = 0, j = n, medio = 0;
        while (i < j) {
            medio = (i + j) / 2;
            if (arr[medio] == objetivo) return arr[medio];
            if (objetivo < arr[medio]) {
                if (medio > 0 && objetivo > arr[medio - 1]) 
                    return (objetivo - arr[medio - 1] >= arr[medio] - objetivo) ? arr[medio] : arr[medio - 1];
                j = medio;
            } else {
                if (medio < n - 1 && objetivo < arr[medio + 1])
                    return (objetivo - arr[medio] >= arr[medio + 1] - objetivo) ? arr[medio + 1] : arr[medio];
                i = medio + 1;
            }
        }
        return arr[medio];
    }

    // Encontrar todos los índices de un elemento repetido
    public static List<Integer> encontrarTodosLosIndices(int[] arr, int elemento) {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == elemento) indices.add(i);
        }
        return indices;
    }
}
