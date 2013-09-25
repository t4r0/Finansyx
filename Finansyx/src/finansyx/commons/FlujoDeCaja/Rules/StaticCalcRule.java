/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;

import finansyx.commons.FlujoDeCaja.Gastos;
import java.util.ArrayList;
import sun.security.util.Length;

/**
 *
 * @author t4r0
 */
public class StaticCalcRule extends Rule{
    
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

    @Override
    public void Calcular(Gastos a, Integer inicio) {
       ArrayList<Double> val = a.getValues();
      for(int i=inicio; i < largo; i++)
      {
          val.set(i, Value);
      }
    }
    
    
    
    
}
