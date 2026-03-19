import java.util.Scanner;

public class Ejercicio2_Validador_de_Números {

    static Scanner sc = new Scanner(System.in);

    // ── Funciones ─────────────────────────────────────────────
    static boolean esPar(int n)    { return n % 2 == 0; }
    static boolean esImpar(int n)  { return n % 2 != 0; }

    static boolean esPrimo(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    static boolean esPerfecto(int n) {
        if (n < 1) return false;
        int suma = 0;
        for (int i = 1; i < n; i++)
            if (n % i == 0) suma += i;
        return suma == n;
    }

    static boolean esPalindromo(int n) {
        String s = String.valueOf(Math.abs(n));
        String r = new StringBuilder(s).reverse().toString();
        return s.equals(r);
    }

    // ── Utilidades ────────────────────────────────────────────
    static int pedirEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  ⚠ Ingresa un número entero válido.");
            }
        }
    }

    // ── Menú ──────────────────────────────────────────────────
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("  VALIDADOR DE NÚMEROS");
            System.out.println("==============================");
            System.out.println("  1. Par o impar");
            System.out.println("  2. Primo");
            System.out.println("  3. Perfecto");
            System.out.println("  4. Palíndromo");
            System.out.println("  5. Analizar todo");
            System.out.println("  6. Salir");
            System.out.print("\nOpción: ");
            String op = sc.nextLine().trim();

            int n;
            switch (op) {
                case "1":
                    n = pedirEntero("  Número: ");
                    System.out.println("  Resultado: " + n + " es " + (esPar(n) ? "PAR" : "IMPAR"));
                    break;
                case "2":
                    n = pedirEntero("  Número: ");
                    System.out.println("  Resultado: " + n + (esPrimo(n) ? " ES primo." : " NO es primo."));
                    break;
                case "3":
                    n = pedirEntero("  Número: ");
                    System.out.println("  Resultado: " + n + (esPerfecto(n) ? " ES perfecto." : " NO es perfecto."));
                    break;
                case "4":
                    n = pedirEntero("  Número: ");
                    System.out.println("  Resultado: " + n + (esPalindromo(n) ? " ES palíndromo." : " NO es palíndromo."));
                    break;
                case "5":
                    n = pedirEntero("  Número: ");
                    System.out.println("\n  Análisis de " + n + ":");
                    System.out.println("  Par/Impar:   " + (esPar(n) ? "Par" : "Impar"));
                    System.out.println("  Primo:       " + (esPrimo(n) ? "Sí" : "No"));
                    System.out.println("  Perfecto:    " + (esPerfecto(n) ? "Sí" : "No"));
                    System.out.println("  Palíndromo:  " + (esPalindromo(n) ? "Sí" : "No"));
                    break;
                case "6":
                    System.out.println("\n  ¡Hasta luego!");
                    return;
                default:
                    System.out.println("  ⚠ Opción inválida.");
            }
        }
    }
}