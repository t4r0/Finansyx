/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.Exceptions.NotAValidOptionException;
import finansyx.commons.Rules.TieredRule;

/**
 *
 * @author t4r0
 */
public class TieredValuesManager extends FinancialDataManager{
    
    public TieredValuesManager(){}
    
    public TieredValuesManager(Double value, int baseYear, int firstYear, Double base) throws NotAValidOptionException
    {
        super(new TieredRule(value, baseYear, base, firstYear));
    }
    
    public TieredValuesManager(String value, int baseYear, int firstYear, Double base) throws NotAValidOptionException
    {
         super(new TieredRule(value, baseYear, base, firstYear));
    }
        
}
