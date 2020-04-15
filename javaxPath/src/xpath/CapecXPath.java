package xpath;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;

public class CapecXPath {
	public static void display() {
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db =dbf.newDocumentBuilder();
			Document d=db.parse("src\\data\\Attack_Patterns.xml");
			XPath xp= XPathFactory.newInstance().newXPath();
			NodeList nl=(NodeList)xp.compile("//Attack_Pattern").evaluate(d, XPathConstants.NODESET);
			System.out.println(nl.getLength()+" Attack Patterns searched.");
			for (int i=0;i<nl.getLength();i++) {
				/* Print all Attack Patterns and Descriptions
				System.out.println("Name:" + xp.compile("./@Name").evaluate(nl.item(i)));
				System.out.println("Description: "+ xp.compile("./Description").evaluate(nl.item(i)));
				System.out.println("===="); */
				String x= xp.compile("./Description").evaluate(nl.item(i));
				if(x.contains("RFID")) {
					System.out.println("Name: "+xp.compile("./@Name").evaluate(nl.item(i)) +"\nDescription: "
				+xp.compile("./Description").evaluate(nl.item(i))+"\nLikelihood Of Attack: "+xp.compile("./Likelihood_Of_Attack").evaluate(nl.item(i)));
				}
				}
			System.out.println();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
