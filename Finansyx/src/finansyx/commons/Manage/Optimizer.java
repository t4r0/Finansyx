/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.AverageRule;
import finansyx.commons.Rules.Options;
import finansyx.commons.Rules.PrognosticRule;
import finansyx.commons.Rules.Rule;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class Optimizer extends FinancialDataManager{
    
    static Boolean isDependent = false;
    public Optimizer(ArrayList<Double> values, DataManager man, Double increase)
    {
            this.calcRule = getBestOption(values, man, increase);
            Calc();
    }
    
    public static final Rule getBestOption(ArrayList<Double> values, 
            DataManager man, Double increase)
    {
        if(maxDifference(man.getValues(), values) > 0.05)
        {
            isDependent = true;
            return new AverageRule(values);
        }
        else       
            return new PrognosticRule(values, 95,Options.PUNTUAL, increase);
    }
    public static final Double maxDifference(ArrayList<Double> a, ArrayList<Double> b)
    {
        Double max = -9999.;
        Double min = 9999.0;
        Double ave = 0.;
        if(a.size() > b.size() || b.size() > a.size())
            return 0.06;
        for(int i = 0 ; i < a.size(); i++)
        {
            ave = b.get(i)/ a.get(i);
            if(ave > max)
                max = ave;
            if(ave < min)
                min = ave;
        }    
            
        return max - min;
    }

    @Override
    public final void Calc() {
        if(isDependent)
            this.values = calcRule.getValuesFromRule(base);
        else
            this.values = calcRule.getValuesFromRule();
    }
    
    
}
