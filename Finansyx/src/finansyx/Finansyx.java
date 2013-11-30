/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx;

import finansyx.commons.Finances.Finances;
import finansyx.commons.Prognostication.*;
import finansyx.commons.*;
import finansyx.commons.Finances.Fee;
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
        ArrayList<Double> promx = new ArrayList<Double>(
                Arrays.asList(new Double[]{94., 108., 146., 184., 196., 209., 225., 265.}));
        ArrayList<Double> promy = new ArrayList<Double>(
                Arrays.asList(new Double[]{9., 14., 17., 18., 21., 24., 28., 32.}));
        LinearModel modl= new LinearModel(keys, values);
        PolynomialModel modP = new PolynomialModel(keys, values);
        ExponentialModel modE = new ExponentialModel(keys, values);
        LogarithmicModel modL = new LogarithmicModel(keys, values);
        PotentialModel modPo = new PotentialModel(keys, values);
                
        System.out.println(modl.toString());
        System.out.println(modP.toString());
        System.out.println(modE.toString());
        System.out.println(modL.toString());
        System.out.println(modPo.toString() + "\n===================\n");
        System.out.println(Finances.TieredCosts(300., 0.1, 2011, 2021));
        
        ArrayList<Fee> cuotas = Finances.ConstantPaymentMortgage(250.,4, 3,0.2,1.);
        for(Fee cuota: cuotas)
        {
            System.out.println(cuota.toString());
        }
        ArrayList<Double> pruebas = Finances.InterestsSummary(cuotas, 4);
        for(Double payment: pruebas)
            System.out.println(payment);
        
        System.out.println("\n =============  \n\n");
        ArrayList<Fee> cuotasAl = Finances.ConstantAmortizedMortgage(250., 4, 3,0.2,1.);
        for(Fee cuota: cuotasAl)
        {
            System.out.println(cuota.toString());
        }
        
        pruebas = Finances.InterestsSummary(cuotasAl, 4);
        
        
        for(Double payment: pruebas)
            System.out.println(payment);
        
        
         System.out.println(Finances.Average(promx, promy));
         System.out.println(Statistics.zNormal(0.9));
         System.out.println(Statistics.zNormal(0.95));
         System.out.println(Statistics.zNormal(0.99));
    }
}
