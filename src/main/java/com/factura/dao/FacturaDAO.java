package com.factura.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.factura.model.Factura;

/* ====================== INTERFACE FacturaDAO ===========================
 * Esta interface hace uso del Repositorio JPA para el uso de sus métodos
 * ya establecidos para un mantenimiendo simple de una tabla este nos ayudara
 * a tener el acceso a los datos del modelo sin tocar sentencias SQL.
 * 
 * @author: Aldair Bullon Santana
 * @version: 08/01/2022
 * */


public interface FacturaDAO extends JpaRepository<Factura, Integer> {

	/* Método personalizado para buscar una factura por RUC*/
	public Factura findByRUC(String RUC);
	

}

/* Cierre de la interface FacturaDAO */
