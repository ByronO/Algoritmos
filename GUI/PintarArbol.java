package GUI;

import Domain.Arbol;
import Domain.Nodo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author armando
 */
public class PintarArbol extends JPanel {

    private Graphics2D g2;
    private Arbol arbol;
    private JScrollPane jScrollPane;

    public PintarArbol(Arbol arbol) {
        this.setBounds(0, 0, 10000, 8000);
        this.setVisible(true);
        this.arbol = arbol;
//        this.jScrollPane = new JScrollPane(this);
////        this.jScrollPane.add(this);
//        this.add(jScrollPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int x = 600, y = 0;
        this.g2 = (Graphics2D) g;
        pintarArbol(this.arbol.getRaiz(), x, y);
        pintarArbol1(this.arbol.getRaiz(), x, y);

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
            temp.drawIzquierda(g2, x, y);
            pintarArbol1(temp.getIzq(), x - 100, y + 100);

        }
        if (temp.getDer() != null) {
            temp.drawDerecha(g2, x, y);

            pintarArbol1(temp.getDer(), x + 100, y + 100);
        }
    }

}//class
