import java.util.*;

public class EstructurasLineales {

    // Clase Pila Genérica
    public static class Pila<T> {
        private final LinkedList<T> list = new LinkedList<>();
        public void push(T val) { list.addFirst(val); }
        public T pop() { if(is_empty()) throw new EmptyStackException(); return list.removeFirst(); }
        public T peek() { if(is_empty()) throw new EmptyStackException(); return list.getFirst(); }
        public boolean is_empty() { return list.isEmpty(); }
    }

    // Clase Cola Genérica
    public static class Cola<T> {
        private final LinkedList<T> list = new LinkedList<>();
        public void enqueue(T val) { list.addLast(val); }
        public T dequeue() { if(is_empty()) throw new NoSuchElementException(); return list.removeFirst(); }
        public T peek() { if(is_empty()) throw new NoSuchElementException(); return list.getFirst(); }
        public boolean is_empty() { return list.isEmpty(); }
    }

    // Aplicación Pila: Validar Paréntesis Balanceados
    public static boolean parentesisBalanceados(String expr) {
        Pila<Character> pila = new Pila<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') pila.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (pila.is_empty()) return false;
                char top = pila.pop();
                if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) return false;
            }
        }
        return pila.is_empty();
    }

    // Aplicación Cola: Simulador de Fila de Banco
    public static void simularFilaBanco(List<String> clientes) {
        Cola<String> fila = new Cola<>();
        clientes.forEach(fila::enqueue);
        int turno = 1;
        while (!fila.is_empty()) {
            System.out.println("Turno #" + (turno++) + ": Atendiendo a " + fila.dequeue());
        }
    }
}
