package com.inventory_management;

import com.inventory_management.config.Initializer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagementApplication {

	private final Initializer initiator;


	public InventoryManagementApplication(Initializer initiator) {
		this.initiator = initiator;
	}

	public static void main(String[] args) {
		SpringApplication.run(InventoryManagementApplication.class, args);
	}
	@PostConstruct
	public void init() {
		initiator.initial();
	}

}
