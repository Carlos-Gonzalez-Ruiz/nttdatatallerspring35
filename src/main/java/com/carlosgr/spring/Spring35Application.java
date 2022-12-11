package com.carlosgr.spring;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carlosgr.spring.persistence.Product;
import com.carlosgr.spring.persistence.Shelf;
import com.carlosgr.spring.service.interfaces.ProductManagementServiceI;
import com.carlosgr.spring.service.interfaces.ShelfManagementServiceI;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Clase principal de la aplicación.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@SpringBootApplication
public class Spring35Application implements CommandLineRunner {

	/** Servicio de gestión de la tabla de estantería */
	@Autowired
	ShelfManagementServiceI shelfManagementService;
	/** Servicio de gestión de la tabla de producto */
	@Autowired
	ProductManagementServiceI productManagementService;

	/**
	 * Método principal de la clase.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(Spring35Application.class, args);
	}

	/**
	 * Método que Spring llama al inicializar la aplicación tras iniciar Spring
	 * Boot.
	 * 
	 * @param args (vaargs)
	 * @throws Exception
	 */
	@Override
	public void run(String... args) throws Exception {
		// Declarar variables reutilizables.
		String updateUser = "SYS";
		Date updateDate = new Date();
		Shelf shelf;
		Product product;

		/// Insertar datos de demostración.
		// Nueva estantería.
		shelf = new Shelf();
		shelf.setName("Limpieza");
		shelf.setUpdateUser(updateUser);
		shelf.setUpdateDate(updateDate);
		shelfManagementService.insertShelf(shelf);

		// Productos de esta estantería.
		product = new Product();
		product.setName("Detergente");
		product.setStock(10);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);

		product = new Product();
		product.setName("Escoba");
		product.setStock(20);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);

		product = new Product();
		product.setName("Recogedor");
		product.setStock(5);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);

		// Nueva estantería.
		shelf = new Shelf();
		shelf.setName("Juguetes");
		shelf.setUpdateUser("SYS");
		shelf.setUpdateDate(new Date());
		shelfManagementService.insertShelf(shelf);

		// Productos de esta estantería.
		product = new Product();
		product.setName("Lego Classic XL");
		product.setStock(7);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);

		product = new Product();
		product.setName("Lego Classic L");
		product.setStock(2);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);

		// Nueva estantería.
		shelf = new Shelf();
		shelf.setName("Videojuegos");
		shelf.setUpdateUser("SYS");
		shelf.setUpdateDate(new Date());
		shelfManagementService.insertShelf(shelf);

		// Productos de esta estantería.
		product = new Product();
		product.setName("Half-Life 3");
		product.setStock(35);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);

		product = new Product();
		product.setName("Minecraft 2");
		product.setStock(28);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);

		product = new Product();
		product.setName("Spore 2");
		product.setStock(1);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);

		// Nueva estantería.
		shelf = new Shelf();
		shelf.setName("Libros");
		shelf.setUpdateUser("SYS");
		shelf.setUpdateDate(new Date());
		shelfManagementService.insertShelf(shelf);

		// Productos de esta estantería.
		product = new Product();
		product.setName("El Quijote");
		product.setStock(10);
		product.setUpdateUser(updateUser);
		product.setUpdateDate(updateDate);
		product.setShelf(shelf);
		productManagementService.insertProduct(product);
	}

}
