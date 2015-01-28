package com.bitcamp.mustafademovic;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;

public class TestClass {
	public static void main(String[] args) {
		
		Person mustafa = new Person("Mustafa", "Ademovic");
		Person vedad = new Person("Vedad", "Zornic");
		Person emir = new Person("Emir", "Imamovic");
		Person gordan = new Person("Gordan", "Sajevic");
		
		mustafa.addChild(new Person("Mujo"));
		vedad.addChild(new Person("Haso"));
		emir.addChild(new Person("Emir"));
		gordan.addChild(new Person("Goro"));
		
		LinkedList<Person> person = new LinkedList<Person>();
		person.add(mustafa);
		person.add(vedad);
		person.add(emir);
		person.add(gordan);
		//System.out.println(person.toString());
		
		try {
			Person.personToXML(person,new FileOutputStream("./XML/people.xml"));
		} catch (FileNotFoundException e) {
		
		System.out.println(e.getMessage());
		}
		
		
		
	}

	
}
