import java.util.ArrayList;

public class Ejercicio14_Hotel {

    static class Habitacion {
        int numero;
        String tipo; // simple, doble, suite
        double precioPorNoche;
        boolean ocupada = false;

        Habitacion(int numero, String tipo, double precio) {
            this.numero = numero;
            this.tipo = tipo;
            this.precioPorNoche = precio;
        }

        void mostrar() {
            System.out.printf("Hab %d | %s | $%.2f/noche | %s%n",
                    numero, tipo, precioPorNoche, ocupada ? "Ocupada" : "Disponible");
        }
    }

    static class Reserva {
        String cliente;
        Habitacion habitacion;
        int dias;

        Reserva(String cliente, Habitacion habitacion, int dias) {
            this.cliente = cliente;
            this.habitacion = habitacion;
            this.dias = dias;
        }

        double costoTotal() {
            return habitacion.precioPorNoche * dias;
        }

        void mostrar() {
            System.out.printf("Cliente: %s | Hab %d (%s) | %d días | Total: $%.2f%n",
                    cliente, habitacion.numero, habitacion.tipo, dias, costoTotal());
        }
    }

    static class Hotel {
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        ArrayList<Reserva> reservas = new ArrayList<>();

        void agregarHabitacion(Habitacion h) { habitaciones.add(h); }

        void reservar(String cliente, int numHabitacion, int dias) {
            for (Habitacion h : habitaciones) {
                if (h.numero == numHabitacion) {
                    if (h.ocupada) {
                        System.out.println("La habitación " + numHabitacion + " está ocupada.");
                    } else {
                        h.ocupada = true;
                        Reserva r = new Reserva(cliente, h, dias);
                        reservas.add(r);
                        System.out.print("Reserva confirmada -> ");
                        r.mostrar();
                    }
                    return;
                }
            }
            System.out.println("Habitación no encontrada.");
        }

        void liberar(int numHabitacion) {
            for (Habitacion h : habitaciones) {
                if (h.numero == numHabitacion && h.ocupada) {
                    h.ocupada = false;
                    System.out.println("Habitación " + numHabitacion + " liberada.");
                    return;
                }
            }
            System.out.println("No se encontró reserva activa para esa habitación.");
        }

        void listarHabitaciones() {
            System.out.println("--- Habitaciones ---");
            for (Habitacion h : habitaciones) h.mostrar();
        }

        void listarReservas() {
            System.out.println("--- Reservas activas ---");
            for (Reserva r : reservas) r.mostrar();
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.agregarHabitacion(new Habitacion(101, "Simple", 80.0));
        hotel.agregarHabitacion(new Habitacion(102, "Doble", 130.0));
        hotel.agregarHabitacion(new Habitacion(103, "Suite", 250.0));

        hotel.listarHabitaciones();
        System.out.println();
        hotel.reservar("Carlos Díaz", 101, 3);
        hotel.reservar("Lucía Mora", 103, 5);
        hotel.reservar("Pedro Ríos", 101, 2); // ya ocupada
        System.out.println();
        hotel.listarReservas();
        System.out.println();
        hotel.liberar(101);
        hotel.reservar("Pedro Ríos", 101, 2); // ahora disponible
    }
}
