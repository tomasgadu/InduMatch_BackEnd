package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class LineaModeloEntidad {
	
	private UUID id;
	private MarcaFabricanteEntidad marcaFabricante;
	private String nombre;
	
	public LineaModeloEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setMarcaFabricante(new MarcaFabricanteEntidad());
		setNombre(UtilTexto.VACIO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public MarcaFabricanteEntidad getMarcaFabricante() {
		return marcaFabricante;
	}
	
	public void setMarcaFabricante(MarcaFabricanteEntidad marcaFabricante) {
		this.marcaFabricante = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(marcaFabricante, new MarcaFabricanteEntidad());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
	}
	
}
