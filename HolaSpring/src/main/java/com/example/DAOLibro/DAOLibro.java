package com.example.DAOLibro;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.clases.Libro;


@Component
public class DAOLibro {
	private ArrayList<Libro> libros;
	private int contador;
	
	public DAOLibro() {
		libros = new ArrayList<>();
		
        // Inicializamos el servidor con 5 libros preestablecidos
        libros.add(new Libro(contador++, "Libro 1", "Editorial A", 4.5));
        libros.add(new Libro(contador++, "Libro 2", "Editorial B", 3.8));
        libros.add(new Libro(contador++, "Libro 3", "Editorial A", 4.0));
        libros.add(new Libro(contador++, "Libro 4", "Editorial C", 4.2));
        libros.add(new Libro(contador++, "Libro 5", "Editorial B", 3.9));
	}
	//Recoge un libro y se lo manda
	public Libro get(int posicion) {
		try {
			return libros.get(posicion);
		}catch(IndexOutOfBoundsException iobe) {
			System.out.println("Persona fuera de rango");
			return null;
		}
	}
	//Recoge el arraylist con todos los libros y se lo manda
	public ArrayList<Libro> listar() {
		try {
			return libros;
		}catch(IndexOutOfBoundsException iobe) {
			System.out.println("No hay libros");
			return null;
		}
	}
	//Da de alta un libro
	public Libro post(Libro l) {
		l.setId(contador++);
		libros.add(l);
		return l;
	}
	//Modifica un libro
	public Libro update(Libro l, int posicion) {
		if(libros.get(posicion) != null) {
		libros.set(posicion, l);
		return l;
		}else {
			return null;
		}
	}
	//Eliminar un libro
	public Libro delete(int posicion) {
		if(libros.get(posicion)!=null) {
			Libro l = new Libro();
			l = libros.get(posicion);
			libros.remove(posicion);
			return l;
		}else {
			return null;
		}
	}
}
