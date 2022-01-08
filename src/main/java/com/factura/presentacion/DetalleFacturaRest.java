package com.factura.presentacion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factura.model.DetalleFactura;
import com.factura.services.DFacturaServicio;

/* ====================== Clase FacturaRest  ===========================
 * Esta clase definira los metodos a ejecutar cuando se haga una solicitud
 * HHTP - Consumira de la capa servicios .
 * 
 * La anotación @RestController : Extiende de la anotacion @Controller pero
 * esta anotación no devolvera vistas, si no, nos devolvera un objeto o json
 * como una respuesta HTTP.
 * 
 * La anotación @RequestMapping: Asignara una solicitud web a traves de la creación
 * de una URL base que usara el controlador.
 * 
 * @author: Aldair Bullon Santana
 * @version: 08/01/2022
 * */

@RestController
@RequestMapping("api/factura/detalle")
public class DetalleFacturaRest {

	/* La anotación @Autowired indica que se hara una inyección de dependencias */
	@Autowired
	private DFacturaServicio dFacturaServicio;
	
	/* Maneja solicituds HTTP de tipo POST*/
	@PostMapping("/guardar/{codigo}")
	public void guardar(@PathVariable("codigo") Integer codigo, @RequestBody DetalleFactura dFactura) {
		
		dFacturaServicio.nuevoDetalle(codigo, dFactura);
			
	}
	
	/* Maneja solicituds HTTP de tipo GET*/
	@GetMapping("/listar/{RUC}")
	public List<DetalleFactura> listarDetalle(@PathVariable("RUC") String RUC){
		
			return dFacturaServicio.listarDetalleRUC(RUC);
	
	}
	
	/* Maneja solicituds HTTP de tipo DELETE*/
	@DeleteMapping("/eliminar/{codigoFactura}")
	@Transactional
	public void eliminarDetalle(@PathVariable("codigoFactura") Integer codigoFactura){
		
			dFacturaServicio.eliminarDetalle(codigoFactura);
	
	}
	
}

/* Cierre de la clase DetalleFacturaRest*/