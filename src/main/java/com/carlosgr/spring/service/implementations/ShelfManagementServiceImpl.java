package com.carlosgr.spring.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosgr.spring.persistence.Shelf;
import com.carlosgr.spring.repository.ShelfRepositoryI;
import com.carlosgr.spring.service.interfaces.ShelfManagementServiceI;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Implementación de la interfaz para la gestión del servicio de estantería.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Service
public class ShelfManagementServiceImpl implements ShelfManagementServiceI {

	/** Repositorio de estantería */
	@Autowired
	private ShelfRepositoryI shelfRepository;

	@Override
	public void insertShelf(Shelf shelf) {
		shelfRepository.saveAndFlush(shelf);
	}

	@Override
	public void deleteShelf(Shelf shelf) {
		shelfRepository.delete(shelf);
	}

	@Override
	public void deleteShelf(Long id) {
		shelfRepository.deleteById(id);
	}

	@Override
	public List<Shelf> showShelvesContainingName(String name) {
		return shelfRepository.findByNameContaining(name);
	}

	@Override
	public List<Shelf> showShelves() {
		return shelfRepository.findAll();
	}

}
