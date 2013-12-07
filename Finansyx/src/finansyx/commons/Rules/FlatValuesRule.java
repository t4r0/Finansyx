/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Rules;

import java.util.ArrayList;

/**
 * Una clase abstracta que asigna valores constantes,
 * como regla general de calculo
 * @author t4r0
 */
public class FlatValuesRule extends Rule{
    
    
    public FlatValuesRule(){}
    /**
     * Inicializa una nueva instancia de esta clase
     * @param limit la maxima cantidad de valores que se calcularan
     */
    public FlatValuesRule(int limit){this.limit = limit;}
    
    /**
     * Inicializa una nueva instancia de esta clase
     * @param value un valor constante
     * @param limit la maxima cantidad de valores que se calcularan
     */
    public FlatValuesRule(Double value, int limit){this.limit = limit; this.Value = value;}
    
    @Override
    public ArrayList<Double> getValuesFromRule()
    {
        ArrayList<Double> array = new ArrayList<>();
        for(int i=start; i < limit; i++)
            array.add(Value);
        return array;
    }
    
}
