import java.util.ArrayList;

public class Ejercicio09_Carrito {

    static class Producto {
        String nombre;
        double precio;
        int cantidad;

        Producto(String nombre, double precio, int cantidad) {
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
        }

        double subtotal() {
            return precio * cantidad;
        }

        void mostrar() {
            System.out.printf("%-15s $%.2f x %d = $%.2f%n", nombre, precio, cantidad, subtotal());
        }
    }

    static class Carrito {
        ArrayList<Producto> productos = new ArrayList<>();

        void agregar(Producto p) {
            productos.add(p);
            System.out.println("Agregado: " + p.nombre);
        }

        void eliminar(String nombre) {
            productos.removeIf(p -> p.nombre.equalsIgnoreCase(nombre));
            System.out.println("Eliminado: " + nombre);
        }

        double calcularTotal() {
            double total = 0;
            for (Producto p : productos) total += p.subtotal();
            return total;
        }

        double aplicarDescuento(double porcentaje) {
            double descuento = calcularTotal() * (porcentaje / 100);
            return calcularTotal() - descuento;
        }

        void mostrarCarrito() {
            System.out.println("--- Carrito de Compras ---");
            for (Producto p : productos) p.mostrar();
            System.out.printf("Total: $%.2f%n", calcularTotal());
        }
    }

    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        carrito.agregar(new Producto("Manzanas", 2.50, 4));
        carrito.agregar(new Producto("Leche", 1.80, 2));
        carrito.agregar(new Producto("Pan", 3.00, 1));

        carrito.mostrarCarrito();
        System.out.printf("Total con 10%% de descuento: $%.2f%n", carrito.aplicarDescuento(10));

        carrito.eliminar("Leche");
        System.out.println();
        carrito.mostrarCarrito();
    }
}
