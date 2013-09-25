/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja.Rules;
import finansyx.commons.FlujoDeCaja.Gastos;
import finansyx.commons.FlujoDeCaja.Ingresos;

/**
 *
 * @author t4r0
 */
public interface IInverseCalcRule extends ICalcRule{
    void CalcularInverso(Ingresos a, Gastos b);
    void CalcularInverso(Ingresos a, Gastos b, Integer inicio);
}
