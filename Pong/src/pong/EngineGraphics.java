//file: EngineGraphics.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 10/20/19
//purpose: This is the code that refers to repainting the graphical interface!
package pong;
public class EngineGraphics extends Thread 
{
    private final PanelBoard canvas;
    EngineGraphics(PanelBoard canvas) 
    {
        this.canvas = canvas;
    }

    public void run() 
    {
        while (!Ball.endGame)
        {
            canvas.repaint();
            try { 
                Thread.sleep(6);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }
}
