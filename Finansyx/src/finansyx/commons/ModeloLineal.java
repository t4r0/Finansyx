/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons;

import finansyx.Exceptions.DiferentSizeException;
import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class ModeloLineal extends Modelo{

    public ModeloLineal() {
        super ();
    }
    
    
    @Override
    public void Sumatorias(ArrayList<Integer> y, ArrayList<Double> x)
            throws DiferentSizeException
    {
        Double varX = 0.0;
        try
        {    
            super.Sumatorias(y, x);
            for(Integer i : y)
            {
                varX = x.get(i);
                sumX += varX;
                sumY += i;
                sumXY += varX * i;
            }
        }
        catch (DiferentSizeException e)
        {
            throw e;
        }
    }
    
}
