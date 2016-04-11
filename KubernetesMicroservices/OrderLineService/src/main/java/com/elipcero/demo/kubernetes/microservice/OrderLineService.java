package com.elipcero.demo.kubernetes.microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderLineService {
	
	private static final Logger LOG = LoggerFactory.getLogger(OrderLineService.class);
	
	@RequestMapping("/orderlines/{number}")
    public OrderLineEntity getOrderLine(@PathVariable int number) {
		
		try {
		
			LOG.info("Get order line: {}", number);
			
			return new OrderLineEntity(number, "productName");
		
		}
		catch (Throwable e) {
			LOG.info("Get order line. Error {}", e);
	        throw e;
        }		
 	}
}
