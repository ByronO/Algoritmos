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
    private ArrayList<Palabra> palabras = new ArrayList<>();

    public Arbol() {
        this.raiz = null;
    }

    public void agregar(Palabra palabra) {
        Nodo nuevo = new Nodo(palabra);
        insertar(nuevo, this.raiz);
    }

//    public Nodo insertar(Nodo nuevo, Nodo temp) {
//        Nodo previous;
//        if (this.raiz == null) {
//            raiz = nuevo;
//        } else if (nuevo.getPalabra().getAscii() < temp.getPalabra().getAscii()) {
//            temp.setIzq(insertar(nuevo, temp.getIzq()));
//            if (height(temp.getIzq()) - height(temp.getDer()) == 2) {
//                if (nuevo.getPalabra().getAscii() < temp.getIzq().getPalabra().getAscii()) {
//                    temp = rotateWithLeftChild(temp); /* Caso 1 */
//                } else {
//                    temp = doubleWithLeftChild(temp); /* Caso 2 */
//                }
//            }
//        } else if (nuevo.getPalabra().getAscii() > temp.getPalabra().getAscii()) {
//            temp.setDer(insertar(nuevo, temp.getDer()));
//            if (height(temp.getDer()) - height(temp.getIzq()) == 2) {
//                if (nuevo.getPalabra().getAscii() < temp.getDer().getPalabra().getAscii()) {
//                    temp = rotateWithRightChild(temp); /* Caso 4 */
//                } else {
//                    temp = doubleWithRightChild(temp); /* Caso 3 */
//                }
//            }
//        } 
//        temp.setHeight(max(height( temp.getIzq() ), height( temp.getDer() ) ) + 1);
//        return temp;
//    }

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
    
    
    private static int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    private static Nodo rotateWithLeftChild(Nodo k2) {
        Nodo k1 = k2.getIzq();
        k2.setIzq(k1.getDer());
        k1.setDer(k2);
        k2.setHeight(max(height(k2.getIzq()), height(k2.getDer())) + 1);
        k1.setHeight(max(height(k1.getIzq()), k2.getHeight()) + 1);
        return k1;
    }

    private static Nodo rotateWithRightChild(Nodo k1) {
        Nodo k2 = k1.getDer();
        k1.setDer(k2.getIzq());
        k2.setIzq(k1);
        k1.setHeight(max(height(k1.getIzq()), height(k1.getDer())) + 1);
        k2.setHeight(max(height(k2.getDer()), k1.getHeight()) + 1);
        return k2;
    }

    private static Nodo doubleWithLeftChild(Nodo k3) {
        k3.setIzq(rotateWithRightChild(k3.getIzq()));
        return rotateWithLeftChild(k3);
    }

    private static Nodo doubleWithRightChild(Nodo k1) {
        k1.setDer(rotateWithLeftChild(k1.getDer()));
        return rotateWithRightChild(k1);
    }

    private static int height(Nodo t) {
        return t == null ? -1 : t.getHeight();
    }

    public void printTree1() {
        Nodo temp = this.raiz;
        printTree(temp);
    }

    public void printTree(Nodo temp) {
        if (temp != null) {
            printTree(temp.getIzq());
            printTree(temp.getDer());
        }
    }

    public ArrayList<Palabra> recorrerArbol1() {
        Nodo temp = this.raiz;
        recorrerArbol(temp);

        return palabras;
    }

    public ArrayList<Palabra> recorrerArbol(Nodo temp) {

//        ArrayList<Palabra> palabras = new ArrayList<Palabra>();
        if (temp != null) {
//            System.out.println(temp.getPalabra().toString());

            palabras.add(temp.getPalabra());
            recorrerArbol(temp.getIzq());
            recorrerArbol(temp.getDer());
        }

        return this.palabras;

    }

    public Nodo getRaiz() {
        return raiz;
    }

}
