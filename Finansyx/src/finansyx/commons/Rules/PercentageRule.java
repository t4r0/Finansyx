/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Rules;

import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class PercentageRule extends Rule{
    
    public PercentageRule(Double value)
    {
        super(value);
    }
    
    public PercentageRule(String value)
    {
        super(Double.parseDouble(value.trim().replace("%"," "))/100);
       
    }
    
    @Override
    public ArrayList<Double> getValuesFromRule(DataManager manager)            
    {
        ArrayList<Double> values = new ArrayList<>();
        for(Double value: manager.getValues())
        {
            values.add(value * this.Value);
        }
        return values;
    }
    
    @Override
    public ArrayList<Double> getValuesFromRule()
    {
        ArrayList<Double> values = new ArrayList<>();
        for(int i=0; i < 10; i++)
            values.add(Value * Math.random());
        return values;
    }
    
}
