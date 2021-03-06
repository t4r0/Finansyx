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
    
    /** 
     * El valor base que se utilizará de ser necesario
    * para calcular los valores dependientes
    */
    Double Value=0.;
    
    /**
     * Verifica si una regla es dependiente de otros valores
     */
    Boolean independence = false;
    
    /**
     * El limite inicial de esta regla
     */
    int start = 0;
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
     * Obtiene el límite del calculo de esta regla
     * @return 
     */
    public int getLimit() {
        return limit;
    }

    /**
     * Devuelve el inicio del calculo de esta regla
     * @return 
     */
    public int getStart()
    {
        return start;
    }
    /**
     * Dice si una regla es independiente o no
     * @return 
     */    
    public Boolean isIndependient()
    {
        return independence;
    }
    
    /**
     * Establece si una regla es independiente o no
     * @param value 
     */
    public void setIndependence(Boolean value)
    {
        this.independence = value;
    }
    /**
     * Establece el limite de calculo de esta regla
     * @param limit la cantidad de veces que se calculará un valor
     * @param start el inicio de los calculos de este valor
     */
    public void setLimit(int limit, int start) {
        this.limit = limit;
        this.start = start;
    }    
    
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
    public ArrayList<Double> getValuesFromRule()
    {
        return new ArrayList<>();
    }
}
