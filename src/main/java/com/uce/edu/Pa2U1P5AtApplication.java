package com.uce.edu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;
import com.uce.edu.repository.modelo.Materia;
import com.uce.edu.service.IMateriaService;
import com.uce.edu.transferencia.repository.modelo.CuentaBancaria;
import com.uce.edu.transferencia.repository.modelo.Transferencia;
import com.uce.edu.transferencia.service.ICuentaBancariaService;
import com.uce.edu.transferencia.service.ITransferenciaService;

@SpringBootApplication
public class Pa2U1P5AtApplication implements CommandLineRunner{
	

	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	
	
	
	public static void main(String[] args)  {
		SpringApplication.run(Pa2U1P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//1.Crear cuentas
		
		CuentaBancaria ctaOrigen= new CuentaBancaria();
		ctaOrigen.setCedulaPropietario("1726");
		ctaOrigen.setNumero("1234");
		ctaOrigen.setSaldo(new BigDecimal(100));
		this.bancariaService.guardar(ctaOrigen);
		
		CuentaBancaria ctaDestino= new CuentaBancaria();
		ctaDestino.setCedulaPropietario("1725");
		ctaDestino.setNumero("12345");
		ctaDestino.setSaldo(new BigDecimal(200));
		this.bancariaService.guardar(ctaDestino);
		this.iTransferenciaService.realizar("1234", "12345", new BigDecimal(20));
		
		
//		
		this.iTransferenciaService.realizar("1234", "12345", new BigDecimal(30));
		this.iTransferenciaService.realizar("12345", "1234", new BigDecimal(20));
		
//		Construir un reporte del estado de cuenta de todas las transferencias
		
		List<Transferencia> lista= this.iTransferenciaService.buscarTodos();
		int i =0;
		for(Transferencia trans:lista) {
			i++;
			System.out.println(i+":"+trans);
		}
		
	
		
		
		
		
	
	}

}
