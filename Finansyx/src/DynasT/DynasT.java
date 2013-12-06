/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DynasT;

import DynasT.Analysis.Classes.LexicalAnalyzer;
import DynasT.Analysis.Classes.SintaxAnalysis;

/**
 *
 * @author t4r0
 */
public class DynasT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            
        LexicalAnalyzer lexico = new LexicalAnalyzer(System.in);
        SintaxAnalysis sintactico = new SintaxAnalysis(lexico);
        try{
        sintactico.parse();      
        }catch (Exception e)
        {           
           System.out.println("Listo!");      
           System.out.println(e.getMessage());
        }
        System.out.println("Generado correctamente");
    }
    
}
