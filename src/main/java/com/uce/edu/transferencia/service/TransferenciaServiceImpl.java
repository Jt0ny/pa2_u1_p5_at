package com.uce.edu.transferencia.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.transferencia.repository.ICuentaBancariaRepository;
import com.uce.edu.transferencia.repository.ITransferenciaRepository;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired 
	private ITransferenciaRepository iTransferenciaRepository;
	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Override
	public Transferencia buscar(String numero) {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionar(numero);
	}

	@Override
	public void guardar(Transferencia transferencia) {
		this.iTransferenciaRepository.insertar(transferencia);
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.iTransferenciaRepository.actualizar(transferencia);
			}

	@Override
	public void eliminar(String numero) {
	this.iTransferenciaRepository.eliminar(numero);
		
	}

	@Override
	public void realizar(String numeroOrigen,String numeroDestino, BigDecimal monto) {
		// 1. buscar cta origen
		
		CuentaBancaria bancaria= this.bancariaRepository.seleccionar(numeroOrigen);
		
		//2. consultar el saldo 
		
		//3.validar cuenta 
		
		//4.restar monto 
		
		//5. actualizar cta origen 
		
		
		//6.buscar cta destino
		
		
		//7.consultar saldo
		
		//8. sumar monto
		
		//9.actualizar cta destino
		
		//10.crear transferencia 
	}

}
