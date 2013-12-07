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
