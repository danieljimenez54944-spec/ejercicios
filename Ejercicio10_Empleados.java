import java.util.ArrayList;

public class Ejercicio10_Empleados {

    static class Empleado {
        String nombre, departamento;
        int dni;
        double salario;

        Empleado(int dni, String nombre, double salario, String departamento) {
            this.dni = dni;
            this.nombre = nombre;
            this.salario = salario;
            this.departamento = departamento;
        }

        double salarioAnual() {
            return salario * 12;
        }

        void aplicarAumento(double porcentaje) {
            salario += salario * (porcentaje / 100);
            System.out.printf("Nuevo salario de %s: $%.2f%n", nombre, salario);
        }

        void mostrar() {
            System.out.printf("DNI: %d | %s | Depto: %s | Salario: $%.2f | Anual: $%.2f%n",
                    dni, nombre, departamento, salario, salarioAnual());
        }
    }

    static ArrayList<Empleado> empleados = new ArrayList<>();

    static void agregar(Empleado e) {
        empleados.add(e);
    }

    static Empleado buscarPorDNI(int dni) {
        for (Empleado e : empleados) {
            if (e.dni == dni) return e;
        }
        return null;
    }

    public static void main(String[] args) {
        agregar(new Empleado(1001, "Sandra Torres", 2500.0, "Ventas"));
        agregar(new Empleado(1002, "Jorge Ruiz", 3000.0, "TI"));
        agregar(new Empleado(1003, "Paola Gómez", 2800.0, "RRHH"));

        System.out.println("--- Lista de Empleados ---");
        for (Empleado e : empleados) e.mostrar();

        System.out.println("\nBúsqueda por DNI 1002:");
        Empleado encontrado = buscarPorDNI(1002);
        if (encontrado != null) {
            encontrado.mostrar();
            encontrado.aplicarAumento(15);
        }
    }
}
