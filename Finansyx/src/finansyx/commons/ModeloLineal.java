/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons;

import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class ModeloLineal extends Modelo{

    public ModeloLineal() {
        super ();
    }
    
    public ModeloLineal(ArrayList<Integer> y, ArrayList<Double> x)
    {
        super(y, x);
    }
    
    @Override
    public Double Calcular(Integer x)
    {
        return a*x + b;
    }
    
    @Override
    public void Sumatorias(ArrayList<Integer> y, ArrayList<Double> x)           
    {
        Double varX = 0.0;
        super.Sumatorias(y, x);
        for(Integer i : y)
        {
            varX = x.get(i);
            sumX += varX;
            sumY += i;
            sumXY += varX * i;
            sumX2 += Math.pow(varX, 2);
            sumY2 += Math.pow(i, 2);
        }
        n = y.size();
    }
    
    @Override
    public void CalcularVariables()
    {
        a = ((n*sumXY) - (sumX*sumY)) 
                / ((n*sumX2) - Math.pow(sumX, 2));
        
        b = (sumY / n) - a*(sumX/n);
    }
}
