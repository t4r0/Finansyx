/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons;

/**
 *
 * @author t4r0
 */
public class Finanzas {
    /**
     * Calcula la tasa minima atractiva de retorno
     * @param i = premio al riesgo
     * @param f = inflacion
     * @return la tasa minimia atractiva de retorno
     */
    public static Double TMAR(Double i, Double f)
    {
        return i + f + i*f;
    }
   
    /**
     * 
     * @param base = El precio base del gasto
     * @param percentage = El porcentaje anual en que crecerá la base
     * @param yearBase = El año base
     * @param yearPronostic = El año de pronóstico
     * @return El valor de un gasto en el año de pronostico
     */
    public static Double GastosEscalonados(Double base, Double percentage, Integer yearBase, Integer yearPronostic)
    {
        int cuenta = yearPronostic - yearBase;
        Double valor = base;
        for(int i = 0; i < cuenta; i ++)
        {
            valor += valor*percentage;
        }
        return valor;
    }
    
    /**
     * Aproxima un numero a la cantidad de decimales específicos
     * @param numero = El numero que se desea aproximar
     * @param decimales = La cantidad de decimales a los que se desea aproximar
     * @return El numero aproximado
     */
    public static Double Aproximar(Double numero, int decimales)
    {
        Double aprox = Math.pow(10, decimales);
        aprox = Math.ceil(Math.round(numero*aprox))/aprox;
        return aprox;
    }
}
