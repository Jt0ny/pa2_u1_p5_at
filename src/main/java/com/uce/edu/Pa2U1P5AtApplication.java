package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ioc.di.Estudiante;

@SpringBootApplication
public class Pa2U1P5AtApplication implements CommandLineRunner{
	
	@Autowired
	private Estudiante estudiante;
	
	public static void main(String[] args)  {
		SpringApplication.run(Pa2U1P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.estudiante.setApellido("Tipan");
		this.estudiante.setNombre("Anthony");
		this.estudiante.setCedula("123465");
		this.estudiante.setSalario(new BigDecimal(400));
		System.out.println(estudiante);
		
		
		
	}

}
