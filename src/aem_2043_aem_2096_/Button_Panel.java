/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aem_2043_aem_2096_;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *Η κλάση αυτη αναπαριστα το πανελ με τα κουμπια .Δημιουργείται όλο το πανελ με τα κουμπια 
 * ως πεδια εχουμε κουμπια και τη λογικη
 * @author nikos
 */
public class Button_Panel extends JPanel implements Observer {

    JButton btnNew1, btnNew2, btnNew3, btnExit;   // κουμπια
    JCheckBox cbHelp, cbHelp1;               // check box.
    ButtonGroup bgNumbers;          // τα κουμπια με τους αριθμους 
    JButton[] btnNumbers;     
    JLabel l; // τα στατιστικα
    private Game game;

    /**
     * κατασκευαστης 
     */
    public Button_Panel(Game game) {

        super(new BorderLayout());
        this.game = game;
        String s = "";
        Profile profile = new Profile();
        JTextField text = new JTextField();

        JPanel pnlAlign = new JPanel();

        pnlAlign.setLayout(new BoxLayout(pnlAlign, BoxLayout.PAGE_AXIS));
        add(pnlAlign, BorderLayout.NORTH);
        int reply = JOptionPane.showConfirmDialog(null, "Are you a NEW PLAYER?", "Player", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Object[] obj = {"Give your new  name:\n\n", text};
            Object stringArray[] = {"OK"};
            if (JOptionPane.showOptionDialog(pnlAlign, obj, "Name",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj) == JOptionPane.OK_OPTION) {
 //το νεο ονομα το αποθηκευουμε στο προφιλ του τρεχοντος χρηστη.
                s = text.getText();
                profile.setName(s);
                game.add_player(profile);
                game.setCurrent_player(profile);
              
               
            }

        } else {
            boolean name_exist = false;
            Object[] obj = {"Give your old name:\n\n", text};
            Object stringArray[] = {"OK"};
            if (JOptionPane.showOptionDialog(pnlAlign, obj, "Name",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj) == JOptionPane.OK_OPTION) {
                s = text.getText();
                name_exist = game.check_name(s);
                game.setCurrent_player(profile);
                //εαν το παλιο ονομα δεν υπαρχει θα του ξαναζητηθει να δωσει το παλιο αλλιωσ να δωσει ενα νεο ονομα
                while (!name_exist) {
                    reply = JOptionPane.showConfirmDialog(null, "Your name doesnt exist.Do you want to try again ?", "Player", JOptionPane.YES_NO_OPTION);
                    if (reply == JOptionPane.YES_OPTION) {
                        Object[] obj2 = {"Giveyour old  name:\n\n", text};

                        if (JOptionPane.showOptionDialog(pnlAlign, obj2, "Name",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj2) == JOptionPane.OK_OPTION) {
                            s = text.getText();
                            name_exist = game.check_name(s);
                            game.setCurrent_player(profile);
                        }

                    } else {

                        Object[] obj4 = {"Give new  name:\n\n", text};

                        if (JOptionPane.showOptionDialog(pnlAlign, obj4, "Name",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, stringArray, obj4) == JOptionPane.OK_OPTION) {
                            s = text.getText();
                            profile.setName(s);
                            game.add_player(profile);
                            game.setCurrent_player(profile);
                            name_exist = true;
                        }
                    }
                }
            }
        }



        JPanel pnlOptions1 = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlOptions1.setBorder(BorderFactory.createTitledBorder(" PLAYER INFORMATION: "));
        pnlAlign.add(pnlOptions1);
        l = new JLabel("Name :  " + s + "  Wins : " + game.getCurrent_player().getWins() + "  Losses : " + game.getCurrent_player().getLosses());
        pnlOptions1.add(l);
        

        JPanel pnlOptions = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlOptions.setBorder(BorderFactory.createTitledBorder("Game Options "));
        pnlAlign.add(pnlOptions);

        btnNew1 = new JButton("New_Sudoku_Game");
        btnNew1.setFocusable(false);
        pnlOptions.add(btnNew1);
        btnNew2 = new JButton("New_Hyper_Game");
        btnNew2.setFocusable(false);
        pnlOptions.add(btnNew2);
        btnNew3 = new JButton("New_Duidoku_Game");
        btnNew3.setFocusable(false);
        pnlOptions.add(btnNew3);



        btnExit = new JButton("Save and Exit");
        btnExit.setFocusable(false);
        pnlOptions.add(btnExit);

        JPanel pnlNumbers = new JPanel();
        pnlNumbers.setLayout(new BoxLayout(pnlNumbers, BoxLayout.PAGE_AXIS));
        pnlNumbers.setBorder(BorderFactory.createTitledBorder(" Numbers "));
        pnlAlign.add(pnlNumbers);

        JPanel pnlNumbersHelp = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlNumbers.add(pnlNumbersHelp);

        cbHelp = new JCheckBox("Help on", true);
        cbHelp.setFocusable(false);
        pnlNumbersHelp.add(cbHelp);
        cbHelp1 = new JCheckBox("Wordoku_on", false);
        cbHelp1.setFocusable(false);
        pnlNumbersHelp.add(cbHelp1);

        JPanel pnlNumbersNumbers = new JPanel(new FlowLayout(FlowLayout.LEADING));
        pnlNumbers.add(pnlNumbersNumbers);

        bgNumbers = new ButtonGroup();
        btnNumbers = new JButton[9];
        for (int i = 0; i < 9; i++) {
            btnNumbers[i] = new JButton("" + (i + 1));
            btnNumbers[i].setText("1");

            btnNumbers[i].setPreferredSize(new Dimension(40, 40));
            btnNumbers[i].setFocusable(false);
            bgNumbers.add(btnNumbers[i]);
            pnlNumbersNumbers.add(btnNumbers[i]);
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
              
                for (int i = 0; i < 9; i++) {

                    btnNumbers[i].setVisible(true);
                }
                l.setText("Name :  " + game.getCurrent_player().getName() + "  Wins : " + game.getDuidoku().getWins() + "  Losses : " + game.getDuidoku().getLosses());
                break;
            case NEW_GAME_HYPER_SUDOKU:
                for (int i = 4; i < 9; i++) {

                    btnNumbers[i].setVisible(true);
                }
                l.setText("Name :  " + game.getCurrent_player().getName() + "  Wins : " + game.getDuidoku().getWins() + "  Losses : " + game.getDuidoku().getLosses());
                break;
            case NEW_GAME_DUIDOKU:
                for (int i = 4; i < 9; i++) {

                    btnNumbers[i].setVisible(false);
                }
                l.setText("Name :  " + game.getCurrent_player().getName() + "  Wins : " + game.getDuidoku().getWins() + "  Losses : " + game.getDuidoku().getLosses());

                break;

        }
    }

    /**
     * σε ολα τα components  προσθετει χειρισμο 
     *
     * @param buttonController χείριστης ο οποιος χειριζεται ολα τα αction με τα κουμπια 
     */
    public void setController(Button_Control buttonController) {
        btnNew1.addActionListener(buttonController);
        btnNew2.addActionListener(buttonController);
        btnNew3.addActionListener(buttonController);




        btnExit.addActionListener(buttonController);
        cbHelp.addActionListener(buttonController);
        cbHelp1.addActionListener(buttonController);
        for (int i = 0; i < 9; i++) {
            btnNumbers[i].addActionListener(buttonController);
        }
    }
}