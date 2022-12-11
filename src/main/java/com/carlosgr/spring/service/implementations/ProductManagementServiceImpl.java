package com.carlosgr.spring.service.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlosgr.spring.persistence.Product;
import com.carlosgr.spring.repository.ProductRepositoryI;
import com.carlosgr.spring.service.interfaces.ProductManagementServiceI;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Implementación de la interfaz para la gestión del servicio de producto.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Service
public class ProductManagementServiceImpl implements ProductManagementServiceI {

	/** Repositorio de producto */
	@Autowired
	private ProductRepositoryI productRepository;

	@Override
	public void insertProduct(Product product) {
		productRepository.saveAndFlush(product);
	}

	@Override
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> showProductsWithStockHigherThan(Integer stock) {
		return productRepository.findByStockGreaterThan(stock);
	}

	@Override
	public List<Product> showProducts() {
		return productRepository.findAll();
	}

}
