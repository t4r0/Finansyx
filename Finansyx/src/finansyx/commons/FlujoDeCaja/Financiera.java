/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.FlujoDeCaja;

import finansyx.commons.FlujoDeCaja.Rules.Rule;
import java.util.ArrayList;

/**
 *La clase financiera representa una abstracción de la información financiera
 * @author t4r0
 */
public class Financiera {
    //El titulo o la forma en que se identifica esta información financiera
    private String titulo = "Valores";
    
    //Si se tiene un comprobante el cual será usado para pagar impuestos
    private Boolean factura = false;
    
    //La Regla con la que se calcularan los valores de esta información
    private Rule ReglaDeCalculo = new Rule();
    private ArrayList<Double> valores = new ArrayList<>();
    
    public Financiera(){}
    
    /**
     * Inicializa una nueva instancia de esta clase con valores iniciales
     * @param inicialvalues 
     */
    public Financiera(ArrayList<Double> inicialvalues)
    {
        this.valores = inicialvalues;
    }
    
    /**
     * 
     * @return los valores de esta instancia
     */
    public ArrayList<Double> getValues()
    {
        return valores;
    }
    
    /**
     * Agrega un valor a esta instancia
     * @param value el valor que se desea agregar
     */
     public void Add(Double value)
    {
        valores.add(value);
    }
    
}
