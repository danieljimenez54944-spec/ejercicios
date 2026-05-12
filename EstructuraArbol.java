public class EstructuraArbol {

    public static class NodoArbol {
        int valor; NodoArbol izquierdo, derecho;
        public NodoArbol(int v) { this.valor = v; }
    }

    public static class ArbolBinario {
        NodoArbol raiz;

        public void insertar(int val) { raiz = insertarRec(raiz, val); }
        private NodoArbol insertarRec(NodoArbol r, int val) {
            if (r == null) return new NodoArbol(val);
            if (val < r.valor) r.izquierdo = insertarRec(r.izquierdo, val);
            else if (val > r.valor) r.derecho = insertarRec(r.derecho, val);
            return r;
        }

        public boolean buscar(int val) { return buscarRec(raiz, val); }
        private boolean buscarRec(NodoArbol r, int val) {
            if (r == null) return false;
            if (r.valor == val) return true;
            return val < r.valor ? buscarRec(r.izquierdo, val) : buscarRec(r.derecho, val);
        }

        public void eliminar(int val) { raiz = eliminarRec(raiz, val); }
        private NodoArbol eliminarRec(NodoArbol r, int val) {
            if (r == null) return null;
            if (val < r.valor) r.izquierdo = eliminarRec(r.izquierdo, val);
            else if (val > r.valor) r.derecho = eliminarRec(r.derecho, val);
            else {
                if (r.izquierdo == null) return r.derecho;
                if (r.derecho == null) return r.izquierdo;
                r.valor = minValor(r.derecho);
                r.derecho = eliminarRec(r.derecho, r.valor);
            }
            return r;
        }

        private int minValor(NodoArbol r) {
            int min = r.valor;
            while (r.izquierdo != null) { min = r.izquierdo.valor; r = r.izquierdo; }
            return min;
        }

        // Recorridos
        public void inorden() { inordenRec(raiz); System.out.println(); }
        private void inordenRec(NodoArbol r) { if(r != null) { inordenRec(r.izquierdo); System.out.print(r.valor + " "); inordenRec(r.derecho); } }

        public void preorden() { preordenRec(raiz); System.out.println(); }
        private void preordenRec(NodoArbol r) { if(r != null) { System.out.print(r.valor + " "); preordenRec(r.izquierdo); preordenRec(r.derecho); } }

        public void postorden() { postordenRec(raiz); System.out.println(); }
        private void postordenRec(NodoArbol r) { if(r != null) { postordenRec(r.izquierdo); postordenRec(r.derecho); System.out.print(r.valor + " "); } }

        public int obtenerAltura() { return obtenerAlturaRec(raiz); }
        private int obtenerAlturaRec(NodoArbol r) {
            if (r == null) return 0;
            return 1 + Math.max(obtenerAlturaRec(r.izquierdo), obtenerAlturaRec(r.derecho));
        }
    }
}
