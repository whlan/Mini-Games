package Sudoku;

import MainPackage.PointChanger;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.font.FontRenderContext;

@SuppressWarnings("serial")
public class SudokuPanel extends JPanel {

    private SudokuPuzzle puzzle;
    private int currentlySelectedCol;
    private int currentlySelectedRow;
    private int usedWidth;
    private int usedHeight;
    private int fontSize;

    private PointChanger pointChanger;

    public SudokuPanel(PointChanger pointChanger) {
        this.pointChanger = pointChanger;
        this.addMouseListener(new SudokuPanelMouseAdapter());
        this.puzzle = new SudokuGenerator().generateRandomSudoku(SudokuPuzzleType.NINEBYNINE);
        currentlySelectedCol = -1;
        currentlySelectedRow = -1;
        usedWidth = 0;
        usedHeight = 0;
        fontSize = 26;
    }



    public void newSudokuPuzzle(SudokuPuzzle puzzle) {
        this.puzzle = puzzle;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(1.0f,1.0f,1.0f));
//        g2d.setColor(new Color(0f,0f,0f));

        int slotWidth = this.getWidth()/puzzle.getNumColumns();
        int slotHeight = this.getHeight()/puzzle.getNumRows();

        usedWidth = (this.getWidth()/puzzle.getNumColumns())*puzzle.getNumColumns();
        usedHeight = (this.getHeight()/puzzle.getNumRows())*puzzle.getNumRows();

        g2d.fillRect(0, 0,usedWidth,usedHeight);

        g2d.setColor(new Color(0.0f,0.0f,0.0f));
//        g2d.setColor(Color.BLUE);
        for(int x = 0;x <= usedWidth;x+=slotWidth) {
            if((x/slotWidth) % puzzle.getBoxWidth() == 0) {
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(x, 0, x, usedHeight);
            }
            else {
                g2d.setStroke(new BasicStroke(1));
                g2d.drawLine(x, 0, x, usedHeight);
            }
        }
        //this will draw the right most line
        //g2d.drawLine(usedWidth - 1, 0, usedWidth - 1,usedHeight);
        for(int y = 0;y <= usedHeight;y+=slotHeight) {
            if((y/slotHeight) % puzzle.getBoxHeight() == 0) {
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(0, y, usedWidth, y);
            }
            else {
                g2d.setStroke(new BasicStroke(1));
                g2d.drawLine(0, y, usedWidth, y);
            }
        }
        //this will draw the bottom line
        //g2d.drawLine(0, usedHeight - 1, usedWidth, usedHeight - 1);

        Font f = new Font("Times New Roman", Font.PLAIN, fontSize);
        g2d.setFont(f);
        FontRenderContext fContext = g2d.getFontRenderContext();
        for(int row=0;row < puzzle.getNumRows();row++) {
            for(int col=0;col < puzzle.getNumColumns();col++) {
                if(!puzzle.isSlotAvailable(row, col)) {
                    int textWidth = (int) f.getStringBounds(puzzle.getValue(row, col), fContext).getWidth();
                    int textHeight = (int) f.getStringBounds(puzzle.getValue(row, col), fContext).getHeight();
                    g2d.drawString(puzzle.getValue(row, col), (col*slotWidth)+((slotWidth/2)-(textWidth/2)), (row*slotHeight)+((slotHeight/2)+(textHeight/2)));
                }
            }
        }
        if(currentlySelectedCol != -1 && currentlySelectedRow != -1) {
            g2d.setColor(new Color(0.0f,0.0f,1.0f,0.3f));
            g2d.fillRect(currentlySelectedCol * slotWidth,currentlySelectedRow * slotHeight,slotWidth,slotHeight);
        }
    }

    public void messageFromNumActionListener(String buttonValue) {
        if(currentlySelectedCol != -1 && currentlySelectedRow != -1) {
            boolean didOrDidnt= puzzle.makeMove(currentlySelectedRow, currentlySelectedCol, buttonValue, true);
            repaint();
            if(didOrDidnt == true){
                // ok
            } else {
                // point has changed
                pointChanger.changePoint(puzzle.getPoint());

            }
//            System.out.println(didOrDidnt);
        }
    }

    public class NumActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            messageFromNumActionListener(((JButton) e.getSource()).getText());
        }
    }

    private class SudokuPanelMouseAdapter extends MouseInputAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                int slotWidth = usedWidth/puzzle.getNumColumns();
                int slotHeight = usedHeight/puzzle.getNumRows();
                currentlySelectedRow = e.getY() / slotHeight;
                currentlySelectedCol = e.getX() / slotWidth;
                e.getComponent().repaint();
            }
        }
    }

    public boolean isGameFinished (){
        return puzzle.boardFull();
    }
}