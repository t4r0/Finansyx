/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Pronosticos;

import java.util.ArrayList;
import Jama.Matrix;
/**
 *
 * @author t4r0
 */
public class ModeloPolinomial extends Modelo{
    
    Double sumX2Y = 0.0, sumX3=0.0, sumX4=0.0;
    
        public ModeloPolinomial() {
        super ();
    }
    
    public ModeloPolinomial(ArrayList<Integer> x, ArrayList<Double> y)
    {
        super(x, y);
    }
    
    @Override
    public void Reset()
    {
        super.Reset();
        sumX2Y = 0.0;
        sumX3=0.0;
        sumX4=0.0;
    }
    
    @Override
    public Double Calcular(Integer x)
    {
        return a*x + b;
    }
    
    @Override
    public void Sumatorias(ArrayList<Integer> x, ArrayList<Double> y)           
    {
        Double varY = 0.0;
        Integer varX = 0;
        Double varX2 = 0.0;
        super.Sumatorias(x, y);
        for(int i =0; i < y.size(); i++)
        {
            varX = x.get(i);
            varY = y.get(i);
            varX2 = Math.pow(varX, 2);
            sumX += varX;
            sumY += varY;
            sumXY += varX * varY;
            sumX2 += varX2;
            sumY2 += Math.pow(varY, 2);
            sumX2Y += varX2 * varY;
            sumX3 += Math.pow(varX, 3);
            sumX4 += Math.pow(varX, 4);
        }
        n = y.size();
        yProm = sumY / n;
    }
    
    @Override
    public void CalcularVariables()
    {
       double[][] matA = {{n, sumX, sumX2, sumY},
                          {sumX, sumX2, sumX3, sumXY},
                          {sumX2,sumX3, sumX4, sumX2Y }};
               
       Matrix A = new Matrix(matA);
       Matrix B = A.inverse();

    }
    
}
