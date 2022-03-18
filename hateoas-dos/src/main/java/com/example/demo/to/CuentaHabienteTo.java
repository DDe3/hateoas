package com.example.demo.to;

import java.io.Serializable;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.example.demo.repository.modelo.CuentaBancaria;

public class CuentaHabienteTo extends RepresentationModel<CuentaHabienteTo> implements Serializable {

	private Integer id;
	private String nombre;
	private String cedula;
	private List<CuentaBancariaTo> cuentas;
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
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public List<CuentaBancariaTo> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<CuentaBancariaTo> cuentas) {
		this.cuentas = cuentas;
	}
	
	
	
}
