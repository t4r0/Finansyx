

package finansyx.commons.Manage;

import finansyx.commons.Rules.Rule;

/**
 *
 * @author t4r0
 */
public class FinancialDataManager extends DataManager{
    
    Boolean hasBill = true;
    Boolean isShield = false;
    Boolean isAsset = false;
    public FinancialDataManager() {
    }
    
    public FinancialDataManager(Rule calcRule) 
    {
        super(calcRule);
    }
    
    public FinancialDataManager(Rule calcRule, DataManager base)
    {
        super(calcRule, base);
    }

    public void setHasBill(Boolean hasBill) {
        this.hasBill = hasBill;
    }

    public void setIsShield(Boolean isShield) {
        this.isShield = isShield;
    }
    
    public Boolean hasBill()
    {
        return hasBill;
    }
    
    public Boolean isShield()
    {
        return isShield;
    }
            
    public Boolean isAsset()
    {
        return isAsset;
    }
    
    public void isAsset(Boolean value)
    {
        this.isAsset = value;
    }
}
