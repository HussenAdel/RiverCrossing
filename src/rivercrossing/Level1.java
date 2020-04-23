package rivercrossing;
import java.util.ArrayList;
import java.util.List;

public class Level1 implements ICrossingStrategy {
	int i;
	ICrosser Crosser;
	ArrayList<ICrosser> list = new ArrayList(5);
        String label;
        int leftsize;
        int rightsize;
	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {
            leftsize=leftBankCrossers.size();
            rightsize=rightBankCrossers.size();
		if (boatRiders.size() == 0 || boatRiders.size() > 2)
                {
			return false;
                                }
		for (i = 0; i < boatRiders.size(); i++) {
			if (boatRiders.get(i).canSail()) {
				break;
			}
                        else if (i == (boatRiders.size() - 1)) {
				return false;
			}
		}
                for (i=0;i<leftBankCrossers.size();i++)
                {
                    if (leftBankCrossers.get(i).getEatingRank()==10&&boatRiders.size()==2)
                    {
                        leftsize=leftsize-2;
                      
                    }
                     if (leftBankCrossers.get(i).getEatingRank()==10&&boatRiders.size()==1)
                    {
                        leftsize=leftsize-1;
                    }
                    
                }
                       for (i=0;i<rightBankCrossers.size();i++)
                {
                    if (rightBankCrossers.get(i).getEatingRank()==10&&boatRiders.size()==2)
                    {
                        rightsize=rightsize-2;
                    }
                     if (rightBankCrossers.get(i).getEatingRank()==10&&boatRiders.size()==1)
                    {
                        rightsize=rightsize-1;
                    }
                    
                
                }
		if (rightsize > 1) {
                    
			for (i = 0; i < rightBankCrossers.size(); i++) {
                            if (rightBankCrossers.get(i)==boatRiders.get(0))
                            {
                                continue;
                            }
                            if (boatRiders.size()==2)
                            {
                                if (rightBankCrossers.get(i)==boatRiders.get(0))
                                {
                                    continue;
                                }
                            }
				if (rightBankCrossers.get(i).getEatingRank() == 1)
                                {
					return false;
                                }
			}
		}
		if (leftsize > 1) {
			for (i = 0; i < leftBankCrossers.size(); i++) {
                             if (leftBankCrossers.get(i)==boatRiders.get(0))
                            {
                                continue;
                            }
                            if (boatRiders.size()==2)
                            {
                                if (leftBankCrossers.get(i)==boatRiders.get(1))
                                {
                                    continue;
                                }
                            }
				if (leftBankCrossers.get(i).getEatingRank() == 1)
                                {
					return false;
                                }
                        }
		}
		return true;
	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		ICrosserFactory factory = new ICrosserFactory();
		Crosser = factory.makeICrosser("Farmer",60);
                label=String.valueOf(Crosser.getEatingRank());
                Crosser.setLabelToBeShown(label);
		list.add(Crosser);
		Crosser = factory.makeICrosser("Plant",10);
                label=String.valueOf(Crosser.getEatingRank());
                Crosser.setLabelToBeShown(label);
		list.add(Crosser);
		Crosser = factory.makeICrosser("Wolf",30);
                label=String.valueOf(Crosser.getEatingRank());
                Crosser.setLabelToBeShown(label);
		list.add(Crosser);
		Crosser = factory.makeICrosser("Herbivorous",20);
                label=String.valueOf(Crosser.getEatingRank());
                Crosser.setLabelToBeShown(label);
		list.add(Crosser);
		return list;
	}

	@Override
	public String[] getInstructions() {
		String[] Instructions = new String[10];
		String Instruction;
		Instruction = "1. The farmer is the only one who can sail the boat. He can only take one passenger, in addition to himself";
		Instructions[0] = Instruction;
		Instruction = "2. You can not leave any two crossers on the same bank if they can harm(eat) each other \n";
		Instructions[1] = Instruction;
                Instruction=" How can the farmer get across the river with all the 2 animals and the plant without any losses?";
                Instructions[2] = Instruction;
		return Instructions;
	}
	
}
