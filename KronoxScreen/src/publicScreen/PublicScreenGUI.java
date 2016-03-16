package publicScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class PublicScreenGUI extends JFrame {

	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel LIBpanel;
	private JTextPane txtpnTest;
	
	private ArrayList<LectureInformationBox> LIBs = new ArrayList<LectureInformationBox>();
    
	private int libSpacing = 60;
	private int libHeight = 65;
	private int libWidth = 1053;
	
	private int topOffset = 242;
	
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
		setBounds(0, 0, 1080, 1920);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUndecorated(true);
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1080, 242);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		//mainPanel.setVisible(false);
		mainPanel.setLayout(null);
		
		JLabel picWelcomeToNiagara = new JLabel("");
		picWelcomeToNiagara.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/Images/Welcome_to_niagara.png")));
		picWelcomeToNiagara.setBounds(22, 24, 467, 160);
		mainPanel.add(picWelcomeToNiagara);
		
		JLabel picMalmoLogo = new JLabel("");
		picMalmoLogo.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/Images/Malmo_Hogskola_Logo.png")));
		picMalmoLogo.setBounds(905, 25, 155, 139);
		mainPanel.add(picMalmoLogo);
		
		JPanel panelBlackBox = new JPanel();
		panelBlackBox.setBackground(Color.BLACK);
		panelBlackBox.setBounds(0, 184, 1080, 60);
		mainPanel.add(panelBlackBox);
		panelBlackBox.setLayout(null);
		
		JPanel panelBlackBoxLower = new JPanel();
		panelBlackBoxLower.setBackground(Color.BLACK);
		panelBlackBoxLower.setBounds(0, 1726, 1080, 194);
		mainPanel.add(panelBlackBoxLower);
		panelBlackBoxLower.setLayout(null);
		
		
		
		LIBpanel = new JPanel();
		LIBpanel.setBounds(0, topOffset, libWidth, 2000);
		LIBpanel.setBackground(Color.WHITE);
		contentPane.add(LIBpanel, BorderLayout.CENTER);
		LIBpanel.setLayout(null);
		
		
		for(int i = 0; i < 10; i++) {
			LIBs.add(new LectureInformationBox("NI:A0305", "Programming 2", "10:15"));
		}
		
		libSpacing = 60/(LIBs.size()/3);
		// 
        for(int i = 0; i < 22; i++) {
        	JPanel LIB = new JPanel();
        	if ((i & 1) == 0) LIB.setBackground(Color.WHITE);
    		LIB.setBounds(0, topOffset + libHeight*(i+1)+ libSpacing*i, libWidth, libHeight);
    		LIB.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
    		LIBpanel.add(LIB);
    		LIB.setLayout(null);
    		
    		JLabel lblTime = new JLabel("13:25");
    		lblTime.setFont(new Font("Futura", Font.PLAIN, 30));
    		lblTime.setBounds(24, 0, 98, libHeight);
    		LIB.add(lblTime);
    		
    		JLabel lblCourse = new JLabel("Fastighetsvetenskap: Styrning av fastighetsföretag");
    		lblCourse.setFont(new Font("Futura", Font.PLAIN, 30));
    		lblCourse.setBounds(158, 0, 753, libHeight);
    		LIB.add(lblCourse);
    		
    		JLabel lblRoom = new JLabel("C0315");
    		lblRoom.setFont(new Font("Futura", Font.PLAIN, 30));
    		lblRoom.setBounds(930, 0, 124, libHeight);
    		LIB.add(lblRoom);
			}

		new LIBscrolling().start();
		
		
	}
	
	public class LIBscrolling extends Thread {
		
		@Override
		public void run() {
			
			int YScroll = 0;
			while(true) {
				YScroll-=1;
				LIBpanel.setLocation(5, YScroll);
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void drawLIBs() {
		
	}
}
