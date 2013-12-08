/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import java.util.ArrayList;


/**
 *
 * @author t4r0
 */
public class PeriodicalManager extends FinancialDataManager{

    ArrayList<DataManager> managers = new ArrayList<>();
    Integer now = 0;
    public PeriodicalManager()
    {
        
    }     
    
    public PeriodicalManager(ArrayList<DataManager> managers) {
        this.managers= managers;
        this.Calc();
    }

    public void addManager(DataManager manager, Integer limit)
    {
        manager.setLimit( limit + now, now);
        managers.add(manager);
        now += limit;
        Calc();
    }
    @Override
    public final void Calc(){
        values.clear();
        for(DataManager manager : managers)
          values.addAll(manager.values);        
    }
    
    
}
