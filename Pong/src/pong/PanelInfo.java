//file: PanelInfo.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This class represents the infromation displayed on the panel such as the start button, quit button, and labels!
package pong;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static pong.FrmPong.canvas;

public class PanelInfo extends JPanel
{
    JButton startBtn = new javax.swing.JButton();
    JButton quitBtn = new javax.swing.JButton();
    static JLabel lblScores = new javax.swing.JLabel();
    static JLabel lblName = new javax.swing.JLabel();
    static JLabel lblTime = new javax.swing.JLabel();
    static JLabel lblMessage = new javax.swing.JLabel();
    public PanelInfo() 
    {
        startBtn.setText("Start");
        quitBtn.setText("Quit");
        startBtn.setFocusable(false);
        quitBtn.setFocusable(false);
        quitBtn.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                MainPackage.MainApp.frmPingPong.setVisible(false);
                MainPackage.MainApp.menu.setVisible(true);
            } 
        });
        
        startBtn.addActionListener(new ActionListener() 
        { 
            public void actionPerformed(ActionEvent e) 
            { 
                KeyboardEvent.activateMove = true;
                if( Ball.endGame == true ) 
                {
                    restart();
                }
            }
        });

        lblName = new JLabel("PONG");
        lblName.setFont(new java.awt.Font("Tahoma", 0, 100));
        this.add(lblName);
        
        lblTime = new JLabel("Date time");
        lblTime.setFont(new java.awt.Font("Tahoma", 0, 36));
        this.add(lblTime);
        
        lblScores = new JLabel("Player 1: 0        Player 2: 0");
        lblScores.setFont(new java.awt.Font("Tahoma", 0, 36));
        this.add(lblScores);
        
        lblMessage = new JLabel();
        lblMessage.setFont(new java.awt.Font("Tahoma", 0, 72));
        this.add(lblMessage);
        
        this.add(startBtn);
        this.add(quitBtn);
    }
    public static void restart()
    {
        FrmPong.canvas.ball.resetScore();
        Ball.endGame = false;
        new EngineGraphics(canvas).start();
    }
    
}
