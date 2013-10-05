/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;
import finansyx.commons.FlujoDeCaja.*;
/**
 *
 * @author t4r0
 */
public interface ICalcRule {
    public Financiera Calcular();
    public Financiera Calcular(Integer inicio);
}
