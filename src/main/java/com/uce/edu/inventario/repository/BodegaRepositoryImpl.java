package com.uce.edu.inventario.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.inventario.repository.modelo.Bodega;
;

@Repository
public class BodegaRepositoryImpl implements IBodegaRepository{

	private static List<Bodega> base =new ArrayList<Bodega>();
	
	@Override
	public Bodega seleccionar(String codigo) {
		for(Bodega bodega:base) {
			  if (bodega.getCodigo().equals(codigo)) {
				  Bodega bg=new Bodega();
				  bg.setCapacidad(bodega.getCapacidad());
				  bg.setDireccion(bodega.getDireccion());
				  bg.setNombre(bodega.getNombre());
				  bg.setCodigo(bodega.getCodigo());
				return  bg;
				
			  }
			}
		return null;
	}

	public Bodega seleccionarEliminar(String codigo) {	
		for(Bodega bodega:base) {
			  if (bodega.getCodigo().equals(codigo)) {
				  return bodega;
			  }
			}
			return null;
	}


	@Override
	public void insertar(Bodega bodega) {
		base.add(bodega);
		
	}

	@Override
	public void actualizar(Bodega bodega) {
		this.eliminar(bodega.getCodigo());
		this.insertar(bodega);
		
	}

	@Override
	public void eliminar(String codigo) {
		Bodega bodega= this.seleccionarEliminar(codigo);
		base.remove(bodega);		
	}

}
