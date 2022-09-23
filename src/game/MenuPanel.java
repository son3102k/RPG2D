
package game;


import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public MenuPanel(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
		setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(44, 204, 244, 229);
		lblNewLabel_3.setIcon(resizeImage(lblNewLabel_3, "Data/EnemyImage/enemy.png"));
		add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("RPG Simple");
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Eras Demi ITC", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(208, 97, 323, 147);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.refresh(new LevelPanel(mainFrame));
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.setBounds(308, 262, 126, 44);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.refresh(new HelpPanel(mainFrame));
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(308, 332, 126, 44);
		add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(232, 221, 282, 185);
		lblNewLabel_2.setIcon(resizeImage(lblNewLabel_2, "Data/GuiImage/frame2.png"));
		add(lblNewLabel_2);


		JButton linktothe = new JButton("");
		linktothe.setBounds(610,380,90,24);
		linktothe.setIcon(resizeImage(linktothe, "Data/GuiImage/Facebook_Button.jpg"));
		linktothe.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				try {
					String myurl = "https://www.facebook.com/nguyen.haiduong.3538/";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(myurl));

				} catch (Exception e2){
					e2.printStackTrace();
				}
			}
		});
		
		add(linktothe);

		JButton linktothestack = new JButton("");
		linktothestack.setBounds(660,320,40,40);
		linktothestack.setIcon(resizeImage(linktothestack, "Data/GuiImage/Stackover.png"));
		linktothestack.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent e){
				try {
					String myurl = "https://stackoverflow.com/questions/tagged/java";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(myurl));

				} catch (Exception e2){
					e2.printStackTrace();
				}
			}
		});
		
		add(linktothestack);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 720, 480);
		lblNewLabel_1.setIcon(resizeImage(lblNewLabel_1, "Data/Background/background1.png"));
		add(lblNewLabel_1);

	}
	public ImageIcon resizeImage(JComponent comp, String image) {
		BufferedImage img=null;
		try {
			img=ImageIO.read(new File(image));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image dimg=img.getScaledInstance(comp.getWidth(), comp.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imgIcon= new ImageIcon(dimg);
		return imgIcon;
	}
}

