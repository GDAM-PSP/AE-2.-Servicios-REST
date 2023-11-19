package es.ae2.cliente.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import es.ae2.cliente.entidad.Libro;
import es.ae2.cliente.negocio.LibroService;

@SpringBootApplication(scanBasePackages={
"es.ae2.cliente"})
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
		int opcion;
		Boolean respuesta;
		int id;
		Libro libro = new Libro();
		Scanner idsc = new Scanner(System.in);
		do {
			menu();
			opcion = opcionMenu();
			System.out.println("");
			System.out.println("Opción seleccionada:  " + opcion);

			// DAR DE ALTA UN NUEVO LIBRO
			switch (opcion) {
			case 1:
				respuesta = libroService.altaLibro(libro);
				if (respuesta) {
					System.out.println("DADO DE ALTA EL LIBRO: " + libro);
				} else {
					System.out.println("NO SE HA PODIDO DAR DE ALTA EL LIBRO: " + libro);
				}
				System.out.println("                                               ");
				System.out.println("                                               ");
				break;

			// DAR DE BAJA UN LIBRO POR ID
			case 2:
				System.out.println("Introduzca ID: ");
				id = idsc.nextInt();
				respuesta = libroService.borrarLibroId(id);
				if (respuesta) {
					System.out.println("LIBRO CON ID " + id + " HA SIDO BORRADO");
				} else {
					System.out.println("NO SE HA PODIDO BORRAR EL LIBRO CON ID " + id);
				}
				System.out.println("                                               ");
				System.out.println("                                               ");
				break;

			// MODIFICAR UN LIBRO POR ID
			case 3:
				System.out.println("Introduzca el ID: ");
				id = idsc.nextInt();
				//Obtenemos el libro a modificar para mostrar los valores originales
				libro = libroService.ObtenerporId(id);
				if (libro != null) {
					libroService.modificarLibroId(libro, id);
				} else {
					System.out.println("El libro no existe.");
				}
				break;

			// OBTENER UN LIBRO POR ID
			case 4:
				System.out.println("Introduzca ID: ");
				id = idsc.nextInt();
				libro = libroService.ObtenerporId(id);
				System.out.println(libro.toString());
				System.out.println("                                               ");
				System.out.println("                                               ");
				System.out.println("                                               ");
				System.out.println("                                               ");
				break;

			// LISTAR TODOS LOS LIBROS
			case 5:
				List<Libro> lista = libroService.listarLibros();
				for (Libro s : lista) {
					System.out.println("           ");
					System.out.println("*  " + "[" + s.getTitulo() + "]");
					System.out.println(s.toString());
					System.out.println("           ");
				}
				break;
			}
		} while (opcion != 0);
		idsc.close();
		pararCliente();
	}

	public void pararCliente() {
		SpringApplication.exit(contextoSpring, () -> 0); // salida de la APP springBoot (????)
		System.out.println("Cerrando aplicacion");
	}

	public static void menu() {
		System.out.println("========================================");
		System.out.println("|             MENÚ PRINCIPAL            |");
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("========================================");
		System.out.println("Menu de Opciones:                       |");
		System.out.println("1->Dar de alta un libro                 |");
		System.out.println("2->Dar de baja un libro por ID          |");
		System.out.println("3->Modificar un libro por ID            |");
		System.out.println("4->Obtener un libro por ID              |");
		System.out.println("5->Listar todos los libros              |");
		System.out.println("0->Salir                                |");

	}

	private int opcionMenu() {
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("Seleccione una opción: ");
			opcion = sc.nextInt();
		} catch (java.util.InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		return opcion;
	}
}
