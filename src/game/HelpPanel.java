package game;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HelpPanel extends JPanel {
	private MainFrame mainFrame;

	/**
	 * Create the panel.
	 */
	public HelpPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.refresh(new MenuPanel(mainFrame));
			}
		});
		btnNewButton.setBounds(68, 404, 85, 21);
		add(btnNewButton);

	}
}
