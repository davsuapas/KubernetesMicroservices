package com.elipcero.demo.kubernetes.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class OrderService {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderComposition orderComposition; 
    
    @RequestMapping("/")
    public String getOrder() {
        return "{\"timestamp\":\"" + new Date() + "\",\"content\":\"Hello from getOrder()\"}";
    }
	
	@RequestMapping("/orders/{number}")
    public OrderEntity getOrder(@PathVariable int number) {
	
		LOG.info("Get order: {}", number);
		
		return this.orderComposition.getOrder(number);
 	}
}
