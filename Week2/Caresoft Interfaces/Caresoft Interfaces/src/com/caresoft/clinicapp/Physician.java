package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	
	public Physician(Integer id) {
		super(id);
	}
	
	@Override
	public boolean assignPin(int pin) {
		if (pin < 1000 || pin > 9999) {
			return false;
		}
		else {
			this.pin = pin;
			return true;
		}
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id == confirmedAuthID) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters
    
    @Override
    public Integer getId() {
    	// TODO Auto-generated method stub
    	return super.getId();
    }
    
    @Override
    public int getPin() {
    	// TODO Auto-generated method stub
    	return super.getPin();
    }
    
    public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}
    
    @Override
    public void setId(Integer id) {
    	// TODO Auto-generated method stub
    	super.setId(id);
    }
    
    @Override
    public void setPin(int pin) {
    	// TODO Auto-generated method stub
    	super.setPin(pin);
    }
    
    public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

	

	
}
