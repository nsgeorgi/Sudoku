/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.util.Random;

/**
 *Η κλάση αυτή υλοποιεί την κλασσική παραλλαγη  του παιχνιδιού.
 * @author nikos
 */
public class Classic_Sudoku_Game extends Sudoku {

    private  int[][][] sudoku_puzzles;  //τα διάφορα παιχνίδια που φορτώθηκαν από το αρχείο 

    /**κατασκευαστής 
     */
    public Classic_Sudoku_Game() {
        sudoku_puzzles = new int[10][9][9];
        saved_game=null;
        
    }

    /**
     *επιστρέφει όλα τα παζλ 
     * @return
     */
    public int[][][] getSudoku_puzzles() {
        return sudoku_puzzles;
    }

   
    @Override
    public void New_Game() {
      
        Random r = new Random();  // επιλέγουμε τυχαία ένα παζλ
         flag=1;  //ο αριθμός 1 δείχνει ότι αυτή τη στιγμή τρέχουμε την κλασσικη παραλλαγη
          int selected_puzzle=0;
       
        
             selected_puzzle=r.nextInt(sudoku_puzzles.length);
        
        
       
        if ( saved_game==null)  {   //εάν υπάρχει αποθηκεύμενο παζλ τότε χρησιμοποίουμε αυτό αλλιώς εκχωρούμε ένα τυχαία.
            
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                 current_game[i][j] =    sudoku_puzzles[selected_puzzle][i][j];
             
            }
             
        }  }
        saved_game=null;
         setChanged();   //ενημερώνουμε τους παρατηρητές 
             
        notifyObservers(Update_Action.NEW_GAME_SUDOKU);
   
    }

    /**
     * τα παζλ που έχουμε φορτώσει τα εκχωρόυμε
     * @param sudoku_puzzles
     */
    public void setSudoku_puzzles(int[][][] sudoku_puzzles) {
        this.sudoku_puzzles = sudoku_puzzles;
         
    }
 
    /**
     * Ελέγχει έαν ο αριθμός που επέλεξε ο χρήστης είναι εγκυρος , καλώντας άλλες μεθόδους.
     * @param x
     * @param y
     * @return
     */
    public boolean isSelectedNumberCandidate(int x, int y) {
         return current_game[y][x] == 0 && Find_x(current_game, y, selected_Number)
                && Find_y(current_game,x, selected_Number) && Find_block(current_game, x, y, selected_Number);
    }

    
     /**
     * Για κάθε block που υπάρχει ελέγχει εάν η τιμή που επέλεξε ο χρήστης είναι μοναδική.
     * @param current_game
     * @param number
     * @param y    Τις παραμέτρους αυτές τις έχω αναφέρει παραπάνω
     * @param x
     * @return
     */
    
    @Override
     public boolean Find_block(int[][] current_game, int number, int y, int x) {
        int x1 = x < 3 ? 0 : x < 6 ? 3 : 6;
        int y1 = y < 3 ? 0 : y < 6 ? 3 : 6;
        for (int yy = y1; yy < y1 + 3; yy++) {
            for (int xx = x1; xx < x1 + 3; xx++) {
                if (current_game[yy][xx] == number) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
}
