/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Rules;

import finansyx.commons.Prognostication.ModelManager;

import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class PrognosticRule extends RuleWithOption{
    
    ModelManager manager = new ModelManager();
    int confianza = 90;
    /**
     * Inicializa una nueva instancia de esta clase
     */
    public PrognosticRule(){}
    
    /**
     * Inicializa una nueva regla de pronostico
     * @param values valores base para pronosticar
     * @param confidence el nivel de confianza
     * @param option la forma en que se calcularán estos valores
     * @param incremento cuanto aumentará el pronóstico
     */
    public PrognosticRule(ArrayList<Double> values, int confidence, int option, Double incremento)
    {
        manager = new ModelManager(values);
        this.option = option;
        manager.setFixedConfidence(confidence);
        manager.setIncremento(incremento);
    }
    
    /**
     * Obtiene el nivel de confianza del pronostico
     * @return 
     */
    public int getConfidence(){return confianza;}
    
    /**
     * Establece el nivel de confianza del pronóstico.
     * No es util si se calculara con opción:
     *  
     * @param value El nivel de confianza de los limites que se calcularan
     */
    public void setConfidence(int value){ this.confianza = value; }
    
    @Override
    public ArrayList<Double> getValuesFromRule()
    {
       
        ArrayList<Double> values = new ArrayList<>();
      
        switch(option)
        {
            case Options.PUNTUAL:
            {
                for(int i=start + 1; i <= limit; i ++)
                    values.add(manager.Calcular(i));
                break;
            }            
            case Options.LOWER_LIMIT:
            {
                for(int i= start + 1; i <= limit; i++)
                    values.add(manager.fixedLowerLimit(i));
                break;                    
            }            
            case Options.UPPER_LIMIT:
            {
                 for(int i= start + 1; i <= limit; i++)
                    values.add(manager.fixedUpperLimit(i));
                break; 
            }
            case Options.MINIMUM:
            {
               
                for(int i=1; i <= limit; i++)
                    values.add(manager.Minimum(i));
                break;
            }
            
            case Options.MINIMUM_LOWER:
            {
                for(int i= start + 1; i <= limit; i++)
                    values.add(manager.MinimumFixedLower(i));
                break;   
            }
            case Options.MINIMUM_UPPER:
            {
                 for(int i= start + 1; i <= limit; i++)
                    values.add(manager.MinimumFixedUpper(i));
                break; 
            }
            default:
            {
               return null;
            }
        }
        return values;        
    }
}
