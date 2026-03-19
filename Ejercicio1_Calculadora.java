import java.util.Scanner;

public class Ejercicio1_Calculadora {

    static Scanner sc = new Scanner(System.in);

    // ── Operaciones ───────────────────────────────────────────
    static double sumar(double a, double b)        { return a + b; }
    static double restar(double a, double b)        { return a - b; }
    static double multiplicar(double a, double b)   { return a * b; }

    static String dividir(double a, double b) {
        if (b == 0) return "Error: no se puede dividir entre cero.";
        return String.valueOf(a / b);
    }

    static String potencia(double base, double exp) {
        return String.valueOf(Math.pow(base, exp));
    }

    static String raizCuadrada(double n) {
        if (n < 0) return "Error: no existe raíz cuadrada de un número negativo.";
        return String.valueOf(Math.sqrt(n));
    }

    // ── Utilidades ────────────────────────────────────────────
    static double pedirNumero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  ⚠ Ingresa un número válido.");
            }
        }
    }

    // ── Menú ──────────────────────────────────────────────────
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("  CALCULADORA");
            System.out.println("==============================");
            System.out.println("  1. Sumar");
            System.out.println("  2. Restar");
            System.out.println("  3. Multiplicar");
            System.out.println("  4. Dividir");
            System.out.println("  5. Potencia");
            System.out.println("  6. Raíz cuadrada");
            System.out.println("  7. Salir");
            System.out.print("\nOpción: ");
            String op = sc.nextLine().trim();

            double a, b;
            switch (op) {
                case "1":
                    a = pedirNumero("  Número 1: ");
                    b = pedirNumero("  Número 2: ");
                    System.out.printf("  Resultado: %.4f%n", sumar(a, b));
                    break;
                case "2":
                    a = pedirNumero("  Número 1: ");
                    b = pedirNumero("  Número 2: ");
                    System.out.printf("  Resultado: %.4f%n", restar(a, b));
                    break;
                case "3":
                    a = pedirNumero("  Número 1: ");
                    b = pedirNumero("  Número 2: ");
                    System.out.printf("  Resultado: %.4f%n", multiplicar(a, b));
                    break;
                case "4":
                    a = pedirNumero("  Número 1: ");
                    b = pedirNumero("  Número 2: ");
                    System.out.println("  Resultado: " + dividir(a, b));
                    break;
                case "5":
                    a = pedirNumero("  Base: ");
                    b = pedirNumero("  Exponente: ");
                    System.out.println("  Resultado: " + potencia(a, b));
                    break;
                case "6":
                    a = pedirNumero("  Número: ");
                    System.out.println("  Resultado: " + raizCuadrada(a));
                    break;
                case "7":
                    System.out.println("\n  ¡Hasta luego!");
                    return;
                default:
                    System.out.println("  ⚠ Opción inválida.");
            }
        }
    }
}