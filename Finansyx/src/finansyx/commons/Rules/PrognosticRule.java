/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Rules;

import finansyx.commons.Prognostication.ModelManager;
import finansyx.commons.Prognostication.Models.Model;

import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class PrognosticRule extends Rule{
    
    int firstYear = 0;
    ModelManager manager = new ModelManager();
    
    public PrognosticRule(){}
    
    public PrognosticRule(ArrayList<Double> values, int firstYear)
    {
        manager = ModelManager.getManagerFromPattern(values);
        this.firstYear = firstYear;
    }
    
    @Override
    public ArrayList<Double> getValuesFromRule()
    {
        Model model = manager.getSelectedModel();
        int n = model.getn();
        ArrayList<Double> values = new ArrayList<>();
        for(int i=1; i < limit; i ++)
        {
            values.add(model.Calc(i+n));
        }
        return values;
    }
}
