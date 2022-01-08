package com.factura.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.model.DetalleFactura;
import com.factura.model.Factura;

/* ====================== INTERFACE DetalleFacturaDAO ===========================
 * Esta interface hace uso del Repositorio JPA para el uso de sus métodos
 * ya establecidos para un mantenimiendo simple de una tabla este nos ayudara
 * a tener el acceso a los datos del modelo sin tocar sentencias SQL.
 * 
 * @author: Aldair Bullon Santana
 * @version: 08/01/2022
 * */

public interface DetalleFacturaDAO extends JpaRepository<DetalleFactura, Integer>{

	/* Método personalizado para listar el detalle de la factura por RUC*/
	public List<DetalleFactura> findByFactura(Factura factura);
	
	/* Método personalizado para eliminar el detalle de la factura por codigoFactura */
	public void deleteByFactura(Factura factura);
}

/* Cierre de la interface DetalleFacturaDAO */