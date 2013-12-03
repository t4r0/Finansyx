/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.PercentageRule;

/**
 *
 * @author t4r0
 */
public class PercentageManager extends DataManager{
    
    public PercentageManager(){}
    
    public PercentageManager(Double value, DataManager base)
    {
        super(new PercentageRule(value), base);
    }
    
    public PercentageManager(String value, DataManager base)
    {
       super(new PercentageRule(value), base);
    }
}
