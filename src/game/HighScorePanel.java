package game;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HighScorePanel extends JPanel {
	public static int a;
	public static int b;
	public  static int c;
	public static int d;
	public static int f;
	private GameFrame gameframe;
	public HighScorePanel(GameFrame gameframe) {
		this.gameframe = gameframe;
		setBackground(Color.WHITE);
		setLayout(null);
		this.readHighScore();
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameframe.refresh(new GameoverPanel(gameframe));
			}
		});
		btnNewButton.setBounds(68, 404, 85, 21);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("High Score\r\n");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.DARK_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(294, 28, 146, 38);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(""+a);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(344, 88, 49, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(""+b);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(344, 126, 49, 14);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(""+c);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(344, 168, 49, 14);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(""+d);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(344, 208, 49, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(""+f);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(344, 244, 49, 14);
		add(lblNewLabel_5);

	}
	public void readHighScore() {
		
		
		int arr[]= {0, 0, 0, 0, 0} ;
        
	       try {   
	    	   BufferedReader br = new BufferedReader(new FileReader("C:\\New Folder\\HighScore.txt"));       
	           String s;
	           
	           s= br.readLine();
	          for  (int i=0;i<5;i++) {
	        	   
	        	   try {
	        	      arr[i] = Integer.parseInt(s);
	        	   }
	        	   catch (NumberFormatException e)
	        	   {
	        	      arr[i] = 0;
	        	   }
	                
	                s= br.readLine();
	            }
	           
	       } catch (IOException e) {
	           e.printStackTrace();
	           
	       }
	       int temp = arr[0];
	       for (int i = 0 ; i < arr.length - 1; i++) {
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[i] > arr[j]) {
	                    temp = arr[j];
	                    arr[j] = arr[i];
	                    arr[i] = temp;
	                }
	            }
	       }
	       this.a = arr[4];
	       this.b = arr[3];
	       this.c = arr[2];
	       this.d = arr[1];
	       this.f = arr[0];
	   }
}
