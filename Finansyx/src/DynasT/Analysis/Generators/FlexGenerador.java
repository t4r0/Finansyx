/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DynasT.Analysis.Generators;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author Moshitos
 */
public class FlexGenerador {
    
    public static void main (String[] args) {
    	  Scanner reader;
          String archivo;
          try
          {
         
          archivo = "C:/Users/t4r0/Documents/GitHub/Finansyx/Finansyx/src/DynasT/Analysis/Files/DynasT-lex.flex";
          JFlex.Main.generate(new File(archivo) );
          }
          catch(Exception e)
          {
        	  System.out.println(e.getMessage());//el archivo que va a ejecutar
          }
    }
    
}
