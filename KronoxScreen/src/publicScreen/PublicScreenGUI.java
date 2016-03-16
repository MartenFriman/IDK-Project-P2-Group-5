package publicScreen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
<<<<<<< HEAD
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
=======
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.SpringLayout;
>>>>>>> origin/master

public class PublicScreenGUI extends JFrame {

	private JPanel contentPane;
	private JPanel mainPanel;
	private JPanel LIBpanel;
	private JTextPane txtpnTest;
	
	private ArrayList<LectureInformationBox> LIBs = new ArrayList<LectureInformationBox>();
    
	private int libSpacing = 60;
	private int libHeight = 65;
	private int libWidth = 1048;
	
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
		setBounds(100, 100, 1080, 1920);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
<<<<<<< HEAD
		LIBpanel = new JPanel();
		contentPane.add(LIBpanel, BorderLayout.CENTER);
		LIBpanel.setBackground(Color.WHITE);
		LIBpanel.setLayout(null);
		
		for(int i = 0; i < 10; i++) {
			LIBs.add(new LectureInformationBox("NI:A0305", "Programming 2", "10:15"));
		}
		
		libSpacing = 60/(LIBs.size()/3);
		// 
        for(int i = 0; i < 10; i++) {
        
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
    		
    		JLabel lblCourse = new JLabel("Fastighetsvetenskap: Styrning av fastighetsf�retag");
    		lblCourse.setFont(new Font("Futura", Font.PLAIN, 30));
    		lblCourse.setBounds(158, 0, 753, libHeight);
    		LIB.add(lblCourse);
    		
    		JLabel lblRoom = new JLabel("C0315");
    		lblRoom.setFont(new Font("Futura", Font.PLAIN, 30));
    		lblRoom.setBounds(930, 0, 124, libHeight);
    		LIB.add(lblRoom);
			}

		new LIBscrolling().start();
		
		mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		JLabel picWelcomeToNiagara = new JLabel("");
		picWelcomeToNiagara.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/Images/Welcome_to_niagara.png")));
		picWelcomeToNiagara.setBounds(22, 24, 467, 160);
		mainPanel.add(picWelcomeToNiagara);
=======
		JLabel picWelcomeToNiagara = new JLabel("");
		picWelcomeToNiagara.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/Images/Welcome_to_niagara.png")));
		picWelcomeToNiagara.setBounds(22, 24, 467, 160);
		contentPane.add(picWelcomeToNiagara);
>>>>>>> origin/master
		
		JLabel picMalmoLogo = new JLabel("");
		picMalmoLogo.setIcon(new ImageIcon(PublicScreenGUI.class.getResource("/Images/Malmo_Hogskola_Logo.png")));
		picMalmoLogo.setBounds(905, 25, 155, 139);
<<<<<<< HEAD
		mainPanel.add(picMalmoLogo);
=======
		contentPane.add(picMalmoLogo);
>>>>>>> origin/master
		
		JPanel panelBlackBox = new JPanel();
		panelBlackBox.setBackground(Color.BLACK);
		panelBlackBox.setBounds(0, 184, 1080, 60);
<<<<<<< HEAD
		mainPanel.add(panelBlackBox);
=======
		contentPane.add(panelBlackBox);
>>>>>>> origin/master
		panelBlackBox.setLayout(null);
		
