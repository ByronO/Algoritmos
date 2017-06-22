/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import Domain.Arbol;

/**
 *
 * @author armando
 */
public class Grafico extends JFrame {

    public Grafico(String texto) {
        super();
        this.dispose();
        this.setSize(600, 450);
        this.setVisible(true);
        pintarTexto(texto);
    }

    public Grafico(Arbol arbol) {
        super();
        this.dispose();
        this.setSize(1300, 750);
        this.setVisible(true);
        this.add(new PintarArbol(arbol));
    }

    private void pintarTexto(String texto) {
        JTextArea area = new JTextArea(texto);
        area.setBounds(100, 100, 600, 450);
        area.setLineWrap(true);
        this.add(area);
    }

}
