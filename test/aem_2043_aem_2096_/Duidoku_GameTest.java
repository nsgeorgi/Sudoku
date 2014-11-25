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
public class Duidoku_GameTest {
    
    public Duidoku_GameTest() {
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
     * Test of setWins method, of class Duidoku_Game.
     */
    @Test
    public void testSetWins() {
        System.out.println("setWins");
        int wins = 0;
        Duidoku_Game instance = new Duidoku_Game();
        instance.setWins(wins);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of setLosses method, of class Duidoku_Game.
     */
    @Test
    public void testSetLosses() {
        System.out.println("setLosses");
        int losses = 0;
        Duidoku_Game instance = new Duidoku_Game();
        instance.setLosses(losses);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getWins method, of class Duidoku_Game.
     */
    @Test
    public void testGetWins() {
        System.out.println("getWins");
        Duidoku_Game instance = new Duidoku_Game();
        int expResult = instance.getWins();
        int result = instance.getWins();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getLosses method, of class Duidoku_Game.
     */
    @Test
    public void testGetLosses() {
        System.out.println("getLosses");
        Duidoku_Game instance = new Duidoku_Game();
        int expResult = instance.getLosses();
        int result = instance.getLosses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of New_Game method, of class Duidoku_Game.
     */
    @Test
    public void testNew_Game() {
        System.out.println("New_Game");
        Duidoku_Game instance = new Duidoku_Game();
        instance.New_Game();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of computers_turn method, of class Duidoku_Game.
     */
    @Test
    public void testComputers_turn() {
        System.out.println("computers_turn");
        Duidoku_Game instance = new Duidoku_Game();
        instance.computers_turn();
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of isSelectedNumberCandidate method, of class Duidoku_Game.
     */
    @Test
    public void testIsSelectedNumberCandidate() {
        System.out.println("isSelectedNumberCandidate");
        int x = 0;
        int y = 0;
        Duidoku_Game instance = new Duidoku_Game();
        boolean expResult = instance.isSelectedNumberCandidate(x, y);
        boolean result = instance.isSelectedNumberCandidate(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of Find_new_block_duidoku method, of class Duidoku_Game.
     */
    @Test
    public void testFind_new_block_duidoku() {
        System.out.println("Find_new_block_duidoku");
        int[][] current_game = new int[9][9];
        int number = 0;
        int y = 0;
        int x = 0;
        Duidoku_Game instance = new Duidoku_Game();
        boolean expResult = instance.Find_new_block_duidoku(current_game, number, y, x);
        boolean result = instance.Find_new_block_duidoku(current_game, number, y, x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of Find_block method, of class Duidoku_Game.
     */
    @Test
    public void testFind_block() {
        System.out.println("Find_block");
        int[][] current_game = null;
        int number = 0;
        int y = 0;
        int x = 0;
        Duidoku_Game instance = new Duidoku_Game();
        boolean expResult = instance.Find_block(current_game, number, y, x);
        boolean result = instance.Find_block(current_game, number, y, x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }
}
