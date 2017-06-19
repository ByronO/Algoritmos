/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Arbol;
import Domain.Palabra;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author byron
 */
public class PalabraData {

    private String path;

    public void leerTexto(String path) throws FileNotFoundException {
        this.path = path;
        Arbol arbol = new Arbol();
        ArrayList<Palabra> todasLasPalabras = new ArrayList<Palabra>();

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
                    todasLasPalabras.add(palabra);
                }
            }

            ArrayList<Palabra> palabras = new ArrayList<Palabra>();
            ArrayList<Integer> posiciones = new ArrayList<Integer>();

            for (int i = 0; i < todasLasPalabras.size(); i++) {
                int cantidad = 0;
                String p = todasLasPalabras.get(i).getPalabra();

                for (int j = 0; j < todasLasPalabras.size(); j++) {
                        if (p.equalsIgnoreCase(todasLasPalabras.get(j).getPalabra())) {
                        cantidad++;
                        posiciones.add(j);
//                        System.out.println(p+cantidad);
                    }
                    char[] c = p.toCharArray();
                    int ascii = c[0];
                    Palabra palabra = new Palabra(p, cantidad, ascii, posiciones);
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
                posiciones.removeAll(posiciones);
            }

            for (int i = 0; i < palabras.size(); i++) {
                arbol.agregar(palabras.get(i));
            }
            arbol.printTree1();
        } catch (IOException ex) {
            Logger.getLogger(PalabraData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
