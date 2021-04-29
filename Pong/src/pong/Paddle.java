//file: Paddle.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This class represents the creation, movement, and positioning of the paddle!
package pong;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Paddle 
{
    private int posX, posY;
    static final int WIDTH = 10, HEIGHT = 100;

    public Paddle(int x, int y) 
    {
        this.posX = x;
        this.posY = y;
    }

    public Rectangle2D getPaddle() 
    {
        return new Rectangle2D.Double(posX, posY, WIDTH, HEIGHT);
    }

    public void movePaddle1(Rectangle limites) 
    {
        if (KeyboardEvent.keyW && posY > limites.getMinY()) 
        {
            posY--;
        }
        if (KeyboardEvent.keyS && posY < limites.getMaxY()-HEIGHT) 
        {
            posY++;
        }
    }

    public void movePaddle2(Rectangle limites) 
    {
        if (KeyboardEvent.keyUp && posY > limites.getMinY()) 
        {
            posY--;
        }
        if (KeyboardEvent.keyDown && posY < limites.getMaxY()-HEIGHT) 
        {
            posY++;
        }
    }
}
