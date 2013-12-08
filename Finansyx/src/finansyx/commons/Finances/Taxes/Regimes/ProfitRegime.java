/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Finances.Taxes.Regimes;

/**
 *
 * @author t4r0
 */
public class ProfitRegime extends Regime {
    
    public ProfitRegime(Double value, Double percentage)
    {
        this.value = value;
        this.percentage = percentage;
    }

    @Override
    public int getRegime() {
        return Regime.PROFIT;
    }

    
    
}

