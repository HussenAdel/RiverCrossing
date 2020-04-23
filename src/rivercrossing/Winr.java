/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrossing;
 import javax.swing.*;
import java.awt.geom.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class Winr{
InputStream music;
JFrame jf= new JFrame();
      private int score=0;
      ICrossingStrategy gamestrategy;
      AudioStream audio;
      AudioPlayer play;
      private JButton jButton1=new JButton();
    private JButton jButton2=new JButton();
    private JLabel jLabel1= new JLabel();
    private JLabel jLabel2= new JLabel();
    private JLabel jLabel3= new JLabel();
    private JLabel jLabel4=new JLabel();
    private JPanel pa=new JPanel();
    /**
     * Creates new form Win
     */
    public Winr(score sc,ICrossingStrategy gamestrategy) {
        jf.setSize(700,700);
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("You Win");
        pa.add(jLabel1);
        jLabel1.setBounds(0, 0, 50, 50);
        jButton2.setText("New Game");
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/star-staricon-starvector-set-on-260nw-740605270.jpg"))); // NOI18N
        jLabel3.setText("\n");
        pa.add(jLabel3);
        jLabel3.setBounds(60, 60, 50, 50);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/star-staricon-starvector-set-on-260nw-740605270.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
pa.add(jLabel2);
        jLabel2.setBounds(60, 120, 50, 50);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rivercrossing/star-staricon-starvector-set-on-260nw-740605270.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        pa.add(jLabel2);
        jLabel2.setBounds(60, 120, 50, 50);
        jButton1.setText("Retry");
        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new move(0,jf.getWidth(),"Magdy",36));
        this.gamestrategy=gamestrategy;
       jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
        try {
            music=new FileInputStream(new File("baby_shark_do_do_do-dsy5tFJSb38.wav"));
            audio=new AudioStream(music);
            play.player.start(audio);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Win.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(Win.class.getName()).log(Level.SEVERE, null, ex);
    }
        score=sc.getScore();
        System.out.println(score);
        if (score==1)
        {
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
        }
        else if (score==2)
        {
           jLabel2.setVisible(true);
            jLabel3.setVisible(true);
        }
        else
        {
            jLabel3.setVisible(true);
        }
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        //jButton1ActionPerformed(ActionEvent evt);
        
//    }
//     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        new GUI(gamestrategy, true).setVisible(true);
//        play.player.stop(audio);
//        jf.setVisible(false);
//    }                                        
//
//    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
//        new Levels(true).setVisible(true);
//        play.player.stop(audio);
//        jf.setVisible(false);
   }
}