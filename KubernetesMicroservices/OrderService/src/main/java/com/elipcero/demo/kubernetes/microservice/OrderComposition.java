package com.elipcero.demo.kubernetes.microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class OrderComposition {
	
    @Autowired
    private LoadBalancerClient loadBalancer;
    
    private static final Logger LOG = LoggerFactory.getLogger(OrderComposition.class);    
    
    private RestTemplate restTemplate = new RestTemplate();
	
	@HystrixCommand(fallbackMethod = "defaultOrder")
    public OrderEntity getOrder(int number) {
		 
		LOG.info("Get order: {}", number);
		
		OrderEntity order = new OrderEntity(number);
	
		String url = loadBalancer.choose("orderline").getUri() + "/orderlines/" + number;
		
		LOG.info("Get order line for order: {}", url);
	    
	    order.getOrderLines().add(restTemplate.getForEntity(url, OrderLineEntity.class).getBody());
	    
	    LOG.info("Return order with lines number: {}", order.getOrderLines().size());
	    
	    OrderLineEntity line = order.getOrderLines().stream().findFirst().get();
	    
	    LOG.info("Return order number : {}", order.getNumber());
	    LOG.info("Return order line number : {}", line.getNumber());
	    LOG.info("Return order line product : {}", line.getProductName());
					
		return order;
 	}
	
	public OrderEntity defaultOrder(int number) {
        LOG.info("Using fallback method for order service");
        return new OrderEntity(number); 
    }	
}
