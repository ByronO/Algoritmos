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
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(PalabraData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public void guardarArbol() throws FileNotFoundException {

        File file = new File("Arbol.txt");
        PrintWriter pw = new PrintWriter(file);

        ArrayList<Palabra> palabras = arbol.recorrerArbol1();

        String posiciones = "";
        for (int i = 0; i < palabras.size(); i++) {
            for (int j = 0; j < palabras.get(i).getPosiciones().size(); j++) {
                posiciones += palabras.get(i).getPosiciones().get(j);

                posiciones += ",";

            }
            String sub = posiciones.substring(0, posiciones.length() - 1);
//            switch (palabras.get(i).getPalabra()) {
//                case "que":
//                    palabras.get(i).setPalabra("!");
//                    break;
//                case "para":
//                    palabras.get(i).setPalabra("'");
//                    break;
//                case "pero":
//                    palabras.get(i).setPalabra("#");
//                    break;
//                case "por":
//                    palabras.get(i).setPalabra("$");
//                    break;
//                case "como":
//                    palabras.get(i).setPalabra("%");
//                    break;
//                case "del":
//                    palabras.get(i).setPalabra("&");
//                    break;
//                case "los":
//                    palabras.get(i).setPalabra("(");
//                    break;
//                case "las":
//                    palabras.get(i).setPalabra(")");
//                    break;
//                case "la":
//                    palabras.get(i).setPalabra("*");
//                    break;
//                case "el":
//                    palabras.get(i).setPalabra("+");
//                    break;
//                case "cuando":
//                    palabras.get(i).setPalabra("/");
//                    break;
//                case "de":
//                    palabras.get(i).setPalabra("^");
//                    break;
//                case "porque":
//                    palabras.get(i).setPalabra("{");
//                    break;
//                case "porqué":
//                    palabras.get(i).setPalabra("}");
//                    break;
//                case "además":
//                    palabras.get(i).setPalabra("[");
//                    break;
//                case "también":
//                    palabras.get(i).setPalabra("]");
//                    break;
//                case "más":
//                    palabras.get(i).setPalabra("-");
//                    break;
//
//            }
            pw.println(palabras.get(i).getPalabra() + " " + sub);
            posiciones = "";
        }

        pw.close();
    }

    public String leerArbol(String path) {
        ArrayList<Palabra> palabrasDelArbol = new ArrayList<>();
        String texto = "";
        FileReader fr = null;
        try {
            this.pathArbol = path;
            File archivo = new File(this.pathArbol);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                Palabra palabra;
                String[] a = linea.split(" ");
                String[] b = a[1].split(",");

                for (int i = 0; i < 1; i++) {
                    ArrayList<Integer> posiciones = new ArrayList<>();

                    for (int j = 0; j < b.length; j++) {
                        posiciones.add(Integer.parseInt(b[j]));
                    }
//                    switch (a[0]) {
//                        case "!":
//                            a[0] = "que";
//                            break;
//                        case "'":
//                            a[0] = "para";
//                            break;
//                        case "#":
//                            a[0] = "pero";
//                            break;
//                        case "$":
//                            a[0] = "por";
//                            break;
//                        case "%":
//                            a[0] = "como";
//                            break;
//                        case "&":
//                            a[0] = "del";
//                            break;
//                        case "(":
//                            a[0] = "los";
//                            break;
//                        case ")":
//                            a[0] = "las";
//                            break;
//                        case "*":
//                            a[0] = "la";
//                            break;
//                        case "+":
//                            a[0] = "el";
//                            break;
//                        case "/":
//                            a[0] = "cuando";
//                            break;
//                        case "^":
//                            a[0] = "de";
//                            break;
//                        case "{":
//                            a[0] = "porque";
//                            break;
//                        case "}":
//                            a[0] = "porqué";
//                            break;
//                        case "[":
//                            a[0] = "además";
//                            break;
//                        case "]":
//                            a[0] = "también";
//                            break;
//                        case "-":
//                            a[0] = "más";
//                            break;
//
//                    }
                    palabra = new Palabra(a[0], posiciones);

                    palabrasDelArbol.add(palabra);
                }

            }

            int cont = 0;
            int a = 0;
            while (a < palabrasDelArbol.size()) {
                for (int i = 0; i < palabrasDelArbol.size(); i++) {
                    for (int j = 0; j < palabrasDelArbol.get(i).getPosiciones().size(); j++) {
                        if (palabrasDelArbol.get(i).getPosiciones().get(j) == cont) {
                            texto += palabrasDelArbol.get(i).getPalabra() + " ";
                            cont++;
                        }

                    }
                }
                a++;
            }

            fr.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PalabraData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {

        }
        return texto;
    }
    
    
}
