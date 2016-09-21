/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.util.ArrayList;
import java.util.Observable;

/**
 *Σε αυτή τη κλάση περιέχονται οι κλάσεις που αποτελούν τη   λογική του παιχνιδιού.Περιέχει ως πεδία όλες τις παραλλαγές και την κλάση που αναπαρίστα το προφίλ 
 * του χρήστη.
 * @author nikos
 */
public class Game {

    private Classic_Sudoku_Game classic_sudoku;
    private Hyper_Sudoku_Game hyper_sudoku;
    private Duidoku_Game duidoku;
    private ArrayList<Profile> profiles;
    private Profile current_player; // ο τρέχον χρήσ
    

    /**
     *
     */
    public Game() {
        profiles = new ArrayList<>();
        classic_sudoku = new Classic_Sudoku_Game();
        hyper_sudoku = new Hyper_Sudoku_Game();
        duidoku = new Duidoku_Game();
        current_player = new Profile(); 
        
    }

    /**
     *επιστρέφει τα προφίλ των χρηστών
     * @return
     */
    public ArrayList<Profile> getProfiles() {
        return profiles;
    }

    /**
     *
     * @param profile  
     */
  

    /**
     *
     * @return
     */
    public Profile getProfile() {
        Profile p =new Profile();
        return p;
    }

    /**
     *
     * @return
     */
    public Profile getCurrent_player() {
        return current_player;
    }

    /**
     *
     * @param current_player
     */
    public void setCurrent_player(Profile current_player) {
        this.current_player = current_player;
    }

    /**
     *
     * @return
     */
    public Classic_Sudoku_Game getClassic_Sudoku() {
        return classic_sudoku;
    }

    /**
     *
     * @return
     */
    public Hyper_Sudoku_Game getHyper_sudoku() {
        return hyper_sudoku;
    }

    /**
     *
     * @return
     */
    public Duidoku_Game getDuidoku() {
        return duidoku;
    }

    /**
     *
     * @param p
     */
    public void add_player(Profile p) {
        profiles.add(p);
    }

    /**
     *
     * @param s το όνομα που δίνει ο τρέχον χρήστης στη διεπαφή 
     * @return ελέγχουμε έαν είναι παλιός χρήστης .
     */
    public boolean check_name(String s) {
        for (Profile p : profiles) {
           
            if (p.getName().equals(s)) {
              
                return true;
            }
        }
        return false;
    }
}
