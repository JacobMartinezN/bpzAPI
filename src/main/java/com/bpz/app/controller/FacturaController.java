package com.bpz.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bpz.app.service.FacturaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.bpz.app.entity.Factura;

@Api(value = "BPZ" , description = "Operaciones pertenecientes a Facturas BPZ")
@RestController
@RequestMapping(value="facturas")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaController {
	
	@Autowired
	private FacturaService facturaService;

	@ApiOperation(value = "Visualiza una lista de las de facturas en el sistema BPZ.", response = Iterable.class)
	@GetMapping
	public ResponseEntity<List<Factura>> allFacturas() {
		List<Factura> facturas = new ArrayList<>();
		try {
			facturas = facturaService.findAll();
		}catch (Exception e) {
			return new ResponseEntity<List<Factura>>(facturas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Visualiza una lista de las de facturas 'Por Pagar' en el sistema BPZ.", response = Iterable.class)
	@RequestMapping(value = "/pagos", method = RequestMethod.GET)
	public ResponseEntity<List<Factura>> facturasByEstado() {
		List<Factura> facturas = new ArrayList<>();
		try {
			facturas = facturaService.findByEstado();
		}catch (Exception e) {
			return new ResponseEntity<List<Factura>>(facturas, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Factura>>(facturas, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Permite registrar facturas en el sistema BPZ.", response = Iterable.class)
	@PostMapping
	public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
		Factura f = new Factura();
		try {
			f = facturaService.save(factura);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Factura>(f,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Factura>(f,HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Permite actualizar facturas en el sistema BPZ.", response = Iterable.class)
	@PutMapping(value="/{id:\\d+}")
	public ResponseEntity<Factura> updateFactura(@PathVariable Integer id, @RequestBody Factura factura){
		Factura storeFactura = facturaService.findById(id);
		try {
			storeFactura.setCodigoServicio(factura.getCodigoServicio());
			storeFactura.setDescripcion(factura.getDescripcion());
			storeFactura.setEstado(factura.getEstado());
			storeFactura.setFechaEmision(factura.getFechaEmision());
			storeFactura.setFechaVencimiento(factura.getFechaVencimiento());
			storeFactura.setNunFactura(factura.getNunFactura());
			storeFactura.setPeriodoDetraccion(factura.getPeriodoDetraccion());
			storeFactura.setPorcentajeDetraccion(factura.getPorcentajeDetraccion());
			storeFactura.setSubtotal(factura.getSubtotal());
			storeFactura.setTipoMoneda(factura.getTipoMoneda());
			storeFactura.setTotal(factura.getTotal());
			facturaService.update(storeFactura);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<Factura>(storeFactura, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Factura>(storeFactura, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Permite eliminar facturas en el sistema BPZ.", response = Iterable.class)
	@DeleteMapping(value = "/{id:\\d+}")
	public ResponseEntity<String> deleteFactura(@PathVariable Integer id) {
		try {
			facturaService.deleteById(id);
		} catch (Exception e) {
			return new ResponseEntity<String>("Factura no encontrada", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>("Factura eliminada satisfactoriamente", HttpStatus.OK);
	}
	
}
