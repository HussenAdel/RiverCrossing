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

public class Herbivorous extends Animal {
private BufferedImage[] imgs = new BufferedImage[6];
	private int i =0;
	public Herbivorous(double weight) {
		this.eatingRank=1;
                this.weight=weight;
                File file = new File("C:\\Users\\Adel\\Documents\\NetBeansProjects\\rivercrossing\\imgs\\Goat1.png");
               // System.out.println(file);
                
            try {
                imgs[i]=ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            }
               
	}
	

	@Override
	public boolean canSail() {
		return false;
	}

	@Override
	public double getWeight() {
		return weight;
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
		ICrosser Herbivorous = new Herbivorous(this.getWeight());
		Herbivorous.getImages();
		Herbivorous.setLabelToBeShown(this.getLabelToBeShown());
		return Herbivorous;
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
