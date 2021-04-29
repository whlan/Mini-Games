//file: KeyBoardEvent.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This class represents the key pressing in which it detects whether it is pressed or not!
package pong;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardEvent extends KeyAdapter 
{
    static boolean keyW, keyS, keyUp, keyDown, activateMove=false;
    @Override
    public void keyPressed(KeyEvent e)
    {
        int id = e.getKeyCode();
        if (id == KeyEvent.VK_W) 
        {
            keyW = true;
        }
        if (id == KeyEvent.VK_S)
        {
            keyS = true;
        }
        if (id == KeyEvent.VK_UP)
        {
            keyUp = true;
        }
        if (id == KeyEvent.VK_DOWN)
        {
            keyDown = true;
        }
    }


    public void keyReleased(KeyEvent e)
    {
        int id = e.getKeyCode();
        if (id == KeyEvent.VK_W) 
        {
            keyW = false;
        }
        if (id == KeyEvent.VK_S)
        {
            keyS = false;
        }
        if (id == KeyEvent.VK_UP) 
        {
            keyUp = false;
        }
        if (id == KeyEvent.VK_DOWN)
        {
            keyDown = false;
        }
        if (id == KeyEvent.VK_SPACE)
        {
            activateMove = true;
        }
    }
}
