

package finansyx.commons.Manage;

import finansyx.commons.Finances.Finances;
import finansyx.commons.Statistics;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class DepreciationManager extends FinancialDataManager{
     ArrayList<Double> actualValues = new ArrayList<>();
     Double value = 0.;
     Double Original = 0.;
     public DepreciationManager(Double percentage, Double original)
     {
         this.value = percentage;
         this.Original = original;
         this.hasBill = false;
         this.isShield = true;
         Calc();
     }
     
     public DepreciationManager(String percentage, Double original)
     {
         this.value = Statistics.percentageFromString(percentage);
         this.Original = original;
         this.hasBill = false;
         this.isShield = true;
         Calc();
     }

     public ArrayList<Double> getActualValues()
     {
         return actualValues;
     }
    @Override
    public final void Calc() {
        this.actualValues = Finances.Depreciate(Original, value);
        this.values = Finances.flatDepreciation(Original, value);
    }

    @Override
    public Boolean isAsset() {
        return true;
    }
    
    
     
}
