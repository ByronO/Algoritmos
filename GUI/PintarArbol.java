package GUI;

import Domain.Arbol;
import Domain.Nodo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author armando
 */
public class PintarArbol extends JPanel {

    private Graphics2D g2;
    private Arbol arbol;

    public PintarArbol(Arbol arbol) {
        this.setBounds(0, 0, 900, 800);
        this.setVisible(true);
        this.arbol = arbol;

    }

    @Override
    protected void paintComponent(Graphics g) {
        int x = 600, y = 0;
        this.g2 = (Graphics2D) g;
        pintarArbol(this.arbol.getRaiz(), x, y);
        pintarArbol1(this.arbol.getRaiz(), x, y);
        pintarArbol2(this.arbol.getRaiz(), x, y);

    }

    private void pintarArbol(Nodo temp, int x, int y) {
        if (temp != null) {
            temp.draw(g2, x, y);
            pintarArbol(temp.getIzq(), x - 100, y + 100);
            pintarArbol(temp.getDer(), x + 100, y + 100);
        }
    }

    private void pintarArbol1(Nodo temp, int x, int y) {
        if (temp.getIzq() != null) {
            temp.draw2(g2, x, y);
            pintarArbol1(temp.getIzq(), x - 100, y + 100);

        }
    }

    private void pintarArbol2(Nodo temp, int x, int y) {
        if (temp.getDer() != null) {
            temp.draw3(g2, x, y);

            pintarArbol1(temp.getDer(), x + 100, y + 100);

        }
    }

}//class
