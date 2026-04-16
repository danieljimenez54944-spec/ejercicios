public class Ejercicio08_CuentaBancaria {

    static class CuentaBancaria {
        String titular;
        double saldo;
        String numeroCuenta;

        CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
            this.titular = titular;
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldoInicial;
        }

        void depositar(double monto) {
            if (monto <= 0) {
                System.out.println("El monto debe ser positivo.");
                return;
            }
            saldo += monto;
            System.out.printf("Depósito de $%.2f realizado. Saldo actual: $%.2f%n", monto, saldo);
        }

        void retirar(double monto) {
            if (monto <= 0) {
                System.out.println("El monto debe ser positivo.");
            } else if (monto > saldo) {
                System.out.println("Saldo insuficiente.");
            } else {
                saldo -= monto;
                System.out.printf("Retiro de $%.2f realizado. Saldo actual: $%.2f%n", monto, saldo);
            }
        }

        void consultarSaldo() {
            System.out.printf("Cuenta: %s | Titular: %s | Saldo: $%.2f%n", numeroCuenta, titular, saldo);
        }
    }

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Luis Pérez", "001-2024", 500.0);
        cuenta.consultarSaldo();
        cuenta.depositar(300.0);
        cuenta.retirar(100.0);
        cuenta.retirar(800.0); // intento con saldo insuficiente
        cuenta.consultarSaldo();
    }
}
