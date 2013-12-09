
package finansyx.commons.CashFlow;

import finansyx.commons.Finances.Finances;
import finansyx.commons.Finances.Fiscal.GTAcreditation;
import finansyx.commons.Finances.Fiscal.GtTaxesManager;
import finansyx.commons.Manage.ArithmeticalManager;
import finansyx.commons.Manage.DataManager;
import finansyx.commons.Manage.DepreciationManager;
import finansyx.commons.Manage.FinancialDataManager;
import finansyx.commons.Rules.Options;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author t4r0
 */
public class CashFlow {
    /**
     * Indica si las cantidades de este flujo de caja son brutas
     */
    public static final int GROSS = 20;
    
    /**
     * Indica si las cantidades de este flujo de caja son netas
     */
    public static final int NET = 24;
     
   Integer regime = -1;
    /**
     * El año de inicio
     */
    Integer start = 2013;
    
    /**
     * Indica la forma en que se tratarán las cantidades
     */
    Integer type = CashFlow.NET;
    
    /**
     * La inversión inicial
     */
    Double investment = 0.;
    
    /**
     * Los activos que posee la empresa
     */
    Double assets = 0.;
    
    /**
     * Los ingresos del año pasado
     */
    Double lastYearRevenue = 0.;
    
    /**
     * Los costos del año pasado
     */
    Double lasYearCosts = 1.;
    
    /**
     * El porcentaje de utilidad del año pasado
     */
    Double percentage = 0.;
    
    /**
     * Indica si es una empresa que se dedica al comercio
     */
    Boolean commerce = true;
    
    /**
     * Un administrador de los inversionistas y la tasa menor atractiva
     * de retorno.
     */
    MARRManager marr = new MARRManager();
    
    /**
     * Los ingresos de este año
     */
    FinancialDataManager Revenue = new FinancialDataManager();
    
    /**
     * Los costos de este año
     */
    FinancialDataManager Costs = new FinancialDataManager();
    
    /**
     * La utilidad bruta de la pronosticación
     */
    DataManager grossProfit = new DataManager();
    
    /**
     * El porcentaje de utilidad bruta
     */
    ArrayList<Double> grossProfitPercentage = new ArrayList<>();
    
    /**
     * Los outgoings de esta pronosticacion
     */
    HashMap<String, FinancialDataManager> Outlays = new HashMap<>();
  
    ArrayList<Double> outgoings = new  ArrayList<>();
    
    ArrayList<Double> PBT = new ArrayList<>();
    
    ArrayList<Double> outlaysWithBill  = new ArrayList<>();
    
    ArrayList<Double> outlaysWithOutBill  = new ArrayList<>();
    
    ArrayList<Double> shields = new ArrayList<>();
    
    ArrayList<Double> asset = new ArrayList<>();
    
    Double IRR = 0.0;
    
    ArrayList<Double> netProfit = new ArrayList<>();
    
    ArrayList<Double> actualNetValue =new ArrayList<>();
    
    ArrayList<Double> effectiveNetIncome = new ArrayList<>();
    
    GtTaxesManager taxes = new GtTaxesManager();
    
    /**
     * Crea una nueva instancia de esta clase
     * @param revenue los ingresos 
     * @param costs los costos
     */
    public CashFlow(FinancialDataManager revenue, FinancialDataManager costs)
    {
        this.Revenue = revenue;
        this.Costs = costs;
        grossProfit = new ArithmeticalManager(Options.SUBSTRACT, Revenue.getValues(),Costs);
        findPercentage();        
    }

    /**
     * Inicializa una instancia de esta clase
     */
    public CashFlow() {
       
    }

    public Double getInvestment() {
        return investment;
    }

