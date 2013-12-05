/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Prognostication.Models;

import finansyx.commons.Finances.Finances;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class PotentialModel extends Model{
    
    Double sumLogY = 0.0, sumLogYLogX = 0.0, sumLogY2=0.0,
            sumLogX = 0.0, sumLogX2 = 0.0; 
       public PotentialModel() {
        super ();
       setName("Potencial");
    }
       
    public PotentialModel(ArrayList<Double> values)
    {
        super(values);
        setName("Potencial");
    }
    
    public PotentialModel(ArrayList<Integer> x, ArrayList<Double> y)
    {
        setName("Potencial");
        Sum(x, y);
        CalcValues();
        CalcDecisionFactor();
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
    public Double Calc(Integer x)
    {
        return A*Math.pow(x,b);
    }
    
    @Override
    public void Sum(ArrayList<Integer> x, ArrayList<Double> y)           
    {
        Double varY = 0.0;
        Integer varX = 0;
        Double varX2 = 0.0, varLogY=0.
                , varLogX= 0.;
        super.Sum(x, y);
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
    public void CalcValues()
    {
       b = sumLogYLogX - (sumLogX * sumLogY);
       b = b / (sumLogX2 - Math.pow(sumLogX, 2));       
       a = sumLogY - b*sumLogX;
       A = Math.exp(a);       
    }
    
    @Override
    void CalcVariance()
    {
       ArrayList<Double> Ycalc = Calc(keys);
       for(int k =0; k < keys.size(); k++)
           varExp += Math.pow(Ycalc.get(k) - values.get(k), 2);
       
       Sxy = Math.sqrt(varExp/(n-2));
    }
    
    @Override
     void CalcDecisionFactor()
    { 
       Double denominador = (sumLogX2 - Math.pow(sumLogX, 2)) *
                                (sumLogY2 - Math.pow(sumLogY, 2));
       CalcVariance();
       r = (sumLogYLogX - (sumLogX * sumLogY)) / Math.sqrt(denominador);       
       r2 = Math.pow(r, 2);
    }
    
}
