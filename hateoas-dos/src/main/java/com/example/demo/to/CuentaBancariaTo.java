package com.example.demo.to;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.modelo.CuentaHabiente;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CuentaBancariaTo extends RepresentationModel<CuentaBancariaTo> implements Serializable {
	
	private Integer id;
	private String nombre;
	private BigDecimal saldo;
	@JsonIgnore
	private CuentaHabienteTo cuentaHabiente;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public CuentaHabienteTo getCuentaHabiente() {
		return cuentaHabiente;
	}
	public void setCuentaHabiente(CuentaHabienteTo cuentaHabiente) {
		this.cuentaHabiente = cuentaHabiente;
	}
	
	
	
	

}