    public void setInvestment(Double investment) {
        this.investment = investment;
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

    public FinancialDataManager getCosts() {
        return Costs;
    }

    public ArrayList<Double> getOutgoings() {
        return outgoings;
    }

    public ArrayList<Double> getOutlaysWithBill() {
        return outlaysWithBill;
    }

    public ArrayList<Double> getOutlaysWithOutBill() {
        return outlaysWithOutBill;
    }
    
    public FinancialDataManager getRevenue() {
        return Revenue;
    }
    
    public Double getIRR()
    {
        return IRR;
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

    public DataManager getGrossProfit() {
        return grossProfit;
    }

    public ArrayList<Double> getGrossProfitPercentage() {
        return grossProfitPercentage;
    }

    public HashMap<String, FinancialDataManager> getOutlays() {
        return Outlays;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setCosts(FinancialDataManager Costs) {
        this.Costs = Costs;
        if(!Revenue.getValues().isEmpty() && !Costs.getValues().isEmpty())
        {
            grossProfit = new ArithmeticalManager(Options.SUBSTRACT,Revenue.getValues(), Costs);
            findPercentage();
        }
    }

    public void setGrossProfit(DataManager grossProfit) {
        this.grossProfit = grossProfit;
    }

    public void setGrossProfitPercentage(ArrayList<Double> grossProfitPercentage) {
        this.grossProfitPercentage = grossProfitPercentage;
    }

    public void setOutlays(HashMap<String, FinancialDataManager> Outlays) {
        this.Outlays = Outlays;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public void setRevenue(FinancialDataManager Revenue) {
        this.Revenue = Revenue;
        if(!Revenue.getValues().isEmpty() && !Costs.getValues().isEmpty())
        {
            grossProfit = new ArithmeticalManager(Options.SUBSTRACT,Revenue.getValues(), Costs);
            findPercentage();
        }
    }
    
    public void setLastYearRevenue(Double value){
        this.lastYearRevenue = value;
        this.percentage =  percentage =  1 - (lastYearRevenue / lasYearCosts);
    }

    public Double getLastYearRevenue() {
        return lastYearRevenue;
    }

    public ArrayList<Double> getAllRevenues()
    {
        ArrayList<Double> arr = new ArrayList<>();
        arr.add(lastYearRevenue);
        arr.addAll(Revenue.getValues());
        return arr;
    }
    public void setLasYearCosts(Double lasYearCosts) {
        this.lasYearCosts = lasYearCosts;
        this.percentage =  percentage =  1 - (lastYearRevenue / lasYearCosts);
    }

    public Double getLasYearCosts() {
        return lasYearCosts;
    }
    
    public final void findPercentage()
    {
        ArrayList<Double> rvnue = Revenue.getValues();
        ArrayList<Double> csts = Costs.getValues();
        for(int i=0; i< rvnue.size(); i++)
            grossProfitPercentage.add(1 - (csts.get(i) / rvnue.get(i)));
        percentage =  1 - (lasYearCosts/ lastYearRevenue);
    }
    
    public void AddOutlay(String name, FinancialDataManager manager)
    {
        String Name = name.toUpperCase();
        if(Name.equalsIgnoreCase("ingresos"))
            this.setRevenue(manager);
        else
            if(Name.equalsIgnoreCase("costos"))
            this.setCosts(manager);
            else
            {
              this.Outlays.put(Name, manager);
              makeSum();
            }
    }
    
    public void AddAsset(String name, DepreciationManager manager)
    {
        int size = manager.getValues().size();
        ArrayList<Double> val = manager.getActualValues();
        int aSize = asset.size();
        if(asset.isEmpty())
            asset.addAll(val);
        else
        {
            for(int i=0; i < size; i ++)
            {
                if(i >= aSize)
                    asset.add(val.get(i));
                else
                {           
                        asset.set(i,asset.get(i) + val.get(i));
                }
            }
        }
        this.AddOutlay(name, manager);
    }
    
    public Double getAsset(Integer i)
    {
        if(i >= asset.size())
            return 0.;
        return asset.get(i);
    }
    
    public ArrayList<Double> getAsset()
    {
        return asset;
    }
    
    public FinancialDataManager getOutLay(String name)
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
    
    public ArrayList<Double> getAllProfitPercentage()
    {
        ArrayList<Double> per = new ArrayList<>();
        per.add(percentage);
        per.addAll(grossProfitPercentage);
        return per;
    }
    
    public void makeSum()
    {
        int size=0;
        ArrayList<Double> values = null;
        Double sum = 0.;
        Double pbt = 0.;
        Double bill = 0.;       
        Double current = 0.;
        Double shield = 0.;
        
        outgoings.clear();
        PBT.clear();
        outlaysWithBill.clear();
        outlaysWithOutBill.clear();
        shields.clear();
        for(int i=0; i<10; i++)
        {
            sum = 0.;
            bill = 0.;          
            shield = 0.;
            if(Costs.hasBill())
                    bill = Costs.getValues().get(i);
            for(FinancialDataManager man : Outlays.values())
            {
                values = man.getValues();
                size = values.size();
                
                if(i < size)
                {
                    current = values.get(i);
                    if(man.hasBill())
                        bill += current;                    
                    sum += values.get(i);
                    
                    if(man.isShield())
                        shield += current;
                }                   
            }
            pbt = grossProfit.getValues().get(i) - sum;
            PBT.add(pbt);
            outgoings.add(sum);
            outlaysWithBill.add(bill);
            outlaysWithOutBill.add(sum + Costs.getValues().get(i)  - bill);
            shields.add(shield);
        }
    }
    
    public ArrayList<Double> CalcNetProfit(int Type)
    {
        ArrayList<Double> prof = new ArrayList<>();
        taxes = new GtTaxesManager(Type, this);
        ArrayList<Double> imp = taxes.calcTaxes();
        for(int i=0; i < PBT.size(); i++)
            prof.add(PBT.get(i) - taxes.values.get(i));
        return prof;
    }
    
    public void CalcNetProfit()
    {
        netProfit = this.CalcNetProfit(this.regime);
    }
    public ArrayList<Double> CalcEffectiveNetIncome(ArrayList<Double> netProfit)
    {
        ArrayList<Double> eff = new ArrayList<>();
        for(int i=0; i< netProfit.size(); i++)
            eff.add(netProfit.get(i) + shields.get(i));
        return eff;
    }
    
    public void CalcEffectiveNetIncome()
    {
       effectiveNetIncome = this.CalcEffectiveNetIncome(netProfit);
    }
    
    public void ReCalc()
    {
        Revenue.Calc();
        Costs.Calc();
        grossProfit = new ArithmeticalManager(Options.SUBSTRACT, Revenue.getValues(),Costs);
        for(FinancialDataManager man : Outlays.values())
            man.Calc();
        makeSum();
        CalcNetProfit();
        CalcEffectiveNetIncome();
        CalcActualNetValue();
        IRR();
    }
    
    public ArrayList<Double> CalcActualNetValue(ArrayList<Double> list)
    {
       return  marr.actualNetValue(list);
    }  
    
    public void CalcActualNetValue()
    {
        actualNetValue = CalcActualNetValue(effectiveNetIncome);
    }
    public Double IRR(ArrayList<Double> list)
    {
        return Finances.IRR(list);
    }
    
    public Double IRR()
    {
        ArrayList<Double> income = new ArrayList<>();
        income.add(assets * -1.0);
        income.addAll(actualNetValue);
        return IRR = Finances.IRR(income);
    }
    public void Optimize()
    {
        ArrayList<Double> netprof = CalcNetProfit(GTAcreditation.ISO_ISR);
        ArrayList<Double> netprof2 = CalcNetProfit(GTAcreditation.ISR_ISO);
        
        ArrayList<Double> act1 = new ArrayList<>();
        act1.add(assets * -1.0);
        act1.addAll(CalcActualNetValue(CalcEffectiveNetIncome(netprof)));
        
        ArrayList<Double> act2 = new ArrayList<>();
        act2.add(assets * -1.0);
        act2.addAll(CalcActualNetValue(CalcEffectiveNetIncome(netprof2)));
        
        Double irr1 = IRR(act1);
        Double irr2 = IRR(act2);
        
        if(irr1 > irr2)
            this.regime = GTAcreditation.ISO_ISR;
        else
            this.regime = GTAcreditation.ISR_ISO;
        CalcNetProfit();
        CalcEffectiveNetIncome();
        CalcActualNetValue();
        IRR();
    }
}
