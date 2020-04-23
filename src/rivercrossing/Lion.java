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

public class Lion extends Carnivorous {
private BufferedImage[] imgs = new BufferedImage[6];
      private int i=0;
      
    /**
     *
     * @param weight
     */
    public Lion (double weight) {
        super(weight);
           File file = new File("C:\\Users\\Adel\\Documents\\NetBeansProjects\\rivercrossing\\imgs\\tr1.png");
               // System.out.println(file);
                
            try {
                imgs[i]=ImageIO.read(file);
            } catch (IOException ex) {
                Logger.getLogger(Farmer.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

	@Override
	public double getWeight() {
		return weight;
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
		ICrosser lion = new Lion(this.getWeight());
		lion.setLabelToBeShown(this.getLabelToBeShown());
		lion.getImages();
		return lion;
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
