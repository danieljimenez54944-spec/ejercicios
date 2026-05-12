import java.util.*;

public class CajeroAutomatico {
    public static class Transaccion {
        String tipo; double monto; String fecha;
        public Transaccion(String t, double m) { this.tipo = t; this.monto = m; this.fecha = new Date().toString(); }
    }

    public static class Cuenta {
        double saldo; String pin; List<Transaccion> historial = new ArrayList<>();
        double retiroDiarioAcumulado = 0; final double LIMITE_DIARIO = 2000000;

        public Cuenta(double s, String p) { this.saldo = s; this.pin = p; }
        public boolean validarPIN(String p) { return this.pin.equals(p); }
    }

    public static class ATM {
        private final Cuenta cuentaActiva;
        private int intentosPin = 0;
        private final Map<Integer, Integer> dispensadorBilletes = new TreeMap<>(Collections.reverseOrder());

        public ATM(Cuenta c) {
            this.cuentaActiva = c;
            dispensadorBilletes.put(50000, 100); // 100 billetes de 50k
            dispensadorBilletes.put(20000, 200);
        }

        public boolean autenticar(String pin) {
            if (intentosPin >= 3) { System.out.println("Tarjeta Bloqueada."); return false; }
            if (cuentaActiva.validarPIN(pin)) { intentosPin = 0; return true; }
            intentosPin++;
            return false;
        }

        public void retirar(double monto) {
            if (cuentaActiva.retiroDiarioAcumulado + monto > cuentaActiva.LIMITE_DIARIO) { System.out.println("Supera límite diario."); return; }
            if (monto > cuentaActiva.saldo) { System.out.println("Saldo insuficiente."); return; }

            double restante = monto;
            Map<Integer, Integer> entrega = new HashMap<>();
            for (int denom : dispensadorBilletes.keySet()) {
                int cantDispo = dispensadorBilletes.get(denom);
                int cantNecesaria = (int) (restante / denom);
                int aEntregar = Math.min(cantNecesaria, cantDispo);
                if (aEntregar > 0) { entrega.put(denom, aEntregar); restante -= (aEntregar * denom); }
            }

            if (restante == 0) {
                entrega.forEach((k, v) -> dispensadorBilletes.put(k, dispensadorBilletes.get(k) - v));
                cuentaActiva.saldo -= monto;
                cuentaActiva.retiroDiarioAcumulado += monto;
                cuentaActiva.historial.add(new Transaccion("Retiro", monto));
                System.out.println("Retiro exitoso. Billetes entregados: " + entrega);
            } else { System.out.println("No hay billetes de denominación adecuada en el cajero."); }
        }
    }
}
