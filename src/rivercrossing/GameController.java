package rivercrossing;
import java.beans.Beans;
import java.util.Stack;
import org.w3c.dom.NodeList;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;





import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import sun.awt.SunToolkit;

public class GameController implements IRiverCrossingController {
	Stack<State> undo, redo;
	ICrossingStrategy gameStrategy;
	private List<ICrosser> crossersOnRightBank;
	private List<ICrosser> crossersOnLeftBank;
	private int numberOfSails;
	private boolean isOnTheLeft;
	private State currentState;
	private static GameController Instance = null;

	private GameController() {

	}

	public static GameController getInstance() {
		if (Instance == null)
			Instance = new GameController();
		return Instance;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
		crossersOnRightBank = new ArrayList<ICrosser>();
		crossersOnLeftBank = new ArrayList<ICrosser>();
		crossersOnLeftBank = this.gameStrategy.getInitialCrossers();
		numberOfSails = 0;
		isOnTheLeft = true;
		undo = new Stack<State>();
		redo = new Stack<State>();
		currentState = new State(crossersOnRightBank, crossersOnLeftBank, numberOfSails, isOnTheLeft);
	}

	@Override
	public void resetGame() {
            if (gameStrategy instanceof Level1)
            {
		crossersOnRightBank = new ArrayList<ICrosser>();
		crossersOnLeftBank = new ArrayList<ICrosser>();
		crossersOnLeftBank = new Level1().getInitialCrossers();
		numberOfSails = 0;
		isOnTheLeft = true;
		undo = new Stack<State>();
		redo = new Stack<State>();
		currentState = new State(crossersOnRightBank, crossersOnLeftBank, numberOfSails, isOnTheLeft);
            }
            else
            {
            
              crossersOnRightBank = new ArrayList<ICrosser>();
		crossersOnLeftBank = new Level2().getInitialCrossers();
		numberOfSails = 0;
		isOnTheLeft = true;
		undo = new Stack<State>();
		redo = new Stack<State>();
		currentState = new State(crossersOnRightBank, crossersOnLeftBank, numberOfSails, isOnTheLeft);
            }
	}

	@Override
	public String[] getInstructions() {
		return gameStrategy.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return crossersOnRightBank;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return crossersOnLeftBank;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return isOnTheLeft;
	}

	@Override
	public int getNumberOfSails() {
		return numberOfSails;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		 if (gameStrategy.isValid(crossersOnRightBank, crossersOnLeftBank, crossers))
			 return true;
		 return false;
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
            System.out.println("CurrentState");
            System.out.println("Sails : " + currentState.getNumOfSails());
            System.out.println("isontheleft : " + 
                    currentState.isOnTheLeft());
    
		undo.push(currentState);
		List<ICrosser> newCrossersOnRightBank = new ArrayList<ICrosser>();
		List<ICrosser> newCrossersOnLeftBank = new ArrayList<ICrosser>();
		for (int i = 0; i < crossersOnLeftBank.size(); ++i)
			newCrossersOnLeftBank.add(crossersOnLeftBank.get(i));
		for (int i = 0; i < crossersOnRightBank.size(); ++i)
			newCrossersOnRightBank.add(crossersOnRightBank.get(i));
		crossersOnLeftBank = newCrossersOnLeftBank;
		crossersOnRightBank = newCrossersOnRightBank;

		if (fromLeftToRightBank) {
			for (int i = 0; i < crossers.size(); i++) {
				crossersOnLeftBank.remove(crossers.get(i));
				crossersOnRightBank.add(crossers.get(i));
			}
			isOnTheLeft = false;
		} else {
			for (int i = 0; i < crossers.size(); i++) {
				crossersOnRightBank.remove(crossers.get(i));
				crossersOnLeftBank.add(crossers.get(i));
			}
			isOnTheLeft = true;
		}
		numberOfSails++;
		currentState = new State(crossersOnRightBank, crossersOnLeftBank, numberOfSails, isOnTheLeft);
	}

	@Override
	public boolean canUndo() {
		if (undo.isEmpty())
			return false;
		return true;
	}

	@Override
	public boolean canRedo() {
		if (redo.isEmpty())
			return false;
		return true;
	}

	@Override
	public void undo() {
		redo.push(currentState);
		currentState = undo.pop();
		crossersOnRightBank = currentState.getCrossersOnRightBank();
		crossersOnLeftBank = currentState.getCrossersOnLeftBank();
		numberOfSails = currentState.getNumOfSails();
		isOnTheLeft = currentState.isOnTheLeft();
	}

