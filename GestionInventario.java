import java.time.LocalDate;
import java.util.*;

public class GestionInventario {

    public static abstract class Producto {
        String codigo, nombre; double precio; int stock, ventas;
        public Producto(String c, String n, double p, int s) { this.codigo = c; this.nombre = n; this.precio = p; this.stock = s; }
        public abstract double calcularPrecio();
        public void registrarVenta(int cant) { if (cant <= stock) { stock -= cant; ventas += cant; } }
    }

    public static class ProductoPerecible extends Producto {
        LocalDate fechaVencimiento;
        public ProductoPerecible(String c, String n, double p, int s, LocalDate fV) { super(c, n, p, s); this.fechaVencimiento = fV; }
        @Override public double calcularPrecio() {
            if (LocalDate.now().plusDays(3).isAfter(fechaVencimiento)) return precio * 0.5; // 50% descuento si vence pronto
            return precio;
        }
    }

    public static class ProductoElectronico extends Producto {
        int mesesGarantia;
        public ProductoElectronico(String c, String n, double p, int s, int mG) { super(c, n, p, s); this.mesesGarantia = mG; }
        @Override public double calcularPrecio() { return precio; }
    }

    public static class Inventario {
        List<Producto> productos = new ArrayList<>();
        public void agregar(Producto p) { productos.add(p); }
        
        public void verificarAlertasStock() {
            productos.stream().filter(p -> p.stock < 5)
                     .forEach(p -> System.out.println("Alerta Stock Bajo: " + p.nombre + " (Unidades: " + p.stock + ")"));
        }

        public void reporteMasVendidos() {
            productos.stream().sorted((p1, p2) -> Integer.compare(p2.ventas, p1.ventas))
                     .forEach(p -> System.out.println(p.nombre + " - Vendidos: " + p.ventas));
        }
    }
}
