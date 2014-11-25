/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 * Η κλάση αυτή αναπαριστά  το κάθε κελι του παζλ.
 * @author nikos
 */
public class Field extends JLabel {
    private int x;      // X συντεταγμενη του παζλ
    private int y;      // Y συντεταγμενη του παζλ.

    /**
     * Κατασκευαστης 
     *
     * @param x     X συντεταγμενη του παζλ
     * @param y     Y συντεταγμενη του παζλ.
     */
    public Field(int x, int y) {
        super("", CENTER);
        this.x = x;
        this.y = y;
        
        setPreferredSize(new Dimension(40, 40));
        { 
        setBorder(BorderFactory.createLineBorder(Color.GRAY)); } 
         
        setFont(new Font(Font.DIALOG, Font.PLAIN, 20));
        setOpaque(true);
    }

    /**
     * Επιλέγει τον αριθμό και το χρώμα του κελιού αναλογα με το αν εχει δωσει ο χρηστης τον αριθμο. 
     *
     * @param number        ο αριθμός που θα εκχωρηθεί στο κελί
     * @param userInput     Boolean που δείχνει αν ο αριθμός είναι είσοδος του χρήστη ή όχι.
     */
    public void setNumber(int number, boolean userInput) {
        setForeground(userInput ? Color.BLUE : Color.BLACK);
      
        setText(number > 0 ? number +  "" : "");
    }
    
    /**
     * Επιλέγει τον αριθμό και το χρώμα του κελιού αναλογα με το αν εχει δωσει ο χρηστης τον αριθμο. 
     *Ο αριθμός μετατρέπεται σε γράμμα και εμφανίζεται ως γραμμα στην οθόνη.
     * @param number        ο αριθμός που θα εκχωρηθεί στο κελί
     * @param userInput     Boolean που δείχνει αν ο αριθμός είναι είσοδος του χρήστη ή όχι.
     */
    
    public void setNumber_withletters(int number, boolean userInput) {
        setForeground(userInput ? Color.BLUE : Color.BLACK);
        setText(number > 0 ? ((char)( number + 64))+  "" : "");
    }

    /**
     *επιστρέφει τη χ συντεταγμένη
     *
     * @return  X 
     */
    public int getFieldX() {
        return x;
    }

    /**
     *επιστρέφει τη y συντεταγμένη
     *
     * @return  Y 
     */
    public int getFieldY() {
        return y;
    }
}
    

