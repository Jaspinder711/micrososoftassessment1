package com.ram.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ram.model.Order;
import com.ram.model.Product;

@Component
public class MessageReceiver
{
	private static final String MESSAGE_QUEUE = "orders_queue";
	
	@JmsListener(destination = MESSAGE_QUEUE)
	public void receiveMessage(Order order)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Received " + order);
	}
	@JmsListener(destination = "queue2")
	public void receiveMessageFromQueue2(Product product)
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Received " + product);
	}
}
