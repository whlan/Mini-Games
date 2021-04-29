package MainPackage;

//file: FrmHangMan.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 9/21/19
//purpose: This program is a Hangman game in which players are able to interact with
//clicking buttons and see the visual representation of a hangman being drawn for each 
//mistake the player makes. Also, the score is kept, and users are able to view them 
//from the main menu!
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
/**
 * 
 * @author Ben Mai
 */
public class FrmHangMan extends JFrame implements ActionListener 
{

    private JButton buttonQuit, buttonSkip;
    private JButton buttonA, buttonB, buttonC, buttonD, buttonE, buttonF,
            buttonG, buttonH, buttonI, buttonJ, buttonK, buttonL, buttonM,
            buttonN, buttonO, buttonP, buttonQ, buttonR, buttonS, buttonT,
            buttonU, buttonV, buttonW, buttonX, buttonY, buttonZ;
    private JTextField txtGuessUser;
    private JLabel lblGuessUser, imageN, imageN1, imageN2,
            imageN3, imageN4, imageN5, imageN6, lbtDateTime, lblResult;
    private String Word;
    private String[] lines = new String[10];    //10 is the max size of characters
    public int counter = 0, correctCounter = 0, failsQuant = 0 ;
    public static int score = 100, storeNum = 0;
    private JLabel image0, image01, image02,
            image03, image04, image05, image06;
    public static LinkedList<Integer> scores = new LinkedList();
    
