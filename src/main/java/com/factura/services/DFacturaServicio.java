package com.factura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.factura.dao.DetalleFacturaDAO;
import com.factura.dao.FacturaDAO;
import com.factura.model.DetalleFactura;


/* ====================== INTERFACE DetalleFacturaDAO ===========================
 * Esta clase controladora es un servicio para el manejo de la capa de logica
 * de negocio y puede acceder a varios repositorios de la capa DAO .
 * 
 * La anotación @Service : Indica que gestionara todas las operaciones entre la
 * logica de negocio y los repositorios
 * 
 * @author: Aldair Bullon Santana
 * @version: 08/01/2022
 * */


@Service
public class DFacturaServicio {

	/* La anotación @Autowired indica que se hara una inyección de dependencias */
	@Autowired
	private DetalleFacturaDAO dFacturaDAO;
	@Autowired
	private FacturaDAO facturaDAO;
	

	/* Método para crear un nuevo de detalle de una factura */
	public void nuevoDetalle(Integer codigo,DetalleFactura dFactura) {
		
		try {
		
			dFactura.setFactura(facturaDAO.getById(codigo));
			dFacturaDAO.save(dFactura);	
			
		} catch(Exception e) {
			
			System.out.println(e);
		}
		
	}

	/* Método para listar el detalle de una factura por RUC*/
	public List<DetalleFactura> listarDetalleRUC(String RUC){
		
		try {
			
			return dFacturaDAO.findByFactura(facturaDAO.findByRUC(RUC));
	
		} catch(Exception e) {
			
			System.out.println(e);
			return null;
			
		}
	}
	/* Método para eliminar el detalle de una factura por codigo de factura */
	public void eliminarDetalle(Integer codigo) {
		
		try {
			dFacturaDAO.deleteByFactura(facturaDAO.getById(codigo));
		
		} catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
}

/* Cierre de la clase servicio DetalleFacturaServicio */
