package com.bpz.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpz.app.entity.Factura;
import com.bpz.app.repository.FacturaRepository;

@Service
public class FacturaService implements IFacturaService {

	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	public List<Factura> findAll() {
		// TODO Auto-generated method stub
		return facturaRepository.findAll();
	}

	@Override
	public Factura findById(Integer id) {
		// TODO Auto-generated method stub
		return facturaRepository.findById(id).orElse(null);
	}

	@Override
	public Factura save(Factura t) {
		// TODO Auto-generated method stub
		return facturaRepository.save(t);
	}

	@Override
	public void update(Factura t) {
		// TODO Auto-generated method stub
		facturaRepository.save(t);
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		facturaRepository.deleteById(id);
		
	}

	@Override
	public List<Factura> findByEstado() {
		// TODO Auto-generated method stub
		return facturaRepository.findByEstado();
	}

	
}
