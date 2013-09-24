/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx;

import finansyx.commons.Pronosticos.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author t4r0
 */
public class Finansyx {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> keys = new ArrayList<Integer>(
                Arrays.asList(new Integer[]{1,2,3,4}));
        ArrayList<Double> values = new ArrayList<Double>(
                Arrays.asList(new Double[]{29.0, 29.5, 39.0, 60.0}));
        ModeloLineal modl= new ModeloLineal(keys, values);
        ModeloPolinomial modP = new ModeloPolinomial(keys, values);
        System.out.println(modl.toString());
        System.out.println(modP.toString());
    }
}
