/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author byron
 */
public class Nodo {

    private Palabra palabra;
    private Nodo izq, der;

    private Graphics2D g2;

    public Nodo(Palabra palabra, Nodo izq, Nodo der) {
        this.palabra = palabra;
        this.izq = izq;
        this.der = der;
    }

    public Nodo(Palabra palabra) {
        this.palabra = palabra;
    }

    public Nodo() {
    }

    public Palabra getPalabra() {
        return palabra;
    }

    public void setPalabra(Palabra palabra) {
        this.palabra = palabra;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public void draw(Graphics g, int x, int y) {
        this.g2 = (Graphics2D) g;
        String a = this.palabra.getPalabra();
        a += this.palabra.getPosiciones();
        g2.setColor(Color.green);
        g2.fillOval(x, y, 100, 50);
        g2.setColor(Color.BLACK);
        g2.drawString(a, x + 15, y + 30);
//        g2.drawLine(x+80, y+50, x+140, y+70);
    }

    public void drawIzquierda(Graphics g, int x, int y) {
        this.g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.drawLine(x + 50, y + 50, x - 50, y + 100);

    }

    public void drawDerecha(Graphics g, int x, int y) {
        this.g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.drawLine(x + 50, y + 50, x + 150, y + 100);

    }
}
