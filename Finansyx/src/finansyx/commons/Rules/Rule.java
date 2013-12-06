/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Rules;
import finansyx.Exceptions.NotAValidOptionException;
import finansyx.commons.Manage.DataManager;
import java.util.ArrayList;
/**
 *
 * @author t4r0
 */
public class Rule{
    
    /** 
     * El valor base que se utilizará de ser necesario
    * para calcular los valores dependientes
    */
    Double Value=0.;
    
    /**
     * El limite de esta regla
     */
    int limit = 10;
    
    /**
     * Crea una nueva instancia de esta clase
     */
    public Rule(){}
    
    /**
     * Crea una nueva instancia de este objeto
     * @param value El valor base con el que se inicializará esta regla
     * de calculo
     */
    public Rule(Double value){ this.Value = value; }
    
    /**
     * Cambia el valor base del calculo de esta regla de calculo
     * @param value El valor base de la regla de calculo
     */
    public void setValue(Double value){ this.Value = value;}
    
    /**
     * Devuelve el valor base de esta regla de calculo.
     * @return 
     */
    public Double getValue(){ return this.Value; }
    
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
    public ArrayList<Double> getValuesFromRule() throws NotAValidOptionException
    {
        return new ArrayList<>();
    }
}
