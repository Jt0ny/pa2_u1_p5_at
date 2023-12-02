package com.uce.edu;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;
import com.uce.edu.inventario.service.IBodegaService;
import com.uce.edu.inventario.service.IInventarioService;
import com.uce.edu.inventario.service.IProductoService;

@SpringBootApplication
public class Pa2U1P5AtApplication implements CommandLineRunner{
	
	 @Autowired
	 private IProductoService iProductoService;
	 
	 @Autowired
	 private IBodegaService bodegaService;
	 
	 @Autowired
	 private IInventarioService iInventarioService;
	 
	 public static void main(String[] args) {
		SpringApplication.run(Pa2U1P5AtApplication.class,args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Producto p1= new Producto();
		p1.setCodigoBarras("123");
		p1.setNombre("HP azul");
		p1.setStock(0);
		this.iProductoService.guardar(p1);
		
		Producto p2= new Producto();
		p2.setCodigoBarras("456");
		p2.setNombre("Teclado hp");
		p2.setStock(0);
		this.iProductoService.guardar(p2);
		
		Bodega bodega = new Bodega();
		bodega.setCapacidad(10);
		bodega.setCodigo("777");
		bodega.setDireccion("Sangolqui");
		bodega.setNombre("Tu bodega fav");
		this.bodegaService.guardar(bodega);
		
	
		this.iInventarioService.registar("777", "123", 50);
		this.iInventarioService.registar("777", "456", 100);
		this.iInventarioService.registar("777", "123", 20);
		
		Producto p11= this.iProductoService.buscar("123");
		System.out.println("Producto 1: "+p11.getStock());
		
		Producto p22= this.iProductoService.buscar("456");
		System.out.println("Producto 2: "+p22.getStock());
		

		 
		
	
	}

}
