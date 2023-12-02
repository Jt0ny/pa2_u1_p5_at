package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;
import com.uce.edu.inventario.repository.modelo.Inventario;

@Repository
public class InventarioRepositoryImpl implements IInventarioRepository{

	private static List<Inventario> base =new ArrayList<Inventario>();
	
	
	@Override
	public Inventario seleccionar(String codigo) {
		for(Inventario inventario:base) {
			  if (inventario.getCodigo().equals(codigo)) {
				  Inventario in=new Inventario();
				  in.setBodega(inventario.getBodega());
				  in.setCodigo(inventario.getCodigo());
				  in.setFechaIngreso(inventario.getFechaIngreso());
				  in.setProducto(inventario.getProducto());
				return  in;
				
			  }
			}
		return null;
	}
	
	public Inventario seleccionarEliminar(String codigo) {	
		for(Inventario inventario:base) {
			  if (inventario.getCodigo().equals(codigo)) {
				  return inventario;
			  }
			}
			return null;
	}

	@Override
	public void insertar(Inventario inventario) {
		base.add(inventario);
		
	}

	@Override
	public void actualizar(Inventario inventario) {
		this.eliminar(inventario.getCodigo());
		this.insertar(inventario);
		
	}

	@Override
	public void eliminar(String codigo) {
		Inventario inventario= this.seleccionarEliminar(codigo);
		base.remove(inventario);
		
	}

}
