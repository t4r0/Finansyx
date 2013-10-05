/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Pronosticos;

import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class ModeloPotencial extends Modelo{
    
    Double sumLogY = 0.0, sumLogYLogX = 0.0, sumLogY2=0.0,
            sumLogX = 0.0, sumLogX2 = 0.0; 
       public ModeloPotencial() {
        super ();
       setNombre("Potencial");
    }
    
    public ModeloPotencial(ArrayList<Integer> x, ArrayList<Double> y)
    {
        setNombre("Potencial");
        Sumatorias(x, y);
        CalcularVariables();
        CalcularFactoresDeDecision();
    }
    
    @Override
    public void Reset()
    {
        super.Reset();
        sumLogY = 0.0;
        sumLogYLogX = 0.0;
        sumLogY2=0.0;
        sumLogX = 0.0;
        sumLogX2 = 0.0; 
    }
    
    @Override
    public Double Calcular(Integer x)
    {
        return A*Math.pow(x,b);
    }
    
    @Override
    public void Sumatorias(ArrayList<Integer> x, ArrayList<Double> y)           
    {
        Double varY = 0.0;
        Integer varX = 0;
        Double varX2 = 0.0, varLogY=0.
                , varLogX= 0.;
        super.Sumatorias(x, y);
        for(int i =0; i < y.size(); i++)
        {
            varX = x.get(i);
            varY = y.get(i);
            varLogY=Math.log(varY);
            varLogX = Math.log(varX);
            sumX += varX;
            sumY += varY;
            sumLogX+= varLogX;
            sumLogY += varLogY;
            sumLogX2 += Math.pow(varLogX, 2);
            sumLogY2 += Math.pow(varLogY,2);
            sumLogYLogX += varLogX * varLogY;
        }
        n = y.size();
        yProm = sumY / n;
        sumX = sumX / n;
        sumY = sumY / n;
        sumLogX = sumLogX / n;
        sumLogX2 = sumLogX2 / n;
        sumLogY = sumLogY / n;
        sumLogY2 = sumLogY2 / n;
        sumLogYLogX = sumLogYLogX / n;
    }
    
    @Override
    public void CalcularVariables()
    {
       b = sumLogYLogX - (sumLogX * sumLogY);
       b = b / (sumLogX2 - Math.pow(sumLogX, 2));
       
       a = sumLogY - b*sumLogX;
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
       Double denominador = (sumLogX2 - Math.pow(sumLogX, 2)) *
                                (sumLogY2 - Math.pow(sumLogY, 2));
       CalcularVarianza();
       r = (sumLogYLogX - (sumLogX * sumLogY)) / Math.sqrt(denominador);
       
       r2 = Math.pow(r, 2);
    }
    
}
