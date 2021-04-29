package MainPackage;

//file: FrmScore.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 9/21/19
//purpose: This shows the scores listed from greatest at the top to lowest at the bottom corresponding to the user name
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Ben Mai
 */
class FrmScore extends JFrame implements ActionListener {

    private final JLabel lblTitle;
    private JLabel lblScore01, lblScore02, lblScore03, lblScore04, lblScore05, lblScore06, lblScore07 ;
    private final JButton buttonQuit;
    
    /**
     * Constructor
     */
    public FrmScore() throws IOException {
        getContentPane().setLayout(null);
        this.setSize(600, 400);
        lblTitle = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        lblTitle.setText("High Scores");
        lblTitle.setBounds(30, 30, 600, 30);
        
        updateScores();
        this.add(lblTitle);
        
        buttonQuit = new JButton("Back");
        buttonQuit.setBounds(400, 280, 100, 20);
        buttonQuit.addActionListener(this);
        getContentPane().add(buttonQuit);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    @Override
    /**
     * Action to get back to the menu
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(buttonQuit)) {
            this.setVisible(false);
            MainApp.menu.setVisible(true);
        }
    }

    /**
     * Update the scores depending on the linked list size
     */
    private void updateScores() throws IOException {
        //sort the list to get the most hight first
        //Collections.sort(FrmHangMan.scores, Collections.reverseOrder());
        LinkedList<Score> scoreList = new LinkedList();
        scoreList = MainApp.getScores();
        lblScore01 = new JLabel("");
        lblScore02 = new JLabel("");
        lblScore03 = new JLabel("");
        lblScore04 = new JLabel("");
        lblScore05 = new JLabel("");
        lblScore06 = new JLabel("");
        lblScore07 = new JLabel("");
        //depending on list size, display scores
        if (scoreList.size()>0) {
            lblScore01.setText(scoreList.get(0).getInitials() +"-----------------------------------"+ scoreList.get(0).getScore());
        }
        if (scoreList.size()>1) {
            lblScore02.setText(scoreList.get(1).getInitials() +"-----------------------------------"+ scoreList.get(1).getScore());
        }
        if (scoreList.size()>2) {
            lblScore03.setText(scoreList.get(2).getInitials() +"-----------------------------------"+ scoreList.get(2).getScore());
        }
        if (scoreList.size()>3) {
            lblScore04.setText(scoreList.get(3).getInitials() +"-----------------------------------"+ scoreList.get(3).getScore());
        }
        if (scoreList.size()>4) {
            lblScore05.setText(scoreList.get(4).getInitials() +"-----------------------------------"+ scoreList.get(4).getScore());
        }
        if (scoreList.size()>5) {
            lblScore06.setText(scoreList.get(5).getInitials() +"-----------------------------------"+ scoreList.get(5).getScore());
        }
        if (scoreList.size()>6) {
            lblScore07.setText(scoreList.get(6).getInitials() +"-----------------------------------"+ scoreList.get(6).getScore());
        }

        
        lblScore01.setBounds(200, 60, 600, 30);
        lblScore02.setBounds(200, 90, 600, 30);
        lblScore03.setBounds(200,120, 600, 30);
        lblScore04.setBounds(200,150, 600, 30);
        lblScore05.setBounds(200,180, 600, 30);
        lblScore06.setBounds(200,210, 600, 30);
        lblScore07.setBounds(200,240, 600, 30);

        this.add(lblScore01);
        this.add(lblScore02);
        this.add(lblScore03);
        this.add(lblScore04);
        this.add(lblScore05);
        this.add(lblScore06);
        this.add(lblScore07);
    }
}