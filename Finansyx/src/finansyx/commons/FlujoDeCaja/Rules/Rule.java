/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;
import finansyx.commons.FlujoDeCaja.*;
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
    public Financiera Calcular() {  return null;  }

    @Override
    public Financiera Calcular(Integer inicio) { return null; }
    
    
    
    
}
