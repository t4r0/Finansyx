/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Pronosticos;

import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class ModelManager {
    
    ArrayList<Modelo> modelos = new ArrayList<Modelo>();
    public ModelManager(){}
    
    public ModelManager(ArrayList<Modelo> modelos){ this.modelos= modelos;}
    
    public Modelo get(int i)
    {
        return modelos.get(i);
    }
    
    public void Add(Modelo modelo)
    {
        modelos.add(modelo);
    }
    
    public int Size()
    {
        return modelos.size();
    }
}
