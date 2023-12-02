package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Inventario;
import com.uce.edu.inventario.repository.modelo.Producto;

@Repository
public class ProductoRepositoryImpl implements IProductoRepository{

	private static List<Producto> base =new ArrayList<Producto>();
	
	@Override
	public Producto seleccionar(String codigoBarras) {
		for(Producto producto:base) {
			  if (producto.getCodigoBarras().equals(codigoBarras)) {
				  Producto pro=new Producto();
				  pro.setCodigoBarras(producto.getCodigoBarras());
				  pro.setNombre(producto.getNombre());
				  pro.setStock(producto.getStock());
				return  pro;
				
			  }
			}
		return null;
	}

	public Producto seleccionarEliminar(String codigoBarras) {	
		for(Producto producto:base) {
			  if (producto.getCodigoBarras().equals(codigoBarras)) {
				  return producto;
			  }
			}
			return null;
	}
	
	@Override
	public void insertar(Producto producto) {
		base.add(producto);
		
	}

	@Override
	public void actualizar(Producto producto) {
		this.eliminar(producto.getCodigoBarras());
		this.insertar(producto);
		
	}

	@Override
	public void eliminar(String codigoBarras) {
		Producto producto = this.seleccionarEliminar(codigoBarras);
		base.remove(producto);
		
	}

}
