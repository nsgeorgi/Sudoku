/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level; 
import java.util.logging.Logger;
import javax.swing.JFrame;


/**
 *Αυτή η κλάση αναπαριστά το γραφικό περιβάλλον της εφαρμογής μας.Δημιουργείται το πλαίσιο της εφαρμογής και τα διάφορα δοχεία 
 * που το πλαισιώνουν τα οποία υπάρχουν ως πεδία.Επίσης διαβάζουμε το αρχείο που έχει αποθηκευμένο το save του παιχνιδιόυ , 
 * το αρχείο με τα παιχνίδια 
 * καθώς και το αρχείο που περιέχει πληροφορίες για τους χρήστες.Τέλος δημιουργούμε το αντικείμενο της λογικής και προσθέτουμε 
 * τους παρατηρητές του προγράμματος οι οποιοί είναι τα δοχεία. 
 * @author nikos
 */
public class Gui extends JFrame {

    private Button_Control button_control;  //η αλληλεπίδραση του χρήστη με το πλάισιο των κουμπιών.
    private Button_Panel button_panel;  // το πλαίσιο που περιέχει τα κουμπιά
    private Sudoku_Control sudoku_control;  //η αλληλεπίδραση του χρήστη με το πλάισιο του σουντόκου
    private Sudoku_Panel sudoku_panel; // το πλαίσιο που περιέχει το σουντόκου.
    private Game game; //η λογική του παιχνιδιού

    /**
     *
     * @throws FileNotFoundException
     */
    public Gui() throws FileNotFoundException {

        //------ DIAVASMA TOU ARXEIOU ------ //
        
        super("Sudoku");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

       Scanner scanner = new Scanner(new File("test.txt"));  //διάβασμ του αρχείου με τα παιχνίδια



        int tmp = 0;

        int[][][] sudoku_puzzles = new int[10][9][9];
        int[][][] hyper_puzzles = new int[10][9][9];
        int[][] saved_puzzle = new int[9][9];

        for (int k = 0; k < 10; k++) {

            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {
                    tmp = scanner.nextInt();

                    sudoku_puzzles[k][i][j] = tmp;
                  
                }
            }
        }
        for (int k = 0; k < 10; k++) {


            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {
                    tmp = scanner.nextInt();
                    hyper_puzzles[k][i][j] = tmp;

                }
            }
        }
       

        scanner.close();
        boolean load_game = false;
        String s = "";
        try {
            File file = new File("saved_game.txt");   //διάβασμα του αρχείου με το αποθηκευμένο παιχνίδι
            if (file.exists()) {
                scanner = new Scanner(file);
                s = scanner.nextLine();

                while (scanner.hasNext()) {
                    load_game = true;

                    for (int i = 0; i < 9; i++) {

                        for (int j = 0; j < 9; j++) {
                            tmp = scanner.nextInt();

                            saved_puzzle[i][j] = tmp;
                               
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Button_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        game = new Game();   //δημιουργούμε την λογική ,τρεις κλάσης για κάθε παραλλαγή του παιχνιδιού
        Classic_Sudoku_Game sudoku_game = game.getClassic_Sudoku();
        Hyper_Sudoku_Game hyper_game = game.getHyper_sudoku();
        Duidoku_Game duidoku_game = game.getDuidoku();
        try {
            File file = new File("saved_profiles.txt");  //διάβασμα του αρχείου με τα αποθηκυμένα προφίλ των χρηστών.
            if (file.exists()) {

                scanner = new Scanner(file);

                while (scanner.hasNextLine()) {
                    Profile x = game.getProfile();
                    x.setName(scanner.nextLine());

                    x.setSudoku_puzzles_solved(scanner.nextInt());
                    x.setHyper_puzzles_solved(scanner.nextInt());
                    x.setWins(scanner.nextInt());
                    x.setLosses(scanner.nextInt());
                    game.add_player(x);
                   
                    scanner.nextLine();


                }
            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Button_Control.class.getName()).log(Level.SEVERE, null, ex);
        }


        sudoku_game.setSudoku_puzzles(sudoku_puzzles);   //παιρνάμε τα παιχνίδια από το αρχείο στην αντίστοιχη κλάση
        hyper_game.setHyper_puzzles(hyper_puzzles);
        //εάν υπάρχει αποθηκευμένο παιχνίδι, τότε θα το φορτώσουμε
        if (load_game == true) {
            if (s.equals("SUDOKU")) {
             
                sudoku_game.setSaved_game(saved_puzzle);
                sudoku_game.setCurrent_game(saved_puzzle);
                sudoku_game.New_Game();
            } else if (s.equals("HYPERSUDOKU")) {
                hyper_game.setSaved_game(saved_puzzle);
                hyper_game.setCurrent_game(saved_puzzle);
                hyper_game.New_Game();
            } else {
               duidoku_game.setSaved_game(saved_puzzle);
               duidoku_game.setCurrent_game(saved_puzzle);
                duidoku_game.New_Game();
            }
        } else {    //εάν δεν υπάρχει τότε θα εμφανίσουμε στην έναρξη του παιχνιδιού την κλάσσικη έκδοση του παιχνιδιού.
           
            sudoku_game.New_Game();
        }

        //---ANAPTYKSI TOU GUI---- //



        button_control = new Button_Control(game);
        button_panel = new Button_Panel(game);

        button_panel.setController(button_control); //στο πλαίσιο των κουμπιών περνάμε τον χειρισμό του.
        add(button_panel, BorderLayout.EAST);
      
        sudoku_panel = new Sudoku_Panel(game);
        sudoku_control = new Sudoku_Control(sudoku_panel, sudoku_game, hyper_game, duidoku_game);//στο πλαίσιο του σουντόκου  περνάμε τον χειρισμό του.και τις κλάσης λογικής
        if (s.equals("SUDOKU") || load_game == false) {
           
            sudoku_panel.setGame(sudoku_game);
        } else if (s.equals("HYPERSUDOKU")){
            sudoku_panel.set_Hyper_Game(hyper_game);
          
        }else if (s.equals("DUIDOKU")){
            sudoku_panel.setGame_duidoku(duidoku_game);
          
        }
        sudoku_panel.setController(sudoku_control);
        add(sudoku_panel, BorderLayout.CENTER);
            //σε κάθε κλάση λογικής προσθέτουμε τους παρατηρητές της εφαρμογής.
        sudoku_game.addObserver(button_panel);
        sudoku_game.addObserver(sudoku_panel);
        hyper_game.addObserver(button_panel);
        hyper_game.addObserver(sudoku_panel);
        duidoku_game.addObserver(button_panel);
        duidoku_game.addObserver(sudoku_panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
