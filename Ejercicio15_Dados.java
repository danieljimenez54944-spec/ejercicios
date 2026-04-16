import java.util.ArrayList;
import java.util.Random;

public class Ejercicio15_Dados {

    static Random random = new Random();

    static class Dado {
        int valor;

        int lanzar() {
            valor = random.nextInt(6) + 1;
            return valor;
        }
    }

    static class Jugador {
        String nombre;
        int puntos = 0;

        Jugador(String nombre) { this.nombre = nombre; }

        int jugarTurno(Dado dado) {
            int suma = 0;
            System.out.print(nombre + " lanza: ");
            for (int i = 0; i < 3; i++) {
                int val = dado.lanzar();
                suma += val;
                System.out.print(val + " ");
            }
            System.out.println("-> Suma: " + suma);
            puntos = suma;
            return suma;
        }
    }

    static class Juego {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Dado dado = new Dado();

        void agregarJugador(Jugador j) { jugadores.add(j); }

        void jugar() {
            System.out.println("=== JUEGO DE DADOS ===");
            System.out.println("Regla: mayor suma de 3 lanzamientos gana\n");

            for (Jugador j : jugadores) j.jugarTurno(dado);

            Jugador ganador = jugadores.get(0);
            for (Jugador j : jugadores) {
                if (j.puntos > ganador.puntos) ganador = j;
            }

            System.out.println("\n¡GANADOR: " + ganador.nombre + " con " + ganador.puntos + " puntos!");
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.agregarJugador(new Jugador("Andrés"));
        juego.agregarJugador(new Jugador("Camila"));
        juego.agregarJugador(new Jugador("Felipe"));
        juego.jugar();
    }
}
