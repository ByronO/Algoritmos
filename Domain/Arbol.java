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
    private int position;

    public Arbol() {
        this.raiz = null;
        this.position = 0;
    }

    public void agregar(Palabra palabra) {
        Nodo nuevo = new Nodo(palabra);
        insertar(nuevo, this.raiz);
    }

//    public Nodo insertar(Nodo nuevo, Nodo temp) {
//        Nodo aux = temp;
//        if (this.raiz == null) {
//            raiz = nuevo;
//        } else if (nuevo.getPalabra().getAscii() < temp.getPalabra().getAscii()) {
//            temp.izq = insertar(nuevo, temp.izq);
//            if (height(temp.izq) - height(temp.der) == 2) {
//                if (nuevo.getPalabra().getAscii() < temp.izq.getPalabra().getAscii()) {
//                    aux = rotateWithLeftChild(temp);
//                } else {
//                    aux = doubleWithLeftChild(temp); 
//                }
//            }
//        } else if (nuevo.getPalabra().getAscii() > temp.getPalabra().getAscii()) {
//            temp.der = insertar(nuevo, temp.der);
//            if (height(temp.der) - height(temp.izq) == 2) {
//                if (nuevo.getPalabra().getAscii() < temp.der.getPalabra().getAscii()) {
//                    aux = rotateWithRightChild(temp); 
//                } else {
//                    aux = doubleWithRightChild(temp); 
//                }
//            }
//        } 
//        if(temp.izq.height > temp.der.height){
//            temp.height = temp.izq.height +1;
//        }else
//
//        temp.height = Math.max(height(temp.izq), height(temp.der)) + 1;
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
//    private static int max(int lhs, int rhs) {
//        return lhs > rhs ? lhs : rhs;
//    }
    private static Nodo rotateWithLeftChild(Nodo k2) {
        Nodo k1 = k2.izq;
        k2.izq = k1.der;
        k1.der = k2;
        k2.height = Math.max(height(k2.izq), height(k2.der)) + 1;
        k1.height = Math.max(height(k1.izq), k2.height) + 1;
        return k1;
    }

    private static Nodo rotateWithRightChild(Nodo k1) {
        Nodo k2 = k1.der;
        k1.der = k2.izq;
        k2.izq = k1;
        k1.height = Math.max(height(k1.izq), height(k1.der)) + 1;
        k2.height = Math.max(height(k2.der), k1.height) + 1;
        return k2;
    }

    private static Nodo doubleWithLeftChild(Nodo k3) {
        k3.izq = rotateWithRightChild(k3.izq);
        return rotateWithLeftChild(k3);
    }

    private static Nodo doubleWithRightChild(Nodo k1) {
        k1.der = rotateWithLeftChild(k1.der);
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
