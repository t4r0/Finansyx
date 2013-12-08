/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Finances.Fiscal;

import finansyx.commons.Finances.Fiscal.Tax.Tax;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class GTAcreditation  extends AcreditationTaxManager{
    
    public static final int ISO_ISR = 9;
    public static final int ISR_ISO = 6;

    public int type = 0;
    public GTAcreditation(Tax main, Tax secondary, int type) {
        super(main, secondary);
        this.type = type;
    }

    public ArrayList<Double> definitiveMainTax()
    {
        ArrayList<Double> definitive = new ArrayList<>();
        Tax isr = main;
        Tax iso = secondary;
        
        switch(type)
        {
            case ISO_ISR:
            {
                for(int i=0; i < iso.getPayment().size(); i++)
                {
                    definitive.add(iso.getPay(i));
                }
                break;
            }
            case ISR_ISO:
            {
                for(int i=0; i < isr.getPayment().size(); i++)
                    definitive.add(isr.getPay(i));
                break;
            }
        }
        return definitive;
    }
    
    public ArrayList<Double> definitiveSecondaryTax()
    {
        ArrayList<Double> definitive = new ArrayList<>();
        Double acum = 0.0;
        Double pay = 0.0;
        switch(type)
        {
            case ISO_ISR:
            {
                for(int i=0; i < secondary.getPayment().size(); i++)
                {
                    pay = main.getPay(i);
                    if(acum > pay)
                    {
                        definitive.add(0.0);
                        acum = acum - pay + secondary.getPay(i);
                    }
                    else
                    {
                      
                        definitive.add(pay - acum);
                        acum = secondary.getPay(i);
                    }
                }
                break;
            }
            case ISR_ISO:
            {
                for(int i=0; i < main.getPayment().size(); i++)
                {
                    pay = main.getPay(i);
                    acum = secondary.getPay(i);
                    if(acum > pay)
                        definitive.add(acum - pay);
                    else
                        definitive.add(0.0);
                }                 
                break;
            }
        }
        return definitive;
    }

    @Override
    public ArrayList<Double> calcTaxes() {
       ArrayList<Double> mai = definitiveMainTax();
       ArrayList<Double> secondar = definitiveSecondaryTax();
       ArrayList<Double> val = new ArrayList<>();
       
       for(int i=0; i < mai.size() || i < secondar.size(); i++)
           val.add(mai.get(i) + secondar.get(i));
       
       return val;
    }
 
}
