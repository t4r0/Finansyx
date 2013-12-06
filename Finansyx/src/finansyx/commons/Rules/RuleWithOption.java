/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Rules;

/**
 * Representa una regla con opciones
 * @author t4r0
 */
public class RuleWithOption extends Rule{
    int option = -1;
    
    /**
     * Inicializa una instancia de esta clase
     */
    public RuleWithOption(){};
    /**
     * Inicializa una instancia de esta clase
     * @param option la opcion que se utilizará para calcular los valores aqui
     */
    public RuleWithOption(int option){this.option = option;}
    
    /**
     * Inicializa una instancia de esta clase
     * @param value El valor con el que se inicializará
     */
    public RuleWithOption(Double value){ super(value);}
    
    /**
     * Devuelve la opcion que contiene esta regla
     * @return 
     */
    public int getOption(){return option;}
    
    /**
     * Se cambia la opcion, con la que se calcularan los valores
     * @param value el valor que se asignará
     */
    public void setOption(int value){this.option = value;}
}
