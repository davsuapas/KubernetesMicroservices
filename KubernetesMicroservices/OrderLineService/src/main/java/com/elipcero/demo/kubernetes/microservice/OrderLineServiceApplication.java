package com.elipcero.demo.kubernetes.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderLineServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderLineServiceApplication.class, args);
    }
}
