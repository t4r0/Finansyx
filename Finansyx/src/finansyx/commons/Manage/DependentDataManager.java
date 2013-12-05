/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.commons.Rules.Rule;

/**
 *
 * @author t4r0
 */
public class DependentDataManager extends DataManager{
    
    /**
     * Inicializa una nueva instancia de esta clase
     * @param calcRule la regla de calculo de los valores de este manager
     * @param base El lugar de donde se tomarán los valores base
     */
    public DependentDataManager(Rule calcRule, DataManager base)
    {
        super(calcRule, base);
    }
    
    /**
     * Calcula el valor en base a la regla de calculo especificada
     */
    @Override
    public void Calc()
    {
        this.values = calcRule.getValuesFromRule(base);
    }
    
}
