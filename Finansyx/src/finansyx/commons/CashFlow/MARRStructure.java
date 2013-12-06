/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.CashFlow;

import finansyx.commons.Finances.Finances;
import finansyx.commons.Statistics;

/**
 *
 * @author t4r0
 */
public class MARRStructure {
    
    private Double percentage = 0.;
    private Double risk = 0.;
    private Double marr = 0.;
    private Double ponderateMarr = 0.;
    
    public MARRStructure(){}
    
    public MARRStructure(Double percentage, Double inflation, Double risk)
    {
        this.risk = risk;
        this.percentage = percentage;
        this.marr = Finances.MARR(risk, inflation);
        this.ponderateMarr = percentage * marr;       
    }

    public MARRStructure(String percentage,String inflation, String risk)
    {
        this.risk = Statistics.percentageFromString(risk);
        this.percentage = Statistics.percentageFromString(percentage);
        this.marr = Finances.MARR(this.risk, Statistics.percentageFromString(inflation));
        this.ponderateMarr = this.percentage * marr;       
    }  
    public Double getMarr() {
        return marr;
    }

    public Double getPercentage() {
        return percentage;
    }

    public Double getPonderateMarr() {
        return ponderateMarr;
    }

    public Double getRisk() {
        return risk;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
        this.ponderateMarr = this.percentage * marr;
    }
    
    public void setPercentage(String value)
    {
        this.percentage = Statistics.percentageFromString(value);
    }
    
    public void setRisk(Double value)
    {
        this.risk = value;
    }
    
    public void setRisk(String value)
    {
        setRisk(Statistics.percentageFromString(value));
    }
    
    public void setRisk(Double risk, Double inflation)
    {
        this.risk = risk;
        this.marr = Finances.MARR(risk, inflation);
        this.ponderateMarr = percentage * marr;       
    }
    
    public void setRisk(String risk, String inflation)
    {
        setRisk(Statistics.percentageFromString(risk),Statistics.percentageFromString(inflation));
    }
}
