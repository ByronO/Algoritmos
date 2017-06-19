/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author byron
 */
public class Palabra {
    
    private String palabra;
    private int ascii;
    private ArrayList<Integer> posiciones;

    public Palabra(String palabra, int ascii, ArrayList<Integer> posiciones) {
        this.palabra = palabra;
        this.ascii = ascii;
        this.posiciones = posiciones;
    }

    public Palabra(String palabra) {
        this.palabra = palabra;
    }
    
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
        
    }

    public int getAscii() {
        return ascii;
    }

    public void setAscii(int ascii) {
        this.ascii = ascii;
    }

    public ArrayList<Integer> getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(ArrayList<Integer> posiciones) {
        this.posiciones = posiciones;
    }

    @Override
    public String toString() {
        return "Palabra{" + "palabra=" + palabra + ", ascii=" + ascii + ", posiciones=" + posiciones + '}';
    }
    
}
