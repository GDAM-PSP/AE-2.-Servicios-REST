package com.example;


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

import com.example.DAOLibro.DAOLibro;
import com.example.clases.Libro;


@RestController
public class ControladorRest {
	
	@Autowired
	DAOLibro daolibro;
	
	//Obtener libro por id
	@GetMapping(path="/libros/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> getLibroID(@PathVariable("id") int id) {
		if(daolibro.get(id)!=null) {
			return new ResponseEntity<Libro>(daolibro.get(id),HttpStatus.OK);//Devuelve el obj encontrado
		}else {
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);//No encontrado
		}
	}
	//Listar todos los libros
	@GetMapping(path="/libros", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Libro>> getLibros(){
		if(daolibro.listar()!=null) {
			return new ResponseEntity<List<Libro>>(daolibro.listar(),HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Libro>>(HttpStatus.NOT_FOUND);
		}
	}
	//Dar de alta un libro
	@PostMapping(path="libros", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> postLibros(@RequestBody Libro l){
		return new ResponseEntity<Libro>(daolibro.post(l),HttpStatus.CREATED);
	}
	//Modificar un libro
	@PutMapping(path="libros/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> putLibros(@RequestBody Libro l, @PathVariable("id") int id){
		l.setId(id);
		Libro lUpdate = daolibro.update(l, id);
		if(lUpdate!=null) {
			return new ResponseEntity<Libro>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(path="libros/{id}", produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Libro> DeleteLibros(@PathVariable("id") int id){
		Libro l = daolibro.delete(id);
		if(l!=null) {
			return new ResponseEntity<Libro>(l,HttpStatus.OK);
		}else {
			return new ResponseEntity<Libro>(HttpStatus.NOT_FOUND);
		}
		
	}
	
}
