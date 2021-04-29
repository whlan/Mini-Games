/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainPackage;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrmGameOver extends JFrame implements ActionListener{
     private JLabel lblGameOver, lblTotalScore, lblScore;
     private JButton buttonQuit;
    /**
     * To display the first window
     */
    public FrmGameOver() {
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.BLACK); 
        this.setSize(600, 400);
        lblGameOver = new JLabel();
        lblTotalScore = new JLabel();
        lblScore = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        
        lblGameOver.setFont(new java.awt.Font("Tahoma", 0, 55)); 
        lblGameOver.setForeground(Color.RED);
        lblGameOver.setText("GAME OVER!!!");
        lblGameOver.setBounds(120, 30, 600, 60);
        
        lblTotalScore.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        lblTotalScore.setForeground(Color.WHITE);
        lblTotalScore.setText("TOTAL SCORE");
        lblTotalScore.setBounds(180, 110, 600, 40);
        
        lblScore.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        lblScore.setForeground(Color.WHITE);
        lblScore.setText(MainApp.initials + " "+Integer.toString(FrmHangMan.totalScore(0)));
        lblScore.setBounds(230, 160, 600, 40);
        
        buttonQuit = new JButton("Back");
        buttonQuit.setBounds(230, 250, 100, 20);
        buttonQuit.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        buttonQuit.addActionListener(this);
        this.add(lblGameOver);
        this.add(lblTotalScore);
        this.add(lblScore);
        this.add(buttonQuit);
    }
    
    @Override
    /**
     * Actions depending on the selected button
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(buttonQuit)) {
            this.setVisible(false);
            this.dispose();
            MainApp.menu.setVisible(true);
        }
    }
               
}
