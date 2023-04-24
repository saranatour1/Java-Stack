package com.paintings.Art;

import java.util.ArrayList;

/*
 * 
 * 
 * The Art class should have the following member variables and an abstract 
 * method called viewArt(). The viewArt() method 
 * should be implemented in the child classes and will be used 
 * to print information about the artwork.
 * 
 * 
 * String title
String author
String description
 * 
 * */

// inside of Art.java
//Member Variables 
public abstract class Art {
    // TODO: implement Art class
	protected String title; 
	protected String author;
	protected String descreption; 
	// private ArrayList <String> values; 
	
	// Constructor 	
	public Art(String title, String author, String descreption) {
		super();
		this.title = title;
		this.author = author;
		this.descreption = descreption;
//		this.values = values;
		// this.values = new ArrayList <String> ();
		
	}
	
//	Create an abstract method called viewArt()
public abstract void viewArt();





	
}
