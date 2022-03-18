package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.CuentaBancaria;
import com.example.demo.repository.modelo.CuentaHabiente;

@Repository
@Transactional
public class CuentaHabienteRepoImpl {

	@PersistenceContext
	private EntityManager em;

	public CuentaHabiente getCuentaHabiente(Integer id) {
		return em.find(CuentaHabiente.class, id);
	}
	
	public CuentaBancaria getCuentaBancaria(Integer id) {
		return em.find(CuentaBancaria.class, id);
	}

	public List<CuentaHabiente> getAllCuentaHabiente() {
		TypedQuery<CuentaHabiente> mq = em.createQuery("SELECT ch FROM CuentaHabiente ch",CuentaHabiente.class);
		return mq.getResultList();
	}

}
