/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finansyx.commons.Manage;

import finansyx.Exceptions.NotAValidOptionException;
import finansyx.commons.Rules.Rule;
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
public class DataManagerTest {
    
    public DataManagerTest() {
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
     * Test of Calc method, of class DataManager.
     * @throws finansyx.Exceptions.NotAValidOptionException
     */
    @Test
    public void testCalc() throws NotAValidOptionException {
        System.out.println("Calc");
        DataManager instance = new DataManager();
        instance.Calc();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBase method, of class DataManager.
     */
    @Test
    public void testGetBase() {
        System.out.println("getBase");
        DataManager instance = new DataManager();
        DataManager expResult = null;
        DataManager result = instance.getBase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCalcRule method, of class DataManager.
     */
    @Test
    public void testGetCalcRule() {
        System.out.println("getCalcRule");
        DataManager instance = new DataManager();
        Rule expResult = null;
        Rule result = instance.getCalcRule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValues method, of class DataManager.
     */
    @Test
    public void testGetValues() {
        System.out.println("getValues");
        DataManager instance = new DataManager();
        ArrayList<Double> expResult = null;
        ArrayList<Double> result = instance.getValues();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBase method, of class DataManager.
     */
    @Test
    public void testSetBase() {
        System.out.println("setBase");
        DataManager base = null;
        DataManager instance = new DataManager();
        instance.setBase(base);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCalcRule method, of class DataManager.
     */
    @Test
    public void testSetCalcRule() {
        System.out.println("setCalcRule");
        Rule calcRule = null;
        DataManager instance = new DataManager();
        instance.setCalcRule(calcRule);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValues method, of class DataManager.
     */
    @Test
    public void testSetValues() {
        System.out.println("setValues");
        ArrayList<Double> values = null;
        DataManager instance = new DataManager();
        instance.setValues(values);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
