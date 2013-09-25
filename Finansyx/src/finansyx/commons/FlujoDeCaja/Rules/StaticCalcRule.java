/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;

import finansyx.commons.FlujoDeCaja.Gastos;

/**
 *
 * @author t4r0
 */
public class StaticCalcRule extends Rule{
    
    Double Value = 0.;
    public StaticCalcRule()
    {
        
    }
    
    public StaticCalcRule(Double value)
    {
        Value = value;
    }

    @Override
    public void Calcular(Gastos gastos) {
       for(Double val : gastos.getValues())
           val = Value;
       
    }
    
    
}
