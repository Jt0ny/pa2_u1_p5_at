package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;

@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public CuentaBancaria buscar(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.insertar(cuentaBancaria);
		
	}

	@Override
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.bancariaRepository.actualizar(cuentaBancaria);
		
	}

	@Override
	public void eliminar(String numero) {
		this.bancariaRepository.eliminar(numero);
		
	}

	@Override
	public void depositar(String numDestino, BigDecimal monto) {
		CuentaBancaria ctaDestino = this.bancariaRepository.seleccionar(numDestino);
		BigDecimal resta= monto.multiply(new BigDecimal(0.9));
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(resta));
		this.bancariaRepository.actualizar(ctaDestino);
	
		
	}

}
