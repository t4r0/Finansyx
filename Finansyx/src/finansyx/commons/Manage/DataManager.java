/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Manage;


import finansyx.commons.Rules.Rule;
import java.util.ArrayList;
/**
 *
 * @author t4r0
 */
public class DataManager {
    DataManager base = null;
    ArrayList<Double> values = new ArrayList<>();
    Rule calcRule = new Rule();
    String name = "";
    ArrayList<DataManager> related = new ArrayList<>();
    public DataManager() {
    }
    
    public DataManager(Rule calcRule)
    {
        this.calcRule = calcRule;
        this.values = calcRule.getValuesFromRule();
    }
    
    /**
     * Inicializa una nueva instancia de esta clase
     * @param calcRule la regla de calculo de los valores de este manager
     * @param base El lugar de donde se tomarán los valores base
     */
    public DataManager(Rule calcRule, DataManager base)
    {
        this.calcRule = calcRule;
        this.base = base;
        this.values = calcRule.getValuesFromRule(base);
    }
    
    public void UpdateRelated(DataManager man)
    {
        for(DataManager rel: related)
        {
            rel.base = man;
            man.AddRelated(rel);
        }
        related.clear();
    }
    
    private void AddRelated(DataManager man)
    {
        this.related.add(man);
    }
    /**
     * Calcula el valor en base a la regla de calculo especificada
     */
    public void Calc() 
    {
        this.values = calcRule.getValuesFromRule();
    }

    public DataManager getBase() {
        return base;
    }

    public Rule getCalcRule() {
        return calcRule;
    }

    public ArrayList<Double> getValues() {
        return values;
    }

    public void setBase(DataManager base) {
        this.base = base;
    }

    public void setCalcRule(Rule calcRule) {
        this.calcRule = calcRule;
    }

    public void setValues(ArrayList<Double> values) {
        this.values = values;
    }  
    
    public Integer getLimit()
    {
        return calcRule.getLimit();
    }
    
    public String getName()
    {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    public void setLimit(Integer limit, Integer start)
    {
        calcRule.setLimit(limit, start);
        this.values = new ArrayList<>();
        Calc();
    }
    
    @Override
    public String toString()
    {
        String cadena = "";
        for(Double value : values)
            cadena += value + " | ";
        return cadena;
    }
    
}
