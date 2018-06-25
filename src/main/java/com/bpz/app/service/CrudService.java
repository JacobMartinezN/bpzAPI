package com.bpz.app.service;

import java.util.List;

import com.bpz.app.entity.Factura;

public interface CrudService<T> {
	
	List<T> findAll();

	T findById(Integer id);

	T save(T t);

	void update(T t);

	void deleteById(Integer id);
	
	public List<Factura> findByEstado();
}
