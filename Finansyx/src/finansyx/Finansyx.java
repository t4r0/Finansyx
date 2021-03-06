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
import finansyx.commons.Finances.Fiscal.GTAcreditation;
import finansyx.commons.Finances.Fiscal.GtTaxesManager;
import finansyx.commons.Finances.Fiscal.Tax.*;
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
                   
                   return;
                }
                
                default: break;
            }
        }
        while(option != 4);
       
    }
    
    public static void testCashFlow() throws NotAValidOptionException
    {
        PrognosticManager progn, gasM;
        ArrayList<Double> prog = new ArrayList<>(
                Arrays.asList(new Double[]{1132., 1259., 1459., 1712., 2479., 2512., 2788., 2800.,
                 2865. , 2888.}));
        ArrayList<Double> tel= new ArrayList<>(
                Arrays.asList(new Double[]{21., 25., 30., 38., 43., 48., 51., 55.}));
         ArrayList<Double> gas= new ArrayList<>(
                Arrays.asList(new Double[]{60., 68., 75., 76., 89., 95., 103., 115.}));
        ArrayList<Double> seg= new ArrayList<>(
                Arrays.asList(new Double[]{21., 29., 38., 49., 53., 57., 58., 59., 60.}));
        CashFlow flujo = new CashFlow();
        flujo.setAssets(2200.0);
        flujo.setLastYearRevenue(2888.0);
        flujo.setLasYearCosts(2773.0);
        flujo.setRevenue(new PrognosticManager(prog, 95, Options.UPPER_LIMIT, 0.12));
        
        flujo.setCosts(new PeriodicalManager(getManagers(flujo.getRevenue())));
        
        flujo.AddOutlay("alquileres",new TieredValuesManager("5%", 2013, 2014, 12.));
        TieredValuesManager sueldo = new TieredValuesManager("8%", 2013, 2014, 17.);
        sueldo.setHasBill(false);
        flujo.AddOutlay("sueldos",sueldo);
        flujo.AddOutlay("combustible",new PrognosticManager(gas, 99,Options.MINIMUM_LOWER, 0.));
        flujo.AddOutlay("servicios",new PercentageManager("1%", flujo.getRevenue()));
        flujo.AddOutlay("telefono",new PrognosticManager(tel, 99,Options.MINIMUM_UPPER, 0.));
        flujo.AddOutlay("comisiones",new PercentageManager("4%", new PercentageManager("45%", flujo.getRevenue())));
        PercentageManager indemn = new PercentageManager("8.33%", flujo.getOutLay("sueldos"));
        indemn.setHasBill(false);
        indemn.setIsShield(true);
        flujo.AddOutlay("indemnizaciones",indemn);
        flujo.AddOutlay("seguros",new PrognosticManager(seg,95,Options.LOWER_LIMIT, 0.));
        flujo.AddOutlay("oficina",new PercentageManager("1.5%", flujo.getRevenue()));
        depreciate(flujo);
        
        flujo.AddOutlay("uniformes",new PercentageManager("0.8%", flujo.getCosts()));
        PercentageManager igss = new PercentageManager("12.67%", flujo.getOutLay("sueldos"));
        igss.setHasBill(false);
        flujo.AddOutlay("igss", igss);
        flujo.AddOutlay("mantenimiento",new FlatValuesManager(28.6,10));
        flujo.AddOutlay("intereses",new FeeManager(2200., 12, 10,"16%" ,Options.FRENCH));
        
        PercentageManager inc =  new PercentageManager("3%", new PercentageManager("55%", flujo.getRevenue()));
        inc.setHasBill(false);
        inc.setIsShield(true);
        flujo.AddOutlay("incobrables",inc);
        
        flujo.Optimize();
        
        CashFlow clon = flujo.generateScenario(null);
    }
    
    public static void depreciate(CashFlow flujo)
    {
        flujo.AddAsset("maquinaria",new DepreciationManager("20%", 550.00));
        flujo.AddAsset("vehiculos", new DepreciationManager("20%", 200.0));
        flujo.AddAsset("edificio", new DepreciationManager("5%", 945.0));
        flujo.AddAsset("mobiliario",new DepreciationManager("20%", 50.0));
        flujo.AddAsset("instalacion",new DepreciationManager("20%", 50.0));
    }
 
    public static ArrayList<DataManager> getManagers(DataManager man)
    {
        ArrayList<DataManager> managers = new ArrayList<>();
        String[] perc = new String[]{"97%", "96%", "60%", "75%", "70%"};
        Integer[] lim = new Integer[]{1, 1, 2, 3, 3};
        PercentageManager mana = null;
        int add = 0;
         for(int i=0; i < perc.length; i++)
         {
             mana = new PercentageManager(perc[i], man);             
             mana.setLimit(lim[i] + add, add);
             managers.add(mana);
             add += lim[i];
         }
        return managers;
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
        ArrayList<Integer> keys = new ArrayList<>(
                Arrays.asList(new Integer[]{1,2,3,4}));
        ArrayList<Double> values = new ArrayList<>(
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
