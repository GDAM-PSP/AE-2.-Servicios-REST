package es.ae2.servidor.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"es.ae2.servidor"})
public class InicializadorApp {

	public static void main(String[] args) {
		SpringApplication.run(InicializadorApp.class, args);
	}

}
