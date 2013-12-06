/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.*;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class ArithmeticalManager extends DependentDataManager{

    public ArithmeticalManager(int option, ArrayList<Double> values, DataManager base) {
        super(new ArithmeticalRule(option, values), base);
    }
    
}
