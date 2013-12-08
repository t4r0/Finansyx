/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Finances.Fiscal;

import finansyx.commons.CashFlow.CashFlow;
import finansyx.commons.Finances.Fiscal.Tax.ISOTax;
import finansyx.commons.Finances.Fiscal.Tax.ISRTax;
import finansyx.commons.Finances.Fiscal.Tax.IVATax;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class GtTaxesManager extends TaxManager {
    
    GTAcreditation acred = null;
    IVATax iva = new IVATax();
    ISRTax isr = new ISRTax();
    ISOTax iso = null;
    public ArrayList<Double> values = new ArrayList<Double>();
    public GtTaxesManager(int Type,CashFlow cashflow)
    {
        isr = new ISRTax();
        iso = new ISOTax(isr);
        acred = new GTAcreditation(isr,iso, Type);
        
        iva.calcTax(cashflow);
        isr.calcTax(cashflow);
        iso.calcTax(cashflow);
        values = calcTaxes();
                
    }

    @Override
    public final ArrayList<Double> calcTaxes() {
        ArrayList<Double> imp = new ArrayList<>();
        ArrayList<Double> acredi = acred.calcTaxes();
        for(int i=0; i < 10; i++)
        {
            imp.add(iva.getPay(i) + acredi.get(i));
        }
        return imp;
    }
    
    
}
