package com.caresoft.clinicapp;
// I think i am missing the interface here !  but maybe not! 
public class User  implements HIPAACompliantUser{
	// the 'class members' for the User class 
	protected Integer id;
	protected int pin;

	//this was Auto generated
	public User(Integer id){
		this.id = id;
	}

	//getter method for the Id 
	// Note :: These Were Auto Generated
	public Integer getId() {
			return id;
	}
	//Setter method for the id
	public void setId(Integer id) {
		this.id = id;
	}
	// getter method for the pin 
	public int getPin() {
		return pin;
	}
	// setter method for the pin 
	public void setPin(int pin) {
		this.pin = pin;
	}

	// Although unneeeded, Would not execute without them! 
	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TODO Auto-generated method stub
		return false;
	}    
}

