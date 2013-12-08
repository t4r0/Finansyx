/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.PrognosticRule;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class PrognosticManager extends FinancialDataManager{
    
    int option = 0;
    int confidence = 0;
    Double incremento = 0.;
    public PrognosticManager(ArrayList<Double> values, int confidence, int option, Double incremento)
    {
        super(new PrognosticRule(values, confidence, option, incremento));
        this.option = option;
        this.confidence = confidence;
        this.incremento = incremento;
    }
    
    public Integer getOption()
    {
        return option;
    }
    
    public Integer getConfidence()
    {
        return confidence;
    }
    
    public Double getIncremento()
    {
        return incremento;
    }
    
    public ArrayList<Double> getPattern()
    {
        return ((PrognosticRule)(calcRule)).getManager().getPattern();
    }
}
