package com.bpz.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Factura {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	private Integer codigoServicio;
	
	@NotNull
	private String nunFactura;
	
	@NotNull
	private String estado;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fechaEmision;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date fechaVencimiento;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date periodoDetraccion;
	
	@NotNull
	private String descripcion;
	
	@NotNull
	private Integer tipoMoneda;
	
	@NotNull
	private double subtotal;
	
	@NotNull
	private double total;
	
	@NotNull
	private double porcentajeDetraccion;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigoServicio() {
		return codigoServicio;
	}

	public void setCodigoServicio(Integer codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

	public String getNunFactura() {
		return nunFactura;
	}

	public void setNunFactura(String nunFactura) {
		this.nunFactura = nunFactura;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getPeriodoDetraccion() {
		return periodoDetraccion;
	}

	public void setPeriodoDetraccion(Date periodoDetraccion) {
		this.periodoDetraccion = periodoDetraccion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(Integer tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getPorcentajeDetraccion() {
		return porcentajeDetraccion;
	}

	public void setPorcentajeDetraccion(double porcentajeDetraccion) {
		this.porcentajeDetraccion = porcentajeDetraccion;
	}
	
	
	
}
