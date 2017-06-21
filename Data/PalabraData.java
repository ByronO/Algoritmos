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

    private String pathTexto, pathArbol;
    private ArrayList<Palabra> todasLasPalabras = new ArrayList<Palabra>();
    private Arbol arbol = new Arbol();

    public void leerTexto(String path) throws FileNotFoundException {
        this.pathTexto = path;

        try {
            File archivo = new File(this.pathTexto);
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

        String posiciones = "";
        for (int i = 0; i < palabras.size(); i++) {
            for (int j = 0; j < palabras.get(i).getPosiciones().size(); j++) {
                posiciones += palabras.get(i).getPosiciones().get(j);
                if (j != palabras.get(j).getPosiciones().size() - 2) {
                    posiciones += ",";
                }
            }
            String sub = posiciones.substring(0, posiciones.length() - 1);
            pw.println(palabras.get(i).getPalabra() + "-" + sub);
            posiciones = "";
        }

//        for (int i = 0; i < palabras.size(); i++) {
//            
//        }
        pw.close();
    }

    public String leerArbol(String path) {
        ArrayList<Palabra> palabrasDelArbol = new ArrayList<>();
        ArrayList<Integer> posiciones = new ArrayList<>();

        FileReader fr = null;
        try {
            this.pathArbol = path;
            File archivo = new File(this.pathArbol);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                Palabra palabra;
                String[] a = linea.split("-");
                String[] b = a[1].split(",");

                for (int i = 0; i < 1; i++) {
                                    posiciones.removeAll(posiciones);

                    for (int j = 0; j < b.length; j++) {
                        posiciones.add(Integer.parseInt(b[j]));
                    }
//                    System.out.println(posiciones.size());
                    palabra = new Palabra(a[0], posiciones);

                    palabrasDelArbol.add(palabra);

                }

            }

            for (int j = 0; j < palabrasDelArbol.size(); j++) {
                System.out.println(palabrasDelArbol.get(j).getPosiciones().toString());
            }

            String texto = "";

            int cont = 0;
            for (int i = 0; i < palabrasDelArbol.size(); i++) {
                for (int j = 0; j < palabrasDelArbol.get(i).getPosiciones().size(); j++) {
//                    System.out.println(palabrasDelArbol.get(i).getPosiciones().get(j));

                    if (palabrasDelArbol.get(i).getPosiciones().get(j).compareTo(cont) == 0) {
                        System.out.println("saa");

                        texto += palabrasDelArbol.get(i).getPalabra() + " ";
                        cont++;
//                        System.out.println(cont);
                    }

                }
            }

            System.out.println(texto);
            fr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PalabraData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {

        }

        return null;
    }
}
