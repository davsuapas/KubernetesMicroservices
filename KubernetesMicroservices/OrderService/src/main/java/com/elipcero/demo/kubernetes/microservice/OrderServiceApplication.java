package com.elipcero.demo.kubernetes.microservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class OrderServiceApplication implements CommandLineRunner {
	
    private static final Logger LOG = LoggerFactory.getLogger(OrderServiceApplication.class);
    
    @Autowired
    private ConnectionFactory connectionFactory;    
	
    public void run(String... args) {
        LOG.info("Create RabbitMqCF for host: {}", connectionFactory.getHost());
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
