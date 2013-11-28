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
public class Ingresos extends Financiera{

    ArrayList<Double> valores = new ArrayList<>();
    public Ingresos() {
    }
   
    public Ingresos(String titulo, Rule regla)
    {
        setTitulo(titulo);
        setRule(regla);
        getRule().Calcular();
    }
}
