//file: Ball.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This is the code that makes up the ball shape, coordinates, boundaries, and resets the score! 
package pong;

import java.awt.geom.*;
public class Ball 
{

    private static final int WIDTH = 15;
    private static final int HEIGHT = 15;
    private double posX = 0;
    private static double posY = 0;
    private double dx = 1;
    private double dy = 1;
    private int score1 = 0, score2 = 0;
    public static boolean endGame = false;

    //it returns the ball (Ellipse2D implements Shape interface)
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(posX, posY, WIDTH, HEIGHT);
    }

    public void moveBall(Rectangle2D bounds, boolean collisionR1, boolean collisionR2)
    {
        posX += dx;
        posY += dy;

        if (collisionR1) 
        {
            dx = -dx;
            posX = 20;
        }
        if (collisionR2) 
        {
            dx = -dx;
            posX = 755;
        }

        if (posX < bounds.getMinX())
        {
            score2+=10; //Score player 2 increments by 10, player 1 loose

            posX = bounds.getCenterX();
            posY = bounds.getCenterY();
            dx = -dx;
            KeyboardEvent.activateMove=false;
        }

        if (posX + WIDTH >= bounds.getMaxX()) 
        {
            score1+=10; //score 1 increments by 1

            posX = bounds.getCenterX();
            posY = bounds.getCenterY();
            dx = -dx;
            KeyboardEvent.activateMove=false;
        }

        if (posY < bounds.getMinY()) 
        {
            posY = bounds.getMinY();
            dy = -dy;
        }

        if (posY + HEIGHT >= bounds.getMaxY())
        {
            posY = bounds.getMaxY() - HEIGHT;
            dy = -dy;
        }

    }

    public int getScore1()
    {
        return score1;
    }

    public int getScore2() 
    {
        return score2;
    }
    
    public void resetScore()
    {
        score1 = 0;
        score2 = 0;
    }

}
