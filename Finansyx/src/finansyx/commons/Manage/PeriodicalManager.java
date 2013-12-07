/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.Rule;
import java.util.HashMap;
import javax.print.attribute.HashAttributeSet;

/**
 *
 * @author t4r0
 */
public class PeriodicalManager extends FinancialDataManager{

    HashMap<Integer, Rule> rules = new HashMap<>();
    
    public PeriodicalManager(HashMap<Integer, Rule> rules) {
        this.rules = rules;
    }
    
    
}
