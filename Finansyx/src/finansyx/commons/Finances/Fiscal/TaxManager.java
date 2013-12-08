/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Finances.Fiscal;

import finansyx.commons.Finances.Fiscal.Tax.Tax;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class TaxManager {
    
    ArrayList<Tax> taxes = new ArrayList<>();
    public TaxManager()
    {
        
    }
    
    public TaxManager(ArrayList<Tax> taxes)
    {
        this.taxes = taxes;
    }
    
    public ArrayList<Double> calcTaxes()
    {
        return null;
    }
}
