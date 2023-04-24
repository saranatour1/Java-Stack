package com.paintings.Art;


//he painting class should inherit from Art, 
//and it should also contain a new member variable called paintType (ex. Oil, Watercolor, Acrylic, etc.).


//inside of Painting.java
public class Painting extends Art {
	// TODO: implement Painting class
	private String paintType;
	// Constructor

	public Painting(String paintType, String title, String author, String description) {
		// super(paintType, paintType, paintType, values<String>); // why ?
		super(title, author, description);
		this.paintType = paintType;
	}
	
	//Getter for paintType 
	public String getPaintType() {
		return paintType;
	}
	
	// Setter for paintType
	public void setPaintType(String paintType) {
		this.paintType = paintType;
	}

	@Override
	public void viewArt() {
			System.out.println("This is a painting, it has the following paint Type " + this.paintType 
					+ ", the title is " + super.title + ", the author is " + super.author 
					+ ", and the description is " + super.descreption);
	}
	
	
	
}
