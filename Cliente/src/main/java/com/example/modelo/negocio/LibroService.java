package com.example.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.modelo.entidad.Libro;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Service // Implementa servicio en contexto Spring
public class LibroService {

	@Autowired
	private RestTemplate restTemplate;

	// URL PARA LAS PETICIONES HTTP
	public static final String URL = "http://localhost:8080/libros/";

	// METODO PARA OBTENER EL LIBRO POR ID

	public Libro ObtenerporId(int id) {
		try {
			ResponseEntity<Libro> libro = restTemplate.getForEntity(URL + id, Libro.class);
			HttpStatus hs = libro.getStatusCode(); // DEVUELVE EL CODIGO HTTP 100-500
			if (hs == HttpStatus.OK) {
				return libro.getBody();
			} else {
				System.out.println(libro.getStatusCode() + ", >>> Error ");
				return null;
			}
			// ESCRIBIMOS EL ERROR HTTP SI NO SE ENCUENTRA EL LIBRO
		} catch (HttpClientErrorException e) {
			System.out.println("El libro no se ha podido encontrar con el ID," + id);
			System.out.println(e.getStatusCode());
			return null;
		}

	}

	// MOSTRAMOS LOS LIBROS DISPONIBLES

	public List<Libro> listarLibros() {
		try {
			ResponseEntity<Libro[]> libro = restTemplate.getForEntity(URL, Libro[].class);
			Libro[] libros = libro.getBody();
			return Arrays.asList(libros); // DEVOLVEMOS EL ARRAY COMO LISTA
		} catch (HttpClientErrorException e) {
			System.out.println("El libro no se ha podido encontrar la lista"); // ESCRIBIMOS EL ERROR HTTP SI NO SE
																				// ENCUENTRA la lista de libros
			System.out.println(e.getStatusCode());
			return null;
		}
	}

	// MODIFICACION DE lIBRO POR ID
	public boolean modificarLibroId(Libro l, int id) { // MODIFICACION DE
		int opcion;
		String texto;
		float opcion_aux;
		Scanner sc = new Scanner(System.in);
		l = ObtenerporId(id);
		Libro lmodificado = l;
		System.out.println("");
		System.out.println(l.toString());
		System.out.println("");
		System.out.println("¿Que desea Modificar?");
		System.out.println("1.- ID");
		System.out.println("2.- EDITORIAL");
		System.out.println("3.- TITULO");
		System.out.println("4.- NOTA");
		System.out.println("0.- NADA");
		opcion = sc.nextInt();
		switch (opcion) {
		case 1:
			System.out.print("Ingrese el nuevo ID: ");
			opcion = sc.nextInt();
			if (opcion != l.getId()) {
				lmodificado.setId(opcion);
				System.out.println("                         ");
				break;
			} else {
				System.out.println("Ya existe un libro con ese ID Selecciona Otro");
				break;
			}
		case 2:
			System.out.print("Ingrese la nueva editorial: ");
			texto = sc.next();
			l.setEditorial(texto);
			System.out.println("                         ");
			System.out.println("***** EDITORIAL MODIFICADA ****");
			System.out.println("                         ");
			break;
		case 3:
			System.out.print("Ingrese el nuevo título: ");
			String viejotitulo = l.getTitulo();
			texto = sc.next();
			if (!texto.equals(viejotitulo)) {
				l.setTitulo(texto);
				System.out.println("                         ");
				System.out.println("***** TITUTLO MODIFICADO ****");
				System.out.println("                         ");
				break;
			} else {
				System.out.println("Ya existe un libro con ese titulo, vuelva a intentarlo");
				break;
			}
		case 4:
			System.out.print("Ingrese la nueva nota: ");
			opcion_aux = sc.nextFloat();
			l.setNota(opcion_aux);
			break;
		default:
			System.out.println("Error: Opción no válida.");
			break;
		}
		try {
			restTemplate.put(URL + l.getId(), l, Libro.class); // LE SOLICITAMOS EL ID POR URL CON EL OBJETO
																// // // //
			// CORRESPONDIENTE.

			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("No se ha podido modificar el libro por ID");
			System.out.println(e.getStatusCode());
			return false;
		}
	}

	// BORRAR LIBRO POR ID
	public boolean borrarLibroId(int id) {
		try {
			restTemplate.delete(URL + id); // LE SOLICITAMOS EL ID POR URL CON EL OBJETO
			System.out.println("Eliminado el libro con ID: " + id);
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("No se ha podido ELIMINAR el libro por ID");
			System.out.println(e.getStatusCode());
			return false;
		}
	}

	// ALTA DE LIBRO NUEVO

	public boolean altaLibro(Libro libro) {
		try {
			ResponseEntity<Libro> lib = restTemplate.postForEntity(URL, libro, Libro.class);
			System.out.println("El objeto se ha dado de alta " + lib.getStatusCode());
			return true; // DEVOLVEMOS EL ARRAY COMO LISTA
		} catch (HttpClientErrorException e) {
			System.out.println("No se ha podido dar de alta el libro"); // ESCRIBIMOS EL ERROR HTTP SI NO SE
			// ENCUENTRA la lista de libros
			System.out.println(e.getStatusCode());
			return false;
		}
	}
}
