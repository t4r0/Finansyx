/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.CashFlow;

import java.util.HashMap;

/**
 *
 * @author t4r0
 */
public class FinancialPlanning {

    HashMap<String, CashFlow> scenarios = new HashMap<>();
    CashFlow main= new CashFlow();
    public FinancialPlanning() {
    }
    
    public void addCashFlow(String name, CashFlow cashFlow)
    {
        if(scenarios.isEmpty())
            main = cashFlow;
        this.scenarios.put(name, cashFlow);
    }
    
    public void createScenario(HashMap<String, Double> map,String name)
    {
        addCashFlow(name, main.generateScenario(map));
    }
}
