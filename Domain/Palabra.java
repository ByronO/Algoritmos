/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author byron
 */
public class Palabra {
    
    private String palabra;
    private int cantidad, ascii;
    private int []psiciones;

    public Palabra(String palabra, int cantidad, int ascii, int[] psiciones) {
        this.palabra = palabra;
        this.cantidad = cantidad;
        this.ascii = ascii;
        this.psiciones = psiciones;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
        
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getAscii() {
        return ascii;
    }

    public void setAscii(int ascii) {
        this.ascii = ascii;
    }

    public int[] getPsiciones() {
        return psiciones;
    }

    public void setPsiciones(int[] psiciones) {
        this.psiciones = psiciones;
    }

    @Override
    public String toString() {
        return "Palabra{" + "palabra=" + palabra + ", cantidad=" + cantidad + ", ascii=" + ascii + ", psiciones=" + psiciones + '}';
    }
    
    
    
}
