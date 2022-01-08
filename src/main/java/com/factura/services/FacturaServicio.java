package com.factura.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.factura.dao.FacturaDAO;
import com.factura.model.Factura;

/* ====================== INTERFACE FacturaDAO ===========================
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
public class FacturaServicio {
	
	/* La anotación @Autowired indica que se hara una inyección de dependencias */
	@Autowired
	private FacturaDAO facturaDAO;
	
	/* Método para crear una nueva factura */
	public void nuevaFactura(Factura factura) {
		try {
			
			facturaDAO.save(factura);
			
		} catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	/* Método para listar todas las facturas */
	public List<Factura> listarFactura() {
		try {
			
		return facturaDAO.findAll();
		
		} catch(Exception e) {
			
			System.out.println(e);
			return null;
		}
	}
	
	/* Método para eliminar una factura */
	public void eliminarFactura(Integer codigo) {
		try {
			
			facturaDAO.deleteById(codigo);
		
		} catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	/* Método para actualizar una factura */
	public void actualizarFactura(Integer codigo,Factura factura) {
		try {
			
			factura.setCodigo(codigo);
			facturaDAO.save(factura);
			
		} catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	/* Método listar una factura por RUC */
	public Factura listarFacturaRUC(String RUC) {
		try {
			
			return facturaDAO.findByRUC(RUC);
		
		} catch(Exception e) {
			
			System.out.println(e);
			return null;
			
		}
	}
	
}

/* Cierre de la clase servicio FacturaServicio */
