/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package finansyx.commons.Finanzas;

import java.math.BigDecimal;
import java.util.ArrayList;
import org.apache.commons.math3.util.Precision;/**
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
        return Precision.round(numero, decimales, BigDecimal.ROUND_HALF_UP);
    }
    
    /**
     * Calcula intereses en base al sistema de cuotas niveladas
     * @param A - El prestamo o la inversión que se ha hecho
     * @param P - Los pagos que se harán por año
     * @param N - Años involucrado en el préstamo
     * @param j - tasa de interes
     * @param m - capitalizaciones
     * @return 
     */
    public static ArrayList<Cuota> CuotasNiveladas(Double A, Integer P, Integer N,
            Double j, Double m)
    {
        ArrayList<Cuota> cuotas = new ArrayList<>();
        Double exp = j/m;
        Double renta =A * ( Math.pow(1 + exp, m/P) - 1)/
                (1 - Math.pow(1 + exp, -m*N));
        Double factor = Math.pow(1 + exp, m/P) - 1; 
        Double capital = A;
        Double interes, amort;
        for(int i = 0 ; i < P*N ; i ++)
        {
            interes = capital*factor;
            amort = renta - interes;
            capital = capital - amort;
            cuotas.add(new Cuota(i+1, renta, interes,amort,capital));
        }        
        return cuotas;
    }
    
    /***
     * Calcula intereses, en base al sistema de cuotas no niveladas
    @param A - El prestamo o la inversión que se ha hecho
     * @param P - Los pagos que se harán por año
     * @param N - Años involucrado en el préstamo
     * @param j - tasa de interes
     * @param m - capitalizaciones
     * @return 
     */
    public static ArrayList<Cuota> CuotasNoNiveladas(Double A, Integer P, Integer N,
            Double j, Double m)
    {
        ArrayList<Cuota> cuotas = new ArrayList<>();
        Double exp = j/m;
        Double amortizacion = A / (N*P);
        Double factor = Math.pow(1 + exp, m/P) - 1; 
        Double capital = A;
        Double interes,renta;
        for(int i = 0 ; i < P*N ; i ++)
        {
            interes = capital*factor;
            renta = interes + amortizacion;
            capital = capital - amortizacion;
            cuotas.add(new Cuota(i+1, renta, interes,amortizacion,capital));
        }        
        return cuotas;
    }
    
    public static ArrayList<Double> Resumen(ArrayList<Cuota> cuota, int pagos)
    {
        Double payment=0.;
        ArrayList<Double> payments = new ArrayList<Double>();
        int counter = 0;
        for(int i=0; i<cuota.size(); i++)
        {
            payment += cuota.get(i).getIntereses();
            counter ++;
            if(counter == pagos)
            {
                payments.add(payment);
                payment = 0.;
                counter = 0;
            }
        }
        return payments;
    }
    /**
     * Calcula el promedio porcentual, de b en relación de a.
     * @param a Los datos que representan el total a partir del cual se
     * calculará el promedio
     * @param b Los datos de los que se calculará el promedio.
     * @return El promedio porecntual de B en relación a A
     */
    public static  Double Promedio(ArrayList<Double> a, ArrayList<Double> b)
    {
        int i = 0;
        Double promedio = 0.;
        for(i = 0; i < b.size(); i ++)        
            promedio += (b.get(i) / a.get(i));
        promedio = promedio / b.size();
        return Math.round(Aproximar(promedio, 2)*100)/100.;    
    }
}
