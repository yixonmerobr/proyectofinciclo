/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinciclo;

import javax.swing.JFrame;

/**
 *
 * @author yixon
 */
public class abb {

    private Nodo raizabb;
    private Nodo raizavl;

    public abb() {
        this.raizabb = this.raizavl = null;
    }

    public Nodo getRaizabb() {
        return raizabb;
    }

    public Nodo getRaizavl() {
        return raizavl;
    }

    private boolean esVacia() {
        return raizabb == null;
    }

    public void insertarabb(int dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            raizabb = nuevo;
            System.out.println("Dato " + nuevo.getDatoabb() + " insertado con "
                    + " éxito como raíz del árbol");
        } else {
            insertarNodoabb(raizabb, nuevo);
        }

    }

    private void insertarNodoabb(Nodo r, Nodo nuevo) {
        if (nuevo.getDatoabb() < r.getDatoabb()) {
            if (r.getIzqabb() == null) {
                r.setIzqabb(nuevo);
                System.out.println("Dato " + nuevo.getDatoabb() + " insertado con "
                        + " éxito a la izquierda del: " + r.getDatoabb());
            } else {
                insertarNodoabb(r.getIzqabb(), nuevo);
            }
        } else if (nuevo.getDatoabb() > r.getDatoabb()) {
            if (r.getDerabb() == null) {
                r.setDerabb(nuevo);
                System.out.println("Dato " + nuevo.getDatoabb() + " insertado con "
                        + " éxito a la derecha del: " + r.getDatoabb());
            } else {
                insertarNodoabb(r.getDerabb(), nuevo);

            }
        } else {
            System.out.println("El dato " + nuevo.getDatoabb() + " está repetido....");
        }
    }

    public void RecPreOrdenabb() {
        if (esVacia()) {
            System.out.println("Árbol está vacio....");
        } else {

            mostrarPreordenabb(raizabb);
        }
    }

    private void mostrarPreordenabb(Nodo r) {
        if (r == null) {
            return;
        } else {
            System.out.print(r.getDatoabb() + " ");
            mostrarPreordenabb(r.getIzqabb());
            mostrarPreordenabb(r.getDerabb());
        }
    }

    public void RecPosOrdenabb() {
        if (esVacia()) {
            System.out.println("Árbol está vacio....");
        } else {
            mostrarPosordenabb(raizabb);
        }
    }

    private void mostrarPosordenabb(Nodo r) {
        if (r == null) {
            return;
        } else {
            mostrarPosordenabb(r.getIzqabb());
            mostrarPosordenabb(r.getDerabb());
            System.out.print(r.getDatoabb() + " ");

        }
    }

    public void RecInOrdenabb() {
        if (esVacia()) {
            System.out.println("Árbol está vacio....");
        } else {
            mostrarInordenabb(raizabb);
        }
    }

    private void mostrarInordenabb(Nodo r) {
        if (r == null) {
            return;
        } else {
            mostrarInordenabb(r.getIzqabb());
            System.out.print(r.getDatoabb() + " ");
            mostrarInordenabb(r.getDerabb());

        }
    }

    public void existe(int dato) {
        Nodo aux = raizabb;
        if (esVacia()) {
            System.out.println("El árbol está vacio");
            //return;
        } else {
            while (aux != null) {
                if (aux.getDatoabb() == dato) {
                    System.out.println("El Valor " + dato + " existe!!!");
                    return;
                } else if (dato < aux.getDatoabb()) {
                    aux = aux.getIzqabb();
                } else {
                    aux = aux.getDerabb();
                }
            }
            System.out.println("El Valor " + dato + " no se encuentra en árbol");
        }
    }

    // Graficar árbol
    public void graficarabb() {
        Graficar Migrafico = new Graficar(this);
        JFrame ventana = new JFrame("Mi ABB");
        ventana.getContentPane().add(Migrafico);
        ventana.setDefaultCloseOperation(2);
        ventana.setSize(800, 600);
        ventana.setVisible(true);
    }

    public int nodosCompletosabb(Nodo r) {
        if (r == null) {
            return 0;
        } else {
            if (r.getIzqabb() != null && r.getDerabb() != null) {
                return nodosCompletosabb(r.getIzqabb()) + nodosCompletosabb(r.getDerabb()) + 1;
            }
            return nodosCompletosabb(r.getIzqabb()) + nodosCompletosabb(r.getDerabb());
        }
    }
}
