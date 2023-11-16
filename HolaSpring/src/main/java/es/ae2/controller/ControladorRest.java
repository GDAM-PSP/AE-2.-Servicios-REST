package es.ae2.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.ae2.classes.Libro;
import es.ae2.dao.LibroDao;


@RestController
public class ControladorRest {
	
	@Autowired
	LibroDao daoLibro;
	
	/**
	 * Obtener libro por id
	 * @param id del libro a buscar
	 * @return Objeto libro encontrado, 404 en caso de no existir
	 */
	@GetMapping(path="/libros/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> getLibroID(@PathVariable("id") int id) {
		if(daoLibro.get(id) != null) {
			//Devolvemos el objeto encontrado
			return new ResponseEntity<Libro>(daoLibro.get(id),HttpStatus.OK);
		}else {
			//No encontrado
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Listar todos los libros
	 * @return Lista de libros de los objetos encontrados, 404 en caso de no existir
	 */
	@GetMapping(path="/libros", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> getLibros(){
		if(daoLibro.listar()!=null) {
			return new ResponseEntity<List<Libro>>(daoLibro.listar(),HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Libro>>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Dar de alta un libro
	 * @param bodyLibro Body del libro a crear
	 * @return Objeto libro creado
	 */
	@PostMapping(path="libros", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> postLibros(@RequestBody Libro bodyLibro){
		Libro libro = daoLibro.post(bodyLibro);
		
		if (libro != null) {
			return new ResponseEntity<Libro>(libro,HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Libro>(HttpStatus.BAD_REQUEST);
		}
	}
	
	/**
	 * Modificar un libro
	 * @param bodyLibro Body recibido con la modificacion
	 * @param id Identificador del libro a modificar
	 * @return Objeto libro modificado, 404 si no existe el ID
	 */
	@PutMapping(path="libros/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> putLibros(@RequestBody Libro bodyLibro, @PathVariable("id") int id){
		bodyLibro.setId(id);
		Libro updateLibro = daoLibro.update(bodyLibro, id);
		
		if(updateLibro != null) {
			return new ResponseEntity<Libro>(daoLibro.get(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Eliminacion de libro por ID
	 * @param id Identificador del libro a eliminar
	 * @return 200 si se elimina, 404 si no existe
	 */
	@DeleteMapping(path="libros/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> DeleteLibros(@PathVariable("id") int id){
		Boolean eliminacionLibro = daoLibro.delete(id);
		
		if(eliminacionLibro) {
			return new ResponseEntity<Libro>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
