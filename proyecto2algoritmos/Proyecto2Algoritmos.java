/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2algoritmos;

import Data.PalabraData;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author byron
 */
public class Proyecto2Algoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            PalabraData palabraData = new PalabraData();
            palabraData.leerTexto("texto.txt");
            palabraData.guardarArbol();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Proyecto2Algoritmos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
