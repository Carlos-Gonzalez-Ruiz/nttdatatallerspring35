package com.carlosgr.spring.service.interfaces;

import java.util.List;

import com.carlosgr.spring.persistence.Product;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Interfaz para la gestión del servicio de producto.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
public interface ProductManagementServiceI {

	/**
	 * Inserta un nuevo producto a la tabla de producots.
	 * 
	 * @param product
	 */
	public void insertProduct(final Product product);

	/**
	 * Elimina un producto de la tabla de productos.
	 * 
	 * @param product
	 */
	public void deleteProduct(final Product product);

	/**
	 * Elimina un producto de la tabla de productos, mediante el ID.
	 * 
	 * @param id
	 */
	public void deleteProduct(final Long id);

	/**
	 * Encontrar productos cuyo stock sea superior a cierto valor.
	 * 
	 * @param stock
	 * @return List<Product>
	 */
	public List<Product> showProductsWithStockHigherThan(final Integer stock);

	/**
	 * Devuelve un listado con todos los productos.
	 * 
	 * @return List<Product>
	 */
	public List<Product> showProducts();

}
