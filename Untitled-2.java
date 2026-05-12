import java.util.*;

public class OrdenamientoAvanzado {

    // QuickSort para arreglos de enteros
    public static void quickSort(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            int pi = particion(arr, bajo, alto);
            quickSort(arr, bajo, pi - 1);
            quickSort(arr, pi + 1, alto);
        }
    }

    private static int particion(int[] arr, int bajo, int alto) {
        int pivote = arr[alto];
        int i = (bajo - 1);
        for (int j = bajo; j < alto; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;
        return i + 1;
    }

    // MergeSort para arreglos de enteros
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(arr, l, L, 0, n1);
        System.arraycopy(arr, m + 1, R, 0, n2);
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { arr[k] = L[i]; i++; }
            else { arr[k] = R[j]; j++; }
            k++;
        }
        while (i < n1) { arr[k] = L[i]; i++; k++; }
        while (j < n2) { arr[k] = R[j]; j++; k++; }
    }

    // Función para comparar tiempos de ejecución
    public static void compararTiempos(int tamaño) {
        int[] arr1 = new Random().ints(tamaño, 0, 100000).toArray();
        int[] arr2 = arr1.clone();

        long inicio = System.nanoTime();
        quickSort(arr1, 0, arr1.length - 1);
        long fin = System.nanoTime();
        System.out.println("QuickSort: " + (fin - inicio) / 1e6 + " ms");

        inicio = System.nanoTime();
        mergeSort(arr2, 0, arr2.length - 1);
        fin = System.nanoTime();
        System.out.println("MergeSort: " + (fin - inicio) / 1e6 + " ms");
    }

    // Ordenar objetos por múltiples criterios (Ejemplo: Persona por Edad, luego por Nombre)
    public static class Persona {
        String nombre; int edad;
        public Persona(String n, int e) { this.nombre = n; this.edad = e; }
        @Override public String toString() { return nombre + " (" + edad + ")"; }
    }

    public static void ordenarPersonas(List<Persona> personas) {
        personas.sort(Comparator.comparingInt((Persona p) -> p.edad)
                                .thenComparing(p -> p.nombre));
    }
}
