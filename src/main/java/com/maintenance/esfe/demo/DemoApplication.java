package com.maintenance.esfe.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		// Cargar las variables de entorno
        Dotenv dotenv = Dotenv.configure().load();

        // Configurar las variables de entorno en el sistema
        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });

        SpringApplication.run(DemoApplication.class, args);
	}

}
