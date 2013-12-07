
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
    
    public static final int GROSS = 20;
    public static final int NET = 24;
     
    Integer start = 2013;
    Integer type = 0;
    
    Double assets = 0.;
    Double lastYearRevenue = 0.;
    Double lasYearCosts = 1.;
    Double percentage = 0.;
    Boolean commerce = true;
    
    MARRManager marr = new MARRManager();
    
    DataManager Revenue = new DataManager();
    DataManager Costs = new DataManager();
    DataManager grossProfit = new DataManager();
    ArrayList<Double> grossProfitPercentage = new ArrayList<>();
    HashMap<String, DataManager> Outlays = new HashMap<>();
  
    
    public CashFlow(DataManager revenue, DataManager costs)
    {
        this.Revenue = revenue;
        this.Costs = costs;
        grossProfit = new ArithmeticalManager(Options.SUBSTRACT, Revenue.getValues(),Costs);
        findPercentage();        
    }

    public CashFlow() {
       
    }

    public Double getAssets() {
        return assets;
    }

    public void setAssets(Double assets) {
        this.assets = assets;
    }
    
    public Boolean isCommerce() {
        return commerce;
    }

    public void setCommerce(Boolean commerce) {
        this.commerce = commerce;
    }
    
    public void setStart(Integer value)
    {
        this.start = value;
    }

    public Integer getStart() {
        return start;
    }   

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public DataManager getCosts() {
        return Costs;
    }

    public DataManager getGrossProfit() {
        return grossProfit;
    }

    public ArrayList<Double> getGrossProfitPercentage() {
        return grossProfitPercentage;
    }

    public HashMap<String, DataManager> getOutlays() {
        return Outlays;
    }

    public Double getPercentage() {
        return percentage;
    }

    public DataManager getRevenue() {
        return Revenue;
    }

    public void setCosts(DataManager Costs) {
        this.Costs = Costs;
    }

    public void setGrossProfit(DataManager grossProfit) {
        this.grossProfit = grossProfit;
    }

    public void setGrossProfitPercentage(ArrayList<Double> grossProfitPercentage) {
        this.grossProfitPercentage = grossProfitPercentage;
    }

    public void setOutlays(HashMap<String, DataManager> Outlays) {
        this.Outlays = Outlays;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setRevenue(DataManager Revenue) {
        this.Revenue = Revenue;
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
