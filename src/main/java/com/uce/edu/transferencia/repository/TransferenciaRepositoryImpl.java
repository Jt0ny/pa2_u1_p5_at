package com.uce.edu.transferencia.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;

@Repository
public class TransferenciaRepositoryImpl implements ITransferenciaRepository {

	private static List<Transferencia> base =new ArrayList<>();
	
	
	@Override
	public Transferencia seleccionar(String numero) {
		
		for(Transferencia cuenta:base) {
		  if (cuenta.getNumero().equals(numero)) {
			 return cuenta; 
		  }
		}
		return null;
	}

	@Override
	public void insertar(Transferencia transferencia) {
		base.add(transferencia);
		
		
	}

	@Override
	public void actualizar(Transferencia transferencia) {
		this.eliminar(transferencia.getNumero());
		this.insertar(transferencia);
	}

	@Override
	public void eliminar(String numero) {
		Transferencia transferencia= this.seleccionar(numero);
		base.remove(transferencia);
		
		
	}

}
