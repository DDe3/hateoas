package com.example.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "cuenta_bancaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cuba")
	@SequenceGenerator(name = "seq_cuba", sequenceName = "seq_cuba", allocationSize = 1)
	@Column(name="cuba_id")
	private Integer id;
	@Column(name="cuba_nombre")
	private String nombre;
	@Column(name="cuba_saldo")
	private BigDecimal saldo;
	
	
	@ManyToOne
	@JoinColumn(name = "cuha_id")
	private CuentaHabiente cuentaHabiente;
	
	
	
	public CuentaHabiente getCuentaHabiente() {
		return cuentaHabiente;
	}
	public void setCuentaHabiente(CuentaHabiente cuentaHabiente) {
		this.cuentaHabiente = cuentaHabiente;
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
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	
}
