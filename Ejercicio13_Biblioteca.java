import java.util.ArrayList;

public class Ejercicio13_Biblioteca {

    static class Libro {
        String titulo, autor, isbn;
        boolean disponible = true;

        Libro(String titulo, String autor, String isbn) {
            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
        }

        void mostrar() {
            System.out.printf("[%s] %s - %s | %s%n", isbn, titulo, autor,
                    disponible ? "Disponible" : "Prestado");
        }
    }

    static class Usuario {
        String nombre;
        ArrayList<Libro> librosPrestados = new ArrayList<>();

        Usuario(String nombre) { this.nombre = nombre; }

        boolean puedePrestar() { return librosPrestados.size() < 3; }
    }

    static class Biblioteca {
        ArrayList<Libro> libros = new ArrayList<>();

        void agregarLibro(Libro l) { libros.add(l); }

        Libro buscarLibro(String isbn) {
            for (Libro l : libros) {
                if (l.isbn.equals(isbn)) return l;
            }
            return null;
        }

        void prestar(Usuario u, String isbn) {
            if (!u.puedePrestar()) {
                System.out.println(u.nombre + " ya tiene 3 libros prestados.");
                return;
            }
            Libro l = buscarLibro(isbn);
            if (l == null) {
                System.out.println("Libro no encontrado.");
            } else if (!l.disponible) {
                System.out.println("El libro no está disponible.");
            } else {
                l.disponible = false;
                u.librosPrestados.add(l);
                System.out.println(u.nombre + " prestó: " + l.titulo);
            }
        }

        void devolver(Usuario u, String isbn) {
            Libro l = buscarLibro(isbn);
            if (l != null && u.librosPrestados.remove(l)) {
                l.disponible = true;
                System.out.println(u.nombre + " devolvió: " + l.titulo);
            } else {
                System.out.println("Este usuario no tiene ese libro.");
            }
        }

        void listarLibros() {
            System.out.println("--- Catálogo ---");
            for (Libro l : libros) l.mostrar();
        }
    }

    public static void main(String[] args) {
        Biblioteca bib = new Biblioteca();
        bib.agregarLibro(new Libro("Cien años de soledad", "García Márquez", "ISBN001"));
        bib.agregarLibro(new Libro("El principito", "Saint-Exupéry", "ISBN002"));
        bib.agregarLibro(new Libro("Don Quijote", "Cervantes", "ISBN003"));
        bib.agregarLibro(new Libro("La Odisea", "Homero", "ISBN004"));

        Usuario u1 = new Usuario("Valentina");

        bib.listarLibros();
        System.out.println();
        bib.prestar(u1, "ISBN001");
        bib.prestar(u1, "ISBN002");
        bib.prestar(u1, "ISBN003");
        bib.prestar(u1, "ISBN004"); // debe rechazarse por límite
        System.out.println();
        bib.devolver(u1, "ISBN002");
        bib.prestar(u1, "ISBN004"); // ahora sí puede
        System.out.println();
        bib.listarLibros();
    }
}
