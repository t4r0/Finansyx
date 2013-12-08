/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Finances.Taxes.Regimes;

import finansyx.commons.Finances.Taxes.Regimes.Regime;

/**
 *
 * @author t4r0
 */
public class SimpleRegime extends Regime{

    
    
    public SimpleRegime(Double value) {
        this.value = value;
        this.percentage = 0.07;
                
    }

    @Override
    public Double getCalc() {
       return value * percentage;
    }
        
    
}