    /**
     * Frame with the hangman game
     */
    public FrmHangMan() {
        setDefaultCloseOperation(3);    //Exit on close
        
        lblGuessUser = new JLabel(" Word: ");
        lblGuessUser.setBounds(200, 20, 100, 20);
        lbtDateTime = new JLabel("");
        lbtDateTime.setBounds(400, 0, 200, 50);
        txtGuessUser = new JTextField("");
        txtGuessUser.setEditable(false);
        txtGuessUser.setBounds(200, 50, 350, 50);
        txtGuessUser.setFont(new java.awt.Font("Tahoma", 0, 36));
        buttonA = new JButton("A");
        buttonA.setBounds(0, 255, 45, 40);
        buttonA.setToolTipText("Select");
        buttonB = new JButton("B");
        buttonB.setBounds(45, 255, 45, 40);
        buttonB.setToolTipText("Select");
        buttonC = new JButton("C");
        buttonC.setBounds(90, 255, 45, 40);
        buttonC.setToolTipText("Select");
        buttonD = new JButton("D");
        buttonD.setBounds(135, 255, 45, 40);
        buttonD.setToolTipText("Select");
        buttonE = new JButton("E");
        buttonE.setBounds(180, 255, 45, 40);
        buttonE.setToolTipText("Select");
        buttonF = new JButton("F");
        buttonF.setBounds(225, 255, 45, 40);
        buttonF.setToolTipText("Select");
        buttonG = new JButton("G");
        buttonG.setBounds(270, 255, 45, 40);
        buttonG.setToolTipText("Select");
        buttonH = new JButton("H");
        buttonH.setBounds(315, 255, 45, 40);
        buttonH.setToolTipText("Select");
        buttonI = new JButton("I");
        buttonI.setBounds(360, 255, 45, 40);
        buttonI.setToolTipText("Select");
        buttonJ = new JButton("J");
        buttonJ.setBounds(405, 255, 45, 40);
        buttonJ.setToolTipText("Select");
        buttonK = new JButton("K");
        buttonK.setBounds(450, 255, 45, 40);
        buttonK.setToolTipText("Select");
        buttonL = new JButton("L");
        buttonL.setBounds(495, 255, 45, 40);
        buttonL.setToolTipText("Select");
        buttonM = new JButton("M");
        buttonM.setBounds(540, 255, 45, 40);
        buttonM.setToolTipText("Select");
        buttonN = new JButton("N");
        buttonN.setBounds(0, 300, 45, 40);
        buttonN.setToolTipText("Select");
        buttonO = new JButton("O");
        buttonO.setBounds(45, 300, 45, 40);
        buttonO.setToolTipText("Select");
        buttonP = new JButton("P");
        buttonP.setBounds(90, 300, 45, 40);
        buttonP.setToolTipText("Select");
        buttonQ = new JButton("Q");
        buttonQ.setBounds(135, 300, 50, 40);
        buttonQ.setToolTipText("Select");
        buttonR = new JButton("R");
        buttonR.setBounds(180, 300, 50, 40);
        buttonR.setToolTipText("Select");
        buttonS = new JButton("S");
        buttonS.setBounds(225, 300, 50, 40);
        buttonS.setToolTipText("Select");
        buttonT = new JButton("T");
        buttonT.setBounds(270, 300, 50, 40);
        buttonT.setToolTipText("Select");
        buttonU = new JButton("U");
        buttonU.setBounds(315, 300, 50, 40);
        buttonU.setToolTipText("Select");
        buttonV = new JButton("V");
        buttonV.setBounds(360, 300, 50, 40);
        buttonV.setToolTipText("Select");
        buttonW = new JButton("W");
        buttonW.setBounds(405, 300, 50, 40);
        buttonW.setToolTipText("Select");
        buttonX = new JButton("X");
        buttonX.setBounds(450, 300, 50, 40);
        buttonX.setToolTipText("Select");
        buttonY = new JButton("Y");
        buttonY.setBounds(495, 300, 50, 40);
        buttonY.setToolTipText("Select");
        buttonZ = new JButton("Z");
        buttonZ.setBounds(540, 300, 50, 40);
        buttonZ.setToolTipText("Select");

        buttonQuit = new JButton("Back");
        buttonQuit.setBounds(200, 200, 100, 20);

        buttonSkip = new JButton("Skip");
        buttonSkip.setBounds(200, 160, 100, 20);
        buttonSkip.setToolTipText("Continue to next game");

        buttonQuit.addActionListener(this);
        buttonSkip.addActionListener(this);
        buttonA.addActionListener(this); buttonB.addActionListener(this); buttonC.addActionListener(this); 
        buttonD.addActionListener(this); buttonE.addActionListener(this); buttonF.addActionListener(this); 
        buttonG.addActionListener(this); buttonH.addActionListener(this); buttonI.addActionListener(this); 
        buttonJ.addActionListener(this); buttonK.addActionListener(this); buttonL.addActionListener(this); 
        buttonM.addActionListener(this); buttonN.addActionListener(this); buttonO.addActionListener(this); 
        buttonP.addActionListener(this); buttonQ.addActionListener(this); buttonR.addActionListener(this);
        buttonS.addActionListener(this); buttonT.addActionListener(this); buttonU.addActionListener(this);
        buttonV.addActionListener(this); buttonW.addActionListener(this); buttonX.addActionListener(this);
        buttonY.addActionListener(this); buttonZ.addActionListener(this); 

        Icon imageFirst = new ImageIcon("./0.gif");
        imageN = new JLabel(imageFirst);
        imageN.setBounds(30, 50, 160, 170);

        Icon image01 = new ImageIcon("./1.gif");
        imageN1 = new JLabel(image01);
        imageN1.setBounds(30, 50, 160, 170);

        Icon image02 = new ImageIcon("./2.gif");
        imageN2 = new JLabel(image02);
        imageN2.setBounds(30, 50, 160, 170);

        Icon image03 = new ImageIcon("./3.gif");
        imageN3 = new JLabel(image03);
        imageN3.setBounds(30, 50, 160, 170);

        Icon image04 = new ImageIcon("./4.gif");
        imageN4 = new JLabel(image04);
        imageN4.setBounds(30, 50, 160, 174);

        Icon image05 = new ImageIcon("./5.gif");
        imageN5 = new JLabel(image05);
        imageN5.setBounds(30, 50, 160, 170);

        Icon image06 = new ImageIcon("./6.gif");
        imageN6 = new JLabel(image06);
        imageN6.setBounds(30, 50, 160, 170);

        lblResult = new JLabel();
        lblResult.setBounds(350, 140, 200, 50);
        lblResult.setFont(new java.awt.Font("Tahoma", 0, 36));
        getContentPane().add(lblResult);
        
        images();
        createWord();
        getContentPane().add(lblGuessUser);
        getContentPane().add(txtGuessUser);
        getContentPane().add(buttonQuit);
        getContentPane().add(buttonSkip);
        getContentPane().add(lbtDateTime);
        
        getContentPane().add(buttonA); getContentPane().add(buttonB); getContentPane().add(buttonC); 
        getContentPane().add(buttonD); getContentPane().add(buttonE); getContentPane().add(buttonF); 
        getContentPane().add(buttonG); getContentPane().add(buttonH); getContentPane().add(buttonI); 
        getContentPane().add(buttonJ); getContentPane().add(buttonK); getContentPane().add(buttonL); 
        getContentPane().add(buttonM); getContentPane().add(buttonN); getContentPane().add(buttonO);
        getContentPane().add(buttonP); getContentPane().add(buttonQ); getContentPane().add(buttonR);
        getContentPane().add(buttonS); getContentPane().add(buttonT); getContentPane().add(buttonU);
        getContentPane().add(buttonV); getContentPane().add(buttonW); getContentPane().add(buttonX); 
        getContentPane().add(buttonY); getContentPane().add(buttonZ); 
        getContentPane().setLayout(null);
        setSize(600, 400);
        lblResult.setText(""+score);
        
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
        //-------- Print time ----------------------------

    }
    /**
     * This method creates the random word
     */
    private void createWord() {
        String[] wordList = {"abstract", "cemetery", "nurse", "pharmacy", "climbing"};
        int pala = (int) (Math.random() * wordList.length);
        Word = wordList[pala];
        for (int j = 0; j < Word.length(); j++) {
            counter++;
            lines[j] = "_";
            txtGuessUser.setText(txtGuessUser.getText() + lines[j] + " ");
        }
    }

