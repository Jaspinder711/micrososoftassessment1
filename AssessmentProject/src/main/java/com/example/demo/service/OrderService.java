package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	public List<Order> getAllOrders(){
		List<Order> orders = new ArrayList<Order>();
		repo.findAll().forEach(order -> orders.add(order));
		return orders;
	}
	
	public Order getOrderById(Integer id) {
		return repo.findById(id).get();
	}
	
	public void saveOrUpdate(Order order) {
		repo.save(order);
	}
	
	public void deleteOrder(Integer id) {
		repo.deleteById(id);
	}
	
	public void update(Order order) {
		repo.save(order);
	}
}
