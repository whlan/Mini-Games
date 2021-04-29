package MainPackage;

//file: FrmCredits.java
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 9/21/19
//purpose: This shows the individuals behind this project, which includes the bronco ID # also!
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 
 * @author Ben Mai
 */
class FrmCredits extends JFrame implements ActionListener 
{

    private final JLabel lblTitle;
    private final JLabel lblCredit01,lblCredit02,lblCredit03 ;
    private final JButton buttonQuit;
   
    /**
     * To display credits
     */
    public FrmCredits() 
    {
        getContentPane().setLayout(null);
        this.setSize(600, 400);
        lblTitle = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 48)); 
        lblTitle.setText("Credits");
        lblTitle.setBounds(30, 30, 600, 60);
        
        lblCredit01 = new JLabel("Benjamin Mai");
        lblCredit01.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        lblCredit01.setBounds(150, 100, 600, 50);
        
        lblCredit02 = new JLabel("Wei-Hao Lan");
        lblCredit02.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        lblCredit02.setBounds(150, 150, 600, 50);
        
        lblCredit03 = new JLabel("Rigo Canales Maldonado");
        lblCredit03.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        lblCredit03.setBounds(150, 200, 600, 50);

        
        this.add(lblCredit01);
        this.add(lblCredit02);
        this.add(lblCredit03);
        this.add(lblTitle);
        
        buttonQuit = new JButton("Back");
        buttonQuit.setBounds(400, 280, 100, 20);
        buttonQuit.addActionListener(this);
        getContentPane().add(buttonQuit);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource().equals(buttonQuit))
        {
            this.setVisible(false);
            MainApp.menu.setVisible(true);
        }
    }
}