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
	private int libWidth = 1080;
	
	private int topOffset = 242;
	private int bottomOffset = 135;
	
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
		
		JLabel timeLabel = new JLabel("Time");
		timeLabel.setFont(new Font("Futura", Font.PLAIN, 30));
		timeLabel.setForeground(Color.WHITE);
		timeLabel.setBounds(26, 13, 94, 31);
		panelBlackBox.add(timeLabel);
		
		JLabel courseLabel = new JLabel("Course");
		courseLabel.setForeground(Color.WHITE);
		courseLabel.setFont(new Font("Futura", Font.PLAIN, 30));
		courseLabel.setBounds(158, 13, 112, 31);
		panelBlackBox.add(courseLabel);
		
		JLabel roomLabel = new JLabel("Room");
		roomLabel.setForeground(Color.WHITE);
		roomLabel.setFont(new Font("Futura", Font.PLAIN, 30));
		roomLabel.setBounds(930, 13, 112, 31);
		panelBlackBox.add(roomLabel);
		
		
		
		JPanel blackBarLower = new JPanel();
		blackBarLower.setBackground(Color.BLACK);
		blackBarLower.setBounds(0, 1785, 1080, 135);
		contentPane.add(blackBarLower);
		blackBarLower.setLayout(null);
		
		JLabel lblKronoxLogo = new JLabel("");
		lblKronoxLogo.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/Images/KronoxLogoSmall.png")));
		lblKronoxLogo.setBounds(42, 17, 211, 100);
		blackBarLower.add(lblKronoxLogo);
		
		JLabel lblGroupAvailable = new JLabel("Group study rooms available");
		lblGroupAvailable.setFont(new Font("Futura", Font.PLAIN, 25));
		lblGroupAvailable.setForeground(Color.WHITE);
		lblGroupAvailable.setBounds(728, 6, 346, 33);
		blackBarLower.add(lblGroupAvailable);
		
		JLabel lblGroupNiagara = new JLabel("Niagara:");
		lblGroupNiagara.setForeground(Color.WHITE);
		lblGroupNiagara.setFont(new Font("Futura", Font.PLAIN, 25));
		lblGroupNiagara.setBounds(728, 51, 115, 33);
		blackBarLower.add(lblGroupNiagara);
		
		JLabel lblGroupOrkanen = new JLabel("Orkanen:");
		lblGroupOrkanen.setForeground(Color.WHITE);
		lblGroupOrkanen.setFont(new Font("Futura", Font.PLAIN, 25));
		lblGroupOrkanen.setBounds(728, 84, 115, 33);
		blackBarLower.add(lblGroupOrkanen);
		
		
		
		for(int i = 0; i < 35; i++) {
			LIBs.add(new LectureInformationBox("NI:A0305", "Programming 2", "10:15"));
		}
		
		libSpacing = 60/(LIBs.size()/3);
		
		LIBpanel = new JPanel();
		LIBpanel.setBounds(0, libSpacing, libWidth, 5000);
		LIBpanel.setBackground(Color.WHITE);
		contentPane.add(LIBpanel, BorderLayout.CENTER);
		LIBpanel.setLayout(null);
		
        for(int i = 0; i < 35; i++) {
        	JPanel LIB = new JPanel();
        	if ((i & 1) == 0) LIB.setBackground(Color.WHITE);
    		LIB.setBounds(0, topOffset + libHeight*(i)+ libSpacing*i, libWidth, libHeight);
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
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while(YScroll > -(((LIBs.size()*libHeight)+(LIBs.size()*libSpacing))-(1920-topOffset-bottomOffset))) {
				YScroll-=1;
				LIBpanel.setLocation(0, YScroll);
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new LIBscrolling().start();
		}
	}
	
	public void drawLIBs() {
		
	}
}
