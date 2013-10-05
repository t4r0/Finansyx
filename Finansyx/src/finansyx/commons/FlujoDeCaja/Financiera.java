/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja;

import finansyx.commons.FlujoDeCaja.Rules.Rule;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class Financiera {
    
    private String titulo = "Valores";
    private Boolean factura = false;
    private Rule ReglaDeCalculo = new Rule();
    private ArrayList<Double> valores = new ArrayList<Double>();
    
    public Financiera(){}
    
    public Financiera(ArrayList<Double> inicialvalues)
    {
        this.valores = inicialvalues;
    }
    
    public ArrayList<Double> getValues()
    {
        return valores;
    }
    
     public void Add(Double value)
    {
        valores.add(value);
    }
    
}
