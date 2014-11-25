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
public class FieldTest {
    
    public FieldTest() {
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
     * Test of setNumber method, of class Field.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        boolean userInput = false;
        Field instance = new Field(number, number);
        instance.setNumber(number, userInput);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setNumber_withletters method, of class Field.
     */
    @Test
    public void testSetNumber_withletters() {
        System.out.println("setNumber_withletters");
        int number = 0;
        boolean userInput = false;
        Field instance = new Field(number, number);
        instance.setNumber_withletters(number, userInput);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getFieldX method, of class Field.
     */
    @Test
    public void testGetFieldX() {
        System.out.println("getFieldX");
        int x=0;
        int y=1;
        Field instance = new Field(x, y);
        int expResult = instance.getFieldX();
        int result = instance.getFieldX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getFieldY method, of class Field.
     */
    @Test
    public void testGetFieldY() {
        System.out.println("getFieldY");
        int x=0;
        int y=1;
        Field instance = new Field(x, y);
        int expResult = instance.getFieldY();
        int result = instance.getFieldY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
