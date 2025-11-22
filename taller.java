class Nodo {
    int dato;
    Nodo izquierdo;
    Nodo derecho;
    
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class NodoChar {
    char dato;
    NodoChar izquierdo;
    NodoChar derecho;
    
    public NodoChar(char dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class ArbolBinarioBusqueda {
    Nodo raiz;
    
    public ArbolBinarioBusqueda() {
        this.raiz = null;
    }
    
    public void insertar(int dato) {
        raiz = insertarRecursivo(raiz, dato);
    }
    
    private Nodo insertarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            return new Nodo(dato);
        }
        
        if (dato < nodo.dato) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = insertarRecursivo(nodo.derecho, dato);
        }
        
        return nodo;
    }
    
    public boolean buscar(int dato) {
        StringBuilder recorrido = new StringBuilder();
        boolean encontrado = buscarRecursivo(raiz, dato, recorrido);
        System.out.print("Recorrido: " + recorrido.toString());
        System.out.println(" - " + (encontrado ? "ENCONTRADO" : "NO ENCONTRADO"));
        return encontrado;
    }
    
    private boolean buscarRecursivo(Nodo nodo, int dato, StringBuilder recorrido) {
        if (nodo == null) {
            return false;
        }
        
        if (recorrido.length() > 0) {
            recorrido.append(" → ");
        }
        recorrido.append(nodo.dato);
        
        if (dato == nodo.dato) {
            return true;
        } else if (dato < nodo.dato) {
            return buscarRecursivo(nodo.izquierdo, dato, recorrido);
        } else {
            return buscarRecursivo(nodo.derecho, dato, recorrido);
        }
    }
  
    public void eliminar(int dato) {
        raiz = eliminarRecursivo(raiz, dato);
    }
  
    private Nodo eliminarRecursivo(Nodo nodo, int dato) {
        if (nodo == null) {
            return null;
        }
        
        if (dato < nodo.dato) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, dato);
        } else
        {
            if (nodo.izquierdo == null && nodo.derecho == null) {
                return null;
            }
         
            if (nodo.izquierdo == null) {
                return nodo.derecho;
            }
            if (nodo.derecho == null) {
                return nodo.izquierdo;
            }
         
            int sucesor = encontrarMinimo(nodo.derecho);
            nodo.dato = sucesor;
            nodo.derecho = eliminarRecursivo(nodo.derecho, sucesor);
        }
        
        return nodo;
    }
    
    private int encontrarMinimo(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo.dato;
    }
    
    public void imprimirInorden() {
        System.out.print("Recorrido Inorden: ");
        imprimirInordenRecursivo(raiz);
        System.out.println();
    }
    
    private void imprimirInordenRecursivo(Nodo nodo) {
        if (nodo != null) {
            imprimirInordenRecursivo(nodo.izquierdo);
            System.out.print(nodo.dato + " ");
            imprimirInordenRecursivo(nodo.derecho);
        }
    }
  
    public void visualizar() {
        visualizarRecursivo(raiz, "", true);
    }
    
    private void visualizarRecursivo(Nodo nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.dato);
            
            if (nodo.izquierdo != null || nodo.derecho != null) {
                if (nodo.izquierdo != null) {
                    visualizarRecursivo(nodo.izquierdo, prefijo + (esUltimo ? "    " : "│   "), nodo.derecho == null);
                }
                if (nodo.derecho != null) {
                    visualizarRecursivo(nodo.derecho, prefijo + (esUltimo ? "    " : "│   "), true);
                }
            }
        }
    }
}


class ArbolBinarioBusquedaChar {
    NodoChar raiz;
    
    public ArbolBinarioBusquedaChar() {
        this.raiz = null;
    }
    
    public void insertar(char dato) {
        raiz = insertarRecursivo(raiz, dato);
    }
    
