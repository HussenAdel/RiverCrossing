package rivercrossing;


import java.util.ArrayList;
import java.util.List;

public class Level2 implements ICrossingStrategy {
	private ICrosser Crosser;
	private ArrayList<ICrosser> list = new ArrayList(15);
        private String label;

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {
		if (boatRiders.size() == 0 || boatRiders.size() > 2)
			return false;
		else if (boatRiders.size() == 1) {
			if (!boatRiders.get(0).canSail() || boatRiders.get(0).getWeight() > 100) {
				return false;
			}
		} else if (boatRiders.size() == 2) {
			if ((!boatRiders.get(0).canSail() && !boatRiders.get(1).canSail())
					|| (boatRiders.get(0).getWeight() + boatRiders.get(1).getWeight()) > 100)
				return false;
		}
		return true;
	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		ICrosserFactory factory = new ICrosserFactory();
		Crosser = factory.makeICrosser("Farmer",90);
                int c=(int) Math.round(Crosser.getWeight());
                label=String.valueOf(c);
                Crosser.setLabelToBeShown(label);
		list.add(Crosser);
		Crosser = factory.makeICrosser("Farmer",80);
               c=(int) Math.round(Crosser.getWeight());
                label=String.valueOf(c);
                Crosser.setLabelToBeShown(label);;
		list.add(Crosser);
		Crosser = factory.makeICrosser("Farmer",60);
                 c=(int) Math.round(Crosser.getWeight());
                label=String.valueOf(c);
                Crosser.setLabelToBeShown(label);
		list.add(Crosser);
		Crosser = factory.makeICrosser("Farmer",40);
                 c=(int) Math.round(Crosser.getWeight());
                label=String.valueOf(c);
                Crosser.setLabelToBeShown(label);
		list.add(Crosser);
		Crosser = factory.makeICrosser("Herbivorous",20);
                 c=(int) Math.round(Crosser.getWeight());
                label=String.valueOf(c);
                Crosser.setLabelToBeShown(label);
		list.add(Crosser);
		return list;
	}

	@Override
	public String[] getInstructions() {
		String[] Instructions = new String[10];
		String Instruction;
		Instruction = "1 . The boat cannot bear a load heavier than 100 kg";
		Instructions[0] = Instruction;
		Instruction = "2 . All farmers can raft, while the animal cannot";
		Instructions[1] = Instruction;
                Instruction="How can they all get to the other side with their animal? ";
                Instructions[2]=Instruction;
		return Instructions;
	}
}
