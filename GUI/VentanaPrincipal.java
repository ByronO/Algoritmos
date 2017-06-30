/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Domain.Arbol;
import Domain.Nodo;
import Data.PalabraData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private JMenu jMenuTexto, jMenuArbol;
    private JMenuItem jmiDeTextoAArbol, jmiDeArbolATexto, jmiArchivoTexto, jmiArchivoArbol, jmiBuscarEnElArbor;
    private JFileChooser fileChooserTexto, fileChooserArbol;

    private PalabraData palabraData;

    private String pathTexto, pathArbol;

    private PalabraData palabraDataTexto, palabraDataArbol;
    private Arbol arbolGenera;

    public VentanaPrincipal() {
        super();
        this.jMenuBar = new JMenuBar();
        this.jMenuTexto = new JMenu("Texto");
        this.jMenuArbol = new JMenu("Arbol");
        this.jmiDeTextoAArbol = new JMenuItem("Pasar texto a árbol");
        this.jmiDeArbolATexto = new JMenuItem("Pasar árbol a texto");
        this.jmiBuscarEnElArbor = new JMenuItem("Buscar palabra en el arbol");
        this.jmiArchivoTexto = new JMenuItem("Buscar archivo");
        this.jmiArchivoArbol = new JMenuItem("Buscar archivo");

        this.setJMenuBar(this.jMenuBar);
        this.add(new Fondo());
        this.setResizable(false);
        this.arbolGenera = new Arbol();
        init();

    }//Constructor

    public void init() {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 650);
        this.jMenuBar.add(this.jMenuTexto);
        this.jMenuBar.add(this.jMenuArbol);

        this.jMenuTexto.add(this.jmiArchivoTexto);
        this.jMenuTexto.add(this.jmiDeTextoAArbol);

        this.jMenuArbol.add(this.jmiArchivoArbol);
        this.jMenuTexto.add(this.jmiBuscarEnElArbor);
        this.jMenuArbol.add(this.jmiDeArbolATexto);

        this.jmiArchivoArbol.addActionListener(this);
        this.jmiDeArbolATexto.addActionListener(this);

        this.jmiArchivoTexto.addActionListener(this);
        this.jmiBuscarEnElArbor.addActionListener(this);
        this.jmiDeTextoAArbol.addActionListener(this);

        this.setJMenuBar(this.jMenuBar);

        this.jmiDeTextoAArbol.setVisible(false);
        this.jmiDeArbolATexto.setVisible(false);
        this.jmiBuscarEnElArbor.setVisible(false);

    }//init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jmiArchivoTexto) {
            this.fileChooserTexto = new JFileChooser();
            this.fileChooserTexto.showOpenDialog(null);
            File file = this.fileChooserTexto.getSelectedFile();
            if (file != null) {
                if (file.getPath().toLowerCase().indexOf(".txt") != -1) {
                    this.pathTexto = file.getPath();
                    JOptionPane.showMessageDialog(null, "Archivo cargado");
                    this.jmiDeTextoAArbol.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "El archivo no es valido");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un archivo para ver las nuevas opciones", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }//if
        if (e.getSource() == this.jmiArchivoArbol) {
            this.fileChooserArbol = new JFileChooser();
            this.fileChooserArbol.showOpenDialog(null);
            File file = this.fileChooserArbol.getSelectedFile();
            if (file != null) {
                if (file.getPath().toLowerCase().indexOf(".txt") != -1) {
                    this.pathArbol = file.getPath();
                    JOptionPane.showMessageDialog(null, "Archivo cargado");
                    this.jmiDeArbolATexto.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "El archivo no es valido");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un archivo para ver las nuevas opciones", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }//if

        if (e.getSource() == this.jmiDeArbolATexto) {
            palabraDataArbol = new PalabraData();

            Grafico g = new Grafico(palabraDataArbol.leerArbol(this.pathArbol));
            g.setVisible(true);
        }
        if (e.getSource() == this.jmiDeTextoAArbol) {
            try {
                this.jmiBuscarEnElArbor.setVisible(true);
                PalabraData palabraData = new PalabraData();
                palabraData.leerTexto(this.pathTexto);
                palabraData.guardarArbol();
                this.arbolGenera = palabraData.getArbol();
                Grafico g = new Grafico(palabraData.getArbol());
                g.setVisible(true);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == this.jmiBuscarEnElArbor) {
            String a = JOptionPane.showInputDialog("Escriba la palabra a buscar."); //actionPerformed
            Nodo t= this.arbolGenera.recorrerArbol2(a);
           JOptionPane.showMessageDialog(rootPane, "Palabra: "+ t.getPalabra().getPalabra()+" "+t.getPalabra().getPosiciones());
        }

    }
}
