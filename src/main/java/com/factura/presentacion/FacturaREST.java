package com.factura.presentacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.factura.model.Factura;
import com.factura.services.FacturaServicio;

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
@RequestMapping("api/factura")
public class FacturaREST {

	/* La anotación @Autowired indica que se hara una inyección de dependencias */
	@Autowired
	private FacturaServicio facturaServicio;
	
	/* Maneja solicituds HTTP de tipo POST*/
	@PostMapping("/guardar")
	/* Metodo para guardar la factura - master*/
	public void guardar(@RequestBody Factura factura) {
		facturaServicio.nuevaFactura(factura);
	}
	
	/* Maneja solicituds HTTP de tipo GET*/
	@GetMapping("/listar")
	/* Metodo para listar la factura - master*/
	public List<Factura> listar() {
		return facturaServicio.listarFactura();
	}
	
	/* Maneja solicituds HTTP de tipo DELETE*/
	@DeleteMapping("/eliminar/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer codigo) {
		facturaServicio.eliminarFactura(codigo);
	}
	
	/* Maneja solicituds HTTP de tipo PUT*/
	@PutMapping("/actualizar/{codigo}")
	public void actualizar(@PathVariable("codigo") Integer codigo, @RequestBody Factura factura) {
		facturaServicio.actualizarFactura(codigo, factura);
	}
	
	/* Maneja solicituds HTTP de tipo GET*/
	@GetMapping("/listar/{RUC}")
	public Factura listarPorRUC(@PathVariable("RUC") String RUC) {
		return facturaServicio.listarFacturaRUC(RUC);
	}
}

/* Cierre de la clase Clase FacturaRest */
