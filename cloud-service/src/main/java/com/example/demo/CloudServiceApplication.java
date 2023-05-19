package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudServiceApplication.class, args);
	}

}

@RestController
class FirstController {

	@Autowired
	Environment environment;
	@GetMapping("/welcome")
	public String welcome(HttpServletRequest request) {
		String str1 = String.format("%s\n%s\n%s",
				environment.getProperty("spring.application.name"),
				request.getServerName(),
				request.getServerPort());
		return str1;
	}
}
