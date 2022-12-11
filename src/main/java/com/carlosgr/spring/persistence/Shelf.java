package com.carlosgr.spring.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

/**
 * NTT Data - Spring - Taller 3 y 5
 * 
 * Clase para la tabla de estanería.
 * 
 * @author NTT Data - Carlos González Ruiz
 */
@Entity
@Table(name = "T_SHELF")
public class Shelf extends AbstractEntity implements Serializable {

	/** Serial Version ID */
	private static final long serialVersionUID = 1L;

	/** ID (clave primaria) */
	private Long shelfId;
	/** Nombre del estante */
	private String name;

	/** Productos asociados al estante */
	private List<Product> products;

	/**
	 * @return the shelfId
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_SHELF_ID")
	public Long getShelfId() {
		return shelfId;
	}

	/**
	 * @param shelfId the shelfId to set
	 */
	public void setShelfId(Long shelfId) {
		this.shelfId = shelfId;
	}

	/**
	 * @return the name
	 */
	@Column(name = "C_NAME", unique = true, nullable = false)
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
	 * @return the products
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "shelf")
	@JsonManagedReference
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public Long getId() {
		return this.shelfId;
	}

	@Override
	public void setId(Long id) {
		this.shelfId = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(name, products, shelfId);
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
		Shelf other = (Shelf) obj;
		return Objects.equals(name, other.name) && Objects.equals(products, other.products)
				&& Objects.equals(shelfId, other.shelfId);
	}

	@Override
	public String toString() {
		/* @formatter:off */
		return 	"[shelfId=" + shelfId + ", " +
				"name=\"" + name + "\", " +
				"products=" + products + "]";
		/* @formatter:on */
	}

}