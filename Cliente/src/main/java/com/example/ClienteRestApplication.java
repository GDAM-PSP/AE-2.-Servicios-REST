package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.modelo.negocio.ServicioProxyMensaje;

@SpringBootApplication
public class ClienteRestApplication implements CommandLineRunner {
	@Autowired
	private ServicioProxyMensaje spm;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClienteRestApplication.class, args);
	}

	public void run(String... args) throws Exception {
	}
}
