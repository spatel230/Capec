package com.stephanie.mycapec.models;

import java.util.Date;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usecases")
public class UseCase {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private Date updated;

    private String mitigation;

	public UseCase() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UseCase(String title, String content, Date updated) {
		super();
		this.title = title;
		this.content = content;
		this.updated = updated;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		String p=null;
		try {
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db =dbf.newDocumentBuilder();
			Document d=db.parse("src\\data\\Attack_Patterns.xml");
			XPath xp= XPathFactory.newInstance().newXPath();
			NodeList nl=(NodeList)xp.compile("//Attack_Pattern").evaluate(d, XPathConstants.NODESET);
			//System.out.println(nl.getLength()+" Attack Patterns searched.");
			for (int i=0;i<nl.getLength();i++) {
				/* Print all Attack Patterns and Descriptions
				System.out.println("Name:" + xp.compile("./@Name").evaluate(nl.item(i)));
				System.out.println("Description: "+ xp.compile("./Description").evaluate(nl.item(i)));
				System.out.println("====");*/
				String x= xp.compile("./Description").evaluate(nl.item(i));
				if(x.contains(title)) {
					p+="Attack Pattern: "+ xp.compile("./@ID").evaluate(nl.item(i))+"\nName: "+xp.compile("./@Name").evaluate(nl.item(i)) +"\nDescription: "+xp.compile("./Description").evaluate(nl.item(i))+"\nLikelihood Of Attack: "+xp.compile("./Likelihood_Of_Attack").evaluate(nl.item(i))+"\nSeverity: "+xp.compile("./Typical_Severity").evaluate(nl.item(i))+"\n\n";
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		content=p;
		this.content = content;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	

}
