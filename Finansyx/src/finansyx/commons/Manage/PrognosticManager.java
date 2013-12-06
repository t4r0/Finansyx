/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.Exceptions.NotAValidOptionException;
import finansyx.commons.Rules.PrognosticRule;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class PrognosticManager extends FinancialDataManager{
    
    public PrognosticManager(ArrayList<Double> values, int confidence, int option, Double incremento)
    {
        super(new PrognosticRule(values, confidence, option, incremento));
    }
}
