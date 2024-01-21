/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinciclo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author yixon
 */
public class Graficar extends JPanel {

    private final abb arbol;

    public static final int DIAMETRO = 40;
    public static int RADIO = DIAMETRO / 2;
    public static final int ANCHO = 50;

    public Graficar(abb arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        paintABB(g);
    }

    private void paintABB(Graphics g) {
        paintABB(g, getWidth() / 2, 20, arbol.getRaizabb());
    }

    private void paintABB(Graphics g, int x, int y, Nodo r) {
        if (r == null) {
            return;
        }

        g.setColor(Color.YELLOW);
        int EXTRA = arbol.nodosCompletosabb(r) * (ANCHO / 2);
        g.fillOval(x, y, DIAMETRO, DIAMETRO);

        g.setColor(Color.BLACK);
        g.drawString(r.getDatoabb() + "", x + 10, y + 20);

        g.setColor(Color.BLACK);

        if (r.getIzqabb() != null) {
            g.drawLine(x + RADIO - 5, y + RADIO + 15, x - ANCHO - EXTRA + RADIO, y - 15 + ANCHO + RADIO);
        }

        if (r.getDerabb() != null) {
            g.drawLine(x + RADIO - 5, y + RADIO + 15, x + ANCHO + EXTRA + RADIO, y - 15 + ANCHO + RADIO);
        }

        paintABB(g, x - ANCHO - EXTRA, y + ANCHO, r.getIzqabb());
        paintABB(g, x + ANCHO + EXTRA, y + ANCHO, r.getDerabb());
    }
}
