/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;

/**
 *
 * @author t4r0
 */
public class InverseRule extends Rule implements IInverseCalcRule{

    @Override
    public void Calcular()
    {
        CalcularInverso();
    }
    
    @Override
    public void Calcular(Integer inicio)
    {
        CalcularInverso(inicio);
    }
    
    @Override
    public void CalcularInverso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void CalcularInverso(Integer inicio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
