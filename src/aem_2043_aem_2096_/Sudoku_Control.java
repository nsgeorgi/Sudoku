/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

/**
 *    Η κλάση αυτή αναπαριστά τον χειριστή στο πάνελ των κουμπιών. Ως πεδία έχουμε
 * τη λογικη του παιχνιδιου.
 * @author nikos
 */
public class Sudoku_Control implements MouseListener {

    private Sudoku_Panel sudokuPanel;    // το πάνελ του σουντόκου
    private Classic_Sudoku_Game sudoku_game;
    public Hyper_Sudoku_Game hyper_game;
    public Duidoku_Game duidoku_game;           

    /**
     * κατασκευαστης 
     *
     * @param game η λογική του παιχνιδιου
     */
    public Sudoku_Control(Sudoku_Panel sudokuPanel, Classic_Sudoku_Game s_game, Hyper_Sudoku_Game h_game, Duidoku_Game d_game) {
        this.sudokuPanel = sudokuPanel;
        this.sudoku_game = s_game;
        this.hyper_game = h_game;
        this.duidoku_game = d_game;
    }

    /**
     * Εάν ο χρήστης κάνει κλικ σε ενα κελι του σουντόκου ενεργοποιειται αυτη η συναρτηση.
     * εαν πατησει δεξι κλικ εκχωρει τον αριθμο που επελεξε ο χρηστης  sto selected number και αν είναι εγκυρος θα εκχωρηθει και στο παζλ  και θα ενημερωθουν οι παρατηρητες
     * εαν πατησει αριστερο κλικ σβήνεται ο αριθμος που εχει δωσει και ενημρωνονται οι παρατηρητες 
     * 
     *
     * @param e MouseEvent.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        JPanel panel = (JPanel) e.getSource();
        Component component = panel.getComponentAt(e.getPoint());
        if (component instanceof Field) {
            Field field = (Field) component;
            int x = field.getFieldX();
            int y = field.getFieldY();
            if (sudoku_game.isFlag() == 1) {  //εαν το τρέχον παιχνιδι ειναι το κλασσικο
                   //εαν κάνει δεξι κλικ σε ένα κελι  για να εκχωρηθει ο αριθμος θα πρεπει να ειναι εκγυρος , το κελι σε εκεινη τη θεση να ειναι αδειο
                //και να είναι μπλε
                if (e.getButton() == MouseEvent.BUTTON1 && sudoku_game.isSelectedNumberCandidate(x, y) && (sudoku_game.getNumber(x, y) == 0 || field.getForeground().equals(Color.BLUE))) {
                    int number = sudoku_game.getSelectedNumber();
                    if (number == -1) {
                        return;
                    }
                    sudoku_game.setNumber(x, y, number);
                    if (sudoku_game.wordoku) {
                        field.setNumber_withletters(number, true);
                    } else {
                        field.setNumber(number, true);
                    }
                    //εαν κανει αριστερο κλικ
                } else if (e.getButton() == MouseEvent.BUTTON3 && !field.getForeground().equals(Color.BLACK)) {
                    sudoku_game.setNumber(x, y, 0);
                    field.setNumber(0, false);
                }
                sudokuPanel.update(sudoku_game, Update_Action.CANDIDATES);
            } else if (sudoku_game.isFlag() == 2) { //εαν το τρεχον παιχνιδι ειναι h hyper παραλλαγη
                   //εαν κάνει δεξι κλικ σε ένα κελι  για να εκχωρηθει ο αριθμος θα πρεπει να ειναι εκγυρος , το κελι σε εκεινη τη θεση να ειναι αδειο
                //και να ειναι μπλε
                if (e.getButton() == MouseEvent.BUTTON1 && hyper_game.isSelectedNumberCandidate(x, y) && (hyper_game.getNumber(x, y) == 0 || field.getForeground().equals(Color.BLUE))) {
                    int number = hyper_game.getSelectedNumber();
                    if (number == -1) {
                        return;
                    }
                    hyper_game.setNumber(x, y, number);
                    if (hyper_game.wordoku) {
                        field.setNumber_withletters(number, true);
                    } else {
                        field.setNumber(number, true);
                    }
                    //εαν κανει αριστερο κλικ
                } else if (e.getButton() == MouseEvent.BUTTON3 && !field.getForeground().equals(Color.BLACK)) {
                    hyper_game.setNumber(x, y, 0);
                    field.setNumber(0, false);
                }
                sudokuPanel.update(hyper_game, Update_Action.CANDIDATES);
            } else {  //εαν το τρεχον παιχνιδι ειναι h duidoku παραλλαγη
                //εαν κάνει δεξι κλικ σε ένα κελι  για να εκχωρηθει ο αριθμος θα πρεπει να ειναι εκγυρος , το κελι σε εκεινη τη θεση να ειναι αδειο
                //και να είναι μπλε
                if (e.getButton() == MouseEvent.BUTTON1 && duidoku_game.isSelectedNumberCandidate(x, y) && (duidoku_game.getNumber(x, y) == 0 || field.getForeground().equals(Color.blue))) {
                    int number = duidoku_game.getSelectedNumber();
                    if (number == -1) {
                        return;
                    }
                  
                    duidoku_game.setNumber(x, y, number);
                    if (duidoku_game.wordoku) {
                        field.setNumber_withletters(number, true);
                    } else {
                        field.setNumber(number, true);
                    }
                 //ενημερωνονται οι παρατηρητες 
             sudokuPanel.update(duidoku_game, Update_Action.CANDIDATES);
              duidoku_game.computers_turn();
               } 
               
            }  



        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}
