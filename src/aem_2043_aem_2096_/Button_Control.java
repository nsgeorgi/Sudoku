/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 * Η κλάση αυτή αναπαριστά τον χειριστή στο πάνελ των κουμπιών. Ως πεδία έχουμε
 * τη λογικη του παιχνιδιου.
 *
 * @author nikos
 */
public class Button_Control implements ActionListener {

    private Classic_Sudoku_Game sudoku_game;
    private Hyper_Sudoku_Game hyper_game;
    private Duidoku_Game duidoku_game;
    private Game game;

    /**
     * κατασκευαστης
     *
     * @param game Game to be set.
     */
    public Button_Control(Game game) {
        this.sudoku_game = game.getClassic_Sudoku();
        this.hyper_game = game.getHyper_sudoku();
        this.duidoku_game = game.getDuidoku();
        this.game = game;

    }

    /**
     * Μετά απο κάθε πατημα κουμπιου γίνεται και ένα action.
     *
     * @param e ActionEvent.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "New_Sudoku_Game":
                sudoku_game.New_Game();
                break;
            case "New_Hyper_Game":
                hyper_game.New_Game();
                break;
            case "New_Duidoku_Game":
                duidoku_game.New_Game();
                break;
            case "Save and Exit":
                int reply = JOptionPane.showConfirmDialog(null, "Do you want to save your game", "Save", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {

                    try {
                        PrintWriter out = new PrintWriter("saved_game.txt");



                        if (sudoku_game.isFlag() == 1) {  //περίπτωση όπου θέλουμε να αποθηκευσουμε ένα παιχνιδι της κλασσικης εκδοσης 
                            out.print("SUDOKU");
                            out.println();


                            for (int i = 0; i < 9; i++) {
                                out.println();
                                for (int j = 0; j < 9; j++) {
                                    out.print(sudoku_game.current_game[i][j]);
                                    out.print(" ");

                                }

                            }
                        } else if (sudoku_game.isFlag() == 2) {    //περίπτωση όπου θέλουμε να αποθηκευσουμε ένα παιχνιδι της hyper παραλλαγης 
                            out.print("HYPERSUDOKU");

                            for (int i = 0; i < 9; i++) {
                                out.println();

                                for (int j = 0; j < 9; j++) {
                                    out.print(hyper_game.current_game[i][j]);
                                    out.print(" ");

                                }
                            } 
                        } else {   //περίπτωση όπου θέλουμε να αποθηκευσουμε ένα παιχνιδι της duidoku παραλλαγης
                            out.print("DUIDOKU");

                            for (int i = 0; i < 9; i++) {
                                out.println();

                                for (int j = 0; j < 9; j++) {
                                    out.print(duidoku_game.current_game[i][j]);
                                    out.print(" ");

                                }
                            }

                        }
                        out.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Button_Control.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    PrintWriter out1;
                    try {
                        out1 = new PrintWriter(new FileOutputStream(new File("saved_profiles.txt"), true));
                        out1.println(game.getCurrent_player().getName());

                            //αποθήκευση των στατιστικων και του ονοματος του τρεχον χρηστη

                        out1.print(game.getCurrent_player().getSudoku_puzzles_solved() + " " + game.getCurrent_player().getHyper_puzzles_solved() + " " + game.getDuidoku().getWins() + " " + game.getDuidoku().getLosses());
                        out1.println();
                        out1.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Button_Control.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    JOptionPane.showMessageDialog(null, "Save Completed");
                    JOptionPane.showMessageDialog(null, "GOODBYE");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(null, "GOODBYE");
                    System.exit(0);
                }
                break;
            case "Help on":    // check box
                if (sudoku_game.isFlag() == 1) {
                    sudoku_game.setHelp(((JCheckBox) e.getSource()).isSelected());
                } else if (sudoku_game.isFlag() == 2) {
                    hyper_game.setHelp(((JCheckBox) e.getSource()).isSelected());
                } else {
                    duidoku_game.setHelp(((JCheckBox) e.getSource()).isSelected());
                }
                break;
            case "Wordoku_on":  //wordoku box
                if (sudoku_game.isFlag() == 1) {
                    sudoku_game.convert_letter_to_numbers(((JCheckBox) e.getSource()).isSelected());
                } else if (sudoku_game.isFlag() == 2) {
                    hyper_game.convert_letter_to_numbers(((JCheckBox) e.getSource()).isSelected());
                } else {
                    duidoku_game.convert_letter_to_numbers(((JCheckBox) e.getSource()).isSelected());
                }
                break;
            default:
                if (sudoku_game.isFlag() == 1) {
                    sudoku_game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
                } else {
                    if (sudoku_game.isFlag() == 2) {
                        hyper_game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));
                    } else {
                        duidoku_game.setSelectedNumber(Integer.parseInt(e.getActionCommand()));

                    }

                }
                break;
        }
    }
}
