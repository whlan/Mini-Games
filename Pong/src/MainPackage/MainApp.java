package MainPackage;

//file: MainApp.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This program is a Hangman game in which players are able to interact with
//clicking buttons and see the visual representation of a hangman being drawn for each 
//mistake the player makes. Also, the score is kept, and users are able to view them 
//from the main menu!

import Sudoku.FrmSudoku;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.awt.event.KeyEvent;
import pong.FrmPong;

/**
 * 
 * @author Ben Mai
 */
public class MainApp {
    public static FrmMainMenu menu;
    public static FrmHangMan frmHangMan;
    public static FrmSudoku frmSudoku; // added the FrmSudoku
    public static FrmScore frmScore;
    public static FrmCredits frmCredits ;
    public static FrmColorClick frmColorClick;
    public static FrmPong frmPingPong;
    public static FrmGameOver frmGameOver;
    public static boolean runCircleClick = false;
    public static String initials = "ABC";
    public static final String FILENAME = "scores.txt";
    private static JFrame frame;
    
    /**
     * Main method
     * @param args 
     */
    public static void main(String[] args) {
        FrmSplash splash = new FrmSplash();
        splash.setVisible(true);
        frame = new JFrame("CS2450 Project");
        //Wait 3 seconds before to hide splash
        try {
            Thread.sleep(3000);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        splash.setVisible(false);
        splash = null;
        menu = new FrmMainMenu();
        menu.setVisible(true);
        
         KeyboardFocusManager.getCurrentKeyboardFocusManager()
                .addKeyEventDispatcher(new KeyEventDispatcher() {
                    @Override
                    public boolean dispatchKeyEvent(KeyEvent e) {
                        if(KeyEvent.KEY_PRESSED == e.getID()){
                            if(e.getKeyCode()==KeyEvent.VK_F1)
                            JOptionPane.showMessageDialog(frame,
                                    "                 " +
                                            "Created By:" + "\n" +
                                            "Benjamin Mai: 012316889" + "\n" +
                                            "Rigo Maldonado: 011920935" + "\n" +
                                            "Wei-Hao Lan: 011708593" + "\n" +
                                            "    CS2450 Semester Project" + "\n" +
                                            "               Fall 2019");

                        }
                        if(KeyEvent.KEY_PRESSED == e.getID()){
                            if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
                                System.exit(0);
                        }
                        return false;
                    }
                });
    }
    public static void saveScoreToFile(String initials, int score) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true));
        bw.write(initials+","+score);
        bw.append(System.getProperty("line.separator"));
        bw.close();
    }
    public static LinkedList<Score> getScores() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(FILENAME));
        String line = br.readLine();
        LinkedList<Score> scoreList = new LinkedList();
        while (line!=null && line.trim()!="") {
            if (line.contains(",")) {
                System.out.println(line.split(",")[0] + "\t" + Integer.parseInt(line.split(",")[1]));
                scoreList.add(new Score(line.split(",")[0],Integer.parseInt(line.split(",")[1])));
            }
            line = br.readLine();
        }
        //-------- SORT
        scoreList.sort(Comparator.comparing(Score::getScore).reversed());
        return scoreList;
    }
    
}
