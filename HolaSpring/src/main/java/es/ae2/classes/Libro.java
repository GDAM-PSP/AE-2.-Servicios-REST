package es.ae2.classes;

public class Libro {
	private int id;
	private String editorial;
	private String titulo;
	private double nota;
	
	//Constructor/inicializador vacio
	public Libro() {
	}
	
	//Constructor con datos
	public Libro(int id, String editorial, String titulo, double nota) {
		this.id = id;
		this.editorial = editorial;
		this.titulo = titulo;
		this.nota = nota;
	}
	
	//Getters y setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEditorial() {
		return editorial;
	}
	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public double getNota() {
		return nota;
	}
	
	public void setNota(double nota) {
		this.nota = nota;
	}
	
	@Override
	//Reemplazo metodo toString para printear cadena de datos del objeto
	public String toString() {
		return "Libro [id=" + id + ", editorial=" + editorial + ", titulo=" + titulo + ", nota=" + nota + "]";
	}
}
