/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons;
import org.apache.commons.math3.distribution.*;
/**
 *
 * @author t4r0
 */
public class Estadistica {
    
    /**
     * Calcula el valor z, en una distribución normal estándar
     * con los grados de  confianza dados
     * @param confianza = los grados para los cuales se calculará Z
     * @return el valor de Z de acuerdo a una distribución normal estándar
     */
    public static Double zNormal(Double confianza)
    {
        NormalDistribution dist = new NormalDistribution();
        return dist.inverseCumulativeProbability(confianza);
    }
}
