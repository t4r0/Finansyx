/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.AverageRule;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class AverageManager extends DependentDataManager{

    /**
     * Crea un nuevo Manager usando como regla el promedio
     * @param manager El manager en el que se basarán los valores de este
     * @param values Los valores iniciales para calcular el promedio
     */
    public AverageManager(DataManager manager, ArrayList<Double> values) {
        super(new AverageRule(values), manager);
    }
    
}
