/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Pronosticos;
import java.util.ArrayList;
import finansyx.Exceptions.*;
import finansyx.commons.Statistics;
import finansyx.commons.Finanzas.Finances;

        
/**
 *
 * @author t4r0
 */
public class Model {

    // El Name de este modelo
    protected String Name= "Modelo";
    //Variables que forman parte de la ecuación
    protected Double A=0.0 ,  a= 0.0, b= 0.0, c= 0.0;
    protected Integer n=0;
    protected Double yProm = 0.0;
    //Variables que ayudan a la toma de decisión
    protected Double Sxy=0.0, r=0.0, r2=0.0;    
    //Sumatorias
    protected Double sumX=0.0, sumY=0.0, sumXY=0.0, sumX2=0.0, sumY2=0.0;       
    protected Double totalValue = 0.0, varExp=0.0, varNExp=0.0;
    ArrayList<Integer> keys = new ArrayList<>();
    ArrayList<Double> values = new ArrayList<>();
    /**
     * Crea una nueva instancia de este modelo
     */
    public Model() {
    }
    
    public Model(ArrayList<Integer> yValues, ArrayList<Double> xValues)
    {       
        Sum(yValues, xValues);
        CalcValues();
        CalcDecisionFactor();
    }
    
    public Double getA(){return A;}
    public Double geta(){return a;}
    public Double getb(){return b;}
    public Double getc(){return c;}
    public Double getSXY(){return Sxy;}
    public Double getr(){return r;}
    public Double getr2(){return r2;}
    public Integer getn(){return n;}
    public String getName(){return Name;}
    public void setName(String Name){this.Name = Name;}
    /**
     * Hace las sumatorias respectivas de este modelo
     * @param y = Los valores independientes, del modelo
     * @param x = Los valores dependientes, del modelo
     * @throws DiferentSizeException 
     */
    public void Sum(ArrayList<Integer> y, ArrayList<Double> x)
    {
        keys = y;
        values = x;
    }
    
    /**
     * Calcula las variables relacionadas con este modelo
     */
    void CalcValues() {}
    
    /**
     * Calcula los factores de decision de este modelo
     */
    void CalcDecisionFactor()
    { 
       
       Double numerador =(n*sumXY) - (sumX*sumY);
       Double denominador = (n*sumX2) - Math.pow(sumX, 2);
       denominador = denominador*((n*sumY2) - Math.pow(sumY, 2) );
       r =numerador / Math.sqrt(denominador);
       r2 = Math.pow(r, 2);
       CalcVariance();
      
    }
    
    public void CalcModel(ArrayList<Integer> yValues, ArrayList<Double> xValues)
    {
        Reset();
        Sum(yValues, xValues);
        CalcValues();
        CalcDecisionFactor();       
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
    void CalcVariance()
    {
       ArrayList<Double> Ycalc = Calc(keys);
       for(int k =0; k < keys.size(); k++)
           varExp += Math.pow(Ycalc.get(k) - values.get(k), 2);
       Sxy = Math.sqrt(varExp/(n-2));
    }
    
    
    /**
     * Calcula un valor en base a la ecuación de este modelo
     * @param a =  El independiente,a partir del cual se calculará la proyección
     * @return Una proyección en base al modelo especificado
     */
    public Double Calc(Integer a){return 0.0;}
    
    /**
     * 
     */
    public ArrayList<Double> Calc(ArrayList<Integer> a)
    {
        ArrayList<Double> resultado = new ArrayList<>();
        for(Integer num: a)
        {
            resultado.add(Calc(num));
        }
        return resultado;
    }
    
    public final Double UpperLimit(Double value, Double confianza)
    {
        return value + Statistics.zNormal(confianza)* Sxy/Math.sqrt(n);
    }
    
    public final Double UpperLimit(Integer punto, Double confianza)
    {
         return Calc(n + punto) + Statistics.zNormal(confianza)* Sxy /Math.sqrt(n);
    }
    
    
    public final Double LowerLimit(Double value, Double confianza)
    {
        return value - Statistics.zNormal(confianza)* Sxy/Math.sqrt(n);
    }
    
    public final Double LowerLimit(Integer punto, Double confianza)
    {
        return Calc(n + punto) - (Statistics.zNormal(confianza)*Sxy/Math.sqrt(n));
    }
    
    public final Double FixedUpperLimit(Double value, int confianza)
    {
        return value + Statistics.FixedZ(confianza)* Sxy/Math.sqrt(n);
    }
    
    public final Double FixedUpperLimit(Integer punto, int confianza)
    {
        return Calc(n + punto) + Statistics.FixedZ(confianza)* Sxy /Math.sqrt(n);
    }
    
    public final Double FixedLowerLimit(Double value, int confianza)
    {
        return value - Statistics.FixedZ(confianza)* Sxy/Math.sqrt(n);
    }
    
    public final Double FixedLowerLimit(Integer punto, int confianza)
    {
        return Calc(n + punto) - Statistics.FixedZ(confianza)* Sxy /Math.sqrt(n);
    }
    
    @Override
    public String toString()
    {
        return "r= " + r + "\nr^2= " + r2 + "\nSXY= "+ Sxy; 
    }
}
