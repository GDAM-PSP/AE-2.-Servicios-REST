package com.example.modelo.entidad;

import java.util.Objects;

public class Libro {
	
	private int id;
	private String titulo;
	private String editorial;
	private double puntuacion;

	// Constructor por defecto
	public Libro() {
	}

	// Constructor con todos los campos
	public Libro(int id, String nombre, String editorial, double puntuacion) {
		this.id = id;
		this.titulo = nombre;
		this.editorial = editorial;
		this.puntuacion = puntuacion;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return titulo;
	}

	public void setNombre(String nombre) {
		this.titulo = nombre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}

	// Método equals y hashCode para evitar libros duplicados
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        Libro libro = (Libro) obj;
//        return id.equals(libro.id) || nombre.equals(libro.nombre);
//    }
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", editorial=" + editorial + ", puntuacion=" + puntuacion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo);
	}
}
