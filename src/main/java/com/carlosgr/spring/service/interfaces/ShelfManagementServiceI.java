package com.carlosgr.spring.service.interfaces;

import java.util.List;

import com.carlosgr.spring.persistence.Shelf;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Interfaz para la gestión del servicio de estantería.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public interface ShelfManagementServiceI {

	/**
	 * Inserta una nueva estantería a la tabla de estanterías.
	 * 
	 * @param shelf
	 */
	public void insertShelf(final Shelf shelf);

	/**
	 * Elimina una estantería de la tabla de estanterías.
	 * 
	 * @param shelf
	 */
	public void deleteShelf(final Shelf shelf);

	/**
	 * Elimina una estantería de la tabla de estanterías, mediante el ID.
	 * 
	 * @param id
	 */
	public void deleteShelf(final Long id);

	/**
	 * Encontrar estanterías cuyo nombre contenga cierto cadena de caracteres.
	 * 
	 * @param name
	 * @return List<Shelf>
	 */
	public List<Shelf> showShelvesContainingName(final String name);

	/**
	 * Devuelve un listado con todas las estanterías.
	 * 
	 * @return List<Shelf>
	 */
	public List<Shelf> showShelves();

}
