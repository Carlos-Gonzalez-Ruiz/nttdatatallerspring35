package com.carlosgr.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlosgr.spring.persistence.Shelf;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Clase repositorio para la tabla de estantería.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Repository
public interface ShelfRepositoryI extends JpaRepository<Shelf, Long> {

	/**
	 * Encontrar estanterías cuyo nombre contenga cierto cadena de caracteres.
	 * 
	 * @param name
	 * @return List<Shelf>
	 */
	public List<Shelf> findByNameContaining(final String name);

}
