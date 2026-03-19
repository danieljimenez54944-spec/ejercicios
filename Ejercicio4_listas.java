import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4_listas {

    static Scanner sc = new Scanner(System.in);

    // ── Funciones ─────────────────────────────────────────────
    static double encontrarMayor(double[] lista) {
        double mayor = lista[0];
        for (double e : lista)
            if (e > mayor) mayor = e;
        return mayor;
    }

    static double encontrarMenor(double[] lista) {
        double menor = lista[0];
        for (double e : lista)
            if (e < menor) menor = e;
        return menor;
    }

    static double calcularPromedio(double[] lista) {
        double suma = 0;
        for (double e : lista) suma += e;
        return suma / lista.length;
    }

    static double[] eliminarDuplicados(double[] lista) {
        ArrayList<Double> resultado = new ArrayList<>();
        for (double e : lista)
            if (!resultado.contains(e)) resultado.add(e);
        double[] arr = new double[resultado.size()];
        for (int i = 0; i < resultado.size(); i++) arr[i] = resultado.get(i);
        return arr;
    }

    static double[] burbuja(double[] lista) {
        double[] arr = lista.clone();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - 1 - i; j++)
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }

    static String arrayToString(double[] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i] % 1 == 0 ? (int) arr[i] : arr[i]);
            if (i < arr.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    static double[] pedirLista() {
        while (true) {
            try {
                System.out.print("  Ingresa números separados por comas: ");
                String entrada = sc.nextLine();
                String[] partes = entrada.split(",");
                double[] lista = new double[partes.length];
                for (int i = 0; i < partes.length; i++)
                    lista[i] = Double.parseDouble(partes[i].trim());
                return lista;
            } catch (NumberFormatException e) {
                System.out.println("  ⚠ Formato inválido. Ejemplo: 3, 1, 4, 1, 5");
            }
        }
    }

    // ── Menú ──────────────────────────────────────────────────
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("  OPERACIONES CON LISTAS");
            System.out.println("==============================");
            System.out.println("  1. Ingresar lista y ver resultados");
            System.out.println("  2. Salir");
            System.out.print("\nOpción: ");
            String op = sc.nextLine().trim();

            if (op.equals("1")) {
                double[] lista = pedirLista();
                System.out.println("\n  Lista original:      " + arrayToString(lista));
                System.out.printf("  Mayor:               %.2f%n", encontrarMayor(lista));
                System.out.printf("  Menor:               %.2f%n", encontrarMenor(lista));
                System.out.printf("  Promedio:            %.2f%n", calcularPromedio(lista));
                System.out.println("  Sin duplicados:      " + arrayToString(eliminarDuplicados(lista)));
                System.out.println("  Ordenada (burbuja):  " + arrayToString(burbuja(lista)));
            } else if (op.equals("2")) {
                System.out.println("\n  ¡Hasta luego!");
                break;
            } else {
                System.out.println(" Opción inválida.");
            }
        }
    }
}