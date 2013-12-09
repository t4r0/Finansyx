/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

/**
 *
 * @author t4r0
 */
public class IncrementManager extends FinancialDataManager{

    Double value = 0.0;
    public IncrementManager(DataManager man, Double increment) {
        this.base = man;
        this.value = increment;
    }

    @Override
    public void Calc() {
        for(Double val: base.getValues())
            values.add(val + (value * value));
    }
     
    
    
}
