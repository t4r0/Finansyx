/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;

import finansyx.commons.FlujoDeCaja.Gastos;
import finansyx.commons.FlujoDeCaja.Ingresos;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class PercentageCalcRule extends Rule implements IInverseCalcRule{

   
    public PercentageCalcRule() {
    }

    public PercentageCalcRule(Double value)
    {
        Value = value;
    }
    
    @Override
    public void CalcularInverso(Ingresos a, Gastos b) {
        ArrayList<Double> ing, gast;
        ing = a.getValues();
        gast = b.getValues();
      for(int i=0; i < largo; i++)
          gast.set(i, ing.get(i) * Value);
      
    }

    @Override
    public void CalcularInverso(Ingresos a, Gastos b, Integer inicio) {
        ArrayList<Double> ing, gast;
        ing = a.getValues();
        gast = b.getValues();
      for(int i=inicio; i < largo; i++)
          gast.set(i, ing.get(i) * Value);
    }
    
    
    
    
}
