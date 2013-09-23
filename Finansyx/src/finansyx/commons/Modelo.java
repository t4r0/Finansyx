/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons;
import java.util.ArrayList;
import finansyx.Exceptions.*;
        
/**
 *
 * @author t4r0
 */
public class Modelo {

    //Variables que forman parte de la ecuación
    Double A=0.0 ,  a= 0.0, b= 0.0, c= 0.0, n=0.0;
    
    //Variables que ayudan a la toma de decisión
    Double Sxy=0.0, r=0.0, r2=0.0;
    
    //Sumatorias
    Double sumX, sumY, sumXY, sumX2, sumY2;
    
    public Modelo() {
    }
    
    public void Sumatorias(ArrayList<Integer> y, ArrayList<Double> x) throws 
            DiferentSizeException
    {
        if(y.size() != x.size())
            throw new DiferentSizeException();
    }
}
