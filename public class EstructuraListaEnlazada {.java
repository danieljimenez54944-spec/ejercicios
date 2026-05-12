public class EstructuraListaEnlazada {

    public static class Nodo {
        int dato; Nodo siguiente;
        public Nodo(int d) { this.dato = d; this.siguiente = null; }
    }

    public static class ListaEnlazada {
        Nodo cabeza;

        public void insertar(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (cabeza == null) { cabeza = nuevo; return; }
            Nodo temp = cabeza;
            while (temp.siguiente != null) { temp = temp.siguiente; }
            temp.siguiente = nuevo;
        }

        public void eliminar(int dato) {
            if (cabeza == null) return;
            if (cabeza.dato == dato) { cabeza = cabeza.siguiente; return; }
            Nodo temp = cabeza;
            while (temp.siguiente != null && temp.siguiente.dato != dato) { temp = temp.siguiente; }
            if (temp.siguiente != null) temp.siguiente = temp.siguiente.siguiente;
        }

        public boolean buscar(int dato) {
            Nodo temp = cabeza;
            while (temp != null) {
                if (temp.dato == dato) return true;
                temp = temp.siguiente;
            }
            return false;
        }

        public void invertir() {
            Nodo previo = null, actual = cabeza, siguiente = null;
            while (actual != null) {
                siguiente = actual.siguiente;
                actual.siguiente = previo;
                previo = actual;
                actual = siguiente;
            }
            cabeza = previo;
        }

        // Detectar ciclos (Algoritmo de la Liebre y la Tortuga de Floyd)
        public boolean detectarCiclos() {
            Nodo tortuga = cabeza, liebre = cabeza;
            while (liebre != null && liebre.siguiente != null) {
                tortuga = tortuga.siguiente;
                liebre = liebre.siguiente.siguiente;
                if (tortuga == liebre) return true;
            }
            return false;
        }

        public int obtenerEnPosicion(int n) {
            Nodo temp = cabeza;
            int cont = 0;
            while (temp != null) {
                if (cont == n) return temp.dato;
                cont++;
                temp = temp.siguiente;
            }
            throw new IndexOutOfBoundsException("Posición fuera de rango");
        }
    }
}
