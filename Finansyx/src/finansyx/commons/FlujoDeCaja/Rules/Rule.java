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
public class Rule implements ICalcRule{

     Double Value = 0.;
     Integer largo = 0;
     Financiera origen = new Financiera();
     Financiera destino = new Financiera();
     
    public Rule() {
    }

    public Rule(Double value, Integer largo)
    {
        this.Value = value;
        this.largo = largo;
    }
    
    public Rule(Financiera origen, Financiera destino, Double value)
    {
        this.origen = origen;
        this.destino = destino;
        this.Value = value;
    }

    public Financiera getDestino() {
        return destino;
    }

    public Integer getLargo() {
        return largo;
    }

    public Financiera getOrigen() {
        return origen;
    }

    public void setDestino(Financiera destino) {
        this.destino = destino;
    }

    public void setLargo(Integer largo) {
        this.largo = largo;
    }

    public void setOrigen(Financiera origen) {
        this.origen = origen;
    }
    
    public Double getValue()
    {
        return Value;
    }
    
    public void setValue(Double value)
    {
        Value = value;
    }    
            
    @Override
    public void Calcular() { }

    @Override
    public void Calcular(Integer inicio) { }
    
    
    
    
}
