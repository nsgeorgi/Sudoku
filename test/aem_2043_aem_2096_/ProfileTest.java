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
public class ProfileTest {
    
    public ProfileTest() {
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
     * Test of getName method, of class Profile.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Profile instance = new Profile();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getWins method, of class Profile.
     */
    @Test
    public void testGetWins() {
        System.out.println("getWins");
        Profile instance = new Profile();
        int expResult =instance.getWins();
        int result = instance.getWins();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of getLosses method, of class Profile.
     */
    @Test
    public void testGetLosses() {
        System.out.println("getLosses");
        Profile instance = new Profile();
        int expResult =  instance.getLosses();
        int result = instance.getLosses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getSudoku_puzzles_solved method, of class Profile.
     */
    @Test
    public void testGetSudoku_puzzles_solved() {
        System.out.println("getSudoku_puzzles_solved");
        Profile instance = new Profile();
        int expResult = instance.getSudoku_puzzles_solved();
        int result = instance.getSudoku_puzzles_solved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getHyper_puzzles_solved method, of class Profile.
     */
    @Test
    public void testGetHyper_puzzles_solved() {
        System.out.println("getHyper_puzzles_solved");
        Profile instance = new Profile();
        int expResult = instance.getHyper_puzzles_solved();
        int result = instance.getHyper_puzzles_solved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Profile.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Profile instance = new Profile();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setWins method, of class Profile.
     */
    @Test
    public void testSetWins() {
        System.out.println("setWins");
        int wins = 0;
        Profile instance = new Profile();
        instance.setWins(wins);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setLosses method, of class Profile.
     */
    @Test
    public void testSetLosses() {
        System.out.println("setLosses");
        int losses = 0;
        Profile instance = new Profile();
        instance.setLosses(losses);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setSudoku_puzzles_solved method, of class Profile.
     */
    @Test
    public void testSetSudoku_puzzles_solved() {
        System.out.println("setSudoku_puzzles_solved");
        int sudoku_puzzles_solved = 0;
        Profile instance = new Profile();
        instance.setSudoku_puzzles_solved(sudoku_puzzles_solved);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setHyper_puzzles_solved method, of class Profile.
     */
    @Test
    public void testSetHyper_puzzles_solved() {
        System.out.println("setHyper_puzzles_solved");
        int hyper_puzzles_solved = 0;
        Profile instance = new Profile();
        instance.setHyper_puzzles_solved(hyper_puzzles_solved);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
}
