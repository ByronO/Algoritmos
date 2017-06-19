/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author byron
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private JMenuBar jMenuBar;
    private JMenu jMenu;
    private JMenuItem jmiDeTextoAArbol, jmiDeArbolATexto, jmiArchivo;
    private JFileChooser fileChooser;

    public VentanaPrincipal() {
        super();
        this.jMenuBar = new JMenuBar();
        this.jMenu = new JMenu("Menu");
        this.jmiDeTextoAArbol = new JMenuItem("Pasar texto a árbol");
        this.jmiDeArbolATexto = new JMenuItem("Pasar árbol a texto");
        this.jmiArchivo = new JMenuItem("Buscar archivo");
        this.setJMenuBar(this.jMenuBar);
        this.add(new Fondo());
        this.setResizable(false);

        init();

    }//Constructor

    public void init() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 650);
        this.jMenuBar.add(this.jMenu);
        this.jMenu.add(this.jmiArchivo);
        this.jMenu.add(this.jmiDeTextoAArbol);
        this.jMenu.add(this.jmiDeArbolATexto);

        this.jmiArchivo.addActionListener(this);
        this.jmiDeArbolATexto.addActionListener(this);
        this.jmiDeTextoAArbol.addActionListener(this);

        this.setJMenuBar(this.jMenuBar);

        this.jmiDeTextoAArbol.setVisible(false);
        this.jmiDeArbolATexto.setVisible(false);

    }//init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jmiArchivo) {
            this.fileChooser = new JFileChooser();
            this.fileChooser.showOpenDialog(null);
            File file = this.fileChooser.getSelectedFile();
            if (file != null) {
                if (file.getPath().toLowerCase().indexOf(".txt") != -1) {
                    JOptionPane.showMessageDialog(null, "Archivo cargado");
                    this.jmiDeTextoAArbol.setVisible(true);
                    this.jmiDeArbolATexto.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "El archivo no es valido");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un archivo para ver las nuevas opciones", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }//if

        if (e.getSource() == this.jmiDeArbolATexto) {
            Grafico g = new Grafico();
            g.setVisible(true);
        }
        if (e.getSource() == this.jmiDeTextoAArbol) {
            Grafico g = new Grafico();
            g.setVisible(true);
        }
    }//actionPerformed

}
