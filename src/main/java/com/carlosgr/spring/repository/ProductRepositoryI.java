package com.carlosgr.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carlosgr.spring.persistence.Product;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Clase repositorio para la tabla de producto.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Repository
public interface ProductRepositoryI extends JpaRepository<Product, Long> {

	/**
	 * Encontrar productos con stock mayor a cierto valor.
	 * 
	 * @param stock
	 * @return List<Product>
	 */
	public List<Product> findByStockGreaterThan(final Integer stock);

}
