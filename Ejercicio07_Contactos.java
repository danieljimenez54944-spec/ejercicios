import java.util.ArrayList;

public class Ejercicio07_Contactos {

    static class Contacto {
        String nombre, telefono, correo;

        Contacto(String nombre, String telefono, String correo) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.correo = correo;
        }

        void mostrar() {
            System.out.println(nombre + " | " + telefono + " | " + correo);
        }
    }

    static class Agenda {
        ArrayList<Contacto> contactos = new ArrayList<>();

        void agregar(Contacto c) {
            contactos.add(c);
            System.out.println("Contacto agregado: " + c.nombre);
        }

        void eliminar(String nombre) {
            contactos.removeIf(c -> c.nombre.equalsIgnoreCase(nombre));
            System.out.println("Contacto eliminado: " + nombre);
        }

        void buscar(String nombre) {
            for (Contacto c : contactos) {
                if (c.nombre.equalsIgnoreCase(nombre)) {
                    c.mostrar();
                    return;
                }
            }
            System.out.println("Contacto no encontrado.");
        }

        void listarTodos() {
            System.out.println("--- Lista de contactos ---");
            for (Contacto c : contactos) c.mostrar();
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.agregar(new Contacto("Carlos", "3001234567", "carlos@mail.com"));
        agenda.agregar(new Contacto("María", "3107654321", "maria@mail.com"));
        agenda.agregar(new Contacto("Pedro", "3209876543", "pedro@mail.com"));

        agenda.listarTodos();
        System.out.println();
        agenda.buscar("María");
        System.out.println();
        agenda.eliminar("Carlos");
        agenda.listarTodos();
    }
}