    private NodoChar insertarRecursivo(NodoChar nodo, char dato) {
        if (nodo == null) {
            return new NodoChar(dato);
        }
        
        if (dato < nodo.dato) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, dato);
        } else if (dato > nodo.dato) {
            nodo.derecho = insertarRecursivo(nodo.derecho, dato);
        }
        
        return nodo;
    }
    
    public boolean buscar(char dato) {
        StringBuilder recorrido = new StringBuilder();
        boolean encontrado = buscarRecursivo(raiz, dato, recorrido);
        System.out.print("Recorrido: " + recorrido.toString());
        System.out.println(" - " + (encontrado ? "ENCONTRADO" : "NO ENCONTRADO"));
        return encontrado;
    }
    
    private boolean buscarRecursivo(NodoChar nodo, char dato, StringBuilder recorrido) {
        if (nodo == null) {
            return false;
        }
        
        if (recorrido.length() > 0) {
            recorrido.append(" → ");
        }
        recorrido.append(nodo.dato);
        
        if (dato == nodo.dato) {
            return true;
        } else if (dato < nodo.dato) {
            return buscarRecursivo(nodo.izquierdo, dato, recorrido);
        } else {
            return buscarRecursivo(nodo.derecho, dato, recorrido);
        }
    }
    
    public void visualizar() {
        visualizarRecursivo(raiz, "", true);
    }
    
    private void visualizarRecursivo(NodoChar nodo, String prefijo, boolean esUltimo) {
        if (nodo != null) {
            System.out.println(prefijo + (esUltimo ? "└── " : "├── ") + nodo.dato);
            
            if (nodo.izquierdo != null || nodo.derecho != null) {
                if (nodo.izquierdo != null) {
                    visualizarRecursivo(nodo.izquierdo, prefijo + (esUltimo ? "    " : "│   "), nodo.derecho == null);
                }
                if (nodo.derecho != null) {
                    visualizarRecursivo(nodo.derecho, prefijo + (esUltimo ? "    " : "│   "), true);
                }
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        
        System.out.println("========================================");
        System.out.println("ÁRBOL A: {10,43,24,-10,54,0,23,82,43}");
        System.out.println("========================================");
        
        ArbolBinarioBusqueda arbolA = new ArbolBinarioBusqueda();
        int[] clavesA = {10, 43, 24, -10, 54, 0, 23, 82, 43};
        
        for (int clave : clavesA) {
            arbolA.insertar(clave);
        }
        
        System.out.println("\nEstructura del Árbol A:");
        arbolA.visualizar();
        arbolA.imprimirInorden();
        
        System.out.println("\n--- Búsquedas en Árbol A ---");
        System.out.print("Buscar 22: ");
        arbolA.buscar(22);
        System.out.print("Buscar 0: ");
        arbolA.buscar(0);
        System.out.print("Buscar 24: ");
        arbolA.buscar(24);
        System.out.print("Buscar 23: ");
        arbolA.buscar(23);
        
        System.out.println("\n--- Adicionar claves al Árbol A: {-5,-3,22,44} ---");
        int[] adicionarA = {-5, -3, 22, 44};
        for (int clave : adicionarA) {
            arbolA.insertar(clave);
        }
        System.out.println("Árbol A después de adicionar:");
        arbolA.visualizar();
        arbolA.imprimirInorden();
        
        System.out.println("\n--- Eliminar claves del Árbol A: {10,54,82} ---");
        arbolA.eliminar(10);
        arbolA.eliminar(54);
        arbolA.eliminar(82);
        System.out.println("Árbol A después de eliminar:");
        arbolA.visualizar();
        arbolA.imprimirInorden();
        
      
        System.out.println("\n\n========================================");
        System.out.println("ÁRBOL B: {32,67,43,25,52,56,78,64,23,67}");
        System.out.println("========================================");
        
        ArbolBinarioBusqueda arbolB = new ArbolBinarioBusqueda();
        int[] clavesB = {32, 67, 43, 25, 52, 56, 78, 64, 23, 67};
        
        for (int clave : clavesB) {
            arbolB.insertar(clave);
        }
        
        System.out.println("\nEstructura del Árbol B:");
        arbolB.visualizar();
        arbolB.imprimirInorden();
        
        System.out.println("\n--- Búsquedas en Árbol B ---");
        System.out.print("Buscar 23: ");
        arbolB.buscar(23);
        System.out.print("Buscar 24: ");
        arbolB.buscar(24);
        System.out.print("Buscar 25: ");
        arbolB.buscar(25);
        
        System.out.println("\n--- Adicionar claves al Árbol B: {24,26,27} ---");
        int[] adicionarB = {24, 26, 27};
        for (int clave : adicionarB) {
            arbolB.insertar(clave);
        }
        System.out.println("Árbol B después de adicionar:");
        arbolB.visualizar();
        arbolB.imprimirInorden();
        
       
        System.out.println("\n\n========================================");
        System.out.println("ÁRBOL C: {A,Y,E,F,G,X,W,U,Z,R,B}");
        System.out.println("========================================");
        
        ArbolBinarioBusquedaChar arbolC = new ArbolBinarioBusquedaChar();
        char[] clavesC = {'A', 'Y', 'E', 'F', 'G', 'X', 'W', 'U', 'Z', 'R', 'B'};
        
        for (char clave : clavesC) {
            arbolC.insertar(clave);
        }
        
        System.out.println("\nEstructura del Árbol C:");
        arbolC.visualizar();
        
        System.out.println("\n--- Búsquedas en Árbol C ---");
        System.out.print("Buscar U: ");
        arbolC.buscar('U');
        System.out.print("Buscar V: ");
        arbolC.buscar('V');
        System.out.print("Buscar W: ");
        arbolC.buscar('W');
        
        System.out.println("\n--- Adicionar claves al Árbol C: {L,M,N,O} ---");
        char[] adicionarC = {'L', 'M', 'N', 'O'};
        for (char clave : adicionarC) {
            arbolC.insertar(clave);
        }
        System.out.println("Árbol C después de adicionar:");
        arbolC.visualizar();
        
        System.out.println("\n========================================");
        System.out.println("FIN DE LA EJECUCIÓN");
        System.out.println("========================================");
    }
}
