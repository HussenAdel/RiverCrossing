package rivercrossing;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JFrame;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Board extends JPanel {

private Image ground;
private Image city;
private int x = 0;


public Board() {
    ground = Toolkit.getDefaultToolkit().getImage("last.png");
   // city = Toolkit.getDefaultToolkit().getImage("Goat1.png");
}

public void paint(Graphics g){
    super.paint(g);
   // g.drawImage(ground, x - 1000, 500, 1000, 200, this);
    g.drawImage(ground, x++, 500, 500, 200, this);
    repaint();
   // g.drawImage(city, 0, 0, 600, 500, this);

//    if(x == -100){
//        x = 0;
 //   }
}
  public static void main(String[] args) {
    {
        JFrame jf=new JFrame("hello");
        
        jf.setSize(5000,1000);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new Board());
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        
    }
     }
}