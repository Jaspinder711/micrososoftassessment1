package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

@RestController
public class OrderServiceController {
	
	private static final String MESSAGE_QUEUE = "orders_queue";
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	JmsTemplate jms;

	@GetMapping("/orders")
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("/orders/{id}")
	public Order getOrder(@RequestParam("id") Integer id) {
		return orderService.getOrderById(id);
	}
	
	@PostMapping("/saveorder")
	public void saveOrder(@RequestBody Order order) {
		orderService.saveOrUpdate(order);
		jms.convertAndSend(MESSAGE_QUEUE,order);
	}
	
	@PutMapping("/updateOrder")
	public void updateOrder(@RequestBody Order order) {
		orderService.update(order);
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public void deleteOrder(@RequestParam("id") Integer id) {
		orderService.deleteOrder(id);
	}
}
