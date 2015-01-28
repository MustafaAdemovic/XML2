package com.bitcamp.mustafademovic;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class Person {
	private String name;
	private String lastName;
	private LinkedList<Person> children;

	public Person(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
		children = new LinkedList<>();
	}
	public Person(String name){
		this.name = name;
		children = new LinkedList<>();
	}

	public void addChild(Person p) {
		children.add(p);
	}

	public boolean hasChild() {
		if (children.isEmpty()) 
			return false;
		
		return true;
	}
	public String writeChild(){
		
		return "Children: "  + children.toString();
	}

	public String toString() {
		return name + " " + lastName;
	}

	public static void personToXML(List<Person> persons, OutputStream os) {
		PrintWriter pw = new PrintWriter(os);
		pw.println("<?xml version =\"1.0\" ?>");
		pw.println("<people>");
		Iterator<Person> it = persons.iterator();
		Person temp = null;
		while (it.hasNext()) {
			temp = it.next();
			pw.println(" <person name = '" + temp.name + "'" + " lastName = '" + temp.lastName + "'" + " >");
			Iterator<Person> itChildern = temp.children.iterator();
			Person tempChildern = null;
			
			while(itChildern.hasNext()) {
				tempChildern = itChildern.next();
				pw.println("  <child name = '" + tempChildern.name + "'" + " lastName = '" + temp.lastName + "'" + " />");
			}
			pw.println("</person>");
		}
		
		
		pw.println("</people>");
		pw.flush();
	}

}
