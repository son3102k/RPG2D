package game;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
public class GameFrame extends JFrame {
    private GamePanel gamepanel;
    private  static int level;
	public GameFrame(){
        
        gamepanel = new GamePanel(720,480);
        gamepanel.setLevel(level);
        add(gamepanel);
        setTitle("RPG 2D Game Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(735, 515);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void setLevel(int level2){
        level = level2;
        
    }
    public static void main(String args[]) {
        new GameFrame();
    }

}
*/
public class GameFrame extends JFrame {
    private GamePanel gamepanel;
    private  static int level;
	public GameFrame(){
        gamepanel = new GamePanel(720,480,this);
        gamepanel.setLevel(level);
        add(gamepanel);
        setTitle("RPG 2D Game Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(735, 515);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public GamePanel getgamepanel(){
        return gamepanel;
    }
    public static void setLevel(int level2){
        level = level2;
        
    }
    public void refresh(JPanel view){
    	this.getContentPane().removeAll();
        this.getContentPane().add(view);
        this.repaint();
        this.revalidate();
        this.setVisible(true);
    }
    public static void main(String args[]) {
    	new GameFrame();
    }

}
