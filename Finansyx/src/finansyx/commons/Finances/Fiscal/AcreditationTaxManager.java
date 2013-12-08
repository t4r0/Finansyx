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
public class AcreditationTaxManager extends TaxManager{
    
    Tax main= new Tax();
    Tax secondary = new Tax();
    
    public AcreditationTaxManager(Tax main, Tax secondary)
    {
        this.main = main;
        this.secondary = secondary;
    }
}
