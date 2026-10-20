package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class DepartamentoEntidad {
	
	private UUID id;
	private String nombre;
	private PaisEntidad pais;
	
	public DepartamentoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNombre(UtilTexto.VACIO);
		setPais(new PaisEntidad());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
	}
	
	public PaisEntidad getPais() {
		return pais;
	}
	
	public void setPais(PaisEntidad pais) {
		this.pais = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pais, new PaisEntidad());
	}
	
}
