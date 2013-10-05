/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Pronosticos;

import java.util.*;
/**
 *
 * @author t4r0
 */
public class ModeloExponencial extends Modelo{
    
    Double sumLogY = 0.0, sumXLogY = 0.0, sumLogY2=0.0;
    
       public ModeloExponencial() {
        super ();
        nombre = "Exponencial";
    }
    
    public ModeloExponencial(ArrayList<Integer> x, ArrayList<Double> y)
    {
        Sumatorias(x, y);
        CalcularVariables();
        CalcularFactoresDeDecision();
    }
    
    @Override
    public void Reset()
    {
        super.Reset();
        sumLogY = 0.0;
        sumLogY2=0.0;
       sumXLogY=0.0;
    }
    
    @Override
    public Double Calcular(Integer x)
    {
        return A*Math.exp(b * x);
    }
    
    @Override
    public void Sumatorias(ArrayList<Integer> x, ArrayList<Double> y)           
    {
        Double varY = 0.0;
        Integer varX = 0;
        Double varX2 = 0.0, varLog=0.;
        super.Sumatorias(x, y);
        for(int i =0; i < y.size(); i++)
        {
            varX = x.get(i);
            varY = y.get(i);
            varLog=Math.log(varY);
            varX2 = Math.pow(varX, 2);
            sumX += varX;
            sumY += varY;
            sumX2 += varX2;
            sumLogY += varLog;
            sumLogY2 += Math.pow(varLog,2);
            sumXLogY += varX * varLog;
        }
        n = y.size();
        yProm = sumY / n;
        sumX = sumX / n;
        sumY = sumY / n;
        sumX2 = sumX2 / n;
        sumLogY = sumLogY / n;
        sumLogY2 = sumLogY2 / n;
        sumXLogY = sumXLogY / n;
    }
    
    @Override
    public void CalcularVariables()
    {
       b = sumXLogY - (sumX * sumLogY);
       b = b / (sumX2 - Math.pow(sumX, 2));
       
       a = sumLogY - b*sumX;
       A = Math.exp(a);
    }
    
    @Override
    void CalcularVarianza()
    {
       ArrayList<Double> Ycalc = Calcular(keys);
       for(int k =0; k < keys.size(); k++)
           varExp += Math.pow(Ycalc.get(k) - values.get(k), 2);
       
       Sxy = Math.sqrt(varExp/(n-2));
    }
    
    @Override
     void CalcularFactoresDeDecision()
    { 
       Double denominador = (sumX2 - Math.pow(sumX, 2)) *
                                (sumLogY2 - Math.pow(sumLogY, 2));
       CalcularVarianza();
       r = (sumXLogY - (sumX * sumLogY)) / Math.sqrt(denominador);
       
       r2 = Math.pow(r, 2);
    }
}
