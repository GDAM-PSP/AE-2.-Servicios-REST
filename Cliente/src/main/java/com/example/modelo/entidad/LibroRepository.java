package com.example.modelo.entidad;

import java.util.List;

public interface LibroRepository {
	List<Libro> listarLibros();

	Libro obtenerLibroPorId(int id);

	Libro darAltaLibro(Libro libro);

	Libro darAltaLibroPorId(int id, Libro libro);

	Libro modificarLibro(int id, Libro libro);

	void eliminarLibro(int id);
}