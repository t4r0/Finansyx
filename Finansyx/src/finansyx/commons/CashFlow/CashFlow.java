/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.CashFlow;

import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author t4r0
 */
public class CashFlow {
    
    Double lastYearRevenue = 0.;
    Double lasYearCosts = 0.;
    DataManager Revenue = new DataManager();
    DataManager Costs = new DataManager();
    ArrayList<Double> grossProfit = new ArrayList<>();
    ArrayList<Double> grossProfitPercentage = new ArrayList<>();
    HashMap<String, DataManager> Outlays = new HashMap<>();
    
    public CashFlow()
    {
        
    }
}
