package com.carlosgr.spring.persistence;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Clase para la tabla de producto.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Entity
@Table(name = "T_PRODUCT")
public class Product extends AbstractEntity implements Serializable {

	/** Serial Version ID */
	private static final long serialVersionUID = 1L;

	/** ID (clave primaria) */
	private Long productId;
	/** Nombre del producto */
	private String name;
	/** Stock del producto */
	private Integer stock;

	/** Estantería a la que pertence el producto. */
	private Shelf shelf;

	/**
	 * @return the productId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_PRODUCT_ID")
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_NAME", nullable = false)
	@NotEmpty
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the stock
	 */
	@Column(name = "C_STOCK")
	@Min(value = 0, message = "El stock no puede ser inferior a 0.")
	public Integer getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}

	/**
	 * @return the shelf
	 */
	@ManyToOne
	@JoinColumn(name = "C_SHELF_ID")
	@JsonBackReference
	public Shelf getShelf() {
		return shelf;
	}

	/**
	 * @param shelf the shelf to set
	 */
	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}

	@Override
	public Long getId() {
		return this.productId;
	}

	@Override
	public void setId(Long id) {
		this.productId = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name, productId, stock);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name) && Objects.equals(productId, other.productId)
				&& Objects.equals(stock, other.stock);
	}

	@Override
	public String toString() {
		/* @formatter:off */
		return 	"[productId=" + productId + ", " +
				"name=\"" + name + "\", " + 
				"stock=" + stock + "]";
		/* @formatter:on */
	}

}
