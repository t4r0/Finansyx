/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.CashFlow;

import finansyx.commons.Manage.ArithmeticalManager;
import finansyx.commons.Manage.DataManager;
import finansyx.commons.Rules.Options;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author t4r0
 */
public class CashFlow {
    
    Double lastYearRevenue = 0.;
    Double lasYearCosts = 1.;
    Double percentage = 0.;
    DataManager Revenue = new DataManager();
    DataManager Costs = new DataManager();
    DataManager grossProfit = new DataManager();
    ArrayList<Double> grossProfitPercentage = new ArrayList<>();
    HashMap<String, DataManager> Outlays = new HashMap<>();
    MARRManager marr = new MARRManager();
    
    public CashFlow(DataManager revenue, DataManager costs)
    {
        this.Revenue = revenue;
        this.Costs = costs;
        grossProfit = new ArithmeticalManager(Options.SUBSTRACT, Revenue.getValues(),Costs);
        findPercentage();
        
    }

    public CashFlow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setLastYearRevenue(Double value){this.lastYearRevenue = value;}

    public Double getLastYearRevenue() {
        return lastYearRevenue;
    }

    public void setLasYearCosts(Double lasYearCosts) {
        this.lasYearCosts = lasYearCosts;
    }

    public Double getLasYearCosts() {
        return lasYearCosts;
    }
    
    public final void findPercentage()
    {
        ArrayList<Double> rvnue = Revenue.getValues();
        ArrayList<Double> csts = Costs.getValues();
        for(int i=0; i< rvnue.size(); i++)
            grossProfitPercentage.add(1 - (rvnue.get(i) / csts.get(i)));
        percentage =  1 - (lastYearRevenue / lasYearCosts);
    }
    
    public void AddOutlay(String name, DataManager manager)
    {
        String Name = name.toUpperCase();
        this.Outlays.put(Name, Revenue);
    }
    
    public DataManager getOutLay(String name)
    {
        String Name = name.toUpperCase();
        return Outlays.get(Name);
    }

    public MARRManager getMarr() {
        return marr;
    }

    public void setMarr(MARRManager marr) {
        this.marr = marr;
    }   
}
