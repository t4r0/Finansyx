/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Rules;

import finansyx.Exceptions.NotAValidOptionException;
import finansyx.commons.Finances.Fee;
import finansyx.commons.Finances.Finances;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class FeeRule extends RuleWithOption{
    
   
    Double A = 0.;
    int p = 1;
    int n = 1;
    Double j = 0.;
    Double m = 1.;
    
    ArrayList<Fee> fees= new ArrayList<>();
    
    /**
     * Inicializa una nueva regla
     * @param A - El prestamo o la inversión que se ha hecho
     * @param p - Los pagos que se harán por año
     * @param n - Años involucrado en el préstamo
     * @param j - tasa de interes     * 
     * @param option la forma en que se calcularán los intereses
     */
    public FeeRule(Double A, int p, int n, Double j, int option)
    {
        this.A = A;
        this.p = p;
        this.n = n;
        this.j = j;
        this.option = option;
    }
    
    /**
     * @return devuelve las cuotas que deben pagarse
     */
    public ArrayList<Fee> getFees(){return fees;}
    
    @Override
    public ArrayList<Double> getValuesFromRule()
    {
        
        switch(option)
        {
            case Options.FRENCH:
            {
               fees = Finances.ConstantPaymentMortgage(A, p, n, j, m);
               return Finances.InterestsSummary(fees, p);
            }
            
            case Options.GERMAN:
            {
               fees = Finances.ConstantPaymentMortgage(A, p, n, j, m);
               return Finances.InterestsSummary(fees, p);
            }
            
            default:
               return null;
        }
    }
}