	@Override
	public void redo() {
		undo.push(currentState);
		currentState = redo.pop();
		crossersOnRightBank = currentState.getCrossersOnRightBank();
		crossersOnLeftBank = currentState.getCrossersOnLeftBank();
		numberOfSails = currentState.getNumOfSails();
		isOnTheLeft = currentState.isOnTheLeft();
	}
        @Override
        public void saveGame() {

		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse("scene.xml");

			Node river = doc.getFirstChild();
			Node bank = doc.getElementsByTagName("bank").item(0);
			NodeList list = bank.getChildNodes();
			System.out.println(list.getLength());
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if ("level".equals(node.getNodeName())) {
					if (gameStrategy instanceof Level1) {
						node.setTextContent("1");
					} else {
						node.setTextContent("2");
					}
				}
				if ("leftcrossers".equals(node.getNodeName())) {
					if (gameStrategy instanceof Level1) {
						for (int a = 0; a < crossersOnLeftBank.size(); ++a) {
							String eatingRank = Integer.toString(crossersOnLeftBank.get(a).getEatingRank());
							node.setTextContent(node.getTextContent() + eatingRank + " ");
						}
					} else {
						for (int b = 0; b < crossersOnLeftBank.size(); ++b) {
							String weight = Double.toString(crossersOnLeftBank.get(b).getWeight());
							node.setTextContent(node.getTextContent() + weight + " ");
						}

					}
				}

				if ("rightcrossers".equals(node.getNodeName())) {
					if(crossersOnRightBank.isEmpty())
					{
						node.setTextContent("");
						break;
					}
					if (gameStrategy instanceof Level1) {
						for (int a = 0; a < crossersOnRightBank.size(); ++a) {
							String eatingRank = Integer.toString(crossersOnRightBank.get(a).getEatingRank());
							node.setTextContent(node.getTextContent() + eatingRank + " ");
						}
					} else {
						for (int b = 0; b < crossersOnRightBank.size(); ++b) {
							String weight = Double.toString(crossersOnRightBank.get(b).getWeight());
							node.setTextContent(node.getTextContent() + weight  + " ");
						}

					}

				}
				System.out.println(node.getNodeName());

				if ("position".equals(node.getNodeName())) {
					node.setTextContent(Boolean.toString(isOnTheLeft));
				}
				if ("moves".equals(node.getNodeName())) {
					node.setTextContent(Integer.toString(numberOfSails));
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("scene.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}

	@Override
	public void loadGame() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse("scene.xml");
			Node River = doc.getFirstChild();
			Node bank = doc.getElementsByTagName("bank").item(0);
			NodeList list = bank.getChildNodes();
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				if ("level".equals(node.getNodeName())) {
					int f = Integer.parseInt(node.getTextContent());
					if (f == 1)
						newGame(new Level1());
					else
						newGame(new Level2());
				}
				
				  if ("leftcrossers".equals(node.getNodeName())) { 
					 node.setTextContent("");
					  }
				 
				if ("rightcrossers".equals(node.getNodeName())) {
						if(node.getTextContent().equals(""))
							break;
					String r = node.getTextContent();
					String[] ra = r.split(" ");
						
					if (gameStrategy instanceof Level1) {
						for (int o = 0; o < ra.length; o++) {
							int eatingRank = Integer.parseInt(ra[o]);
							for (int j = 0; j < crossersOnLeftBank.size(); ++j) {
								if (crossersOnLeftBank.get(j).getEatingRank() == eatingRank) {
									crossersOnRightBank.add(crossersOnLeftBank.get(j));
									crossersOnLeftBank.remove(j);
								}
							}

						}

					} else {
						for (int o = 0; o < ra.length; o++) {
							double weight = Double.parseDouble(ra[o]);
							for (int j = 0; j < crossersOnLeftBank.size(); ++j) {
								if (crossersOnLeftBank.get(j).getWeight() == weight) {
									crossersOnRightBank.add(crossersOnLeftBank.get(j));
									crossersOnLeftBank.remove(j);
								}
							}

						}
					}
					node.setTextContent("");
					
				}
				if ("position".equals(node.getNodeName())) {
					isOnTheLeft = Boolean.valueOf(node.getTextContent());

				}
				if ("moves".equals(node.getNodeName())) {
					numberOfSails = Integer.parseInt(node.getTextContent());
				}
			}
                        currentState.setNumOfSails(numberOfSails);
                        currentState.setOnTheLeft(isOnTheLeft);
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("scene.xml"));
			transformer.transform(source, result);

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
			
        }		
}

