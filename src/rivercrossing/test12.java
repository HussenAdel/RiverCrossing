/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrossing;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

public class test12 {

	private JFrame frame;
	private JLabel label;
	private JLabel farmerlabel;
	private JLabel boatlabel;
	private JLabel boatlabel1;
	private JLabel grasslabel;
	private JLabel goatlabel;
	private JLabel lionlabel;
	private JLabel ride1;
	private JLabel ride2;
	private JLabel pas1;
	private JLabel pas2;
	private JLabel farrive;
	private JLabel larrive;
	private JLabel garrive;
	private JLabel grarrive;
	private Image img;
        private ArrayList<JLabel> left=new ArrayList<JLabel>(6);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test12 window = new test12();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test12() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1390, 728);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel ride3 = new JLabel("");
		ride3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				goatlabel.setIcon(ride3.getIcon());
				ride3.setIcon(null);
				goatlabel.setVisible(true);
			}
		});
		ride3.setBounds(457, 431, 94, 90);
		frame.getContentPane().add(ride3);
		
		JLabel ride4 = new JLabel("");
		ride4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grasslabel.setIcon(ride4.getIcon());
				ride4.setIcon(null);
				grasslabel.setVisible(true);
			}
		});
		ride4.setBounds(517, 441, 68, 90);
		frame.getContentPane().add(ride4);
		
		JLabel pas3 = new JLabel("");
		pas3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				garrive.setIcon(pas3.getIcon());
				pas3.setIcon(null);
			}
		});
		pas3.setBounds(813, 431, 81, 90);
		frame.getContentPane().add(pas3);
		
		JLabel pas4 = new JLabel("");
		pas4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				grarrive.setIcon(pas4.getIcon());
				pas4.setIcon(null);
			}
		});
		pas4.setBounds(881, 431, 81, 80);
		frame.getContentPane().add(pas4);
		
		ride1 = new JLabel("");
		ride1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				farmerlabel.setIcon(ride1.getIcon());
				ride1.setIcon(null);
				farmerlabel.setVisible(true);
			}
		});
		ride1.setBounds(400, 393, 73, 124);
		frame.getContentPane().add(ride1);
		
		ride2 = new JLabel("");
		ride2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lionlabel.setIcon(ride2.getIcon());
				ride2.setIcon(null);
				lionlabel.setVisible(true);
			}
		});
		ride2.setBounds(544, 441, 94, 80);
		frame.getContentPane().add(ride2);
		
		
		pas1 = new JLabel("");
		pas1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				farrive.setIcon(pas1.getIcon());
				pas1.setIcon(null);
			}
		});
		pas1.setBounds(720, 393, 61, 124);
		frame.getContentPane().add(pas1);
		
		pas2 = new JLabel("");
		pas2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				larrive.setIcon(pas2.getIcon());
				pas2.setIcon(null);
			}
		});
		pas2.setBounds(775, 415, 68, 106);
		frame.getContentPane().add(pas2);

		boatlabel1 = new JLabel("");
		boatlabel1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boatlabel.setIcon(boatlabel1.getIcon());
				boatlabel1.setIcon(null);
				boatlabel.setVisible(true);
				ride1.setIcon(pas1.getIcon());
				ride1.setVisible(true);
				ride2.setIcon(pas2.getIcon());
				ride2.setVisible(true);
				ride3.setIcon(pas3.getIcon());
				ride3.setVisible(true);
				ride4.setIcon(pas4.getIcon());
				ride4.setVisible(true);
				pas1.setIcon(null);
				pas2.setIcon(null);	
                pas3.setIcon(null);
				pas4.setIcon(null);
			}
		});
		boatlabel1.setBounds(696, 430, 228, 147);
		frame.getContentPane().add(boatlabel1);
		
		farrive = new JLabel("");
		farrive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pas1.setIcon(farrive.getIcon());
				farrive.setIcon(null);
				pas1.setVisible(true);
			}
		});
		farrive.setBounds(972, 358, 81, 124);
		frame.getContentPane().add(farrive);
		
		larrive = new JLabel("");
		larrive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pas2.setIcon(larrive.getIcon());
				larrive.setIcon(null);
				pas2.setVisible(true);
			}
		});
		larrive.setBounds(1098, 370, 87, 112);
		frame.getContentPane().add(larrive);
		
		garrive = new JLabel("");
		garrive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pas3.setIcon(garrive.getIcon());
				garrive.setIcon(null);
				pas3.setVisible(true);
			}
		});
		garrive.setBounds(1196, 370, 81, 112);
		frame.getContentPane().add(garrive);
		
		grarrive = new JLabel("");
		grarrive.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pas4.setIcon(grarrive.getIcon());
				grarrive.setIcon(null);
				pas4.setVisible(true);
			}
		});
		grarrive.setBounds(1287, 380, 73, 112);
		frame.getContentPane().add(grarrive);
	
		boatlabel = new JLabel("");
		boatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boatlabel1.setIcon(boatlabel.getIcon());
				boatlabel.setIcon(null);
				boatlabel1.setVisible(true);
				pas1.setIcon(ride1.getIcon());
				pas2.setIcon(ride2.getIcon());
				pas3.setIcon(ride3.getIcon());
				pas4.setIcon(ride4.getIcon());
				pas1.setVisible(true);
				pas2.setVisible(true);
				pas3.setVisible(true);
				pas4.setVisible(true);
				ride1.setIcon(null);
				ride2.setIcon(null);				
				ride3.setIcon(null);
				ride4.setIcon(null);	
			}
		});
		boatlabel.setBounds(389, 436, 249, 141);
	//	Image Img = new ImageIcon(this.getClass().getResource("/last.png")).getImage();
		boatlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("last.png")));
		frame.getContentPane().add(boatlabel);		
		
		farmerlabel = new JLabel("");
		farmerlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ride1.setIcon(farmerlabel.getIcon());
				farmerlabel.setIcon(null);
				ride1.setVisible(true);
			}
		});
		farmerlabel.setBounds(285, 371, 94, 115);
		farmerlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("fa.png")));
		frame.getContentPane().add(farmerlabel);
		
		goatlabel = new JLabel("");
		goatlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ride3.setIcon(goatlabel.getIcon());
				goatlabel.setIcon(null);
				ride3.setVisible(true);
			}
		});
		goatlabel.setBounds(103, 416, 81, 70);
		goatlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("goat1.png")));
		frame.getContentPane().add(goatlabel);
		
		lionlabel = new JLabel("");
		lionlabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ride2.setIcon(lionlabel.getIcon());
				lionlabel.setIcon(null);
                                lionlabel.setVisible(false);
				ride2.setVisible(true);
			}
		});
		lionlabel.setBounds(194, 402, 73, 80);
                lionlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("tr1.png")));
		//img = new ImageIcon(this.getClass().getResource("/tr1.png")).getImage();
		//lionlabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(lionlabel);
		
		grasslabel = new JLabel("");
		grasslabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ride4.setIcon(grasslabel.getIcon());
				grasslabel.setIcon(null);
				ride4.setVisible(true);
			}
		});
		grasslabel.setBounds(32, 416, 61, 76);
                grasslabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("zeft2.png")));
		//img = new ImageIcon(this.getClass().getResource("/zeft2.png")).getImage();
		//grasslabel.setIcon(new ImageIcon(img));
		frame.getContentPane().add(grasslabel);
	
		label = new JLabel("");
		label.setBounds(0, 0, 1390, 690);
                label.setIcon(new javax.swing.ImageIcon(getClass().getResource("lastbg.png")));
		//img = new ImageIcon(this.getClass().getResource("/lastbg.png")).getImage();
		frame.getContentPane().setLayout(null);
		//label.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label);
	}
}


