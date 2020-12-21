package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

public class Address {

	@Column
	private String state;
	
	@Column
	private Integer pin;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if(state==null || state.isEmpty()) throw new IllegalStateException("State is a required field");
		this.state = state;
	}

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		if( pin < 0) throw new IllegalStateException("Invalid pin");
		this.pin = pin;
	}
	
	
}
