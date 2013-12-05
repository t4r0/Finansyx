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
public class PrognosticRule extends Rule{
    
    int firstYear = 0;
    ModelManager manager = new ModelManager();
    int option = -1;
    int confianza = 90;
    
    public PrognosticRule(){}
    
    public PrognosticRule(ArrayList<Double> values, int firstYear, int option)
    {
        manager = new ModelManager(values);
        this.firstYear = firstYear;
        this.option = option;
    }
    
    public int getConfidence(){return confianza;}
    
    public void setConfidence(int value){ this.confianza = value; }
    
    public int getOption(){return option; }
    
    public void setOption(int option){this.option = option;}
    
    @Override
    public ArrayList<Double> getValuesFromRule() throws NotAValidOptionException
    {
        Model model = manager.getSelectedModel();
        int n = model.getn();
        ArrayList<Double> values = new ArrayList<>();
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
            default:
            {
                throw new NotAValidOptionException("Esta opción no es válida, o no es soportada");
            }
        }
        return values;        
    }
}
