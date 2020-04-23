package rivercrossing;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class test1 {

    private JLabel labelmoves;
    private JLabel labeltimer;
    private Timer timer3;
    private Timer timer1;
    private Timer timer;
    private Point rv;
    ICrossingStrategy gameStrategy;
    private int i;
    int t;
    private int size;
    private int r1index;
    private int r2index;
    IRiverCrossingController control;
    private JFrame frame = new JFrame();
    private BufferedImage bufferedImage;
	private JLabel label;
    private JLabel labelride1;
    private JLabel labelride2;
    private JLabel boatlabel;
    private JLabel ride1;
    private JLabel ride2;
    private JLabel labelright[] = new JLabel[6];
    private JLabel labelleft[] = new JLabel[6];
    private JLabel left[] = new JLabel[6];
    private JLabel right[] = new JLabel[6];
    private JButton move;
    private JButton undo;
    private JButton redo;
    private JButton save;
    private JButton retry;
    private JButton exit;
    boolean leftorright = true;
    private ArrayList<ICrosser> boatlist = new ArrayList(5);
    private ArrayList<ICrosser> Arraylist = new ArrayList(5);
    private ICrosser list[] = new ICrosser[6];
    ICrosser crosser;

    /**
     * Launch the application.
     */
//    public static void main(String[] args) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    test1 window = new test1(new Level1(),true);
//                    window.frame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }

    /**
     * Create the application.
     */
    public test1(ICrossingStrategy gamesStrategy, boolean neworload) {
        frame.setVisible(true);
        this.gameStrategy = gamesStrategy;
        control = GameController.getInstance();
        
        if (neworload) {
            control.newGame(gameStrategy);
            size = control.getCrossersOnLeftBank().size();
            Arraylist = (ArrayList<ICrosser>) control.getCrossersOnLeftBank();
            initialize();
            Instructions ins = new Instructions(control.getInstructions(), timer);
            ins.setVisible(true);
            for (i = 0; i < Arraylist.size(); i++) {
                list[i] = Arraylist.get(i);
                left[i].setVisible(true);
                labelright[i].setText(Arraylist.get(i).getLabelToBeShown());
                labelleft[i].setText(Arraylist.get(i).getLabelToBeShown());
                labelleft[i].setVisible(true);
                 if (list[i] instanceof Farmer)
                {
                      bufferedImage = new Farmer(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a);
                }
                else if (list[i] instanceof Herbivorous)
                {
                        bufferedImage = new Herbivorous(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a);
                }
                else if (list[i] instanceof Plant)
                        {
                              bufferedImage = new Plant(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a); 
                        }
                else 
                {
                    bufferedImage = new Lion(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a); 
                }
            }
        } else { 
            control.loadGame();
            initialize();
             Instructions ins = new Instructions(control.getInstructions(), timer);
            ins.setVisible(true);
            leftorright=control.isBoatOnTheLeftBank();
            labelmoves.setText("Moves : " + control.getNumberOfSails());
           if (leftorright) {
                        ride1.setBounds(450, 400, 73, 124);
                        ride2.setBounds(520, 400, 94, 130);
                        boatlabel.setBounds(389, 436, 249, 141);
                        labelride1.setBounds(495, 450, 40, 20);
        labelride2.setBounds(555, 450, 40, 20);

                    } else {
                        ride1.setBounds(730, 400, 73, 124);
                        ride2.setBounds(800, 400, 94, 130);
                        boatlabel.setBounds(669, 436, 249, 141);
                        labelride1.setBounds(775, 450, 40, 20);
                        labelride2.setBounds(835, 450, 40, 20);
                    }
            Arraylist = (ArrayList<ICrosser>) control.getCrossersOnLeftBank(); 
            size = control.getCrossersOnLeftBank().size();
            for (i = 0; i < Arraylist.size(); i++) {
                list[i] = Arraylist.get(i);
                labelright[i].setText(Arraylist.get(i).getLabelToBeShown());
                labelleft[i].setText(Arraylist.get(i).getLabelToBeShown());
                left[i].setVisible(true);
                labelleft[i].setVisible(true);
                  if (list[i] instanceof Farmer)
                {
                      bufferedImage = new Farmer(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a);
                }
                else if (list[i] instanceof Herbivorous)
                {
                        bufferedImage = new Herbivorous(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a);
                }
                else if (list[i] instanceof Plant)
                        {
                              bufferedImage = new Plant(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a); 
                        }
                else 
                {
                    bufferedImage = new Lion(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a); 
                }
            }
            Arraylist = (ArrayList<ICrosser>) control.getCrossersOnRightBank();
            for (int j=0; j < Arraylist.size(); i++,j++) {
                list[i] = Arraylist.get(j);
                labelright[i].setText(Arraylist.get(j).getLabelToBeShown());
                labelleft[i].setText(Arraylist.get(j).getLabelToBeShown());
                right[i].setVisible(true);
                labelright[i].setVisible(true);
                size++;
                  if (list[i] instanceof Farmer)
                {
                      bufferedImage = new Farmer(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a);
                }
                else if (list[i] instanceof Herbivorous)
                {
                        bufferedImage = new Herbivorous(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a);
                }
                else if (list[i] instanceof Plant)
                        {
                              bufferedImage = new Plant(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a); 
                        }
                else 
                {
                    bufferedImage = new Lion(20).getImages()[0];
            ImageIcon a = new ImageIcon(bufferedImage);
       left[i].setIcon(a);
       right[i].setIcon(a); 
                }
            }
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame.setBounds(320, 100, 1390, 728);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        labelride1 = new JLabel("");
        labelride1.setBounds(495, 450, 40, 20);
        Font font = new Font("Tahoma", 1, 15);
        labelride1.setFont(font);
        labelride1.setForeground(Color.red);
        frame.getContentPane().add(labelride1);
        labelride2 = new JLabel("");
        labelride2.setBounds(555, 450, 40, 20);
        font = new Font("Tahoma", 1, 15);
        labelride2.setFont(font);
        labelride2.setForeground(Color.red);
        frame.getContentPane().add(labelride2);
        labelmoves = new JLabel("Moves : " + control.getNumberOfSails());
        labelmoves.setForeground(Color.red);
        font = new Font("Tahoma", 1, 20);
        labelmoves.setFont(font);
        labelmoves.setBounds(1230, 200, 150, 50);
        frame.getContentPane().add(labelmoves);
        labeltimer = new JLabel("Time :" + t);
        labeltimer.setBounds(1250, 270, 150, 50);
        labeltimer.setFont(font);
        labeltimer.setForeground(Color.red);
        frame.getContentPane().add(labeltimer);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                t++;
                labeltimer.setText("Time :" + t);
            }
        });

        ride1 = new JLabel("");

        ride1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (leftorright) {
                    ride1.setIcon(null);
                    ride1.setVisible(false);
                    labelride1.setVisible(false);
                    left[r1index].setVisible(true);
                    labelleft[r1index].setVisible(true);
                } else {

                    ride1.setIcon(null);
                    ride1.setVisible(false);
                    labelride1.setVisible(false);
                    right[r1index].setVisible(true);
                    labelright[r1index].setVisible(true);
                }
            }
        });
        ride1.setBounds(450, 400, 73, 124);
        frame.getContentPane().add(ride1);
        ride1.setVisible(false);

        ride2 = new JLabel("");
        ride2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (leftorright) {
                    ride2.setIcon(null);
                    ride2.setVisible(false);
                    labelride2.setVisible(false);
                    left[r2index].setVisible(true);
                    labelleft[r2index].setVisible(true);
                } else {
                    ride2.setIcon(null);
                    ride2.setVisible(false);
                    labelride2.setVisible(false);
                    right[r2index].setVisible(true);
                    labelright[r2index].setVisible(true);
                }

            }
        });
        ride2.setBounds(520, 400, 94, 130);
        frame.getContentPane().add(ride2);
        ride2.setVisible(false);
        labelright[0] = new JLabel("3");
        font= new Font("Tahoma", 1, 15);
        labelright[0].setFont(font);
        labelright[0].setBounds(1017, 415, 40, 20);
        labelright[0].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelright[0]);
        labelright[1] = new JLabel("3");
        font= new Font("Tahoma", 1, 15);
        labelright[1].setFont(font);
        labelright[1].setBounds(1075, 455, 40, 20);
        labelright[1].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelright[1]);
        labelright[2] = new JLabel("3");
        font= new Font("Tahoma", 1, 15);
        labelright[2].setFont(font);
        labelright[2].setBounds(1167, 455, 40, 20);
        labelright[2].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelright[2]);
        labelright[3] = new JLabel("3");
        font= new Font("Tahoma", 1, 15);
        labelright[3].setFont(font);
        labelright[3].setBounds(1250, 455, 40, 20);
        labelright[3].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelright[3]);
        labelright[4] = new JLabel("3");
        font= new Font("Tahoma", 1, 15);
        labelright[4].setFont(font);
        labelright[4].setBounds(1300, 455, 40, 20);
        labelright[4].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelright[4]);
        right[0] = new JLabel("");
        BufferedImage bufferedImage = new Farmer(20).getImages()[0];
       // ImageIcon a = new ImageIcon(list[0].getImages()[0]);
         
 ImageIcon c = new ImageIcon(bufferedImage);
       // right[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("fa.png")));
        right[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (!ride1.isVisible() && !leftorright) {
                    ride1.setIcon(right[0].getIcon());
                    labelride1.setText(labelright[0].getText());
                    right[0].setVisible(false);
                    labelright[0].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 0;
                } else if (!ride2.isVisible() && !leftorright) {
                    ride2.setIcon(right[0].getIcon());
                    labelride2.setText(labelright[0].getText());
                    right[0].setVisible(false);
                    labelright[0].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 0;
                }
            }
        });
        right[0].setBounds(972, 358, 81, 124);
        frame.getContentPane().add(right[0]);

        right[1] = new JLabel("");
        right[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (!ride1.isVisible() && !leftorright) {
                    ride1.setIcon(right[1].getIcon());
                    labelride1.setText(labelright[1].getText());
                    right[1].setVisible(false);
                    labelright[1].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 1;
                } else if (!ride2.isVisible() && !leftorright) {
                    ride2.setIcon(right[1].getIcon());
                    labelride2.setText(labelright[1].getText());
                    right[1].setVisible(false);
                    labelright[1].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 1;
                }
            }
        });
        right[1].setBounds(1037, 400, 87, 130);
       // right[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("zeft2.png")));
        frame.getContentPane().add(right[1]);

        right[2] = new JLabel("");
      //  right[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("tr1.png")));
        right[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (!ride1.isVisible() && !leftorright) {
                    ride1.setIcon(right[2].getIcon());
                    labelride1.setText(labelright[2].getText());
                    right[2].setVisible(false);
                    labelright[2].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 2;
                } else if (!ride2.isVisible() && !leftorright) {
                    ride2.setIcon(right[2].getIcon());
                    labelride2.setText(labelright[2].getText());
                    right[2].setVisible(false);
                    labelright[2].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 2;
                }
            }
        });
        right[2].setBounds(1117, 400, 81, 130);
        frame.getContentPane().add(right[2]);

        right[3] = new JLabel("");
       // right[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("Goat1.png")));
        right[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!ride1.isVisible() && !leftorright) {
                    ride1.setIcon(right[3].getIcon());
                    labelride1.setText(labelright[3].getText());
                    right[3].setVisible(false);
                    labelright[3].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 3;
                } else if (!ride2.isVisible() && !leftorright) {
                    ride2.setIcon(right[3].getIcon());
                    labelride2.setText(labelright[3].getText());
                    right[3].setVisible(false);
                    labelright[3].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 3;
                }
            }

        });
        right[3].setBounds(1200, 400, 73, 130);
        frame.getContentPane().add(right[3]);

        right[4] = new JLabel("");
       // right[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("1.png")));
        right[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!ride1.isVisible() && !leftorright) {
                    ride1.setIcon(right[4].getIcon());
                    labelride1.setText(labelright[4].getText());
                    right[4].setVisible(false);
                    labelright[4].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 4;

                } else if (!ride2.isVisible() && !leftorright) {
                    ride2.setIcon(right[4].getIcon());
                    labelride2.setText(labelright[4].getText());
                    right[4].setVisible(false);
                    labelright[4].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 4;
                }

            }
        });
        right[4].setBounds(1257, 400, 81, 130);

        frame.getContentPane().add(right[4]);
        boatlabel = new JLabel("");
        boatlabel.setBounds(389, 436, 249, 141);
        boatlabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("last.png")));
        frame.getContentPane().add(boatlabel);

        labelleft[0] = new JLabel("3");
        font= new Font("Tahoma", 1, 15);
        labelleft[0].setFont(font);
        labelleft[0].setBounds(330, 455, 40, 20);
        labelleft[0].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelleft[0]);
        labelleft[1] = new JLabel("7");
        font= new Font("Tahoma", 1, 15);
        labelleft[1].setFont(font);
        labelleft[1].setBounds(245, 455, 40, 20);
        labelleft[1].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelleft[1]);
        labelleft[2] = new JLabel("7");
        labelleft[2].setBounds(170, 455, 40, 20);
        font= new Font("Tahoma", 1, 15);
        labelleft[2].setFont(font);
        labelleft[2].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelleft[2]);
        labelleft[3] = new JLabel("7");
        labelleft[3].setBounds(100, 460, 40, 20);
        font= new Font("Tahoma", 1, 15);
        labelleft[3].setFont(font);
        labelleft[3].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelleft[3]);
        labelleft[4] = new JLabel("7");
        font= new Font("Tahoma", 1, 15);
        labelleft[4].setFont(font);
        labelleft[4].setBounds(45, 455, 40, 20);
        labelleft[4].setForeground(new java.awt.Color(255, 51, 51));
        frame.getContentPane().add(labelleft[4]);

        left[0] = new JLabel("");
        left[0].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (!ride1.isVisible() && leftorright) {
                    ride1.setIcon(left[0].getIcon());
                    labelride1.setText(labelleft[0].getText());
                    labelleft[0].setVisible(false);
                    left[0].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 0;
                } else if (!ride2.isVisible() && leftorright) {
                    ride2.setIcon(left[0].getIcon());
                    labelride2.setText(labelleft[0].getText());
                    labelleft[0].setVisible(false);
                    left[0].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 0;
                }
            }
        });
        left[0].setBounds(285, 400, 94, 130);
     //   left[0].setIcon(new javax.swing.ImageIcon(getClass().getResource("fa.png")));
        frame.getContentPane().add(left[0]);

        left[1] = new JLabel("");
        left[1].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!ride1.isVisible() && leftorright) {
                    ride1.setIcon(left[1].getIcon());
                    labelride1.setText(labelleft[1].getText());
                    labelleft[1].setVisible(false);
                    left[1].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 1;
                } else if (!ride2.isVisible() && leftorright) {
                    ride2.setIcon(left[1].getIcon());
                    labelride2.setText(labelleft[1].getText());
                    labelleft[1].setVisible(false);
                    left[1].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 1;
                }
            }

        });
        left[1].setBounds(220, 400, 81, 130);
        //left[1].setIcon(new javax.swing.ImageIcon(getClass().getResource("zeft2.png")));
        frame.getContentPane().add(left[1]);

        left[2] = new JLabel("");
        left[2].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!ride1.isVisible() && leftorright) {
                    ride1.setIcon(left[2].getIcon());
                    labelride1.setText(labelleft[2].getText());
                    labelleft[2].setVisible(false);
                    left[2].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 2;
                } else if (!ride2.isVisible() && leftorright) {
                    ride2.setIcon(left[2].getIcon());
                    labelride2.setText(labelleft[2].getText());
                    labelleft[2].setVisible(false);
                    left[2].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 2;

                }
            }
        });

        left[2].setBounds(140, 400, 80, 130);
        //left[2].setIcon(new javax.swing.ImageIcon(getClass().getResource("tr1.png")));
        frame.getContentPane().add(left[2]);

        left[3] = new JLabel("");
        left[3].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!ride1.isVisible() && leftorright) {
                    ride1.setIcon(left[3].getIcon());
                    labelride1.setText(labelleft[3].getText());
                    labelleft[3].setVisible(false);
                    left[3].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 3;

                } else if (!ride2.isVisible() && leftorright) {
                    ride2.setIcon(left[3].getIcon());
                    labelride2.setText(labelleft[3].getText());
                    labelleft[3].setVisible(false);
                    left[3].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 3;

                }

            }
        });
        left[3].setBounds(80, 400, 80, 130);
        //left[3].setIcon(new javax.swing.ImageIcon(getClass().getResource("Goat1.png")));
        frame.getContentPane().add(left[3]);
        left[4] = new JLabel("");
        left[4].addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!ride1.isVisible() && leftorright) {
                    ride1.setIcon(left[4].getIcon());
                    labelride1.setText(labelleft[4].getText());
                    labelleft[4].setVisible(false);
                    left[4].setVisible(false);
                    ride1.setVisible(true);
                    labelride1.setVisible(true);
                    r1index = 4;

                } else if (!ride2.isVisible() && leftorright) {
                    ride2.setIcon(left[4].getIcon());
                    labelride2.setText(labelleft[4].getText());
                    labelleft[4].setVisible(false);
                    left[4].setVisible(false);
                    ride2.setVisible(true);
                    labelride2.setVisible(true);
                    r2index = 4;
                }
            }
        });
        left[4].setBounds(0, 400, 81, 130);
       // left[4].setIcon(new javax.swing.ImageIcon(getClass().getResource("1.png")));
        frame.getContentPane().add(left[4]);
        labelride1.setVisible(false);
        labelride2.setVisible(false);
        for (i = 0; i < 5; i++) {
            left[i].setVisible(false);
            right[i].setVisible(false);
            labelleft[i].setVisible(false);
            labelright[i].setVisible(false);

        }
        move = new JButton("Move");
        move.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                if (ride1.isVisible()) {
                    crosser = list[r1index];
                    boatlist.add(crosser);

                }
                if (ride2.isVisible()) {
                    crosser = list[r2index];
                    boatlist.add(crosser);
                }
                if (control.canMove(boatlist, leftorright)) {
                    control.doMove(boatlist, leftorright);
                    labelmoves.setText("Moves : " + control.getNumberOfSails());
                    boatlist = new ArrayList(5);
                    Point rv1 = ride1.getLocation();
                    Point rv2 = ride2.getLocation();
                    Point rv1l = labelride1.getLocation();
                    Point rv2l = labelride2.getLocation();
                    rv = boatlabel.getLocation();
                    timer1 = new Timer(10, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int x;
                            if (leftorright) {
                                rv.x++;
                                rv1.x++;
                                rv2.x++;
                                rv1l.x++;
                                rv2l.x++;
                                x = 669;
                            } else {
                                rv.x--;
                                rv1.x--;
                                rv2.x--;
                                rv1l.x--;
                                rv2l.x--;
                                x = 389;
                            }
                            if (rv.x == x) {
                                timer1.stop();
                                if (leftorright) {

                                    if (ride1.isVisible()) {
                                        right[r1index].setVisible(true);
                                        labelright[r1index].setVisible(true);
                                    }
                                    if (ride2.isVisible()) {
                                        right[r2index].setVisible(true);
                                        labelright[r2index].setVisible(true);
                                    }
                                    ride1.setIcon(null);
                                    ride2.setIcon(null);
                                    ride1.setVisible(false);
                                    ride2.setVisible(false);
                                    labelride1.setVisible(false);
                                    labelride2.setVisible(false);
                                    leftorright = false;

                                } else {
                                    if (ride1.isVisible()) {
                                        left[r1index].setVisible(true);
                                        labelleft[r1index].setVisible(true);
                                    }
                                    if (ride2.isVisible()) {
                                        left[r2index].setVisible(true);
                                        labelleft[r2index].setVisible(true);
                                    }
                                    ride1.setIcon(null);
                                    ride2.setIcon(null);
                                    ride1.setVisible(false);
                                    ride2.setVisible(false);
                                    labelride1.setVisible(false);
                                    labelride2.setVisible(false);
                                    leftorright = true;

                                }

                                if (control.getCrossersOnLeftBank().size() == 0) {
                                    timer.stop();
                                    Win g = new Win(control.getNumberOfSails(), gameStrategy);
                                    g.setVisible(true);
                                }

                            }

                            boatlabel.setLocation(rv);
                            ride1.setLocation(rv1);
                            ride2.setLocation(rv2);
                            labelride1.setLocation(rv1l);
                            labelride2.setLocation(rv2l);
                            boatlabel.repaint();
                            ride1.repaint();
                            ride2.repaint();
                            labelride1.repaint();
                            labelride2.repaint();

                        }

                    });
                    timer1.setInitialDelay(0);
                    timer1.start();

                } else {
                    JOptionPane.showMessageDialog(null, "INVALID MOVE");
                    boatlist = new ArrayList(5);
                    if (ride1.isVisible()) {
                        if (leftorright) {
                            left[r1index].setVisible(true);
                            labelleft[r1index].setVisible(true);
                        } else {
                            right[r1index].setVisible(true);
                            labelright[r1index].setVisible(true);
                        }
                        ride1.setIcon(null);
                        ride1.setVisible(false);
                        labelride1.setVisible(false);
                    }
                    if (ride2.isVisible()) {
                        if (leftorright) {
                            left[r2index].setVisible(true);
                            labelleft[r2index].setVisible(true);
                        } else {
                            right[r2index].setVisible(true);
                            labelright[r2index].setVisible(true);
                        }
                        ride2.setIcon(null);
                        ride2.setVisible(false);
                        labelride2.setVisible(false);

                    }
                }
            }
        });

        move.setBounds(630, 100, 100, 100);
        frame.getContentPane().add(move);
        retry = new JButton("Reset");

        retry.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                control.resetGame();
                for (i = 0; i < size; i++) {
                    list[i]=control.getCrossersOnLeftBank().get(i);
                    left[i].setVisible(true);
                    right[i].setVisible(false);
                    labelleft[i].setVisible(true);
                    labelright[i].setVisible(false);

                }
                timer.stop();
                labelride1.setVisible(false);
                labelride2.setVisible(false);
                ride1.setVisible(false);
                ride2.setVisible(false);
                leftorright = true;
                ride1.setBounds(450, 400, 73, 124);
                ride2.setBounds(520, 400, 94, 130);
                boatlabel.setBounds(389, 436, 249, 141);
                boatlist = new ArrayList(5);
                t = 0;
                labeltimer.setText("Time : " + t);
                labelmoves.setText("Moves : " + control.getNumberOfSails());
                labelride1.setBounds(495, 450, 40, 20);
        labelride2.setBounds(555, 450, 40, 20);

                Instructions ins = new Instructions(control.getInstructions(), timer);
                ins.setVisible(true);
            }

        });
        retry.setBounds(0, 600, 70, 70);
        frame.getContentPane().add(retry);
        save = new JButton("Save");
        save.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                control.saveGame();
            }
        });
        save.setBounds(300, 600, 70, 70);
        frame.getContentPane().add(save);
        undo = new JButton("Undo");
        undo.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if (control.canUndo()) {
                    boatlist = new ArrayList(5);
                    for (i = 0; i < size; i++) {
                        left[i].setVisible(false);
                        right[i].setVisible(false);
                        labelleft[i].setVisible(false);
                        labelright[i].setVisible(false);

                    }
                    labelride1.setVisible(false);
                    labelride2.setVisible(false);
                    ride1.setVisible(false);
                    ride2.setVisible(false);
                    control.undo();
                    labelmoves.setText("Moves : " + control.getNumberOfSails());
                    leftorright = control.isBoatOnTheLeftBank();
                    Arraylist= new ArrayList<>();
                    Arraylist = (ArrayList<ICrosser>) control.getCrossersOnLeftBank();
                    for (i = 0; i < Arraylist.size(); i++) {
                        for (int j = 0; j < size; j++) {
                            if (labelleft[j].getText().equals(Arraylist.get(i).getLabelToBeShown())) {
                                left[j].setVisible(true);
                                labelleft[j].setVisible(true);
                            }
                        }
                    }
                    for (i = 0; i < size; i++) {
                        if (!left[i].isVisible()) {
                            right[i].setVisible(true);
                            labelright[i].setVisible(true);
                        }
                    }
                    if (leftorright) {
                        ride1.setBounds(450, 400, 73, 124);
                        ride2.setBounds(520, 400, 94, 130);
                        boatlabel.setBounds(389, 436, 249, 141);
                        labelride1.setBounds(495, 450, 40, 20);
        labelride2.setBounds(555, 450, 40, 20);

                    } else {
                        ride1.setBounds(730, 400, 73, 124);
                        ride2.setBounds(800, 400, 94, 130);
                        boatlabel.setBounds(669, 436, 249, 141);
                        labelride1.setBounds(775, 450, 40, 20);
                        labelride2.setBounds(835, 450, 40, 20);
                    }
                }
            }
        });
        undo.setBounds(100, 600, 70, 70);
        frame.getContentPane().add(undo);
        redo = new JButton("Redo");
        redo.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                  if (control.canRedo()) {
                    boatlist = new ArrayList(5);
                    for (i = 0; i < size; i++) {
                        left[i].setVisible(false);
                        right[i].setVisible(false);
                        labelleft[i].setVisible(false);
                        labelright[i].setVisible(false);

                    }
                    labelride1.setVisible(false);
                    labelride2.setVisible(false);
                    ride1.setVisible(false);
                    ride2.setVisible(false);
                    control.redo();
                    labelmoves.setText("Moves : " + control.getNumberOfSails());
                    leftorright = control.isBoatOnTheLeftBank();
                    Arraylist = (ArrayList<ICrosser>) control.getCrossersOnLeftBank();
                    for (i = 0; i < Arraylist.size(); i++) {
                        for (int j = 0; j < size; j++) {
                            if (labelleft[j].getText().equals(Arraylist.get(i).getLabelToBeShown())) {
                                left[j].setVisible(true);
                                labelleft[j].setVisible(true);
                            }
                        }
                    }
                    for (i = 0; i < size; i++) {
                        if (!left[i].isVisible()) {
                            right[i].setVisible(true);
                            labelright[i].setVisible(true);
                        }
                    }
                    if (leftorright) {
                        ride1.setBounds(450, 400, 73, 124);
                        ride2.setBounds(520, 400, 94, 130);
                        boatlabel.setBounds(389, 436, 249, 141);
                        labelride1.setBounds(495, 450, 40, 20);
        labelride2.setBounds(555, 450, 40, 20);

                    } else {
                        ride1.setBounds(730, 400, 73, 124);
                        ride2.setBounds(800, 400, 94, 130);
                        boatlabel.setBounds(669, 436, 249, 141);
                        labelride1.setBounds(775, 450, 40, 20);
                        labelride2.setBounds(835, 450, 40, 20);
                    }
                }
            }
        });
        redo.setBounds(200, 600, 70, 70);
        frame.getContentPane().add(redo);
        exit = new JButton("Exit");
                exit.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu me =new menu();
                me.setVisible(true);
                frame.setVisible(false);
            }
        });
                exit.setBounds(400, 600, 70, 70);
                frame.getContentPane().add(exit);
                
        
        
        label = new JLabel("");
        label.setBounds(0, 0, 1390, 690);
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource("lastbg.png")));
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(label);
    }
}
