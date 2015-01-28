package com.bitcamp.mustafademovic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonReader {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilder docReader;

		docReader = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document xmldoc = docReader.parse(new File("./XML/people.xml"));
		NodeList xmlPeople = xmldoc.getElementsByTagName("person");
		LinkedList<Person> people = new LinkedList<Person>();

		for (int i = 0; i < xmlPeople.getLength(); i++) {
			Node current = xmlPeople.item(i);
			if (current instanceof Element) {
				Element currentOfElement = (Element) current;
				String name = currentOfElement.getAttribute("name");
				String lastName = currentOfElement.getAttribute("lastName");
				Person currentPerson = new Person(name, lastName);
				people.add(currentPerson);

				if (currentOfElement.hasChildNodes()) {
					NodeList childNodes = currentOfElement.getChildNodes();
					for (int j = 0; j < childNodes.getLength(); j++) {
						Node currentChild = childNodes.item(j);
						if (currentChild instanceof Element) {
							Element currentOfElementChild = (Element) currentChild;
							String nameChild = currentOfElementChild.getAttribute("name");
							Person currentPersonChild = new Person(nameChild, lastName);
							people.add(currentPersonChild);
						}
					}

				}
			}

			Iterator<Person> it = people.iterator();
			while (it.hasNext()) {
				Person next = it.next();
				System.out.println(next.toString());
				if(next.hasChild())
					System.out.println("\t" + next.writeChild());
				
				
			}
		}
	}
}
