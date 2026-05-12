import java.util.*;

public class ReservaVuelos {
    public static class Pasajero {
        String id, nombre; List<String> historialReservas = new ArrayList<>();
        public Pasajero(String i, String n) { this.id = i; this.nombre = n; }
    }

    public static class Vuelo {
        String codigo, origen, destino; int asientosDisponibles; double precioBase;
        public Vuelo(String c, String o, String d, int a, double p) { this.codigo = c; this.origen = o; this.destino = d; this.asientosDisponibles = a; this.precioBase = p; }
    }

    public static class SistemaReservas {
        List<Vuelo> vuelos = new ArrayList<>();
        Map<String, List<Vuelo>> reservasPasajeros = new HashMap<>();

        public List<Vuelo> buscarVuelos(String orig, String dest) {
            return vuelos.stream().filter(v -> v.origen.equalsIgnoreCase(orig) && v.destino.equalsIgnoreCase(dest)).toList();
        }

        public boolean reservarMúltiple(Pasajero p, List<Vuelo> listaVuelos) {
            for (Vuelo v : listaVuelos) { if (v.asientosDisponibles < 1) return false; }
            for (Vuelo v : listaVuelos) {
                v.asientosDisponibles--;
                reservasPasajeros.computeIfAbsent(p.id, k -> new ArrayList<>()).add(v);
                p.historialReservas.add(v.codigo);
            }
            return true;
        }

        public void cancelarReserva(Pasajero p, Vuelo v) {
            if (reservasPasajeros.getOrDefault(p.id, Collections.emptyList()).remove(v)) {
                v.asientosDisponibles++;
                System.out.println("Reembolso procesado para " + p.nombre + ": $" + (v.precioBase * 0.90)); // 10% penalización
            }
        }
    }
}
