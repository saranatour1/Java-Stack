package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
// the class is a public class implementing HIPPA User 
public class Physician implements HIPAACompliantUser {
  //	member variables,  Patient notes, id, pin 
  private ArrayList < String > patientNotes;
  private int id;
  private int pin;
  private Integer confirmedAuthid;

  //    Constructor, with id   and empty ArrayList 
  public Physician(int id) {
    this.id = id;
    this.patientNotes = new ArrayList < String > ();
  }

  public void newPatientNotes(String notes, String patientName, Date date) {
    String report = String.format("Datetime Submitted: %s \n", date);
    report += String.format("Reported By id: %s\n", this.id);
    report += String.format("Patient Name: %s\n", patientName);
    report += String.format("Notes: %s \n", notes);
    this.patientNotes.add(report);
  }


  //   Pin must be exactly 4 digits, returns false if not.
  // Expected to assign the pin to the user (as a member variable)

@Override //auto?
  public boolean assignPin(int pin) {
    if (pin < 1000 || pin > 9999) {
      return false;
    }
    this.pin = pin;
    return true;
  }
  public boolean accessAuthorized(int id) {
    int val = this.id;
    return val == id;
  }
  //getters and setters 

  public ArrayList < String > getPatientNotes() {
    return patientNotes;
  }

  public void setPatientNotes(ArrayList < String > patientNotes) {
    this.patientNotes = patientNotes;
  }

  public int getid() {
    return id;
  }

  public void setid(int id) {
    this.id = id;
  }

  @Override
  public boolean accessAuthorized(Integer confirmedAuthID) {
    return this.id == confirmedAuthID;
  }

  // 50% done    
}

// I failed the tests 

// I passed the tests ^~^ 