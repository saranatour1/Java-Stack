package com.paintings.Art;

import java.util.ArrayList;

//inside of Museum.java
public class Museum {
	public static void main(String[] args) {
		// TODO: create paintings and sculptures here
		// ArrayList<Art> museum = new ArrayList<Art> ();
		// Create 3 instances of Painting
		Painting oil = new Painting("oil", "Davinci", "Davanci", " Weehehehhehe ");
		Painting Watercolor = new Painting("watercolor", "Something", " kolooo", "jejeje");
		Painting acrylic = new Painting("acrylic", "newSomething", "HAh", "kal");

		oil.viewArt();
		Watercolor.viewArt();
		acrylic.viewArt();

		// Create 2 instances of Scupture
		Sculpture marble = new Sculpture("Marble", "Whwhwhwh", "Someone1", "kk");
		Sculpture bronze = new Sculpture(" Bronze", "Weeeeeeee", "Someone2", "kk2");

		marble.viewArt();
		bronze.viewArt();
		// System.out

		System.out.println("xx Welcome to the museum! xx");

	}
}
