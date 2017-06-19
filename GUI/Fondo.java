/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author armando
 */
public class Fondo extends JPanel {

    private BufferedImage imagen;
    private Graphics2D g2;

    public Fondo() {

        try {
            this.setBounds(0, 0, 900, 800);
            this.setVisible(true);

            this.imagen = ImageIO.read(getClass().getResourceAsStream("/Assets/a.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Fondo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(this.imagen, 1, 1, 810, 600, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        this.g2 = (Graphics2D) g;
        draw(g2);
    }

}
