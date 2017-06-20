/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Arbol;
import Domain.Nodo;
import Domain.Palabra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author byron
 */
public class PalabraData {

    private String path;
    private ArrayList<Palabra> todasLasPalabras = new ArrayList<Palabra>();
    private Arbol arbol = new Arbol();

    public void leerTexto(String path) throws FileNotFoundException {
        this.path = path;

        try {
            File archivo = new File(this.path);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                Palabra palabra;
                String[] a = linea.split(" ");

                for (int i = 0; i < a.length; i++) {
                    palabra = new Palabra(a[i]);
                    this.todasLasPalabras.add(palabra);
                }
            }

            ArrayList<Palabra> palabras = new ArrayList<Palabra>();

            for (int i = 0; i < this.todasLasPalabras.size(); i++) {

                String p = this.todasLasPalabras.get(i).getPalabra();
                ArrayList<Integer> posiciones = new ArrayList<Integer>();
                for (int j = 0; j < this.todasLasPalabras.size(); j++) {
                    if (p.equalsIgnoreCase(this.todasLasPalabras.get(j).getPalabra())) {

                        posiciones.add(j);
                    }
                    char[] c = p.toCharArray();
                    int ascii = c[0];
                    Palabra palabra = new Palabra(p, ascii, posiciones);
                    boolean existe = false;
                    for (int x = 0; x < palabras.size(); x++) {
                        if (palabra.getPalabra().equalsIgnoreCase(palabras.get(x).getPalabra())) {
                            existe = true;
                        }

                    }
                    if (existe == false) {
                        palabras.add(palabra);
                    }
                }
            }

            for (int i = 0; i < palabras.size(); i++) {
                arbol.agregar(palabras.get(i));
            }
            arbol.printTree1();
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(PalabraData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void guardarArbol() throws FileNotFoundException {

        File file = new File("Arbol.txt");
        PrintWriter pw = new PrintWriter(file);

        ArrayList<Palabra> palabras = arbol.recorrerArbol1();

        for (int i = 0; i < palabras.size(); i++) {
            pw.println(palabras.get(i).toString());
        }
        pw.close();
    }
}
