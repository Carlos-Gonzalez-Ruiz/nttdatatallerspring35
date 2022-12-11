package com.carlosgr.spring.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlosgr.spring.persistence.Product;
import com.carlosgr.spring.persistence.Shelf;
import com.carlosgr.spring.service.interfaces.ProductManagementServiceI;
import com.carlosgr.spring.service.interfaces.ShelfManagementServiceI;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Implementación de la interfaz para la gestión del servicio de estantería.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@RestController
@RequestMapping("/shop")
public class ShopRestController {

	/** Servicio de gestión de la tabla de estantería */
	@Autowired
	ShelfManagementServiceI shelfManagementService;
	/** Servicio de gestión de la tabla de producto */
	@Autowired
	ProductManagementServiceI productManagementService;

	public ShopRestController() {
		super();
	}

	/**
	 * Añade una estantería por medio de una petición POST que contiene la
	 * estantería a insertar en la tabla de estanterías.
	 * 
	 * @param shelf
	 */
	@PostMapping(value = "shelves/add")
	public void addShelf(final @RequestBody Shelf shelf) {
		shelfManagementService.insertShelf(shelf);
	}

	/**
	 * Añade un producto por medio de una petición POST que contiene el producto a
	 * insertar en la tabla de productos.
	 * 
	 * @param product
	 */
	@PostMapping(value = "products/add")
	public void addProduct(final @RequestBody Product product) {
		productManagementService.insertProduct(product);
	}

	/**
	 * Elimina una estantería por medio de una petición DELETE que contiene la
	 * estantería a eliminar en la tabla de estanterías.
	 * 
	 * @param shelf
	 */
	@DeleteMapping(value = "shelves/delete/{id}")
	public void deleteShelf(final @PathVariable Long id) {
		shelfManagementService.deleteShelf(id);
	}

	/**
	 * Elimina un producto por medio de una petición DELETE que contiene el producto
	 * a eliminar en la tabla de productos.
	 * 
	 * @param product
	 */
	@DeleteMapping(value = "products/delete/{id}")
	public void deleteProduct(final @PathVariable Long id) {
		productManagementService.deleteProduct(id);
	}

	/**
	 * Devuelve todas las estanterías, o las que tengan cierto nombre, por medio de
	 * una petición GET.
	 * 
	 * @param shelf
	 * @return List<Shelf>
	 */
	@GetMapping(value = "shelves/")
	public List<Shelf> getShelves(final @RequestBody(required = false) Shelf shelf) {
		if (shelf == null) {
			return shelfManagementService.showShelves();
		} else {
			return shelfManagementService.showShelvesContainingName(shelf.getName());
		}
	}

	/**
	 * Devuelve todos los productos, o los que tengan un stock superior a un cierto
	 * valor, por medio de una petición GET.
	 * 
	 * @param product
	 * @return List<Product>
	 */
	@GetMapping(value = "products/")
	public List<Product> getProducts(final @RequestBody(required = false) Product product) {
		if (product == null) {
			return productManagementService.showProducts();
		} else {
			return productManagementService.showProductsWithStockHigherThan(product.getStock());
		}
	}

}
