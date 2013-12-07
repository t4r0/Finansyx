/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.FeeRule;
import finansyx.commons.Statistics;

/**
 *
 * @author t4r0
 */
public class FeeManager extends FinancialDataManager{
    
    public FeeManager(Double A, int p, int n, Double j, int option)
    {
        super(new FeeRule(A, p, n, j, option));
    }
    
     public FeeManager(Double A, int p, int n, String j, int option)
    {
        super(new FeeRule(A, p, n, Statistics.percentageFromString(j), option));
    }
}
