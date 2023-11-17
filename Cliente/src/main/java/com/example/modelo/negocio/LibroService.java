package com.example.modelo.negocio;

import org.springframework.stereotype.Service;

import com.example.modelo.entidad.Libro;
import com.example.modelo.entidad.LibroRepository;

import java.util.ArrayList;
import java.util.List;

public class LibroService implements LibroRepository {
	private final LibroRepository libroRepository = null;

	// constructor

	public List<Libro> listarLibros() {
		return libroRepository.listarLibros();
	}

	public Libro obtenerLibroPorId(int id) {
		return libroRepository.obtenerLibroPorId(id);
	}

	public Libro darAltaLibro(Libro libro) {
		if (!libroRepository.listarLibros().contains(libro)) {
			return libroRepository.darAltaLibro(libro);
		} else {
			throw new RuntimeException("Ya existe un libro con el mismo ID o título.");
		}
	}

	public Libro darAltaLibroPorId(int id, Libro libro) {
		if (!libroRepository.listarLibros().contains(libro)) {
			return libroRepository.darAltaLibroPorId(id, libro);
		} else {
			throw new RuntimeException("Ya existe un libro con el mismo ID o título.");
		}
	}

	public Libro modificarLibro(int id, Libro libro) {
		if (!libroRepository.listarLibros().contains(libro)) {
			return libroRepository.modificarLibro(id, libro);
		} else {
			throw new RuntimeException("Ya existe un libro con el mismo ID o título.");
		}
	}

	public void eliminarLibro(int id) {
		libroRepository.eliminarLibro(id);
	}
}
