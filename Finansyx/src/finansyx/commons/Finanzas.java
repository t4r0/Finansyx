/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons;

/**
 *
 * @author t4r0
 */
public class Finanzas {
    /**
     * Calcula la tasa minima atractiva de retorno
     * @param i = premio al riesgo
     * @param f = inflacion
     * @return 
     */
    public static Double TMAR(Double i, Double f)
    {
        return i + f + i*f;
    }
    
}
