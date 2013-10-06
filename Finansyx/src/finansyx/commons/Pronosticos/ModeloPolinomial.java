/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Pronosticos;

import java.util.ArrayList;
import Jama.Matrix;
import finansyx.commons.Finanzas.Finanzas;
/**
 *
 * @author t4r0
 */
public class ModeloPolinomial extends Modelo{
    
    Double sumX2Y = 0.0, sumX3=0.0, sumX4=0.0;    
        public ModeloPolinomial() {
        super ();
        setNombre("Polinomial");
    }
    
    public ModeloPolinomial(ArrayList<Integer> x, ArrayList<Double> y)
    {
        setNombre("Polinomial");
        Sumatorias(x, y);
        CalcularVariables();
        CalcularFactoresDeDecision();
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
        return a*Math.pow(x, 2) + b*x + c;
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
       double[][] matA = {{n, sumX, sumX2},
                          {sumX, sumX2, sumX3},
                          {sumX2,sumX3, sumX4}};
       double[] matB = {sumY, sumXY, sumX2Y};
       Matrix A = new Matrix(matA);
       Matrix B = new Matrix(matB, 3);
       Matrix C = A.solve(B);       
       a = C.get(2,0);
       b = C.get(1, 0);
       c = C.get(0, 0);
    }
    
    @Override
    void CalcularVarianza()
    {
       ArrayList<Double> Ycalc = Calcular(keys);
       for(int k =0; k < keys.size(); k++)
       {
           varExp += Math.pow(Ycalc.get(k) - values.get(k), 2);
           varTotal += Math.pow(values.get(k) - yProm, 2);
           varNExp += Math.pow(Ycalc.get(k) - yProm, 2);
       }
       Sxy = Math.sqrt(varExp/(n-2));
    }
    
    @Override
     void CalcularFactoresDeDecision()
    { 
       CalcularVarianza();
       r = Math.sqrt(varNExp/varTotal);
       r2 = Math.pow(r, 2);
    }   
}
