package com.example.modelo.negocio;

import org.springframework.stereotype.Service;

import com.example.modelo.entidad.Libro;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioLibro {

	private final List<Libro> libros = new ArrayList<>();

	// Constructor con libros preestablecidos
	public ServicioLibro() {
		// Se agregan 5 libros preestablecidos
		libros.add(new Libro(1, "Libro1", "Editorial1", 4.5));
		libros.add(new Libro(2, "Libro2", "Editorial2", 3.8));
		libros.add(new Libro(3, "Libro3", "Editorial3", 4.2));
		libros.add(new Libro(4, "Book4", "Editorial4", 5.0));
		libros.add(new Libro(5, "Book5", "Editorial5", 4.7));
	}

	public List<Libro> listarLibros() {
		return libros;
	}

	public Libro listarPorId(int id) {
		return null;
	}

	public Libro crearLibro(Libro libro) {
		libro.setId((int) System.currentTimeMillis()); // ID único basado en la marca de tiempo
		libros.add(libro);
		return libro;
	}

	public Libro actualizarLibro(int id, Libro actualizarLibro) {
		return null;
	}

	public void borrarLibro(int id) {
		libros.remove(id);
	}
	
}
