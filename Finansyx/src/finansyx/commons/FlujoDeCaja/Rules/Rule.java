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
public class Rule implements ICalcRule{

     Double Value = 0.;
     Integer largo = 0;
    public Rule() {
    }

    public Double getValue()
    {
        return Value;
    }
    
    public void setValue(Double value)
    {
        Value = value;
    }        
            
    @Override
    public void Calcular(Gastos a) {    }

    @Override
    public void Calcular(Gastos a, Integer inicio) {    }
    
    
    
    
}
