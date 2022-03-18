package com.example.demo.repository.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_habiente")
public class CuentaHabiente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuha")
	@SequenceGenerator(name = "seq_cuha", sequenceName = "seq_cuha", allocationSize = 1)
	@Column(name="cuha_id")
	private Integer id;
	@Column(name="cuha_nombre")
	private String nombre;
	@Column(name="cuha_cedula")
	private String cedula;
	
	@OneToMany(mappedBy = "cuentaHabiente", cascade = CascadeType.ALL)
	private List<CuentaBancaria> cuentas;
	
	
	
	
	public List<CuentaBancaria> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}
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
	
	

}