		JPanel panelBlackBoxLower = new JPanel();
		panelBlackBoxLower.setBackground(Color.BLACK);
		panelBlackBoxLower.setBounds(0, 1726, 1080, 194);
<<<<<<< HEAD
		mainPanel.add(panelBlackBoxLower);
		panelBlackBoxLower.setLayout(null);
	}
	
	public class LIBscrolling extends Thread {
		
		@Override
		public void run() {
			int YScroll = 0;
			while(true) {
				YScroll-=1;
				LIBpanel.setLocation(5, YScroll);
				LIBpanel.repaint();
				System.out.println("SCROLLED");
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
		
		
=======
		contentPane.add(panelBlackBoxLower);
		panelBlackBoxLower.setLayout(null);
		
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
		
		/**LIB 1*/
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 242, 1080, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTime1 = new JLabel("13:25");
		lblTime1.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime1.setBounds(24, 0, 98, 65);
		panel_1.add(lblTime1);
		
		JLabel lblCourse1 = new JLabel("Fastighetsvetenskap: Styrning av fastighetsföretag");
		lblCourse1.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse1.setBounds(158, 0, 753, 65);
		panel_1.add(lblCourse1);
		
		JLabel lblRoom1 = new JLabel("C0315");
		lblRoom1.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom1.setBounds(930, 0, 124, 65);
		panel_1.add(lblRoom1);
		
		/**LIB 2*/
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 306, 1080, 65);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTime2 = new JLabel("13:25");
		lblTime2.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime2.setBounds(24, 0, 98, 65);
		panel_2.add(lblTime2);
		
		JLabel lblCourse2 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse2.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse2.setBounds(157, 0, 753, 65);
		panel_2.add(lblCourse2);
		
		JLabel lblRoom2 = new JLabel("C0315");
		lblRoom2.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom2.setBounds(930, 0, 124, 65);
		panel_2.add(lblRoom2);
		
		/**LIB 3*/
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 370, 1080, 65);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblTime3 = new JLabel("13:25");
		lblTime3.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime3.setBounds(24, 0, 85, 65);
		panel_3.add(lblTime3);
		
		JLabel lblCourse3 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse3.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse3.setBounds(157, 0, 649, 65);
		panel_3.add(lblCourse3);
		
		JLabel lblRoom3 = new JLabel("C0315");
		lblRoom3.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom3.setBounds(930, 0, 97, 65);
		panel_3.add(lblRoom3);
		
		/**LIB 4*/
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 434, 1080, 65);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblTime4 = new JLabel("13:25");
		lblTime4.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime4.setBounds(24, 0, 98, 65);
		panel_4.add(lblTime4);
		
		JLabel lblCourse4 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse4.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse4.setBounds(157, 0, 753, 65);
		panel_4.add(lblCourse4);
		
		JLabel lblRoom4 = new JLabel("C0315");
		lblRoom4.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom4.setBounds(930, 0, 124, 65);
		panel_4.add(lblRoom4);
		
		/**LIB 5*/
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(0, 499, 1080, 65);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblTime5 = new JLabel("13:25");
		lblTime5.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime5.setBounds(24, 0, 98, 65);
		panel_5.add(lblTime5);
		
		JLabel lblCourse5 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse5.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse5.setBounds(157, 0, 753, 65);
		panel_5.add(lblCourse5);
		
		JLabel lblRoom5 = new JLabel("C0315");
		lblRoom5.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom5.setBounds(930, 0, 124, 65);
		panel_5.add(lblRoom5);
		
		/**LIB 6*/
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 563, 1080, 65);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblTime6 = new JLabel("13:25");
		lblTime6.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime6.setBounds(24, 0, 98, 65);
		panel_6.add(lblTime6);
		
		JLabel lblCourse6 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse6.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse6.setBounds(157, 0, 753, 65);
		panel_6.add(lblCourse6);
		
		JLabel lblRoom6 = new JLabel("C0315");
		lblRoom6.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom6.setBounds(930, 0, 124, 65);
		panel_6.add(lblRoom6);
		
		/**LIB 7*/
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(0, 627, 1080, 65);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblTime7 = new JLabel("13:25");
		lblTime7.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime7.setBounds(24, 0, 98, 65);
		panel_7.add(lblTime7);
		
		JLabel lblCourse7 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse7.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse7.setBounds(157, 0, 753, 65);
		panel_7.add(lblCourse7);
		
		JLabel lblRoom7 = new JLabel("C0315");
		lblRoom7.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom7.setBounds(930, 0, 124, 65);
		panel_7.add(lblRoom7);
		
		/**LIB 8*/
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 691, 1080, 65);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblTime8 = new JLabel("13:25");
		lblTime8.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime8.setBounds(24, 0, 98, 65);
		panel_8.add(lblTime8);
		
		JLabel lblCourse8 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse8.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse8.setBounds(157, 0, 753, 65);
		panel_8.add(lblCourse8);
		
		JLabel lblRoom8 = new JLabel("C0315");
		lblRoom8.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom8.setBounds(930, 0, 124, 65);
		panel_8.add(lblRoom8);
		
		/**LIB 9*/
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(0, 753, 1080, 65);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		JLabel lblTime9 = new JLabel("13:25");
		lblTime9.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime9.setBounds(24, 0, 98, 65);
		panel_9.add(lblTime9);
		
		JLabel lblCourse9 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse9.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse9.setBounds(157, 0, 753, 65);
		panel_9.add(lblCourse9);
		
		JLabel lblRoom9 = new JLabel("TEST");
		lblRoom9.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom9.setBounds(930, 0, 124, 65);
		panel_9.add(lblRoom9);
		
		/**LIB 10*/
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(0, 816, 1080, 65);
		contentPane.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblTime10 = new JLabel("13:25");
		lblTime10.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime10.setBounds(24, 0, 98, 65);
		panel_10.add(lblTime10);
		
		JLabel lblCourse10 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse10.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse10.setBounds(157, 0, 753, 65);
		panel_10.add(lblCourse10);
		
		JLabel lblRoom10 = new JLabel("TEST");
		lblRoom10.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom10.setBounds(930, 0, 124, 65);
		panel_10.add(lblRoom10);
		
		/**LIB 11*/
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(0, 881, 1080, 65);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		JLabel lblTime11 = new JLabel("13:25");
		lblTime11.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime11.setBounds(24, 0, 98, 65);
		panel_11.add(lblTime11);
		
		JLabel lblCourse11 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse11.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse11.setBounds(157, 0, 753, 65);
		panel_11.add(lblCourse11);
		
		JLabel lblRoom11 = new JLabel("TEST");
		lblRoom11.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom11.setBounds(930, 0, 124, 65);
		panel_11.add(lblRoom11);
		
		/**LIB 12*/
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(0, 946, 1080, 65);
		contentPane.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblTime12 = new JLabel("13:25");
		lblTime12.setFont(new Font("Futura", Font.PLAIN, 30));
		lblTime12.setBounds(24, 0, 98, 65);
		panel_12.add(lblTime12);
		
		JLabel lblCourse12 = new JLabel("Fritidspedagogik: Lek och lärande i olika miljöer");
		lblCourse12.setFont(new Font("Futura", Font.PLAIN, 30));
		lblCourse12.setBounds(157, 0, 753, 65);
		panel_12.add(lblCourse12);
		
		JLabel lblRoom12 = new JLabel("TEST");
		lblRoom12.setFont(new Font("Futura", Font.PLAIN, 30));
		lblRoom12.setBounds(930, 0, 124, 65);
		panel_12.add(lblRoom12);
		
		/**LIB 13*/
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(0, 1011, 1080, 65);
		contentPane.add(panel_13);
		panel_13.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(0, 1076, 1080, 65);
		contentPane.add(panel_14);
		panel_14.setLayout(null);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel_15.setBounds(0, 1141, 1080, 65);
		contentPane.add(panel_15);
		panel_15.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(0, 1206, 1080, 65);
		contentPane.add(panel_16);
		panel_16.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.WHITE);
		panel_17.setBounds(0, 1271, 1080, 65);
		contentPane.add(panel_17);
		panel_17.setLayout(null);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(0, 1336, 1080, 65);
		contentPane.add(panel_18);
		panel_18.setLayout(null);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		panel_19.setBounds(0, 1401, 1080, 65);
		contentPane.add(panel_19);
		panel_19.setLayout(null);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(0, 1466, 1080, 65);
		contentPane.add(panel_20);
		panel_20.setLayout(null);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		panel_21.setBounds(0, 1531, 1080, 65);
		contentPane.add(panel_21);
		panel_21.setLayout(null);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBounds(0, 1596, 1080, 65);
		contentPane.add(panel_22);
		panel_22.setLayout(null);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.WHITE);
		panel_23.setBounds(0, 1661, 1080, 65);
		contentPane.add(panel_23);
		panel_23.setLayout(null);
>>>>>>> origin/master
	}
}
