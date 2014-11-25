/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *Η κλάση αυτή αναπαριστά  το πάνελ του σουντόκου με τα κελια.Δημιουργειται ολο το παζλ.
 * @author nikos
 */
public class Sudoku_Panel extends JPanel implements Observer {
   

    private static final Color COLOR_CANDIDATE = new Color(102, 153, 255);
    private int flag_s;
    
    private Field[][] fields;       // Πινακας με  fields.
    private JPanel[][] panels; //Πινακας με blocks

    // 
    /**
     * εδω κατασκευάζονται τα πανελς , προσθέτονται τα 
     * υποπανελς στα πανελς και τα κελια στα υποπανελς.
     * @param game 
     */
    public Sudoku_Panel(Game game) {
        super(new GridLayout(3, 3));

        panels = new JPanel[3][3];
        flag_s = game.getClassic_Sudoku().isFlag();
     
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                panels[y][x] = new JPanel(new GridLayout(3, 3));
                panels[y][x].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                add(panels[y][x]);
            }
        }

        fields = new Field[9][9];
        for (int y = 0; y < (9); y++) {
            for (int x = 0; x < (9); x++) {
                fields[y][x] = new Field(x, y);
                panels[y / 3][x / 3].add(fields[y][x]);
              
            }
        }
    }

    /**
     * αυτη η μέθοδος καλειται οταν υπαρχουν ενημερωσεις για το συγκεκριμενο πανελ
     *
     * @param o The model.
     * @param arg The UpdateAction.
     */
    @Override
    public void update(Observable o, Object arg) {
        switch ((Update_Action) arg) {
            case NEW_GAME_SUDOKU:
                flag_s = 1;  // ο αριθμός 3 δείχνει ότι αυτή τη στιγμή τρέχουμε την classic εκδοση

                setGame((Classic_Sudoku_Game) o);
                break;
            case NEW_GAME_HYPER_SUDOKU:
              
                flag_s = 2;   // ο αριθμός 3 δείχνει ότι αυτή τη στιγμή τρέχουμε την hyper παραλλαγη
                set_Hyper_Game((Hyper_Sudoku_Game) o);
                break;
            case NEW_GAME_DUIDOKU:
                 flag_s = 3;   // ο αριθμός 3 δείχνει ότι αυτή τη στιγμή τρέχουμε την duidoku παραλλαγη
              
                setGame_duidoku((Duidoku_Game) o);
                break;
            case WORDOKU:
            
               
                if (flag_s == 2) {
                  
                    set_Hyper_Game((Hyper_Sudoku_Game) o);
                } else if (flag_s == 1) {
                    setGame((Classic_Sudoku_Game) o);
                } else {
                    setGame_duidoku((Duidoku_Game) o);
                }

                break;

           case SELECTED_NUMBER:
            case CANDIDATES:
            case HELP:
              
                if (flag_s == 2) {
                   
                    setCandidates_hyper((Hyper_Sudoku_Game) o);
                } else if (flag_s == 1) {
                    setCandidates((Classic_Sudoku_Game) o);
                } else {
                    setCandidates_duidoku((Duidoku_Game) o);
                   
                
                }

                break;
        }
    }

    /**
     * εκχωρει τον τρεχον πινακα της κανονικης εκδοσης στα γραφικα .
     *
     * @param game η κλαση classic sudokou
     */
    public void setGame(Sudoku game) {


        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {

                fields[y][x].setBackground(Color.WHITE);
                if (game.isWordoku()) {

                    fields[y][x].setNumber_withletters(game.getNumber(x, y), false);
                } else {
                    fields[y][x].setNumber(game.getNumber(x, y), false);
                }
            }
        }
    }

    /**
     *  εκχωρει τον τρεχον πινακα της duidoku εκδοσης στα γραφικα .
     * @param game  η κλαση duidoku sudokou
     */
    public void setGame_duidoku(Sudoku game) {

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                
                fields[y][x].setBackground(Color.DARK_GRAY);

            }

        }

        for (int y = 1; y < 5; y++) {
            for (int x = 4; x < 8; x++) {
                //ενεργοποιω μονο τα συγκεκριμενα κελια για να φτιαξω την   duidoku παραλλαγη 
                fields[y][x].setBackground(Color.white);

            }
        }
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {


                if (game.isWordoku()) {

                    fields[y][x].setNumber_withletters(game.getNumber(x, y), false);
                } else {
                    fields[y][x].setNumber(game.getNumber(x, y), false);
                }

            }

        }



    }

    /**
     *  εκχωρει τον τρεχον πινακα της hyper εκδοσης στα γραφικα .
     * η κλαση hyper sudokou
     * @param game
     */
    public void set_Hyper_Game(Hyper_Sudoku_Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) { //εαν το χ δεν ειναι ενα απο αυτα τοτε θα ειναι η περιοχη με το κοκκινο χρωμα
                if (x == 0 || x == 4 || x == 8 || y == 0 || y == 4 || y == 8) {
                    fields[y][x].setBackground(Color.WHITE);
                } else {
                    fields[y][x].setBackground(Color.red);
                }
                if (game.isWordoku()) {

                    fields[y][x].setNumber_withletters(game.getNumber(x, y), false);
                } else {
                    fields[y][x].setNumber(game.getNumber(x, y), false);
                }
            }
        }
    }

    /**
     * δείχνει με μπλε χρωμα ποια κελια ειναι υποψηφια για μια συγκεκριμενη τιμη  για την κλασσικη
     *
     * @param game Current game.
     */
    
    private void setCandidates(Classic_Sudoku_Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                fields[y][x].setBackground(Color.WHITE);
                if (game.isHelp() && game.isSelectedNumberCandidate(x, y)) {
                    fields[y][x].setBackground(COLOR_CANDIDATE);
                }
            }
        }
    }
    
      /**
     * δείχνει με μπλε χρωμα ποια κελια ειναι υποψηφια για μια συγκεκριμενη τιμη  για την hyper
     *
     * @param game Current game.
     */
    

    private void setCandidates_hyper(Hyper_Sudoku_Game game) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (x == 0 || x == 4 || x == 8 || y == 0 || y == 4 || y == 8) {
                    fields[y][x].setBackground(Color.WHITE);
                } else {
                    fields[y][x].setBackground(Color.red);
                }
                if (game.isHelp() && game.isSelectedNumberCandidate(x, y)) {
                    fields[y][x].setBackground(COLOR_CANDIDATE);
                }
            }
        }
    }
    
      /**
     * δείχνει με μπλε χρωμα ποια κελια ειναι υποψηφια για μια συγκεκριμενη τιμη  για την duidoku
     *
     * @param game Current game.
     */
    

    private void setCandidates_duidoku(Duidoku_Game game) {
      
         for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {

                fields[y][x].setBackground(Color.DARK_GRAY);

            }

        }

        for (int y = 1; y < 5; y++) {
            for (int x = 4; x < 8; x++) {

                fields[y][x].setBackground(Color.white);

            }
        }
        for (int y = 0; y < 9; y++) {
           
            for (int x = 0; x < 9; x++) {
                System.out.print(  game.current_game[y][x]);
            
                if (game.isHelp() && game.isSelectedNumberCandidate(x, y)) {
                    fields[y][x].setBackground(COLOR_CANDIDATE);
                }
            }
        }
    }

    /**
     * Προσθέτει χειρισμό σε όλα τα πάνελς.
     *
     * @param sudokuController χειριστής που χειρίζεται όλα τα  actions.
     */
    public void setController(Sudoku_Control sudokuController) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                panels[y][x].addMouseListener(sudokuController);
            }
        }
    }

    /**
     *
     * @return
     */
    public int isFlag_s() {
        return flag_s;
    }

    
}
