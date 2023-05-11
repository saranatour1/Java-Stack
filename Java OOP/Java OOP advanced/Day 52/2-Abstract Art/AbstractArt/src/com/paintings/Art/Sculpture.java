package com.paintings.Art;

//inside of Sculpture.java
public class Sculpture extends Art {
	// TODO: implement Sculpture class
	// //The sculpture class should also inherit from Art, and it should contain a
	// new member variable called material
	// (ex. Marble, Bronze, Porcelain, etc.).
	// Create a Sculpture class that inherits Art and has an additional member
	// variable material

	protected String material;

	// Constructor for Sculptur
	public Sculpture(String material, String title, String author, String description) {
		super(title, author, description);
		this.material = material;
	}

	@Override
	public void viewArt() {
		// TODO Auto-generated method stub
		System.out.println("This is a Sculpture, it has the following material Type " + this.material
				+ ", the title is " + super.title + ", the author is " + super.author
				+ ", and the description is " + super.descreption);
	}

}
