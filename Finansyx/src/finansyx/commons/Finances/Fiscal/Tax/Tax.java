/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Finances.Fiscal.Tax;

import finansyx.commons.CashFlow.CashFlow;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class Tax {
    Boolean pay = true;
    ArrayList<Double> payment= new ArrayList<>();
    public Tax(){}
    
    public Boolean shouldPay(){ return pay;}
    
    public void setShouldPay(Boolean value)
    {
        this.pay = value;
    }
    public void calcTax(CashFlow cashFlow)
    {
        makeSum();
    }
    
    public void makeSum()
    {
        
    }

    public ArrayList<Double> getPayment() {
        return payment;
    }   
    
    public Double getPay(Integer i)
    {
        if(i < 0 || i >= payment.size())
            return 0.0;
        return payment.get(i);
    }
    
     @Override
    public String toString()
    {
        String cadena = "";
        for(Double value : payment)
            cadena += value + " | ";
        return cadena;
    }
}
