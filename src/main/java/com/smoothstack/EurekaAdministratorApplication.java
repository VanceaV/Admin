package com.smoothstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class EurekaAdministratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAdministratorApplication.class, args);
	}

}
