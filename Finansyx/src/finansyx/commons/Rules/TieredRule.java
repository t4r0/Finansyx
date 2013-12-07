
package finansyx.commons.Rules;

import finansyx.commons.Finances.Finances;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class TieredRule extends PercentageRule {
    
    int baseYear = 2013;
    Double base = 0.;
    int firstYear = 2013;
    
    public TieredRule(Double value, int baseYear, Double base, int firstYear)
    {
        super(value);
        this.baseYear = baseYear;
        this.firstYear = firstYear;
        this.base = base;
    }
    
    public TieredRule(String value, int baseYear, Double base, int firstYear)
    {
        super(value);
        this.baseYear = baseYear;
        this.firstYear = firstYear;
        this.base = base;
    }
    
    @Override
    public ArrayList<Double> getValuesFromRule()
    {
        ArrayList<Double> values = new ArrayList<>();
        for(int i=start; i < limit; i++ )
        {
            values.add(Finances.TieredCosts(base, Value, baseYear, firstYear + i));
        }
        return values;
    }
}
