/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Finances.Taxes;

import finansyx.commons.CashFlow.CashFlow;
import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class IVATax  extends Tax{
    
    ArrayList<Double> debit = new ArrayList<>();
    ArrayList<Double> credit = new ArrayList<>();
            
    public IVATax()
    {
        
    }
    
    @Override
    public void calcTax(CashFlow cashFlow)
    {
        DataManager rev = cashFlow.getRevenue();
        ArrayList<Double> fact = cashFlow.getOutlaysWithBill();
        if(cashFlow.getType() == CashFlow.NET)
        {
            for(int i=0; i < 10; i++)
            {
                debit.add(rev.getValues().get(i) * 0.12);
                credit.add(fact.get(i)*0.12);
            }
        }
        else
        {            
            for(int i=0; i < 10; i++)
            {
                debit.add(rev.getValues().get(i)*0.1071428);
                credit.add(fact.get(i)*0.1071428);
            }
        }
        this.makeSum();
    }
    
    @Override
    public void makeSum()
    {
        Double cred = 0.;
        Double deb = 0.;
        Double acred = 0.;
        Double paym = 0.;
        
        for(int i=0; i < debit.size() || i < credit.size(); i++)
        {
            cred = credit.get(i);
            deb = debit.get(i);
            paym = deb- cred - acred;
            
            if(paym < 0)
            {
                acred = -1*paym;
                paym = 0.;
            }
            
            else
                acred = 0.;            
            payment.add(paym);
        }
    }
}
