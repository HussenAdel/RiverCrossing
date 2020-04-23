package rivercrossing;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Wolf extends Carnivorous {

    public Wolf(double weight) {
       super(weight);
    }

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public BufferedImage[] getImages() {
		return null;
	}

	@Override
	public ICrosser makeCopy() {
		ICrosser wolf = new Wolf(this.getWeight());
		wolf.getImages();
		wolf.setLabelToBeShown(this.getLabelToBeShown());
		return wolf;
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
