import java.util.Scanner;

public class Ejercicio3_Manipulacion_de_cadenas {

    static Scanner sc = new Scanner(System.in);

    // ── Funciones ─────────────────────────────────────────────
    static int contarVocales(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray())
            if ("aeiouáéíóúü".indexOf(c) >= 0) count++;
        return count;
    }

    static int contarConsonantes(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray())
            if (Character.isLetter(c) && "aeiouáéíóúü".indexOf(c) < 0) count++;
        return count;
    }

    static String invertir(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    static boolean esPalindromo(String s) {
        String limpia = s.toLowerCase().replaceAll("[^a-záéíóúüñ]", "");
        return limpia.equals(new StringBuilder(limpia).reverse().toString());
    }

    static int contarPalabras(String s) {
        String recortada = s.trim();
        if (recortada.isEmpty()) return 0;
        return recortada.split("\\s+").length;
    }

    // ── Menú ──────────────────────────────────────────────────
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n==============================");
            System.out.println("  MANIPULACIÓN DE CADENAS");
            System.out.println("==============================");
            System.out.println("  1. Contar vocales y consonantes");
            System.out.println("  2. Invertir cadena");
            System.out.println("  3. Verificar palíndromo");
            System.out.println("  4. Contar palabras");
            System.out.println("  5. Analizar todo");
            System.out.println("  6. Salir");
            System.out.print("\nOpción: ");
            String op = sc.nextLine().trim();

            if (op.equals("6")) {
                System.out.println("\n  ¡Hasta luego!");
                return;
            }

            if (!op.matches("[1-5]")) {
                System.out.println("  ⚠ Opción inválida.");
                continue;
            }

            System.out.print("  Ingresa el texto: ");
            String texto = sc.nextLine();

            switch (op) {
                case "1":
                    System.out.println("  Vocales:     " + contarVocales(texto));
                    System.out.println("  Consonantes: " + contarConsonantes(texto));
                    break;
                case "2":
                    System.out.println("  Invertida:   " + invertir(texto));
                    break;
                case "3":
                    System.out.println("  Palíndromo:  " + (esPalindromo(texto) ? "Sí ✓" : "No ✗"));
                    break;
                case "4":
                    System.out.println("  Palabras:    " + contarPalabras(texto));
                    break;
                case "5":
                    System.out.println("\n  Análisis de: \"" + texto + "\"");
                    System.out.println("  Vocales:     " + contarVocales(texto));
                    System.out.println("  Consonantes: " + contarConsonantes(texto));
                    System.out.println("  Invertida:   " + invertir(texto));
                    System.out.println("  Palíndromo:  " + (esPalindromo(texto) ? "Sí ✓" : "No ✗"));
                    System.out.println("  Palabras:    " + contarPalabras(texto));
                    break;
            }
        }
    }
}