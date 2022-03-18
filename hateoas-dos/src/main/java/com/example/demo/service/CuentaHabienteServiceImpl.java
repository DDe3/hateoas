package com.example.demo.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CuentaHabienteRepoImpl;
import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.CuentaHabiente;
import com.example.demo.to.CuentaBancariaTo;
import com.example.demo.to.CuentaHabienteTo;

@Service
public class CuentaHabienteServiceImpl {
	
	@Autowired
	private CuentaHabienteRepoImpl repo;
	
	
	public CuentaHabienteTo getCuentaHabiente(Integer id) {
		return convertirCuentaHabiente(repo.getCuentaHabiente(id));
	}
	
	public CuentaBancariaTo getCuentaBancaria(Integer id) {
		CuentaBancaria cb = repo.getCuentaBancaria(id);
		return convertirCuentaBancaria(cb, convertirCuentaHabiente(cb.getCuentaHabiente()));
	}

	public List<CuentaHabienteTo> getAllCuentaHabiente() {
		List<CuentaHabiente> cuentaHabientes = repo.getAllCuentaHabiente();
		return cuentaHabientes.stream().map(cb -> convertirCuentaHabiente(cb)).collect(Collectors.toList());
	}
	
	private CuentaHabienteTo convertirCuentaHabiente(CuentaHabiente cb) {
		CuentaHabienteTo cbto = new CuentaHabienteTo();
		cbto.setCedula(cb.getCedula());
		cbto.setId(cb.getId());
		cbto.setNombre(cb.getNombre());
		cbto.setCuentas(convertirListaCuentaBancaria(cb.getCuentas(),cbto));
		return cbto;
	}
	
	private List<CuentaBancariaTo> convertirListaCuentaBancaria(List<CuentaBancaria> cuentasBancarias, CuentaHabienteTo chto) {
		return cuentasBancarias.stream().map(cb -> convertirCuentaBancaria(cb, chto)).collect(Collectors.toList());
	}
	
	private CuentaBancariaTo convertirCuentaBancaria(CuentaBancaria cb, CuentaHabienteTo chto) {
		CuentaBancariaTo cbto = new CuentaBancariaTo();
		cbto.setId(cb.getId());
		cbto.setNombre(cb.getNombre());
		cbto.setSaldo(cb.getSaldo());
		cbto.setCuentaHabiente(chto);
		return cbto;
	}

}
