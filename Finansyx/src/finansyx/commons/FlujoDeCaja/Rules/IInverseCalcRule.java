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
public interface IInverseCalcRule extends ICalcRule{
    public Financiera CalcularInverso(Financiera a);
    public Financiera CalcularInverso(Financiera a, Integer inicio);
}