/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Prognostication.Models;

import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class LinearModel extends Model{

    public LinearModel() {
        super ();
        setName("Lineal");
        
    }
    
    public LinearModel(ArrayList<Double> values)
    {
        super(values);
        setName("Lineal");
    }
    
    public LinearModel(ArrayList<Integer> x, ArrayList<Double> y)
    {       
        super(x, y);
        setName("Lineal");
    }
    
    @Override
    public Double Calc(Integer x)
    {
        return a*x + b;
    }
    
    @Override
    public void Sum(ArrayList<Integer> x, ArrayList<Double> y)           
    {
        Double varY = 0.0;
        Integer varX = 0;
        super.Sum(x, y);
        for(int i =0; i < y.size(); i++)
        {
            varX = x.get(i);
            varY = y.get(i);
            sumX += varX;
            sumY += varY;
            sumXY += varX * varY;
            sumX2 += Math.pow(varX, 2);
            sumY2 += Math.pow(varY, 2);
        }
        n = y.size();
    }
    
    @Override
    public void CalcValues()
    {
        Double numerador = (n*sumXY) - (sumX*sumY);
        Double denominador = (n*sumX2) - Math.pow(sumX, 2);        
        a = numerador / denominador;        
        b = (sumY / n) - a*(sumX/n);
    }
}
