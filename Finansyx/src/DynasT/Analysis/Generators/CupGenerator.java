/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DynasT.Analysis.Generators;

import java.util.Scanner;



/**
 *
 * @author T4R0_o
 */
public class CupGenerator {
    public static void main(String[] args)    {
       
        try 
        {
            /* To create a vup file use this command line
             * java -jar cup.jar -destdir src\Analisis -parser SintaxAnalysis src\Analisis\calculadora.cup
             */
        Scanner reader;
        String archivo;
        String directorio;
        reader = new Scanner(System.in);
        System.out.println("¿Que generaré?: ");
        archivo = reader.next();
        System.out.println("¿Donde debo ponerlo?: ");
        directorio= reader.next();
               String opciones[] = new String[5];
               opciones[0]="-destdir";
               opciones[1]=directorio;
               opciones[2]="-parser";
               opciones[3]= "SintaxAnalysis";
               opciones[4]=archivo;
               java_cup.Main.main(opciones);
        } 
        catch (Exception ex) 
        {
            System.out.print(ex);
         }
    }



	
 }
