/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Rules;

import finansyx.Exceptions.NotAValidOptionException;
import finansyx.commons.Prognostication.ModelManager;
import finansyx.commons.Prognostication.Models.Model;

import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class PrognosticRule extends RuleWithOption{
    
    int firstYear = 0;
    ModelManager manager = new ModelManager();
    int confianza = 90;
    /**
     * Inicializa una nueva instancia de esta clase
     */
    public PrognosticRule(){}
    
    /**
     * Inicializa una nueva regla de pronostico
     * @param values valores base para pronosticar
     * @param firstYear primer año de pronostico
     * @param option la forma en que se calcularán estos valores
     */
    public PrognosticRule(ArrayList<Double> values, int firstYear, int option)
    {
        manager = new ModelManager(values);
        this.firstYear = firstYear;
        this.option = option;
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
    public ArrayList<Double> getValuesFromRule() throws NotAValidOptionException
    {
        Model model = manager.getSelectedModel();
        int n = model.getn();
        ArrayList<Double> values = new ArrayList<>();
        Model minModel = manager.getMinimumPrognosticModel();
        switch(option)
        {
            case Options.PUNTUAL:
            {
                for(int i=1; i < limit; i ++)
                    values.add(model.Calc(i+n));
                break;
            }            
            case Options.LOWER_LIMIT:
            {
                for(int i=1; i < limit; i++)
                    values.add(model.FixedLowerLimit(i+ n,this.confianza));
                break;                    
            }            
            case Options.UPPER_LIMIT:
            {
                 for(int i=1; i < limit; i++)
                    values.add(model.FixedUpperLimit(i+ n,this.confianza));
                break; 
            }
            case Options.MINIMUM:
            {
               
                for(int i=1; i < limit; i++)
                    values.add(minModel.Calc(i+n));
                break;
            }
            
            case Options.MINIMUM_LOWER:
            {
                for(int i=1; i < limit; i++)
                    values.add(minModel.FixedLowerLimit(i+ n,this.confianza));
                break;   
            }
            case Options.MINIMUM_UPPER:
            {
                 for(int i=1; i < limit; i++)
                    values.add(minModel.FixedUpperLimit(i+ n,this.confianza));
                break; 
            }
            default:
            {
                throw new NotAValidOptionException("Esta opción no es válida, o no es soportada");
            }
        }
        return values;        
    }
}
