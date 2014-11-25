/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.util.Observable;
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
public class Button_PanelTest {
    
    public Button_PanelTest() {
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
     * Test of update method, of class Button_Panel.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Observable o = new Classic_Sudoku_Game();
        Object arg = Update_Action.HELP;
        Game game=new Game();
        Button_Panel instance = new Button_Panel(game);
        instance.update(o, arg);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setController method, of class Button_Panel.
     */
    @Test
    public void testSetController() {
        System.out.println("setController");
        Game game =new Game();
      //  Button_Control buttonController = new Button_Control(game);
        Button_Panel instance = new Button_Panel(game);
      //  instance.setController(buttonController);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
