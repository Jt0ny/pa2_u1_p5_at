package com.uce.edu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Pa2U1P5AtApplication implements CommandLineRunner{

	public static void main(String[] args)  {
		SpringApplication.run(Pa2U1P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hola mundo");
		System.out.println("Soy Anthony Tipan");
		System.out.println("Cambio en la misma rama");
		
	}

}
