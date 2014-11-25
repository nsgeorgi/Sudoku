/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

/**
 * Η κλάση αυτή αναπαριστά τη λογική του σουντόκου. Είναι αφηρήμενη αφού οι 3
 * παραλλαγές την κληρονομούν.Κάποιες μέθοδοι υλοποιούνται εδώ καποιές αλλές
 * στις παραλλαγες.
 *
 * @author nikos
 */
public abstract class Sudoku extends Observable {

    /**
     * Το αποθηκευμένο παιχνίδι που φορτώθηκε
     */
    protected int[][] saved_game;
    /**
     * Το τρέχον παιχνίδι
     */
    protected int[][] current_game;
    /**
     * Μετατροπή του πίνακα που περ
     */
    protected char[][] current_game_to_letters;
    /**
     * Ο τρέχον αριθμός που επέλεξε ο χρήστης
     */
    protected int selected_Number;
    /**
     * Σημαίαα η οποία δείχνει εάν η επιλογή help είναι ενεργή
     */
    protected boolean help;
    /**
     * Σημαίαα η οποία δείχνει εάν η επιλογή wordoku είναι ενεργή
     */
    protected boolean wordoku;
   
    /**
     * Σημαία η οποία δείχνει ποια παραλλαγή τρέχει αυτή τη στιγμή. Μας βοοηθαει για να γίνονται οι κατάλληλες στις ενημερώσεις 
     * των γραφικών.
     * ο αριθμός 1 δείχνει ότι αυτή τη στιγμή τρέχουμε την κλασσικη παραλλαγη
     * ο αριθμός 2 δείχνει ότι αυτή τη στιγμή τρέχουμε την hyper παραλλαγη
     * ο αριθμός 3 δείχνει ότι αυτή τη στιγμή τρέχουμε την duidoku παραλλαγη
     * 
     */ 
    protected  static  int flag = 0;

    

    /**
     * Κατασκευαστής
     */
    public Sudoku() {

        saved_game = new int[9][9];
        current_game = new int[9][9];
        current_game_to_letters = new char[9][9];
        help = true;
    }

    /**
     * Η κλάση από όπου ξεκινάει το κάθε παιχνίδι
     */
    abstract public void New_Game();

    /**
     *
     * @param selectedNumber ο αριθμός που επέλεξε ο χρήστης
     * ενημερώνουμε τους παρατηρητές μας για τις αλλάγες στα γραφικά
     */
    public void setSelectedNumber(int selectedNumber) {

        this.selected_Number = selectedNumber;
        setChanged();
        notifyObservers(Update_Action.SELECTED_NUMBER);
    }

    /**
     *
     * @return
     */
    public int isFlag() {
        return flag;
    }

    /**
     * η αλληλεπίδραση του χρήστη με το  check box help on  . Ενημερώνουμε τους παρατηρητές για τυχόν αλλάγες στα γραφικά.
     * @param help
     */
    public void setHelp(boolean help) {
        this.help = help;
        setChanged();
        notifyObservers(Update_Action.HELP);
    }

    /**
     * Επιστρέφει τον αριθμό που επιλέχτηκε απο τον χρήστη.
     *
     * @return 
     */
    public int getSelectedNumber() {
        return selected_Number;
    }

    /**
     *Εκχωρεί  τον έγκυρο αριθμό που δόθηκε από τον χρήστη στον τρέχον πίνακα
     *
     * @param x Η χ συντεταγμενή του παζλ.
     * @param y Η y συντεταγμενή του παζλ.
     * @param number Ο αριθμός που θα εκχωρηθέι 
     */
    public void setNumber(int x, int y, int number) {
        current_game[y][x] = number;
    }

    /**
     * Επιστρέφει τον αριθμό στην συγκεκριμένη θέση .
     *
    * @param x Η χ συντεταγμενή του παζλ.
     * @param y Η y συντεταγμενή του παζλ.
     * @param number Ο αριθμός σε αυτή τη θέση 
     */
    public int getNumber(int x, int y) {
        return current_game[y][x];
    }

  
    /**
     * Επιστέφει αν το το check help είναι ενεργό η όχι
     *
     * @return 
     */
    public boolean isHelp() {
        return help;
    }

    /**
     *Στον άξονα του χ ελέγχει έαν η τιμή που δίνει ο χρήστης είναι εγκυρή δηλαδη είναι μοναδική
     * @param current_game 
     * @param y    Τις παραμέτρους αυτές τις έχω αναφέρει παραπάνω
     * @param selectedNumber
     * @return
     */
    public boolean Find_x(int[][] current_game, int y, int selectedNumber) {
        for (int x = 0; x < 9; x++) {
            if (current_game[y][x] == selectedNumber) {
                return false;
            }
        }
        return true;
    }

    /**
     *Στον άξονα του y ελέγχει έαν η τιμή που δίνει ο χρήστης είναι εγκυρή δηλαδη είναι μοναδική
     * @param current_game
     * @param x   Τις παραμέτρους αυτές τις έχω αναφέρει παραπάνω
     * @param number
     * @return
     */
    public boolean Find_y(int[][] current_game, int x, int number) {
        for (int y = 0; y < 9; y++) {

            if (current_game[y][x] == number) {
                return false;
            }
        }
        return true;
    }

    /**
     * Για κάθε block που υπάρχει ελέγχει εάν η τιμή που επέλεξε ο χρήστης είναι μοναδική.
     * @param current_game
     * @param number
     * @param y    Τις παραμέτρους αυτές τις έχω αναφέρει παραπάνω
     * @param x
     * @return
     */
    public abstract boolean Find_block(int[][] current_game, int number, int y, int x) ;
    
    
 

    /**ελέγχει εάν το check box του wordoku είναι ενεργό ή όχι. Ενημερώνει τους παρατηρητές για αλλαγές στα γραφικά
     *
     * @param wordoku
     */
    public void convert_letter_to_numbers(boolean wordoku) {
        this.wordoku = wordoku;

        setChanged();
       
        notifyObservers(Update_Action.WORDOKU);
    }

    /**
     *
     * @return
     */
    public boolean isWordoku() {
        return wordoku;
    }

    /**
     *
     * @param saved_game
     */
    public void setSaved_game(int[][] saved_game) {
        this.saved_game = saved_game;
    }

    /**
     *
     * @param current_game
     */
    public void setCurrent_game(int[][] current_game) {
        this.current_game = current_game;
    }

    /**
     *
     * @return
     */
    public int[][] getSaved_game() {
        return saved_game;
    }

    /**
     *
     * @return
     */
    public int[][] getCurrent_game() {
        return current_game;
    }
}
