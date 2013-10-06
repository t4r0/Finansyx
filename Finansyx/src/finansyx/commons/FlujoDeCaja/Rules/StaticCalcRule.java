/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;

import finansyx.commons.FlujoDeCaja.Financiera;
import java.util.ArrayList;
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
    public void Calcular() {
       ArrayList<Double> val = new ArrayList<>();
       for(int i =0; i < largo; i++)
            val.add(Value);
       this.destino.setValues(val);
    }

    @Override
    public void Calcular(Integer inicio) {
       ArrayList<Double> val = new ArrayList<>();
      for(int i=inicio; i < largo; i++)
          val.add(Value);
      this.destino.setValues(val);
    }   
}
