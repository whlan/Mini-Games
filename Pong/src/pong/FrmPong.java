//file: FrmPong.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This is the code that refers to adding the ball, buttons, and title to the User Interface! 
package pong;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
public class FrmPong extends JFrame 
{
    public static PanelBoard canvas;
    PanelInfo panelInfo;
    Ball ball = new Ball();
    JButton startBtn = new javax.swing.JButton();
    JButton quitBtn = new javax.swing.JButton();

    public FrmPong()
    {
        setTitle("Pong");
        setSize(800, 1000);
        setResizable(false);
        setLayout(new GridLayout(2, 1));
        canvas = new PanelBoard();
        panelInfo = new PanelInfo();
        add(canvas);
        add(panelInfo);
        addKeyListener(new KeyboardEvent());
        new EngineGraphics(canvas).start();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

}
