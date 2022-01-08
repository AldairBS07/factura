package com.factura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/* ====================== CLASE ENTIDAD DETALLE FACTURA ===========================
 * Esta clase define a través de la anotación @Entity la representación
 * del OBJETO DetalleFactura en la base de datos (una tabla)
 * 
 * @author: Aldair Bullon Santana
 * @version: 08/01/2022
 * */


@Entity
public class DetalleFactura {
	/*
	 * Campos que usara el objeto y se representaran como columnas en la 
	 * base de datos a través de la persistencia.
	 * ==================================================================================
	 * La anotación: @Id, indica que sera el primary key de la tabla
	 * La anotación: @GeneratedValue - Indetity, indica que sera de tipo autoincrementable
	 * La anotación: @Column, indica que sera un columna dentro de la tabla. Con el parametro
	 * lenght podemos especififcar la longitud del dato.
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name="codigoFactura", referencedColumnName = "codigo")
	private Factura factura;
	
	@Column(length = 100)
	private String producto;
	
	@Column
	private Integer cantidad;
	
	@Column
	private double precio;

	/* Métodos Getter y Setter para el encapsulamiento de los campos */
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	/* Cierre de los métodos getter y setter */
	
}

/* Cierre de la clase entidad - Factura */
