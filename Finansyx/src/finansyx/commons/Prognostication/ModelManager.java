/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Prognostication;

import finansyx.commons.Prognostication.Models.ExponentialModel;
import finansyx.commons.Prognostication.Models.LinearModel;
import finansyx.commons.Prognostication.Models.LogarithmicModel;
import finansyx.commons.Prognostication.Models.Model;
import finansyx.commons.Prognostication.Models.PolynomialModel;
import finansyx.commons.Prognostication.Models.PotentialModel;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Un gestor, que ayuda a controlar multiples modelos de pronosticación
 * @author t4r0
 */
public class ModelManager {
    
    
    // Los modelos almacenados en este gestor
    ArrayList<Model> models = new ArrayList<>();
    //El modelo que se usará para calcular los valores de salida de este gestor
    Model selectedModel = new Model();    
    //El modelo con el minimo pronóstico
    Model minimumPrognosticModel = new Model();
    //El nivel de confianza que se utilizará para calcular valores estadísticos
    Double confianza = 0.;
    //El indice del modelo seleccionado
    Integer index = -1;
    //La tendencia de los valores con los que se generó el modelo
    int trending = -2;
    
    Double incremento = 0.;
    
    Integer fixedConfidence = 90;
    public ModelManager(){}
    
     /**
      * Crea un nuevo manager, desde un conjunto de datos
      * @param pattern el conjunto de datos a partir del cual se creará el nuevo manager
      */
     public ModelManager(ArrayList<Double> pattern)
     {
       models = new ArrayList<>();
       models.add(new LinearModel(pattern));
       models.add(new PolynomialModel(pattern));
       models.add(new LogarithmicModel(pattern));
       models.add(new ExponentialModel(pattern));
       models.add(new PotentialModel(pattern));       
       findTrending(pattern);
       chooseModel();      
     }
    
    /**
     * Inicia una nueva instancia de esta clase, con los modelos especificados y
     * el grado de confianza dado
     * @param modelos - los modelos dentro de los cuales se escogerá el optimo
     * @param confianza - Los grados de confianza que se usarán para resolver el
     * problema específico
     */
     public ModelManager(ArrayList<Model> modelos, Double confianza){
        this.models= modelos;
        this.confianza = confianza;
        chooseModel();
    }

    public void setIncremento(Double incremento) {
        this.incremento = incremento;
    }

    public void setFixedConfidence(Integer fixedConfidence) {
        this.fixedConfidence = fixedConfidence;
    }
     
     
     
     /**
      * Halla la tendencia de los valores especificados, la cual representará
      * la tendencia de este Manager
      * @param values los valores, cuya tendencia se debe evaluar
      */
     final void findTrending(ArrayList<Double> values)
     {
         this.trending = Trending.findTrending(values);
     }
     
     /**
      * Establece los grados de confianza que se usarán para calcular los limites
      * @param confianza - Los grados de confianza para calcular los valores estadisticos a partir de esta clase 
      */
     public void setConfianza(Double confianza)
     {
         this.confianza = confianza;
         chooseModel();
     }
     
     /**
      * Escoge el modelo adecuado 
      */
    public final void chooseModel()
    {
        Model choos = models.get(0);
        Model mod  = new Model();
        index = 0;
        for(int i=0; i< models.size(); i++)
        {
            mod = models.get(i);
            if(isCandidate(mod, choos) && mod.getTrending() == this.trending)
            {    
                choos = mod;
                index = i;
            }           
        }
        selectedModel= choos;
        chooseMinimumModel();
    }
    
    /**
     * Escoge el modelo con el pronóstico minimo
     */
    public final void chooseMinimumModel()
    {
        Model choos = models.get(0);
        Model mod = new Model();
        Double currentMinimum = Double.POSITIVE_INFINITY;
        Double res = 0.;
        for(int i=0; i < models.size(); i++)
        {
            mod = models.get(i);
            res = mod.Calc(1);     
            if(Objects.equals(res, currentMinimum))
                res = mod.Calc(2);
            if (res < currentMinimum && mod.getTrending() == this.trending)
            {
                choos = mod;       
                currentMinimum = res;
            }
        }
        minimumPrognosticModel = choos;
    }
    
