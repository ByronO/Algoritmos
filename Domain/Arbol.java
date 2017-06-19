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
public class Arbol {

    private Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void agregar(Palabra palabra) {
        Nodo nuevo = new Nodo(palabra);
        insertar(nuevo, this.raiz);
    }

    public void insertar(Nodo nuevo, Nodo temp) {
        Nodo previous;
        if (this.raiz == null) {
            raiz = nuevo;
        } else {
            temp = this.raiz;
            previous = null;
            while (temp != null) {
                previous = temp;
                if (nuevo.getPalabra().getAscii() < temp.getPalabra().getAscii()) {
                    temp = temp.getIzq();
                } else {
                    temp = temp.getDer();
                }
            }

            if (nuevo.getPalabra().getAscii() < previous.getPalabra().getAscii()) {
                previous.setIzq(nuevo);
            } else {
                previous.setDer(nuevo);
            }
        }

    }

    public void printTree1() {
        Nodo temp = this.raiz;

        printTree(temp);
    }

    public void printTree(Nodo temp) {
        if (temp != null) {
            System.out.println(temp.getPalabra().toString());
            printTree(temp.getIzq());
            printTree(temp.getDer());
        }
    }

    public ArrayList<Nodo> recorrerArbol1() {
        Nodo temp = this.raiz;
        ArrayList<Nodo> nodos = recorrerArbol(temp);

        return nodos;
    }

    public ArrayList<Nodo> recorrerArbol(Nodo temp) {

        ArrayList<Nodo> nodos = new ArrayList<Nodo>();
        if (temp != null) {
            nodos.add(temp);
            recorrerArbol(temp.getIzq());
            recorrerArbol(temp.getDer());
        }
        return nodos;
    }

    public Nodo getRaiz() {
        return raiz;
    }

}
