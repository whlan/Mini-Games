package MainPackage;

//file: FrmMainMenu.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This serves as the main menu where users are able to play the Color Clicking Game, Hangman Game,
//view the score, view the credits, and save their score to a file!

import Sudoku.FrmSudoku;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import pong.FrmPong;

/**
 * 
 * @author Ben Mai
 */
public class FrmMainMenu extends JFrame implements ActionListener  {
    private JButton btnPlay;
    private JButton btnPlaySudoku;
    private JButton btnPlayColor;
    private JButton btnScores;
    private JButton btnPlayPingPong;
    private JButton btnCredits;
    private JButton btnSaveInitials;

    private JLabel imgLogo;
    private JLabel lblInitials;
    private JTextField txtInitials;

    /**
     * It just creates a menu with 3 buttons and it displays also a log
     */
    public FrmMainMenu() {
        //Frames.super("Menu");
        MainApp.frmHangMan = new FrmHangMan();  //
        MainApp.frmSudoku = new FrmSudoku();  // initialize the sudoku game
        MainApp.frmCredits = new FrmCredits();
        MainApp.frmPingPong = new FrmPong();
        MainApp.frmPingPong.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Icon imgLogoIcon = new ImageIcon("./gameboy.jpg");
        imgLogo = new JLabel(imgLogoIcon);
        imgLogo.setBounds(200, 100, 200, 200);
        this.add(imgLogo);

        lblInitials = new JLabel("Initials:");
        lblInitials.setBounds(50, 100, 50, 30);
        this.add(lblInitials);

        txtInitials = new JTextField("ABC");
        txtInitials.setToolTipText("Enter the inttial");
        txtInitials.setBounds(100, 100, 50, 30);
        this.add(txtInitials);

        btnSaveInitials = new JButton("Save");
        btnSaveInitials.setToolTipText("Save the intitial");
        btnSaveInitials.setBounds(50, 150, 100, 30);
        this.add(btnSaveInitials);

        this.setSize(600, 400);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnPlay = new JButton ("Play");
        btnPlay.setToolTipText("Click to start the game");
        //btnPlaySudoku = new JButton ("Sudoku"); // Initialize the button with the right name
        //btnPlayColor = new JButton("ColorClick");
        btnScores = new JButton ("High Scores");
        btnCredits = new JButton ("Credits");
        btnPlayPingPong = new JButton("Play Pong");
        
        btnPlay.setBounds(0, 0, 120, 50);
        //btnPlaySudoku.setBounds(120, 0, 120, 50);
        //btnPlayColor.setBounds(240, 0, 120, 50);
        btnScores.setBounds(240, 0, 180, 50);
        btnScores.setToolTipText("Click to see the high scores");
        btnPlayPingPong.setBounds(120, 0, 120, 50);
        btnPlayPingPong.setToolTipText("Click to start play pong game");
        btnCredits.setBounds(420, 0, 120, 50);
        btnCredits.setToolTipText("Click to see the credits");

        btnPlay.setFont(new java.awt.Font("Tahoma", 0, 18));
        //btnPlaySudoku.setFont(new java.awt.Font("Tahoma", 0, 18));
        //btnPlayColor.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnScores.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnPlayPingPong.setFont(new java.awt.Font("Tahoma", 0, 18));
        btnCredits.setFont(new java.awt.Font("Tahoma", 0, 18));

        btnPlay.addActionListener(this);
        //btnPlaySudoku.addActionListener(this);
        //btnPlayColor.addActionListener(this);
        btnScores.addActionListener(this);
        btnCredits.addActionListener(this);
        btnSaveInitials.addActionListener(this);
        btnPlayPingPong.addActionListener(this);
        //add components
        this.add(btnPlay);
        //this.add(btnPlaySudoku);
        //this.add(btnPlayColor);
        this.add(btnScores);
        this.add(btnCredits);
        this.add(btnPlayPingPong);
        ////

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setVisible(true);

    }

    @Override
    /**
     * Actions depending on the selected button
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnPlay)) {
            this.setVisible(false);
            MainApp.frmHangMan.setVisible(true);
        }
        // open sudoku game
        if (e.getSource().equals(btnPlaySudoku)) {
            this.setVisible(false);
            MainApp.frmSudoku.setVisible(true);
        }
        if (e.getSource().equals(btnPlayPingPong)) {
            this.setVisible(false);
            MainApp.frmPingPong.setVisible(true);
        }
        
        
        if (e.getSource().equals(btnScores)) {
            try {
                this.setVisible(false);
                MainApp.frmScore = new FrmScore();
                MainApp.frmScore.setVisible(true);
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        if (e.getSource().equals(btnCredits)) {
            MainApp.frmCredits.setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource().equals(btnPlayPingPong)) {
            pong.PanelInfo.restart();
            MainApp.frmPingPong.setVisible(true);
            this.setVisible(false);
        }
        
        
        if (e.getSource().equals(btnSaveInitials)) {
            MainApp.initials = txtInitials.getText();
            JOptionPane.showMessageDialog(null, "Your initials: " + MainApp.initials + " has been saved");
        }

    }

}
