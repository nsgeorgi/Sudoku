/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nikos
 */
public class Update_ActionTest {
    
    public Update_ActionTest() {
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
     * Test of values method, of class Update_Action.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        Update_Action[] expResult = Update_Action.values();
        Update_Action[] result = Update_Action.values();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of valueOf method, of class Update_Action.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name;
        name = "HELP";
        Update_Action expResult = Update_Action.valueOf(name);
        Update_Action result = Update_Action.valueOf(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
