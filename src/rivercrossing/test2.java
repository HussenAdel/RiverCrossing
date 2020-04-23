import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test2 {

	private JFrame frame;
	private JLabel boatlabel;
	private JLabel boatlabel1;
	private JLabel pass1;
	private JLabel pass2;
	private JLabel pass3;
	private JLabel pass4;
	private JLabel pass5;
	private JLabel arrive3;
	private JLabel arrive4;
	private JLabel arrive5;
	private JLabel arrive6;
	private JLabel arrive7;
	private JLabel ride1;
	private JLabel ride2;
	private JLabel ride3;
    private JLabel ride4;
	private JLabel ride5;
	private JLabel label;
	private JLabel farmerlabel;
	private JLabel farmerlabel1;
	private JLabel farmerlabel2;
	private JLabel farmerlabel3;
	private JLabel animallabel;
	private Image img;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test2 window = new test2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public test2() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1390, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		pass3 = new JLabel("");
		pass3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arrive5.setIcon(pass3.getIcon());
				pass3.setIcon(null);
			}
		});
		pass3.setBounds(778, 395, 71, 119);
		frame.getContentPane().add(pass3);
		
		pass4 = new JLabel("");
		pass4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arrive7.setIcon(pass4.getIcon());
				pass4.setIcon(null);
			}
		});
		pass4.setBounds(817, 395, 81, 119);
		frame.getContentPane().add(pass4);
		
		pass5 = new JLabel("");
		pass5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arrive6.setIcon(pass5.getIcon());
				pass5.setIcon(null);
			}
		});
		pass5.setBounds(744, 399, 85, 115);
		frame.getContentPane().add(pass5);
		
		ride4 = new JLabel("");
		ride4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				farmerlabel.setIcon(ride4.getIcon());
				ride4.setIcon(null);
				farmerlabel.setVisible(true);
			}
		});
		ride4.setBounds(491, 369, 71, 126);
		frame.getContentPane().add(ride4);
		
		ride5 = new JLabel("");
		ride5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				farmerlabel3.setIcon(ride5.getIcon());
				ride5.setIcon(null);
				farmerlabel3.setVisible(true);

				
			}
		});
		ride5.setBounds(520, 376, 62, 119);
		frame.getContentPane().add(ride5);
		
		arrive3 = new JLabel("");
		arrive3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pass2.setIcon(arrive3.getIcon());
				arrive3.setIcon(null);
				pass2.setVisible(true);
			}
		});
		arrive3.setBounds(1273, 367, 87, 115);
		frame.getContentPane().add(arrive3);
		
		arrive4 = new JLabel("");
		arrive4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pass3.setIcon(arrive4.getIcon());
				arrive4.setIcon(null);
				pass3.setVisible(true);
			}
		});
		arrive4.setBounds(1201, 369, 62, 115);
		frame.getContentPane().add(arrive4);
		
		ride3 = new JLabel("");
		ride3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				farmerlabel1.setIcon(ride3.getIcon());
				ride3.setIcon(null);
				farmerlabel1.setVisible(true);

			}
		});
		ride3.setBounds(454, 369, 71, 126);
		frame.getContentPane().add(ride3);
		
		arrive5 = new JLabel("");
		arrive5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pass5.setIcon(arrive5.getIcon());
				arrive5.setIcon(null);
				pass5.setVisible(true);
			}
		});
		arrive5.setBounds(1037, 367, 71, 115);
		frame.getContentPane().add(arrive5);
		
		arrive6 = new JLabel("");
		arrive6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				pass4.setIcon(arrive6.getIcon());
				arrive6.setIcon(null);
				pass4.setVisible(true);
			}
		});
		arrive6.setBounds(937, 367, 71, 115);
		frame.getContentPane().add(arrive6);
		
		ride1 = new JLabel("");
		ride1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				farmerlabel2.setIcon(ride1.getIcon());
				ride1.setIcon(null);
				farmerlabel2.setVisible(true);

				
			}
		});
		
		arrive7 = new JLabel("");
		arrive7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pass1.setIcon(arrive7.getIcon());
				arrive7.setIcon(null);
				pass1.setVisible(true);
				
			}
		});
		arrive7.setBounds(1129, 367, 62, 115);
		frame.getContentPane().add(arrive7);
		ride1.setBounds(411, 375, 81, 139);
		frame.getContentPane().add(ride1);
		
		ride2 = new JLabel("");
		ride2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				animallabel.setIcon(ride2.getIcon());
				ride2.setIcon(null);
				animallabel.setVisible(true);
			}
		});
		ride2.setBounds(565, 443, 81, 71);
		frame.getContentPane().add(ride2);
		
		pass1 = new JLabel("");
		pass1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arrive4.setIcon(pass1.getIcon());
				pass1.setIcon(null);
			}
		});
		pass1.setBounds(713, 399, 71, 115);
		frame.getContentPane().add(pass1);
		
		pass2 = new JLabel("");
		pass2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				arrive3.setIcon(pass2.getIcon());
				pass2.setIcon(null);
			}
		});
		pass2.setBounds(880, 415, 71, 99);
		frame.getContentPane().add(pass2);
		
		boatlabel = new JLabel("");
		boatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boatlabel1.setIcon(boatlabel.getIcon());
				boatlabel.setIcon(null);
				boatlabel1.setVisible(true);
				pass1.setIcon(ride1.getIcon());
				pass2.setIcon(ride2.getIcon());
				pass3.setIcon(ride3.getIcon());
				pass4.setIcon(ride4.getIcon());
				pass5.setIcon(ride5.getIcon());
				pass1.setVisible(true);
				pass2.setVisible(true);
				pass3.setVisible(true);
				pass4.setVisible(true);
				pass5.setVisible(true);
				ride1.setIcon(null);
				ride2.setIcon(null);				
				ride3.setIcon(null);
				ride4.setIcon(null);	
				ride5.setIcon(null);
		}	
		});
		boatlabel.setBounds(411, 429, 266, 141);
		img = new ImageIcon(this.getClass().getResource("/last.png")).getImage();
		boatlabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(boatlabel);	
	
	    boatlabel1 = new JLabel("");
		boatlabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boatlabel.setIcon(boatlabel1.getIcon());
				boatlabel1.setIcon(null);
				boatlabel.setVisible(true);
				ride1.setIcon(pass1.getIcon());
				ride1.setVisible(true);
				ride2.setIcon(pass2.getIcon());
				ride2.setVisible(true);
				ride3.setIcon(pass3.getIcon());
				ride3.setVisible(true);
				ride4.setIcon(pass4.getIcon());
				ride4.setVisible(true);
				ride5.setIcon(pass5.getIcon());
				ride5.setVisible(true);
				
				pass1.setIcon(null);
				pass2.setIcon(null);	
                pass3.setIcon(null);
				pass4.setIcon(null);
				pass5.setIcon(null);
			}
		});
		boatlabel1.setBounds(713, 429, 227, 139);
		frame.getContentPane().add(boatlabel1);
		
		farmerlabel = new JLabel("");
		farmerlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ride4.setIcon(farmerlabel.getIcon());
				farmerlabel.setIcon(null);
				ride4.setVisible(true);
				
			}
		});
		farmerlabel.setBounds(156, 375, 87, 115);
		img = new ImageIcon(this.getClass().getResource("/fa.png")).getImage();
		farmerlabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(farmerlabel);
		
		farmerlabel1 = new JLabel("");
		farmerlabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ride3.setIcon(farmerlabel1.getIcon());
				farmerlabel1.setIcon(null);
				ride3.setVisible(true);
				
			}
		});
		farmerlabel1.setBounds(229, 375, 81, 115);
		img = new ImageIcon(this.getClass().getResource("/3.png")).getImage();
		farmerlabel1.setIcon(new ImageIcon(img));
		frame.getContentPane().add(farmerlabel1);
		
		farmerlabel2= new JLabel("");
		farmerlabel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ride1.setIcon(farmerlabel2.getIcon());
				farmerlabel2.setIcon(null);
				ride1.setVisible(true);
				
			}
		});
		farmerlabel2.setBounds(305, 372, 81, 110);
		img = new ImageIcon(this.getClass().getResource("/2.png")).getImage();
		farmerlabel2.setIcon(new ImageIcon(img));
		frame.getContentPane().add(farmerlabel2);
		
		farmerlabel3 = new JLabel("");
		farmerlabel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ride5.setIcon(farmerlabel3.getIcon());
				farmerlabel3.setIcon(null);
				ride5.setVisible(true);
			}
		});
		farmerlabel3.setBounds(78, 375, 81, 115);
		img = new ImageIcon(this.getClass().getResource("/1.png")).getImage();
		farmerlabel3.setIcon(new ImageIcon(img));
		frame.getContentPane().add(farmerlabel3);
		

		JLabel sign = new JLabel("");
		sign.setBounds(-33, 11, 177, 154);
		img = new ImageIcon(this.getClass().getResource("/oo.png")).getImage();
		sign.setIcon(new ImageIcon(img));
		frame.getContentPane().add(sign);
		
		animallabel = new JLabel("");
		animallabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ride2.setIcon(animallabel.getIcon());
				animallabel.setIcon(null);
				ride2.setVisible(true);
				
			}
		});
		animallabel.setBounds(0, 411, 81, 71);
		Image img5 = new ImageIcon(this.getClass().getResource("/Goat1.png")).getImage();
		animallabel.setIcon(new ImageIcon(img5));
		frame.getContentPane().add(animallabel);
	
		
	    label = new JLabel("");
		label.setBounds(0, 0, 1390, 690);
		img = new ImageIcon(this.getClass().getResource("/lastbg.png")).getImage();
		frame.getContentPane().setLayout(null);
		label.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label);
		}
}
