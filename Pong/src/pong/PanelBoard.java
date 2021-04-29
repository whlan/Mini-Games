//file: PanelBoard.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This class represents the background of the game, graphics of the paddle, detects collision of the ball and paddle,
//displays the date and time, player score, and game results!
package pong;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JPanel;

public class PanelBoard extends JPanel 
{
    Paddle paddle01 = new Paddle(10, 200);
    Paddle paddle02 = new Paddle(784 - Paddle.WIDTH, 200);
    Ball ball = new Ball();
    public PanelBoard() 
    {
        this.setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.WHITE);
        displayScoreAndTime(g2);
        draw(g2);        
    }

    private void draw(Graphics2D g) 
    {

        g.fill(paddle01.getPaddle());
        update();

        g.fill(paddle02.getPaddle());
        update();

        g.fill(ball.getShape());
        update();
    }

    private void update() 
    {
        if (KeyboardEvent.activateMove==true) 
        {
            ball.moveBall(getBounds(), colision(paddle01.getPaddle()), colision(paddle02.getPaddle()));
        }
        paddle01.movePaddle1(getBounds());
        paddle02.movePaddle2(getBounds());
    }

    //it checks if there is a collision between paddle and ball
    private boolean colision(Rectangle2D r)
    {
        return ball.getShape().intersects(r);
    }

    private void displayScoreAndTime(Graphics2D g) 
    {
        Graphics2D g1 = g, g2 = g;
        String message ="";
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        now = LocalDateTime.now();
        
        PanelInfo.lblTime.setText("           "+dtf.format(now)+"           ");
        
        g1.drawString("P1:" + Integer.toString(ball.getScore1()), (float) getBounds().getMinX() + 20, 30);
        g2.drawString("P2:" + Integer.toString(ball.getScore2()), (float) getBounds().getCenterX() + 110, 30);
        PanelInfo.lblScores.setText("Player 1 Score:" + Integer.toString(ball.getScore1()) + "                    Player 2 Score:" + Integer.toString(ball.getScore2()));
        
        if (ball.getScore1() == 100) 
        {
            message = "  Game over, Player 1 Wins  "; 
            Ball.endGame = true;
        }
        if (ball.getScore2() == 100) 
        {
            message = "  Game over, Player 2 Wins  ";
            Ball.endGame = true;
        }
        if (KeyboardEvent.activateMove == false && Ball.endGame==false)
        {
            if (ball.getScore1()==0 && ball.getScore2()==0)
            {
                message = "    Press space to start     ";
            }
            else 
            {
                message = "   Press space to continue   ";
            }            
        }  
        g.drawString(message, (float) getBounds().getCenterX() - 220, (float) getBounds().getCenterY() - 100);
        PanelInfo.lblMessage.setText(message);
    }
}
