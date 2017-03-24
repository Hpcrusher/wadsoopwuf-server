package com.friends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/config/web-mvc-config.xml")
public class WadsoopwufServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WadsoopwufServerApplication.class, args);
	}
}
