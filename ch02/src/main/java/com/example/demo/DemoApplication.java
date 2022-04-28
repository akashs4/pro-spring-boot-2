package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = { ActiveMQAutoConfiguration.class, DataSourceAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Testbean getTestBean() {
		return new Testbean();
	}
}

class Testbean implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.err.println("this is test bean");
	}

}
