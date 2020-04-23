package rivercrossing;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;


public class levelPage extends JFrame {

	private JFrame frame;
	private JLabel label;
	private Image img;
	private JLabel level1;
	private JLabel level2;
	private JLabel frame1;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JButton btn1;
	private JButton button;
	private JLabel lblRiver;
	private JButton btnExitGame;
	private  boolean neworload;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					levelPage window = new levelPage();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public levelPage(boolean neworload) {
            this.neworload=neworload;	
            initialize();
       
       
    }
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(450, 100, 1200, 735);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
                	 frame.setVisible(true);
		
		level1 = new JLabel("");
		level1.setBounds(128, 312, 148, 186);
		
		
		lblRiver = new JLabel("RIVER CROSSING PUZZLE");
		lblRiver.setForeground(new Color(51, 0, 51));
		lblRiver.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 44));
		lblRiver.setBounds(262, -39, 750, 218);
		frame.getContentPane().add(lblRiver);
		
		btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new menu().setVisible(true);
                            frame.setVisible(false);
			}
		});
		
		JLabel lblLevel = new JLabel("LEVEL 1");
		lblLevel.setForeground(new Color(34, 139, 34));
		lblLevel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 28));
		lblLevel.setBounds(202, 260, 171, 60);
		frame.getContentPane().add(lblLevel);
		btnExitGame.setForeground(new Color(153, 204, 255));
		btnExitGame.setBackground(new Color(0, 0, 0));
		btnExitGame.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnExitGame.setBounds(530, 506, 199, 102);
		frame.getContentPane().add(btnExitGame);
		
		JLabel lblLevel_1 = new JLabel("LEVEL 2");
		lblLevel_1.setForeground(new Color(34, 139, 34));
		lblLevel_1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 28));
		lblLevel_1.setBounds(919, 270, 171, 60);
		frame.getContentPane().add(lblLevel_1);
                level1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/levels1.png")));
		frame.getContentPane().add(level1);
		
		label_1 = new JLabel("");
		label_1.setBounds(240, 355, 191, 162);
                label_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/myLion2.png")));
		frame.getContentPane().add(label_1);
		
		button = new JButton("Play");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 
				   new test1(new Level2(),neworload);
				   frame.setVisible(false);
			}
		});
		button.setForeground(new Color(0, 153, 0));
		button.setFont(new Font("Tahoma", Font.BOLD, 24));
		button.setBackground(Color.BLACK);
		button.setBounds(933, 571, 122, 48);
		frame.getContentPane().add(button);
		
		btn1 = new JButton("Play");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				   new test1(new Level1(),neworload);
				   frame.setVisible(false);
				   
			}
		});
		btn1.setBackground(new Color(0, 0, 0));
		btn1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn1.setForeground(new Color(0, 153, 0));
		btn1.setBounds(213, 560, 122, 48);
		frame.getContentPane().add(btn1);	
		
		frame1 = new JLabel("");
		frame1.setBounds(160, 210, 250, 350);
		frame1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/myFramec.png")));
		frame.getContentPane().add(frame1);
		
		
		label_2 = new JLabel("");
		label_2.setBounds(847, 324, 155, 186);
		//img = new ImageIcon(this.getClass().getResource("/levels1.png")).getImage();
		label_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/levels1.png")));
		frame.getContentPane().add(label_2);

		label_3 = new JLabel("");
		label_3.setBounds(982, 386, 122, 154);
		label_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/goat.png")));
		frame.getContentPane().add(label_3);
		
		level2 = new JLabel("");
		level2.setBounds(883, 229, 331, 331);
		//img = new ImageIcon(this.getClass().getResource("/myFramec.png")).getImage();
		level2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/myframec.png")));
		frame.getContentPane().add(level2);
		
		label = new JLabel("");
		label.setBounds(0, 0, 1200,750 );
		//img = new ImageIcon(this.getClass().getResource("/aboelsho2.jpg")).getImage();
		label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/aboelsho2.jpg")));
		frame.getContentPane().add(label);
		
		
		
	}
}
