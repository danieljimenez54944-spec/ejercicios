import java.util.ArrayList;

public class Ejercicio11_Vehiculos {

    static abstract class Vehiculo {
        String marca, modelo;
        int anio;

        Vehiculo(String marca, String modelo, int anio) {
            this.marca = marca;
            this.modelo = modelo;
            this.anio = anio;
        }

        abstract double calcularCostoMantenimiento();

        void mostrar() {
            System.out.printf("%s %s (%d) - Mantenimiento: $%.2f%n",
                    marca, modelo, anio, calcularCostoMantenimiento());
        }
    }

    static class Auto extends Vehiculo {
        int numeroPuertas;

        Auto(String marca, String modelo, int anio, int puertas) {
            super(marca, modelo, anio);
            this.numeroPuertas = puertas;
        }

        @Override
        double calcularCostoMantenimiento() {
            return 300.0;
        }
    }

    static class Moto extends Vehiculo {
        String tipo; // deportiva, urbana

        Moto(String marca, String modelo, int anio, String tipo) {
            super(marca, modelo, anio);
            this.tipo = tipo;
        }

        @Override
        double calcularCostoMantenimiento() {
            return 150.0;
        }
    }

    static class Camion extends Vehiculo {
        double capacidadToneladas;

        Camion(String marca, String modelo, int anio, double capacidad) {
            super(marca, modelo, anio);
            this.capacidadToneladas = capacidad;
        }

        @Override
        double calcularCostoMantenimiento() {
            return 800.0 + (capacidadToneladas * 50);
        }
    }

    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Auto("Toyota", "Corolla", 2022, 4));
        vehiculos.add(new Moto("Yamaha", "MT-07", 2021, "deportiva"));
        vehiculos.add(new Camion("Volvo", "FH16", 2020, 20.0));

        System.out.println("--- Vehículos y costos de mantenimiento ---");
        for (Vehiculo v : vehiculos) v.mostrar();
    }
}
