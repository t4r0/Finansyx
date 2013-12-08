/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Finances.Taxes;

/**
 *
 * @author t4r0
 */
public class Regime {
    public static final int SIMPLE = 4;
    public static final int PROFIT = 5;
    
    Double percentage = 0.;
    Double value = 0.;
    
    
    public Regime()
    {
        
    }
    
    public int getRegime()
    {
        return Regime.SIMPLE;
    }
    
    public Double getCalc() {
       if(value > 0)
          return value * percentage;
       return 0.;
    }
}
