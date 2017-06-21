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
        int x = 365, y = 0;
        this.g2 = (Graphics2D) g;
        pintarArbol(this.arbol.getRaiz(),x,y);
    }

    private void pintarArbol(Nodo temp, int x,int y) {
        System.out.println(x+","+y);
        temp.draw(g2, x, y);
        pintarArbol(temp.getIzq(),x-20,y+50);
        pintarArbol(temp.getDer(), x+20, y+50);
    }

}//class
