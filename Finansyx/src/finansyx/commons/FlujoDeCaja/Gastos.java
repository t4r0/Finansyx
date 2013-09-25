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
public class Gastos {

    private String titulo = "Gastos";
    private Boolean factura = false;
    private Rule ReglaDeCalculo = new Rule();
    private ArrayList<Double> valores = new ArrayList<Double>();
    
    public Gastos() {
    }
    
    public ArrayList<Double> getValues()
    {
        return valores;
    }
    
}
