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
public class LogarithmicModel extends Model{
    
    Double sumLogX = 0., sumLogX2 = 0., sumLogXY = 0.;
       public LogarithmicModel() {
        super ();
        setName("Logaritmico");
    }
    
    public LogarithmicModel(ArrayList<Integer> x, ArrayList<Double> y)
    {
        setName("Logaritmico");
        Sum(x, y);
        CalcValues();
        CalcDecisionFactor();
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
    public Double Calc(Integer x)
    {
        return b*Math.log(x) + a;
    }
    
    @Override
    public void Sum(ArrayList<Integer> x, ArrayList<Double> y)           
    {
        Double varY = 0.0;
        Integer varX = 0;
        Double varY2 = 0.0, varLog=0.;
        super.Sum(x, y);
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
    public void CalcValues()
    {
       b = sumLogXY - (sumLogX* sumY);
       b = b / (sumLogX2 - Math.pow(sumLogX, 2));       
       a = sumY - b*sumLogX;
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
                                (sumY2 - Math.pow(sumY, 2));
       CalcVariance();
       r = (sumLogXY - (sumLogX * sumY)) / Math.sqrt(denominador);       
       r2 = Math.pow(r, 2);
    }
    
}
