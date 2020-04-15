package xpath;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;

public class CapecXPath {
	public static void display(String key) {
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
				key="RFID";
				String x= xp.compile("./Description").evaluate(nl.item(i));
				if(x.contains(key)) {
					System.out.println("Attack Pattern: "+ xp.compile("./@ID").evaluate(nl.item(i))+"\nName: "+xp.compile("./@Name").evaluate(nl.item(i)) +"\nDescription: "
				+xp.compile("./Description").evaluate(nl.item(i)));
					System.out.println("Likelihood Of Attack: "+xp.compile("./Typical_Severity").evaluate(nl.item(i)));
				}
				}
			System.out.println();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
