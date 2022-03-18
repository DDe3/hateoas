package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.demo.service.CuentaHabienteServiceImpl;
import com.example.demo.to.CuentaBancariaTo;
import com.example.demo.to.CuentaHabienteTo;

@RestController
@RequestMapping("/Api/V1/cuentaHabientes")
public class CuentaBancariaRestController {
	
	@Autowired
	private CuentaHabienteServiceImpl cbs;
	
	/*
	public ResponseEntity<List<CuentaHabienteTo>> consultarTodos() {
		return ResponseEntity.ok(cbs.getAllCuentaHabiente());
	}
	*/
	
	@GetMapping()
	public List<CuentaHabienteTo> consultarTodos() {
		List<CuentaHabienteTo> chtos = cbs.getAllCuentaHabiente();
		chtos.forEach( ch -> {
			Link link = linkTo(methodOn(CuentaBancariaRestController.class).consultarCuentaHabiente(ch.getId())).withRel("cuentaHabiente");
			ch.add(link);
			ch.getCuentas().forEach(cb -> {
				Link linkCB = linkTo(methodOn(CuentaBancariaRestController.class).consultarCuentaBancaria(ch.getId(), cb.getId())).withRel("cuentaBancaria");
				cb.add(linkCB);
			});
			
		});
		return chtos;
	}
	
	@GetMapping("/{idHabiente}")
	public CuentaHabienteTo consultarCuentaHabiente(@PathVariable(name = "idHabiente")Integer idHabiente) {
		CuentaHabienteTo cb = cbs.getCuentaHabiente(idHabiente);
		Link link = linkTo(methodOn(CuentaBancariaRestController.class).consultarCuentaHabiente(cb.getId())).withRel("cuentaHabiente");
		cb.add(link);
		return cb;
	}
	
	@GetMapping("/{idHabiente}/cuentasBancarias/{idCuenta}")
	public CuentaBancariaTo consultarCuentaBancaria(@PathVariable(name = "idHabiente")Integer idHabiente, @PathVariable(name = "idCuenta")Integer idCuenta) {
		return cbs.getCuentaBancaria(idCuenta);
	}

}
