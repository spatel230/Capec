package xpath;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class CapecXPath {
    public static void display(String key) {
        try {
            DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
            DocumentBuilder db =dbf.newDocumentBuilder();
            Document d=db.parse("src\\data\\Attack_Patterns.xml");
            XPath xp= XPathFactory.newInstance().newXPath();
            NodeList nl=(NodeList)xp.compile("//Attack_Pattern").evaluate(d, XPathConstants.NODESET);
            System.out.println(nl.getLength()+" Attack Patterns searched.");
            String p = null;
            for (int i=0;i<nl.getLength();i++) {
				/* Print all Attack Patterns and Descriptions
				System.out.println("Name:" + xp.compile("./@Name").evaluate(nl.item(i)));
				System.out.println("Description: "+ xp.compile("./Description").evaluate(nl.item(i)));
				System.out.println("====");
				key="RFID";*/
                String x= xp.compile("./Description").evaluate(nl.item(i));
                if(x.contains(key)) {
                    NodeList nl2=(NodeList)xp.compile("//Attack_Pattern/Mitigations//Mitigation//xhtml:p").evaluate(d, XPathConstants.NODESET);
                    System.out.println(xp.compile(("./Mitigations//Mitigation//xhtml:p")));
                    p+="Attack Pattern: "+ xp.compile("./@ID").evaluate(nl.item(i))+"\nName: "+xp.compile("./@Name").evaluate(nl.item(i)) +"\nDescription: "+xp.compile("./Description").evaluate(nl.item(i))+"\nLikelihood Of Attack: "+xp.compile("./Likelihood_Of_Attack").evaluate(nl.item(i))+"\nSeverity: "+xp.compile("./Typical_Severity").evaluate(nl.item(i))+"\n\n";
                    //System.out.println("Attack Pattern: "+ xp.compile("./@ID").evaluate(nl.item(i))+"\nName: "+xp.compile("./@Name").evaluate(nl.item(i)) +"\nDescription: "+xp.compile("./Description").evaluate(nl.item(i))+"\nLikelihood Of Attack: "+xp.compile("./Likelihood_Of_Attack").evaluate(nl.item(i))+"\nSeverity: "+xp.compile("./Typical_Severity").evaluate(nl.item(i))+"\n");
                }
            }
            System.out.println(p);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
