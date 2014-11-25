/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.util.ArrayList;

/**
 *  η κλάση που αναπαριστά τα προφίλ των χρηστών.Περίεχει πληροφορίες όπως νίκες , ήττες κτλ.
 * @author nikos
 */
public class Profile {
    private  String name;
    private int wins;
    private int losses;
    private int sudoku_puzzles_solved;  //αριθμός λυμμένων παζλ
     private int hyper_puzzles_solved;
     private ArrayList<String> names;

    /**
     *  Κατασκευαστής
     */
    public Profile() {
        name="";
        wins=0;
        losses=0;
        
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public int getWins() {
        return wins;
    }

    /**
     *
     * @return
     */
    public int getLosses() {
        return losses;
    }

    /**
     *
     * @return
     */
    public int getSudoku_puzzles_solved() {
        return sudoku_puzzles_solved;
    }

    /**
     *
     * @return
     */
    public int getHyper_puzzles_solved() {
        return hyper_puzzles_solved;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param wins
     */
    public void setWins(int wins) {
        this.wins += wins;
    }

    /**
     *
     * @param losses
     */
    public void setLosses(int losses) {
        this.losses += losses;
    }

    /**
     *
     * @param sudoku_puzzles_solved ο αριθμός των παζλ όπου έχει λύσει της συγκεκριμένης έκδοσης
     */
    public void setSudoku_puzzles_solved(int sudoku_puzzles_solved) {
        this.sudoku_puzzles_solved += sudoku_puzzles_solved;
    }

    /**
     *
     * @param hyper_puzzles_solved ο αριθμός των παζλ όπου έχει λύσει της συγκεκριμένης έκδοσης
     */
    public void setHyper_puzzles_solved(int hyper_puzzles_solved) {
        this.hyper_puzzles_solved += hyper_puzzles_solved;
    }
     
     
    
    
    
    
    
    
}
