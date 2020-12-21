package com.ram.model;

import java.io.Serializable;

public class Order implements Serializable{

	private int id;

	private double price;

	private String state;

	private int pin;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		if(id < 0) throw new IllegalStateException("Id is required field");
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if(price < 0) throw new IllegalStateException("Price is required field");
		this.price = price;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		if(state==null || state.isEmpty()) throw new IllegalStateException("State is a required field");
		this.state = state;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		if( pin < 0) throw new IllegalStateException("Invalid pin");
		this.pin = pin;
	}
	
	
	
	
}
