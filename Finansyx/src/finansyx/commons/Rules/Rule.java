/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Rules;
import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;
/**
 *
 * @author t4r0
 */
public class Rule{
    
    // El valor base que se utilizará de ser necesario
    // para calcular los valores dependientes
    Double Value=0.;
    int limit = 10;
    public Rule(){}
    
    /**
     * Crea una nueva instancia de este objeto
     * @param value El valor base con el que se inicializará esta regla
     * de calculo
     */
    public Rule(Double value){ this.Value = value; }
    
    /**
     * Regresa los valores calculados, por esta regla de calculo
     * @param manager el manager base, a partir del cual se calcularán los nuevos valores
     * @return una lista de valores, calculados en base a los parametros de esta regla
     */
    public ArrayList<Double> getValuesFromRule(DataManager manager)
    {
        return manager.getValues();
    }
    
    /**
     * Regresa los valores, calculados por esta regla
     * @return una lista de valores, calculados arbitrariamente.
     */
    public ArrayList<Double> getValuesFromRule()
    {
        return new ArrayList<>();
    }
}
