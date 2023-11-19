package es.ae2.servidor.dao;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import es.ae2.servidor.entidad.Libro;

@Component
public class LibroDao {
	private ArrayList<Libro> libros;
	private int contador;

	public LibroDao() {
		libros = new ArrayList<>();

		// Inicializamos el servidor con 5 libros preestablecidos
		libros.add(new Libro(contador++, "Editorial A", "Libro 1", 4.5));
		libros.add(new Libro(contador++, "Editorial B", "Libro 2", 3.8));
		libros.add(new Libro(contador++, "Editorial C", "Libro 3", 4.0));
		libros.add(new Libro(contador++, "Editorial D", "Libro 4", 4.2));
		libros.add(new Libro(contador++, "Editorial E", "Libro 5", 3.9));
	}

	/**
	 * Devuelve el libro consultado
	 * 
	 * @param id Identificador del libro
	 * @return Libro o null si no existe el ID
	 */
	public Libro get(int id) {
		for (Libro libro : libros) {
			if (libro.getId() == id) {
				return libro;
			}
		}

		return null;
	}

	/**
	 * Recoge el arraylist con todos los libros
	 * 
	 * @return Arraylist de libros o null si no existen
	 */
	public ArrayList<Libro> listar() {
		try {
			return libros;
		} catch (IndexOutOfBoundsException iobe) {
			System.out.println("No hay libros");
			return null;
		}
	}

	/**
	 * Da de alta el libro con los datos introducidos
	 * 
	 * @param libro Body recibido del POST
	 * @return Libro creado o null si hay errores en los parametros
	 */
	public Libro post(Libro libro) {
		try {
			libro.setId(contador++);
			libros.add(libro);
			return libro;
		} catch (Exception e) {
			// Error en algun campo al insertar
			return null;
		}
	}

	/**
	 * Modifica el libro por ID
	 * 
	 * @param libro Datos a modificar del libro
	 * @param id    Identificador del libro
	 * @return Libro actualizado o null si no existe
	 */
	public Libro update(Libro libroModificado, int id) {
		int index = 0;
		for (Libro libro : libros) {
			if (libro.getId() == id) {
				libros.set(index, libroModificado);
				return libros.get(index);
			}
			index++;
		}

		return null;
	}

	/**
	 * Eliminar un libro
	 * 
	 * @param id Identificador a eliminar
	 * @return
	 */
	public Boolean delete(int id) {
		int index = 0;

		for (Libro libro : libros) {
			if (libro.getId() == id) {
				libros.remove(index);
				return true;
			}

			index++;
		}

		// No ha encontrado el libro, devolvemos false
		return false;
	}
}
