import java.util.ArrayList;

public class Ejercicio12_Figuras {

    static abstract class Figura {
        abstract double calcularArea();
        abstract double calcularPerimetro();
        abstract String nombre();

        void mostrar() {
            System.out.printf("%s -> Área: %.2f | Perímetro: %.2f%n",
                    nombre(), calcularArea(), calcularPerimetro());
        }
    }

    static class Circulo extends Figura {
        double radio;

        Circulo(double radio) { this.radio = radio; }

        @Override double calcularArea() { return Math.PI * radio * radio; }
        @Override double calcularPerimetro() { return 2 * Math.PI * radio; }
        @Override String nombre() { return "Círculo (r=" + radio + ")"; }
    }

    static class Rectangulo extends Figura {
        double base, altura;

        Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override double calcularArea() { return base * altura; }
        @Override double calcularPerimetro() { return 2 * (base + altura); }
        @Override String nombre() { return "Rectángulo (" + base + "x" + altura + ")"; }
    }

    static class Triangulo extends Figura {
        double a, b, c;

        Triangulo(double a, double b, double c) {
            this.a = a; this.b = b; this.c = c;
        }

        @Override
        double calcularArea() {
            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override double calcularPerimetro() { return a + b + c; }
        @Override String nombre() { return "Triángulo (" + a + "," + b + "," + c + ")"; }
    }

    static double areaTotal(ArrayList<Figura> figuras) {
        double total = 0;
        for (Figura f : figuras) total += f.calcularArea();
        return total;
    }

    public static void main(String[] args) {
        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Circulo(5));
        figuras.add(new Rectangulo(4, 6));
        figuras.add(new Triangulo(3, 4, 5));

        System.out.println("--- Figuras Geométricas ---");
        for (Figura f : figuras) f.mostrar();
        System.out.printf("Área total de todas las figuras: %.2f%n", areaTotal(figuras));
    }
}
