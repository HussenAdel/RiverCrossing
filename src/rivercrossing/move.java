/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrossing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Paint;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Adel
 */
public class move extends JPanel{
    int x=0;
    int y=0;
    int source;
    int dest;
    String name;
public move(int source,int dest,String name,int y)
{
    this.y=y;
    this.source=source;
    this.x=source;
    this.dest=dest;
    this.name=name;
}
        

    @Override
 public void paint(Graphics g)
{
    super.paint(g);
    Graphics2D g2=(Graphics2D)g;
g2.setColor(Color.red);
    Font font=new Font("Tahoma", 1,36);
g2.setFont(font);
   g2.drawString(name, x, y);
    try {
        Thread.sleep(100);
    } catch (Exception e) {
        System.out.println(""+e);
    }
    
    x+=10;
    if(x>dest)
            {
               x=source;
            }
    repaint();
}
     
     public static void main(String[] args) {
    {
        JFrame jf=new JFrame("hello");
        
        jf.setSize(700,700);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new move(0,450,"You",36));
        jf.add(new move(450,jf.getWidth(),"win",36));
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        
    }
     }
}
     
