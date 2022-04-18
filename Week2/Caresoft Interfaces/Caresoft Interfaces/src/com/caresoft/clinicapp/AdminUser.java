package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	
//... imports class definition...
    
    // Inside class:
    private String role;
    private ArrayList<String> securityIncidents;
    
    // TO DO: Implement a constructor that takes an ID and a role
    
    public AdminUser(Integer id, String role) {
		// TODO Auto-generated constructor stub
    	super(id);
    	this.role = role;
    	this.securityIncidents = new ArrayList<String>();
	}
    
    // TO DO: Implement HIPAACompliantUser!
    
    public boolean accessAuthorized(Integer id) {
    	if (id != this.id) {
    		this.authIncident();
    		return false;
    	}
    	else {
    		return true;
    	}
    }
    
    // TO DO: Implement HIPAACompliantAdmin!
    
    public ArrayList<String> reportSecurityIncidents() {
    	return this.securityIncidents;
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    public boolean assignPin(int pin) {
    	if (pin < 100000 || pin > 999999) {
    		return false;
    	}
    	else {
    		this.pin = pin;
    		return true;
    	}
    }
    

    
    // TO DO: Setters & Getters

	
}
