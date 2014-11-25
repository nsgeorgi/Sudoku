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
public class Hyper_Sudoku_GameTest {
    
    public Hyper_Sudoku_GameTest() {
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
     * Test of getHyper_puzzles method, of class Hyper_Sudoku_Game.
     */
    @Test
    public void testGetHyper_puzzles() {
        System.out.println("getHyper_puzzles");
        Hyper_Sudoku_Game instance = new Hyper_Sudoku_Game();
        int[][][] expResult =instance.getHyper_puzzles();
        int[][][] result = instance.getHyper_puzzles();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of New_Game method, of class Hyper_Sudoku_Game.
     */
    @Test
    public void testNew_Game() {
        System.out.println("New_Game");
        Hyper_Sudoku_Game instance = new Hyper_Sudoku_Game();
        instance.New_Game();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setHyper_puzzles method, of class Hyper_Sudoku_Game.
     */
    @Test
    public void testSetHyper_puzzles() {
        System.out.println("setHyper_puzzles");
        int[][][] hyper_puzzles = new int[10][9][9];
        Hyper_Sudoku_Game instance = new Hyper_Sudoku_Game();
        instance.setHyper_puzzles(hyper_puzzles);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of isSelectedNumberCandidate method, of class Hyper_Sudoku_Game.
     */
    @Test
    public void testIsSelectedNumberCandidate() {
        System.out.println("isSelectedNumberCandidate");
        int x = 0;
        int y = 0;
        Hyper_Sudoku_Game instance = new Hyper_Sudoku_Game();
        boolean expResult =  instance.isSelectedNumberCandidate(x, y);
        boolean result = instance.isSelectedNumberCandidate(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Find_block method, of class Hyper_Sudoku_Game.
     */
    @Test
    public void testFind_block() {
        System.out.println("Find_block");
        int[][] current_game = new int[9][9];
        int number = 0;
        int y = 0;
        int x = 0;
        Hyper_Sudoku_Game instance = new Hyper_Sudoku_Game();
        boolean expResult = instance.Find_block(current_game, number, y, x);
        boolean result = instance.Find_block(current_game, number, y, x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of Find_new_block method, of class Hyper_Sudoku_Game.
     */
    @Test
    public void testFind_new_block() {
        System.out.println("Find_new_block");
        int[][] current_game = new int[9][9];
        int number = 0;
        int y = 0;
        int x = 0;
        Hyper_Sudoku_Game instance = new Hyper_Sudoku_Game();
        boolean expResult =instance.Find_new_block(current_game, number, y, x);
        boolean result = instance.Find_new_block(current_game, number, y, x);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }
}
