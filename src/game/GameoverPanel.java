package game;
import game.inputKey.inputManager;
import game.object.GameWorld;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameoverPanel extends JPanel {
	private GameFrame gameframe;

	public GameoverPanel(GameFrame gameframe) {
		this.gameframe = gameframe;
		setLayout(null);
		
            
            try {

                String content = Integer.toString(gameframe.getgamepanel().getgameworld().getscore().getscore());

                File file = new File("C:\\New Folder\\HighScore.txt");

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(content);
                FileWriter sw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter lw = new BufferedWriter(sw);
                lw.write("\n");
                lw.close();
                bw.close();

                

            } catch (IOException e) {
                e.printStackTrace();
            }
		JButton btnNewButton2 = new JButton("High Score");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameframe.refresh(new HighScorePanel(gameframe));
			}
		});
		btnNewButton2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton2.setForeground(new Color(0, 0, 0));
		btnNewButton2.setBackground(new Color(211, 211, 211));
		btnNewButton2.setBounds(308, 12, 126, 44);
		add(btnNewButton2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 51, 51));
		lblNewLabel.setBackground(new Color(153, 0, 51));
		lblNewLabel.setFont(new Font("Vineta BT", Font.PLAIN, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(200, 312, 344, 54);
		add(lblNewLabel);

		JLabel lblscore = new JLabel("Score:  " + gameframe.getgamepanel().getgameworld().getscore().getscore());
		lblscore.setForeground(new Color(255, 255, 255));
		lblscore.setBackground(new Color(0, 0, 0));
		lblscore.setFont(new Font("Vineta BT", Font.PLAIN, 39));
		lblscore.setHorizontalAlignment(SwingConstants.CENTER);
		lblscore.setBounds(243, 50, 225, 97);
		add(lblscore);
		
		
		
		JButton btnNewButton = new JButton(new ImageIcon("Data/GuiImage/home.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.main(null);
				gameframe.setVisible(false);
				gameframe.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 228, 196));
		btnNewButton.setBounds(332, 376, 76, 74);
		add(btnNewButton);
	
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 720, 480);
		lblNewLabel_1.setIcon(resizeImage(lblNewLabel_1, "Data/GuiImage/gameover.jpg"));
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

     




