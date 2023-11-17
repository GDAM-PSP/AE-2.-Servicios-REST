package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.modelo.entidad.Libro;
import com.example.modelo.negocio.LibroService;

@SpringBootApplication
public class ClienteRestApplication implements CommandLineRunner {
	@Autowired // UTILIZA EL OBJETO DE JAVA Y LO INTRODUCE EN EL CONTEXTO SPRING
	private ApplicationContext contextoSpring;

	@Autowired //
	private LibroService libroService;

	@Bean // INTRODUCE EL OBJETO RECIBIDO EN EL CONTEXTO DE SPRING ,RECIBIDO O ENVIADO AL
			// SERVIDOR NEXO CLIENTE SERVIDOR
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ClienteRestApplication.class, args);
	}

	public void run(String... args) throws Exception {

//		libroporId = libroService.ObtenerporId(0);
//		System.out.println(libroporId.toString());

//		List<Libro> libroLista = libroService.listarLibros();
//		String cadena = libroLista.toString();
//		String[] lista = cadena.split("]");
//		for (String cadena2 : lista) {
//			System.out.println(cadena2.toString());
//		}
		Libro libro = new Libro(0, "a", "AB", 0);
		//libro.setEditorial("EDITORIAL");
	//	libro.setTitulo("NOMBRE CAMBIADO");
	//	libroService.modificarLibroId(libro);
	//	libroService.borrarLibroId(1); // BORRAMOS POR ID
		Libro libroporId = libroService.ObtenerporId(0);
		System.out.println(libroporId);
		libroService.altaLibro(libro);
		pararCliente();
	}

	public void pararCliente() {
		SpringApplication.exit(contextoSpring, () -> 0); // salida de la APP springBoot (????)
		System.out.println("Cerrando aplicacion");
	}
}
