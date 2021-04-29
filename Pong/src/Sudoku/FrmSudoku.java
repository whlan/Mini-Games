package Sudoku;

//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.2
//date last modified: 10/20/19
//purpose: This program is a Hangman game in which players are able to interact with
//clicking buttons and see the visual representation of a hangman being drawn for each
//mistake the player makes. Also, the score is kept, and users are able to view them
//from the main menu!

import MainPackage.FrmHangMan;
import MainPackage.FrmGameOver;
import MainPackage.MainApp;
import MainPackage.PointChanger;
import Sudoku.SudokuPuzzle;
import Sudoku.SudokuGenerator;
import Sudoku.SudokuPuzzleType;
import Sudoku.SudokuPanel;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("serial")
public class FrmSudoku extends JFrame implements PointChanger
{


    private JPanel buttonSelectionPanel;
    private SudokuPanel sPanel;

    private JLabel tryagain;
    private JLabel currentPoint;


    public FrmSudoku() {
        this.setMinimumSize(new Dimension(600,400));
//        getContentPane().setLayout(new FlowLayout());
        getContentPane().setLayout(null);
        getContentPane().setPreferredSize(new Dimension(600,400));
//
        buttonSelectionPanel = new JPanel();
        buttonSelectionPanel.setBounds(0,50,140,280);
//        buttonSelectionPanel.setPreferredSize(new Dimension(90,400));

        sPanel = new SudokuPanel(this);
        sPanel.setBounds(140,50,320,320);

        getContentPane().add(buttonSelectionPanel);
        getContentPane().add(sPanel);

        Button submitButton = new java.awt.Button();
        submitButton.setLabel("Submit");
        submitButton.setBounds(10, 330, 120, 20);

        submitButton.addActionListener(evt -> submitButtonActionPerformed(evt));

        getContentPane().add(submitButton);

        Button fillButton = new java.awt.Button();
        fillButton.setLabel("Fill");
        fillButton.setBounds(470, 330, 120, 20);

        fillButton.addActionListener(evt -> btnBackActionPerformed(evt));

        getContentPane().add(fillButton);

        JLabel lbtDateTime = new JLabel("");
        lbtDateTime.setBounds(400, 0, 200, 50);
//        lblResult.setText(""+score);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        //-------- Print time ----------------------------
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                now = LocalDateTime.now();
                lbtDateTime.setText(dtf.format(now));
            }
        }, 0, 1, TimeUnit.SECONDS);
        getContentPane().add(lbtDateTime);
        //-------- Print time ----------------------------

        JLabel pointLabel = new JLabel("Point:");
        pointLabel.setHorizontalAlignment(JLabel.CENTER);
        pointLabel.setFont(new java.awt.Font("Tahoma", 0, 26));
        pointLabel.setBounds(460, 80, 140, 50);

        currentPoint = new JLabel(Integer.toString(SudokuPuzzle.STARTING_POINT));
        currentPoint.setBounds(460, 130, 140, 50);
        currentPoint.setHorizontalAlignment(JLabel.CENTER);

        tryagain = new JLabel("");
        tryagain.setBounds(460, 180, 140, 50);
        tryagain.setFont(new java.awt.Font("Tahoma", 0, 26));
        tryagain.setHorizontalAlignment(JLabel.CENTER);

        setSize(600,400);
        getContentPane().add(pointLabel);
        getContentPane().add(currentPoint);
        getContentPane().add(tryagain);


        rebuildInterface(SudokuPuzzleType.NINEBYNINE, 26);
    }

    public void rebuildInterface(SudokuPuzzleType puzzleType,int fontSize) {
        SudokuPuzzle generatedPuzzle = new SudokuGenerator().generateRandomSudoku(puzzleType);
        sPanel.newSudokuPuzzle(generatedPuzzle);
        sPanel.setFontSize(fontSize);
        buttonSelectionPanel.removeAll();
        for(String value : generatedPuzzle.getValidValues()) {
            JButton b = new JButton(value);
            b.setPreferredSize(new Dimension(40,40));
            b.addActionListener(sPanel.new NumActionListener());
            buttonSelectionPanel.add(b);
        }
        sPanel.repaint();

        buttonSelectionPanel.revalidate();
        buttonSelectionPanel.repaint();
    }
    
    public void fillBoxes(SudokuPuzzleType puzzleType,int fontSize) {
        SudokuPuzzle generatedPuzzle = new SudokuGenerator().autoFill(puzzleType);
        sPanel.newSudokuPuzzle(generatedPuzzle);
        sPanel.setFontSize(fontSize);
        buttonSelectionPanel.removeAll();
        for(String value : generatedPuzzle.getValidValues()) {
            JButton b = new JButton(value);
            b.setPreferredSize(new Dimension(40,40));
            b.addActionListener(sPanel.new NumActionListener());
            buttonSelectionPanel.add(b);
        }
        sPanel.repaint();

        buttonSelectionPanel.revalidate();
        buttonSelectionPanel.repaint();
    }
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        fillBoxes(SudokuPuzzleType.NINEBYNINE, 26);

    }//GEN-LAST:event_btnBackActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
//        this.setVisible(false);
//        MainApp.menu.setVisible(true);
//        MainApp.runCircleClick = false;
        boolean state = sPanel.isGameFinished();
        if(state == true){
            try {
            tryagain.setText("Done!");
            this.setVisible(false);
            this.dispose();
            int num = Integer.parseInt(currentPoint.getText());
            int totalScore = FrmHangMan.totalScore(num);
            MainApp.saveScoreToFile(MainApp.initials, totalScore);
            MainApp.menu.setVisible(true);
            MainApp.runCircleClick = false;
            FrmGameOver frmGameOver = new FrmGameOver();
            frmGameOver.setVisible(true);
            } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
        } else {
            tryagain.setText("Try Again");
        }

    }//GEN-LAST:event_btnBackActionPerformed

    @Override
    public void changePoint(int point) {
        currentPoint.setText(Integer.toString(point));
    }

    @Override
    public void setGameState(boolean state) {
        if(state == true){
            tryagain.setText("Done!");
        } else {
            tryagain.setText("Try Again");
        }
    }




//    private class NewGameListener implements ActionListener {
//
//        private SudokuPuzzleType puzzleType;
//        private int fontSize;
//
//        public NewGameListener(SudokuPuzzleType puzzleType,int fontSize) {
//            this.puzzleType = puzzleType;
//            this.fontSize = fontSize;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            rebuildInterface(puzzleType,fontSize);
//        }
//    }

}