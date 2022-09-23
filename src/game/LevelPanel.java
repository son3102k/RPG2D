package game;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import game.MenuPanel;

public class LevelPanel extends JPanel {
	private MainFrame mainFrame;
	private MenuPanel menuPanel;
	public static int level;

	/**
	 * Create the panel.
	 */
	public LevelPanel(MainFrame mainFrame) {
		menuPanel = new MenuPanel(mainFrame);
		this.mainFrame=mainFrame;
		setBackground(new Color(211, 211, 211));
		setLayout(null);
		
		JButton btnNewButton_3 = new JButton(new ImageIcon("Data/GuiImage/Button-Next-icon.png"));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameFrame.setLevel(level);
				GameFrame.main(null);
				mainFrame.setVisible(false);
			}
		});
		btnNewButton_3.setForeground(new Color(220, 220, 220));
		btnNewButton_3.setBackground(new Color(154, 205, 50));
		btnNewButton_3.setBounds(546, 383, 54, 56);
		add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level=1;
			}
		});
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(304, 179, 102, 40);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Normal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level=2;
			}
		});
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(304, 239, 102, 40);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Hard");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				level=3;
			}
		});
		btnNewButton_2.setBackground(new Color(192, 192, 192));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(304, 299, 102, 47);
		add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("LEVEL");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(263, 95, 180, 87);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(188, 62, 322, 377);
		lblNewLabel.setIcon(menuPanel.resizeImage(lblNewLabel, "Data/GuiImage/levelframe.png"));
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 720, 480);
		lblNewLabel_1.setIcon(menuPanel.resizeImage(lblNewLabel_1, "Data/Background/background.jpg"));
		add(lblNewLabel_1);

	}
}
