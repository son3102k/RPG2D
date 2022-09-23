package game;

import java.awt.CardLayout;
import java.awt.Menu;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
    public MainFrame(){
    	add(new MenuPanel(this));
        setTitle("RPG 2D Game Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(720, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String args[]) {
    	new MainFrame();
    }
    public void refresh(JPanel view){
    	this.getContentPane().removeAll();
        this.getContentPane().add(view);
        this.repaint();
        this.revalidate();
        this.setVisible(true);
    }
}