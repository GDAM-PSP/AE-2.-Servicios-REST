package com.example.modelo.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.modelo.entidad.Libro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service // Implementa servicio en contexto Spring
public class LibroService {

	@Autowired
	private RestTemplate restTemplate;

	public static final String URL = "http://localhost:8080/libros/"; // ESTA URL APUNTA A LAS PETICIONES

	public Libro ObtenerporId(int id) { // METODO PARA OBTENER EL LIBRO POR ID

		try {
			ResponseEntity<Libro> libro = restTemplate.getForEntity(URL + id, Libro.class);
			HttpStatus hs = libro.getStatusCode(); // DEVUELVE EL CODIGO HTTP 100-500
			if (hs == HttpStatus.OK) {
				return libro.getBody();
			} else {
				System.out.println(libro.getStatusCode() + ", >>> Error ");
				return null;
			}

		} catch (HttpClientErrorException e) { // ESCRIBIMOS EL ERROR HTTP SI NO SE ENCUENTRA EL LIBRO
			System.out.println("El libro no se ha podido encontrar con el ID," + id);
			System.out.println(e.getStatusCode());
			return null;
		}

	}

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

	public boolean modificarLibroId(Libro l) {

		try {
			restTemplate.put(URL + l.getId(), l, Libro.class); // LE SOLICITAMOS EL ID POR URL CON EL OBJETO //
																// CORRESPONDIENTE.
			return true;

		} catch (HttpClientErrorException e) {
			System.out.println("No se ha podido modificar el libro por ID");
			System.out.println(e.getStatusCode());
			return false;
		}
	}

	public boolean borrarLibroId(int id) { // DAR DE BAJA POR ID
		try {
			restTemplate.delete(URL + id); // LE SOLICITAMOS EL ID POR URL CON EL OBJETO
			// CORRESPONDIENTE.
			return true;
		} catch (HttpClientErrorException e) {
			System.out.println("No se ha podido ELIMINAR el libro por ID");
			System.out.println(e.getStatusCode());
			return false;
		}

	}

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
