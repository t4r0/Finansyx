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
        setIndependence(true);
    }
    
    public PercentageRule(String value)
    {
        super(Double.parseDouble(value.trim().replace("%"," "))/100);
       
    }
    
    @Override
    public ArrayList<Double> getValuesFromRule(DataManager manager)            
    {
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<Double> manV = manager.getValues();
        Double value = 0.;
        for(int i=start; i < limit; i++)
        {
            value = manV.get(i);
            values.add(value * this.Value);
        }
        return values;
    }
    
    @Override
    public ArrayList<Double> getValuesFromRule()
    {
        ArrayList<Double> values = new ArrayList<>();
        for(int i=start; i < limit; i++)
            values.add(Value * Math.random());
        return values;
    }
    
}
