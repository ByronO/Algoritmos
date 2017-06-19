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
public class Nodo {
    
    private Palabra palabra;
    private Nodo izq, der;

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
}
