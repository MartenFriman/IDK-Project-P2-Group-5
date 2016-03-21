package publicScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
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
	private JPanel fadePanel;
	private JLabel lblClocklabel;
	private JLabel lblDatelabel;
	
	public ArrayList<LectureInformationBox> LIBs = new ArrayList<LectureInformationBox>();
    
	private kronoxParser parser = new kronoxParser();
	
	private Clock clock;
	
	private int libSpacing = 60;
	private int libHeight = 65;
	private int libWidth = 1080;
	
	private int topOffset = 242;
	private int bottomOffset = 135;
	
	private int YScroll;
	
	private boolean hasBeenSynced = true;
	
	private Font Neou_Bold;
		
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
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		//initFonts();
		
		mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 1080, 242);
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		fadePanel = new JPanel();
		fadePanel.setBounds(0, topOffset, libWidth, 1920-bottomOffset-topOffset);
		fadePanel.setBackground(new Color(255, 255, 255, 0));
		contentPane.add(fadePanel, BorderLayout.CENTER);
		fadePanel.setLayout(null);
		
		drawTopBar();
		drawBottomBar();
		
		clock = new Clock(this);
		
		//Sleep to allow clock to initiate
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		LIBs = parser.parseFromKronox(clock.getHours(), clock.getMinutes());
		if (LIBs.size() > 2) libSpacing = 60/(LIBs.size()/3);
		
		LIBpanel = new JPanel();
		LIBpanel.setBounds(0, libSpacing, libWidth, 7000);
		LIBpanel.setBackground(Color.WHITE);
		contentPane.add(LIBpanel, BorderLayout.CENTER);
		LIBpanel.setLayout(null);
		
		drawSchedule();
        
		new LIBscrolling().start();
	}
	
	//Main program loop
	//
	public class LIBscrolling extends Thread {
		
		@Override
		public void run() {
			resyncSchedule();
			YScroll = libSpacing;
			LIBpanel.setLocation(0, YScroll);
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
					Thread.sleep(16);
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
	
	public void drawTopBar() {
		JLabel picWelcomeToNiagara = new JLabel("");
		picWelcomeToNiagara.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/assets/Welcome_to_niagara.png")));
		picWelcomeToNiagara.setBounds(22, 24, 467, 160);
		mainPanel.add(picWelcomeToNiagara);
		
		JLabel picMalmoLogo = new JLabel("");
		picMalmoLogo.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/assets/Malmo_Hogskola_Logo.png")));
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
		
		lblClocklabel = new JLabel("00:00");
		lblClocklabel.setBounds(650, 44, 228, 80);
		lblClocklabel.setFont(new Font("Futura", Font.PLAIN, 79));
		mainPanel.add(lblClocklabel);
		
		lblDatelabel = new JLabel("day, month, year");
		lblDatelabel.setBounds(650, 92, 230, 80);
		lblDatelabel.setFont(new Font("Futura", Font.PLAIN, 30));
		mainPanel.add(lblDatelabel);
	}
	
	public void drawBottomBar() {
		JPanel blackBarLower = new JPanel();
		blackBarLower.setBackground(Color.BLACK);
		blackBarLower.setBounds(0, 1785, 1080, 135);
		contentPane.add(blackBarLower);
		blackBarLower.setLayout(null);
		
		JLabel lblKronoxLogo = new JLabel("");
		lblKronoxLogo.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/assets/KronoxLogoSmall.png")));
		lblKronoxLogo.setBounds(42, 17, 211, 100);
		blackBarLower.add(lblKronoxLogo);
		
		JLabel lblGroupAvailable = new JLabel("Group study rooms available");
		lblGroupAvailable.setFont(new Font("Futura", Font.PLAIN, 25));
		lblGroupAvailable.setForeground(Color.WHITE);
		lblGroupAvailable.setBounds(708, 6, 366, 33);
		blackBarLower.add(lblGroupAvailable);
		
		JLabel lblGroupNiagara = new JLabel("Niagara:");
		lblGroupNiagara.setForeground(Color.WHITE);
		lblGroupNiagara.setFont(new Font("Futura", Font.PLAIN, 25));
		lblGroupNiagara.setBounds(708, 51, 115, 33);
		blackBarLower.add(lblGroupNiagara);
		
		JLabel lblGroupOrkanen = new JLabel("Orkanen:");
		lblGroupOrkanen.setForeground(Color.WHITE);
		lblGroupOrkanen.setFont(new Font("Futura", Font.PLAIN, 25));
		lblGroupOrkanen.setBounds(708, 84, 115, 33);
		blackBarLower.add(lblGroupOrkanen);
	}
	
	public void setTimeOnLabel(String currentTime, String currentDate) {
		lblClocklabel.setText(currentTime);
		lblDatelabel.setText(currentDate);
	}
	
	public void resyncSchedule() {
		if (clock.getMinutes() == 16 && hasBeenSynced == false) {
			System.out.println("I AM SYNCING");
		LIBs = parser.parseFromKronox(clock.getHours(), clock.getMinutes());
		if (LIBs.size() > 2) libSpacing = 60/(LIBs.size()/3);
		LIBpanel.removeAll();
		drawSchedule();
		hasBeenSynced = true;
		} else {
			System.out.println("I HAVE BEEN RESET");
			hasBeenSynced = false;
		}
	}
	
	public void drawSchedule() {
		for(int i = 0; i < LIBs.size(); i++) {
        	JPanel LIB = new JPanel();
        	if ((i & 1) == 0) LIB.setBackground(Color.WHITE);
    		LIB.setBounds(0, topOffset + libHeight*(i)+ libSpacing*i, libWidth, libHeight);
    		LIB.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
    		LIBpanel.add(LIB);
    		LIB.setLayout(null);
    		
    		JLabel lblTime = new JLabel(LIBs.get(i).getTime());
    		lblTime.setFont(new Font("Futura", Font.PLAIN, 30));
    		lblTime.setBounds(24, 0, 105, libHeight);
    		LIB.add(lblTime);
    		
    		JLabel lblCourse = new JLabel(LIBs.get(i).getCourse());
    		lblCourse.setFont(new Font("Futura", Font.PLAIN, 30));
    		lblCourse.setBounds(158, 0, 715, libHeight);
    		LIB.add(lblCourse);
    		
    		JLabel lblRoom = new JLabel(LIBs.get(i).getRoom());
    		lblRoom.setFont(new Font("Futura", Font.BOLD, 30));
    		lblRoom.setBounds(905, 0, 170, libHeight);
    		LIB.add(lblRoom);
			}
	}
	/*
	public void initFonts() {
		try {
			Neou_Bold = Font.createFont(Font.TRUETYPE_FONT, new File("/assets/Neou-Bold.ttf")).deriveFont(79f);
		     GraphicsEnvironment ge = 
		         GraphicsEnvironment.getLocalGraphicsEnvironment();
		     ge.registerFont(Neou_Bold.createFont(Font.TRUETYPE_FONT, new File("/assets/Neou-Bold.ttf")));
		} catch (IOException|FontFormatException e) {
		     
		}
	}
	*/
}

/*
 * public void fadeIn(int fadeTime) { int fadeTimer = fadeTime/255; for(int fade
 * = 0; fade >= 255; fade++) { fadePanel.setBackground(new Color(255, 255, 255,
 * fade)); fadePanel.repaint(); try { Thread.sleep(20); } catch
 * (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } } }
 * 
 * public void fadeOut(int fadeTime) { int fadeTimer = fadeTime/255; for(int
 * fade = 255; fade >= 0; fade--) { fadePanel.setBackground(new Color(255, 255,
 * 255, fade)); fadePanel.repaint(); try { Thread.sleep(20); } catch
 * (InterruptedException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } } }
 */
