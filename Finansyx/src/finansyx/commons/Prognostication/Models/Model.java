/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Prognostication.Models;
import finansyx.commons.Prognostication.Trending;
import java.util.ArrayList;
import finansyx.commons.Statistics;

        
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
    
    /**
     * @return La constante A de este modelo
     */
    public Double getA(){return A;}
    
    /**
     * @return La constante a de este modelo
     */
    public Double geta(){return a;}
    
    /**
     * @return La constante b de este modelo
     */
    public Double getb(){return b;}
    
    /**
     * @return La constante c de este modelo
     */
    public Double getc(){return c;}
    
    /**
     * @return La varianza de este modelo
     */
    public Double getSXY(){return Sxy;}
    
    /**
     * @return Una de las variables de decisión
     */
    public Double getr(){return r;}
    
    /**
     * @return El segundo parámetro de decisión
     */
    public Double getr2(){return r2;}
    
    /**
     * @return La cantidad de numeros con los que se calculó el modelo
     */
    public Integer getn(){return n;}
    
    /**
     * Calcula la tendencia del modelo, de acuerdo a los valores que contiene
     * @return Uno de los valores constantes de Finansyx.commons.Prognostication.Trending
     *           - INCREASING = un modelo que crece constantemente
     *           - DECREASING = un modelo que decrece constantemente
     *           - CONCAVE_UPWARD = un modelo con una curva concava hacia arriba
     *           - CONCAVE_DOWNWARD = un modelo con una curva concava hacia abajo
     *           - FLAT = un modelo con valores constantes
     *           - ALTERNANT = un modelo sin tendencia predecible.
     *           - ERROR = un modelo no predecible.
     */
    public int getTrending(){return Trending.INCREASING;}
    
    /**
     * @return El nombre de este modelo
     */
    public String getName(){return Name;}
    public void setName(String Name){this.Name = Name;}
    /**
     * Hace las sumatorias respectivas de este modelo
     * @param y = Los valores independientes, del modelo
     * @param x = Los valores dependientes, del modelo 
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
    
    /**
     * Calcula el modelo en base a los valores X, Y
     * @param yValues Un conjunto de valores dependientes
     * @param xValues Un conjunto de valores Independientes
     */
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
     * Calcula un conjunto de valores, puntuales, en base a la ecuación de este modelo
     * @param a Un conjunto de valores independientes
     * @return Una proyección en base a los valores independientes.
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
    
    /**
     * Devuelve el límite superior bilateral del valor dado, con la confianza dada
     * @param value Un valor al que se le evaluará un limite bilateral
     * @param confianza El nivel de confianza que se desea
     * @return El limite bilateral con la confianza dada
     */
    public final Double UpperLimit(Double value, Double confianza)
    {
        return value + Statistics.zNormal(confianza)* Sxy/Math.sqrt(n);
    }
    
    /**
     * Calcula el limite superior bilateral del valor dado, con la confianza dada
     * @param punto El punto que se evaluará en este modelo
     * @param confianza El nivel de confianza que se desea
     * @return El limite calculado, en base a un punto en el tiempo, y el nivel de confianza
     */
    public final Double UpperLimit(Integer punto, Double confianza)
    {
         return Calc(n + punto) + Statistics.zNormal(confianza)* Sxy /Math.sqrt(n);
    }
    
    /**
     * Devuelve el limite inferiror bilateral, en base al valor dado, y la confianza dada
     * @param value Un valor al que se le evaluará un limite bilateral
     * @param confianza El nivel de confianza que se desea
     * @return El limite bilateral con la confianza dada
     */    
    public final Double LowerLimit(Double value, Double confianza)
    {
        return value - Statistics.zNormal(confianza)* Sxy/Math.sqrt(n);
    }
    
    /**
     * Calcula el limite inferior bilateral del valor dado, con la confianza dada
     * @param punto El punto que se evaluará en este modelo
     * @param confianza El nivel de confianza que se desea
     * @return El limite calculado, en base a un punto en el tiempo, y el nivel de confianza
     */
    public final Double LowerLimit(Integer punto, Double confianza)
    {
        return Calc(n + punto) - (Statistics.zNormal(confianza)*Sxy/Math.sqrt(n));
    }
    
    /**
     * Devuelve el limite superior bilateral de confianza,
     * para el valor dado, con tres niveles de confianza específicos
     * @param value Un valor al que se le evaluará un limite bilateral
     * @param confianza El nivel de confianza que se desea
     * @return El limite bilateral con la confianza dada
     */    
    public final Double FixedUpperLimit(Double value, int confianza)
    {
        return value + Statistics.FixedZ(confianza)* Sxy/Math.sqrt(n);
    }
    
    /**
     * Calcula el limite superior bilateral de confianza,
     * para el valor dado, con tres niveles de confianza específicos
     * @param punto El punto que se evaluará en este modelo
     * @param confianza El nivel de confianza que se desea
     * @return El limite calculado, en base a un punto en el tiempo, y el nivel de confianza
     */
    public final Double FixedUpperLimit(Integer punto, int confianza)
    {
        return Calc(n + punto) + Statistics.FixedZ(confianza)* Sxy /Math.sqrt(n);
    }
    
    /**
     * Devuelve el limite inferior bilateral de confianza,
     * para el valor dado, con tres niveles de confianza específicos
     * @param value Un valor al que se le evaluará un limite bilateral
     * @param confianza El nivel de confianza que se desea
     * @return El limite bilateral con la confianza dada
     */    
    public final Double FixedLowerLimit(Double value, int confianza)
    {
        return value - Statistics.FixedZ(confianza)* Sxy/Math.sqrt(n);
    }
    
     /**
     * Calcula el limite inferior bilateral de confianza,
     * para el valor dado, con tres niveles de confianza específicos
     * @param punto El punto que se evaluará en este modelo
     * @param confianza El nivel de confianza que se desea
     * @return El limite calculado, en base a un punto en el tiempo, y el nivel de confianza
     */
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
