/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Finances.Taxes;

import finansyx.commons.CashFlow.CashFlow;
import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author t4r0
 */
public class ISRTax extends Tax{
    
    ArrayList<Double> percentages = new ArrayList<>(
                Arrays.asList(new Double[]{0.25, 0.28, 0.28, 0.28, 0.28, 0.28, 0.28, 0.28, 0.28, 0.28}));
    ArrayList<Regime> regimes = new ArrayList<>();
    public ISRTax()
    {
        
    }
    
    @Override
    public void calcTax(CashFlow cashFlow)
    {
        DataManager rev = cashFlow.getRevenue();
        ArrayList<Double> fact = cashFlow.getOutlaysWithBill();
        ArrayList<Double> noFact = cashFlow.getOutlaysWithOutBill();
        Double revs = 0.;
        Double exps = 0.;
        Double perc = 0.;
        int type = cashFlow.getType();
        for(int i=0; i < 10; i++)
        {
            if(type == CashFlow.NET)
            {
                 revs = rev.getValues().get(i);
                 exps = fact.get(i) + noFact.get(i);
            }
            else
            {
                revs = rev.getValues().get(i) / 1.12;
                exps = (fact.get(i)/1.12) + noFact.get(i);
            }
            perc = (revs - exps) / revs;
            if(perc > percentages.get(i))            
                regimes.add(new SimpleRegime(revs));            
            else
                regimes.add(new ProfitRegime(revs - exps, 53 - percentages.get(i)));
        }
        makeSum();
    }
    
    @Override
    public void makeSum()
    {
        for(Regime reg : regimes)
        {
            payment.add(reg.getCalc());
        }
    }
}
