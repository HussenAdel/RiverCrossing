package rivercrossing;


import java.awt.image.BufferedImage;

public abstract class Carnivorous extends Animal {

	public Carnivorous(double weight) {
		this.eatingRank=2;
                this.weight=weight;
	}

	@Override
	public boolean canSail() {
		return false;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public int getEatingRank() {
		return eatingRank;
	}

}
