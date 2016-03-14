package publicScreen;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;

public class PublicScreenGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PublicScreenGUI frame = new PublicScreenGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PublicScreenGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 1920);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel picWelcomeToNiagara = new JLabel("");
		picWelcomeToNiagara.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/Images/Welcome_to_niagara.png")));
		picWelcomeToNiagara.setBounds(22, 24, 467, 160);
		contentPane.add(picWelcomeToNiagara);
		
		JLabel picMalmoLogo = new JLabel("");
		picMalmoLogo.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/Images/Malmo_Hogskola_Logo.png")));
		picMalmoLogo.setBounds(905, 25, 155, 139);
		contentPane.add(picMalmoLogo);
		
		JPanel panelBlackBox = new JPanel();
		panelBlackBox.setBackground(Color.BLACK);
		panelBlackBox.setBounds(0, 184, 1920, 60);
		contentPane.add(panelBlackBox);
		panelBlackBox.setLayout(null);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime.setForeground(Color.WHITE);
		lblTime.setBounds(26, 15, 94, 31);
		panelBlackBox.add(lblTime);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setForeground(Color.WHITE);
		lblCourse.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse.setBounds(158, 15, 112, 31);
		panelBlackBox.add(lblCourse);
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom.setBounds(930, 15, 112, 31);
		panelBlackBox.add(lblRoom);
	}
}
