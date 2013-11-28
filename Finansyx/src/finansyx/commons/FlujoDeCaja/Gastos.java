/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja;

import finansyx.commons.FlujoDeCaja.Rules.Rule;


/**
 *
 * @author t4r0
 */
public class Gastos extends Financiera {

  
    
    public Gastos() {
    }   
  
    public Gastos(String Titulo, Rule regla)
    {
        setTitulo(Titulo);
        setRule(regla);
        getRule().Calcular();
    }
    
}
