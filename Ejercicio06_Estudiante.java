import java.util.ArrayList;

public class Ejercicio06_Estudiante {

    static class Estudiante {
        String nombre;
        int edad;
        ArrayList<Double> calificaciones = new ArrayList<>();

        Estudiante(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        void agregarCalificacion(double cal) {
            calificaciones.add(cal);
        }

        double calcularPromedio() {
            if (calificaciones.isEmpty()) return 0;
            double suma = 0;
            for (double c : calificaciones) suma += c;
            return suma / calificaciones.size();
        }

        boolean aprueba() {
            return calcularPromedio() >= 6.0;
        }

        void mostrarInfo() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Edad: " + edad);
            System.out.println("Calificaciones: " + calificaciones);
            System.out.printf("Promedio: %.2f%n", calcularPromedio());
            System.out.println("Estado: " + (aprueba() ? "APROBADO" : "REPROBADO"));
        }
    }

    public static void main(String[] args) {
        Estudiante e = new Estudiante("Ana López", 20);
        e.agregarCalificacion(8.5);
        e.agregarCalificacion(7.0);
        e.agregarCalificacion(9.0);
        e.agregarCalificacion(5.5);
        e.mostrarInfo();
    }
}
