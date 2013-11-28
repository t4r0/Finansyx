/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja;

import java.util.ArrayList;

/**
 *
 * @author t4r0
 */
public class FlujoDeCaja {
    
    Ingresos ingresos = new Ingresos();
    Gastos costos = new Gastos();
    Financiera UBruta = new Financiera();
    Financiera UAI = new Financiera();
    private ArrayList<Financiera> gastos = new ArrayList<>(3);

    public FlujoDeCaja() {
        gastos.add(ingresos);
        gastos.add(costos);
        gastos.add(UBruta);
    }

    public void setCostos(Gastos costos) {
        this.costos = costos;
        gastos.set(1, this.costos);
    }

    public Gastos getCostos() {
        return costos;
    }
    
    public Ingresos getIngresos() {
        return ingresos;
    }

    public Financiera getUAI() {
        return UAI;
    }

    public Financiera getUBruta() {
        return UBruta;
    }

    public void setGastos(ArrayList<Financiera> gastos) {
        this.gastos = gastos;
    }

    public void setIngresos(Ingresos ingresos) {
        this.ingresos = ingresos;
        this.gastos.set(0, ingresos);
    }

    public void setUAI(Financiera UAI) {
        this.UAI = UAI;
    }

    public void setUBruta(Financiera UBruta) {
        this.UBruta = UBruta;
        this.gastos.set(2, this.UBruta);
    } 
    
    public ArrayList<Financiera> getGastos()
    {
        return gastos;
    }
    
    public Financiera getGastos(int i)
    {
        return gastos.get(i);
    }
    
}
