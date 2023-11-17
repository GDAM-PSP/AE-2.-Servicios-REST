package es.ae2.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"es.ae2"})
public class InicializadorApp {

	public static void main(String[] args) {
		SpringApplication.run(InicializadorApp.class, args);
	}

}
