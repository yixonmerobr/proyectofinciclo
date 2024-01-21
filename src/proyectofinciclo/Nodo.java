/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinciclo;

/**
 *
 * @author yixon
 */
public class Nodo {

    private int datoabb;
    private Nodo izqabb, derabb;

    public Nodo(int dato) {
        this.datoabb = dato;
        this.izqabb = this.derabb = null;
    }

    public int getDatoabb() {
        return datoabb;
    }

    public void setDatoabb(int datoabb) {
        this.datoabb = datoabb;
    }

    public Nodo getIzqabb() {
        return izqabb;
    }

    public void setIzqabb(Nodo izqabb) {
        this.izqabb = izqabb;
    }

    public Nodo getDerabb() {
        return derabb;
    }

    public void setDerabb(Nodo derabb) {
        this.derabb = derabb;
    }
}