    /**
     * Regresa el modelo con el pronóstico mínimo
     * @return 
     */
    public Model getMinimumPrognosticModel(){ return minimumPrognosticModel;}
    /***
     * 
     * @return - El modelo escogido para calcular los datos de salida de este 
     * gestor
     */
    public Model getSelectedModel()
    {
        return selectedModel;
    }
    
    /**
     * Escoge si el Model a es candidato para reemplazar a b
     * @param a - el modelo que se evaluará
     * @param b - el modelo que se pretende sustituir
     * @return si el modelo A, es candidato para sustituir a b.
     */
    protected Boolean isCandidate(Model a, Model b)
    {
         if(a.getSXY() < b.getSXY())
             return true;
           if (Objects.equals(a.getSXY(), b.getSXY()))
            {
                if (a.getr() > b.getr())
                    return true;
                if (a.getr() < b.getr() && a.getr() < b.getr())
                    return false;
                if (Objects.equals(a.getr(), b.getr()) && a.getr2() > b.getr2())
                    return true;                
            }
        return false;
    }
    
    /**
     * Establece el modelo que se quiere escoger, sin tomar en cuenta las
     * politicas de optimización
     * @param i - el indice donde se encuentra el modelo
     */
    public void setSelectedModel(int i)
    {
        if(i >= models.size() || i < 0)
            return;
        selectedModel = models.get(i);                
    }
    
    /**
     * Devuelve el modelo almacenado en el indice i
     * @param i - el indice de donde se obtendrá el modelo
     * @return - el modelo almacenado en el indice i
     */
    public Model get(int i)
    {
        index = i;
        return models.get(i);       
    }
    
    /**
     * Regresa el indice en el que se encuentra el modelo escogido
     * @return El inidce del modelo escogido
     */
    public Integer getSelectedModelIndex()
    {
        return index;
    }
    
    /**
     * Agrega un modelo de pronosticación a este gestor
     * @param modelo - el modelo que se desea agregar
     */
    public void Add(Model modelo)
    {
        models.add(modelo);
    }
    
    /**
     * 
     * @return la cantidad de modelos en este gestor
     */
    public int Size()
    {
        return models.size();
    }
    
    /**
     * Calcula un valor en base a un punto específico, haciendo uso del modelo 
     * escogido
     * @param punto - el valor independiente a partir del cual se calculará
     * el valor dado por el modelo
     * @return un valor dado por el modelo
     */
    public Double Calcular(Integer punto)
    {
        Double value = selectedModel.Calc(punto + selectedModel.getn());
        return value + value*incremento;
    }
    
    public Double fixedUpperLimit(Integer punto)
    {
        Double value = selectedModel.FixedUpperLimit(punto + selectedModel.getn(), fixedConfidence);
        return value + value*incremento;
    }
    
    public Double fixedLowerLimit(Integer punto)
    {
        Double value = selectedModel.FixedLowerLimit(punto + selectedModel.getn(), fixedConfidence);
        return value + value*incremento;
    }
    /**
     * Calcula el limite superior, con los grados de confianza dados
     * @param punto - el punto que se ploteará
     * @return el limite superior de confianza
     */
    public Double UpperLimit(Integer punto)
    {
         Double value = selectedModel.UpperLimit(punto + selectedModel.getn(), confianza);
         return value + value*incremento;
    }
    
    /**
     * Calcula el limite inferior con los grados de confianza dados
     * @param punto - el punto que se ploteará
     * 
     * @return el limite inferior de confianza
     */
     public Double LowerLimit(Integer punto)
    {
         Double value = selectedModel.LowerLimit(punto, confianza);
         return value + value*incremento;
    }   
}
