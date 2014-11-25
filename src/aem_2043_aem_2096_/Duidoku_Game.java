/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;


import javax.swing.JOptionPane;

/**
 * Η κλάση αυτή υλοποιεί την duidoku παραλλαγη  του παιχνιδιού.
 * @author nikos
 */
public class Duidoku_Game extends Sudoku {
   
    private  int wins;
    private int losses;

    /** κατασκευαστής
     *
     */
    public Duidoku_Game() {
        saved_game = null;
        wins=0;
        losses=0;
       
    }

    /**
     *
     * @param wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }

    /**
     *
     * @param losses
     */
    public void setLosses(int losses) {
        this.losses = losses;
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

    @Override
    public void New_Game() {
        flag = 3; // ο αριθμός 3 δείχνει ότι αυτή τη στιγμή τρέχουμε την duidoku παραλλαγη
        if (saved_game == null) {   //εάν υπάρχει αποθηκεύμενο παζλ τότε χρησιμοποίουμε αυτό αλλιώς εκχωρούμε ένα τυχαία.
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    current_game[i][j] = -1;
                }
            }
            for (int y = 1; y < 5; y++) {
                for (int x = 4; x < 8; x++) {

                    current_game[y][x] = 0;

                }
            }
        }  saved_game=null;
        setChanged();   //ενημερώνουμε τους παρατηρητές 
      
        notifyObservers(Update_Action.NEW_GAME_DUIDOKU);
        
    }

    /**
     *Η σειρά του υπολιγιστή να  κάνει κίνηση . επιλέγει τυχαία ένα αριθμο απο το 1 μεχρι το 4 και επιλέγει τυχαιa 
     *  x y συντεταγμένες για είναι απρόβλεπτη η κινηση του . Εάν δεν βρει εγκυρη επιλογη τρέχει την ίδια διαδικασία για 400 φορές 
     * Εαν δεν βρει λυση τότε νικητης αναδεικνύεται ο χρήστης .
     */
    public void computers_turn() {
        int computer_number = 0;
        int x_field = 0;
        int y_field = 0;
        int count = 0;
        do {
            count++;
            computer_number = 1 + (int) (Math.random() * ((4 - 1) + 1));
           
            if (count == 400) {
                JOptionPane.showMessageDialog(null, "Congratulations!!! You win !!");
                wins++;
                break;
            }
            x_field = 4 + (int) (Math.random() * ((8 - 4) + 1));
            y_field = 1 + (int) (Math.random() * ((5 - 1) + 1));
            setSelectedNumber(computer_number);
        } while (!isSelectedNumberCandidate(x_field, y_field));
        setNumber(x_field, y_field, computer_number);
        setChanged();
          //ενημερώνουμε τους παρατηρητές 
        notifyObservers(Update_Action.NEW_GAME_DUIDOKU);  
        boolean flag_1 = false;          //μετα την κίνηση του υπολογιστη ελεγχουμε εαν ο παικτης εχει τη δυνατοτητα να κανει
        for (int i = 1; i < 4; i++) {  //επιτρεπτη κίνηση .Διαλεγουμε με τη σειρα όλους τους αριθμους και τους τοποθετουμε σε ολα 
            selected_Number = i;  // τα κελια . Εαν εστω και μια επιλογη ειναι δυνατη τοτε σταματαμε αφου σημαινει οτι ο χρηστης 
            for (int j = 1; j < 5; j++) { // δεν εχει χασει ακομα. αλλιως αν δεν βρεθει καμια τοτε εχασε.
                for (int k = 4; k < 8; k++) {

                    if (isSelectedNumberCandidate(k, j)) {
                        flag_1 = true;
                        break;
                    }
                }
            }
        }
        if (!flag_1) {
            JOptionPane.showMessageDialog(null, "You lose !!! Play again !!");
           losses++;
                 //ενημερώνουμε τους παρατηρητές 
        }   setChanged();
          notifyObservers(Update_Action.CANDIDATES); 

    }

    /**  Ελέγχει έαν ο αριθμός που επέλεξε ο χρήστης είναι εγκυρος , καλώντας άλλες μεθόδους.
     *
     * @param x
     * @param y
     * @return
     */
    public boolean isSelectedNumberCandidate(int x, int y) {
        return current_game[y][x] == 0 && Find_x(current_game, y, selected_Number)
                && Find_y(current_game, x, selected_Number) && Find_new_block_duidoku(current_game, x, y, selected_Number);
    }

    /**
     * ελέγχει  το block στο οποίο βρίσκεται ο αριθμός που επέλεξε ο χρήστης έτσι ωστε η τιμή αυτή να έιναι μοναδίκη
     * @param current_game
     * @param number
     * @param y
     * @param x
     * @return true αν είναι μοναδική
     */
   
    public boolean Find_new_block_duidoku(int[][] current_game, int number, int y, int x) {

        int x1 = x < 6 ? 4 : 6;
        int y1 = y < 3 ? 1 : 3;
        for (int yy = y1; yy < y1 + 2; yy++) {
            for (int xx = x1; xx < x1 + 2; xx++) {
                if (current_game[yy][xx] == number) {
                    return false;
                }
            }
        }
        return true;

    }

    @Override
    public boolean Find_block(int[][] current_game, int number, int y, int x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
