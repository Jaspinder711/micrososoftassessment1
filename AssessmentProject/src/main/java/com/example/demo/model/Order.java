package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_service")
public class Order implements Serializable{

	@Id
	@Column
	private Integer id;
	
	@Column 
	private Double price;

	@Column
	private String state;

	@Column
	private Integer pin;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if(id < 0) throw new IllegalStateException("Id is required field");
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
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

	public Integer getPin() {
		return pin;
	}

	public void setPin(Integer pin) {
		if( pin < 0) throw new IllegalStateException("Invalid pin");
		this.pin = pin;
	}
	
	
	
	
}
