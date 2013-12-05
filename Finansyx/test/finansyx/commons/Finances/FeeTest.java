/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Finances;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author t4r0
 */
public class FeeTest {
    
    public FeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAmortizacion method, of class Fee.
     */
    @Test
    public void testGetAmortizacion() {
        System.out.println("getAmortizacion");
        Fee instance = new Fee();
        Double expResult = null;
        Double result = instance.getAmortizacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCapital method, of class Fee.
     */
    @Test
    public void testGetCapital() {
        System.out.println("getCapital");
        Fee instance = new Fee();
        Double expResult = null;
        Double result = instance.getCapital();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIntereses method, of class Fee.
     */
    @Test
    public void testGetIntereses() {
        System.out.println("getIntereses");
        Fee instance = new Fee();
        Double expResult = null;
        Double result = instance.getIntereses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumero method, of class Fee.
     */
    @Test
    public void testGetNumero() {
        System.out.println("getNumero");
        Fee instance = new Fee();
        Integer expResult = null;
        Integer result = instance.getNumero();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenta method, of class Fee.
     */
    @Test
    public void testGetRenta() {
        System.out.println("getRenta");
        Fee instance = new Fee();
        Double expResult = null;
        Double result = instance.getRenta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmortizacion method, of class Fee.
     */
    @Test
    public void testSetAmortizacion() {
        System.out.println("setAmortizacion");
        Double amortizacion = null;
        Fee instance = new Fee();
        instance.setAmortizacion(amortizacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCapital method, of class Fee.
     */
    @Test
    public void testSetCapital() {
        System.out.println("setCapital");
        Double capital = null;
        Fee instance = new Fee();
        instance.setCapital(capital);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIntereses method, of class Fee.
     */
    @Test
    public void testSetIntereses() {
        System.out.println("setIntereses");
        Double intereses = null;
        Fee instance = new Fee();
        instance.setIntereses(intereses);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumero method, of class Fee.
     */
    @Test
    public void testSetNumero() {
        System.out.println("setNumero");
        Integer numero = null;
        Fee instance = new Fee();
        instance.setNumero(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRenta method, of class Fee.
     */
    @Test
    public void testSetRenta() {
        System.out.println("setRenta");
        Double renta = null;
        Fee instance = new Fee();
        instance.setRenta(renta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Fee.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Fee instance = new Fee();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
