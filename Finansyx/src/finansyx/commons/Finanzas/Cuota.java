/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Finanzas;

/**
 * Representa cuotas de pago de prestamos y otros
 * @author t4r0
 */
public class Cuota {
    private Integer numero = 0;
    private Double renta = 0.;
    private Double intereses = 0.;
    private Double amortizacion = 0.;
    private Double capital = 0.;
    
    /**
     * Inicializa una instancia de la clase Cuota
     */
    public Cuota(){}
    /**
     * Inicializa una instancia de la clase, con los valores dados
     * @param num - el numero de cuota, almacenada
     * @param renta - la renta de esta cuota
     * @param intereses - los intereses de esta cuota
     * @param amortizacion - la amortización de esta cuota
     * @param capital - el saldo después de pagar esta cuota
     */
    public Cuota(Integer num, Double renta,
            Double intereses, Double amortizacion, Double capital)
    {
        this.numero = num;
        this.amortizacion = amortizacion;
        this.renta = renta;
        this.intereses = intereses;
        this.capital = capital;
    }

    /**
     * @return la amortizacion de esta cuota
     */
    public Double getAmortizacion() {
        return amortizacion;
    }

    /**
     * @return el capital despues de pagar esta cuota
     */
    public Double getCapital() {
        return capital;
    }

    /**
     * @return los intereses a pagar en esta cuota
     */
    public Double getIntereses() {
        return intereses;
    }

    /**
     * @return el numero de cuota almacenada
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * @return la renta a pagar en esta cuota
     */
    public Double getRenta() {
        return renta;
    }

    /**
     * @param amortizacion la amortización de esta cuota
     */
    public void setAmortizacion(Double amortizacion) {
        this.amortizacion = amortizacion;
    }

    /**
     * Establece el capital restante después de pagar esta cuota
     * @param capital el capital despues de pagar esta cuota
     */
    public void setCapital(Double capital) {
        this.capital = capital;
    }

    /**
     * Establece los intereses que se pagarán en esta cuota
     * @param intereses 
     */
    public void setIntereses(Double intereses) {
        this.intereses = intereses;
    }

    /**
     * Establece el numero de cuota almacenada
     * @param numero 
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Establece la renta de esta cuota
     * @param renta 
     */
    public void setRenta(Double renta) {
        this.renta = renta;
    }   

    @Override
    public String toString() {
        return "||" + numero + " | "
                + Finanzas.Aproximar(renta, 2) + " | " +
                Finanzas.Aproximar(intereses, 2) + " | "
                + Finanzas.Aproximar(amortizacion, 2) + " | "
                + Finanzas.Aproximar(capital, 2 ) + " ||";//To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
