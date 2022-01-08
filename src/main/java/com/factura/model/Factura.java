package com.factura.model;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/* ====================== CLASE ENTIDAD FACTURA ===========================
 * Esta clase define a través de la anotación @Entity la representación
 * del OBJETO Factura en la base de datos (una tabla)
 * 
 * @author: Aldair Bullon Santana
 * @version: 08/01/2022
 * */

@Entity
public class Factura {

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
	
	@Column(length = 35)
	private String nombreCliente;
	
	@Column(length = 11)
	private String RUC; 
	
	@Column(length = 100)
	private String direccion;

	@OneToMany(mappedBy="factura", cascade=CascadeType.ALL)
	private List<DetalleFactura> dFactura;
	
	/* Métodos Getter y Setter para el encapsulamiento de los campos */
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getRUC() {
		return RUC;
	}

	public void setRUC(String rUC) {
		RUC = rUC;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<DetalleFactura> getdFactura() {
		return dFactura;
	}

	public void setdFactura(List<DetalleFactura> dFactura) {
		this.dFactura = dFactura;
	}
	
	/* Cierre de los métodos getter y setter */
	
}

/* Cierre de la clase entidad - Factura */