    /**
     * It displays the proper image depending on number of fails
     */
    private void images() {
        if (failsQuant == 0) {
            imageN.setVisible(true);
            getContentPane().add(imageN);
        }
        if (failsQuant == 1) {
            imageN1.setVisible(true);
            imageN.setVisible(false);
            getContentPane().add(imageN1);
        }
        if (failsQuant == 2) 
        {
            imageN2.setVisible(true);
            imageN1.setVisible(false);
            getContentPane().add(imageN2);
        }
        if (failsQuant == 3) 
        {
            imageN3.setVisible(true);
            imageN2.setVisible(false);
            getContentPane().add(imageN3);
        }
        if (failsQuant == 4) 
        {
            imageN4.setVisible(true);
            imageN3.setVisible(false);
            getContentPane().add(imageN4);
        }
        if (failsQuant == 5) 
        {
            imageN5.setVisible(true);
            imageN4.setVisible(false);
            getContentPane().add(imageN5);
        }
        if (failsQuant == 6) 
        {
            imageN6.setVisible(true);
            imageN5.setVisible(false);
            getContentPane().add(imageN6);
        }

    }

    /**
     * The logic each time than a letter button is pressed
     * @param letter 
     */
    public void logic(char letter){
        String letter2 = ""+letter;
        String temp = txtGuessUser.getText();
        int wordCorrect = 0;
        boolean correctWord = false;
        failsQuant++;
        /*
        if (failsQuant>0) 
        {
            score = 100 - failsQuant*10;
        }
        */
        for (int i = 0; i < Word.length(); i++)
        {

            if (letter == Word.charAt(i)) 
            {
                lines[i] = letter2;
                correctCounter++;
                correctWord = true;
                txtGuessUser.setText(null);
                failsQuant = failsQuant - 1;

                for (int j = 0; j < Word.length(); j++) 
                {

                    txtGuessUser.setText(txtGuessUser.getText() + lines[j] + " ");
                }
            }
        }
        if(correctWord == false)
        {
            score -= 10;
        }
        lblResult.setText(""+score);
        
    }
    /**
     * The actions depending on the button pressed
     * @param e 
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource().equals(buttonQuit)) 
        {
            this.setVisible(false);
            this.dispose();
            skip();
            MainApp.menu.setVisible(true);
        }
        if (e.getSource().equals(buttonA)) { logic('a'); buttonA.setEnabled(false); }
        if (e.getSource().equals(buttonB)) { logic('b'); buttonB.setEnabled(false); }
        if (e.getSource().equals(buttonC)) { logic('c'); buttonC.setEnabled(false); }
        if (e.getSource().equals(buttonD)) { logic('d'); buttonD.setEnabled(false); }
        if (e.getSource().equals(buttonE)) { logic('e'); buttonE.setEnabled(false); }
        if (e.getSource().equals(buttonF)) { logic('f'); buttonF.setEnabled(false); }
        if (e.getSource().equals(buttonG)) { logic('g'); buttonG.setEnabled(false); }
        if (e.getSource().equals(buttonH)) { logic('h'); buttonH.setEnabled(false); }
        if (e.getSource().equals(buttonI)) { logic('i'); buttonI.setEnabled(false); }
        if (e.getSource().equals(buttonJ)) { logic('j'); buttonJ.setEnabled(false); }
        if (e.getSource().equals(buttonK)) { logic('k'); buttonK.setEnabled(false); }
        if (e.getSource().equals(buttonL)) { logic('l'); buttonL.setEnabled(false); }
        if (e.getSource().equals(buttonM)) { logic('m'); buttonM.setEnabled(false); }
        if (e.getSource().equals(buttonN)) { logic('n'); buttonN.setEnabled(false); }
        if (e.getSource().equals(buttonO)) { logic('o'); buttonO.setEnabled(false); }
        if (e.getSource().equals(buttonP)) { logic('p'); buttonP.setEnabled(false); }
        if (e.getSource().equals(buttonQ)) { logic('q'); buttonQ.setEnabled(false); }
        if (e.getSource().equals(buttonR)) { logic('r'); buttonR.setEnabled(false); }
        if (e.getSource().equals(buttonS)) { logic('s'); buttonS.setEnabled(false); }
        if (e.getSource().equals(buttonT)) { logic('t'); buttonT.setEnabled(false); }
        if (e.getSource().equals(buttonU)) { logic('u'); buttonU.setEnabled(false); }
        if (e.getSource().equals(buttonV)) { logic('v'); buttonV.setEnabled(false); }
        if (e.getSource().equals(buttonW)) { logic('w'); buttonW.setEnabled(false); }
        if (e.getSource().equals(buttonX)) { logic('x'); buttonX.setEnabled(false); }
        if (e.getSource().equals(buttonY)) { logic('y'); buttonY.setEnabled(false); }
        if (e.getSource().equals(buttonZ)) { logic('z'); buttonZ.setEnabled(false); }
        
        images();

        if (correctCounter == counter) 
        {
          
                lblResult.setText("You win!!!");
                totalScore(score);
                setButtons(false);
                this.setVisible(false);
                skip();
                this.dispose();
                
                FrmColorClick frmColorClick = new FrmColorClick();
                frmColorClick.setVisible(true);
                frmColorClick.start();
        }
        if (failsQuant == 6)
        {
       
            lblResult.setText("You lost!!!");
            totalScore(score);
            setButtons(false);
            skip();
            this.dispose(); 
            FrmColorClick frmColorClick = new FrmColorClick();
            frmColorClick.setVisible(true);
            frmColorClick.start();
        }
        if (e.getSource().equals(buttonSkip))
        {  
            setButtons(false);
            totalScore(0);
            skip();
            this.dispose();
            FrmColorClick frmColorClick = new FrmColorClick();
            frmColorClick.setVisible(true);
            frmColorClick.start();
        }
    }

    /**
     * If skip button is pressed
     */
    private void skip() 
    {
        txtGuessUser.setText(null);
        counter = 0;
        createWord();
        failsQuant = 0;
        correctCounter = 0;
        score = 100;
        buttonSkip.setText("Skip");
        imageN.setVisible(true);
        imageN1.setVisible(false);
        imageN2.setVisible(false);
        imageN3.setVisible(false);
        imageN4.setVisible(false);
        imageN5.setVisible(false);
        imageN6.setVisible(false);
        lblResult.setText(""+score);
        setButtons(true);
        
    }
    
       public static int totalScore(int num)
    {
        storeNum += num;
        return storeNum;
    }
       
    private void setButtons(boolean flag) 
    {
        buttonA.setEnabled(flag); 
        buttonB.setEnabled(flag); 
        buttonC.setEnabled(flag); 
        buttonD.setEnabled(flag); 
        buttonE.setEnabled(flag); 
        buttonF.setEnabled(flag); 
        buttonG.setEnabled(flag); 
        buttonH.setEnabled(flag); 
        buttonI.setEnabled(flag); 
        buttonJ.setEnabled(flag); 
        buttonK.setEnabled(flag); 
        buttonL.setEnabled(flag); 
        buttonM.setEnabled(flag); 
        buttonN.setEnabled(flag); 
        buttonO.setEnabled(flag); 
        buttonP.setEnabled(flag); 
        buttonQ.setEnabled(flag); 
        buttonR.setEnabled(flag); 
        buttonS.setEnabled(flag); 
        buttonT.setEnabled(flag); 
        buttonU.setEnabled(flag); 
        buttonV.setEnabled(flag); 
        buttonW.setEnabled(flag); 
        buttonX.setEnabled(flag); 
        buttonY.setEnabled(flag); 
        buttonZ.setEnabled(flag); 
    }

}