/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx;

import finansyx.Exceptions.NotAValidOptionException;
import finansyx.commons.Prognostication.Models.*;
import finansyx.commons.Finances.Finances;
import finansyx.commons.*;
import finansyx.commons.CashFlow.CashFlow;
import finansyx.commons.Finances.Fee;
import finansyx.commons.Manage.*;
import finansyx.commons.Rules.Options;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
         int option = 0;
        do
        {
            System.out.println("Bienvenido!\n"
                    + "\nProbar Finances: 1"
                    + "\nProbar Modelos:  2"
                    + "\nProbar Finansyx: 3"
                    + "\nNada 4"
                    + "\n¿Qué haremos?: ");
            Scanner scan= new Scanner(System.in);
           option = scan.nextInt();
            switch(option)
            {
                case 1:
                {
                    testFinances();
                    scan.next();
                    break;
                }
                
                case 2:
                {
                    testModels();
                    scan.next();
                    break;
                }
                
                case 3:
                {
                try {
                    testCashFlow();
                } catch (NotAValidOptionException ex) {
                    Logger.getLogger(Finansyx.class.getName()).log(Level.SEVERE, null, ex);
                }
                    scan.next();
                    break;
                }
                
                default: break;
            }
        }
        while(option != 4);
       
    }
    
    public static void testCashFlow() throws NotAValidOptionException
    {
        ArrayList<Double> prog = new ArrayList<>(
                Arrays.asList(new Double[]{1132., 1259., 1459., 1712., 2479., 2512., 2788., 2800.,
                 2865. , 2888.}));
        CashFlow flujo = new CashFlow();
        TieredValuesManager escal = new TieredValuesManager("5%", 2013, 2014, 12.);
        System.out.println(escal);
        escal = new TieredValuesManager("8%", 2013, 2014, 17.);
        System.out.println(escal);
        PrognosticManager progn = new PrognosticManager(prog, 95, Options.UPPER_LIMIT, 0.15);
        System.out.println(progn);
    }
    
    public static  void testFinances()
    {
            ArrayList<Double> promx = new ArrayList<>(
                Arrays.asList(new Double[]{94., 108., 146., 184., 196., 209., 225., 265.}));
        ArrayList<Double> promy = new ArrayList<>(
                Arrays.asList(new Double[]{9., 14., 17., 18., 21., 24., 28., 32.}));
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
    
    public static void testModels()
    {
        ArrayList<Integer> keys = new ArrayList<Integer>(
                Arrays.asList(new Integer[]{1,2,3,4}));
        ArrayList<Double> values = new ArrayList<Double>(
                Arrays.asList(new Double[]{29.0, 29.5, 39.0, 60.0}));    
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
    }
}
