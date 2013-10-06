/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Pronosticos;

import finansyx.commons.Finanzas.Finanzas;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class ModeloLogaritmico extends Modelo{
    
    Double sumLogX = 0., sumLogX2 = 0., sumLogXY = 0.;
       public ModeloLogaritmico() {
        super ();
        setNombre("Logaritmico");
    }
    
    public ModeloLogaritmico(ArrayList<Integer> x, ArrayList<Double> y)
    {
        setNombre("Logaritmico");
        Sumatorias(x, y);
        CalcularVariables();
        CalcularFactoresDeDecision();
    }
    
    @Override
    public void Reset()
    {
        super.Reset();
        sumLogX = 0.;
        sumLogX2 = 0.;
        sumLogXY = 0.;
    }
    
    @Override
    public Double Calcular(Integer x)
    {
        return b*Math.log(x) + a;
    }
    
    @Override
    public void Sumatorias(ArrayList<Integer> x, ArrayList<Double> y)           
    {
        Double varY = 0.0;
        Integer varX = 0;
        Double varY2 = 0.0, varLog=0.;
        super.Sumatorias(x, y);
        for(int i =0; i < y.size(); i++)
        {
            varX = x.get(i);
            varY = y.get(i);
            varLog=Math.log(varX);
            varY2 = Math.pow(varY, 2);
            sumX += varX;
            sumY += varY;
            sumY2 += varY2;
            sumLogX += varLog;
            sumLogX2 += Math.pow(varLog,2);
            sumLogXY += varY * varLog;
        }
        n = y.size();
        yProm = sumY / n;
        sumX = sumX / n;
        sumY = sumY / n;
        sumY2 = sumY2 / n;
        sumLogX = sumLogX / n;
        sumLogX2 = sumLogX2 / n;
        sumLogXY = sumLogXY / n;
    }
    
    @Override
    public void CalcularVariables()
    {
       b = sumLogXY - (sumLogX* sumY);
       b = b / (sumLogX2 - Math.pow(sumLogX, 2));       
       a = sumY - b*sumLogX;
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
                                (sumY2 - Math.pow(sumY, 2));
       CalcularVarianza();
       r = (sumLogXY - (sumLogX * sumY)) / Math.sqrt(denominador);       
       r2 = Math.pow(r, 2);
    }
    
}
