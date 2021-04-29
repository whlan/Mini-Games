package MainPackage;

//file: FrmSplashjava
//author: Benjamin Mai, Rigo Maldonado, Wei-Hao Lan
//class: CS 2450.01 – Programming Graphical User Interfaces
//assignment: Swing Project V1.3
//date last modified: 9/21/19
//purpose: This shows the launch screen where the Game Title, Team Name, and game logo are showcased!
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 * 
 * @author Ben Mai
 */
class FrmSplash extends JFrame {
    private JLabel lblBy, lblTitle, lblSubTitle, imgLogo;
    /**
     * To display the first window
     */
    public FrmSplash() {
        getContentPane().setLayout(null);
        this.setSize(600, 400);
        lblBy    = new JLabel();
        lblTitle = new JLabel();
        lblSubTitle = new JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Icon imgLogoIcon = new ImageIcon("./javalava.jpg");
        imgLogo = new JLabel(imgLogoIcon);
        imgLogo.setBounds(270, 0, 330, 340);
        this.add(imgLogo);
        
        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        lblTitle.setText("CS2450");
        lblTitle.setBounds(30, 30, 600, 40);
        
        lblSubTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); 
        lblSubTitle.setText("HangManX");
        lblSubTitle.setBounds(30, 60, 600, 40);
        
        lblBy.setFont(new java.awt.Font("Tahoma", 0, 24)); 
        lblBy.setText("By: JavaLava");
        lblBy.setBounds(30, 290, 600, 30);
        
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.add(lblBy);
        this.add(lblTitle);
        this.add(lblSubTitle);
    }
}