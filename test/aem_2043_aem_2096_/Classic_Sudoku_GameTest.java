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
public class Classic_Sudoku_GameTest {
    
    public Classic_Sudoku_GameTest() {
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
     * Test of getSudoku_puzzles method, of class Classic_Sudoku_Game.
     */
    @Test
    public void testGetSudoku_puzzles() {
        System.out.println("getSudoku_puzzles");
        Classic_Sudoku_Game instance = new Classic_Sudoku_Game();
        int[][][] expResult = instance.getSudoku_puzzles();
        int[][][] result = instance.getSudoku_puzzles();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of New_Game method, of class Classic_Sudoku_Game.
     */
    @Test
    public void testNew_Game() {
        System.out.println("New_Game");
        Classic_Sudoku_Game instance = new Classic_Sudoku_Game();
        instance.New_Game();
        // TODO review the generated test code and remove the default call to fail.
    //    fail("The test case is a prototype.");
    }

    /**
     * Test of setSudoku_puzzles method, of class Classic_Sudoku_Game.
     */
    @Test
    public void testSetSudoku_puzzles() {
        System.out.println("setSudoku_puzzles");
        int[][][] sudoku_puzzles = null;
        Classic_Sudoku_Game instance = new Classic_Sudoku_Game();
        instance.setSudoku_puzzles(sudoku_puzzles);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setSelectedNumber method, of class Classic_Sudoku_Game.
     */
    @Test
    public void testSetSelectedNumber() {
        System.out.println("setSelectedNumber");
        int selectedNumber = 0;
        Classic_Sudoku_Game instance = new Classic_Sudoku_Game();
        instance.setSelectedNumber(selectedNumber);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedNumber method, of class Classic_Sudoku_Game.
     */
    @Test
    public void testGetSelectedNumber() {
        System.out.println("getSelectedNumber");
        Classic_Sudoku_Game instance = new Classic_Sudoku_Game();
        int expResult = instance.getSelectedNumber();
        int result = instance.getSelectedNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }


    /**
     * Test of isSelectedNumberCandidate method, of class Classic_Sudoku_Game.
     */
    @Test
    public void testIsSelectedNumberCandidate() {
        System.out.println("isSelectedNumberCandidate");
        int x = 0;
        int y = 0;
        Classic_Sudoku_Game instance = new Classic_Sudoku_Game();
        boolean expResult = instance.isSelectedNumberCandidate(x, y);
        boolean result = instance.isSelectedNumberCandidate(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
