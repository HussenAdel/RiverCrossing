package rivercrossing;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class Farmer implements ICrosser {
	private BufferedImage img;
	private double weight;
	private int eatingRank=10;
        private String label;
        private BufferedImage[] imgs = new BufferedImage[6];
        int i=0;
        

	public Farmer(double weight) {
		this.weight=weight;
                 this.eatingRank =10;
		 this.weight=weight;
		File file = new File("C:\\Users\\Adel\\Documents\\NetBeansProjects\\rivercrossing\\imgs\\fa.png");
               // System.out.println(file);
                
            try {
                imgs[i]=ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            }
               
	}

	@Override
	public boolean canSail() {
		return true;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	public void setEatingRank(int eatingRank) {
		this.eatingRank = eatingRank;
	}

	@Override
	public int getEatingRank() {
		return eatingRank;
	}

	@Override
	public BufferedImage[] getImages() {
			BufferedImage[] images = new BufferedImage[6];
        for(int i = 0; i < images.length; i++) {
            images[i] = this.imgs[i];
        }
		return images;
	}
	

	@Override
	public ICrosser makeCopy() {
		ICrosser farmer = new Farmer(this.getWeight());
		farmer.getImages();
		farmer.setLabelToBeShown(this.getLabelToBeShown());
		return farmer;
	}

	@Override
	public void setLabelToBeShown(String label) {
            this.label=label;
	}

	@Override
	public String getLabelToBeShown() {
		return label;
	}

}
