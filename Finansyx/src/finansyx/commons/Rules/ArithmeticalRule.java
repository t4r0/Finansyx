
package finansyx.commons.Rules;

import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;

/**
 * Una regla de calculo que realiza operaciones aritméticas
 * @author t4r0
 */
public class ArithmeticalRule extends RuleWithOption{
    
    ArrayList<Double> base = new ArrayList<>();
    
    public ArithmeticalRule(int option, ArrayList<Double> base)
    {
        super(option);
        this.base = base;
    }
    
    @Override
    public ArrayList<Double> getValuesFromRule(DataManager manager)
    {
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<Double> manValues = manager.getValues();
        switch(option)
        {
            case Options.ADD:
            {
                for(int i=0; i < limit; i++)
                    values.add(base.get(i)+manValues.get(i));
            }
            case Options.SUBSTRACT:
            {
                  for(int i=0; i < limit; i++)
                    values.add(base.get(i)- manValues.get(i));
            }
            case Options.DIVIDE:
            {
                
                  for(int i=0; i < limit; i++)
                  {
                    Double num = manValues.get(i);
                    if(num != 0)
                        values.add(base.get(i)/num);
                    else
                        values.add(0.);
                  }
               
            }
            case Options.MULTIPLY:
            {
                 for(int i=0; i < limit; i++)
                    values.add(base.get(i)*manValues.get(i));
            }          
        }
        return values;
    }
}
