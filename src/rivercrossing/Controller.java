/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rivercrossing;

/**
 *
 * @author Adel
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Controller implements IRiverCrossingController {
	ICrosser f = new Farmer(40);
	ICrosser h = new Herbivorous(20);
	ICrosser c = new Lion(20) ;
           
	
	ICrossingStrategy gameStrategy;
	private List<ICrosser> crossersOnRightBank;
	private List<ICrosser> crossersOnLeftBank;
	private int numberOfSails;
	private int ID;
	private boolean isOnTheLeft;
	private static Controller Instance = null;
	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
		crossersOnRightBank = new LinkedList<ICrosser>();
		crossersOnLeftBank = new LinkedList<ICrosser>();
		crossersOnLeftBank = this.gameStrategy.getInitialCrossers();
		numberOfSails = 0;
		isOnTheLeft = true;
	}

	@Override
	public void resetGame() {
		newGame(gameStrategy);
		
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
		if(gameStrategy.isValid(crossersOnRightBank, crossersOnLeftBank, crossers) == true) {
			return true;
		}
		return false;
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		if(crossers.size()==1) {
			if(fromLeftToRightBank) {
				crossersOnLeftBank.remove(crossers.get(0));
				crossersOnRightBank.add(crossers.get(0));
			}
			else {
				crossersOnRightBank.remove(crossers.get(0));
				crossersOnLeftBank.add(crossers.get(0));
			}
		}
		else {
			if(fromLeftToRightBank) {
				crossersOnLeftBank.remove(crossers.get(0));
				crossersOnLeftBank.remove(crossers.get(1));
				crossersOnRightBank.add(crossers.get(0));
				crossersOnRightBank.add(crossers.get(1));
			}
			else {
				crossersOnRightBank.remove(crossers.get(0));
				crossersOnRightBank.remove(crossers.get(1));
				crossersOnLeftBank.add(crossers.get(0));
				crossersOnLeftBank.add(crossers.get(1));
			}
		}
	}

	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	public boolean canRedo() {
		
		return false;
	}

	@Override
	public void undo() {
	
	}

	@Override
	public void redo() {

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
				for (int i = 0; i < list.getLength(); i++) {			
	            Node node = list.item(i);
			 
			   if ("leftcrossers".equals(node.getNodeName())) {
				   while (crossersOnLeftBank != null )
				   {
					   node.setTextContent(null); 
				   }
				
			   }
		
			   if ("rightcrossers".equals(node.getNodeName())) {
				   while (crossersOnRightBank != null )
				   {
					   node.setTextContent(null);
				   }
				
			   }
		
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
                if ("leftcrossers".equals(node.getNodeName())) {
                    System.out.println(node.getTextContent());
                    
                }
                if ("rightcrossers".equals(node.getNodeName())) {
                    System.out.println(node.getTextContent());
                    
                }
                if ("position".equals(node.getNodeName())) {
                	isOnTheLeft = Boolean.valueOf(node.getTextContent());
                    
                }
                if ("moves".equals(node.getNodeName())) {
                    numberOfSails = Integer.parseInt(node.getTextContent());
                }
            }	

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SAXException sae) {
            sae.printStackTrace();
        }
		
}
}