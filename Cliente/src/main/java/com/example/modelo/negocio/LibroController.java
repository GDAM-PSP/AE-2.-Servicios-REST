package com.example.modelo.negocio;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.modelo.entidad.Libro;

// LibroController.java
@RestController
@RequestMapping("/libros")
public class LibroController {
	private final LibroService libroService = new LibroService();

	// constructor

	@GetMapping
	public List<Libro> listarLibros() {
		return libroService.listarLibros();
	}

	@GetMapping("/{id}")
	public Libro obtenerLibroPorId(@PathVariable int id) {
		return libroService.obtenerLibroPorId(id);
	}

	@PostMapping
	public Libro darAltaLibro(@RequestBody Libro libro) {
		return libroService.darAltaLibro(libro);
	}

	@PutMapping("/{id}")
	public Libro darAltaLibroPorId(@PathVariable int id, @RequestBody Libro libro) {
		return libroService.darAltaLibroPorId(id, libro);
	}

	@PutMapping("/{id}/modificar")
	public Libro modificarLibro(@PathVariable int id, @RequestBody Libro libro) {
		return libroService.modificarLibro(id, libro);
	}

	@DeleteMapping("/{id}")
	public void eliminarLibro(@PathVariable int id) {
		libroService.eliminarLibro(id);
	}
}
