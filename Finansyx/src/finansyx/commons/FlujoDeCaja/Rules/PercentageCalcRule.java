/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;
import finansyx.commons.FlujoDeCaja.*;
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
    public Financiera CalcularInverso(Financiera a) {
        ArrayList<Double> ing, gast;
        ing = a.getValues();
        gast = new ArrayList<>();;
      for(int i=0; i < largo; i++)
          gast.add(ing.get(i) * Value);
      return new Financiera(gast);
    }

    @Override
    public Financiera CalcularInverso(Financiera a, Integer inicio) {
        ArrayList<Double> ing, gast;
        ing = a.getValues();
        gast = new ArrayList<Double>();
      for(int i=inicio; i < largo; i++)
          gast.add(ing.get(i) * Value);
      return new Financiera(gast);
    }
    
    
    
    
}
