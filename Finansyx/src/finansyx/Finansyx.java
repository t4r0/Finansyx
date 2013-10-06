/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx;

import finansyx.commons.Finanzas.Finanzas;
import finansyx.commons.Pronosticos.*;
import finansyx.commons.*;
import finansyx.commons.Finanzas.Cuota;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author t4r0
 */
public class Finansyx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> keys = new ArrayList<Integer>(
                Arrays.asList(new Integer[]{1,2,3,4}));
        ArrayList<Double> values = new ArrayList<Double>(
                Arrays.asList(new Double[]{29.0, 29.5, 39.0, 60.0}));
        ModeloLineal modl= new ModeloLineal(keys, values);
        ModeloPolinomial modP = new ModeloPolinomial(keys, values);
        ModeloExponencial modE = new ModeloExponencial(keys, values);
        ModeloLogaritmico modL = new ModeloLogaritmico(keys, values);
        ModeloPotencial modPo = new ModeloPotencial(keys, values);
                
        System.out.println(modl.toString());
        System.out.println(modP.toString());
        System.out.println(modE.toString());
        System.out.println(modL.toString());
        System.out.println(modPo.toString() + "\n===================\n");
        System.out.println(Finanzas.GastosEscalonados(300., 0.1, 2011, 2021));
        
        ArrayList<Cuota> cuotas = Finanzas.CuotasNiveladas(250., 4, 3,0.2,1.);
        for(Cuota cuota: cuotas)
        {
            System.out.println(cuota.toString());
        }
        
        System.out.println("\n =============  \n\n");
        ArrayList<Cuota> cuotasAl = Finanzas.CuotasNoNiveladas(250., 4, 3,0.2,1.);
        for(Cuota cuota: cuotasAl)
        {
            System.out.println(cuota.toString());
        }
        
         System.out.println(Estadistica.zNormal(0.9));
         System.out.println(Estadistica.zNormal(0.95));
         System.out.println(Estadistica.zNormal(0.99));
    }
}
