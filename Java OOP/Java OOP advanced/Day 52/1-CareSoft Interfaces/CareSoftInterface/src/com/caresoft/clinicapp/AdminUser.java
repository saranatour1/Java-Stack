package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

//  it implements both the admin and user HIPPA intefaces.
public class AdminUser implements HIPAACompliantUser, HIPAACompliantAdmin {
	private Integer employeeID;
	private String role;
	private ArrayList<String> securityIncidents;
	private int pin;
	private Integer confirmedAuthID;

	// The AdminUser class implements the HIPAACompliantUser interface in the
	// following ways:
	// boolean assignPIN(int) ::Pin must be 6 digits or more; returns false if not
	// Expected to assign the pin to the user (as a member variable)

	public AdminUser(Integer employeeID, String role) {
		this.employeeID = employeeID;
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}

	// check if the pin is less than 6 digits return false , else assign it to the
	// object, and return true.
	@Override
	public boolean assignPin(int pin) {
		if (pin < 100000) { // 12345
			return false;
		}
		this.pin = pin;
		return true;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (!this.employeeID.equals(confirmedAuthID)) {
			this.authIncident();
			return false;
		}
		return true;
	}

	// return the Security Incedent
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}

	// new incidents
	public void newIncident(String notes) {
		String report = String.format(
				"Datetime Submitted: %s \nReported By ID: %s\nNotes: %s \n",
				new Date(), this.employeeID, notes);
		securityIncidents.add(report);
	}

	// athorization check, with date
	public void authIncident() {
		String report = String.format(
				"Datetime Submitted: %s \nID: %s\nNotes: %s \n",
				new Date(), this.employeeID, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}

	// getters for employerID
	public Integer getEmployeeID() {
		return employeeID;
	}

	// setter for setEmployeeID
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	// getter for GetRole
	public String getRole() {
		return role;
	}

	// setter for setRole
	public void setRole(String role) {
		this.role = role;
	}

	// retrun securityIncidents
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	// setter for Security incidents
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

	// getter for pen
	public int getPin() {
		return pin;
	}

	// setter for pin
	public void setPin(int pin) {
		this.pin = pin;
	}

	// getter confirmationID
	public Integer getConfirmedAuthID() {
		return confirmedAuthID;
	}

	// Setter ConfirmationID
	public void setConfirmedAuthID(Integer confirmedAuthID) {
		this.confirmedAuthID = confirmedAuthID;
	}
}
