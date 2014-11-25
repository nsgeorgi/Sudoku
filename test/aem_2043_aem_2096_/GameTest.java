/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.util.ArrayList;
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
public class GameTest {
    
    public GameTest() {
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
     * Test of getProfiles method, of class Game.
     */
    @Test
    public void testGetProfiles() {
        System.out.println("getProfiles");
        Game instance = new Game();
        ArrayList expResult = new ArrayList<Profile>();
        ArrayList result = instance.getProfiles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

  
    /**
     * Test of getProfile method, of class Game.
     */
    @Test
    public void testGetProfile() {
        System.out.println("getProfile");
        Game instance = new Game();
       // Profile p=new Profile();
        Profile expResult = instance.getProfile();
        Profile result = instance.getProfile();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrent_player method, of class Game.
     */
    @Test
    public void testGetCurrent_player() {
        System.out.println("getCurrent_player");
        Game instance = new Game();
        instance.getCurrent_player();
        Profile expResult =instance.getCurrent_player(); ;
        Profile result = instance.getCurrent_player();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrent_player method, of class Game.
     */
    @Test
    public void testSetCurrent_player() {
        System.out.println("setCurrent_player");
        Profile current_player = null;
        Game instance = new Game();
        instance.setCurrent_player(current_player);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getClassic_Sudoku method, of class Game.
     */
    @Test
    public void testGetClassic_Sudoku() {
        System.out.println("getClassic_Sudoku");
        Game instance = new Game();
        Classic_Sudoku_Game expResult = instance.getClassic_Sudoku();
        Classic_Sudoku_Game result = instance.getClassic_Sudoku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of getHyper_sudoku method, of class Game.
     */
    @Test
    public void testGetHyper_sudoku() {
        System.out.println("getHyper_sudoku");
        Game instance = new Game();
        Hyper_Sudoku_Game expResult =instance.getHyper_sudoku();
        Hyper_Sudoku_Game result = instance.getHyper_sudoku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getDuidoku method, of class Game.
     */
    @Test
    public void testGetDuidoku() {
        System.out.println("getDuidoku");
        Game instance = new Game();
        Duidoku_Game expResult = instance.getDuidoku();
        Duidoku_Game result = instance.getDuidoku();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of add_player method, of class Game.
     */
    @Test
    public void testAdd_player() {
        System.out.println("add_player");
        Profile p = null;
        Game instance = new Game();
        instance.add_player(p);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of check_name method, of class Game.
     */
    @Test
    public void testCheck_name() {
        System.out.println("check_name");
        String s = "";
        Game instance = new Game();
        boolean expResult = instance.check_name(s);
        boolean result = instance.check_name(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
