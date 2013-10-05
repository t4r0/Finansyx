/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;
import finansyx.commons.FlujoDeCaja.*;
import java.util.ArrayList;

/**
 * Regla que calcula los valores de cierta información financiera a partir
 * de un porcentaje dado
 * @author t4r0
 */
public class PercentageCalcRule extends InverseRule{

   
    public PercentageCalcRule() {
    }

    /**
     * Inicializa una instancia de esta clase, con el porcentaje indicado
     * @param percentage - El porcentaje que se utilizara para calcular los valores
     */
    public PercentageCalcRule(Double percentage)
    {
        Value = percentage;
    }
    
    /**
     * Calcula los valores en base al porecntaje especificado
     * y a la información almacenada 
     * @param a - la información a partir de la cual se calculará la información almacenada
     * en el propietarios de esta regla
     * @return Información calculada en base al porcentaje e información dada
     */
    @Override
    public Financiera CalcularInverso(Financiera a) {
        ArrayList<Double> ing, gast;
        ing = a.getValues();
        gast = new ArrayList<>();;
      for(int i=0; i < largo; i++)
          gast.add(ing.get(i) * Value);
      return new Financiera(gast);
    }
    
    /**
     * Calcula información en base a al porcentaje dado y la información dada, 
     * en el intervalo especificado
     * @param a - La información que se tomará de base para calcular la nueva información
     * financiera
     * @param inicio - el periodo en que iniciará el cálculo de esta información
     * @return Información financiera calculada en base a los porcentajes dados
     */

    @Override
    public Financiera CalcularInverso(Financiera a, Integer inicio) {
        ArrayList<Double> ing, gast;
        ing = a.getValues();
        gast = new ArrayList<Double>();
      for(int i=inicio; i < largo; i++)
          gast.add(ing.get(i) * Value);
      return new Financiera(gast);
    }
    
    
    
    
}
