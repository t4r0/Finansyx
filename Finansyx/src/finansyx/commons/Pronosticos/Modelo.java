/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Pronosticos;
import java.util.ArrayList;
import finansyx.Exceptions.*;
        
/**
 *
 * @author t4r0
 */
public class Modelo {

    //Variables que forman parte de la ecuación
    Double A=0.0 ,  a= 0.0, b= 0.0, c= 0.0;
    Integer n=0;
    Double yProm = 0.0;
    //Variables que ayudan a la toma de decisión
    Double Sxy=0.0, r=0.0, r2=0.0;
    
    //Sumatorias
    Double sumX=0.0, sumY=0.0, sumXY=0.0, sumX2=0.0, sumY2=0.0;
    
    
    //Variaciones
    Double varTotal, varExp, varNExp;
    
    ArrayList<Integer> keys = new ArrayList<Integer>();
    ArrayList<Double> values = new ArrayList<Double>();
    /**
     * Crea una nueva instancia de este modelo
     */
    public Modelo() {
    }
    
    public Modelo(ArrayList<Integer> yValues, ArrayList<Double> xValues)
    {
       
        Sumatorias(yValues, xValues);
        CalcularVariables();
        CalcularFactoresDeDecision();
    }
    
    /**
     * Hace las sumatorias respectivas de este modelo
     * @param y = Los valores independientes, del modelo
     * @param x = Los valores dependientes, del modelo
     * @throws DiferentSizeException 
     */
    public void Sumatorias(ArrayList<Integer> y, ArrayList<Double> x)
    {
        keys = y;
        values = x;
    }
    
    /**
     * Calcula las variables relacionadas con este modelo
     */
    void CalcularVariables() {}
    
    /**
     * Calcula los factores de decision de este modelo
     */
    void CalcularFactoresDeDecision()
    { 
       
       Double numerador =(n*sumXY) - (sumX*sumY);
       Double denominador = (n*sumX2) - Math.pow(sumX, 2);
       denominador = denominador*((n*sumY2) - Math.pow(sumY, 2) );
       r = numerador / Math.sqrt(denominador);
       r2 = Math.pow(r, 2);
       CalcularVarianza();
      
    }
    
    public void CalcularModelo(ArrayList<Integer> yValues, ArrayList<Double> xValues)
    {
        Reset();
        Sumatorias(yValues, xValues);
        CalcularVariables();
        CalcularFactoresDeDecision();       
    }
    
    /**
     * Reinicia esta instancia
     */    
    public void Reset()
    {
        A=0.0;
        a= 0.0;
        b= 0.0;
        c= 0.0;
        n=0;
        sumX=0.0;
        sumY=0.0; 
        sumXY=0.0;
        sumX2=0.0;
        sumY2=0.0;
    }
    
    /**
     * Calcula la varianza 
     */
    void CalcularVarianza()
    {
       ArrayList<Double> Ycalc = Calcular(keys);
       for(int k =0; k < keys.size(); k++)
           varExp += Math.pow(Ycalc.get(k) - values.get(k), 2);
       Sxy = Math.sqrt(varExp/(n-2));
    }
    
    
    /**
     * Calcula un valor en base a la ecuación de este modelo
     * @param a =  El independiente,a partir del cual se calculará la proyección
     * @return Una proyección en base al modelo especificado
     */
    public Double Calcular(Integer a){return 0.0;}
    
    /**
     * 
     */
    public ArrayList<Double> Calcular(ArrayList<Integer> a)
    {
        ArrayList<Double> resultado = new ArrayList<>();
        for(Integer num: a)
        {
            resultado.add(Calcular(num));
        }
        return resultado;
    }
    
    @Override
    public String toString()
    {
        return "r= " + r + "\nr^2= " + r2 + "\nSXY= "+ Sxy; 
    }
}
