/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Finances.Fiscal.Tax;

import finansyx.commons.Finances.Taxes.Regimes.Regime;
import finansyx.commons.CashFlow.CashFlow;
import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class ISOTax extends Tax{
    
    ISRTax tax = new ISRTax();
    public ISOTax(ISRTax tax)
    {
        this.tax = tax;
    }

    @Override
    public void calcTax(CashFlow cashFlow) {
       ArrayList<Double> rev = cashFlow.getAllRevenues();
       Double asset = 0.0;
       Double val = 0.0;
       Boolean comm = cashFlow.isCommerce();
       ArrayList<Regime> reg =  tax.getRegimes();
       ArrayList<Double> ut = cashFlow.getAllProfitPercentage();
       int size = rev.size();
       for(int i=0; i < size -1 ; i++)
       {
           if(ut.get(i) < 0.04 || !comm || reg.get(i).getRegime() == Regime.SIMPLE)
               payment.add(0.0);
           else
           {
               asset = cashFlow.getAsset(i);
               val = rev.get(i);
               if(asset > val * 4 || asset < val)
                   payment.add(val*0.01);
               else
                   payment.add(asset * 0.01);
           }
       }
    }
    
    
}
