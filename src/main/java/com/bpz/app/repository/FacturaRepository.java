package com.bpz.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bpz.app.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer>{

	@Query("select f from Factura f where f.estado like 'Por Pagar'")
	public List<Factura> findByEstado();
}
