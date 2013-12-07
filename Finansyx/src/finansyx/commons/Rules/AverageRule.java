/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Rules;

import finansyx.commons.Finances.Finances;
import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class AverageRule extends Rule{
    
    ArrayList<Double> values = new ArrayList<>();
    
    /**
     * inicializa una nueva instacia de esta clase
     */
    public AverageRule(){}
    
    /**
     * Inicializa una nueva instancia de esta clase
     * @param values los valores base para calcular el promedio
     */
    public AverageRule(ArrayList<Double> values){ 
        this.values = values;
        setIndependence(true);
    }
    
    @Override
    public ArrayList<Double> getValuesFromRule(DataManager manager)
    {
         ArrayList<Double> newValues = new ArrayList<>();
         ArrayList<Double> manValues = manager.getValues();
         this.Value = Finances.Average( manValues, values);
         for(int i=0; i < limit; i++)
             newValues.add(Value * manValues.get(i));
         return newValues;
    }
}
