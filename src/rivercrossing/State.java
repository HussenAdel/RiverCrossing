package rivercrossing;

import java.util.List;

public class State {

	private List<ICrosser> crossersOnRightBank;
	private List<ICrosser> crossersOnLeftBank;
	private int numOfSails;
	private boolean isOnTheLeft;

	public State(List<ICrosser> crossersOnRightBank, List<ICrosser> crossersOnLeftBank,
			int numOfSails, boolean isOnTheLeft) {

		this.crossersOnRightBank = crossersOnRightBank;
		this.crossersOnLeftBank = crossersOnLeftBank;
		this.numOfSails = numOfSails;
		this.isOnTheLeft = isOnTheLeft;
	}

	public List<ICrosser> getCrossersOnRightBank() {
		return crossersOnRightBank;
	}

	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		this.crossersOnRightBank = crossersOnRightBank;
	}

	public List<ICrosser> getCrossersOnLeftBank() {
		return crossersOnLeftBank;
	}

	public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
		this.crossersOnLeftBank = crossersOnLeftBank;
	}

	public int getNumOfSails() {
		return numOfSails;
	}

	public void setNumOfSails(int numOfMoves) {
		this.numOfSails = numOfMoves;
	}

	public boolean isOnTheLeft() {
		return isOnTheLeft;
	}

	public void setOnTheLeft(boolean isOnTheLeft) {
		this.isOnTheLeft = isOnTheLeft;
	}

}
