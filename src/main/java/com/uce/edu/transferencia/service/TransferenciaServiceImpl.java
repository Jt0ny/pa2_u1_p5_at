package com.uce.edu.transferencia.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
		
		List<Transferencia> listaTrans= new ArrayList<>();
		
		// 1. buscar cta origen
		
		CuentaBancaria ctaOrigen= this.bancariaRepository.seleccionar(numeroOrigen);
		System.out.println(ctaOrigen);
		//2. consultar el saldo 
		
		BigDecimal saldoOrigen= ctaOrigen.getSaldo();		
		//3.validar cuenta 
		
		if(saldoOrigen.compareTo(monto)>=0){
			
			//4.restar monto 
			
			BigDecimal nuevoSaldoOrigen=saldoOrigen.subtract(monto);
			
			//5. actualizar cta origen 
			
			ctaOrigen.setSaldo(nuevoSaldoOrigen);
			this.bancariaRepository.actualizar(ctaOrigen);
			
			//6.buscar cta destino
			
			CuentaBancaria ctaDestino=this.bancariaRepository.seleccionar(numeroDestino);
			System.out.println(ctaDestino);
			
			//7.consultar saldo
			
			BigDecimal saldoDestino= ctaDestino.getSaldo();
			
			//8. sumar monto
			
			BigDecimal nuevoSaldoDestino=saldoDestino.add(monto);
			
			//9.actualizar cta destino
			
			ctaDestino.setSaldo(nuevoSaldoDestino);
			this.bancariaRepository.actualizar(ctaDestino);
			
			//10.crear transferencia 
			
			Transferencia transferencia =new Transferencia();
			transferencia.setCuentaOrigen(ctaOrigen);
			transferencia.setCuentaDestino(ctaDestino);
			transferencia.setFecha(LocalDateTime.now());
			transferencia.setMonto(monto);
			
			Integer i=0;
			for(Transferencia trans:listaTrans) {
				i++;
				transferencia.setNumero(i.toString());
			}
		
			//transferencia.setNumero("1");
			this.iTransferenciaRepository.insertar(transferencia);
			listaTrans.add(transferencia);
			System.out.println("Transferencia realizada con exito");
		
			
		}else {
			System.out.println("Saldo no disponible");
		}
		
	}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iTransferenciaRepository.seleccionarTodos();
	}

}
