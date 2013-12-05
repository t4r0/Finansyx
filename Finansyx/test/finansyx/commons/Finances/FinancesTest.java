/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Finances;

import java.util.ArrayList;
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
public class FinancesTest {
    
    public FinancesTest() {
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
     * Test of MARR method, of class Finances.
     */
    @Test
    public void testMARR() {
        System.out.println("MARR");
        Double i = null;
        Double f = null;
        Double expResult = null;
        Double result = Finances.MARR(i, f);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TieredCosts method, of class Finances.
     */
    @Test
    public void testTieredCosts() {
        System.out.println("TieredCosts");
        Double base = null;
        Double percentage = null;
        Integer yearBase = null;
        Integer yearPronostic = null;
        Double expResult = null;
        Double result = Finances.TieredCosts(base, percentage, yearBase, yearPronostic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Round method, of class Finances.
     */
    @Test
    public void testRound() {
        System.out.println("Round");
        Double numero = null;
        int decimales = 0;
        Double expResult = null;
        Double result = Finances.Round(numero, decimales);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConstantPaymentMortgage method, of class Finances.
     */
    @Test
    public void testConstantPaymentMortgage() {
        System.out.println("ConstantPaymentMortgage");
        Double A = null;
        Integer P = null;
        Integer N = null;
        Double j = null;
        Double m = null;
        ArrayList<Fee> expResult = null;
        ArrayList<Fee> result = Finances.ConstantPaymentMortgage(A, P, N, j, m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConstantAmortizedMortgage method, of class Finances.
     */
    @Test
    public void testConstantAmortizedMortgage() {
        System.out.println("ConstantAmortizedMortgage");
        Double A = null;
        Integer P = null;
        Integer N = null;
        Double j = null;
        Double m = null;
        ArrayList<Fee> expResult = null;
        ArrayList<Fee> result = Finances.ConstantAmortizedMortgage(A, P, N, j, m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InterestsSummary method, of class Finances.
     */
    @Test
    public void testInterestsSummary() {
        System.out.println("InterestsSummary");
        ArrayList<Fee> cuota = null;
        int pagos = 0;
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = Finances.InterestsSummary(cuota, pagos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Average method, of class Finances.
     */
    @Test
    public void testAverage() {
        System.out.println("Average");
        ArrayList<Double> a = null;
        ArrayList<Double> b = null;
        Double expResult = null;
        Double result = Finances.Average(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
