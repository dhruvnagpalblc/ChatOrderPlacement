package com.hk.chatOrderPlacement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ChatOrderPlacementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatOrderPlacementApplication.class, args);
	}

}
